package HW6;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Set<Laptop> set = new HashSet<>();

        Laptop laptop1 = new Laptop();
        laptop1.setRam(4);
        laptop1.setHdd(256);
        laptop1.setOperatingSystem("Windows");
        laptop1.setColor("black");

        set.add(laptop1);

        Set<Laptop> filteredSet = new HashSet<>(set);

        laptopMenu(filteredSet);

        System.out.println("Результаты фильтрации:");
        for (Laptop laptop : filteredSet) {
            System.out.println(laptop);
        }
    }

    private static void laptopMenu(Set<Laptop> filteredSet) {
        Scanner scanner = new Scanner(System.in);
        boolean continueFiltering = true;

        while (continueFiltering) {
            System.out.println("Введите цифру, соответствующую необходимому фильтру:\n" +
                    "     1 - ОЗУ\n" +
                    "     2 - Объем ЖД\n" +
                    "     3 - Операционная система\n" +
                    "     4 - Цвет\n" +
                    "     5 - Завершить фильтрацию");
            System.out.print("Выбор: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введите минимальное значение ОЗУ (от 4 до 32): ");
                    int clientRam = scanner.nextInt();
                    filterByRam(filteredSet, clientRam);
                    break;

                case 2:
                    System.out.println("Введите минимальное значение объема жесткого диска (от 256 гБ до 2048 гБ): ");
                    int clientHdd = scanner.nextInt();
                    filterByHdd(filteredSet, clientHdd);
                    break;

                case 3:
                    System.out.println("Введите необходимую операционную систему (без ОС, macOS, Linux, Windows): ");
                    String clientOS = scanner.next();
                    filterByOperatingSystem(filteredSet, clientOS);
                    break;

                case 4:
                    System.out.println("Введите цвет (white, silver, black): ");
                    String clientColor = scanner.next();
                    filterByColor(filteredSet, clientColor);
                    break;

                case 5:
                    continueFiltering = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static void filterByRam(Set<Laptop> filteredSet, int minRam) {
        filteredSet.removeIf(laptop -> laptop.getRam() < minRam);
    }

    private static void filterByHdd(Set<Laptop> filteredSet, int minHdd) {
        filteredSet.removeIf(laptop -> laptop.getHdd() < minHdd);
    }

    private static void filterByOperatingSystem(Set<Laptop> filteredSet, String os) {
        filteredSet.removeIf(laptop -> !laptop.getOperatingSystem().equals(os));
    }

    private static void filterByColor(Set<Laptop> filteredSet, String color) {
        filteredSet.removeIf(laptop -> !laptop.getColor().equals(color));
    }
}