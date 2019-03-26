package edu.cnm.deepdive.escaperoom.service;


import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.android.BaseFluentAsyncTask;
import edu.cnm.deepdive.escaperoom.BuildConfig;
import edu.cnm.deepdive.escaperoom.EscapeRoomApplication;
import edu.cnm.deepdive.escaperoom.R;
import edu.cnm.deepdive.escaperoom.model.Weather;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Declares the {@link #get(String, String)} Retrofit service method () for communicating with the
 * EscapeRoom web service, and defines nested classes in support of making these requests and deserializing the JSON data returned.
 */
public interface EscapeRoomWebService {

  /**
   * Constructs and returns a {@link okhttp3.Call} encapsulating a request to the EscapeRoom web
   * service. Note that the implementation of this method is completed by Retrofit.
   *
   * @param apiKey OpenWeather Open API key.
   * @return {@link Call} object.
   */
  @GET("weather")
  Call<Weather> get(@Query("appid") String apiKey, @Query("q") String filter);

  /**
   * Implements the initialization-on-demand holder idiom for a singleton of {@link
   * EscapeRoomWebService}.
   */
  class InstanceHolder {

    private static final EscapeRoomWebService INSTANCE;
    private static final String API_KEY;

    static {
      EscapeRoomApplication application = EscapeRoomApplication.getInstance();
      Gson gson = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .create();
      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(application.getApplicationContext().getString(R.string.base_url))
          .addConverterFactory(GsonConverterFactory.create(gson))
          .build();
      INSTANCE = retrofit.create(EscapeRoomWebService.class);
      API_KEY = BuildConfig.API_KEY;
    }
  }

  /**
   * Encapsulates the request lifecycle for the EscapeRoom web service as a {@link
   * BaseFluentAsyncTask} subclass.
   */
  class GetWeatherTask extends BaseFluentAsyncTask<String, Void, Weather, Weather> {

    @Nullable
    @Override
    protected Weather perform(String... filters) throws TaskException {
      try {
        Response<Weather> response = InstanceHolder.INSTANCE.get(
            InstanceHolder.API_KEY, filters[0]).execute();
        if (!response.isSuccessful()) {
          throw new TaskException();
        }
        return response.body();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

}
