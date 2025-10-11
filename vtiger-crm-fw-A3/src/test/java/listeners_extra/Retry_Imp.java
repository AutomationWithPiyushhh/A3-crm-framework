package listeners_extra;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_Imp implements IRetryAnalyzer {
	
	int count = 0;
	int initCount = 5;	
	
	@Override
	public boolean retry(ITestResult result) {
		if(count < initCount) {
			count++;
			return true;
		}else {
			return false;
		}
	}
}
