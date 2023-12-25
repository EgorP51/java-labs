import java.io.*;
import java.util.Scanner;

public class WorkingWithFiles {

    public static String GetTheLongestStringFromFile(String filePath)  {
        try (BufferedReader fileReader = new BufferedReader(
                new FileReader(filePath))) {
            String longestLine;
            if ((longestLine = fileReader.readLine()) == null){
                System.out.println("File is empty");
                return null;
            }
            String currentLine;
            while((currentLine = fileReader.readLine()) != null) {
                if(longestLine.split(" ").length < currentLine.split(" ").length){
                    longestLine = currentLine;
                }
            }
            return longestLine;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String inputFilePath(){
        Scanner reader = new Scanner(System.in);
        String filePath = "src/test.txt";
        System.out.print("Enter path to file or leave empty to use default " +
                "(" + filePath + ")\nFile path: ");
        String temp = reader.nextLine();
        return temp.isEmpty() ? filePath : temp;
    }
}
