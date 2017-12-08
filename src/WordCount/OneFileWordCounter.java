package WordCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OneFileWordCounter extends Thread {
	private Path file;
	private int result;

	public OneFileWordCounter(Path file) {
		this.file = file;
	}

	public void run() {
		int count = 0;
		System.out.println("Start counting " + file);
		try (BufferedReader reader = Files.newBufferedReader(file)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				count += line.split(" ").length;
			}
			System.out.println(file.getFileName() + " has " + count + " words");
			result = count;
		} catch (IOException e) {
			System.out.println("Er is een fout opgetreden.");
		}
	}

	public int getResult() {
		return result;
	}
}
