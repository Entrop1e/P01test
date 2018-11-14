package squashTA.resources.selenium.java.src.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageDGFIP {
	private WebDriver webDriver;

	@FindBy(xpath = "//input[@id='numeroFiscal']")
	private WebElement numerofiscal;

	@FindBy(xpath = "//input[@id='referenceAvis']")
	private WebElement reference;

	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Suivant >')]")
	private WebElement boutonSuivant;

	public PageDGFIP(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	public PageRevenusParents suivant() {
		boutonSuivant.click();
		return PageFactory.initElements(webDriver, PageRevenusParents.class);
	}

	public void setNumeroFiscal(int i) {
		this.numerofiscal.sendKeys(Integer.toString(i));
	}

	public void setReference(int i) {
		this.reference.sendKeys(Integer.toString(i));
	}
}
