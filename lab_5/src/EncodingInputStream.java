

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class EncodingInputStream extends FilterInputStream {
    private int offset;
    protected EncodingInputStream(InputStream in, int offset) {
        super(in);
        this.offset = offset;
    }

    public int read() throws IOException {
        int result;
        if((result = super.read()) == -1){
            return -1;
        }else{
            return result + offset;
        }
    }

    public int decode(int readByte){
        if(readByte != -1) {
            return readByte - offset;
        } else
            return -1;
    }

    public static void demonstrateEncoding(){
        Scanner reader = new Scanner(System.in);
        String filePath = WorkingWithFiles.inputFilePath();
        try(EncodingInputStream encode = new EncodingInputStream(
                Files.newInputStream(Paths.get(filePath)),3))
        {
            StringBuilder encoded = new StringBuilder();
            StringBuilder decoded = new StringBuilder();
            int data;
            while((data = encode.read()) != -1)
            {
                encoded.append((char) data);
                decoded.append((char) encode.decode(data));
            }
            System.out.println("Encoded:\n" + encoded + "\nDecoded:\n" + decoded);
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
