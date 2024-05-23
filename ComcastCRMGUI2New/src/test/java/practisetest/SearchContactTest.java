package practisetest;

import org.testng.annotations.Test;

import com.comcast.baseutility.BaseClass;
import com.comcast.crm.createproduct.LoginPage;

public class SearchContactTest  extends BaseClass{
	/**
	 * 
	 * Scenario : login()===>navigate contact ====>create contact=====>verify
	 * 
	 * 
	 */
	@Test
	public void  searchContactTest()
	{
		LoginPage lp=new LoginPage(d);
		/*Step 1 : Login to application*/
		lp.loginToApp(null, null);
		
		
	}

}
