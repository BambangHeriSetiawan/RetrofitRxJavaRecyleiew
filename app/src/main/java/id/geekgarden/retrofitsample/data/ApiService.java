package id.geekgarden.retrofitsample.data;

/**
 * Created by GeekGarden on 25/07/2017.
 */

public class ApiService {
  public final static String BASE_URL = "https://reqres.in/";
public static Api getervice(){
  return ApiClient.getClient(BASE_URL).create(Api.class);
}
}
