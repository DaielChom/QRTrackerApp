package daielchom.qrtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.support.design.widget.Snackbar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText txIdOfficial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txIdOfficial = (EditText) findViewById(R.id.txIdOfficial);
    }

    public void ingresar(View view){

        if(TextUtils.isEmpty(txIdOfficial.toString())){
            Snackbar.make(view, "" + "Ingrese un ID", Snackbar.LENGTH_LONG).show();
        }
        else{

            String idOfficial = txIdOfficial.getText().toString();
            QRTrackerService apiServices = retrofitClient.getClient().create(QRTrackerService.class);
            Call<official> call = apiServices.getOfficialAPI(idOfficial);

            call.enqueue(new Callback<official>() {
                @Override
                public void onResponse(Call<official> call, Response<official> response) {
                    if(response.body().getIdOfficial() != null){


                        String s = response.body().getIdOfficial();
                        Intent send_params = new Intent(Login.this, main.class);
                        send_params.putExtra("official", s);
                        startActivityForResult(send_params,0);
                    }else{
                        Toast.makeText(Login.this,"Usuario no existe", Toast.LENGTH_SHORT).show();
                    }



                }

                @Override
                public void onFailure(Call<official> call, Throwable t) {

                    Toast.makeText(Login.this,"Error", Toast.LENGTH_SHORT).show();
                }
            });


        }

    }


}
