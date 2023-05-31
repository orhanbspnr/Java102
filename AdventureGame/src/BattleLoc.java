import java.util.Random;

public abstract class BattleLoc extends Location{
   private Obstacle obstacle;
   protected String award;
   private int maxObstacle;
Random random = new Random();

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;

    }
    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli Ol! Burada " +obsNumber+ " tane "+ this.getObstacle().getName() + " yaşıyor.");
        System.out.print("<S>avaş veya <K>aç :");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)){
                System.out.println(this.getName() + " tüm düşmanları yendiniz.");
            if (this.award.equals("food") && player.getInv().isFood() == false) {
                System.out.println(this.award + " Kazandınız! ");
                player.getInv().setFood(true);
            } else if (this.award.equals("water") && player.getInv().isWater() == false) {
                System.out.println(this.award + " Kazandınız! ");
                player.getInv().setWater(true);
            } else if (this.award.equals("firewood") && player.getInv().isFirewood() == false) {
                System.out.println(this.award + " Kazandınız! ");
                player.getInv().setFirewood(true);
            }
            return true;
        }
        if (this.getPlayer().getHealth() <= 0){
            System.out.println("Öldünüz");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber){
        int firstAttack = random.nextInt(10)+1;
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.println("<V>ur veya <K>aç");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")){
                 if (firstAttack <= 5){
                     System.out.println("Siz vurdunuz!");
                     this.getObstacle().setHealth(this.getObstacle().getHealth() -this.getPlayer().getTotalDamage());
                     afterHit();
                     if (this.getObstacle().getHealth() > 0){
                         System.out.println();
                         System.out.println(this.getObstacle().getName() + " size vurdu");
                         int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInv().getArmor().getBlock();
                         if (obstacleDamage < 0){
                             obstacleDamage = 0;
                         }
                         this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                         afterHit();

                     }
                 }else {
                     System.out.println(this.getObstacle().getName() + " size vurdu");
                     int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInv().getArmor().getBlock();
                     if (obstacleDamage < 0){
                         obstacleDamage = 0;
                     }
                     this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                     afterHit();
                     if (this.getPlayer().getHealth() > 0){
                         System.out.println("Siz vurdunuz!");
                         this.getObstacle().setHealth(this.getObstacle().getHealth() -this.getPlayer().getTotalDamage());
                         afterHit();
                     }
                 }

                }else {
                    return false;
                }

            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz");
                if (this.getName().equals("Maden")){
                    int mineAward = random.nextInt(100);
                    if (mineAward < 15){
                        int awardWeapon = random.nextInt(100);
                        if (awardWeapon < 20){
                            player.getInv().setWeapon(new Weapon("Tüfek",3,7,45));
                            System.out.println("Tüfek Kazandınız.");
                        } else if (awardWeapon >= 20 && awardWeapon < 50) {
                            player.getInv().setWeapon(new Weapon("Kılıç",2,3,35));
                            System.out.println("Kılıç Kazandınız.");
                        }else {
                            player.getInv().setWeapon(new Weapon("Tabanca",1,2,15));
                            System.out.println("Tabanca Kazandınız.");
                        }
                    } else if (mineAward >= 15 && mineAward <30) {
                        int awardArmor = random.nextInt(100);
                        if (awardArmor < 20){
                            player.getInv().setArmor(new Armor(3,"Ağır",5,40));
                            System.out.println("Ağır Zırh Kazandınız.");
                        } else if (awardArmor >= 20 && awardArmor < 50) {
                            player.getInv().setArmor(new Armor(2,"Orta",3,25));
                            System.out.println("Orta Zırh Kazandınız.");
                        }else {
                            player.getInv().setArmor(new Armor(1,"Hafif",1,15));
                            System.out.println("Hafif Zırh kazandınız");
                        }
                    } else if (mineAward >= 30 && mineAward < 55) {
                        int awardMoney = random.nextInt(100);
                        if (awardMoney < 20){
                            player.setMoney(player.getMoney() + 10);
                            System.out.println("10 Para kazandınız");
                        } else if (awardMoney >= 20 && awardMoney < 50) {
                            player.setMoney(player.getMoney() + 5);
                            System.out.println("5 Para kazandınız");
                        }else {
                            player.setMoney(player.getMoney() + 1);
                            System.out.println("1 Para kazandınız");
                        }
                    }else {
                        System.out.println("Ödül kazanamadınız");
                    }
                }
                System.out.println(this.getObstacle().getAward() + " para kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());
            }else {
                return false;
            }

        }
        return true;
    }
    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println("-------");
    }
    public void playerStats(){
        System.out.println("Oyuncu Değerleri :");
        System.out.println("--------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInv().getWeapon().getName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh : " + this.getPlayer().getInv().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInv().getArmor().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println();
    }
    public void obstacleStats(int i){
        System.out.println(i + ". " +this.getObstacle().getName() + " Değerleri");
        System.out.println("--------------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getAward());
        System.out.println();



    }
    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.maxObstacle) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

}
