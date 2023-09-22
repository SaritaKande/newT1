package BaseLayer;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	private static ThreadLocal<WebDriver> driverThreadlocal = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {

		return driverThreadlocal.get();
	}

	
//public static WebDriver driver;
	
	public static void initialization(String browserName) {
		
		WebDriver driver = null;

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driverThreadlocal.set(driver);
		
		//driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
		driver.manage().deleteAllCookies();
		Properties prop = new Properties();
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\ConfigLayer\\Config.properties";
		try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(prop.getProperty("url"));
	}

}
