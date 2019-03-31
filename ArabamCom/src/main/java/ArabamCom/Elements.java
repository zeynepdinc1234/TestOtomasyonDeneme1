package ArabamCom;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.*;
import org.openqa.selenium.*;

public abstract class Elements {

	protected WebDriver driver;
	protected List<String> liste=new ArrayList<String>();
	
	protected WebElement getById(String id) {
		return driver.findElement(By.id(id));
	}
	
	protected WebElement getByClass(String className) {
		return driver.findElement(By.className(className));
	}
	
	protected WebElement getByName(String name) {
		return driver.findElement(By.name(name));
	}
	
	protected WebElement getByLinkText(String text) {
		return driver.findElement(By.linkText(text));
	}
	
	protected WebElement goToLogo() {
		return driver.findElement(By.id("arabam-header-logo"));
	}
	
	protected WebElement getByXPath(String path) {
		return driver.findElement(By.xpath(path));
	}
	
	protected WebElement getByPartial(String path) {
		return driver.findElement(By.partialLinkText(path));
	}
	
	protected void getScreenShot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/"+fileName+".png"));
	}
	
	protected WebElement getByList(String list){
		  return driver.findElement(By.cssSelector(list));
	}
}
