package squashTA.resources.selenium.java.src.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLieuResidence {
	private WebDriver webDriver;

	@FindBy(xpath = "//input[@id='lieuResidenceFR']")
	private WebElement radioFrance;

	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Suivant')]")
	private WebElement boutonSuivant;

	public PageLieuResidence(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	public void selectionneFrance() {
		radioFrance.click();
	}

	public PageLieuTravailParents suivant() {
		boutonSuivant.click();
		return PageFactory.initElements(webDriver, PageLieuTravailParents.class);

	}

}
