import java.util.*;

public class KategoriIslem extends CRUDIslemler<Kategori>{

    KategoriIslem(ArrayList<Kategori> kategorilistesi){
        liste = kategorilistesi;
    }

    Scanner soru = new Scanner(System.in);
    int input;
    int id;


    public int basla() {

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
                    soru.nextLine(); //scanner temizleme
                }catch (Exception e){
                    System.out.println();
                    System.out.println("Geçersiz Değer Girdiniz");
                    System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
                    System.out.println();
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
                    case 0:
                        return 0;
                    default:
                        System.out.println("Hatalı Değer Girdiniz");
                        System.out.println("Lütfen Geçerli Bir Değer Giriniz");
                        System.out.println();
                        break;
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
        try {
        System.out.println("Silmek istediğiniz kategorinin idsini giriniz: ");
        id = soru.nextInt();
        soru.nextLine(); //scanner temizleme
        for (Kategori kategori : liste) {
            if (id == kategori.getId()) {
                liste.remove(kategori);
                System.out.println("'" + kategori.getAd() + "' Kategorisi silindi");
                System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
                System.out.println();
            } else {
                continue;
            }
        }
    }catch (ConcurrentModificationException e){
            if (id!=1) {
                System.out.println("Geçersiz ID girdiniz");
                System.out.println("İşlem iptal ediliyor");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Geçersiz ID girdiniz");
            System.out.println("İşlem iptal ediliyor");
            soru.nextLine(); //scanner temizleme
        }
    }

    @Override
    public void duzenle() {
        String ad;
        Kategori degisenKategori = new Kategori(null);
        try {
            System.out.println("İsmini değiştirmek istediğiniz kategorinin idsini giriniz:  ");
            input = soru.nextInt();
            soru.nextLine(); //scanner temizleme
            for (Kategori kategori : liste) {
                if (kategori.getId() == input) {
                    degisenKategori = kategori;
                    break;
                }
            }
        if (degisenKategori.getAd() != null){
            System.out.println("Yeni ismi giriniz: ");
            ad = soru.nextLine();
            degisenKategori.setAd(ad);
        }else {
            System.out.println("Geçersiz ID girdiniz.");
            System.out.println("İşlem iptal ediliyor");
        }
        }catch (Exception e){
            System.out.println("Geçersiz ID girdiniz");
            System.out.println("İşlem iptal ediliyor");
            soru.nextLine(); //scanner temizleme
        }
    }
}
