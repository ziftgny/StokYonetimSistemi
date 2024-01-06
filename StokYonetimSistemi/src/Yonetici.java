public class Yonetici {
    private  int id;
    private static int idCounter=0;

    //Her yönetici türünden nesne olusturuldugunda kullanılacak ve
    // her nesneye benzersiz bir id değeri atayacaktır.
    private String kullaniciAdi;
    private String sifre;
    Yonetici(String kullaniciAdi,String sifre){
        this.kullaniciAdi=kullaniciAdi;
        this.sifre=sifre;
        idCounter++;
        id=idCounter;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
