import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UrunIslem extends CRUDIslemler<Urun> {
    ArrayList<Marka> markaListesi = new ArrayList<>();
    ArrayList<Kategori> kategoriListesi = new ArrayList<>();

    UrunIslem(ArrayList<Urun> urunListesi, ArrayList<Marka> markaListesi, ArrayList<Kategori> kategoriListesi) {
        liste = urunListesi;
        this.markaListesi = markaListesi;
        this.kategoriListesi = kategoriListesi;
    }

    public int basla() {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            try {
                System.out.println("Urun İşlemleri");
                System.out.println("-------------------------------------------");
                System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz: ");
                System.out.println("1-Urun Oku");
                System.out.println("2-Urun Oluştur");
                System.out.println("3-Urun Sil");
                System.out.println("4-Urun Düzenle");
                System.out.println("5-Kategori Filtrele");
                System.out.println("6-Marka Filtrele");
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
                case 5:
                    kategoriFiltrele();
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

        } while (true);
    }
    public void kategoriFiltrele() {
        Scanner scanner = new Scanner(System.in);
        int input;
        KategoriIslem ki = new KategoriIslem(kategoriListesi);
        while(true){
            try {
                System.out.println("Filtrelemek istediğiniz kategoriyi id sine göre seçiniz");
                ki.oku();
                input = scanner.nextInt();
                scanner.nextLine();
                Kategori kategori=ki.getCategoryByID(input);
                if(kategori==null){
                    System.out.println("bu id de kategori yok");
                    continue;
                }
                oku(kategori);
                break;
            }catch (Exception e) {
                System.out.println();
                System.out.println("Geçersiz Değer Girdiniz");
                System.out.println("Lütfen Geçerli Bir Değer Giriniz");
                System.out.println();
                scanner.nextLine(); //scanner temizleme
            }

        }


    }
    public void markaFiltrele() {
        Scanner scanner = new Scanner(System.in);
        int input;
        MarkaIslem mi = new KategoriIslem(markaListesi);
        while(true){
            try {
                System.out.println("Filtrelemek istediğiniz kategoriyi id sine göre seçiniz");
                mi.oku();
                input = scanner.nextInt();
                scanner.nextLine();
                Marka marka=mi.getBrandByID(input);
                if(marka==null){
                    System.out.println("bu id de kategori yok");
                    continue;
                }
                oku(marka);
                break;
            }catch (Exception e) {
                System.out.println();
                System.out.println("Geçersiz Değer Girdiniz");
                System.out.println("Lütfen Geçerli Bir Değer Giriniz");
                System.out.println();
                scanner.nextLine(); //scanner temizleme
            }

        }


    }

    @Override
    public void oku() {
        System.out.println();
        System.out.println("Ürünler:");
        for (Urun urun : liste) {
            if(!checkCategoryID(urun.getKategori().getId())){
                urun.setKategori(kategoriListesi.get(0));
            }
            if(!checkBrandID(urun.getMarka().getId())){
                urun.setMarka(markaListesi.get(0));
            }
            System.out.println("ID: " + urun.getId() + ", Ad: " + urun.getAd() + ",Fiyat: " + urun.getFiyat() +
                    ",Kategori: " + urun.getKategori().getAd() + ",Stok: " + urun.getStok() + ",Marka: " + urun.getMarka().getAd());

        }
        System.out.println();
        System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
    }
    public void oku(Kategori kategori){
        for (Urun urun:liste) {
            if(!checkCategoryID(urun.getKategori().getId())){
                urun.setKategori(kategoriListesi.get(0));
            }
            if(!checkBrandID(urun.getMarka().getId())){
                urun.setMarka(markaListesi.get(0));
            }

            if(urun.getKategori().getAd().equals(kategori.getAd()))
                System.out.println("ID: " + urun.getId() + ", Ad: " + urun.getAd() + ",Fiyat: " + urun.getFiyat() +
                        ",Kategori: " + urun.getKategori().getAd() + ",Stok: " + urun.getStok() + ",Marka: " + urun.getMarka().getAd());
        }
    }
    public void oku(Marka marka){
        for (Urun urun:liste) {
            if(!checkCategoryID(urun.getKategori().getId())){
                urun.setKategori(kategoriListesi.get(0));
            }
            if(!checkBrandID(urun.getMarka().getId())){
                urun.setMarka(markaListesi.get(0));
            }

            if(urun.getMarka().getAd().equals(marka.getAd()))
                System.out.println("ID: " + urun.getId() + ", Ad: " + urun.getAd() + ",Fiyat: " + urun.getFiyat() +
                        ",Kategori: " + urun.getKategori().getAd() + ",Stok: " + urun.getStok() + ",Marka: " + urun.getMarka().getAd());
        }
    }

    @Override
    public void olustur() {
        Scanner scanner = new Scanner(System.in);
        String ad, markaAd = null, kategoriAd = null;
        double fiyat;
        int stok, markaId, kategoriId;
        try {
            System.out.println("Eklemek istediğiniz ürünün ismini giriniz: ");
            ad = scanner.nextLine();
            System.out.println("Eklemek istediğiniz ürünün fiyatını giriniz: ");
            fiyat = scanner.nextDouble();
            System.out.println("Eklemek istediğiniz ürünün stok adetini giriniz: ");
            stok = scanner.nextInt();
            System.out.println("Eklemek istediğiniz ürünün marka idsini giriniz: ");
            markaId = scanner.nextInt();
            scanner.nextLine(); //scanner temizleyici
            for (Marka marka : markaListesi) {
                if (markaId == marka.getId()) {
                    System.out.println("Eklemek istediğiniz ürünün kategori idsini giriniz: ");
                    kategoriId = scanner.nextInt();
                    scanner.nextLine(); // scanner temizleyici
                    for (Kategori kategori : kategoriListesi) {
                        if (kategoriId == kategori.getId()) {
                            markaAd = marka.getAd();
                            kategoriAd = kategori.getAd();
                            Urun urun = new Urun(ad, fiyat, stok, marka, kategori);
                            liste.add(urun);
                            System.out.println();
                            System.out.println("'" + ad + "' Ürünü " + markaAd + " Markasına ve " + kategoriAd + " Kategorisine Eklendi");
                            System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
                            System.out.println();
                            return;
                        }
                    }
                    break;
                }
            }
        System.out.println("Geçersiz ID girdiniz");
        System.out.println("İşlem iptal ediliyor");
        }catch (Exception e){
            System.out.println("Geçersiz Değer Girdiniz");
            System.out.println("İşlem iptal ediliyor");
            System.out.println();
            scanner.nextLine(); //scanner temizleme
        }
    }

    @Override
    public void sil() {
        Scanner scanner = new Scanner(System.in);
        int id;
        try {
            System.out.println("Silmek istediğiniz markanın idsini giriniz: ");
            id = scanner.nextInt();
            scanner.nextLine(); //scanner temizleme
            for (Urun urun : liste) {
                if (id == urun.getId()) {
                    System.out.println("'" + urun.getAd() + "' Ürünü silindi");
                    System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
                    System.out.println();
                    liste.remove(urun);
                    return;
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
        String ad;
        int input,markaId,kategoriId;
        try {
        System.out.println("Düzenlemek istediğiniz ürünün idsini giriniz:  ");
            input = scanner.nextInt();
            scanner.nextLine(); //scanner temizleme
            for (Urun urun : liste) {
                if (urun.getId() == input) {
                    System.out.println("Yeni ismi giriniz: ");
                    urun.setAd(scanner.nextLine());
                   System.out.println("Yeni fiyatı giriniz: ");
                   urun.setFiyat(scanner.nextInt());
                   System.out.println("Yeni stok adetini giriniz: ");
                   urun.setStok(scanner.nextInt());
                   System.out.println("Yeni markanın idsini giriniz: ");
                   markaId =scanner.nextInt();
                    for (Marka marka : markaListesi) {
                        if (markaId == marka.getId()) {
                            urun.setMarka(marka);
                            System.out.println("Yeni kategorinin idsini giriniz: ");
                            kategoriId = scanner.nextInt();
                            scanner.nextLine(); // scanner temizleyici
                            for (Kategori kategori : kategoriListesi) {
                                if (kategoriId == kategori.getId()) {
                                    urun.setKategori(kategori);
                                    System.out.println();
                                    System.out.println("Urun '" + urun.getAd() + "' olarak düzenlendi.");
                                    System.out.println("Bir Önceki Menüye Yönlendiriliyorsunuz.");
                                    System.out.println();
                                    return;
                                }
                            }
                            break;
                        }
                    }
                }
            }
                System.out.println();
                System.out.println("Geçersiz ID girdiniz.");
                System.out.println("İşlem iptal ediliyor");
        } catch (Exception e) {
            System.out.println("Geçersiz Değer girdiniz");
            System.out.println("İşlem iptal ediliyor");
            scanner.nextLine(); //scanner temizleme
        }

    }
    public boolean checkCategoryID(int id) {
        for (Kategori i : kategoriListesi) {
            if (id == i.getId())
                return true;
        }
        return false;
    }
    public boolean checkBrandID(int id) {
        for (Marka i : markaListesi) {
            if (id == i.getId())
                return true;
        }
        return false;
    }
}
