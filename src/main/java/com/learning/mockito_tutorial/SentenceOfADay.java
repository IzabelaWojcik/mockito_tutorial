package com.learning.mockito_tutorial;

import java.nio.file.AccessDeniedException;

import com.learning.mockito_tutorial.Credentials;
import com.learning.mockito_tutorial.Database;
import com.learning.mockito_tutorial.Server;

public class SentenceOfADay {

	private Credentials credentialsDatabase;
	private Credentials credentialsServer;

	private Database database;
	private Server server;

	public SentenceOfADay() {
		credentialsDatabase = new Credentials("Stephanie", "abcde");

		database = new Database();
		database.open(credentialsDatabase.getUsername(), credentialsDatabase.getPassword());
		server = new Server("http://address.not.known");
	}

	public String getSentence() {
		String sentence = server.getTodaysSentence();
		if(database.has(sentence))
			return "Nothing new";
		
		return sentence;
	}
}
