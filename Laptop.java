// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру.
//  Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию: 1 - ОЗУ
// // 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
public class Laptop {
    int id;
    int Ram;
    int OS;
    int color;

    @Override 
    public String toString() {
        return String.format("id: %d, оперативная память: %d Mb, операционная система - %s, цвет - %s \n", id, Ram, OS, color);

    }

    @Override
    public boolean equals(Object obj) {
        Laptop l = (Laptop) obj;
        return  color == l.color && Ram > l.Ram && OS == l.OS;
    }

    @Override
    public int hashCode() {
        return id;
    }
}