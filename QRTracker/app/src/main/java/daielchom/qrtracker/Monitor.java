package daielchom.qrtracker;

/**
 * Created by daielchom on 20/07/17.
 */

public class Monitor {
    private String id_monitor;
    private String id_package;
    private String official;
    private String long_monitor;
    private String lati_monitor;
    private String alti_monitor;
    private String hour_monitor;
    private String date_monitor;

    public Monitor() {
    }

    public Monitor(String id_monitor, String id_package, String official, String long_monitor, String lati_monitor, String alti_monitor, String hour_monitor, String date_monitor) {
        this.id_monitor = id_monitor;
        this.id_package = id_package;
        this.official = official;
        this.long_monitor = long_monitor;
        this.lati_monitor = lati_monitor;
        this.alti_monitor = alti_monitor;
        this.hour_monitor = hour_monitor;
        this.date_monitor = date_monitor;
    }

    public String getId_monitor() {
        return id_monitor;
    }

    public void setId_monitor(String id_monitor) {
        this.id_monitor = id_monitor;
    }

    public String getId_package() {
        return id_package;
    }

    public void setId_package(String id_package) {
        this.id_package = id_package;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    public String getLong_monitor() {
        return long_monitor;
    }

    public void setLong_monitor(String long_monitor) {
        this.long_monitor = long_monitor;
    }

    public String getLati_monitor() {
        return lati_monitor;
    }

    public void setLati_monitor(String lati_monitor) {
        this.lati_monitor = lati_monitor;
    }

    public String getAlti_monitor() {
        return alti_monitor;
    }

    public void setAlti_monitor(String alti_monitor) {
        this.alti_monitor = alti_monitor;
    }

    public String getHour_monitor() {
        return hour_monitor;
    }

    public void setHour_monitor(String hour_monitor) {
        this.hour_monitor = hour_monitor;
    }

    public String getDate_monitor() {
        return date_monitor;
    }

    public void setDate_monitor(String date_monitor) {
        this.date_monitor = date_monitor;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "id_monitor='" + id_monitor + '\'' +
                ", id_package='" + id_package + '\'' +
                ", official='" + official + '\'' +
                ", long_monitor='" + long_monitor + '\'' +
                ", lati_monitor='" + lati_monitor + '\'' +
                ", alti_monitor='" + alti_monitor + '\'' +
                ", hour_monitor='" + hour_monitor + '\'' +
                ", date_monitor='" + date_monitor + '\'' +
                '}';
    }
}
