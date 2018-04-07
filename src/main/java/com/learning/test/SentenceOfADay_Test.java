package com.learning.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.learning.mockito_tutorial.Database;
import com.learning.mockito_tutorial.SentenceOfADay;
import com.learning.mockito_tutorial.Server;

public class SentenceOfADay_Test {
	DatabaseForTest databaseForTest;
	ServerForTest serverForTest;
	SentenceOfADay sentenseOfADay;
	
	@Before
	public void setup() {
		databaseForTest = new DatabaseForTest();
		serverForTest = new ServerForTest();
		sentenseOfADay = new SentenceOfADay(databaseForTest, serverForTest);
	}
	
	private class DatabaseForTest extends Database{
		public boolean testResult = true;
		@Override
		public boolean has(String sentence) {
			return testResult;
		}
	}
	
	private class ServerForTest extends Server{

		public ServerForTest() {
			super("http://address.com");
		}
		
		@Override
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
