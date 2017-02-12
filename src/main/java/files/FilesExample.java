package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author bruno.taboada
 */
public class FilesExample {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("pom.xml"))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}