public class Marka {
    private int id;
    private String ad;

    private static int idCounter = 0;

    //Her marka türünden nesne olusturuldugunda kullanılacak ve
    // her nesneye benzersiz bir id değeri atayacaktır.

    public Marka(String ad) {
        idCounter++;
        id = idCounter;
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
