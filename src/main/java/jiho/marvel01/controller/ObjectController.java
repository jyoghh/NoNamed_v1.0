package jiho.marvel01.controller;

import jiho.marvel01.dto.ObjectDto;
import jiho.marvel01.service.ObjectService;
import jiho.marvel01.util.ExcelRead;
import jiho.marvel01.util.ExcelReadOption;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@AllArgsConstructor
public class ObjectController {

    private ObjectService objectService;

    @RequestMapping("/manage_obj")
    public String manage_obj(Model model, ObjectDto objectDto) {
        model.addAttribute("title","점검대상");
        model.addAttribute("menu-expended","collapseMeasure");
        // 빠른 디버깅을 위한 더미 insert
//        objectService.insertTestObject(objectDto);
        return "page/Manage/manage_obj";
    }

    @PostMapping(value = "/register_object")
    public String register(ObjectDto objectDto) {
        objectService.saveObject(objectDto);
        return "redirect:/manage_obj";
    }

    @RequestMapping(value = "/insertObject.do", method = RequestMethod.POST)
    public @ResponseBody Object insert(ObjectDto objectDto,
                                       @RequestParam("type") String type,
                                       @RequestParam("oName") String oName,
                                       @RequestParam("purpose") String purpose,
                                       @RequestParam("oGroup") String oGroup,
                                       @RequestParam("part1") String part1,
                                       @RequestParam("part2") String part2,
                                       @RequestParam("IP") String IP,
                                       @RequestParam("location") String location) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("type", type);
        list.put("oName", oName);
        list.put("purpose", purpose);
        list.put("oGroup", oGroup);
        list.put("part1", part1);
        list.put("part2", part2);
        list.put("IP", IP);
        list.put("location", location);
        objectService.insertObject(objectDto, list);
        return list;
    }

    @RequestMapping(value = "/updateObject.do", method = RequestMethod.POST)
    public @ResponseBody Object update(ObjectDto objectDto,
                                       @RequestParam("oid") Long oid,
                                       @RequestParam("type") String type,
                                       @RequestParam("oName") String oName,
                                       @RequestParam("purpose") String purpose,
                                       @RequestParam("oGroup") String oGroup,
                                       @RequestParam("part1") String part1,
                                       @RequestParam("part2") String part2,
                                       @RequestParam("IP") String IP,
                                       @RequestParam("location") String location) {
        Map<String, String> list = new HashMap<String, String>();
        list.put("type", type);
        list.put("oName", oName);
        list.put("purpose", purpose);
        list.put("oGroup", oGroup);
        list.put("part1", part1);
        list.put("part2", part2);
        list.put("IP", IP);
        list.put("location", location);
        objectService.updateObject(oid, list);
        return list;
    }


    @GetMapping("/object_setting")
    public String objectList(Model model) {
        List<ObjectDto> objectList = objectService.getObjectlist();
        model.addAttribute("ObjectList",objectList);
        return "page/Sys_setting/object_setting";
    }

    @RequestMapping("/getObjectDatatable.do")
    public @ResponseBody Object getDatatable(HttpServletRequest request,
                                              HttpServletResponse response) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", objectService.getObjectlist());
        Object result = mp;
        return result;
    }

    @RequestMapping("/getObjectDatatablebyOid.do")
    public @ResponseBody Object getDatatableOid(HttpServletRequest request,
                                              HttpServletResponse response,
                                                @RequestParam("oid") String oid) {
        String str = oid;
        List<Long> list = new ArrayList<Long>();
        for (String s : str.split(", "))
            list.add(Long.parseLong(s));
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", objectService.getObjectlistbyId(list));
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/deleteobject.do", method = RequestMethod.POST)
    public String deleteobject(@RequestParam("oid") Long oid) {
        objectService.deleteObject(oid);
        return "redirect:/object_setting";
    }

    @RequestMapping(value = "/deleteObjects.do", method = RequestMethod.POST)
    public String deleteObjects(@RequestParam(value = "oid[]") List<Long> oid) {
         objectService.deleteObjects(oid);
         return "redirect:/object_setting";
    }

    @RequestMapping(value = "/getObject.do", method = RequestMethod.POST)
    public @ResponseBody Object getObject(@RequestParam("oid") Long oid) {
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", objectService.getObject(oid));
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/getObjects.do", method = RequestMethod.POST)
    public @ResponseBody Object getObjects(@RequestParam("oid") String oid) {
        String str = oid;
        List<Long> list = new ArrayList<Long>();
        for (String s : str.split(", "))
            list.add(Long.parseLong(s));
        Map<String, Object> mp = new HashMap<String, Object>();
        mp.put("data", objectService.getObjectlistbyId(list));
        Object result = mp;
        return result;
    }

    @RequestMapping(value = "/excelUploadObj.do", method = RequestMethod.POST)
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

        ExcelReadOption excelReadOption = new ExcelReadOption();
        excelReadOption.setFilePath(destFile.getAbsolutePath());
        excelReadOption.setOutputColumns("B","C","D","E","F","G","H","I","J","K");
        excelReadOption.setStartRow(2);

        List<Map<String, String>>excelContent = ExcelRead.read(excelReadOption);
        List<Map<String, String>> totallist = new ArrayList<Map<String, String>>();
        Map<String, String> map = null;

        for(int rpt = 0; rpt < excelContent.size(); rpt++) {
            map = new HashMap<String, String>();
            map.put("type",excelContent.get(rpt).get("B"));
            map.put("oGroup",excelContent.get(rpt).get("C"));
            map.put("part1",excelContent.get(rpt).get("D")+", ".concat(excelContent.get(rpt).get("E")));
            map.put("part2",excelContent.get(rpt).get("F")+", ".concat(excelContent.get(rpt).get("G")));
            map.put("oName",excelContent.get(rpt).get("H"));
            map.put("IP",excelContent.get(rpt).get("I"));
            map.put("purpose",excelContent.get(rpt).get("J"));
            map.put("location",excelContent.get(rpt).get("K"));
            totallist.add(map);
        }
        objectService.insertMultiObjects(totallist);

        Object result = totallist;
        return result;
    }



}

