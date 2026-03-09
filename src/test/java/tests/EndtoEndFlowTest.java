package tests;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobjectmodel.*;
import pojofiles.OrderPojo;
import pojofiles.PlaceorderPojo;
import pojofiles.ProductPojo;
import pojofiles.SiginPojo;
import testcomponents.Baseclass;
import utilities.generation.MobileGenerations;
@Listeners(testcomponents.ListenersClass.class)
public class EndtoEndFlowTest extends Baseclass
{
    SiginPojo siginPojo = new SiginPojo();
    PlaceorderPojo placeorderPojo = new PlaceorderPojo();
    ProductPojo productPojo  = new ProductPojo();
    OrderPojo orderPojo = new OrderPojo();
    LandingPage signupPage;
    BrandPage brandPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    ProductPage productPage;
    OrderPage orderPage;

    @Test(priority = 1)
    public void Signup() throws InterruptedException
    {
        signupPage = new LandingPage(driver);
        signupPage.clickLoginAccount();
        signupPage.clickCreateAccount();
        signupPage.selectIndiaCountry();
        siginPojo.setMobile(MobileGenerations.generateMobileNumber());
        signupPage.enterMobile(siginPojo.getMobile());
        signupPage.clickContinue();
        signupPage.enterOTP(siginPojo.getOtp());
        signupPage.enterUserDetails(siginPojo.getFname(), siginPojo.getLname(), siginPojo.getEmail());
        brandPage = signupPage.submitSignup();
        // verify account creation
        Assert.assertEquals(signupPage.getaccname(),siginPojo.getFullName());
    }

    @Test(priority = 2)
    public void NavigateToBrand()
    {
        brandPage = new BrandPage(driver);
        brandPage.hoverOnBrandsMenu();
        brandPage.selectAlphabet(productPojo.getCatagory());
        productPage = brandPage.selectBrand(productPojo.getBrand());
        // verify brand
        Assert.assertEquals(brandPage.brandpage(),productPojo.matchbrand());
    }

    @Test(dependsOnMethods = "NavigateToBrand", priority = 3)
    public void productSelection()
    {
        productPage.selectProduct(productPojo.getProductName());
        productPage.productName();
        //Verify product name
        Assert.assertEquals(productPage.productName(),productPojo.choosenProductName());
        // verify product price
        Assert.assertEquals(productPage.getPrice(),productPojo.currentPrice());
        // verify product quantity
        Assert.assertEquals(productPage.getQuantity(),productPojo.currentQuantity());
        // verify cart button
        Assert.assertTrue(productPage.isAddtocartVisible());
    }

    @Test(priority = 4)
    public void addProductToCart()
    {
        cartPage = productPage.addToCart();
        Assert.assertEquals(productPage.getcartCount(),productPojo.currentQuantity());
    }


    @Test(priority = 5)
    public void cartPageValidation()
    {
        cartPage.openCart();
        if(cartPage.verifyProductInCart(productPojo.getProductName()))
        {
            System.out.println("Product is Verified");
        }
        // verify product name (cart)
        Assert.assertEquals(cartPage.getProductTitle(),productPojo.choosenProductName());
        // verify product quantity (cart)
        Assert.assertEquals(cartPage.getquantity(),productPojo.currentQuantity());
        // verify product price (cart)
        System.out.println("Price : "+cartPage.getprice());
        Assert.assertTrue(productPojo.getCartPrice(cartPage.getprice()));
    }

    @Test(priority = 6)
    public void checkout()
    {
        checkoutPage = cartPage.proceedToCheckout();
        paymentPage = checkoutPage.fillAddress(placeorderPojo.getFirstname(), placeorderPojo.getLastname(), placeorderPojo.getAddress(), placeorderPojo.getPin());
        Assert.assertTrue(checkoutPage.isaddressSaved());
    }

    @Test(priority = 7)
    public  void paymentOrder()
    {
        paymentPage.enterCardNumber(placeorderPojo.getCard_number());
        paymentPage.enterCVV(placeorderPojo.getCvv());
        paymentPage.enterExpiryAndName(placeorderPojo.getExpire(), placeorderPojo.getCardName());
        orderPage =  paymentPage.placeOrder();
        // verify order confirmation
        Assert.assertTrue(paymentPage.verifyOrderSuccess());
    }

    @Test(priority = 8)
    public void orderpage()
    {

        // verify the thankyou message
        Assert.assertEquals(orderPage.getMessage(),orderPojo.getTqmsg());
        // verify the order id
        Assert.assertTrue(orderPage.isvalidOrderId());
    }

    @Test(priority = 9)
    public void logout1()
    {
        landingPage.logout();
    }

}

