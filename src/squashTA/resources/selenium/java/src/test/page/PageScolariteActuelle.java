package squashTA.resources.selenium.java.src.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageScolariteActuelle {
	private WebDriver webDriver;

	@FindBy(xpath = "//select[@id='idAcademie']")
	private WebElement listeAcademies;

	@FindBy(xpath = "//input[@id='scolDS']")
	private WebElement scolariteMEN;

	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Suivant >')]")
	private WebElement boutonSuivant;

	public PageScolariteActuelle(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	public void setScolariteMEN() {
		this.scolariteMEN.click();
	}

	public void setAcademie(String academie) {
		Select selectAcademies = new Select(listeAcademies);
		// FIXME
		// selectAcademies.deselectAll();
		selectAcademies.selectByVisibleText(academie);
	}

	public PageAideDemandee suivant() {
		boutonSuivant.click();
		return PageFactory.initElements(webDriver, PageAideDemandee.class);
	}
}
