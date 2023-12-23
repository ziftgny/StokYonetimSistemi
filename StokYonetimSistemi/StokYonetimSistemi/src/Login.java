import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Login {
    ArrayList<Kullanici> kullaniciArrayList=new ArrayList<>();
     public void setup(){
         Collections.addAll(kullaniciArrayList,
                 new Kullanici("gulsekykc","20"),
                 new Kullanici("ziftgny","zift2002")
                 );
     }
    public void basla(){
         setup();
        Scanner scanner = new Scanner(System.in);
        System.out.println("yönetici ise 1 \n kullanıcı ise 2 yazınız");
        int kim = scanner.nextInt();
        switch (kim){
            case 1:
                break;
            case 2:
                System.out.println("kullanıcı girişi için kullanıcı adı giriniz: ");
                String kullanıcı1 = scanner.nextLine();
                System.out.println("kullanıcı girişi için şifre giriniz: ");
                String sifre1 = scanner.nextLine();
                for (Kullanici k:kullaniciArrayList) {
                    if(sifre1.equals(k.getSifre())){

                }


                }
                break;
        }
    }
}
