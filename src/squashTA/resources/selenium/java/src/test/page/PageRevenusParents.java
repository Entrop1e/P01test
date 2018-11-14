package squashTA.resources.selenium.java.src.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageRevenusParents {
	private WebDriver webDriver;

	@FindBy(xpath = "//input[@id='rbg']")
	private WebElement rbg;

	@FindBy(xpath = "//input[@id='rfr']")
	private WebElement rfr;

	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Suivant >')]")
	private WebElement boutonSuivant;

	public PageRevenusParents(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	public void setMontants(long rbg, long rfr) {
		this.rbg.sendKeys(Long.toString(rbg));
		this.rfr.sendKeys(Long.toString(rfr));
	}

	public PageFratrie suivant() {
		boutonSuivant.click();
		return PageFactory.initElements(webDriver, PageFratrie.class);
	}
}
