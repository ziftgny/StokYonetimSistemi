public class Marka {
    private int id;
    private String ad;
    //Her marka cinsinden obje olusturuldugunda kullanılacak ve her
    //objeye benzersiz id değeri verecektir.
    private static int idCounter=0;
    public Marka( String ad) {
        idCounter++;
        id=idCounter;
        this.ad = ad;

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
}