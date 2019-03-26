package edu.cnm.deepdive.escaperoom.service;

import android.arch.persistence.room.Query;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.escaperoom.EscapeRoomApplication;
import edu.cnm.deepdive.escaperoom.R;
import edu.cnm.deepdive.escaperoom.model.Weather;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface EscapeRoomWebService {

  @GET()
  Call<Weather> get(@Query("api_key") String apiKey);

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
}
