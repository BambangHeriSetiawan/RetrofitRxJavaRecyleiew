package id.geekgarden.retrofitsample.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import id.geekgarden.retrofitsample.R;
import id.geekgarden.retrofitsample.model.DataItem;
import id.geekgarden.retrofitsample.model.ResponseData;
import java.util.List;

/**
 * Created by GeekGarden on 25/07/2017.
 */

public class ListviewAdapter extends ArrayAdapter<ResponseData> {
  private Context mContext;
  List<ResponseData>mData;

  public ListviewAdapter(@NonNull Context context, @LayoutRes int resource,
      @NonNull List<ResponseData> objects, Context mContext) {
    super(context, resource, objects);
    this.mContext = mContext;
    this.mData = objects;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = inflater.inflate(R.layout.item_list,parent,false);
    ResponseData dataItem = getItem(position);
    TextView tv01  = view.findViewById(R.id.tv1);
    TextView tv02  = view.findViewById(R.id.tv2);
    tv01.setText(dataItem.getTitle());
    tv02.setText(dataItem.getBody());

    return view;

  }
}
