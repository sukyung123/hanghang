package Hangman;
import java.util.Random;

class Words{
	private Random rand;
Words() {
	rand = new Random();
}
String getWord() {
	return words[rand.nextInt(words.length)];
}
String[] words = {
		"Korea", "Digital","Media", "Highschool", "strawberry",
		"desktop", "arrow", "moisture", "november", "cookie",
		"star", "chicken", "series", "movie", "access", "debug",
		"search", "project", "noodle"
};
}
