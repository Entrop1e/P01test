package squashTA.resources.selenium.java.src.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLieuTravailParents {
	private WebDriver webDriver;

	@FindBy(xpath = "//input[@id='lieuTravail0']")
	private WebElement radioAucunEtranger;

	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Suivant')]")
	private WebElement boutonSuivant;

	public PageLieuTravailParents(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	public void selectionneAucunEtranger() {
		radioAucunEtranger.click();
	}

	public PageAdresseDomicileFamilial suivant() {
		boutonSuivant.click();
		return PageFactory.initElements(webDriver, PageAdresseDomicileFamilial.class);
	}

}
