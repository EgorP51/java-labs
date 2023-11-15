import java.util.ArrayList;
import java.util.Scanner;

/*
3) Знайти ті слова, які містять тільки символи латинського алфавіту.
Серед них знайти ті слова, які містять рівну кількість голосних та приголосних.
На вхід поступає рядок із словами. На виході – масив String.
*/

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введіть рядок із словами:");
//        String inputString = scanner.nextLine();

        String inputString = "d Spring Summer kjhg iuygbnj длгнпамиторп";

        String[] words = inputString.split("\\s+");

        ArrayList<String> resultWords = findLatinWordsWithEqualVowelsAndConsonants(words);


        if (resultWords.size() > 0) {
            System.out.println("\nСлова, що містять тільки символи латинського алфавіту та мають рівну кількість голосних та приголосних:");

            for (String word : resultWords) {
                System.out.println(word);
            }
        } else {
            System.out.println("\nНема :(");
        }
    }

    private static ArrayList<String> findLatinWordsWithEqualVowelsAndConsonants(String[] words) {
        ArrayList<String> result = new ArrayList<>();

        for (String word : words) {
            if (containsOnlyLatinCharacters(word)) {
                System.out.println("Слово {" + word + "} містить тільки символи латинського алфавіту");
                if (hasEqualVowelsAndConsonants(word)) {
                    result.add(word);
                }
            }
        }

        return result;
    }

    private static boolean containsOnlyLatinCharacters(String word) {
        return word.matches("[a-zA-Z]+");
    }

    private static boolean hasEqualVowelsAndConsonants(String word) {
        int vowels = 0;
        int consonants = 0;

        for (char ch : word.toLowerCase().toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if (Character.isLetter(ch)) {
                consonants++;
            }
        }

        return vowels == consonants;
    }
}
