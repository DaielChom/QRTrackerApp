package daielchom.qrtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.support.design.widget.Snackbar;

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

        }

    }

}
