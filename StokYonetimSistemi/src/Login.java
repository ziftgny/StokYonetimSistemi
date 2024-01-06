import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Login {
    ArrayList<Kullanici> kullaniciArrayList = new ArrayList<>();
    ArrayList<Yonetici> yoneticiArrayList = new ArrayList<>();

    public void setup() {
        // collection ne ?
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
        Scanner scanner = new Scanner(System.in);
        int secim = 0;
        while (true) {
            try {
                System.out.println("1-Yönetici girişi");
                System.out.println("2-Kullanıcı girişi");
                System.out.println("3-Çıkış");
                secim = scanner.nextInt();
                scanner.nextLine(); //reset
                switch (secim) {
                    case 1:
                        int counter = 0;
                        System.out.println();
                        System.out.println("Yönetici Girişi");
                        System.out.println("-------------------------------------------");
                        System.out.println("Yönetici adını giriniz: ");
                        String yoneticiKAdi = scanner.nextLine();
                        System.out.println("Şifreyi giriniz: ");
                        String sifreY = scanner.nextLine();
                        for (Yonetici k1 : yoneticiArrayList) {
                            if (sifreY.equals(k1.getSifre())) {
                                if (yoneticiKAdi.equals(k1.getKullaniciAdi())) {
                                    YoneticiIslem yoneticiIslem = new YoneticiIslem(kullaniciArrayList);
                                    if (yoneticiIslem.basla() == 1) {
                                        return 1;
                                    }
                                    counter++; // gerekli mi olmasa olur mu ?
                                    // gerekli değilse counteri sil if kaldır
                                }
                            }
                        }
                        if (counter == 0) {
                            System.out.println("Kullanıcı Adı veya Şifre Yanlış");
                            System.out.println();
                        }
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("Kullanıcı Girişi");
                        System.out.println("-------------------------------------------");
                        System.out.println("Kullanıcı adını giriniz: ");
                        String kAdi = scanner.nextLine();
                        System.out.println("Şifreyi giriniz: ");
                        String sifreK = scanner.nextLine();
                        for (Kullanici k : kullaniciArrayList) {
                            if (sifreK.equals(k.getSifre())) {
                                if (kAdi.equals(k.getKullaniciAdi())) {
                                    return 1;
                                }
                            }
                        }
                        System.out.println("Kullanıcı Adı veya Şifre Yanlış");
                        System.out.println();
                        break;
                    case 3:
                        return 3;
                    default:
                        System.out.println("Geçersiz Değer");
                        System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Geçersiz Değer");
                System.out.println();
                scanner.nextLine(); //reset
            }
        }
    }
}
