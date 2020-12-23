package jiho.marvel01.controller;

import jiho.marvel01.domain.Entity.ExcelEntity;
import jiho.marvel01.service.UserService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExcelController {

      private UserService userService;


  @GetMapping("/excel")
  public String main() { // 1
    return "excel";
  }


  @PostMapping("/excel/read")
  public String readExcel(@RequestParam("file") MultipartFile file, Model model)
      throws IOException { // 2

    List<ExcelEntity> dataList = new ArrayList<>();

    String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // 3

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

    for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) { // 4

      Row row = worksheet.getRow(i);

      ExcelEntity data = new ExcelEntity();

      Map<String, String> datas = new HashMap<String, String>();
      Integer i_group = (int) row.getCell(8).getNumericCellValue();

      datas.put("email",row.getCell(1).getStringCellValue());
      datas.put("name",row.getCell(2).getStringCellValue());
      datas.put("corp",row.getCell(3).getStringCellValue());
      datas.put("depart",row.getCell(4).getStringCellValue());
      datas.put("ranks",row.getCell(5).getStringCellValue());
      datas.put("codes",row.getCell(6).getStringCellValue());
      datas.put("status",row.getCell(7).getStringCellValue());
//      data.setNum((int) row.getCell(0).getNumericCellValue());
//      data.setName(row.getCell(1).getStringCellValue());
//      data.setCorp(row.getCell(2).getStringCellValue());
      dataList.add(data);

      userService.insertUser(datas, i_group);
    }

    model.addAttribute("datas", dataList); // 5

    return "/page/excelList";

  }
}
