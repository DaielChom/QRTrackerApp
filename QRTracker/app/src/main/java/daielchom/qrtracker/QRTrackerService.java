package daielchom.qrtracker;

import android.util.Log;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by daielchom on 7/07/17.
 */

public interface QRTrackerService {

    @GET("funcionarios/{id_official}")
    Call<official> getOfficialAPI(@Path("id_official") String id_official);

    @GET("paquetes/list")
    Call <paqueteList> getPackage(@QueryMap Map<String, String> options);

    //@POST("Monitoreos/")
    //Call <monitor> postMonitor();


}
