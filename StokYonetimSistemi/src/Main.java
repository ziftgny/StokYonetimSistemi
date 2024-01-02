import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        Login deneme = new Login();
        int returnvalue=0;
        Scanner scanner = new Scanner(System.in);
        int soru ;
        do {
            returnvalue=deneme.basla();
            if (returnvalue==1) {
                program.basla();
            } else if(returnvalue==2){
                System.out.println("Girilen bilgiler yanlış!");
            }
        }while(returnvalue==0);
    }
}

