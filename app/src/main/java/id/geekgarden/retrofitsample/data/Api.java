package id.geekgarden.retrofitsample.data;



import id.geekgarden.retrofitsample.model.DataItem;
import id.geekgarden.retrofitsample.model.ResponseData;

import id.geekgarden.retrofitsample.model.ResponseUsers;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by GeekGarden on 25/07/2017.
 */

public interface Api {
  @GET("posts")
  Call<ResponseData> getData();

  @GET("/api/users?page=2")
  Observable<ResponseUsers> getDataUsers();
}
