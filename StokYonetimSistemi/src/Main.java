public class Main {
    public static void main(String[] args) {
        System.out.println("Hilmi Deniyor");
            Program program = new Program();
            if(program.login()){
                program.basla();
            }
            else {
                System.out.println("Girilen bilgiler yanlış!");
            }
        }
    }
