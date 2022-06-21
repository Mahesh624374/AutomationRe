package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	
	public static String getData(int Row,int Cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\mahes\\eclipse-workspace\\KiteZerodha\\src\\test\\resources\\Automation Test Data.xlsx");
		String value = WorkbookFactory.create(file).getSheet("Credentials").getRow(Row).getCell(Cell).getStringCellValue();
		return value ;
	}

}
