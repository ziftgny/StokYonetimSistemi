import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Program {
    ArrayList<Marka> markaListesi = new ArrayList<>();
    ArrayList<Kategori> kategoriListesi = new ArrayList<>();
    ArrayList<Urun> urunListesi = new ArrayList<>();

    public boolean basla() {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        while (true) {
            try {
                System.out.println();
                System.out.println("Sisteme hoş geldiniz! işlem seçiniz");
                System.out.println("1-Kategori işlemleri");
                System.out.println("2-Marka işlemleri");
                System.out.println("3-Ürün işlemleri");
                System.out.println("0-Giriş Paneli");
                input = scanner.nextInt();
                switch (input) {
                    case 1:
                        KategoriIslem kategoriIslem = new KategoriIslem(kategoriListesi);
                        kategoriIslem.basla();
                        break;
                    case 2:
                        MarkaIslem markaIslem = new MarkaIslem(markaListesi);
                        markaIslem.basla();
                        break;
                    case 3:
                        UrunIslem urunIslem = new UrunIslem(urunListesi, markaListesi, kategoriListesi);
                        urunIslem.basla();
                        break;
                    case 0:
                        return false;
                    default:
                        System.out.println("Hatalı değer girdiniz");
                        break;
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("Geçersiz Değer Girdiniz");
                scanner.nextLine(); //scanner temizleme
            }
        }

    }

    public void setup() {
        Collections.addAll(markaListesi
                , new Marka("Boş")
                , new Marka("Toshiba")
                , new Marka("Apple")
                , new Marka("LG")
                , new Marka("Samsung")
                , new Marka("AMD")
                , new Marka("Intel")
        );
        Collections.addAll(kategoriListesi
                , new Kategori("Boş")
                , new Kategori("Televizyon")
                , new Kategori("Telefon")
                , new Kategori("Notebook")
        );
        Collections.addAll(urunListesi
                , new Urun("GalaxyS5", 1049.24, 54, markaListesi.get(4), kategoriListesi.get(2))
                , new Urun("İphone", 2500.24, 51, markaListesi.get(2), kategoriListesi.get(2))
                , new Urun("OLed", 5563.24, 48, markaListesi.get(6), kategoriListesi.get(1))
        );

    }

}
