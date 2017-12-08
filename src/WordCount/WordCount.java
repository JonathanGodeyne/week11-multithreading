package WordCount;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordCount {

	public static void main(String[] args) {
		Path dir = Paths.get("Folder");
		List<OneFileWordCounter> allThreads = new ArrayList<>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path file : stream) {
				OneFileWordCounter thread = new OneFileWordCounter(file);
				thread.start();
				allThreads.add(thread);
			}
		} catch (IOException | DirectoryIteratorException x) {
			System.err.println(x);
		}
		
		int total = 0;
		try {
			for(OneFileWordCounter thread : allThreads) {
				thread.join();
				total +=thread.getResult();
			}
			System.out.println("Total word count: "+total);
		}catch(InterruptedException x) {
			System.err.println(x);
		}

	}

}
