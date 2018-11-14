package squashTA.resources.selenium.java.src.test.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageChoixDepot {
	private WebDriver webDriver;

	@FindBy(xpath = "//li[contains(.,'Vous devez choisir un type de dépôt')]")
	private WebElement messageErreur;

	@FindBy(xpath = "//div[@class='card-header'][contains(.,'Mon choix du type de dépôt')]")
	private WebElement divTitre;

	@FindBy(xpath = "//input[@type='radio']")
	private List<WebElement> radiosBoutons;

	@FindBy(xpath = "//input[@id='AUT']")
	private WebElement radioMetropole;

	@FindBy(xpath = "//input[@id='CAL']")
	private WebElement radioCaledonie;

	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Suivant')]")
	private WebElement boutonSuivant;

	public PageChoixDepot(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	public boolean contientElementsAttendus() {
		return divTitre.isDisplayed() && boutonSuivant.isDisplayed() && (radiosBoutons.size() == 2);
	}

	/*
	 * public PageChoixDepot suivantAvecSelectionDeDepot() { boutonSuivant.click();
	 * return PageFactory.initElements(webDriver, RevenusParents.class); }
	 */

	public void suivantSansSelectionDeDepot() {
		boutonSuivant.click();
	}

	public PageSituationFiscaleParents suivantAvecSelectionDeDepot() {
		boutonSuivant.click();
		return PageFactory.initElements(webDriver, PageSituationFiscaleParents.class);

	}

	public boolean contientMessageErreurChoixDepotObligatoire() {
		return messageErreur.isDisplayed();
	}

	public boolean aucunBoutonRadioSelectionne() {
		return !radioMetropole.isSelected() && !radioCaledonie.isSelected();
	}

	public void selectionneDepotMetropole() {
		radioMetropole.click();
	}
}
