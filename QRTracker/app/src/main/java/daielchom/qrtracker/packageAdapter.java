package daielchom.qrtracker;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daielchom on 14/07/17.
 */

public class packageAdapter extends ArrayAdapter<paquete> {

    public packageAdapter(Context context, List<paquete> objects) {
        super(context,0, objects);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.list_package,
                    parent,
                    false);
        }

        TextView id_package = (TextView) convertView.findViewById(R.id.listPackage_ID);
        TextView description_package = (TextView) convertView.findViewById(R.id.listPackage_Description);
        TextView state_package = (TextView) convertView.findViewById(R.id.listPackage_State);

        paquete pack = getItem(position);
        Log.d("sS", pack.getId_package());
        id_package.setText(pack.getId_package());
        description_package.setText(pack.getDescrption_package());
        state_package.setText(pack.getEstate_package());


        return convertView;
    }
}
