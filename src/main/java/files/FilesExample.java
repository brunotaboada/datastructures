package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author bruno.taboada
 */
public class FilesExample {

	@SuppressWarnings("unused")
	private void readWithScanner() {
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(Paths.get("pom.xml"), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				Scanner lineScanner = new Scanner(line);
				while (lineScanner.hasNext()) {
					String token = lineScanner.next();
					System.out.println(token); // you can do whatever you want // with the tokens
				}
				lineScanner.close();
			}
		} finally {
			fileScanner.close();
		}
	}

	public static void main(String[] args) {
		try (Stream<String> stream = Files.lines(Paths.get("pom.xml"))) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}