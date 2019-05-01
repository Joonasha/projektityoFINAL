package HelperClasses;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * Lists that the program needs to initialize graphic interface elements such as comboboxes and radio buttons
 */
public class lists {
	
	/*
	 * Year the study was published
	 */
	public static ObservableList<String> listYears = FXCollections.observableArrayList("2002", "2003", "2004", "2005"
			, "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2014", "2015", "2016", "2017"
			, "2018", "2019");
	
	/*
	 * Level of the study
	 */
	public static ObservableList<String> listLevels = FXCollections.observableArrayList("1. pro gradu tutkielma", " 2. v�it�skirja", "3. muu");
	
	/*
	 * Type of the study
	 */
	public static ObservableList<String> listTypes = FXCollections.observableArrayList("1. monografia", "2. artikkeli", "3. muu");
	
	/*
	 * Number of articles in the study
	 */
	public static ObservableList<String> listNumberofArticles = FXCollections.observableArrayList("Fin 1", "Fin 2", "Fin 3"
			, "Fin 4", "Fin 5", "Fin 6", "Eng 1", "Eng 2", "Eng 3", "Eng 4", "Eng 5", "Eng 6");
	
	/*
	 * Language of the study
	 */
	public static ObservableList<String> listLanguages = FXCollections.observableArrayList("1. suomi", "2. englanti", "3. muu, mik�?");
	
	/*
	 * Number of authors
	 */
	public static ObservableList<String> listNumberofAuthors = FXCollections.observableArrayList("1.","2.");
	
	/*
	 * Paradigm research subjects
	 */
	public static ObservableList<String> listSubjects = FXCollections.observableArrayList("1. Toimintaprosessien tiedon hallinnan organisointi ja ohjaus"
			, "2. Tieto- ja viestint�tekniikan k�ytt�", "3. Tiedonhallinnan osaaminen ja tiedolla johtaminen", "4. Tietorakenteet- ja mallit");
	
	/*
	 * Subclasses and frameworks for chosen subjects
	 */
	public static ObservableList<String> subject1subclasses = FXCollections.observableArrayList("1.1 Toimintaprosessien mallinnus", "1.2 Toimintaprosessien arviointi"
			, "1.3 Tiedon tarve toimintaprosesseissa", "1.4 Informaatioetiikka");
	public static ObservableList<String> subject1frameworks = FXCollections.observableArrayList("Informaation prosessimalli (Choo 2002)", "Innovaatioteoria (Rogers 2003)"
			,"Systeemiteoria (Bertalanffy 1971)", "Wang & Strong (1996)", "It governance (ITG), (CISR 2000, COBIT 2004)", "Muu, mik�?");
	
	public static ObservableList<String> subject2subclasses = FXCollections.observableArrayList("2.1 Tietoj�rjestelmien kehitt�minen", "2.2 K�ytt��noton arviointi"
			, "2.3 S�hk�inen asiointi", "2.4 K�ytett�vyys", "2.5 Tietoturvallisuus");
	public static ObservableList<String> subject2frameworks = FXCollections.observableArrayList("Informaation prosessimalli (Choo 2002)", "Innovaatioteoria (Rogers 2003)"
			, "Organisaatioteoria", "Muutosteoria", "Sosio-tekninen malli", "Nielsenin heurestiikka (1990)", "EUCS- malli (Bailey & Pearson 1983)"
			, "TAM- malli (Davis 1989)", "Perustellun toiminnan teoria (TRA), (Fishbein & Ajzen 1975)", "De Lone & McLean (2014)", "Muu, mik�?");
	
	public static ObservableList<String> subject3subclasses = FXCollections.observableArrayList("3.1 Koulutus/Opetussuunnitelman kehitt�minen", "3.2 Osaamisen arviointi"
			, "3.3 Henkil�st�n tietotekniset valmiudet", "3.4 Johtaminen", "3.5 Tiedon uusiok�ytt�", "3.6 Tiedonlouhinta", "3.7 Governance");
	public static ObservableList<String> subject3frameworks = FXCollections.observableArrayList("Helakorpi (2004)", "Staggers's osaamisen tasot (2001,2002)"
			,"IMIAn suositukset ja koulutusmallit", "Toiminnan teoria (Engestr�m 1987)", "Johtamisteoriat (Mintzberg 1989, SWOT (Humphrey 2005))"
			,"P��t�ksenteko", "Tiedon louhintamallit", "Kokonaisarkkitehtuurit", "Muu, mik�?");
	
