import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOCopy {
    public static void main(String... args) throws FileNotFoundException, IOException {
        FileReader reader = new FileReader("src/FileIO.java");
        FileWriter writer = new FileWriter("src/FileIOCopy.java");
        int code = reader.read();
        int lines = 0;
        while (code >= 0) {
            if (code == '\n')
                lines++;
            writer.write(code); //landet im Betriebssystem Puffer
            code = reader.read();
        }
        writer.close();
        System.out.println(lines + " lines");
    }
}
