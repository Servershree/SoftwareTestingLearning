package Listnerandscreenshot;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Listnerandscreenshot.Testcaseclass;
import Listnerandscreenshot.Screenshot1;



	public class Listners extends Testcaseclass implements ITestListener {

		@Override
		public void onTestStart(ITestResult result) {
			System.out.println("onTestStart");
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			System.out.println("onTestSuccess");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			Screenshot1 ref=new Screenshot1();
			try {
				ref.screenshot(driver,result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			System.out.println("onTestSkipped");
		}


}
