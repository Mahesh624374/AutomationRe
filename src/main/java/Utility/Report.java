package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	
	public static ExtentReports createReport()
	{
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
		
		ExtentReports reportes = new ExtentReports();
		reportes.attachReporter(htmlReporter);
		reportes.setSystemInfo("Regression","Zerodha");
		reportes.setSystemInfo("Browser","Chrome");
		
		return reportes ;

		
	}

}
