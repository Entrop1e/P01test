package squashTA.resources.selenium.java.src.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageMSE {

	private WebDriver webDriver;

	@FindBy(xpath = "//input[@value='Ok']")
	private WebElement boutonOK;

	public PageMSE(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	public PageAccueil clique() {
		boutonOK.click();
		return PageFactory.initElements(webDriver, PageAccueil.class);
	}

}
