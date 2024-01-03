import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UrunIslem extends  CRUDIslemler<Urun>{
    UrunIslem(ArrayList<Urun> urunListesi) {liste=urunListesi;}
     int id;

     double fiyat;
     int stok;
     Marka marka;
     Kategori kategori;
     int input;
    public int basla() {
        Scanner soru = new Scanner(System.in);
        do {
            try {
                System.out.println("Urun İşlemleri");
                System.out.println("-------------------------------------------");
                System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz: ");
                System.out.println("1-Urun Oku");
                System.out.println("2-Urun Oluştur");
                System.out.println("3-Urun Sil");
                System.out.println("4-Urun Düzenle");
                System.out.println("0-Geri Dön");
                input = soru.nextInt();
                soru.nextLine();

                //scanner temizleme
            } catch (Exception e) {
                System.out.println();
                System.out.println("Geçersiz Değer Girdiniz");
                System.out.println("Lütfen Geçerli Bir Değer Giriniz");
                System.out.println();
                soru.nextLine(); //scanner temizleme
                input = 1;
                //do while ın çalışma şartı input un 0 olmaması bu exception durumunda
                //input 0 kaldığı için program calısmayı kesiyor bunu engellemek için
                //input u 0 yapmıyoruz.
                continue;

            }
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
                default:
                    System.out.println();
                    System.out.println("Geçersiz Değer Girdiniz");
                    System.out.println("Lütfen Geçerli Bir Değer Giriniz");

                    System.out.println();
                    break;
                case 0:
                    return 0;
            }

        } while (input != 0);

        return 1;
    }

    @Override
    public void oku() {
        System.out.println();
        System.out.println("Ürünler:");
        for (Urun urun : liste) {
            System.out.println("ID: " + urun.getId() + ", Ad: " + urun.getAd()+",Fiyat: "+urun.getFiyat()+",Kategori: "+urun.getKategori().getAd() +",Stok: "+urun.getStok()+",Marka: "+urun.getMarka().getAd());

        }
        System.out.println();
        System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
    }

    @Override
    public void olustur() {
        /* Scanner soru = new Scanner(System.in);
        String ad;
        String marka;
        System.out.println("Eklemek istediğiniz ürün ismini giriniz: ");
        ad = soru.nextLine();
        System.out.println("Eklemek istediğiniz ürün fiyatını giriniz: ");
        fiyat=soru.nextInt();
        System.out.println("Eklemek istediğiniz ürün stokunu giriniz: ");
        stok=soru.nextInt();
        System.out.println("Eklemek istediğiniz ürün markasını giriniz: ");
         marka=soru.nextLine();
        Urun urun = new Urun(ad,fiyat,stok,marka,kategori);
        liste.add(urun);
        System.out.println();
        System.out.println("'" + ad + "' Ürün Eklendi");
        System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
        System.out.println(); */
    }

    @Override
    public void sil() {
        Scanner soru = new Scanner(System.in);
        try {
            System.out.println("Silmek istediğiniz markanın idsini giriniz: ");
            id = soru.nextInt();
            soru.nextLine(); //scanner temizleme
            for (Urun urun : liste) {
                if (id == urun.getId()) {
                    System.out.println("'" + urun.getAd() + "' Ürünü silindi");
                    System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
                    System.out.println();
                    liste.remove(urun);
                    return;
                }
            }
            System.out.println("Geçersiz ID girdiniz");
            System.out.println("İşlem iptal ediliyor");
        } catch (InputMismatchException e) {
            System.out.println("Geçersiz ID girdiniz");
            System.out.println("İşlem iptal ediliyor");
            soru.nextLine(); //scanner temizleme
        }
    }

    @Override
    public void duzenle() {
        Scanner soru = new Scanner(System.in);
        int counter = 0;
        String ad;
        int input;
        System.out.println("İsmini değiştirmek istediğiniz ürünün idsini giriniz:  ");
        try {
            input = soru.nextInt();
            for (Urun u : liste) {
                if (u.getId() == input) {
                    soru.nextLine();
                    System.out.println("Yeni ismi giriniz: ");
                    u.setAd(soru.nextLine());
                    counter++;
                    System.out.println();
                    System.out.println("Ürün '" + u.getAd() + "' olarak düzenlendi.");
                    System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
                    System.out.println();
                }
            }
            if (counter == 0) {
                System.out.println();
                System.out.println("Geçersiz ID girdiniz.");
                System.out.println("İşlem iptal ediliyor");
            }
        } catch (Exception e) {
            System.out.println("Geçersiz ID girdiniz");
            System.out.println("İşlem iptal ediliyor");
            soru.nextLine(); //scanner temizleme
        }

    }
}
