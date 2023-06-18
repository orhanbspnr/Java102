import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    Scanner scan = new Scanner(System.in);
    Store store;
    public void printBrands(ArrayList<Brand> brands){
    System.out.println("Markalarımız");
    System.out.println("--------------");
    for (Brand brand : brands){
        System.out.println(" - " + brand.getName());
    }
}
public void listNotebook(ArrayList<Notebook> notebooks){
    System.out.println("Notebook Listesi");
    System.out.println();
    String format = "| %-5s | %-20s | %-15s | %-10s | %-10s | %-15s |\n";
    System.out.format(format, "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran");
    for (Notebook n : notebooks) {
        System.out.format(format, n.getId(), n.getName(), n.getPrice() + " TL", n.getBrand().getName(), n.getStorage(),
                n.getScreen());
    }
}
public void listMobilePhone(ArrayList<MobilePhone> mobilePhones){
    System.out.println("Cep Telefonu Listesi");
    System.out.println();
    String format1 = "| %-5s | %-20s | %-15s | %-10s | %-10s | %-15s |\n";
    System.out.format(format1, "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran");
    for (MobilePhone m : mobilePhones) {
        System.out.format(format1, m.getId(), m.getName(), m.getPrice() + " TL", m.getBrand().getName(), m.getStorage(),
                m.getScreen());
    }
}
public void listProducts(ArrayList<Notebook> notebooks, ArrayList<MobilePhone> mobilePhones) {

    System.out.println("Notebook Listesi");
    System.out.println();
        String format = "| %-5s | %-20s | %-15s | %-10s | %-10s | %-15s |\n";
        System.out.format(format, "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran");
        for (Notebook n : notebooks) {
            System.out.format(format, n.getId(), n.getName(), n.getPrice() + " TL", n.getBrand().getName(), n.getStorage(),
                    n.getScreen());
        }
    System.out.println();
    System.out.println("Cep Telefonu Listesi");
    System.out.println();
    String format1 = "| %-5s | %-20s | %-15s | %-10s | %-10s | %-15s |\n";
    System.out.format(format1, "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran");
    for (MobilePhone m : mobilePhones) {
        System.out.format(format, m.getId(), m.getName(), m.getPrice() + " TL", m.getBrand().getName(), m.getStorage(),
                m.getScreen());
    }

    }
    public void listNotebookById(ArrayList<Notebook> notebooks){
        System.out.println("Listelenecek id numarasını giriniz :");
    int chooseid = scan.nextInt();
        System.out.println("Notebook Listesi");
        System.out.println();
        String format = "| %-5s | %-20s | %-15s | %-10s | %-10s | %-15s |\n";
        System.out.format(format, "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran");
        for (Notebook n : notebooks) {
            if(n.getId() == chooseid) {
                System.out.format(format, n.getId(), n.getName(), n.getPrice() + " TL", n.getBrand().getName(), n.getStorage(),
                        n.getScreen());
            }
    }
}
    public void listMobilePhoneById(ArrayList<MobilePhone> mobilePhones){
        System.out.println("Listelenecek id numarasını giriniz :");
        int chooseid = scan.nextInt();
        System.out.println("Cep Telefonu Listesi");
        System.out.println();
        String format1 = "| %-5s | %-20s | %-15s | %-10s | %-10s | %-15s |\n";
        System.out.format(format1, "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran");
        for (MobilePhone m : mobilePhones) {
            if (chooseid == m.getId()){
            System.out.format(format1, m.getId(), m.getName(), m.getPrice() + " TL", m.getBrand().getName(), m.getStorage(),
                    m.getScreen());
        }}
       }
    public void listNotebookByBrand(ArrayList<Notebook> notebooks){
        System.out.println("Listelenecek markanın adını yazınız :");
    String chooseBrand = scan.nextLine();
        System.out.println("Notebook Listesi");
        System.out.println();
        String format = "| %-5s | %-20s | %-15s | %-10s | %-10s | %-15s |\n";
        System.out.format(format, "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran");
        for (Notebook n : notebooks) {
            if(n.getBrand().getName().equalsIgnoreCase(chooseBrand)) {
                System.out.format(format, n.getId(), n.getName(), n.getPrice() + " TL", n.getBrand().getName(), n.getStorage(),
                        n.getScreen());
            }
        }

    }
    public void listMobilePhoneByBrand(ArrayList<MobilePhone> mobilePhones){
        System.out.println("Listelenecek markanın adını yazınız :");
        String chooseBrand = scan.nextLine();
        System.out.println("Cep Telefonu Listesi");
        System.out.println();
        String format1 = "| %-5s | %-20s | %-15s | %-10s | %-10s | %-15s |\n";
        System.out.format(format1, "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran");
        for (MobilePhone m : mobilePhones) {
            if (m.getBrand().getName().equalsIgnoreCase(chooseBrand))
            System.out.format(format1, m.getId(), m.getName(), m.getPrice() + " TL", m.getBrand().getName(), m.getStorage(),
                    m.getScreen());
        }
    }
}
