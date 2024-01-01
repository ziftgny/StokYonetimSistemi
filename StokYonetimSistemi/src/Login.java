import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Login {
    ArrayList<Kullanici> kullaniciArrayList=new ArrayList<>();
    ArrayList<Kullanici> yoneticiArrayList=new ArrayList<>();
     public void setup(){
         Collections.addAll(kullaniciArrayList,
                 new Kullanici("gulsekykc","20"),
                 new Kullanici("ziftgny","zift2002"),
                 new Kullanici("hilmigndogdu","gs1905")
                 );
         Collections.addAll(yoneticiArrayList,
                 new Kullanici("ayberk123","easydaisy"),
                 new Kullanici("alper","3322")
         );
     }
    public boolean basla(){
         setup();
        Scanner scanner = new Scanner(System.in);
        System.out.println("yönetici ise 1 \n kullanıcı ise 2 yazınız");
        int kim = scanner.nextInt();
        //reset
        scanner.nextLine();
        switch (kim){
            case 1:  System.out.println("yönetici girişi için kullanıcı adı giriniz: ");
                String kAdi1 = scanner.nextLine();
                System.out.println("Yönetici girişi için şifre giriniz: ");
                String sifre1 = scanner.nextLine();
                for (Kullanici k1:yoneticiArrayList) {
                    if(sifre1.equals(k1.getSifre())){
                        if(kAdi1.equals(k1.getKullaniciAdi())){
                            return true;
                        }

                    }
                }
                System.out.println("şifre veya kullanıcı adı yanlış");
                return false;
            case 2:
                System.out.println("kullanıcı girişi için kullanıcı adı giriniz: ");
                String kAdi = scanner.nextLine();
                System.out.println("kullanıcı girişi için şifre giriniz: ");
                String sifre = scanner.nextLine();
                for (Kullanici k:kullaniciArrayList) {
                    if(sifre.equals(k.getSifre())){
                        if(kAdi.equals(k.getKullaniciAdi())){
                            return true;
                        }

                     }

                }
                System.out.println("şifre veya kullanıcı adı yanlış");
                return false;
            default:
                System.out.println("geçersiz değer");
                break;
        }
        return false;
    }
}
