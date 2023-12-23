public class Urun {
    private int id;
    private String ad;
    private double fiyat;
    private int stok;
    private Marka marka;
    private Kategori kategori;
    private static int idCounter=0;

    public Urun(String ad, double fiyat, int stok, Marka marka, Kategori kategori) {
        idCounter++;
        this.id=idCounter;
        this.ad = ad;
        this.fiyat = fiyat;
        this.stok = stok;
        this.marka = marka;
        this.kategori = kategori;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public Marka getMarka() {
        return marka;
    }

    public void setMarka(Marka marka) {
        this.marka = marka;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }
}
