package utilities;


import pages.AddressPage;
import pages.AccountPage;
import pages.CommonPage;
import pages.HomePage;
import pages.LogInPage;
import pages.MyWishListPage;
import pages.ProductDetailPage;
import pages.WhatIsNewPage;

public class PageInitializer extends BaseClass {

	public static CommonPage cp;
	public static HomePage hp;
	public static LogInPage lp;
	public static WhatIsNewPage wp;
	public static ProductDetailPage pp;
	public static MyWishListPage mp;
	
	public static AccountPage ca;
	public static AddressPage cb;


	public static void initialize() {
		cp = new CommonPage();
		hp = new HomePage();
		lp = new LogInPage();
		wp = new WhatIsNewPage();
		pp = new ProductDetailPage();
		mp = new MyWishListPage();
		ca = new AccountPage();
		cb = new AddressPage();


	}

}
