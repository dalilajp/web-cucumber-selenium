package util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Utils {

	public static String formatarNomeLog(String strLog) {
		LocalDateTime dataHoraAgora = LocalDateTime.now();
		DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd_MM_yy_HH_mm_SS");
		String strLogFormatado = strLog + "_" + dataHoraAgora.format(formatoDataHora);
		return strLogFormatado;
	}

	public static void logPrint(String strLog) {
		String strLogFormatado = formatarNomeLog(strLog);
		ExtentTest extentTest = TestRule.getExtentTest();
		efetuarPrintTela(strLogFormatado);
		try {
			extentTest.log(Status.INFO, strLog,	MediaEntityBuilder
					.createScreenCaptureFromPath("src/test/resources/reports/prints/" + strLogFormatado + ".png")
							.build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void efetuarPrintTela(String strLog) {
		File scrFile = ((TakesScreenshot) TestRule.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("src/test/resources/reports/prints/" + strLog + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void logPass(String strMensagem) {
		ExtentTest extentTest = TestRule.getExtentTest();
		extentTest.log(Status.PASS, strMensagem);
	}

	public static void logFail(String strMensagem) {
		ExtentTest extentTest = TestRule.getExtentTest();
		extentTest.log(Status.FAIL, strMensagem);
	}

	public static void wait(int intSegundos) {
		try {
			synchronized (TestRule.getDriver()) {
				TestRule.getDriver().wait(intSegundos * 1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void deleteArquivo() {
		String pastaImagens = "src/test/resources/reports/prints/";

		File pasta = new File(pastaImagens);
		if (pasta.isDirectory()) {
			File[] sun = pasta.listFiles();
			for (File toDelete : sun) {
				toDelete.delete();
			}
		}
	}
}