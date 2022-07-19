package TestNG;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Parameter.Dataproviderdemo1;

import selenium.Captureshots;

public class ListenerClass extends ListenersDemo implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		System.out.println("on start method invoked");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("name of method start:"+result.getMethod());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("name of test method pass:"+result.getMethod());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("name of test method fail:"+result.getMethod());
		     String name= result.getName();
		
		Captureshots sc=new  Captureshots();
		 try {
			sc.screenshot(driver,name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		System.out.println("name of test method skipped:"+result.getMethod());

	}

	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("finish");
	}

	
	
	
	
	
	
	
	
	
	
}
