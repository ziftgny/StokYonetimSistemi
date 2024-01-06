
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class YoneticiIslem extends CRUDIslemler<Kullanici> {
    YoneticiIslem(ArrayList<Kullanici> kullanicilistesi) {
        liste = kullanicilistesi;
    }

    public int basla() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz");
                System.out.println("1-Stok İşlemleri");
                System.out.println("2-Yönetici İşlemleri");
                System.out.println("0-Giriş Paneli");
                int secim = scanner.nextInt();
                if (secim == 0) {
                    return 0;
                } else if (secim == 1) {
                    return 1;
                } else if (secim == 2) {
                    yoneticiIslemleri();
                } else {
                    System.out.println("Geçersiz Değer Girdiniz");
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("Geçersiz Değer Girdiniz");
                scanner.nextLine(); //scanner temizleme
            }
        }
    }

    private void yoneticiIslemleri() {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            try {
                System.out.println("Yönetici İşlemleri");
                System.out.println("-------------------------------------------");
                System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz: ");
                System.out.println("1-Kullanıcı Oku");
                System.out.println("2-Kullanıcı Oluştur");
                System.out.println("3-Kullanıcı Sil");
                System.out.println("4-Kullanıcı Düzenle");
                System.out.println("0-Geri Dön");
                input = scanner.nextInt();
                scanner.nextLine();  //scanner temizleme
                switch (input) {
                    case 0:
                        return;
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
                        System.out.println("Geçersiz Değer Girdiniz");
                        System.out.println("Lütfen Geçerli Bir Değer Giriniz");
                        System.out.println();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Geçersiz Değer Girdiniz");
                System.out.println("Lütfen Geçerli Bir Değer Giriniz");
                System.out.println();
                scanner.nextLine(); //scanner temizleme
            }
        } while (true);
    }

    @Override
    public void oku() {
        System.out.println();
        System.out.println("Kullanıcılar:");
        for (Kullanici kullanici : liste) {
            System.out.println("ID: " + kullanici.getId() + ", Ad: " + kullanici.getKullaniciAdi() + ", Şifre: " + kullanici.getSifre());
        }
        System.out.println();
        System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
    }

    @Override
    public void olustur() {
        Scanner scanner = new Scanner(System.in);
        String ad,sifre;
        System.out.println("Eklemek istediğiniz kullanıcının ismini giriniz: ");
        ad = scanner.nextLine();
        System.out.println("Eklemek istediğiniz kullanıcının şifresini giriniz: ");
        sifre = scanner.nextLine();
        Kullanici kullanici = new Kullanici(ad, sifre);
        liste.add(kullanici);
        System.out.println();
        System.out.println("'" + ad + "' Kullanıcısı Eklendi");
        System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
        System.out.println();

    }

    @Override
    public void sil() {
        Scanner scanner = new Scanner(System.in);
        int id;
        try {
            System.out.println("Silmek istediğiniz kullanıcının idsini giriniz: ");
            id = scanner.nextInt();
            scanner.nextLine(); //scanner temizleme
            for (Kullanici kullanici : liste) {
                if (id == kullanici.getId()) {
                    System.out.println("'" + kullanici.getKullaniciAdi() + "' Kullanıcısı silindi");
                    System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
                    System.out.println();
                    liste.remove(kullanici);
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
        String ad;
        int counter = 0,input;
        System.out.println("Düzenlemek istediğiniz kullanıcının idsini giriniz:  ");
        try {
            input = scanner.nextInt();
            scanner.nextLine(); //scanner temizleme
            for (Kullanici kullanici : liste) {
                if (kullanici.getId() == input) {
                    counter++;
                    System.out.println("Yeni ismi giriniz: ");
                    kullanici.setKullaniciAdi(scanner.nextLine());
                    System.out.println("Yeni şifreyi giriniz: ");
                    kullanici.setSifre(scanner.nextLine());
                    System.out.println();
                    System.out.println("Kullanıcı '" + kullanici.getKullaniciAdi() + "' olarak düzenlendi.");
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
            scanner.nextLine(); //scanner temizleme
        }

    }

}

