package com.demo.action;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.export.ExcelExportService;
import com.demo.vo.Message;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/data/*")
public class ExcelAction {
    @GetMapping("excel")
    public void createExcelData(HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Content-type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=aigs.xls");

        // 数据的生成需要将数据保存在Message对象中
        String[] contents = new String[]{"文本1", "文本2", "本文3"};
        List<Message> list = new ArrayList<>();
        for (String content : contents) {
            Message message = new Message();
            message.setMsg(content);
            message.setPubdate(new Date());
            list.add(message);
        }

        // 随后开始XLS的内容配置
        ExportParams exportParams = new ExportParams("DEMO", "最新消息", ExcelType.HSSF);
        // 创建工作簿
        Workbook workbook = new HSSFWorkbook();
        new ExcelExportService().createSheet(workbook, exportParams, Message.class, list);
        workbook.write(httpServletResponse.getOutputStream());
    }
}
