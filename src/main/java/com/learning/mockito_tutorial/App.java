package com.learning.mockito_tutorial;

public class App {

	public static void main(String[] args) {
		SentenceOfADay sentenceOfADay = null;
		sentenceOfADay = new SentenceOfADay();
		String sentence = sentenceOfADay.getSentence();

		System.out.println(sentence);

	}

}
