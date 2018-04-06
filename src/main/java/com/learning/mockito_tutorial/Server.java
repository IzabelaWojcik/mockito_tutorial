package com.learning.mockito_tutorial;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.*;

public class Server {

	private String address;
	Calendar calendar;
	
	Map<Integer, String> sentences;
	
	public Server(String address) {
		if(!Pattern.matches("http://.+\\..+", address))
		{
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
		
		calendar = Calendar.getInstance();
		sentences = new HashMap<Integer, String>();
		sentences.put(Calendar.MONDAY, "Never compare your weaknesses to other people’s strengths");
		sentences.put(Calendar.TUESDAY, "Yesterday I was clever, so I wanted to change the world. Today I am wise, so I am changing myself");
		sentences.put(Calendar.WEDNESDAY, "Your childhood may not have been perfect, but it’s over");
		sentences.put(Calendar.THURSDAY, "Own your life, or someone will own it for you");
		sentences.put(Calendar.FRIDAY, "We cannot change the cards we are dealt, just how we play the hand");
		sentences.put(Calendar.SATURDAY, "The world does not reward perfectionists. It rewards those who get things done");
		sentences.put(Calendar.SUNDAY, "No matter what anyone says to you, you don’t have to eat dinner with them, live with them, or go to bed with them");
	}

	public String getTodaysSentence()
	{
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sentences.get(day);
	}
}
