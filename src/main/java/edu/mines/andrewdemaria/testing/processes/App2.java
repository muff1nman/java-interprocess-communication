package edu.mines.andrewdemaria.testing.processes;

import java.util.Scanner;

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
		//getInput();
		logger.debug("Exiting main on other application");
	}
	
	public static void getInput() {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		logger.debug("Retreived this from user:" + s);
	}

}
