package HW6;

public class Laptop {
    private int ram;
    private int hdd;
    private String os;
    private String color;

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getOperatingSystem() {
        return os;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.os = operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Объем опреативной памяти: " + ram + " Объем жесткого диска: " + hdd + " Операционная система: " + os + " Цвет: " + color;
    }
}
