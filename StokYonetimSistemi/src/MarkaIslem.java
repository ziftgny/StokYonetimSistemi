import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MarkaIslem extends CRUDIslemler<Marka>{
    MarkaIslem(ArrayList<Marka> markaListesi) {
        liste = markaListesi;
    }

    int input;
    int id;


    public int basla() {
        Scanner soru = new Scanner(System.in);
        do {
            try {
                System.out.println("Marka İşlemleri");
                System.out.println("-------------------------------------------");
                System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz: ");
                System.out.println("1-Marka Oku");
                System.out.println("2-Marka Oluştur");
                System.out.println("3-Marka Sil");
                System.out.println("4-Marka Düzenle");
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
        System.out.println("Markalar:");
        for (Marka marka : liste) {
            System.out.println("ID: " + marka.getId() + ", Ad: " + marka.getAd());

        }
        System.out.println();
        System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
    }

    @Override
    public void olustur() {
        Scanner soru = new Scanner(System.in);
        String ad;
        System.out.println("Eklemek istediğiniz marka ismini giriniz: ");
        ad = soru.nextLine();
        Marka marka = new Marka(ad);
        liste.add(marka);
        System.out.println();
        System.out.println("'" + ad + "' Markası Eklendi");
        System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
        System.out.println();
    }

    @Override
    public void sil() {
        Scanner soru = new Scanner(System.in);
        try {
            System.out.println("Silmek istediğiniz markanın idsini giriniz: ");
            id = soru.nextInt();
            soru.nextLine(); //scanner temizleme
            for (Marka marka : liste) {
                if (id == marka.getId()) {
                    System.out.println("'" + marka.getAd() + "' Markası silindi");
                    System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
                    System.out.println();
                    liste.remove(marka);
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
        int input;
        System.out.println("İsmini değiştirmek istediğiniz kategorinin idsini giriniz:  ");
        try {
            input = soru.nextInt();
            for (Marka m : liste) {
                if (m.getId() == input) {
                    soru.nextLine();
                    System.out.println("Yeni ismi giriniz: ");
                    m.setAd(soru.nextLine());
                    counter++;
                    System.out.println();
                    System.out.println("Marka '" + m.getAd() + "' olarak düzenlendi.");
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


