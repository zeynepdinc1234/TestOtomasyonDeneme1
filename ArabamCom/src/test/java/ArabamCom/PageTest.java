package ArabamCom;

import static org.junit.Assert.*;

import java.util.List;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTest extends Elements {

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				".\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.arabam.com/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			getScreenShot("AnaSayfa");
			getByClass("search-input").sendKeys("Taken Screenshot");
			getByClass("search-button").click();
			goToLogo().click();
			getByPartial("Son 24 Saat").click();
			goToLogo().click();
			getByPartial("48 Saat").click();
			goToLogo().click();
			getByPartial("Acil Ýlanlar").click();
			goToLogo().click();
			getByPartial("Fiyatý Düþenler").click();
			goToLogo().click();
			int divSayisi = 0, vitrinSayisi = 0;
			List<WebElement> urunlerIsimListesi = driver
					.findElements(By.cssSelector("div[class='col-lg-2 col-md-3 col-xs-6']"));
			// Tüm vitrin ürünlerinin bulunduðu dinamik divler
			List<WebElement> vitrinListesi = driver.findElements(By.cssSelector("div[class='pin-container']"));
			// sizin için önerilenler kýsmýnýn divleri vitrin ürünleri içindeki bir
			// className alýndý
			if (getByList("h4[class='model-name']").isDisplayed()) {
				urunlerIsimListesi.add(getByList("div[class='col-lg-2 col-md-3 col-xs-6']"));
				vitrinListesi.add(getByList("div[class='pin-container']"));
				// sadece önerilenlerde bulunan bir deðiþkeni buldum ve tamamýndan çýkartým bu
				// sayede vitrindekilerin sayýsýný almýþ oldum.
			}
			divSayisi = urunlerIsimListesi.size();
			vitrinSayisi = vitrinListesi.size();
			int a = divSayisi - vitrinSayisi;
			getByClass("search-input").sendKeys("Vitrindeki ürün sayýsý " + a);
			getByClass("search-button").click();
			goToLogo().click();
			getByPartial("Motosiklet").click();
			getByClass("form-control2018").sendKeys("Suzuki");
			getByLinkText("Suzuki").click();
			getByClass("form-control2018").sendKeys("Burgman AN 650");
			getByLinkText("Burgman AN 650").click();
		} catch (Exception hata) {
			getByClass("search-input").sendKeys(hata.getMessage());
			getByClass("search-button").click();
		}
	}
}
