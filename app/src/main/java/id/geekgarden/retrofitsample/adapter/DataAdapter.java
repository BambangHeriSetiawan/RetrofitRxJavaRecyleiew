package id.geekgarden.retrofitsample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.geekgarden.retrofitsample.R;
import id.geekgarden.retrofitsample.model.DataItem;
import java.util.List;

/**
 * Created by GeekGarden on 26/07/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
  private List<DataItem> mUsers;
  private Context mContext;
  private PostItemListener mItemListener;

  public class ViewHolder extends RecyclerView.ViewHolder{
    PostItemListener mItemListener;
    @BindView(R.id.tv1) TextView tv1;
    @BindView(R.id.tv2) TextView tv2;
    public ViewHolder(View itemView, PostItemListener postItemListener) {
      super(itemView);
      ButterKnife.bind(this,itemView);
      this.mItemListener = postItemListener;
    }


  }

  public DataAdapter(Context context, List<DataItem> posts, PostItemListener postItemListener) {
    mUsers = posts;
    mContext = context;
    mItemListener = postItemListener;

  }

  @Override
  public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    Context context = parent.getContext();
    LayoutInflater inflater = LayoutInflater.from(context);

    View postView = inflater.inflate(R.layout.item_list, parent, false);

    ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
    DataItem users = mUsers.get(position);
    TextView tv1 = holder.tv1;
    TextView tv2 = holder.tv2;
    tv1.setText(users.getFirstName());
    tv2.setText(users.getLastName());

  }

  @Override
  public int getItemCount() {
    return mUsers.size();
  }

  public void updateUsers(List<DataItem> items) {
    mUsers = items;
    notifyDataSetChanged();
  }

  private DataItem getItem(int adapterPosition) {
    return mUsers.get(adapterPosition);
  }

  public interface PostItemListener {
    void onPostClick(long id);
  }
}
