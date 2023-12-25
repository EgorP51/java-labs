
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UrlTagsCount {

    public static String getURLSource(String url) throws IOException {
        URL urlObject = new URL(url);
        URLConnection urlConnection = urlObject.openConnection();
        urlConnection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) " +
                        "Chrome/23.0.1271.95 Safari/537.11");

        return toString(urlConnection.getInputStream());
    }

    private static String toString(InputStream inputStream) throws IOException
    {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, "UTF-8")))
        {
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(inputLine);
            }

            return stringBuilder.toString();
        }
    }

    public static Map<String,Long> GetCountOfTags() throws IOException {
        System.out.print("Input URL: ");
        Scanner reader = new Scanner(System.in);
        String url = reader.nextLine();

        String content = getURLSource(url);

        return Arrays
                .stream(content.split("[' '>]"))
                .filter(s -> s.matches("<!?[a-zA-Z]+?"))
                .filter(s -> !s.contains("/"))
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        ));
    }

    public static void ShowByMode() throws IOException {
        System.out.println("1 - lexicographic order\n2 - by frequency");
        Scanner scanner = new Scanner(System.in);

        int integerValue = scanner.nextInt();

        switch (integerValue){
            case 1:
                GetCountOfTags().entrySet()
                        .stream()
                        .sorted(Map.Entry.<String,Long>comparingByKey())
                        .forEach(System.out::println);
                break;
            case 2:
                GetCountOfTags().entrySet()
                        .stream()
                        .sorted(Map.Entry.<String,Long>comparingByValue())
                        .forEach(System.out::println);
                break;
        }
    }

}
