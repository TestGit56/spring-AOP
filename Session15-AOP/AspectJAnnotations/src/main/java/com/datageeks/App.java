package com.datageeks;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.datageeks.service.SampleService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	SampleService service = container.getBean(SampleService.class);
    	
    	System.out.println("\n\n BeforeAdvice :-");
    	
    	service.demo("HDFC", 1500f);
    	
    	System.out.println("\n\n AfterReturningAdvice :-");
    	service.order();
    	
    	System.out.println("\n\n AroundAdvice :-");
    	service.transfer();
    	
    	System.out.println("\n\n After or Finally Advice & AfterThrowing Advice :-");
    		try
    		{
    	service.testExp();
    		}catch(Exception exp) {}
    }
}
