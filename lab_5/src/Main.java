import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        do {
            System.out.println("1 - first task (the longest line)\n" +
                    "2 - third task (show encoding)\n" +
                    "3 - fourth task (count frequency of URL tags)");
            int integerValue = reader.nextInt();

            switch (integerValue) {
                case 1:
                    System.out.println(
                            WorkingWithFiles.GetTheLongestStringFromFile(
                                    WorkingWithFiles.inputFilePath()
                            )
                    );
                    break;
                case 2:
                    EncodingInputStream.demonstrateEncoding();
                    break;
                case 3:
                    UrlTagsCount.ShowByMode();
                    break;
                default:
                    break;
            }
            System.out.print("Enter n to stop working with books " +
                    "or any other input to continue\nYour choice: ");
        } while (reader.next().charAt(0) != 'n');
    }
}