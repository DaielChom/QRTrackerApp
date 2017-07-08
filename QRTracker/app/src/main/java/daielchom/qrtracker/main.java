package daielchom.qrtracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;


public class main extends AppCompatActivity {

    private TextView mTextMessage;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment fragment;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_qr:

                    mTextMessage.setText(R.string.title_qr);
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragment = new fragmentQR();
                    fragmentTransaction.replace(R.id.content, fragment).commit();

                    return true;

                case R.id.navigation_monitor:

                    mTextMessage.setText(R.string.title_monitor);
                    FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                    fragment = new fragmentMonitor();
                    fragmentTransaction1.replace(R.id.content, fragment).commit();

                    return true;

                case R.id.navigation_list:
                    mTextMessage.setText(R.string.title_List);
                    FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                    fragment = new fragmentList();
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

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