	public static ObservableList<String> subject4subclasses = FXCollections.observableArrayList("4.1 Tietovarastojen tutkiminen", "4.1.1 Tietosis�ll�t", "4.1.2 Rakenteiden kirjaaminen"
                        , "4.2 Tiedonmallintaminen", "4.3 Termist�t", "4.4 Standardointi","4.5 Tiedon j�sennys");
	public static ObservableList<String> subject4frameworks = FXCollections.observableArrayList("Hoitoty�n viitetietomalli (Goossen 1997)"
			, "Terminologiset rakennemallit (Cimino 1998)", "Tiedon sosiologia", "Informaation prosessimalli (Choo 2002)", "Standardit", "FinCC"
			, "Wang & Strong (1996)", "Muu, mik�?");

	/*
	 * Tasks and concepts
	 */
	public static ObservableList<String> listConcepts = FXCollections.observableArrayList("1. tieto", "2. toimijat", "3. toiminta", "4. menetelm�t");
	
	/*
	 * Research methods employed in the study
	 */
	public static ObservableList<String> listMethods = FXCollections.observableArrayList("1. Laadullinen", "2. M��r�llinen", "3. Tapaustutkimus", "4. Delfoi", "5. Tiedonlouhinta"
			, "6. Toimintatutkimus", "7. Arviointitutkimus", "8. Muu, mik�?");
	
	/*
	 * Data collecting methods employed in the study
	 * *-marked options must be elaborated on
	 */
	public static ObservableList<String> listDatamethods = FXCollections.observableArrayList("1. Asiakirjat*", "2. haastattelu", "3. havainnointi", "4. kirjallisuuskatsaus"
			, "5. kysely", "6. rekisteriaineisto", "7. Muu, mik�?");
	
	/*
	 * Data sources
	 * *-marked options must be elaborated on
	 */
	public static ObservableList<String> listSources = FXCollections.observableArrayList("1. Hoitoty�ntekij�t", "2. L��k�rit", "3. muu henkil�st�*", "4. Erityisty�ntekij�t"
			, "5. potilaat/asiakkaat", "6. kansalaiset", "7.  opiskelijat", "8. opettajat", "9. johtajat", "10. tietohallintoammattilaiset", "11. viranomaiset",
                        "12. kirjallisuus ja tieteelliset tutkimukset", "13. asiakirjat*", "14. rekisterit*", "15. muu, mik�?");
        
	/*
	 * Context of the research
	 */
	public static ObservableList<String> listContext = FXCollections.observableArrayList("1. perusterveydenhuolto", "2. erikoissairaanhoito", "3. sosiaalihuolto"
			, "4. yksityissektori", "5. kolmas sektori", "6. koulutussektori", "7. yrityssektori", "8. muu, mik�?");
	
	/*
	 * Grade of the study (Master's thesis)
	 */
	public static ObservableList<String> listGrades = FXCollections.observableArrayList("1. approbatur", "2. lubenter approbatur", "3. non sine laude approbatur"
			, "4. cum laude approbatur", "5. magna cum laude approbatur", "6. eximia cum laude approbatur", "7. laudatur");
	
	/*
	 * Grade of the study (Doctorate)
	 */
	 public static ObservableList<String> doctorateGrades = FXCollections.observableArrayList("1. kiitt�en hyv�ksytty", "2. hyv�ksytty");

	 /*
	  * A list of the theses generated with the form
	  */
	 public static ArrayList<Gradu> addedTheses = new ArrayList<Gradu>();
	 
	 /*
	  * A list of strings presentative of all the theses in the list above
	  */
	 public static ObservableList<String> addedThesesString = FXCollections.observableArrayList("Kiitt�en hyv�ksytty", "Hyv�ksytty");

	 /*
	  * A list of selectable subjects for visualization
	  */
	 public static ObservableList<String> chartSubjects = FXCollections.observableArrayList("1. Vuosi", "2. Taso", "3. Muoto", "4. Kieli", "5. Paradigman tutkimuskohteet", "6. Tutkimusmetodit", 
			 "7. Aineistonkeruumenetelm�", "8. Arvosana, pro gradu", "9. Arvosana, v�it�skirja");
	 
	 public static ObservableList<String> lineChartY = FXCollections.observableArrayList("1. Taso", "2. Muoto", "3. Kieli", "4. Paradigman tutkimuskohteet",
			 "5. Arvosana, pro gradu", "6. Arvosana, v�it�skirja");
	 /*
	  * A list of theses used for visualization
	  */
	 public static ArrayList<Thesis> visualTheses = new ArrayList<Thesis>();
}
