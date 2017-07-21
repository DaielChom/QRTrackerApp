package daielchom.qrtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;


public class main extends AppCompatActivity {

    private TextView mTextMessage;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment fragment;
    private String paquete = "null";
    private Bundle daticos;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_qr:


                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragment = new fragmentQR();
                    fragment.setArguments(daticos);
                    fragmentTransaction.replace(R.id.content, fragment).commit();

                    return true;

                case R.id.navigation_monitor:

                    Bundle datos = new Bundle();
                    datos.putString("official", getIntent().getStringExtra("official"));


                    FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                    fragment = new fragmentMonitor();
                    fragment.setArguments(daticos);
                    fragmentTransaction1.replace(R.id.content, fragment).commit();

                    return true;

                case R.id.navigation_list:

                    FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                    fragment = new fragmentList();
                    fragment.setArguments(daticos);
                    fragmentTransaction2.replace(R.id.content, fragment).commit();

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daticos = new Bundle();
        daticos.putString("official", getIntent().getStringExtra("official"));
        daticos.putString("id_paquete", getIntent().getStringExtra("id_paquete"));

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().getItem(2).setChecked(true);





        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
        fragment = new fragmentMonitor();

        fragment.setArguments(daticos);
        fragmentTransaction2.replace(R.id.content, fragment).commit();

    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }






}
