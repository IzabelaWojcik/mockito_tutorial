package com.learning.mockito_tutorial;

import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Database {

	boolean opened = false;
	private Map<String, String> users;
	
	private List<String> sentences;

	public Database() {
		sentences = new LinkedList<String>();
		sentences.add("Never compare your weaknesses to other people’s strengths");
		sentences.add("We cannot change the cards we are dealt, just how we play the hand");
		sentences.add("No matter what anyone says to you, you don’t have to eat dinner with them, live with them, or go to bed with them");
		
		users = new HashMap<String, String>();
		users.put("Stephanie", "abcde");
		users.put("John", "12345");
	}

	public boolean has(String sentence) {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sentences.contains(sentence);
	}

	public void open(String username, String password) {
		if(!users.containsKey(username) || users.get(username) != password)
		{
			throw new IllegalAccessError("Invalid credentials");
		}
	}

}
