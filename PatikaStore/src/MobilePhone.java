public class MobilePhone extends Product{
private int battery;
private String color;


    public MobilePhone(int id, String name, int price, Brand brand, int storage, double screen, double discount, int stock, int ram, int battery, String color) {
        super(id, name, price, brand, storage, screen, discount, stock, ram);
        this.battery = battery;
        this.color = color;

    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
