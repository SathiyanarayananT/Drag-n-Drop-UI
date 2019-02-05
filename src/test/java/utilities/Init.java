package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Init {

	private static WebDriver driver;

	// Driver initialise
	public static void InitializeDriver() {

		// chrome/firefox Driver
		if (ReadProperty.readDetails("DRIVER").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "BrowserDriver\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (ReadProperty.readDetails("DRIVER").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "BrowserDriver\\geckodriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Login
	public static void LaunchURL() {
		driver.get(ReadProperty.readDetails("URL"));
	}

	// Driver quit
	public static void Quit() {
		driver.quit();

	}

	// Get WebDriver
	public static WebDriver getDriver() {
		return driver;
	}
}
