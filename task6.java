// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру.
//  Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию: 1 - ОЗУ
// // 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class task6 {

    public static void search(Set laptops) {

        HashMap<Integer, Object> map = new HashMap<>(); // создаем Маp для хранения запросов поиска
        Scanner iScanner = new Scanner(System.in);

        int param = 0;
        int v = 0;
        int s = 0;
        int c = 0;

        while (param != 4) {
            System.out.println(
                    "Какой параметр поиска желаете использовать? RAM - 1, OS - 2, color - 3, больше никакой - 4");
            param = iScanner.nextInt();
            switch (param) {
                case 1:
                    System.out.println("Введите минимальный требуемый объем памяти ");
                    int n = 1;
                    v = iScanner.nextInt();
                    map.put(n, v);
                    break;
                case 2:
                    System.out.println("Введите тип операционной системы: 1 - Windows, 2 - Ios, 3 - yandex. ");
                    s = iScanner.nextInt();
                    n = 2;
                    map.put(n, s);
                    break;
                case 3:
                    System.out.println("Введите цвет ноутбука: 6- blue, 7 -red, 8 - yellow, 9 - black, 10 -white ");
                    n = 3;
                    c = iScanner.nextInt();
                    map.put(n, c);
                    break;
                case 4:
                    break;
            }
        }
        iScanner.close();

        Laptop ls = new Laptop(); // создаем новый лаптоп-образец для сравнения с другими лаптопами.
        ls.id = 0;
        ls.Ram = v; // 0
        ls.OS = s; // 0
        ls.color = c; // 0

        int count = 0;
        System.out.println("Мы нашли для вас:");
        for (Object i : laptops) {
            if (i.equals(ls)) { // метод equals в классе Laptop переопределен под совпадение цвета и
                                // операционки, оперативка не ниже указанного в запросе значения.
                System.out.println(i);
                System.out.println("Таблица Операционных систем: 1 - Windows, 2 - Ios, 3 - yandex. Цвета: 6-blue, 7 -red, 8 - yellow, 9 - black, 10 -white ");
                count++;
            }
        }
        if (count == 0) {
            if (ls.Ram == 0 && ls.OS == 0 && ls.color == 0) {
                System.out.println("Вы не ввели ни одного критеря поиска! Покажем Вам все что есть на складе:");
                System.out.println();
                for (Object i : laptops) {
                    System.out.println(i);
                }
            } else {
                System.out.println("Нет вариантов удовлетворяющих вашему запросу. Попробуйте уточнить критерии поиска");
            }
        }

        if (ls.Ram != 0 && ls.OS == 0 | ls.color == 0) { // если не введны параметры операционой системы и цвет, то
                                                         // программа выдаст исключение
            System.out.println("Необходмио ввести обязательные параметры:  тип ОС и цвет корпуса!");
        }
    }

    public static void main(String[] args) {

        // Таблица Операционных систем: 1 - Windows, 2 - Ios, 3 - yandex.
        // Цвета: 6-blue, 7 -red, 8 - yellow, 9 - black, 10 -white
       

        Laptop l1 = new Laptop();
        l1.id = 3213321;
        l1.Ram = 230;
        l1.OS = 1; // "windows"
        l1.color = 6; // "blue"

        Laptop l2 = new Laptop();
        l2.id = 4321;
        l2.Ram = 250;
        l2.OS = 1;
        l2.color = 7; // "red"

        Laptop l3 = new Laptop();
        l3.id = 53423;
        l3.Ram = 260;
        l3.OS = 1;
        l3.color = 8; // "yellow"

        Laptop l4 = new Laptop();
        l4.id = 13214;
        l4.Ram = 280;
        l4.OS = 1;
        l4.color = 6;

        Laptop l5 = new Laptop();
        l5.id = 265876;
        l5.Ram = 290;
        l5.OS = 2; // "Ios"
        l5.color = 9; // "black"

        Laptop l6 = new Laptop();
        l6.id = 519256;
        l6.Ram = 340;
        l6.OS = 2;
        l6.color = 10; // "white"

        Laptop l7 = new Laptop();
        l7.id = 9867654;
        l7.Ram = 500;
        l7.OS = 3; // "yandex"
        l7.color = 6;

        var laptops = new HashSet<Laptop>(Arrays.asList(l1, l2, l3, l4, l5, l6, l7));
        try {
            search(laptops);
        } catch (Exception e) {
            System.out.println("Вводите только цифры от 0 до 10!");
        }
    }
}
