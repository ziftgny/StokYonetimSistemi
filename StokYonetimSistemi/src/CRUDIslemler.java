import java.util.ArrayList;

public abstract class CRUDIslemler<T> {
    ArrayList<T> liste;
    //Neden t , t ne işe yarıyor ?

    public abstract void oku();

    abstract public void olustur();

    abstract public void sil();

    abstract public void duzenle();

}
