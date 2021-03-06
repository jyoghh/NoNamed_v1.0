package jiho.marvel01.controller;

import jiho.marvel01.domain.Entity.ExcelEntity;
import jiho.marvel01.dto.ExcelDto;
import jiho.marvel01.dto.UserDto;
import jiho.marvel01.service.ExcelService;
import jiho.marvel01.service.UserService;
import jiho.marvel01.util.ExcelRead;
import jiho.marvel01.util.ExcelReadOption;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class ExcelController {

    @Autowired
  private ExcelService excelService;
    @Autowired
  private UserService userService;


  @GetMapping("/excel")
  public String main() { // 1
    return "excel";
  }

  @PostMapping("/excel/read")
  public String readExcel(@RequestParam("file") MultipartFile file, Model model)
      throws IOException { // 2

    List<ExcelDto> list = new ArrayList<>();

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

      ExcelDto excelDto1 = ExcelDto.builder()
              .email(row.getCell(1).getStringCellValue())
              .name(row.getCell(2).getStringCellValue())
              .corp(row.getCell(3).getStringCellValue())
              .department(row.getCell(4).getStringCellValue())
              .ranks(row.getCell(5).getStringCellValue())
              .codes(row.getCell(6).getStringCellValue())
              .status(row.getCell(7).getStringCellValue())
              .i_group((int)row.getCell(8).getNumericCellValue())
              .build();

      list.add(excelDto1);
    }
    model.addAttribute("datas", list); // 5
    return "page/excelList";

  }

    @RequestMapping(value = "/excelUploadAjax", method = RequestMethod.POST)
    public @ResponseBody Object excelUploadAjax(MultipartHttpServletRequest request)  throws Exception{
        MultipartFile excelFile =request.getFile("excelFile");
        System.out.println("엑셀 파일 업로드 컨트롤러");
        if(excelFile==null || excelFile.isEmpty()){
            throw new RuntimeException("엑셀파일을 선택 해 주세요.");
        }

        File destFile = new File("D:\\"+excelFile.getOriginalFilename());
        try{
            excelFile.transferTo(destFile);
        }catch(IllegalStateException | IOException e){
            throw new RuntimeException(e.getMessage(),e);
        }

        //Service 단에서 가져온 코드
        ExcelReadOption excelReadOption = new ExcelReadOption();
        excelReadOption.setFilePath(destFile.getAbsolutePath());
        excelReadOption.setOutputColumns("B","C","D","E","F","G","H","I");
        excelReadOption.setStartRow(2);

        List<Map<String, String>>excelContent = ExcelRead.read(excelReadOption);

        //userService.excelUpload(destFile); //서비스 부분을 삭제한다.
        //FileUtils.forceDelete(destFile.getAbsolutePath());

        Object result = excelContent;
        return result;
    }


}

