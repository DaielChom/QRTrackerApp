package daielchom.qrtracker;
import android.util.Log;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by daielchom on 8/07/17.
 */

public class retrofitClient {

    private static Retrofit retrofit = null;
    public static final String BASE_URL = "http://10.0.2.2:8008/";

    public static Retrofit getClient() {

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }


}
