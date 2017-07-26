package id.geekgarden.retrofitsample;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.geekgarden.retrofitsample.adapter.DataAdapter;
import id.geekgarden.retrofitsample.adapter.ListviewAdapter;
import id.geekgarden.retrofitsample.data.Api;
import id.geekgarden.retrofitsample.data.ApiService;
import id.geekgarden.retrofitsample.model.DataItem;

import id.geekgarden.retrofitsample.model.ResponseUsers;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitListviewActivity extends AppCompatActivity {
  private ActionBar actionBar;
  private Api mApi;
  private DataAdapter dataAdapter;
  private List<DataItem> mData;
  @BindView(R.id.rcvData)RecyclerView rcvData;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_retrofit_listview);
    ButterKnife.bind(this);
    initActionbar();
    mApi = ApiService.getervice();
    dataAdapter = new DataAdapter(this,new ArrayList<DataItem>(0),
        new DataAdapter.PostItemListener() {
          @Override
          public void onPostClick(long id) {
            Toast.makeText(RetrofitListviewActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
          }
        });
    rcvData.setHasFixedSize(true);
    rcvData.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    rcvData.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
    rcvData.setAdapter(dataAdapter);
    loadData();

  }


  private void loadData() {

    Observable<ResponseUsers> responseUsersObservable = mApi.getDataUsers().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    responseUsersObservable.subscribe(new Observer<ResponseUsers>() {
      @Override
      public void onCompleted() {

      }

      @Override
      public void onError(Throwable e) {
        Log.e("onError", "RetrofitListviewActivity" + e.getMessage());
      }

      @Override
      public void onNext(ResponseUsers responseUsers) {
        dataAdapter.updateUsers(responseUsers.getData());
      }
    });

  }

  private void initActionbar() {
    actionBar = getSupportActionBar();
    actionBar.setDisplayHomeAsUpEnabled(true);
    actionBar.setHomeButtonEnabled(true);
    actionBar.setTitle("RetrofitListviewActivity");

  }

  @Override
  protected void onDestroy() {

    super.onDestroy();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home){
      onBackPressed();
    }
    return super.onOptionsItemSelected(item);
  }
}
