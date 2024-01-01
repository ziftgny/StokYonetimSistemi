public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        Login deneme = new Login();


        if(deneme.basla()){
            program.basla();
        }
        else {
            System.out.println("Girilen bilgiler yanlış!");
        }

    }
}

