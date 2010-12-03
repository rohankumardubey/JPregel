/**
 * 
 */
package system;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Manasa Chandrasekhar
 * @author Kowshik Prakasam
 *
 */
public class JPregelLogger {
	public static Logger getLogger(String id, String logFile) throws IOException {
		File logDir = new File(JPregelConstants.LOG_DIR);
		
		if(!logDir.exists() &&  !logDir.mkdirs()){
			throw new IOException("Can't create root log dir : "+JPregelConstants.LOG_DIR);
		}
		Logger aLogger = Logger.getLogger(id);
		//logger.setUseParentHandlers(false);
		Handler logHandle = null;
		try {
			logHandle = new FileHandler(logFile);
		} catch (SecurityException e) {
			System.err.println("Can't init logger in "+id);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Can't init logger in "+id);
			e.printStackTrace();
		}
		logHandle.setFormatter(new SimpleFormatter());
		aLogger.addHandler(logHandle);
		aLogger.info("init "+id+" Logger successful");
		return aLogger;
	}
}