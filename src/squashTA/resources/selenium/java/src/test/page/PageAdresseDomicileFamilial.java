package squashTA.resources.selenium.java.src.test.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageAdresseDomicileFamilial {
	private WebDriver webDriver;

	@FindBy(xpath = "//input[@id='adresse']")
	private WebElement voie;

	@FindBy(xpath = "//input[@id='cplAdresse']")
	private WebElement complement;

	@FindBy(xpath = "//input[@id='codePostal']")
	private WebElement codePostal;

	@FindBy(xpath = "//input[@id='localite']")
	private WebElement localite;

	@FindBy(xpath = "//select[@id='idPays']")
	private WebElement listeDesPays;

	@FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Suivant >')]")
	private WebElement boutonSuivant;

	public PageAdresseDomicileFamilial(WebDriver webDriver) {
		super();
		this.webDriver = webDriver;
	}

	public void setAdresse(String voie, String complement, String codePostal, String localite, String pays) {
		this.voie.clear();
		this.voie.sendKeys(voie);
		this.complement.clear();
		this.complement.sendKeys(complement);
		this.codePostal.clear();
		this.codePostal.sendKeys(codePostal);
		this.localite.clear();
		this.localite.sendKeys(localite);
		Select listePays = new Select(listeDesPays);
		listePays.selectByVisibleText(pays);
	}

	public PageDGFIP suivant() {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,1000)");
		Actions actions = new Actions(webDriver);
		actions.moveToElement(boutonSuivant).click().build().perform();
		return PageFactory.initElements(webDriver, PageDGFIP.class);
	}
}
