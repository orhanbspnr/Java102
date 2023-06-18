import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Brand apple = new Brand(1,"Apple");
        Brand asus = new Brand(2,"Asus");
        Brand casper = new Brand(3,"Casper");
        Brand hp = new Brand(4,"HP");
        Brand huawei = new Brand(5,"Huawei");
        Brand lenovo = new Brand(6,"Lenovo");
        Brand monster = new Brand(7,"Monster");
        Brand samsung = new Brand(8,"Samsung");
        Brand xiaomi = new Brand(9,"Xiaomi");

        Notebook matebook14 = new Notebook(1,"HUAWEI Matebook 14",7000,huawei,512,14.0,0,3,8);
        Notebook v14IGL = new Notebook(2,"LENOVO V14 IGL",3699,lenovo,1024,14.0,0,5,16);
        Notebook tufGaming = new Notebook(3,"ASUS Tuf Gaming",8199,asus,2048,15.6,0,4,4);

        MobilePhone galaxyA51 = new MobilePhone(1,"SAMSUNG GALAXY A51",3199,samsung,128,6.5,0,2,6,4000,"Siyah");
        MobilePhone iPhone1164Gb = new MobilePhone(2,"iPhone 11 64 GB",7379,apple,64,6.1,0,6,6,3046,"Mavi");
        MobilePhone redmiNote10Pro8Gb = new MobilePhone(3,"Redmi Note 10 Pro 8GB",4012,xiaomi,128,6.5,0,9,12,4000,"Beyaz");

        ArrayList<Notebook> notebooks = new ArrayList<>();
        notebooks.add(0,matebook14);
        notebooks.add(1,v14IGL);
        notebooks.add(2,tufGaming);

        ArrayList<MobilePhone> mobilePhones = new ArrayList<>();
        mobilePhones.add(0,galaxyA51);
        mobilePhones.add(1,iPhone1164Gb);
        mobilePhones.add(2,redmiNote10Pro8Gb);

        ArrayList<Brand> brands = new ArrayList<>();
        brands.add(apple);brands.add(asus);brands.add(casper);
        brands.add(hp);brands.add(huawei);brands.add(lenovo);
        brands.add(monster);brands.add(samsung);brands.add(xiaomi);
        Management management = new Management();
        Store store = new Store();

        while (true){
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri\n" +
                    "2 - Cep Telefonu İşlemleri\n" +
                    "3 - Marka Listele\n" +
                    "0 - Çıkış Yap\n");
            int choose = scan.nextInt();
            switch (choose){
                case 1 :
                    System.out.println("1-Notebook Listele\n " +
                            "2- Notebook Ekle :\n " +
                            "3- Notebook Sil\n " +
                            "4- Markaya göre Notebook Listele\n " +
                            "5- Id Numarasına Göre Notebook Listele");

                    int select = scan.nextInt();
                    switch (select) {
                        case 1: management.listNotebook(notebooks);
                            break;
                        case 2:
                            store.addNotebook(notebooks);
                            break;
                        case 3:
                            store.deleteNotebook(notebooks);
                            break;
                        case 4:
                            management.listNotebookByBrand(notebooks);
                            break;
                        case 5 :
                            management.listNotebookById(notebooks);
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1-Telefon Listele\n " +
                            "2- Telefon Ekle :\n " +
                            "3- Telefon Sil\n " +
                            "4- Markaya göre Telefon Listele\n " +
                            "5- Id Numarasına Göre Telefon Listele");
                    int select1 = scan.nextInt();
                    switch (select1){
                        case 1:
                            management.listMobilePhone(mobilePhones);
                            break;
                        case 2:
                            store.addMobilePhone(mobilePhones);
                            break;
                        case 3:
                            store.deleteMobilePhone(mobilePhones);
                            break;
                        case 4:
                            management.listMobilePhoneByBrand(mobilePhones);
                            break;
                        case 5:
                            management.listMobilePhoneById(mobilePhones);
                            break;
                    }
                    break;
                case 3 :
                    management.printBrands(brands);
                    break;
                case 0:
                    System.out.println("Çıkış Yapıldı");
                    System.exit(0);

                default:
                    System.out.println("Yanlış değer girdiniz.");



            }

        }








    }
}
