package com.learning.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import com.learning.mockito_tutorial.DatabaseInterface;
import com.learning.mockito_tutorial.SentenceOfADay;
import com.learning.mockito_tutorial.ServerInterface;

public class SentenceOfADay_Test {
	@Mock
	DatabaseInterface databaseForTest;
	@Mock
	ServerInterface serverForTest;
	SentenceOfADay sentenseOfADay;
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setup() {
		sentenseOfADay = new SentenceOfADay(databaseForTest, serverForTest);
	}
	
	
	@Test
	public void getSentence_sentenceInDatabase_returnNothingNew() {
		when(serverForTest.getTodaysSentence()).thenReturn("Hello");
		when(databaseForTest.has("Hello")).thenReturn(true);

		assertEquals(SentenceOfADay.sentenceIsInDatabase, sentenseOfADay.getSentence());
		
		verify(databaseForTest, atLeastOnce()).has("Hello");
	}
	
	@Test
	public void getSentence_sentenceIsntDatabase_returnSentence() {
		when(serverForTest.getTodaysSentence()).thenReturn("Hello");
		when(databaseForTest.has("Hello")).thenReturn(false);
		
		assertEquals(serverForTest.getTodaysSentence(), sentenseOfADay.getSentence());

		verify(databaseForTest, atLeastOnce()).has("Hello");
	}

}
