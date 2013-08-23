package edu.mines.andrewdemaria.testing.processes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App2 {
	
	static Logger logger = LogManager.getLogger(App2.class.getName());


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		logger.debug("Inside main on other application");
		System.out.println("Hi from second app!");
	}

}
