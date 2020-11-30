package jiho.marvel01.controller;

import jiho.marvel01.domain.Entity.ExcelEntity;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExcelController {

    @GetMapping("/excel")
    public String main() {
         return "excel";
    }


  @RequestMapping(value = "/excelRead.do", method = RequestMethod.POST)
  public List<ExcelEntity> readExcel(@RequestParam("file") MultipartFile file, Model model)
          throws IOException {

        List<ExcelEntity> dataList = new ArrayList<>();
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        if (!extension.equals("xlsx") && !extension.equals("xls")) {
          throw new IOException("엑셀파일만 업로드 해주세요.");
        }

        Workbook workbook = null;

        if (extension.equals("xlsx")) {
          workbook = new XSSFWorkbook(file.getInputStream());
        } else if (extension.equals("xls")) {
          workbook = new HSSFWorkbook(file.getInputStream());
        }

        Sheet worksheet = workbook.getSheetAt(0);

        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {

          Row row = worksheet.getRow(i);
          ExcelEntity data = new ExcelEntity();

          data.setNum((int) row.getCell(0).getNumericCellValue());
          data.setName(row.getCell(1).getStringCellValue());
          data.setEmail(row.getCell(2).getStringCellValue());
          dataList.add(data);
        }

        model.addAttribute("datas", dataList);

        return dataList;
    }

}
