package id.geekgarden.retrofitsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.geekgarden.retrofitsample.model.DataItem;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.btnLv) void viewLv(View view){
    Intent i = new Intent(this,RetrofitListviewActivity.class);
    startActivity(i);
  }

}
