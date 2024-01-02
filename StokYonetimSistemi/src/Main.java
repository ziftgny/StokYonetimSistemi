import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Program program = new Program();
        Login deneme = new Login();

        int returnvalue = 0;
        int soru;

        System.out.println();
        System.out.println("STOK YÖNETİM SİSTEMİNE HOŞGELDİNİZ");
        System.out.println();

        do {
            returnvalue = deneme.basla();
            if (returnvalue == 1) {
                program.basla();
            } else if (returnvalue == 2) {
                System.out.println("Girilen bilgiler yanlış!");
            }
        } while (returnvalue == 0);
    }
}

