package com.ojieabujoel.helper;

import com.ojieabujoel.model.Branch;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"BR_NM", "BR_CD", "BR_ADDR", "CITY", "EMAIL", "PHONE_NO", "HO_FG",
            "REGION_FG", "BIC_CD"};
    static String SHEET = "branch";
    public static boolean hasExcelFormat(MultipartFile file){
        if(!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
        }
        public static List<Branch>excelToBranches(InputStream inputStream){
        try{
            //Workbook workbook = new XSSFWorkbook(inputStream);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            List <Branch> branches = new ArrayList<Branch>();
            int rowNumber = 0;
            while (rows.hasNext()){
                Row currentRow = rows.next();
                //skip header
                if (rowNumber==0){
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow= currentRow.iterator();
                Branch branch = new Branch();
                int cellIdx = 0;
                while(cellsInRow.hasNext()){
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx){
                        case 0:
                            branch.setCode((long)currentCell.getNumericCellValue());
                            break;
                        case 1:
                            branch.setName(currentCell.getStringCellValue());
                            break;
                        case 2:
                            branch.setAddress(currentCell.getStringCellValue());
                            break;
                        case 3:
                            branch.setCity(currentCell.getStringCellValue());
                            break;
                        case 4:
                            branch.setEmail(currentCell.getStringCellValue());
                            break;
                        case 5:
                            branch.setPhone_number((long)currentCell.getNumericCellValue());
                            break;
                        case 6:
                            branch.setHead_office((int)currentCell.getNumericCellValue());
                            break;
                        case 7:
                            branch.setReg_off_flag((int) currentCell.getNumericCellValue());
                            break;
                        case 8:
                            branch.setSwift_bicc((int) currentCell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                branches.add(branch);
            }
            workbook.close();
            return branches;
        }catch (IOException e){
            throw new RuntimeException("fail to parse excel file: "+ e.getMessage());
        }
    }
}
