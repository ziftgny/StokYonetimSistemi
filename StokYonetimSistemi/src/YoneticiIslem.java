
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class YoneticiIslem extends CRUDIslemler<Kullanici> {

    YoneticiIslem(ArrayList<Kullanici> kullanicilistesi) {
        liste = kullanicilistesi;
    }

    int input;
    int id;

    public int basla() {
        Scanner soru = new Scanner(System.in);
        do {
            try {
                System.out.println();
                System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz");
                System.out.println();
                System.out.println("1-Stok İşlemleri");
                System.out.println("2-Yönetici İşlemleri");
                System.out.println("0-Giriş Paneli");
                int secim = soru.nextInt();
                if (secim == 2) {
                    System.out.println();
                } else if (secim == 1) {
                    return 1;
                } else if (secim == 0) {
                    System.out.println();
                    return 0;
                } else {
                    System.out.println("Geçersiz Değer Girdiniz");
                    continue;
                }
                do {
                    System.out.println("Yönetici İşlemleri");
                    System.out.println("-------------------------------------------");
                    System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz: ");
                    System.out.println("1-Kullanıcı Oku");
                    System.out.println("2-Kullanıcı Oluştur");
                    System.out.println("3-Kullanıcı Sil");
                    System.out.println("4-Kullanıcı Düzenle");
                    System.out.println("0-Geri Dön");
                    input = soru.nextInt();
                    soru.nextLine();

                    //scanner temizleme

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
                            continue;
                    }
                } while (input != 0);
            } catch (Exception e) {
                System.out.println();
                System.out.println("Geçersiz Değer Girdiniz");
                soru.nextLine(); //scanner temizleme
                input = 1;
                //do while ın çalışma şartı input un 0 olmaması bu exception durumunda
                //input 0 kaldığı için program calısmayı kesiyor bunu engellemek için
                //input u 0 yapmıyoruz.
                continue;
            }

        } while (input != -1);//sonsuz döngü için 0 dan herhangi bir değer olması lazım. -1 opsiyonel bir sayı
        return 1;
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
        Scanner soru = new Scanner(System.in);
        String ad;
        String sifre;
        System.out.println("Eklemek istediğiniz kullanıcının ismini giriniz: ");
        ad = soru.nextLine();
        System.out.println("Eklemek istediğiniz kullanıcının şifresini giriniz: ");
        sifre = soru.nextLine();
        Kullanici kullanici = new Kullanici(ad, sifre);
        liste.add(kullanici);
        System.out.println();
        System.out.println("'" + ad + "' Kullanıcısı Eklendi");
        System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
        System.out.println();

    }

    @Override
    public void sil() {
        Scanner soru = new Scanner(System.in);
        try {
            System.out.println("Silmek istediğiniz kullanıcının idsini giriniz: ");
            id = soru.nextInt();
            soru.nextLine(); //scanner temizleme
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
            soru.nextLine(); //scanner temizleme
        }
    }


    @Override
    public void duzenle() {
        Scanner soru = new Scanner(System.in);
        int counter = 0;
        String ad;
        int input;
        System.out.println("Düzenlemek istediğiniz kullanıcının idsini giriniz:  ");
        try {
            input = soru.nextInt();
            for (Kullanici kullanici : liste) {
                if (kullanici.getId() == input) {
                    soru.nextLine();
                    System.out.println("Yeni ismi giriniz: ");
                    kullanici.setKullaniciAdi(soru.nextLine());
                    System.out.println("Yeni şifreyi giriniz: ");
                    kullanici.setSifre(soru.nextLine());
                    counter++;
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
            soru.nextLine(); //scanner temizleme
        }

    }

}

