package UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BaseLayer.BaseClass;

public class ExcelReader extends BaseClass {

	public static XSSFWorkbook workbook;

	public ExcelReader(String path) {
		File f = new File(path);
		try {
			FileInputStream fis = new FileInputStream(f);
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int getRowNum(int index) {
		return workbook.getSheetAt(index).getLastRowNum() + 1;
	}

	public static int getCellNum(int index) {
		return workbook.getSheetAt(index).getRow(0).getLastCellNum();
	}

	public Object getSpecificcell(int index, int row, int col) {
		XSSFCell cell = workbook.getSheetAt(index).getRow(row).getCell(col);

		if (cell == null) {
			return "";
		}
		if (cell != null) {
			if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
				return cell.getBooleanCellValue();
			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
				return cell.getRawValue();
			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
				return cell.getCellFormula();
			}
		}
		return null;
	}

	public Object[][] getSheetData(int index) {

		int rows = getRowNum(index);
		int cells = getCellNum(index);

		Object[][] data = new Object[rows][cells];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cells; j++) {
				data[i][j] = getSpecificcell(index, i, j);
			}
		}
		return data;
	}

}
