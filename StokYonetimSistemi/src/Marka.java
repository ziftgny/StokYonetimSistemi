public class Marka {
    private final int id;
    private String ad;

    private static int idCounter = 0;

    //Her marka türünden nesne olusturuldugunda kullanılacak ve
    // her nesneye benzersiz bir id değeri atayacaktır.

    public Marka(String ad) {
        this.ad = ad;
        id = idCounter;
        idCounter++;
    }


    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
