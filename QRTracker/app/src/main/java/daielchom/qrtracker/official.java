package daielchom.qrtracker;

/**
 * Created by daielchom on 7/07/17.
 */

public class official {
    private String id_official;
    private String name_official;

    public official() {}

    public official(String idOfficial, String nameOfficial) {
        this.id_official = idOfficial;
        this.name_official = nameOfficial;
    }

    public String getIdOfficial() {
        return id_official;
    }

    public String getNameOfficial() {
        return name_official;
    }

    public void setIdOfficial(String idOfficial) {
        this.id_official = idOfficial;
    }

    public void setNameOfficial(String nameOfficial) {
        this.name_official = nameOfficial;
    }

    @Override
    public String toString() {
        return "official{" +
                "idOfficial='" + id_official + '\'' +
                ", nameOfficial='" + name_official + '\'' +
                '}';
    }
}
