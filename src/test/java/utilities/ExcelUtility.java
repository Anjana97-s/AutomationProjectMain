package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static Object[][] getTestData(String filePath,String sheetName) throws IOException
	{
FileInputStream file = new FileInputStream(filePath);

XSSFWorkbook work = new XSSFWorkbook(file);

XSSFSheet sheet = work.getSheet(sheetName);
int rows= sheet.getLastRowNum();
//System.out.println("rows"+rows);
int cols=sheet.getRow(0).getLastCellNum();
//System.out.println("cols"+cols);
Object[][] data=new Object[rows][cols];
DataFormatter formatter= new DataFormatter();
for(int i=1;i<=rows;i++)
{
	for(int j=0;j<cols;j++)
	{
		data[i-1][j]=formatter.formatCellValue(sheet.getRow(i).getCell(j));
	}
}

work.close();
file.close();
return data;

	}

}
