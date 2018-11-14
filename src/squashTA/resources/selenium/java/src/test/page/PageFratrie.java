package squashTA.resources.selenium.java.src.test.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFratrie {
	private WebDriver webDriver;

	@FindBy(xpath = "//input[@id='afSepare0Non']")
	private WebElement etudiantNonDeclarant;

	@FindBy(xpath = "//tbody[@id='tableFratrie']/tr")
	private List<WebElement> lignesTableauFratrie;

	@FindBy(xpath = "//button[@class='btn btn-dark'][contains(.,'Ajouter une s�ur / un fr�re')]")
	private WebElement boutonAjouterFrereSoeur;

	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Suivant >')]")
	private WebElement boutonSuivant;

	public PageFratrie(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	public int countLignesTableauFratrie() {
		return lignesTableauFratrie.size();
	}

	public void setEtudiantNonDeclarant() {
		this.etudiantNonDeclarant.click();
	}

	public void clickAjouterFrereSoeur() {
		boutonAjouterFrereSoeur.click();
	}

	public PageScolariteActuelle suivant() {
		boutonSuivant.click();
		return PageFactory.initElements(webDriver, PageScolariteActuelle.class);
	}

}
