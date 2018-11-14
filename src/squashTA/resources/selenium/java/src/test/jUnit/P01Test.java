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
import squashTA.resources.selenium.java.src.test.page.PageAdresseDomicileFamilial;
import squashTA.resources.selenium.java.src.test.page.PageAideDemandee;
import squashTA.resources.selenium.java.src.test.page.PageChoixDepot;
import squashTA.resources.selenium.java.src.test.page.PageDGFIP;
import squashTA.resources.selenium.java.src.test.page.PageFratrie;
import squashTA.resources.selenium.java.src.test.page.PageLieuResidence;
import squashTA.resources.selenium.java.src.test.page.PageLieuTravailParents;
import squashTA.resources.selenium.java.src.test.page.PageMSE;
import squashTA.resources.selenium.java.src.test.page.PageRevenusParents;
import squashTA.resources.selenium.java.src.test.page.PageScolariteActuelle;
import squashTA.resources.selenium.java.src.test.page.PageSituationFiscaleParents;

public class P01Test {

	private WebDriver webDriver;

	@Before
	public void setUp() {
//		System.setProperty("webdriver.firefox.driver", "D:\Users\DSI\eclipse-workspace\aglae-depot-test\src\test\resources\drivers\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gblin\\Documents\\chromedriver.exe");

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
		pageChoixDepot.selectionneDepotMetropole();

		// page situation fiscale des parents
		PageSituationFiscaleParents pageSituationFiscaleParents = pageChoixDepot.suivantAvecSelectionDeDepot();
		// TODO Assert.assertTrue(contientElementsAttebndus())
		pageSituationFiscaleParents.selectionneMaries();

		// page lieu residence parents
		PageLieuResidence pageLieuResidence = pageSituationFiscaleParents.suivant();
		pageLieuResidence.selectionneFrance();

		// page lieu travail parents
		PageLieuTravailParents pageLieuTravailParents = pageLieuResidence.suivant();
		pageLieuTravailParents.selectionneAucunEtranger();

		// page adresse Domicile Familial
		PageAdresseDomicileFamilial pageAdresseDomicileFamilial = pageLieuTravailParents.suivant();
		pageAdresseDomicileFamilial.setAdresse("Rue Rouge", "Compl�ment d'adresse", "458754", "MAMDLFLDMFLD",
				"Danemark");

		// page dgfip
		PageDGFIP pageDGFIP = pageAdresseDomicileFamilial.suivant();
		pageDGFIP.setNumeroFiscal(100032569);
		pageDGFIP.setReference(19932569);

		// page revenus parents
		PageRevenusParents pageRevenusParents = pageDGFIP.suivant();
		pageRevenusParents.setMontants(-25020, +32569);

		// page fratrie
		PageFratrie pageFratrie = pageRevenusParents.suivant();
		int nombreInitialLignesTableau = pageFratrie.countLignesTableauFratrie();
		///// pageFratrie.clickAjouterFrereSoeur();
		///// Assert.assertTrue(pageFratrie.countLignesTableauFratrie() ==
		///// (nombreInitialLignesTableau + 1));
		pageFratrie.setEtudiantNonDeclarant();

		// page scolarite actuelle
		PageScolariteActuelle pageScolariteActuelle = pageFratrie.suivant();
		pageScolariteActuelle.setScolariteMEN();
		pageScolariteActuelle.setAcademie("Paris");

		// page aide demandee
		PageAideDemandee pageAideDemandee = pageScolariteActuelle.suivant();
	}

	@After
	public void tearDown() {
		this.webDriver.quit();
	}

}
