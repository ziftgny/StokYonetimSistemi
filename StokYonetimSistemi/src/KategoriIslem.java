import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class KategoriIslem extends CRUDIslemler<Kategori>{

    KategoriIslem(ArrayList<Kategori> kategorilistesi){
        liste = kategorilistesi;
    }

    Scanner soru = new Scanner(System.in);
    int input;
    int id;


    public int basla() {

            do {
                System.out.println("Kategori İşlemleri");
                System.out.println();
                System.out.println("Lütfen Yapmak İstediğiniz işlemi seçiniz: ");
                System.out.println("1-Kategori Oku");
                System.out.println("2-Kategori Oluştur");
                System.out.println("3-Kategori Sil");
                System.out.println("4-Kategori Düzenle");
                System.out.println("0-Geri Dön");
                input = soru.nextInt();
                soru.nextLine(); //scanner temizleme
                switch (input) {
                    case 1:
                        oku();
                        System.out.println();
                        break;
                    case 2:
                        olustur();
                        System.out.println();
                        break;
                    case 3:
                        sil();
                        System.out.println();
                        break;
                    case 4:
                        duzenle();
                        System.out.println();
                        break;
                    case 0:
                        return 0;
                    default:
                        System.out.println("hatalı değer girdiniz");
                        break;
                }

            } while (input != 0);
            return 1;
    }
    @Override
    public void oku() {
        System.out.println("Kategoriler:");
        System.out.println();
        for (Kategori kategori : liste) {
            System.out.println("ID: " + kategori.getId() + ", Ad: " + kategori.getAd());
        }
        System.out.println();

    }
    @Override
    public void olustur() {
        String ad;
        System.out.println("Eklemek istediğiniz kategorinin ismini giriniz: ");
        ad = soru.nextLine();
        Kategori kategori = new Kategori(ad);
        liste.add(kategori);
    }
    @Override
    public void sil() {

        try {
            System.out.println("Silmek istediğiniz kategorinin idsini giriniz: ");
            id = soru.nextInt();
            liste.remove(id-1);
        }catch(Exception e){
            System.out.println("Geçersiz ID girdiniz");
            System.out.println("İşlem iptal ediliyor");
            soru.nextLine(); //scanner temizleme
        }
    }
    @Override
    public void duzenle() {
        String ad;
        Kategori degisenKategori = null;
        try {
            System.out.println("İsmini değiştirmek istediğiniz kategorinin idsini giriniz:  ");
            input = soru.nextInt();
            soru.nextLine(); //scanner temizleme
            for (Kategori kategori : liste) {
                if (kategori.getId() == input) {
                    degisenKategori = kategori;
                    break;
                }
            }

        }catch (Exception e){
            System.out.println("Geçersiz ID girdiniz");
            System.out.println("İşlem iptal ediliyor");
            soru.nextLine(); //scanner temizleme
        }
        if (degisenKategori != null){
            System.out.println("Yeni ismi giriniz: ");
            ad = soru.nextLine();
            degisenKategori.setAd(ad);
        }else {
            System.out.println("Geçersiz id girdiniz.");
            System.out.println("İşlem iptal ediliyor");
        }
    }
}
