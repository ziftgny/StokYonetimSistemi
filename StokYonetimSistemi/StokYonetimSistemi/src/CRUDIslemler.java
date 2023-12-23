import java.util.ArrayList;

public abstract class CRUDIslemler<T> {
    ArrayList<T> liste;

    public CRUDIslemler(ArrayList<T> liste) {
        this.liste = liste;
    }

    public abstract void oku();
    abstract public void olustur();
    abstract public void sil();
    abstract public void duzenle();
}
