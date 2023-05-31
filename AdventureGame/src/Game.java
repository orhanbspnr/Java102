import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start() {
        System.out.println("Macera Oyununa hoş geldiniz");
        System.out.print("Lütfen bir isim giriniz :");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " hoşgeldiniz");
        System.out.print("Lütfen bir karakter seçiniz :");
        player.selectChar();
        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("##### Bölgeler #####");
            System.out.println("1- Güvenli Ev --> Burası gvenli düşman yok");
            System.out.println("2- Eşya dükkanı --> Silah veya zırh satın alabilirsiniz.");
            System.out.println("3- Mağara --> Ödül <yemek>, dikkatli ol karşına zombi çıkabilir.");
            System.out.println("4- Orman --> Ödül <odun>, dikkatli ol karşına vampir çıkabilir. ");
            System.out.println("5- Nehir --> Ödül <su>, dikkatli ol karşına ayı çıkabilir.");
            System.out.println("6- Maden --> Ödül <ganimet>, dikkatli ol karşına yılan çıkabilir.");
            System.out.println("0- Çıkış Yap --> Oyunu Sonlandır.");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz :");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    if (player.getInv().isFood()){
                        System.out.println("Mağaradaki düşmanları daha önce yendiniz. Artık buraya gidemezsiniz.");
                        location = new SafeHouse(player);
                    }
                    break;
                case 4:
                    location = new Forest(player);
                    if (player.getInv().isFirewood()){
                        System.out.println("Ormandaki düşmanları daha önce yendiniz. Artık buraya gidemezsiniz.");
                        location = new SafeHouse(player);
                    }
                    break;
                case 5:
                    location = new River(player);
                    if (player.getInv().isWater()){
                        System.out.println("Nehirdeki düşmanları daha önce yendiniz. Artık buraya gidemezsiniz.");
                        location = new SafeHouse(player);
                    }
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz.");
            }
            if (location.getClass().getName().equals("SafeHouse")) {
                if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
                    System.out.println("Tebrikler Oyunu Kazandınız !");
                    break;
                }
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER !");
                break;
            }

        }
    }
}


