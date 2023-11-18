import java.util.ArrayList;
import java.util.Scanner;

//Напишіть консольну програму, яка дозволяє створювати сутність "Запис в журналі куратора".
//        Для цього потрібно:
//        •	організувати введення даних з командної строки і передати результат введення у відповідну сутність;
//        •	перевіряти на правильність введення даних (зберігаючи правильно введені)
//        і в разі повної коректності всіх даних – передати їх до відповідного класу в моделі;
//        якщо дані не відповідають необхідному формату, то запропонувати повторне введення.
//        •	відображати всі записи журналу.
//        Сутність "Запис в журналі куратора" описана наступним набором:
//        •	прізвище студента;
//        •	ім'я студента;
//        •	дата народження студента;
//        •	телефон студента;
//        •	домашня адреса (вулиця, будинок, квартира).

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<StudentRecord> journal = new ArrayList<>();

        while (true) {
            int choice;

            while (true) {
                System.out.println("1. Ввести запись у журнал");
                System.out.println("2. Показати всі записи в журналі");
                System.out.println("3. Вийти");

                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice >= 1 && choice <= 3) {
                        break;
                    } else {
                        System.out.println("Некоректний вибір. Будь ласка, введіть число від 1 до 3:");
                    }
                } else {
                    System.out.println("Некоректний вибір. Будь ласка, введіть число від 1 до 3:");
                    scanner.nextLine();
                }
            }


            if (choice == 1) {
                StudentRecord record = JournalApp.createStudentRecord(scanner);
                journal.add(record);
            } else if (choice == 2) {
                JournalApp.displayJournal(journal);
            } else if (choice == 3) {
                System.out.println("Программа завершена");
                System.exit(0);
            } else {
                System.out.println("Некоректні данні");
            }
        }
    }
}
