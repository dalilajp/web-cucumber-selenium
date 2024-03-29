package util;

import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestRule {

	private static WebDriver webDriver;
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReport;
	private static ExtentTest extentTest;

	@Before
	public void beforeCenario(Scenario cenario) {
		Utils.deleteArquivo();
		if (extentReport == null) {
			extentReport = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter("src/test/resources/reports/Reporter.html");
			htmlReporter.config().setDocumentTitle("Relatório de Testes");
			htmlReporter.config().setReportName("Automação de Testes da Navegação no site amazon.com");
			htmlReporter.config().setEncoding("UTF-8");
			extentReport.attachReporter(htmlReporter);
		}
		extentTest = extentReport.createTest(cenario.getName());

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		webDriver = new ChromeDriver(options);
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.manage().window().maximize();
	}

	@After
	public void afterCenario(Scenario cenario) {
		if (cenario.isFailed()) {
			extentTest.log(Status.FAIL, "Cenario " + cenario.getName() + " executado com Falhas!");
			extentReport.flush();
			Utils.wait(2);
			Utils.efetuarPrintTela("Print erro Cenario " + cenario.getName());
		} else {
			extentTest.log(Status.PASS, "Cenario " + cenario.getName() + " executado com Sucesso!");
			extentReport.flush();
		}

		if (webDriver != null) {
			webDriver.quit();
		}
	}

	public static WebDriver getDriver() {
		return webDriver;
	}

	public static ExtentTest getExtentTest() {
		return extentTest;
	}
}