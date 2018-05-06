import com.sun.org.apache.xpath.internal.operations.Or;
import humanResources.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        PartTimeEmployee partTimeEmployee1 = new PartTimeEmployee("Иван", "Иванов", JobTitlesEnum.AGENT, 36547);
        PartTimeEmployee partTimeEmployee2 = new PartTimeEmployee("Петр", "Петров", JobTitlesEnum.ENGINEER, 12137);
        StaffEmployee staffEmployee1 = new StaffEmployee("Вася", "Васечкин", JobTitlesEnum.ANALYST, 9587);
        StaffEmployee staffEmployee2 = new StaffEmployee("Ваня", "Ванечкин", JobTitlesEnum.ADMINISTRATOR, 14521);
        StaffEmployee staffEmployee3 = new StaffEmployee("Юля", "Юлина", JobTitlesEnum.DIRECTOR, 42513);
        Department department = new Department("класс 5А");
        department.add(partTimeEmployee1);
        department.add(partTimeEmployee2);
        department.add(staffEmployee1);
        department.add(staffEmployee2);
        department.add(staffEmployee3);

        PartTimeEmployee partTimeEmployee3 = new PartTimeEmployee("ghf", "Иванов", JobTitlesEnum.AGENT, 36547);
        PartTimeEmployee partTimeEmployee4 = new PartTimeEmployee("Пytgf", "Петров", JobTitlesEnum.ENGINEER, 12137);
        StaffEmployee staffEmployee4 = new StaffEmployee("sererd", "Васечкин", JobTitlesEnum.ANALYST, 9587);
        StaffEmployee staffEmployee5 = new StaffEmployee("buniop", "Ванечкин", JobTitlesEnum.ADMINISTRATOR, 14521);
        StaffEmployee staffEmployee6 = new StaffEmployee("teree", "Юлина", JobTitlesEnum.DIRECTOR, 42513);
        Department department2 = new Department("класс 5esfs");
        department2.add(partTimeEmployee3);
        department2.add(partTimeEmployee4);
        department2.add(staffEmployee4);
        department2.add(staffEmployee5);
        department2.add(staffEmployee6);

        System.out.println(department.toString());
        System.out.println(department2.toString());
    }
}
