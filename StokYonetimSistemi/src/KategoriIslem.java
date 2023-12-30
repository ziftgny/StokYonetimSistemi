import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KategoriIslem extends CRUDIslemler{

    private ArrayList<Kategori> kategoriListesi;

    public KategoriIslem(ArrayList<Kategori> kategoriListesi) {
        this.kategoriListesi = kategoriListesi;
    }
    Scanner soru = new Scanner(System.in);
    int input;


    public int basla(){
        do {
            System.out.println("Kategori İşlemleri");
            System.out.println("Lütfen Yapmak İstediğiniz işlemi seçiniz: ");
            System.out.println("1-Kategori Oku");
            System.out.println("2-Kategori Oluştur");
            System.out.println("3-Kategori Sil");
            System.out.println("4-Kategori Düzenle");
            System.out.println("0-Geri Dön");
            input = soru.nextInt();
            switch (input){
                case 1:
                    oku();
                    break;
                case 2:
                    olustur();
                    break;
                case 3:
                    sil();
                    break;
                case 4:
                    olustur();
                    break;
                case 0:
                    return 0;
                default:
                    System.out.println("hatalı değer girdiniz");
                    break;
            }
        }while(input!=0);
        return 1;
    }

    @Override
    public void oku() {
        System.out.println("Kategoriler:");

        for (Kategori kategori : kategoriListesi) {
            System.out.println("ID: " + kategori.getId() + ", Ad: " + kategori.getAd());
        }
        System.out.println();
    }
    @Override
    public void olustur() {
    }

    @Override
    public void sil() {

    }

    @Override
    public void duzenle() {

    }
}
