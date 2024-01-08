public class Kullanici {
    private final int id;
    private static int idCounter = 0;

    //Her kullanıcı türünden nesne olusturuldugunda kullanılacak ve
    // her nesneye benzersiz bir id değeri atayacaktır.
    private String kullaniciAdi;
    private String sifre;

    Kullanici(String kullaniciAdi, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        idCounter++;
        id = idCounter;
    }

    public int getId() {
        return id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
