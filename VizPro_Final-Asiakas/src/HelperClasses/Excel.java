package HelperClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

    /**
     * Lukee dataa .xlsx -tiedostosta listaan
     *
     * @return Palauttaa ArrayListan, joka sisältää kaikki gradut
     */
	//google drive tunnus testiii12343 pass testitesti!
    public static ArrayList<Thesis> readData(String address) {
        ArrayList<Thesis> array = new ArrayList<Thesis>(); //contains all theses

        try {
            //reads the first page on the .xlsx -file
            FileInputStream fis = new FileInputStream(new File(address));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIt = sheet.iterator(); //iteroi rivejä
            Row row = null; //otetaan rivi talteen
            Iterator<Cell> cellIt = null;
            Cell cell = null; //otetaan kenttä talteen
            Thesis tmp = null;
            ArrayList<String> tmpArray = new ArrayList<String>();
            if (rowIt.hasNext()) {
                rowIt.next(); //ohitetaan ensimmäinen rivi eli otsikkorivi
            }
            while (rowIt.hasNext()) {
                row = rowIt.next();
                cellIt = row.cellIterator();
                tmp = new Thesis();
                tmp.setRowNum(row.getRowNum());
                while (cellIt.hasNext()) {
                    cell = cellIt.next();
                    //System.out.println("CELL COLUMN : " + cell.getAddress().getColumn());
                    switch (cell.getAddress().getColumn()) {
                        case 0: //Vuosi
                            tmp.setYear(String.valueOf(cell.getNumericCellValue()));
                            break;
                        case 1: //Tekijät
                            tmp.setAuthors(cell.getStringCellValue().split(","));
                            break;
                        case 2: //Tutkielman nimi
                            tmp.setName(cell.getStringCellValue());
                            break;
                        case 3: //Opinnäytteen taso
                            tmp.setLevel(cell.getStringCellValue());
                            break;
                        case 4: //Opinnäytteen muoto
                            tmp.setType(cell.getStringCellValue());
                            break;
                        case 5: //Artikkelien kieli ja lkm
                            tmp.setArticles(cell.getStringCellValue());
                            break;
                        case 6: //Opinnäytteen kieli
                            tmp.setLanguage(cell.getStringCellValue());
                            break;
                        case 7: //Tekijöiden lkm
                            tmp.setAuthorcount(cell.getStringCellValue());
                            break;
                        case 8: //Paradigman tutkimuskohteet
                            tmp.setResearchSubjects(cell.getStringCellValue().split("\n"));
                            break;
                        case 9: //Tutkimustehtävien ja -käsitteiden sijoittuminen
                            tmp.setResearchConcepts(cell.getStringCellValue().split("\n"));
                            break;
                        case 10: //Tutkimusmetodit
                            tmp.setResearchMethods(cell.getStringCellValue().split("\n"));
                            break;
                        case 11: //Aineistonkeruumenetelmät
                            tmp.setSource(cell.getStringCellValue().split("\n"));
                            break;
                        case 12: //Tietolähteet/informantit
                            tmp.setInformants(cell.getStringCellValue().split("\n"));
                            break;
                        case 13: //Tietolähteiden lukumäärä
                            //System.out.println(cell.getCellType());
                            if (cell.getCellType() == CellType.NUMERIC) {
                                tmp.setInformantCount(String.valueOf(cell.getNumericCellValue()));
                            } else if (cell.getCellType() == CellType.STRING) {
                                tmp.setInformantCount(String.valueOf(cell.getStringCellValue()));
                            } else {
                                throw new Exception("KENTÄN TYYPPI TAAS VÄÄRIN");
                            }
                            break;
                        case 14: //Luokat 1.1, 1.2 ... sekä teoreettiset mallit/viitekehykset
                            String[] tmpStrings = cell.getStringCellValue().split("\n");
                            for (int i = 0; i < tmpStrings.length; i++) {
                                if (tmpStrings[i].trim().length() > 0) {
                                    switch (tmpStrings[i].trim().charAt(0)) {
                                        case '1':
                                            tmp.addClass(tmpStrings[i]);
                                            break;
                                        case '2':
                                            tmp.addClass(tmpStrings[i]);
                                            break;
                                        case '3':
                                            tmp.addClass(tmpStrings[i]);
                                            break;
                                        case '4':
                                            tmp.addClass(tmpStrings[i]);
                                            break;
                                        default:
                                            //tmp.addFrameOfReference(tmpStrings[i]);
                                            break;
                                    }
                                }
                            }
                            break;
                        case 15: //Tutkimuksen konteksti
                            tmp.setContext(cell.getStringCellValue().split(";"));
                            break;
                        case 16: //arvosana, pro gradu
                            tmp.setPggrade(cell.getStringCellValue());
                            break;
                        case 17: //arvosana, väitöskirja
                            tmp.setDtgrade(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                }
                System.out.println(tmp.toString());
                array.add(tmp);
            }
            workbook.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    /**
     * Lisää rivin .xlsx -tiedoston loppuun.
     *
     * @param gradu Lisättävä gradu.
     * @return Tiedon siitä onnistuiko lisäys.
     */
    public static boolean addNewThesis(Thesis thesis, String address) {
        try {
            FileInputStream fis = new FileInputStream(new File(address));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row = sheet.createRow(sheet.getLastRowNum() + 1);

            row.createCell(0);
            row.getCell(0).setCellType(CellType.NUMERIC);
            row.getCell(0).setCellValue(Double.valueOf(thesis.getYear()));

            row.createCell(1).setCellStyle(workbook.createCellStyle());
            row.getCell(1).getCellStyle().setWrapText(true);
            row.getCell(1).setCellValue(thesis.getAuthorsAsString());

            row.createCell(2).setCellValue(thesis.getName());
            row.createCell(3).setCellValue(thesis.getLevel());
            row.createCell(4).setCellValue(thesis.getType());
            row.createCell(5).setCellValue(thesis.getArticles());
            row.createCell(6).setCellValue(thesis.getLanguage());
            row.createCell(7).setCellValue(thesis.getAuthorcount());

            row.createCell(8).setCellStyle(workbook.createCellStyle());
            row.getCell(8).getCellStyle().setWrapText(true);
            row.getCell(8).setCellValue(thesis.getResearchSubjectsAsString());

            row.createCell(9).setCellStyle(workbook.createCellStyle());
            row.getCell(9).getCellStyle().setWrapText(true);
            row.getCell(9).setCellValue(thesis.getResearchConceptsAsString());

            row.createCell(10).setCellStyle(workbook.createCellStyle());
            row.getCell(10).getCellStyle().setWrapText(true);
            row.getCell(10).setCellValue(thesis.getResearchMethodsAsString());

            row.createCell(11).setCellStyle(workbook.createCellStyle());
            row.getCell(11).getCellStyle().setWrapText(true);
            row.getCell(11).setCellValue(thesis.getSourcesAsString());

            row.createCell(12).setCellStyle(workbook.createCellStyle());
            row.getCell(12).getCellStyle().setWrapText(true);
            row.getCell(12).setCellValue(thesis.getInformantsAsString());

            row.createCell(13).setCellValue(thesis.getInformantCount());

            row.createCell(14).setCellStyle(workbook.createCellStyle());
            row.getCell(14).getCellStyle().setWrapText(true);
            row.getCell(14).setCellValue(thesis.getClassesAsString());

            row.createCell(15).setCellStyle(workbook.createCellStyle());
            row.getCell(15).getCellStyle().setWrapText(true);
            row.getCell(15).setCellValue(thesis.getContextAsString());

            row.createCell(16).setCellValue(thesis.getPggrade());
            row.createCell(17).setCellValue(thesis.getDtgrade());

            FileOutputStream fos = new FileOutputStream(address);
            workbook.write(fos);
            workbook.close();
            fis.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    public static boolean editThesis(Thesis thesis) {
        return false;
    }

    public static boolean editCell(Thesis thesis, String newData, String address) {
        try {
            FileInputStream fis = new FileInputStream(new File(address));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            
        } catch (Exception e) {

        }
        return false;
    }
     */
    public static boolean removeThesis(Thesis thesis, String address) {
        try {

           FileInputStream fis = new FileInputStream(new File(address));
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            sheet.removeRow(sheet.getRow(thesis.getRowNum()));
            workbook.close();
            fis.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
