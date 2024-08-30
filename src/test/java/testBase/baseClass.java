package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups= {"Smoke","Functional","Master"})
	@Parameters({"os","browser"})
	public void setUp(String os , String br) throws IOException {
		
		
		logger = LogManager.getLogger(this.getClass());  //Log4j2
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		/*if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capabilites =  new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) {
				
				capabilites.setPlatform(Platform.WIN11);
			}
			
			
			else if(os.equalsIgnoreCase("Linux")) {
				
				capabilites.setPlatform(Platform.LINUX);
			}
			
			else if(os.equalsIgnoreCase("mac")) {
				
				capabilites.setPlatform(Platform.MAC);
			}
			
			else {
				
				System.out.println("No Os Found");
				return;
			}
			
           switch(br.toLowerCase()) {
			
			case "chrome": capabilites.setBrowserName("chrome"); break;
			case "firefox": capabilites.setBrowserName("firefox"); break;
			case "edge": capabilites.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("Invalid Browser Name"); return; 
		
			}


            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilites);
             
			
			
		}*/
		
		
	//	if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		
			
			switch(br.toLowerCase()) {
			
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
	        case "firefox": driver=new FirefoxDriver(); break;
			default: System.out.println("Invalid Browser Name"); return; 
		
			}
			
		//}
		
			
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appUrl"));                                      // Reading URL from properties file
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		driver.manage().window().maximize();
		
	}
	
	
	@AfterClass(groups= {"Smoke","Functional","Master"})
	public void tearDown() {
		
		driver.quit();
	}
	
   public String randomString() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(7);
		return generatedString;
	}
	
	public String randomNumber() {
		
		String generatedNumeric = RandomStringUtils.randomNumeric(10);
		return generatedNumeric;
		
	}
	
	public String randomAlphaNumeric() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		String generatedNumeric = RandomStringUtils.randomNumeric(3);
        return(generatedString+generatedNumeric);
	}

	public String captureScreen(String tname) {
		
		String timeStemp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname +"_" + timeStemp + ".png";
		
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
		
		
	}
}
