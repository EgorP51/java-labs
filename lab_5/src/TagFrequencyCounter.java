import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class TagFrequencyCounter {
    public static Map<String, Integer> getTagFrequency(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements tags = document.select("*");

        Map<String, Integer> tagFrequencyMap = new HashMap();

        for (Element tag : tags) {
            String tagName = tag.tagName();
            tagFrequencyMap.put(tagName, tagFrequencyMap.getOrDefault(tagName, 0) + 1);
        }

        return tagFrequencyMap;
    }

    public static void printTagFrequencyLexicographical(Map<String, Integer> tagFrequencyMap) {
        TreeMap<String, Integer> sortedMap = new TreeMap(tagFrequencyMap);
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    public static void printTagFrequencyDescending(Map<String, Integer> tagFrequencyMap) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList(tagFrequencyMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
