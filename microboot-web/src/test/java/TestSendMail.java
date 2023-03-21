import com.demo.StartSpringBootApplication;
import com.demo.service.IMessageService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)  // 使用Junit5的测试工具
@WebAppConfiguration // 启动Web运行环境
@SpringBootTest(classes = StartSpringBootApplication.class)
public class TestSendMail {
    @Resource
    private JavaMailSender javaMailSender;


    @Test
    public void testSend() {
        // 建立邮件结构
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("system@aigs.ltd");
        simpleMailMessage.setTo("644669785@qq.com");
        simpleMailMessage.setText("this'is a demo info.");
        this.javaMailSender.send(simpleMailMessage);
    }
}
