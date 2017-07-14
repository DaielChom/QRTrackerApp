package daielchom.qrtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

    private ListView listPackage;
    private View view;
    private packageAdapter adapter;

    public fragmentList(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        view = inflater.inflate(R.layout.fragment_list, container, false);
        listPackage = (ListView) view.findViewById(R.id.listPackage);


        QRTrackerService api = retrofitClient.getClient().create(QRTrackerService.class);
        Map<String, String> options = new HashMap<>();
        options.put("state","BodegaANDRecogido");

        Call<paqueteList> call = api.getPackage(options);
        Log.d("SS",call.request().toString());
        call.enqueue(new Callback<paqueteList>(){

            @Override
            public void onResponse(Call<paqueteList> call, Response<paqueteList> response) {
                adapter = new packageAdapter(getContext(),response.body().getPaqueteList());
                listPackage.setAdapter(adapter);





            }

            @Override
            public void onFailure(Call<paqueteList> call, Throwable t) {

                //Toast.makeText(fragmentList.this,"Error", Toast.LENGTH_SHORT).show();
                Log.d("x",t.toString());
            }
        });
        return view;
    }
}
