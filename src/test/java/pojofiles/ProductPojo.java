package pojofiles;

public class ProductPojo
{
    private String productName;
    private String catagory;
    private String brand;

    public String getProductName()
    {
        setProductName("COOFANDY Mens Muscle");
        return productName;
    }

    public void setProductName(String productName)
    {

        this.productName = productName;
    }

    public String getCatagory()
    {
        setCatagory("a");
        return catagory;
    }

    public void setCatagory(String catagory)
    {
        this.catagory = catagory;
    }

    public String getBrand()
    {
        setBrand("Adidas");
        return brand;
    }

    public String  matchbrand()
    {
        return "ADIDAS";
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String choosenProductName()
    {
        return "COOFANDY Mens Muscle T-Shirts V-Neck Slim Fit Workout Shirt Short Sleeve Longline Gym Athletic Tee Shirts A-black Largess";
    }

    public String currentPrice()
    {
        return "$19.79";
    }

    public boolean getCartPrice(String price)
    {
        return price.contains("19.99");
    }

    public String currentQuantity()
    {
        return "1";
    }
}
