package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.CommonFunct;
import utilities.Init;

public class DragDropUI {
	public void DragDropTest() {
		WebDriver driver = Init.getDriver();

		// click on Create an app button
		driver.findElement(By.id("link-create")).click();

		// Click on Lets get started
		CommonFunct.WaitforElementviaXpath("//div[@id='intro-dialog']/following-sibling::div/child::button");
		driver.findElement(By.xpath("//div[@id='intro-dialog']/following-sibling::div/child::button")).click();

		// Click on New page
		driver.findElement(By.id("add-page")).click();

		// Enter name of the page
		driver.findElement(
				By.xpath("//label[text()='Enter a new name for this page:']/following-sibling::input[@name='name']"))
				.sendKeys("test");

		// Click create
		driver.findElement(By.xpath("//div[@id='create-dialog']/following-sibling::div/button[text()='Create']"))
				.click();

		// To double check that we are in correct page
		WebElement current_page = driver.findElement(By.xpath("//li[@aria-disabled='true']/a[1]"));

		// Getting link name
		String pagearea_id = current_page.getAttribute("href");
		pagearea_id = pagearea_id.split("#")[1];

		// Click on messaging
		CommonFunct.WaitforElementviaXpath("//a[contains(text(),'Messaging')]");
		driver.findElement(By.xpath("//a[contains(text(),'Messaging')]")).click();

		// Draging the element to the page area
		WebElement sendsmsblock = driver.findElement(By.xpath("//li[text()='Send an SMS']"));
		WebElement pagearea = driver.findElement(By.id(pagearea_id));
		CommonFunct.DragDropBy(sendsmsblock, pagearea.getLocation().getX() * 4, pagearea.getLocation().getY());

		// Joining the lines from start from send sms block
		// div[@id= 'module-2']/div[@class='mod-rail mod-north']/div
		// This xpath also works,but to be very precise about the block, below xpath is
		// used.

		WebElement startpointer = driver.findElement(
				By.xpath("//div[@id= 'module-1' and .//div[text()='Start']]/div[@class='mod-rail mod-south']/div"));
		WebElement sendsmsblockpointer = driver.findElement(By
				.xpath("//div[@id= 'module-2' and .//div[text()='Send an SMS']]/div[@class='mod-rail mod-north']/div"));
		CommonFunct.DragDrop(startpointer, sendsmsblockpointer);

		// enter values in Send an SMS block
		driver.findElement(By.name("phone_constant")).sendKeys("901982309218");
		driver.findElement(By.name("message_phrase[]")).sendKeys("Hello world");

		WebElement sendanemail = driver.findElement(By.xpath("//li[text()='Send an Email']"));
		CommonFunct.DragDropBy(sendanemail, pagearea.getLocation().getX() * 6, pagearea.getLocation().getY() * 2);

		// enter values in Send an SMS block
		driver.findElement(By.xpath("//div[contains(text(),'SMTP Host:')]/following::input[@type='text']"))
				.sendKeys("smtp.gmail.com");
		driver.findElement(By.xpath("//div[contains(text(),'Port')]/following::input[@type='text']")).sendKeys("456");
		driver.findElement(By.xpath("//div[contains(text(),'Username')]/following::input[@type='text']"))
				.sendKeys("username");

		// This can also be used for Password
		// div[contains(text(),'Password')]/following::input[@*='text']
		// search via name is faster
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("from_constant")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("to_constant")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("subject_constant")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("cc_constant")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//div[@id= 'module-3']//textarea[@name='message_phrase[]']"))
				.sendKeys("abc@gmail.com");

		// Join Send an SMS and Send an Email
		WebElement sendsmsblockpointer1 = driver.findElement(By.xpath(
				"//div[@id= 'module-2' and .//div[text()='Send an SMS']]//div[@class='panel-nodes-attached inner']/div[2]"));
		WebElement sendanemailpointer1 = driver.findElement(By.xpath(
				"//div[@id= 'module-3' and .//div[text()='Send an Email']]/div[@class='mod-rail mod-north']/div"));
		CommonFunct.DragDrop(sendsmsblockpointer1, sendanemailpointer1);

		// Click on Basic
		driver.findElement(By.xpath("//a[contains(text(),'Basic')]")).click();

		// Drop and drop end app
		WebElement endblock = driver.findElement(By.xpath("//li[text()='Hang Up or Exit']"));
		CommonFunct.DragDropBy(endblock, pagearea.getLocation().getX() * 2, pagearea.getLocation().getY() * 5);

		// Join End app and Send an SMS block
		WebElement sendsmsblockpointer2 = driver.findElement(By.xpath(
				"//div[@id= 'module-2' and .//div[text()='Send an SMS']]//div[@class='panel-nodes-attached inner']/div[1]"));
		WebElement endblockpointer1 = driver.findElement(
				By.xpath("//div[@id= 'module-4' and .//div[text()='Exit App']]/div[@class='mod-rail mod-north']/div"));
		CommonFunct.DragDrop(sendsmsblockpointer2, endblockpointer1);

		// Drop and drop end app
		CommonFunct.DragDropBy(endblock, pagearea.getLocation().getX() * 4, pagearea.getLocation().getY() * 7);

		WebElement sendemailblockpointer2 = driver.findElement(By.xpath(
				"//div[@id= 'module-3' and .//div[text()='Send an Email']]//div[@class='panel-nodes-attached inner']/div[1]"));
		WebElement endblockpointer2 = driver.findElement(
				By.xpath("//div[@id= 'module-5' and .//div[text()='Exit App']]/div[@class='mod-rail mod-north']/div"));
		CommonFunct.DragDrop(sendemailblockpointer2, endblockpointer2);

		CommonFunct.DragDropBy(endblock, pagearea.getLocation().getX() * 8, pagearea.getLocation().getY() * 7);

		WebElement sendemailblockpointer3 = driver.findElement(By.xpath(
				"//div[@id= 'module-3' and .//div[text()='Send an Email']]//div[@class='panel-nodes-attached inner']/div[2]"));
		WebElement endblockpointer3 = driver.findElement(
				By.xpath("//div[@id= 'module-6' and .//div[text()='Exit App']]/div[@class='mod-rail mod-north']/div"));
		CommonFunct.DragDrop(sendemailblockpointer3, endblockpointer3);

	}

}
