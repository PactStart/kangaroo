import io.github.pactstart.chuanglan.autoconfiguration.ChuangLanConfig;
import io.github.pactstart.chuanglan.autoconfiguration.ChuangLanSmsClient;

public class SmsTest {

    public static void main(String[] args) {
        ChuangLanConfig chuangLanConfig = new ChuangLanConfig();
        chuangLanConfig.setAccount("");
        chuangLanConfig.setPassword("");
        chuangLanConfig.setUrl("http://smssh1.253.com");
        ChuangLanSmsClient chuangLanSmsClient = new ChuangLanSmsClient(chuangLanConfig);
        chuangLanSmsClient.sendSmsVariableRequest("【陀螺世界】验证码{$var}，您正在登录陀螺世界，请不要把验证码透露给其他人！", "150xxxxxxxx,888888;");

    }
}
