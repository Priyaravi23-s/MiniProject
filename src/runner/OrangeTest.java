package runner;


import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class OrangeTest extends BaseClass {

	@Test
	private void browserLauncher() {
		launchBrowser("chrome");
	}
}
