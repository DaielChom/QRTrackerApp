package daielchom.qrtracker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by daielchom on 13/07/17.
 */

public class paqueteList {

    @SerializedName("list")
    @Expose
    private ArrayList<paquete> list = new ArrayList<>();

    public ArrayList<paquete> getPaqueteList() {
        return list;
    }

    public void setPaqueteList(ArrayList<paquete> paqueteList) {
        this.list = paqueteList;
    }
}
