package com.learning.mockito_tutorial;

import java.nio.file.AccessDeniedException;

import com.learning.mockito_tutorial.Credentials;
import com.learning.mockito_tutorial.Database;
import com.learning.mockito_tutorial.Server;

public class SentenceOfADay {

	private Database database;
	private Server server;
	public final static String sentenceIsInDatabase = "Nothing new";

	public SentenceOfADay(Database databaseName, Server serverName) {
		database = databaseName;
		server = serverName;
	}

	public String getSentence() {
		String sentence = server.getTodaysSentence();
		if(database.has(sentence))
			return sentenceIsInDatabase;
		
		return sentence;
	}
}
