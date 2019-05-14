package HelperClasses;

import java.util.ArrayList;
import java.util.Arrays;

public class Thesis {

    //18 fields
    int rowNum = -1; //monesko gradu tämä on
    String year; //Vuosi
    String[] authors; //Tekijät
    String name; //Tutkielman nimi
    String level; //Opinnäytteen taso
    String type; //Opinnäytteen muoto
    String articles; //Artikkelien kieli ja lkm
    String language; //Opinnäytteen kieli
    String authorcount; //Tekijöiden lkm
    String[] researchSubjects; //Paradigman tutkimuskohteet
    String[] researchConcepts; //Tutkimustehtävien ja -käsitteiden sijoittuminen
    String[] researchMethods; //Tutkimusmetodit
    String[] sources; //Aineistonkeruumenetelmät
    String[] informants; //Tietolähteet/informantit
    String informantCount; //Tietolähteiden lukumäärä
    String[] classes; //Luokat 1.1, 1.2 ...
    String[] context; //Tutkimuksen konteksti
    String pggrade; //arvosana, pro gradu
    String dtgrade; //arvosana, väitöskirja

    public Thesis() {
    	
    }
    public Thesis(String year, String[] authors, String name, String level, String type, String articles, String language, String authorcount, 
    		String[] researchSubjects, String[] researchConcepts, String[] researchMethods, String[] sources, String[]informants, 
    		String informantCount, String[] classes, String[] context) {
    	this.year=year;
    	this.authors=authors;
    	this.name=name;
    	this.level=level;
    	this.type=type;
    	this.articles=articles;
    	this.language=language;
    	this.authorcount=authorcount;
    	this.researchSubjects=researchSubjects;
    	this.researchConcepts=researchConcepts;
    	this.researchMethods=researchMethods;
    	this.sources=sources;
    	this.informants=informants;
    	this.informantCount=informantCount;
    	this.classes=classes;
    	this.context=context;
    	this.pggrade="0";
    	this.dtgrade="0";
    }

