package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog4j {
	 static Logger logger = Logger.getLogger(TestLog4j.class);
	    public static void main(String[] args) throws InterruptedException {
	        PropertyConfigurator.configure("e:\\project\\mybatis\\src\\log4j.properties");
	        for (int i = 0; i < 50; i++) {
	            logger.trace("跟踪信息");
	            logger.debug("调试信息");
	            logger.info("输出信息");
	            logger.warn("警告信息");
	            logger.error("错误信息");
	            logger.fatal("致命信息");
	        }
	    }
}
