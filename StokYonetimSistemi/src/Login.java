import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Login {
    ArrayList<Kullanici> kullaniciArrayList = new ArrayList<>();
    ArrayList<Yonetici> yoneticiArrayList = new ArrayList<>();

    public void setup() {
        Collections.addAll(kullaniciArrayList,
                new Kullanici("gulsekykc", "20"),
                new Kullanici("ziftgny", "zift2002"),
                new Kullanici("hilmigndogdu", "gs1905")
        );
        Collections.addAll(yoneticiArrayList,
                new Yonetici("ayberk123", "easydaisy"),
                new Yonetici("alper", "3322")
        );
    }

    public int basla() {
        setup();
        Scanner scanner = new Scanner(System.in);
        int kim = 0;
        System.out.println();
        System.out.println("STOK YÖNETİM SİSTEMİNE HOŞGELDİNİZ");
        System.out.println();
        do {
            try {

                System.out.println("Yönetici Girişi İçin 1 Kullanıcı Girişi İçin 2 Yazınız");
                kim = scanner.nextInt(); //reset
                scanner.nextLine();
                switch (kim) {
                    case 1:
                        int counter = 0;
                        System.out.println();
                        System.out.println("Yönetici Girişi");
                        System.out.println("-------------------------------------------");
                        do {
                        System.out.println("Yönetici adını giriniz: ");
                        String kAdi1 = scanner.nextLine();
                        System.out.println("Şifreyi giriniz: ");
                        String sifre1 = scanner.nextLine();
                            for (Yonetici k1 : yoneticiArrayList) {
                                if (sifre1.equals(k1.getSifre())) {
                                    if (kAdi1.equals(k1.getKullaniciAdi())) {
                                        System.out.println();
                                        System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz");
                                        System.out.println();
                                        System.out.println("1-Yönetici İşlemleri");
                                        System.out.println("2-Stok İşlemleri ");
                                        System.out.println("0-Kullanıcı Girişi");
                                        System.out.println();
                                        int secim = scanner.nextInt();

                                        if (secim == 1) {
                                            YoneticiIslem yoneticiIslem = new YoneticiIslem(kullaniciArrayList);
                                            yoneticiIslem.basla();
                                        }
                                        if (secim == 2) {
                                            return 1;
                                        }
                                        if (secim == 0) {
                                            return 0;
                                        }
                                    }
                                }
                            }
                            System.out.println("Hatalı Giriş");
                            System.out.println();
                            counter++;
                        } while (counter != 0);
                    case 2:
                        System.out.println("Kullanıcı Girişi");
                        System.out.println("-------------------------------------------");
                        System.out.println("Kullanıcı adını giriniz: ");
                        String kAdi = scanner.nextLine();
                        System.out.println("Şifreyi giriniz: ");
                        String sifre = scanner.nextLine();
                        for (Kullanici k : kullaniciArrayList) {
                            if (sifre.equals(k.getSifre())) {
                                if (kAdi.equals(k.getKullaniciAdi())) {
                                    return 1;
                                }

                            }

                        }
                        System.out.println("Kullanıcı Adı veya Şifre Yanlış");
                        return 2;

                    default:
                        System.out.println("Geçersiz Değer");
                        System.out.println();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Geçersiz Değer");
                System.out.println();
                scanner.nextLine(); //reset
                continue;
            }
        } while (kim != 1 || kim != 2);
        return 2;


    }
}
