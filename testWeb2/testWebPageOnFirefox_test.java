package testWeb2;

import static org.junit.Assert.*;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testWebPageOnFirefox_test {
	private WebDriver driver;
	private String baseUrl = "http://ci2.tuotiansudai.com:6003/";
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private double iTotalNum = 4212.32;

	@Before
	public void setUp() throws Exception {
		 driver = new FirefoxDriver();
		 
		 baseUrl =readValue("baseUrl");

		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	
	/**
	 * @param key<br>
	 * @return key's value<br>
	 *Get the property's value by given key.
	 */
	private static String readValue(String key) {
		String filePath= "webconfig.properties";
		Properties props = new Properties();
		InputStream in=null;
		try {
			in = new BufferedInputStream(new FileInputStream(filePath));
			props.load(in);
			String strValue = props.getProperty(key);
			return strValue;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testCreateAllProjects() throws Exception {
	    driver.get(baseUrl + "/login");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		assertTrue(driver.getTitle().equals("登录"));
		
	    driver.findElement(By.id("user")).clear();
	    driver.findElement(By.id("user")).sendKeys("zhuzhiping");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("123abc");
	    driver.findElement(By.id("yzm")).clear();
	    driver.findElement(By.id("yzm")).sendKeys("kkkkk");
	    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(1000);
	    driver.findElement(By.linkText("项目管理")).click();
	    
	    //for(int i=1;i<15;i++)
	    testCreateProjectForUser("90", "zhuzhiping", "632123199002212147");
	    testCreateProjectForUser("180", "gaoyinglong", "370105199512046531");
	    testCreateProjectForUser("360", "zhuzhiping", "632123199002212147");
	    testCreateProjectForNewComer("30", "gaoyinglong", "370105199512046531");
	    
	}

	//@Test
	public void testChangeUserAccount() throws Exception {
		   driver.get(baseUrl + "/login");
		    driver.findElement(By.id("user")).clear();
		    driver.findElement(By.id("user")).sendKeys("zhuzhiping");
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("123abc");
		    driver.findElement(By.id("yzm")).clear();
		    driver.findElement(By.id("yzm")).sendKeys("kkkkk");
		    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		    driver.findElement(By.linkText("财务管理")).click();
		    driver.findElement(By.linkText("修改账户余额")).click();
		    for(int i=0;i<1000000;i++)
		    {
		    driver.findElement(By.id("login-name")).clear();
		    driver.findElement(By.id("login-name")).sendKeys("qulonglong");
		    driver.findElement(By.id("ui-id-2")).click();
		    driver.findElement(By.id("amount")).clear();
		    driver.findElement(By.id("amount")).sendKeys("999");
		    driver.findElement(By.id("description")).clear();
		    driver.findElement(By.id("description")).sendKeys("1");
		    driver.findElement(By.xpath("//input[@value='提交']")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
			Thread.sleep(5000);
		    }
	    
	    //for(int i=1;i<15;i++)
	    
	}
	
	public void testCreateProjectForUser(String strDay, String strName, String strID) throws Exception {
		Thread.sleep(5000);
	    driver.findElement(By.linkText("发起借款")).click();
		Thread.sleep(10000);
		iTotalNum += 373.11;

	    driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
	    driver.findElement(By.linkText("房产抵押借款")).click();
	    driver.findElement(By.xpath("//input[@type='text']")).clear();
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(strName);
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(strName);
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(strID);
	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("1");
	    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	    driver.findElement(By.linkText(strDay)).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys(String.valueOf(iTotalNum));
//	    driver.findElement(By.xpath("//input[@value='10.00']")).clear();
//	    driver.findElement(By.xpath("//input[@value='10.00']")).sendKeys("1");
	    driver.findElement(By.xpath("//input[@value='50.00']")).clear();
	    driver.findElement(By.xpath("//input[@value='50.00']")).sendKeys("1");
	    driver.findElement(By.xpath("(//input[@value='50.00'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@value='50.00'])[2]")).sendKeys("0.01");
	    driver.findElement(By.xpath("//input[@value='999999.00']")).clear();
	    driver.findElement(By.xpath("//input[@value='999999.00']")).sendKeys(String.valueOf(iTotalNum));
	    driver.findElement(By.xpath("(//input[@type='text'])[9]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("1");
	    driver.findElement(By.id("baseRate")).clear();
	    driver.findElement(By.id("baseRate")).sendKeys("1");
		Thread.sleep(3000);
	    // Start time
	    driver.findElement(By.cssSelector("span.glyphicon.glyphicon-calendar")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='datetimepicker6']/div/ul/li/div/div/table/tbody/tr[2]/td[4]")).click();
		//Thread.sleep(1000);
		
		// End time
	    driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys("2016-06-30 23:00");
	    
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		Thread.sleep(500);
	    driver.switchTo().alert().accept();
		Thread.sleep(3000);
	    driver.findElement(By.linkText("编辑")).click();
		Thread.sleep(10000);
		
	    
	    driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		Thread.sleep(1000);
	    driver.switchTo().alert().accept();
		Thread.sleep(1000);
//	    driver.findElement(By.linkText("所有的借款")).click();
//		Thread.sleep(1000);

	}
	
	
	public void testCreateProjectForUser21(String strDay, String strName, String strID) throws Exception {
		Thread.sleep(5000);
	    driver.findElement(By.linkText("发起借款")).click();
		Thread.sleep(10000);
	    
	    // Wait a element display
//	    WebElement element = driver.findElement(By.id("editor"));
//	    while(!element.isDisplayed())
//	    {
//			driver.navigate().refresh();
//			Thread.sleep(5000);
//			element = driver.findElement(By.id("editor"));
//	    }

	    driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
	    driver.findElement(By.linkText("房产抵押借款")).click();
	    driver.findElement(By.xpath("//input[@type='text']")).clear();
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(strName);
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(strName);
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(strID);
	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("1");
	    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	    driver.findElement(By.linkText(strDay)).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("1");
	    driver.findElement(By.xpath("//input[@value='10.00']")).clear();
	    driver.findElement(By.xpath("//input[@value='10.00']")).sendKeys("1");
	    driver.findElement(By.xpath("//input[@value='50.00']")).clear();
	    driver.findElement(By.xpath("//input[@value='50.00']")).sendKeys("1");
	    driver.findElement(By.xpath("(//input[@value='50.00'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@value='50.00'])[2]")).sendKeys("0.01");
	    driver.findElement(By.xpath("//input[@value='999999.00']")).clear();
	    driver.findElement(By.xpath("//input[@value='999999.00']")).sendKeys("1");
	    driver.findElement(By.xpath("(//input[@type='text'])[10]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("1");
	    driver.findElement(By.id("baseRate")).clear();
	    driver.findElement(By.id("baseRate")).sendKeys("1");
	    // Start time
	    driver.findElement(By.cssSelector("span.glyphicon.glyphicon-calendar")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='datetimepicker6']/div/ul/li/div/div/table/tbody/tr[2]/td[4]")).click();
		//Thread.sleep(1000);
		
		// End time
	    driver.findElement(By.xpath("(//input[@type='text'])[13]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[13]")).sendKeys("2017-06-30 23:00");
	    
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		Thread.sleep(500);
	    driver.switchTo().alert().accept();
		Thread.sleep(3000);
	    driver.findElement(By.linkText("编辑")).click();
		Thread.sleep(10000);
		
//	    element = driver.findElement(By.id("editor"));
//	    while(!element.isDisplayed())
//	    {
//			driver.navigate().refresh();
//			Thread.sleep(5000);
//			element = driver.findElement(By.id("editor"));
//	    }
	    
	    driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		Thread.sleep(1000);
	    driver.switchTo().alert().accept();
		Thread.sleep(1000);
//	    driver.findElement(By.linkText("所有的借款")).click();
//		Thread.sleep(1000);

	}
	
	public void testCreateProjectForNewComer(String strDay, String strName, String strID) throws Exception {
		Thread.sleep(5000);
	    driver.findElement(By.linkText("发起借款")).click();
		Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
	    driver.findElement(By.linkText("房产抵押借款")).click();
	    driver.findElement(By.xpath("//input[@type='text']")).clear();
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(strName);
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(strName);
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(strID);
	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("1");
	    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	    driver.findElement(By.linkText(strDay)).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("1");
//	    driver.findElement(By.xpath("//input[@value='10.00']")).clear();
//	    driver.findElement(By.xpath("//input[@value='10.00']")).sendKeys("1");
	    driver.findElement(By.xpath("//input[@value='50.00']")).clear();
	    driver.findElement(By.xpath("//input[@value='50.00']")).sendKeys("1");
	    driver.findElement(By.xpath("(//input[@value='50.00'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@value='50.00'])[2]")).sendKeys("0.01");
	    driver.findElement(By.xpath("//input[@value='999999.00']")).clear();
	    driver.findElement(By.xpath("//input[@value='999999.00']")).sendKeys("1");
	    
	    //新手专享
	    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
	    driver.findElement(By.linkText("新手专享")).click();

	    driver.findElement(By.xpath("(//input[@type='text'])[9]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("1");
	    driver.findElement(By.id("baseRate")).clear();
	    driver.findElement(By.id("baseRate")).sendKeys("1");
	    
	    // Start time
	    driver.findElement(By.cssSelector("span.glyphicon.glyphicon-calendar")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='datetimepicker6']/div/ul/li/div/div/table/tbody/tr[2]/td[4]")).click();
		Thread.sleep(1000);
		
		// End time
	    driver.findElement(By.xpath("(//input[@type='text'])[12]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys("2017-06-30 23:00");
	    
	    driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		Thread.sleep(500);
	    driver.switchTo().alert().accept();
	    driver.findElement(By.linkText("编辑")).click();
	    
		Thread.sleep(8000);

	    driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		Thread.sleep(2000);
	    driver.switchTo().alert().accept();
		Thread.sleep(2000);

	}

	
	public void testCreateProjectForNewComer21(String strDay, String strName, String strID) throws Exception {
		Thread.sleep(5000);
	    driver.findElement(By.linkText("发起借款")).click();
		Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
	    driver.findElement(By.linkText("房产抵押借款")).click();
	    driver.findElement(By.xpath("//input[@type='text']")).clear();
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(strName);
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(strName);
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(strID);
	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("1");
	    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	    driver.findElement(By.linkText(strDay)).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("1");
	    driver.findElement(By.xpath("//input[@value='10.00']")).clear();
	    driver.findElement(By.xpath("//input[@value='10.00']")).sendKeys("1");
	    driver.findElement(By.xpath("//input[@value='50.00']")).clear();
	    driver.findElement(By.xpath("//input[@value='50.00']")).sendKeys("1");
	    driver.findElement(By.xpath("(//input[@value='50.00'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@value='50.00'])[2]")).sendKeys("1");
	    driver.findElement(By.xpath("//input[@value='999999.00']")).clear();
	    driver.findElement(By.xpath("//input[@value='999999.00']")).sendKeys("1");
	    
	    //新手专享
	    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
	    driver.findElement(By.xpath("//div[16]/div/div/div/ul/li[2]/a/span")).click();

	    driver.findElement(By.xpath("(//input[@type='text'])[10]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("1");
	    driver.findElement(By.id("baseRate")).clear();
	    driver.findElement(By.id("baseRate")).sendKeys("1");
	    
	    // Start time
	    driver.findElement(By.cssSelector("span.glyphicon.glyphicon-calendar")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='datetimepicker6']/div/ul/li/div/div/table/tbody/tr[2]/td[4]")).click();
		Thread.sleep(1000);
		
		// End time
	    driver.findElement(By.xpath("(//input[@type='text'])[13]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[13]")).sendKeys("2017-06-30 23:00");
	    
	    driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		Thread.sleep(500);
	    driver.switchTo().alert().accept();
	    driver.findElement(By.linkText("编辑")).click();
	    
		Thread.sleep(8000);
//	    element = driver.findElement(By.id("editor"));
//	    while(!element.isDisplayed())
//	    {
//			driver.navigate().refresh();
//			Thread.sleep(5000);
//			element = driver.findElement(By.id("editor"));
//	    }

	    driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		Thread.sleep(2000);
	    driver.switchTo().alert().accept();
		Thread.sleep(2000);
//	    driver.findElement(By.linkText("所有的借款")).click();
//		Thread.sleep(1000);

	}

}
