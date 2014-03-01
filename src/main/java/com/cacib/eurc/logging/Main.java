package com.cacib.eurc.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Main.class);
		logger.debug("Hello world.");
		
		// print internal state
	    /*LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	    StatusPrinter.print(lc);*/
	}

}