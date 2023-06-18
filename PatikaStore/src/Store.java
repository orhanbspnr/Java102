import java.util.ArrayList;
import java.util.Scanner;


public class Store {
    Scanner scan = new Scanner(System.in);


    public void addNotebook(ArrayList<Notebook> notebooks){

        System.out.println("id =");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("name =");
        String name = scan.nextLine();
        System.out.println("Fiyat =");
        int price = scan.nextInt();
        System.out.println("Marka Seçiniz : ");
        System.out.println("1- Apple\n " + " 2- Asus\n " + "3- Casper\n " + "4- HP\n" +
                "5- Huawei\n " + "6- Lenovo\n " + "7- Monster\n " + "8- Samsung\n " + "9- Xiaomi");
        System.out.println("Marka =");
        Brand brand;
        int choose = scan.nextInt();
        switch (choose){
            case 1:
                brand = new Brand(1,"Apple");
                break;
            case 2:
                brand = new Brand(2,"Asus");
                break;
            case 3:
                brand = new Brand(3,"Casper");
            case 4:
                brand = new Brand(4,"HP");
            case 5:
                brand = new Brand(5,"Huawei");
            case 6:
                brand = new Brand(6,"Lenovo");
            case 7:
                brand = new Brand(7,"Monster");
            case 8:
                brand = new Brand(8,"Samsung");
            case 9:
                brand = new Brand(9,"Xiaomi");
            default:
                brand = new Brand(1,"Apple");
        }

        System.out.println("Depolama =");
        int storage = scan.nextInt();
        Scanner input = new Scanner(System.in);
        System.out.println("Ekran =");
        double screen = scan.nextDouble();
        System.out.println("indirim");
        double discount = 0;
        System.out.println("Stok =");
        int stock = scan.nextInt();
        System.out.println("Ram =");
        int ram = scan.nextInt();
        notebooks.add(3,new Notebook(id,name,price,brand,storage,screen,discount,stock,ram));
    }

    public void deleteNotebook(ArrayList<Notebook> notebooks){

        System.out.println("Silmek istediğiniz notebook'un id numarasını giriniz :");
        int choose = scan.nextInt();
        notebooks.remove(choose-1);
        System.out.println(choose-1 + " idli notebook silindi.");
    }
    public void addMobilePhone(ArrayList<MobilePhone> mobilePhones){

        System.out.println("id =");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("name =");
        String name = scan.nextLine();
        System.out.println("Fiyat =");
        int price = scan.nextInt();
        System.out.println("Marka Seçiniz : ");
        System.out.println("1- Apple\n " + " 2- Asus\n " + "3- Casper\n " + "4- HP\n" +
                "5- Huawei\n " + "6- Lenovo\n " + "7- Monster\n " + "8- Samsung\n " + "9- Xiaomi");
        System.out.println("Marka =");
        Brand brand;
        int choose = scan.nextInt();
        switch (choose){
            case 1:
                brand = new Brand(1,"Apple");
                break;
            case 2:
                brand = new Brand(2,"Asus");
                break;
            case 3:
                brand = new Brand(3,"Casper");
            case 4:
                brand = new Brand(4,"HP");
            case 5:
                brand = new Brand(5,"Huawei");
            case 6:
                brand = new Brand(6,"Lenovo");
            case 7:
                brand = new Brand(7,"Monster");
            case 8:
                brand = new Brand(8,"Samsung");
            case 9:
                brand = new Brand(9,"Xiaomi");
            default:
                brand = new Brand(1,"Apple");
        }

        System.out.println("Depolama =");
        int storage = scan.nextInt();
        Scanner input = new Scanner(System.in);
        System.out.println("Ekran =");
        double screen = scan.nextDouble();
        System.out.println("indirim");
        double discount = 0;
        System.out.println("Stok =");
        int stock = scan.nextInt();
        System.out.println("Ram =");
        int ram = scan.nextInt();
        System.out.println("Batarya =");
        int battery = scan.nextInt();
        scan.nextLine();
        System.out.println("Renk = ");
        String color = scan.nextLine();
        mobilePhones.add(3,new MobilePhone(id,name,price,brand,storage,screen,discount,stock,ram,battery,color));
    }
    public void deleteMobilePhone(ArrayList<MobilePhone> mobilePhones){

        System.out.println("Silmek istediğiniz notebook'un id numarasını giriniz :");
        int choose = scan.nextInt();
        mobilePhones.remove(choose-1);
        System.out.println(choose-1 + " idli telefon silindi.");
    }


}


