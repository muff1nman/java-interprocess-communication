package edu.mines.andrewdemaria.testing.processes;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
	
	private static String MAIN_EXECUTOR = "edu.mines.andrewdemaria.testing.processes.App2";

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("Starting up another application");
        Process p;
		try {
			p = Runtime.getRuntime().exec(getProcessArguments());

			p.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done?");
    }
    
    public static String[] getProcessArguments() {
    	ArrayList<String> args = new ArrayList<String>();
		args.add("java");
		args.add("-cp");
		args.add(getClassPathArg());
		//args.add(DEBUG_ARGS);
		args.add(MAIN_EXECUTOR);
//		args.add(fullyQualifiedModuleName);
//		args.add(jarPath);
		return args.toArray(new String[args.size()]);
    }
    
	private static String getClassPathArg() {
		String toReturn = "";
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		 
        URL[] urls = ((URLClassLoader)cl).getURLs();
 
        for(URL url: urls){
        	toReturn += url.getFile() + File.pathSeparator;
        }
        
        return toReturn;
	}
}
