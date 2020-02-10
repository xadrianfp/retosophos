package utilities;

import java.util.List;

public class DataReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		excelReader();

	}
	
	public static void excelReader () {
		//String excelName
		String fileName = System.getProperty("user.dir")+"\\Datos.xls";//, "DataDriven";
		String [][] data = utilities.Excel.get(fileName);
		
		for (String[] record : data ) {
			
			for (String field : record) {
				
				System.out.println(field);
			}
		}
		
	}
}
