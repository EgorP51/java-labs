import java.util.HashMap;
import java.util.Scanner;

class Translator {
    private final HashMap<String, String> dictionary;

    public Translator() {
        this.dictionary = new HashMap<>();
    }

    public void addWordPair(String englishWord, String ukrainianTranslation) {
        dictionary.put(englishWord, ukrainianTranslation);
    }

    public String translatePhrase(String phrase) {
        StringBuilder translatedPhrase = new StringBuilder();
        String[] words = phrase.split(" ");

        for (String word : words) {
            if (dictionary.containsKey(word)) {
                translatedPhrase.append(dictionary.get(word)).append(" ");
            } else {
                translatedPhrase.append(word).append(" ");
            }
        }

        return translatedPhrase.toString().trim();
    }

    public void fillDictionaryFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Додавання слів у словник (для завершення залиште англійське слово порожнім):");

        while (true) {
            System.out.print("Введіть англійське слово: ");
            String englishWord = scanner.nextLine().trim();

            if (englishWord.isEmpty()) {
                break;
            } else if (!isValidWord(englishWord, "english")) {
                System.out.println("Неправильний формат англійського слова. Спробуйте ще раз.");
                continue;
            }

            System.out.print("Введіть український переклад: ");
            String ukrainianTranslation = scanner.nextLine().trim();

            if (ukrainianTranslation.isEmpty()) {
                System.out.println("Будь ласка, введіть український переклад.");
                continue;
            } else if (!isValidWord(ukrainianTranslation, "ukrainian")) {
                System.out.println("Неправильний формат українського перекладу. Спробуйте ще раз.");
                continue;
            }

            addWordPair(englishWord, ukrainianTranslation);
        }
    }

    private boolean isValidWord(String word, String language) {
        if (language.equalsIgnoreCase("ukrainian")) {
            return word.matches("[а-яА-ЯґҐєЄіІїЇ]+");
        } else if (language.equalsIgnoreCase("english")) {
            return word.matches("[a-zA-Z]+");
        } else {
            return false;
        }
    }

    public static boolean isValidPhrase(String phrase, String language) {
        if (language.equalsIgnoreCase("english")) {
            return phrase.matches("[a-zA-Z\\s]+");
        } else {
            return false;
        }
    }
}
