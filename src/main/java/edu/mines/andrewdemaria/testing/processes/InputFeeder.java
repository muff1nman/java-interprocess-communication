package edu.mines.andrewdemaria.testing.processes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputFeeder extends Thread {
	
	static Logger logger = LogManager.getLogger(InputFeeder.class.getName());

	private BufferedWriter processInputStream;
	private BufferedReader userInput;
	private boolean processFinished;

	public InputFeeder(BufferedWriter processInputStream) {
		this.processInputStream = processInputStream;
	}

	public void run() {
//		Scanner userInput = new Scanner(System.in);
		userInput = new BufferedReader(new InputStreamReader(System.in));
		//userInput = new BufferedInputStream(System.in);
		int nextChar;
		try {
			while ((nextChar = userInput.read()) != -1 && !processFinished) {
				logger.debug("Read in character: [" + (char) nextChar +"]");
				processInputStream.write( nextChar );
				processInputStream.flush();
			}	
			
		} 
		catch (IOException e) {
			logger.error("Could not write to stream");
		}

	}

	public void finish() {
		logger.debug("Finishing up feeding");
		processFinished = true;
		this.interrupt();
		try {
			System.in.close();
			logger.debug("Attempting to close streams");
			logger.debug("Closing process input stream");
			processInputStream.close();
			logger.debug("Closing std in stream");
			userInput.close();

		} catch (IOException e) {
			logger.error("Could not close streams");
		}
	}

}
