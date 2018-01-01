package com.apachepoi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromFile
{
    private static final String FILE_NAME = "src/main/resources/testfile.xlsx";

	public static void main(String[] args)
	{
		//writeFile();
		Map<Integer, Movie> readFile = readFile();
		System.out.println(readFile.get(1).getName());
		for (Movie string : readFile.values())
		{
			System.out.println(" \t "+string.getId()+" \t "+string.getName()+" \t"+string.getType());
		}
	}
	
	public static Map<Integer, Movie> readFile()
	{
		//InputStream is = ReadFromFile.class.getClassLoader().getResourceAsStream("testfile.xlsx");
		Map<Integer, Movie> map =new HashMap<Integer, Movie>();
		try
		{
			FileInputStream fis =new FileInputStream(FILE_NAME);
			XSSFWorkbook wb =new XSSFWorkbook(fis);
			Sheet sheetAt = wb.getSheetAt(0);
			Iterator<Row> iterator = sheetAt.iterator();
			
			Movie movie =null;
			while (iterator.hasNext())
			{
				Row currentRow = iterator.next();
				Integer value =1;
				if(currentRow.getRowNum() > 0)
				{
					Iterator<Cell> cellIterator = currentRow.iterator();
					
					while (cellIterator.hasNext())
					{
						value++;
						movie =new Movie();
						XSSFCell currentCell = (XSSFCell) cellIterator.next();
						//getCellTypeEnum shown as deprecated for version 3.15
	                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
						if (currentCell.getCellType() == CellType.NUMERIC.getCode()) {
							System.out.println("555555555555");
							//movie.setId(currentCell.getNumericCellValue());
	                        System.out.print(currentCell.getNumericCellValue() + "	\t	");
	                    }
						else if(currentCell.getCellType() == CellType.STRING.getCode())
						{
								movie.setId(currentCell.getStringCellValue());
								movie.setName(currentCell.getStringCellValue());
								movie.setType(currentCell.getStringCellValue());
								System.out.print(currentCell.getStringCellValue() + "	\t	");
						} 
						map.put(currentRow.getRowNum(), movie);
						
					}
					System.out.println();
					wb.close();
				}
				
			}
			
		} catch (Exception e)
		{
			System.out.println("************** "+e.getMessage());
		}
		return map;
	}
	
	public static void writeFile()
	{
		XSSFWorkbook workbook =new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Movies details");
		
		Object[] [] movieNames ={{"movieId", "movieName", "movieType"},
									{"1", "Bahubali", "Action"},
									{"2", "Katti", "Thriller"},
									{"3", "One", "Action"},
									{"4", "Raj", "Thriller"}
									};
		int rowNum =0;
		System.out.println("Creating excel sheet...");
		
		for (Object[] movies : movieNames)
		{
			XSSFRow row = sheet.createRow(rowNum++);
			int colNum = 0;
			for (Object obj : movies)
			{
				XSSFCell cell = row.createCell(colNum++);
				if(obj instanceof String)
				{
					cell.setCellValue((String)obj);
				}
				else if(obj instanceof Integer)
				{
					cell.setCellValue((Integer)obj);
				}
			}
		}
		try{
			FileOutputStream fos =new FileOutputStream(FILE_NAME);
			workbook.write(fos);
			workbook.close();
			
		}catch(Exception e)
		{
			System.out.println("*********** "+e.getMessage());
		}
		System.out.println("************* Done **************** ");
		
	}

}
