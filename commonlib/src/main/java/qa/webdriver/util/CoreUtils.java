package qa.webdriver.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.DecimalFormat;

public abstract class CoreUtils {

	public static Logger LOGGER = LoggerFactory.getLogger( "StaticLogger" );
	protected Logger classlogger = LoggerFactory.getLogger( getClass() );
	public static String separator = System.getProperty("file.separator");

	/**
	 * This can load a gradle resource, such as a .properties file.
	 * 
	 * @param fileName
	 * @return
	 */
	public static File loadGradleResource( String fileName ) {
		File junitFile = new File( fileName );
		if ( junitFile.exists() ) {
			LOGGER.info( "The file '" + junitFile.getAbsolutePath() + "' exists." );
		} else {
			LOGGER.info( "Problem loading Gradle resource: " + junitFile.getAbsolutePath() );
		}	
		return junitFile;
	}
	
	public static void waitTimer( int units, int mills ) {
    	DecimalFormat df = new DecimalFormat("###.##");
		double totalSeconds = ((double)units*mills)/1000;
		LOGGER.info("Explicit pause for " + df.format(totalSeconds) + " seconds divided by " + units + " units of time: ");
		try {
			Thread.currentThread();		
			int x = 0;
			while( x < units ) {
				Thread.sleep( mills );
				LOGGER.info(".");
				x = x + 1;
			}
		} catch ( InterruptedException ex ) {
			ex.printStackTrace();
		}	
	}

	protected CoreUtils() {
        // do nothing
	}

}
