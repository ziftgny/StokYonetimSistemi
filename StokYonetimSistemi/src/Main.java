import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        Login login = new Login();
        login.setup();
        program.setup();

        int returnvalue = 0;
        System.out.println("STOK YÖNETİM SİSTEMİNE HOŞGELDİNİZ");
        //0 döndürüldüğünde sadece kayıt işlemine geri dönmek istediği anlaşılır
        do {
            returnvalue = login.basla();
            if (returnvalue == 1) {
                program.basla();
            }
        } while (returnvalue != 3);
    }
}

