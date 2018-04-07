package com.learning.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.learning.mockito_tutorial.DatabaseInterface;
import com.learning.mockito_tutorial.SentenceOfADay;
import com.learning.mockito_tutorial.ServerInterface;

public class SentenceOfADay_Test {
	DatabaseForTest databaseForTest;
	ServerInterface serverForTest;
	SentenceOfADay sentenseOfADay;
	
	@Before
	public void setup() {
		databaseForTest = new DatabaseForTest();
		serverForTest = new ServerForTest();
		sentenseOfADay = new SentenceOfADay(databaseForTest, serverForTest);
	}
	
	private class DatabaseForTest implements DatabaseInterface{
		public boolean testResult = true;

		public boolean has(String sentence) {
			return testResult;
		}
		
		public void open(String username, String password) {}
	}
	
	private class ServerForTest implements ServerInterface{

		public String getTodaysSentence()
		{
			return "Todays sentence";
		}
		
	}
	
	@Test
	public void getSentence_sentenceInDatabase_returnNothingNew() {
		assertEquals(SentenceOfADay.sentenceIsInDatabase, sentenseOfADay.getSentence());
		
	}
	
	@Test
	public void getSentence_sentenceIsntDatabase_returnSentence() {
		databaseForTest.testResult = false;
		assertEquals(serverForTest.getTodaysSentence(), sentenseOfADay.getSentence());
		
	}

}
