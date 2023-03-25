import com.demo.StartSpringBootApplication;
import com.demo.service.IMessageService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("system@aigs.ltd");
        message.setTo("644669785@qq.com");
        message.setTo("2891873602@qq.com");
        message.setSubject("爱果持续为您服务");
        message.setText("This is a test email from Spring Boot and JavaMailSender.");
        javaMailSender.send(message);
    }
}
