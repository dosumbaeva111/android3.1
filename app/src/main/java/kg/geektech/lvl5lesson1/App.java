package kg.geektech.lvl5lesson1;

import android.app.Application;

import kg.geektech.lvl5lesson1.data.remote.FilmApi;
import kg.geektech.lvl5lesson1.data.remote.RetrofitClient;

public class App extends Application {
private RetrofitClient retrofitClient;
public static FilmApi api;
    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideFilmApi();
    }
}
