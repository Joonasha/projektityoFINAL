package HelperClasses;

import java.util.ArrayList;

public class Gradu {

    String year;
    String author;
    String name;
    String level;
    String type;
    String articles;
    String language;
    String authornumber;
    ArrayList<String> concepts;
    ArrayList<String> rmethod;
    ArrayList<String> dmethod;
    ArrayList<String> sources;
    String sourcenumber;
    ArrayList<String> subjects;
    ArrayList<String> subject1;
    ArrayList<String> subject2;
    ArrayList<String> subject3;
    ArrayList<String> subject4;
    ArrayList<String> subject1framework;
    ArrayList<String> subject2framework;
    ArrayList<String> subject3framework;
    ArrayList<String> subject4framework;
    String context;
    String grade;
    String drgrade;
    

    public Gradu(
            String year,
            String author,
            String name,
            String level,
            String type,
            String articles,
            String language,
            String authornumber,
            ArrayList<String> concepts,
            ArrayList<String> rmethod,
            ArrayList<String> dmethod,
            ArrayList<String> sources,
            String sourcenumber,
            ArrayList<String> subjects,
            ArrayList<String> subject1,
            ArrayList<String> subject2,
            ArrayList<String> subject3,
            ArrayList<String> subject4,
            ArrayList<String> subject1framework,
            ArrayList<String> subject2framework,
            ArrayList<String> subject3framework,
            ArrayList<String> subject4framework,
            String context,
            String grade,
            String drgrade) {

    	this.year=year;
        this.author=author;
        this.name=name;
        this.level=level;
        this.type=type;
        this.articles=articles;
        this.language=language;
        this.authornumber=authornumber;
        this.concepts=concepts;
        this.rmethod=rmethod;
        this.dmethod=dmethod;
        this.sources=sources;
        this.sourcenumber=sourcenumber;
        this.subjects=subjects;
        this.subject1=subject1;
        this.subject2=subject2;
        this.subject3=subject3;
        this.subject4=subject4;
        this.subject1framework=subject1framework;
        this.subject2framework=subject2framework;
        this.subject3framework=subject3framework;
        this.subject4framework=subject4framework;
        this.context=context;
        this.grade=grade;
        this.drgrade=drgrade;
    }

    public Gradu() {

    }

    @Override
    public String toString() {
        return "Gradu: " + name
                + "\n\tVuosi: " + year
                + "\n\tOpinnäytteen tekijä: " + author
                + "\n\tOpinnäytteen taso: " + level
                + "\n\tOpinnäytteen muoto: " + type
                + "\n\tArtikkelien määrä: " + articles
                + "\n\tOpinnäytteen kieli: " + language
                + "\n\tOpinnäytteen tekijöiden määrä: " + authornumber
                + "\n\tParadigman tutkimuskohteet: " + subjects
                + "\n\tTutkimustehtävät ja käsitteet: " + concepts
                + "\n\tTutkimusmetodit: " + rmethod
                + "\n\tAineistonkeruumenetelmä: " + dmethod
                + "\n\tTietolähde: " + sources
                + "\n\tTietolähteiden lukumäärä: " + sourcenumber
                + "\n\tParadigman tutkimuskohteet: " + subjects
                + "\n\tToimintaprosessien tiedon hallinnan organisointi ja ohjaus: " + subject1
                + "\n\tTieto- ja viestintätekniikan käyttö: " + subject2
                + "\n\tTiedonhallinnan osaaminen ja tiedolla johtaminen: " + subject3
                + "\n\tTietorakenteet ja -mallit: " + subject4
                + "\n\tTutkimuksen konteksti: " + context
                + "\n\tArvosana, pro gradu: " + grade
                + "\n\tArvosana, väitöskirja: " + drgrade;
                
    }
    
    /*
    public String[] tiedot() {
        return new String[]{vuosi, tekija, nimi, tarkoitus, kysymykset,
            tutkimusmenetelma, aineistokeruumenetelma, tietolahde,
            viitekehys, paradigmanKasitteet, tutkimusalue, arvosana};
    }
    */

}
