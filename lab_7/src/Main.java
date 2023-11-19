import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String inputString = "d Spring rereh Summer kjhg iuygbnj длгнпамиторп";

        String[] words = inputString.split(" ");

        List<String> wordList = Arrays.asList(words);

        List<String> result = filterWords(
                wordList,
                word -> word.matches("[a-zA-Z]+"),
                word -> countVowels(word) == countConsonants(word)
        );


        if (!result.isEmpty()) {
            System.out.println("Words with only Latin characters and equal vowels and consonants count:");
            for (String s : result) {
                System.out.println(s);
            }
        } else {
            System.out.println("no words :(");
        }
    }

    private static List<String> filterWords(List<String> words, Predicate<String> latinCondition, Predicate<String> countCondition) {
        return words.stream()
                .filter(latinCondition)
                .filter(countCondition)
                .collect(Collectors.toList());
    }

    private static long countVowels(String word) {
        return word.toLowerCase().chars().filter(ch -> "aeiou".indexOf(ch) != -1).count();
    }

    private static long countConsonants(String word) {
        return word.toLowerCase().chars().filter(ch -> "bcdfghjklmnpqrstvwxyz".indexOf(ch) != -1).count();
    }
}
