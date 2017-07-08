package daielchom.qrtracker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by daielchom on 8/07/17.
 */

public class fragmentMonitor extends Fragment {

    public fragmentMonitor (){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_monitor, container, false);
    }
}
