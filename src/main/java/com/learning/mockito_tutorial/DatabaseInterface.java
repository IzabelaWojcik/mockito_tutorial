package com.learning.mockito_tutorial;

import java.util.concurrent.TimeUnit;

public interface DatabaseInterface {
	
	public boolean has(String sentence); 
	public void open(String username, String password); 
}
