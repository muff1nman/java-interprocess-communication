package edu.mines.andrewdemaria.testing.processes;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OutputEater implements Runnable {
	
	static Logger logger = LogManager.getLogger(OutputEater.class.getName());

	
	private BufferedReader outputOfProcess;
	
	private boolean processStopped = false;
	
	public OutputEater(BufferedReader outputOfProcess) {
		this.outputOfProcess = outputOfProcess;
	}
	
	public void finish() {
		logger.debug("Informing eater to finsih");
		this.processStopped = true;
		try {
			logger.debug("Closing stream");
			outputOfProcess.close();
		} catch (IOException e) {
			logger.error("Could not close stream");
			e.printStackTrace();
		}
	}

	public void run() {
		String line;
		try {
			while ((line = outputOfProcess.readLine ()) != null && !processStopped) {
			    System.out.println ("Stdout: " + line);
			}
		} catch (IOException e) {
			logger.error("Could not read from stream");
		}
	}

}
