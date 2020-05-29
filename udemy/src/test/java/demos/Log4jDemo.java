package demos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	private static final Logger logger = LogManager.getLogger(Log4jDemo.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.trace("trace message");
		logger.info("info message");
		logger.warn("warn message");
		logger.debug("debug message");
		logger.error("error message");
		logger.fatal("fatal message");
	}

}
