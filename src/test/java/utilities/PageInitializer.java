package utilities;


import pages.AccountPage;
import pages.AddressPage;
import pages.CheckoutPage;
import pages.CommonPage;
import pages.CreateAccountPage;
import pages.EditAccountPage;
import pages.HomePage;
import pages.LogInPage;
import pages.MenProductPage;
import pages.MyWishListPage;
import pages.OrderPage;
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
	public static CreateAccountPage cap;
	public static EditAccountPage ep;
	public static OrderPage op;
	public static MenProductPage mpp;
	public static CheckoutPage cop;


	public static void initialize() {
		cp = new CommonPage();
		hp = new HomePage();
		lp = new LogInPage();
		wp = new WhatIsNewPage();
		pp = new ProductDetailPage();
		mp = new MyWishListPage();
		ca = new AccountPage();
		cb = new AddressPage();
		cap = new CreateAccountPage();
		ep = new EditAccountPage();
		op = new OrderPage();
		mpp = new MenProductPage();
		cop = new CheckoutPage();

	}

}
