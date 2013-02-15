package export2db;

import com.opensymphony.xwork2.ActionSupport;

import daoimpl.ToolDAOImpl;

import model.tools;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test extends ActionSupport{
	 static Logger logger = Logger.getLogger(test.class.getName());
	 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	 ToolDAOImpl tooldaoimpl= (ToolDAOImpl)context.getBean("ToolDAO");
	 //logger.appenderName = logFile;
	      
 
	
	public String sucess() throws Exception {
		DOMConfigurator.configure(Thread.currentThread().getContextClassLoader().getResource("log4j.xml"));
		System.out.println("hello world");
		tools t = new tools();
		tools t1 = tooldaoimpl.findById(1, true);
		//System.out.println(t.getName());
		t.setName("sj");
		//tooldaoimpl.update(t1);
		tooldaoimpl.save(t);
		//System.out.println(tooldaoimpl.getIdeaAmount());
	      //PropertyConfigurator.configure(args[0]);
	      logger.debug("Entering application.");
	      logger.info("Exiting application.");
        return "SUCESS";
    } 

}