import java.util.*;

public class KategoriIslem extends CRUDIslemler<Kategori>{

    KategoriIslem(ArrayList<Kategori> kategorilistesi){
        liste = kategorilistesi;
    }
    int input;
    int id;


    public int basla() {
        Scanner soru = new Scanner(System.in);
        do {
                try {
                    System.out.println("Kategori İşlemleri");
                    System.out.println("-------------------------------------------");
                    System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz: ");
                    System.out.println("1-Kategori Oku");
                    System.out.println("2-Kategori Oluştur");
                    System.out.println("3-Kategori Sil");
                    System.out.println("4-Kategori Düzenle");
                    System.out.println("0-Geri Dön");
                    input = soru.nextInt();
                    soru.nextLine();

                    //scanner temizleme
                }catch (Exception e){
                    System.out.println();
                    System.out.println("Geçersiz Değer Girdiniz");
                    System.out.println("Lütfen Geçerli Bir Değer Giriniz");
                    System.out.println();
                    soru.nextLine(); //scanner temizleme
                    input=1;
                    //do while ın çalışma şartı input un 0 olmaması bu exception durumunda
                    //input 0 kaldığı için program calısmayı kesiyor bunu engellemek için
                    //input u 0 yapmıyoruz.
                    continue;

                }
                switch (input) {
                    case 1:
                        oku();
                        System.out.println();
                        break;
                    case 2:
                        olustur();
                        System.out.println();
                        break;
                    case 3:
                        sil();

                        System.out.println();
                        break;
                    case 4:
                        duzenle();
                        System.out.println();
                        break;
                    default:
                        System.out.println();
                        System.out.println("Geçersiz Değer Girdiniz");
                        System.out.println("Lütfen Geçerli Bir Değer Giriniz");

                        System.out.println();
                        break;
                    case 0:
                        return 0;
                }

            } while (input != 0);

            return 1;
    }
    @Override
    public void oku() {
        System.out.println();
        System.out.println("Kategoriler:");
        for (Kategori kategori : liste) {
            System.out.println("ID: " + kategori.getId() + ", Ad: " + kategori.getAd());

        }
        System.out.println();
        System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
    }
    @Override
    public void olustur() {
        Scanner soru = new Scanner(System.in);
        String ad;
        System.out.println("Eklemek istediğiniz kategorinin ismini giriniz: ");
        ad = soru.nextLine();
        Kategori kategori = new Kategori(ad);
        liste.add(kategori);
        System.out.println();
        System.out.println("'"+ad+"' Kategorisi Eklendi");
        System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
        System.out.println();
    }
    @Override
    public void sil() {
        Scanner soru = new Scanner(System.in);
        try {
        System.out.println("Silmek istediğiniz kategorinin idsini giriniz: ");
        id = soru.nextInt();
        soru.nextLine(); //scanner temizleme
        for (Kategori kategori : liste) {
            if (id == kategori.getId()) {
                System.out.println("'" + kategori.getAd() + "' Kategorisi silindi");
                System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
                System.out.println();
                liste.remove(kategori);
                return;
            }
        }
            System.out.println("Geçersiz ID girdiniz");
            System.out.println("İşlem iptal ediliyor");
    }catch (InputMismatchException e){
            System.out.println("Geçersiz ID girdiniz");
            System.out.println("İşlem iptal ediliyor");
            soru.nextLine(); //scanner temizleme
        }
    }

    @Override
    public void duzenle() {
        Scanner soru = new Scanner(System.in);
        int counter=0;
        String ad;
        int input;
        System.out.println("İsmini değiştirmek istediğiniz kategorinin idsini giriniz:  ");
        try {
        input = soru.nextInt();
        for (Kategori k:liste) {
            if(k.getId()==input){
                soru.nextLine();
                System.out.println("Yeni ismi giriniz: ");
                k.setAd(soru.nextLine());
                counter++;
                System.out.println();
                System.out.println("Kategori '"+k.getAd()+"' olarak düzenlendi.");
                System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
                System.out.println();
            }
        }
        if (counter == 0) {
            System.out.println();
            System.out.println("Geçersiz ID girdiniz.");
            System.out.println("İşlem iptal ediliyor");
        }
        }catch (Exception e) {
            System.out.println("Geçersiz ID girdiniz");
            System.out.println("İşlem iptal ediliyor");
            soru.nextLine(); //scanner temizleme
        }

    }
}
