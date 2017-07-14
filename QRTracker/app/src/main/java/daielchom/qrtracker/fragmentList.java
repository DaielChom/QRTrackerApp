package daielchom.qrtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.data;

/**
 * Created by daielchom on 8/07/17.
 */

public class fragmentList extends Fragment {

    public fragmentList(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


        QRTrackerService api = retrofitClient.getClient().create(QRTrackerService.class);
        Map<String, String> options = new HashMap<>();
        options.put("state","BodegaANDRecogido");

        Call<paqueteList> call = api.getPackage(options);
        Log.d("SS",call.request().toString());
        call.enqueue(new Callback<paqueteList>(){

            @Override
            public void onResponse(Call<paqueteList> call, Response<paqueteList> response) {


            Log.d("SS", response.body().getPaqueteList().toString());



            }

            @Override
            public void onFailure(Call<paqueteList> call, Throwable t) {

                //Toast.makeText(fragmentList.this,"Error", Toast.LENGTH_SHORT).show();
                Log.d("x",t.toString());
            }
        });
        return inflater.inflate(R.layout.fragment_list, container, false);
    }
}
