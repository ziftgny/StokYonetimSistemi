import java.util.*;

public class KategoriIslem extends CRUDIslemler<Kategori> {
    KategoriIslem(ArrayList<Kategori> kategorilistesi) {
        liste = kategorilistesi;
    }

    public int basla() {
        Scanner scanner = new Scanner(System.in);
        int input;
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
                input = scanner.nextInt();
                scanner.nextLine(); //scanner temizleme
            } catch (Exception e) {
                System.out.println();
                System.out.println("Geçersiz Değer Girdiniz");
                System.out.println("Lütfen Geçerli Bir Değer Giriniz");
                System.out.println();
                scanner.nextLine(); //scanner temizleme
                continue;
            }
            switch (input) {
                case 0:
                    return 0;
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
            }
        } while (true);
    }

    @Override
    public void oku() {
        System.out.println();
        System.out.println("Kategoriler:");
        for (Kategori kategori : liste) {
            System.out.println("ID: " + kategori.getId() + ", Ad: " + kategori.getAd());

        }
        System.out.println();
    }

    @Override
    public void olustur() {
        Scanner scanner = new Scanner(System.in);
        String ad;
        System.out.println("Eklemek istediğiniz kategorinin ismini giriniz: ");
        ad = scanner.nextLine();
        Kategori kategori = new Kategori(ad);
        liste.add(kategori);
        System.out.println();
        System.out.println("'" + ad + "' Kategorisi Eklendi");
        System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
        System.out.println();
    }

    @Override
    public void sil() {
        Scanner scanner = new Scanner(System.in);
        int id;
        try {
            System.out.println("Silmek istediğiniz kategorinin idsini giriniz: ");
            id = scanner.nextInt();
            scanner.nextLine(); //scanner temizleme
            for (Kategori kategori : liste) {
                if (id == kategori.getId()) {
                    System.out.println("'" + kategori.getAd() + "' Kategorisi silindi");
                    System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
                    System.out.println();
                    liste.remove(kategori);
                    return;
                    // Silme işlemi bitince sil() metoduna devam etmesin diye return ile metodu sonlandırıyoruz
                }
            }
            System.out.println("Geçersiz ID girdiniz");
            System.out.println("İşlem iptal ediliyor");
        } catch (InputMismatchException e) {
            System.out.println("Geçersiz ID girdiniz");
            System.out.println("İşlem iptal ediliyor");
            scanner.nextLine(); //scanner temizleme
        }
    }

    @Override
    public void duzenle() {
        Scanner scanner = new Scanner(System.in);
        int counter = 0, input;
        try {
            System.out.println("İsmini değiştirmek istediğiniz kategorinin idsini giriniz:  ");
            input = scanner.nextInt();
            scanner.nextLine(); //scanner temizleme
            for (Kategori kategori : liste) {
                if (kategori.getId() == input) {
                    counter++;
                    System.out.println("Yeni ismi giriniz: ");
                    kategori.setAd(scanner.nextLine());
                    System.out.println();
                    System.out.println("Kategori '" + kategori.getAd() + "' olarak düzenlendi.");
                    System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
                    System.out.println();
                }
            }
            if (counter == 0) {
                System.out.println();
                System.out.println("Geçersiz ID girdiniz.");
                System.out.println("İşlem iptal ediliyor");
            }
        } catch (Exception e) {
            System.out.println("Geçersiz ID girdiniz");
            System.out.println("İşlem iptal ediliyor");
            scanner.nextLine(); //scanner temizleme
        }

    }
    public Kategori getCategoryByID(int id){
        for (Kategori i:liste) {
            if(id==i.getId())
                return i;
        }
        return null;
    }
}
