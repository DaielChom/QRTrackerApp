package daielchom.qrtracker;

/**
 * Created by daielchom on 7/07/17.
 */

public class official {
    private String idOfficial;
    private String nameOfficial;

    public official() {}

    public official(String idOfficial, String nameOfficial) {
        this.idOfficial = idOfficial;
        this.nameOfficial = nameOfficial;
    }

    public String getIdOfficial() {
        return idOfficial;
    }

    public String getNameOfficial() {
        return nameOfficial;
    }

    public void setIdOfficial(String idOfficial) {
        this.idOfficial = idOfficial;
    }

    public void setNameOfficial(String nameOfficial) {
        this.nameOfficial = nameOfficial;
    }

    @Override
    public String toString() {
        return "official{" +
                "idOfficial='" + idOfficial + '\'' +
                ", nameOfficial='" + nameOfficial + '\'' +
                '}';
    }
}
