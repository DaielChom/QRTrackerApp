package daielchom.qrtracker;

import android.util.Log;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by daielchom on 7/07/17.
 */

public interface QRTrackerService {

    @GET("funcionarios/{id_official}")
    Call<official> getOfficialAPI(@Path("id_official") String id_official);
}
