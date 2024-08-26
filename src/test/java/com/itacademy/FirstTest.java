package com.itacademy;

import com.itacademy.utils.JSExecutorUtils;
import com.itacademy.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class FirstTest extends BaseTest {

	@Test
	public void checkProduct() {
		driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
		WebElement firstProductName = driver.findElement(By.xpath("//*[@class = 'sc-124al1g-4 eeXMBo']"));
		Waiters.wait(3000);
		List<WebElement> productsName = driver.findElements(By.xpath("//*[@class = 'sc-124al1g-4 eeXMBo']"));
		String firstName = productsName.get(1).getText();
		WebElement addCartButton = driver.findElement(By.xpath("//*[text()='Add to cart']"));
		addCartButton.click();
		Waiters.wait(3000);
		WebElement nameOnCart = driver.findElement(By.cssSelector(".sc-11uohgb-2.elbkhN"));
		String nameOfCartText = nameOnCart.getText();
		System.out.println(firstName);
		System.out.println(nameOfCartText);
	}

	@Test
	public void checkProduct1() {
		driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
		Waiters.wait(3000);
		List<WebElement> addToCartBtn = driver.findElements(By.xpath("//*[text() = 'Add to cart']"));
		for (WebElement webElement : addToCartBtn) {
			JSExecutorUtils.click(driver, webElement);
		}
	}

	@Test
	public void checkValue() {

		driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
		List<WebElement> productsValue = driver.findElements(By.xpath("//*[@class ='sc-124al1g-6 ljgnQL']"));
		Waiters.wait(2000);

		String productValue1 = productsValue.get(0).getText();
		String productValue2 = productsValue.get(1).getText();
		String productValue3 = productsValue.get(4).getText();

		productValue1 = productValue1.replaceAll("\\$", "").trim();
		productValue2 = productValue2.replaceAll("\\$", "").trim();
		productValue3 = productValue3.replaceAll("\\$", "").trim();

		double valueOfProduct1 = Double.parseDouble(productValue1);
		double valueOfProduct2 = Double.parseDouble(productValue2);
		double valueOfProduct3 = Double.valueOf(productValue3);
		double expectedSumOfProducts = valueOfProduct1 + valueOfProduct2 + valueOfProduct3;

		List<WebElement> addCartBtns = driver.findElements(By.xpath("//*[text()='Add to cart']"));
		addCartBtns.get(0).click();
		addCartBtns.get(1).click();
		addCartBtns.get(4).click();
		Waiters.wait(3000);
		WebElement valueOfProdOnCart = driver.findElement(By.cssSelector(".sc-1h98xa9-9.jzywDV"));
		String valueOnCart = valueOfProdOnCart.getText();
		valueOnCart = valueOnCart.replaceAll("\\$", "").trim();
		double valOnCart = Double.valueOf(valueOnCart);
		Assert.assertEquals(expectedSumOfProducts, valOnCart, "Value is not equal");
	}

	@Test
	public void elementInElement() {
		driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
		Waiters.wait(3000);
		List<WebElement> products = driver.findElements(By.cssSelector(".sc-124al1g-2"));
		for (WebElement webElement : products) {
			System.out.println(webElement.findElement(By.xpath(".//*[contains(@class, 'sc-124al1g-4')]")).getText());
			if (webElement.findElement(By.xpath(".//*[contains(@class, 'sc-124al1g-4')]")).
					getText().equals("Skater Black Sweatshirt"))
			{
				webElement.findElement(By.xpath(".//*[text()= 'Add to cart']")).click();
			}
		}
		Waiters.wait(3000);

	}
}
