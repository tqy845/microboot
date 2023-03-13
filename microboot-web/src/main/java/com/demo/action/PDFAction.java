package com.demo.action;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/data/*")
public class PDFAction {
    @GetMapping("pdf")
    public void createPDF(HttpServletResponse httpServletResponse) throws IOException, DocumentException {
        httpServletResponse.setHeader("Content-type", "application/pdf");
        // 开始强制下载
        httpServletResponse.setHeader("Content-Dispositon", "attachement;filename=aigs.pdf");
        // 生成PDF文件
        Document document = new Document(PageSize.A4, 10, 10, 50, 20);
        // 获取PDF输出流配置
        PdfWriter.getInstance(document, httpServletResponse.getOutputStream()); // 获取输出流配置
        // 构建PDF内容
        document.open();
        // 利用资源匹配符，配置图片资源路径
        Resource imageResource = new ClassPathResource("/images/阿狸.jpg");
        // 通过指定路径加载图片
        // PDF文件在生成的时候是基于坐标的方式实现的绘制处理
        Image image = Image.getInstance(imageResource.getFile().getAbsolutePath());
        image.scaleToFit(PageSize.A4.getWidth() / 2, PageSize.A4.getHeight());
        // 定义绘制的坐标
        float pointX = (PageSize.A4.getWidth() / 2) - (image.getScaledWidth() / 2);
        float pointY = PageSize.A4.getHeight() - image.getScaledHeight() - 100;
        image.setAbsolutePosition(pointX, pointY);
        // 追加图片到PDF
        document.add(image);
        // 图片之后换3行输出文字内容
        document.add(new Paragraph("\n\n\n"));
        // 要输出正常的中文，必须设置字库
        Resource fontResource = new ClassPathResource("/fonts/Alibaba-PuHuiTi-B.ttf");
        BaseFont baseFont = BaseFont.createFont(fontResource.getFile().getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        // 定义要使用的字库
        Font font = new Font(baseFont, 20, Font.NORMAL);
        // 在PDF文件中开始绘制文本信息
        String[] titles = new String[]{"标题1", "标题2", "标题3"};
        String[] contents = new String[]{"文本1", "文本2", "本文3"};
        for (int i = 0; i < titles.length; i++) {
            // 创建表格
            PdfPTable table = new PdfPTable(2);
            // 创建单元格
            PdfPCell cell = new PdfPCell();
            // 定义单元格文字
            cell.setPhrase(new Phrase(titles[i], font));
            table.addCell(cell);

            cell = new PdfPCell();
            cell.setPhrase(new Phrase(contents[i], font));
            table.addCell(cell);
            document.add(table);
        }
        document.close();
    }
}
