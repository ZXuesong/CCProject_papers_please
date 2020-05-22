package Corpus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CorpusLoader {
	
	public static List<String> before_check_both = new ArrayList<String>();
	public static List<String> before_check_pass = new ArrayList<String>();
	public static List<String> before_check_refuse = new ArrayList<String>();
	
	public static List<String> final_pass_val_f = new ArrayList<String>();
	public static List<String> final_pass_val_r = new ArrayList<String>();
	public static List<String> final_pass_inval_f = new ArrayList<String>();
	public static List<String> final_pass_inval_r = new ArrayList<String>();
	public static List<String> final_refuse = new ArrayList<String>();
	
	public static List<String> after_check_nor = new ArrayList<String>();
	public static List<String> after_check_exp_n = new ArrayList<String>();
	public static List<String> after_check_exp_e = new ArrayList<String>();
	public static List<String> after_check_exp_i = new ArrayList<String>();
	public static List<String> after_check_exp_c = new ArrayList<String>();
	public static List<String> after_check_ple_g = new ArrayList<String>();
	public static List<String> after_check_ple_ant = new ArrayList<String>();
	public static List<String> after_check_ple_imp = new ArrayList<String>();
	public static List<String> after_check_ple_kol = new ArrayList<String>();
	public static List<String> after_check_ple_rep = new ArrayList<String>();
	public static List<String> after_check_ple_uni = new ArrayList<String>();

	
	public CorpusLoader() throws FileNotFoundException, IOException {
		String rootPath = System.getProperty("user.dir").replace("\\", "/");
		String path = rootPath+ "/src/Corpus/before_check.xlsx";
		File excelFile = new File(path); 
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(excelFile));
		XSSFSheet sheet = wb.getSheetAt(0);
		for(int i=1;i<sheet.getPhysicalNumberOfRows();i++) {
			before_check_both.add(sheet.getRow(i).getCell(0).toString());
			before_check_pass.add(sheet.getRow(i).getCell(1).toString());
			before_check_refuse.add(sheet.getRow(i).getCell(2).toString());
		}
		wb.close();
		
		String path_2 = rootPath+ "/src/Corpus/final.xlsx";
		File excelFile_2 = new File(path_2); 
		XSSFWorkbook wb_2 = new XSSFWorkbook(new FileInputStream(excelFile_2));
		XSSFSheet sheet_2 = wb_2.getSheetAt(0);
		for(int i=1;i<sheet_2.getPhysicalNumberOfRows();i++) {
			final_pass_val_f.add(sheet_2.getRow(i).getCell(0).toString());
			final_pass_val_r.add(sheet_2.getRow(i).getCell(1).toString());
			final_pass_inval_f.add(sheet_2.getRow(i).getCell(2).toString());
			final_pass_inval_r.add(sheet_2.getRow(i).getCell(3).toString());
			final_refuse.add(sheet_2.getRow(i).getCell(4).toString());
		}
		
		XSSFSheet sheet_3 = wb_2.getSheetAt(1);
		for(int i=1;i<sheet_3.getPhysicalNumberOfRows();i++) {
			after_check_nor.add(sheet_3.getRow(i).getCell(0).toString());
			after_check_exp_n.add(sheet_3.getRow(i).getCell(1).toString());
			after_check_exp_e.add(sheet_3.getRow(i).getCell(2).toString());
			after_check_exp_i.add(sheet_3.getRow(i).getCell(3).toString());
			after_check_exp_c.add(sheet_3.getRow(i).getCell(4).toString());
			after_check_ple_g.add(sheet_3.getRow(i).getCell(5).toString());
			after_check_ple_ant.add(sheet_3.getRow(i).getCell(6).toString());
			after_check_ple_imp.add(sheet_3.getRow(i).getCell(7).toString());
			after_check_ple_kol.add(sheet_3.getRow(i).getCell(8).toString());
			after_check_ple_rep.add(sheet_3.getRow(i).getCell(9).toString());
			after_check_ple_uni.add(sheet_3.getRow(i).getCell(10).toString());
		}
		wb_2.close();
	}
	


}
