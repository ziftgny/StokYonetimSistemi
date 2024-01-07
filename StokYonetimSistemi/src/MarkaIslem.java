import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MarkaIslem extends CRUDIslemler<Marka> {
    MarkaIslem(ArrayList<Marka> markaListesi) {
        liste = markaListesi;
    }

    public int basla() {
        Scanner scanner = new Scanner(System.in);
        int input;
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
                input = scanner.nextInt();
                scanner.nextLine(); // scanner temizleme
            } catch (Exception e) {
                System.out.println();
                System.out.println("Geçersiz Değer Girdiniz");
                System.out.println("Lütfen Geçerli Bir Değer Giriniz");
                System.out.println();
                scanner.nextLine(); //scanner temizleme
                continue;
            }
            switch (input) {
                case 0:
                    return 0;
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
            }
        } while (true);
    }

    @Override
    public void oku() {
        System.out.println();
        System.out.println("Markalar:");
        for (Marka marka : liste) {
            System.out.println("ID: " + marka.getId() + ", Ad: " + marka.getAd());

        }
        System.out.println();
    }

    @Override
    public void olustur() {
        Scanner scanner = new Scanner(System.in);
        String ad;
        System.out.println("Eklemek istediğiniz marka ismini giriniz: ");
        ad = scanner.nextLine();
        Marka marka = new Marka(ad);
        liste.add(marka);
        System.out.println();
        System.out.println("'" + ad + "' Markası Eklendi");
        System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
        System.out.println();
    }

    @Override
    public void sil() {
        Scanner scanner = new Scanner(System.in);
        int input;
        try {
            System.out.println("Silmek istediğiniz markanın idsini giriniz: ");
            input = scanner.nextInt();
            scanner.nextLine(); //scanner temizleme
            if (input == 0) {
                System.out.println("Boş Marka Silinemez");
                return;
            }
            for (Marka marka : liste) {
                if (input == marka.getId()) {
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
            scanner.nextLine(); //scanner temizleme
        }
    }

    @Override
    public void duzenle() {
        Scanner scanner = new Scanner(System.in);
        int input;
        try {
            System.out.println("İsmini değiştirmek istediğiniz kategorinin idsini giriniz:  ");
            input = scanner.nextInt();
            scanner.nextLine(); //scanner temizleme
            if (input == 0) {
                System.out.println("Boş Kategori Düzenlenemez");
                return;
            }
            for (Marka marka : liste) {
                if (marka.getId() == input) {
                    System.out.println("Yeni ismi giriniz: ");
                    marka.setAd(scanner.nextLine());
                    System.out.println();
                    System.out.println("Marka '" + marka.getAd() + "' olarak düzenlendi.");
                    System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
                    System.out.println();
                    return;
                }
            }
            System.out.println();
            System.out.println("Geçersiz ID girdiniz.");
            System.out.println("İşlem iptal ediliyor");
        } catch (Exception e) {
            System.out.println("Geçersiz ID girdiniz");
            System.out.println("İşlem iptal ediliyor");
            scanner.nextLine(); //scanner temizleme
        }

    }

    public Marka getBrandByID(int id) { //????*
        for (Marka i : liste) {
            if (id == i.getId())
                return i;
        }
        return null;
    }
}


