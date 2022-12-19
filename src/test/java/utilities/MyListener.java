package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {
	
	

	@Override
	public void onTestStart(ITestResult result) {
		try {
			MyScreenRecorder.startRecording(result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			MyScreenRecorder.stopRecording();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		CommonMethod.takeScreenshot(result.getMethod().getMethodName());
		try {
			MyScreenRecorder.stopRecording();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

	

}
