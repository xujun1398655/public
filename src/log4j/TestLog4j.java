package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog4j {
	 static Logger logger = Logger.getLogger(TestLog4j.class);
	    public static void main(String[] args) throws InterruptedException {
	        PropertyConfigurator.configure("e:\\project\\mybatis\\src\\log4j.properties");
	        for (int i = 0; i < 50; i++) {
	            logger.trace("������Ϣ");
	            logger.debug("������Ϣ");
	            logger.info("�����Ϣ");
	            logger.warn("������Ϣ");
	            logger.error("������Ϣ");
	            logger.fatal("������Ϣ");
	        }
	    }
}