    public Thesis(boolean testi) {
        year = "1";
        authors = new String[1];
        authors[0] = "2";
        name = "3";
        level = "4";
        type = "5";
        articles = "6";
        language = "7";
        authorcount = "8";
        researchSubjects = new String[1];
        researchSubjects[0] = "9";
        researchConcepts = new String[1];
        researchConcepts[0] = "10";
        researchMethods = new String[1];
        researchMethods[0] = "11";
        sources = new String[1];
        sources[0] = "12";
        informants = new String[1];
        informants[0] = "13";
        informantCount = "14";
        classes = new String[1];
        classes[0] = "15";
        context = new String[1];
        context[0] = "16";
        pggrade = "17";
        dtgrade = "18";
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public void setYear(String year) {
        this.year = year.substring(0,4);
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setArticles(String articles) {
        this.articles = articles;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setAuthorcount(String authorcount) {
        this.authorcount = authorcount;
    }

    public void setResearchSubjects(String[] researchSubjects) {
        this.researchSubjects = researchSubjects;
    }

    public void setResearchConcepts(String[] researchConcepts) {
        this.researchConcepts = researchConcepts;
    }

    public void setResearchMethods(String[] researchMethods) {
        this.researchMethods = researchMethods;
    }

    public void setSource(String[] sources) {
        this.sources = sources;
    }

    public void setInformants(String[] informants) {
        this.informants = informants;
    }

    public void setInformantCount(String informantCount) {
        this.informantCount = informantCount;
    }

    public void setClasses(String[] classes) {
        this.classes = classes;
    }

    public void addClass(String newClass) {
        if (this.classes == null) {
            this.classes = new String[0];
        }
        String[] tmp = new String[this.classes.length + 1];
        for (int i = 0; i < this.classes.length; i++) {
            tmp[i] = this.classes[i];
        }
        tmp[tmp.length - 1] = newClass;
        this.classes = tmp;
    }

    public void setContext(String[] context) {
        this.context = context;
    }

    public void setPggrade(String pggrade) {
        this.pggrade = pggrade;
    }

    public void setDtgrade(String dtgrade) {
        this.dtgrade = dtgrade;
    }

    @Override
    public String toString() {
        return "Thesis : " + "year= " + year + "\n\tauthors= " + Arrays.toString(authors) + "\n\tname= "
                + name + "\n\tlevel= " + level + "\n\ttype= " + type + "\n\tarticles= "
                + articles + "\n\tlanguage= " + language + "\n\tauthorcount= "
                + authorcount + "\n\tresearchSubjects= " + Arrays.toString(researchSubjects)
                + "\n\tresearchConcepts= " + Arrays.toString(researchConcepts) + "\n\tresearchMethods= "
                + Arrays.toString(researchMethods) + "\n\tsource= " + Arrays.toString(sources) + "\n\tinformants= "
                + Arrays.toString(informants) + "\n\tinformantCount= " + informantCount + "\n\tclasses= "
                + Arrays.toString(classes) /*+ "\n\tframesOfReference= " + Arrays.toString(framesOfReference)*/ + "\n\tcontext= "
                + Arrays.toString(context) + "\n\tpggrade= " + pggrade + "\n\tdtgrade= " + dtgrade + "\n";
    }

    public int getRowNum() {
        return rowNum;
    }

    public String getYear() {
        return year;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String getAuthorsAsString() {
        String tmp = "";
        for (int i = 0; i < authors.length; i++) {
            tmp += authors[i];
            tmp += "\n";
        }
        return tmp;
    }

    public String getName() {
        return name;
    }
    public String getGrades() {
        return name;
    }
    public String getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    public String getArticles() {
        return articles;
    }

    public String getLanguage() {
        return language;
    }

    public String getAuthorcount() {
        return authorcount;
    }

    public String[] getResearchSubjects() {
        return researchSubjects;
    }

    public String getResearchSubjectsAsString() {
        String tmp = "";
        for (int i = 0; i < researchSubjects.length; i++) {
            tmp += researchSubjects[i];
            tmp += "\n";
        }
        return tmp;
    }

    public String[] getResearchConcepts() {
        return researchConcepts;
    }

    public String getResearchConceptsAsString() {
        String tmp = "";
        for (int i = 0; i < researchConcepts.length; i++) {
            tmp += researchConcepts[i];
            tmp += "\n";
        }
        return tmp;
    }

    public String[] getResearchMethods() {
        return researchMethods;
    }

    public String getResearchMethodsAsString() {
        String tmp = "";
        for (int i = 0; i < researchMethods.length; i++) {
            tmp += researchMethods[i];
            tmp += "\n";
        }
        return tmp;
    }

    public String[] getSources() {
        return sources;
    }

    public String getSourcesAsString() {
        String tmp = "";
        for (int i = 0; i < sources.length; i++) {
            tmp += sources[i];
            tmp += "\n";
        }
        return tmp;
    }

    public String[] getInformants() {
        return informants;
    }

    public String getInformantsAsString() {
        String tmp = "";
        for (int i = 0; i < informants.length; i++) {
            tmp += informants[i];
            tmp += "\n";
        }
        return tmp;
    }

    public String getInformantCount() {
        return informantCount;
    }

    public String[] getClasses() {
        return classes;
    }

    public String getClassesAsString() {
        String tmp = "";
        for (int i = 0; i < classes.length; i++) {
            tmp += classes[i];
            tmp += "\n";
        }
        return tmp;
    }

    public String[] getContext() {
        return context;
    }

    public String getContextAsString() {
        String tmp = "";
        for (int i = 0; i < context.length; i++) {
            tmp += context[i];
            tmp += "\n";
        }
        return tmp;
    }

    public String getPggrade() {
        return pggrade;
    }

    public String getDtgrade() {
        return dtgrade;
    }

}
