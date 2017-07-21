package daielchom.qrtracker;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by daielchom on 8/07/17.
 */

public class fragmentQR extends Fragment implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    public Fragment fragmentico = new fragmentMonitor();


    public fragmentQR(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


        mScannerView = new ZXingScannerView(getActivity());
        getActivity().setContentView(mScannerView);
        mScannerView.setResultHandler(new ZXingScannerView.ResultHandler() {
            @Override
            public void handleResult(Result rawResult) {


                mScannerView.removeAllViews();  // here remove all the views, it will make an Activity having no View
                mScannerView.stopCamera();  // then stop the camera
                //setContentView(R.layout.activity_Main);


                //Envia a otro fragmento pero quita la barra de navegacion
               //getFragmentManager().beginTransaction().replace(android.R.id.content, fragmentico).commit();

                Intent i = new Intent(getActivity(), main.class);
                i.putExtra("id_paquete",rawResult.getText() );
                i.putExtra("official",getArguments().getString("official"));
                startActivity(i);



            }
        });
        mScannerView.startCamera();

        return inflater.inflate(R.layout.fragment_qr, container, false);
    }



    @Override
    public void handleResult(Result result) {

    }


}
