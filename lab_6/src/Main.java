import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        Scanner scanner = new Scanner(System.in);

        translator.addWordPair("hello", "привіт");
        translator.addWordPair("world", "світ");

        translator.fillDictionaryFromConsole();

        String englishInputPhrase;
        while (true){
            System.out.print("Введіть фразу англійською мовою: ");
            String inputPhrase = scanner.nextLine();

            if (!Translator.isValidPhrase(inputPhrase, "english")) {
                System.out.println("Неправильний формат англійської фрази.");
            }else {
                englishInputPhrase = inputPhrase;
                break;
            }
        }


        String translatedPhrase = translator.translatePhrase(englishInputPhrase);
        System.out.println("Переклад: " + translatedPhrase);

        scanner.close();
    }
}
