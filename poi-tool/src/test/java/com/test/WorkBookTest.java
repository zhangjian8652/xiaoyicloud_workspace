package com.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhangjian on 2016/9/22.
 */
public class WorkBookTest {

    private String filePath = "D://test/workbook.xls";

    @Test
    public void newWorkbook() throws IOException {
        Workbook wb = new HSSFWorkbook();

        FileOutputStream fileOut = new FileOutputStream(this.filePath);
        wb.write(fileOut);
        fileOut.close();

    }


    public void newSheet() throws IOException {
        Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
        Sheet sheet1 = wb.createSheet("new sheet");
        Sheet sheet2 = wb.createSheet("second sheet");

        // Note that sheet name is Excel must not exceed 31 characters
        // and must not contain any of the any of the following characters:
        // 0x0000
        // 0x0003
        // colon (:)
        // backslash (\)
        // asterisk (*)
        // question mark (?)
        // forward slash (/)
        // opening square bracket ([)
        // closing square bracket (])

        // You can use org.apache.poi.ss.util.WorkbookUtil#createSafeSheetName(String nameProposal)}
        // for a safe way to create valid names, this utility replaces invalid characters with a space (' ')
        String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]"); // returns " O'Brien's sales   "
        Sheet sheet3 = wb.createSheet(safeName);

        FileOutputStream fileOut = new FileOutputStream(this.filePath);
        wb.write(fileOut);
        fileOut.close();
    }

    public void createCells() throws IOException {
        Workbook wb = new HSSFWorkbook();
        //Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow((short)0);
        // Create a cell and put a value in it.
        Cell cell = row.createCell(0);
        cell.setCellValue(1);

        // Or do it on one line.
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(
                createHelper.createRichTextString("This is a string"));
        row.createCell(3).setCellValue(true);

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(this.filePath);
        wb.write(fileOut);
        fileOut.close();
    }


    public void createDateCells() throws IOException {
        Workbook wb = new HSSFWorkbook();
        //Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(0);

        // Create a cell and put a date value in it.  The first cell is not styled
        // as a date.
        Cell cell = row.createCell(0);
        cell.setCellValue(new Date());

        // we style the second cell as a date (and time).  It is important to
        // create a new cell style from the workbook otherwise you can end up
        // modifying the built in style and effecting not only this cell but other cells.
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
        cell = row.createCell(1);
        cell.setCellValue(new Date());
        cell.setCellStyle(cellStyle);

        //you can also set date as java.util.Calendar
        cell = row.createCell(2);
        cell.setCellValue(Calendar.getInstance());
        cell.setCellStyle(cellStyle);

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(this.filePath);
        wb.write(fileOut);
        fileOut.close();
    }


    public void diferentTypesCells() throws IOException {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("new sheet");
        Row row = sheet.createRow((short)2);
        row.createCell(0).setCellValue(1.1);
        row.createCell(1).setCellValue(new Date());
        row.createCell(2).setCellValue(Calendar.getInstance());
        row.createCell(3).setCellValue("a string");
        row.createCell(4).setCellValue(true);
        //row.createCell(5).setCellType(CellType.ERROR);

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(this.filePath);
        wb.write(fileOut);
        fileOut.close();
    }


    public void files() throws IOException, InvalidFormatException {
        // Use a file
        Workbook wb = WorkbookFactory.create(new File(this.filePath));

    }


    public void inputStream() throws IOException, InvalidFormatException {

        // Use an InputStream, needs more memory
        Workbook wb = WorkbookFactory.create(new FileInputStream(this.filePath));
    }

    public void NPOIFSFile() throws IOException {
        // HSSFWorkbook, File
        NPOIFSFileSystem fs = new NPOIFSFileSystem(new File(this.filePath));
        HSSFWorkbook wb = new HSSFWorkbook(fs.getRoot(), true);

        fs.close();

    }

    public void NPOIInputStream() throws IOException {
        // HSSFWorkbook, InputStream, needs more memory
        NPOIFSFileSystem fs = new NPOIFSFileSystem(new FileInputStream(new File(this.filePath)));
        HSSFWorkbook wb = new HSSFWorkbook(fs.getRoot(), true);
    }

    public void OPCPackageFile() throws InvalidFormatException, IOException {
        // XSSFWorkbook, File
        OPCPackage pkg = OPCPackage.open(new File(this.filePath));
        XSSFWorkbook wb = new XSSFWorkbook(pkg);

        pkg.close();


    }


    public void OPCPackageInputStream() throws IOException, InvalidFormatException {
        // XSSFWorkbook, InputStream, needs more memory
        OPCPackage pkg = OPCPackage.open(new FileInputStream(new File(this.filePath)));
        XSSFWorkbook wb = new XSSFWorkbook(pkg);

        pkg.close();
    }
}
