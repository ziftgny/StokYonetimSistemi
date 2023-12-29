import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Program {
    ArrayList<Marka> markaListesi=new ArrayList<>();
    ArrayList<Kategori> kategoriListesi=new ArrayList<>();
    ArrayList<Urun> urunListesi=new ArrayList<>();

    public boolean login(){
        return true;
    }
    public int basla(){
        setup();
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        do {
            System.out.println("Sisteme hoş geldiniz! işlem seçiniz");
            System.out.println("1-Kategori işlemleri");
            System.out.println("2-Marka işlemleri");
            System.out.println("3-Ürün işlemleri");
            System.out.println("0-Çıkış");
            input=scanner.nextInt();
                switch (input){
                    case 1:
                        KategoriIslem kategoriIslem = new KategoriIslem(kategoriListesi);
                        kategoriIslem.basla();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 0:
                        return 0;
                    default:
                        System.out.println("hatalı değer girdiniz");
                        break;
                }
        }while(input!=0);
        return 1;
    }
    public void setup(){
        Collections.addAll(markaListesi
                ,new Marka("Toshiba")
                ,new Marka("Apple")
                ,new Marka("LG")
                ,new Marka("Samsung")
                ,new Marka("AMD")
                ,new Marka("Intel")
        );
        Collections.addAll(kategoriListesi
                ,new Kategori("Televizyon")
                ,new Kategori("Telefon")
                ,new Kategori("Notebook")
        );
        Collections.addAll(urunListesi
                ,new Urun("deneme",37.24,54,getMarkaByID(1),getKategoriByID(1))
                ,new Urun("denemeee",21.24,54,getMarkaByID(2),getKategoriByID(3))
                ,new Urun("denemeeee",12.24,54,getMarkaByID(3),getKategoriByID(1))
        );

    }
    public Marka getMarkaByID(int id){
        for (Marka i:markaListesi) {
            if(id == i.getId())
                return i;
        }
        System.out.println("Marka bulunamadı");
        return null;
    }
    public Kategori getKategoriByID(int id){
        for (Kategori i:kategoriListesi) {
            if(id == i.getId())
                return i;
        }
        System.out.println("Kategori bulunamadı");
        return null;
    }
}
