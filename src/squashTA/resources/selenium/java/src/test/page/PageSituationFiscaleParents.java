package squashTA.resources.selenium.java.src.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSituationFiscaleParents {
	private WebDriver webDriver;

	@FindBy(xpath = "//input[@id='structureFamilleA']")
	private WebElement radioMaries;

	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Pr�c�dent')]")
	private WebElement boutonPrecedent;

	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Suivant')]")
	private WebElement boutonSuivant;

	public PageSituationFiscaleParents(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	public boolean contientElementsAttendus() {
		return true; // TODO divTitre.isDisplayed() && boutonSuivant.isDisplayed() &&
						// (radiosBoutons.size() == 2);
	}

	public void precedent() {
		boutonPrecedent.click();
	}

	public void selectionneMaries() {
		radioMaries.click();
	}

	public PageLieuResidence suivant() {
		boutonSuivant.click();
		return PageFactory.initElements(webDriver, PageLieuResidence.class);
	}

}
