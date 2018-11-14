package squashTA.resources.selenium.java.src.test.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAccueil {

	private WebDriver webDriver;

	@FindBy(xpath = "//div[@class='card-header'][contains(.,'Pré-requis')]")
	// @FindBy(xpath = "//div[@class='card-header'][.='Pré-requis']")
	private WebElement divPreRequis;

	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Suivant')]")
	private WebElement boutonSuivant;

	public PageAccueil(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	public boolean contientElementsAttendus() {
		return existeBoutonSuivant() && existeDivPreRequis();
	}

	public boolean existeDivPreRequis() {
		return divPreRequis.isDisplayed();
	}

	public boolean existeBoutonSuivant() {
		return boutonSuivant.isDisplayed();
	}

	public PageChoixDepot suivant() {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,1000)");
		boutonSuivant.click();
		return PageFactory.initElements(webDriver, PageChoixDepot.class);
	}

}
