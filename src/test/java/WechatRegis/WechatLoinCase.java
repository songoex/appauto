package WechatRegis;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class WechatLoinCase {
	// device name:
	private AppiumDriver androidDriver;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		// 配置对象信息，添加设备名，app包名，app页面
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "127.0.0.1:26944");
		desiredCapabilities.setCapability("appPackage", "com.tencent.mm");
		desiredCapabilities.setCapability("appActivity", "com.tencent.mm.ui.LauncherUI");
		// appium接收请求的rest接口
		URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		// 创建驱动对象
		androidDriver = new AndroidDriver(url, desiredCapabilities);
	}

	@Test
	public void test() {
		androidDriver.findElementByXPath("//android.widget.Button[@text='登录']").click();
		androidDriver.findElementByXPath("//android.widget.EditText[@text='请填写手机号']").click();

	}

	@AfterClass
	public void tearDown() {
		androidDriver.quit();
	}
}
