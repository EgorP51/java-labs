import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class JournalApp {
    static StudentRecord createStudentRecord(Scanner scanner) {
        System.out.println("Введіть данні студента:");

        System.out.print("Прізвище: ");
        String lastName = validateName(scanner);

        System.out.print("Ім'я: ");
        String firstName = validateName(scanner);

        System.out.print("Дата народження (рррр-мм-дд): ");
        String birthDate = validateDateOfBirth(scanner);

        System.out.print("Телефон: ");
        String phoneNumber = validatePhoneNumber(scanner);

        System.out.print("Домашня адреса (вулиця, будинок, квартира): ");
        String address = scanner.nextLine();

        return new StudentRecord(lastName, firstName, birthDate, phoneNumber, address);
    }

    static void displayJournal(ArrayList<StudentRecord> journal) {
        if (journal.isEmpty()) {
            System.out.println("Журнал пустий");
        } else {
            System.out.println("Записи в журналі:");
            System.out.println("* * *");
            for (StudentRecord record : journal) {
                System.out.println(record);
            }
            System.out.println("* * *");
        }
    }

    private static String validateName(Scanner scanner) {
        String name = scanner.nextLine().trim();
        if (name.matches("[a-zA-Zа-яА-ЯґєїіҐЄЇІ]+( [a-zA-Zа-яА-ЯґєїіҐЄЇІ]+)?")) {
            return name;
        } else {
            System.out.println("Невалідне значення, спробуйте знову");
            return validateName(scanner);
        }
    }

    private static String validateDateOfBirth(Scanner scanner) {
        String date = scanner.nextLine();

        if (isValidDate(date)) {
            return date;
        } else {
            System.out.println("Дата невалідна, спробуйте знову");
            return validateDateOfBirth(scanner);
        }
    }

    private static boolean isValidDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            return isValidRange(year, 1960, 2023) && isValidRange(month, 1, 12) && isValidRange(day, 1, 31);
        } catch (ParseException e) {
            return false;
        }
    }

    private static boolean isValidRange(int value, int minValue, int maxValue) {
        return value >= minValue && value <= maxValue;
    }

    private static String validatePhoneNumber(Scanner scanner) {
        String phoneNumber = scanner.nextLine();
        if (phoneNumber.matches("\\+380\\d{9}")) {
            return phoneNumber;
        } else {
            System.out.println("Номер телефона невалідний, спробуйте знову");
            return validatePhoneNumber(scanner);
        }
    }
}
