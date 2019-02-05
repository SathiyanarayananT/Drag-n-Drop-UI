package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunct {
	public static WebDriver driver;
	public static void WaitforElementviaXpath(String Xpath) {
		driver = Init.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
	}
	
	public static void DragDropBy(WebElement source , int X , int Y) {
		driver = Init.getDriver();
		Actions act = new Actions(driver);
		act.dragAndDropBy(source, X,Y);
		act.build().perform();
	}
	
	public static void DragDrop(WebElement source , WebElement target) {
		driver = Init.getDriver();
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target);
		act.build().perform();
	}

}
