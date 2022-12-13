package com.nic.ws.spring.store;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWorkBook {

	public List<Book> readBooksFromExcelFile(String excelFilePath) throws IOException {
		List<Book> listBooks = new ArrayList<Book>();
		Workbook workbook = getWorkbook(excelFilePath);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			Book aBook = new Book();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 1:
					aBook.setTitle((String) getCellValue(nextCell));
					break;
				case 2:
					aBook.setAuthor((String) getCellValue(nextCell));
					break;
				case 3:
					aBook.setPrice(Double.parseDouble(getCellValue(nextCell).toString()));
					break;
				}

			}
			listBooks.add(aBook);
		}

		// workbook.close();

		return listBooks;
	}

	public List<List<String>> getDataFromExcelFile(String excelFilePath, String sheet_name, String[] colIndex) throws IOException {
		List<String> list = Arrays.asList(colIndex);
		List<List<String>> table = new ArrayList<List<String>>();

		Workbook workbook = getWorkbook(excelFilePath);
		Sheet sheet = workbook.getSheet(sheet_name);
		
		Iterator<Row> iterator = sheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			List<String> row = new ArrayList<String>();
			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();
				if(list.contains(columnIndex+"")) {
				row.add(getCellValue(nextCell) + "");
				}
			}
			table.add(row);
		}

		return table;
	}

	private Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();

		case Cell.CELL_TYPE_BLANK:
			return cell.getNumericCellValue();
		}

		return null;
	}

	private Workbook getWorkbook(String excelFilePath) {
		Workbook workbook = null;
		try {
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			if (excelFilePath.endsWith("xlsx")) {
				workbook = new XSSFWorkbook(inputStream);
			} else if (excelFilePath.endsWith("xls")) {
				workbook = new HSSFWorkbook(inputStream);
			} else {
				System.out.println("The specified file is not Excel file");
			}
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return workbook;
	}

}
