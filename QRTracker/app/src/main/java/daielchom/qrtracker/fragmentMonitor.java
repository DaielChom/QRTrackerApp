package daielchom.qrtracker;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.LOCATION_SERVICE;


/**
 * Created by daielchom on 8/07/17.
 */

public class fragmentMonitor extends Fragment implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static final int PETICION_PERMISO_LOCALIZACION = 0;
    private TextView txIDPaquete;
    private TextView txIDOfficial;
    private TextView txHour;
    private TextView txDate;
    private TextView txLong;
    private TextView txLat;
    private TextView txAlt;
    private Spinner cbState;
    private Button btSend;
    GoogleApiClient apiClient;


    private View view;

    public fragmentMonitor() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_monitor, container, false);

        // Inicilizate GUI elements
        txIDPaquete = (TextView) view.findViewById(R.id.tx_monitor_id_package);
        txIDOfficial = (TextView) view.findViewById(R.id.tx_monitor_id_official);
        txHour = (TextView) view.findViewById(R.id.tx_monitor_hour_monitor);
        txDate = (TextView) view.findViewById(R.id.tx_monitor_date);
        txLong = (TextView) view.findViewById(R.id.tx_monitor_long);
        txAlt = (TextView) view.findViewById(R.id.tx_monitor_Alt);
        txLat = (TextView) view.findViewById(R.id.tx_monitor_Lat);
        cbState = (Spinner) view.findViewById(R.id.cb_monitor_state_package);
        btSend = (Button) view.findViewById(R.id.bt_monitor);


        // Data
        String id_official = getArguments().getString("official");
        String id_paquete = getArguments().getString("id_paquete");

        // Data time
        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//formating according to my need
        SimpleDateFormat formatterhour = new SimpleDateFormat("hh.mm.ss");
        String date_monitor = formatter.format(today);
        String hour_monitor = formatterhour.format(today);

        //Data GPS
        apiClient = new GoogleApiClient.Builder(getActivity()).enableAutoManage(getActivity(), this).addConnectionCallbacks(this).addApi(LocationServices.API).build();


        //.enableAutoManage(getActivity(),)
        //.addConnectionCallbacks(getActivity())
        //.addApi(Drive.API)
        //.build();

        //updateUI(loc);


        //Data state
        final List<String> state = new ArrayList<String>();
        state.add("");
        state.add("Bodega");
        state.add("Recogido");
        state.add("Entregado");
        state.add("Devuelto");
        ArrayAdapter<String> state_monitor = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, state);


        if (id_paquete != null) {
            txIDPaquete.setText(id_paquete);
            txIDOfficial.setText(id_official);
            txDate.setText(date_monitor);
            txHour.setText(hour_monitor);
            // txLong.setText(String.valueOf(long_monitor));
            cbState.setAdapter(state_monitor);

            QRTrackerService apiServices = retrofitClient.getClient().create(QRTrackerService.class);
            Call<paquete> call = apiServices.getPackage(id_paquete);
            call.enqueue(new Callback<paquete>() {
                @Override
                public void onResponse(Call<paquete> call, Response<paquete> response) {
                    if (response.body().getId_package() != null) {

                        cbState.setSelection(state.indexOf(response.body().getEstate_package()));

                    } else {
                        Toast.makeText(getContext(), "Paquete no existe", Toast.LENGTH_SHORT).show();
                    }


                }

                @Override
                public void onFailure(Call<paquete> call, Throwable t) {

                    Toast.makeText(getContext(), "Error ", Toast.LENGTH_SHORT).show();
                }
            });


        } else {

            txIDOfficial.setText(id_official);
            txIDPaquete.setText("READ QR");
            txDate.setText("DATE");
            txHour.setText("HOUR");
            // txLong.setText(String.valueOf(long_monitor));
            cbState.setAdapter(state_monitor);


        }
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txIDPaquete.getText().toString().equals("READ QR")) {
                    Toast.makeText(getContext(), "Por favor realice la lectira del QR", Toast.LENGTH_SHORT).show();
                } else {

                    QRTrackerService apiServices = retrofitClient.getClient().create(QRTrackerService.class);

                    String id_monitor = txIDPaquete.getText().toString() + txIDOfficial.getText().toString() + txHour.getText().toString() + txDate.getText().toString();
                    String id_package = txIDPaquete.getText().toString();
                    String official = txIDOfficial.getText().toString();
                    String lati_monitor = txLat.getText().toString();
                    String long_monitor = txLong.getText().toString();
                    String alti_monitor = txAlt.getText().toString();
                    String hour_monitor = txHour.getText().toString();
                    String date_monitor = txDate.getText().toString();

                    Monitor monito = new Monitor(id_monitor, id_package, official, long_monitor, lati_monitor, alti_monitor, hour_monitor, date_monitor);

                    Call<Monitor> call = apiServices.postMonitor(monito);
                    call.enqueue(new Callback<Monitor>() {
                        @Override
                        public void onResponse(Call<Monitor> call, Response<Monitor> response) {
                            if (response.body() != null) {
                                Toast.makeText(getContext(), "Monitoreo Exitoso", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                            }


                        }

                        @Override
                        public void onFailure(Call<Monitor> call, Throwable t) {

                            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    });


                }


            }
        });


        return view;

    }

    private void updateUI(Location loc) {
        if (loc != null) {
            txLat.setText(String.valueOf(loc.getLatitude()));
            txLong.setText(String.valueOf(loc.getLongitude()));
            txAlt.setText(String.valueOf(loc.getAltitude()));
        } else {
            txLat.setText("Desconocida");
            txLong.setText("Desconocida");
            txAlt.setText("Desconocida");
        }
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PETICION_PERMISO_LOCALIZACION);
        }
        else{
              Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(apiClient);
          updateUI(lastLocation);}


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e("LOGTAG", "Error grave al conectar con Google Play Services");
    }


       @Override
       public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
           if (requestCode == PETICION_PERMISO_LOCALIZACION) {
               if (grantResults.length == 1
                   && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                   //Permiso concedido

                   @SuppressWarnings("MissingPermission")
                   Location lastLocation =
                       LocationServices.FusedLocationApi.getLastLocation(apiClient);

                   updateUI(lastLocation);

               } else {
                   //Permiso denegado:
                   //Deberíamos deshabilitar toda la funcionalidad relativa a la localización.

                   Log.e("LOGTAG", "Permiso denegado");
               }}}     }