package exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _1_WordFinder {

	public static void main(String[] args) {
		/* Print all the words beginning with P that are over 10 characters. */

		Stream<String> streamOfMessages = loadWordList().stream();

		Predicate<String> predicateLength = word -> word.length() > 10;
		Predicate<String> predicateFirstLetter = word -> word.charAt(0) == 'P';

		List<String> words = streamOfMessages.filter(predicateLength).filter(predicateFirstLetter)
				.collect(Collectors.toList());
		System.out.println(words);

	}

	public static List<String> loadWordList() {
		List<String> messages = new ArrayList<String>();
		File file = new File("resource/words.txt");

		try {
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String aLine;
			while ((aLine = buffer.readLine()) != null) {
				messages.add(aLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return messages;
	}

}