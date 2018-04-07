package com.learning.mockito_tutorial;

import com.learning.mockito_tutorial.SentenceOfADay;

public class App1 {
	private static Credentials credentialsDatabase;
	private Credentials credentialsServer;

	private static Database database;
	private static Server server;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		credentialsDatabase = new Credentials("Stephanie", "abcde");

		database = new Database();
		database.open(credentialsDatabase.getUsername(), credentialsDatabase.getPassword());
		server = new Server("http://address.not.known");
		
		SentenceOfADay sentenceOfADay = null;
		sentenceOfADay = new SentenceOfADay(database, server);
		String sentence = sentenceOfADay.getSentence();

		System.out.println(sentence);
	}

}
