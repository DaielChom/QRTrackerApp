package daielchom.qrtracker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by daielchom on 11/07/17.
 */

public class paquete {

    @SerializedName("id_package")
    @Expose
    private String id_package;

    @SerializedName("client")
    @Expose
    private String client;

    @SerializedName("descrption_package")
    @Expose
    private String descrption_package;

    @SerializedName("state_package")
    @Expose
    private String state_package;

    public paquete() {
    }

    public paquete(String id_package, String client, String descrption_package, String estate_package) {



        this.id_package = id_package;
        this.client = client;
        this.descrption_package = descrption_package;
        this.state_package = estate_package;
    }

    public String getId_package() {
        return id_package;
    }

    public void setId_package(String id_package) {
        this.id_package = id_package;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDescrption_package() {
        return descrption_package;
    }

    public void setDescrption_package(String descrption_package) {
        this.descrption_package = descrption_package;
    }

    public String getEstate_package() {
        return state_package;
    }

    public void setEstate_package(String estate_package) {
        this.state_package = estate_package;
    }

    @Override
    public String toString() {
        return "paquete{" +
                "id_package='" + id_package + '\'' +
                ", client='" + client + '\'' +
                ", descrption_package='" + descrption_package + '\'' +
                ", estate_package='" + state_package + '\'' +
                '}';
    }
}
