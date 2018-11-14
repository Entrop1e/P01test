package squashTA.resources.selenium.java.src.test.jUnit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import squashTA.resources.selenium.java.src.test.page.PageAccueil;
import squashTA.resources.selenium.java.src.test.page.PageChoixDepot;
import squashTA.resources.selenium.java.src.test.page.PageMSE;

public class ChoixDepotObligatoireTest {

	private WebDriver webDriver;

	@Before
	public void setUp() {
//		System.setProperty("webdriver.firefox.driver", "D:\\geckodriver.exe");
		System.setProperty("webdriver.firefox.driver", "D:\\chromedriver.exe");

//		this.webDriver = new FirefoxDriver();
		this.webDriver = new ChromeDriver();
		this.webDriver.manage().window().maximize();
		this.webDriver.get("https://aglaestage.ac-paris.fr/mse-portail");
		this.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void testP01() {
		// page du "faux" portail MSE
		PageMSE pageMSE = PageFactory.initElements(webDriver, PageMSE.class);

		// page d'accueil avec les pieces necessaires
		PageAccueil pageAccueil = pageMSE.clique();
		Assert.assertTrue(pageAccueil.contientElementsAttendus());

		// page choix du type de depot (metropole / nouvelle caledonie / [region])
		PageChoixDepot pageChoixDepot = pageAccueil.suivant();
		Assert.assertTrue("Les �l�ments attendus dans la page ChoixDepot ne sont pas pr�sents",
				pageChoixDepot.contientElementsAttendus());
		// on teste qu'il faut bien selectionner au moins un type de depot
		Assert.assertTrue("Les boutons radio de choix du type de d�p�t doivent �tre vides",
				pageChoixDepot.aucunBoutonRadioSelectionne());
		pageChoixDepot.suivantSansSelectionDeDepot();
		Assert.assertTrue("Le message d'erreur attendu n'est pas pr�sent",
				pageChoixDepot.contientMessageErreurChoixDepotObligatoire());
		Assert.assertTrue("Les �l�ments attendus dans la page ChoixDepot ne sont pas pr�sents",
				pageChoixDepot.contientElementsAttendus());
	}

	@After
	public void tearDown() {
		this.webDriver.quit();
	}

}
