package pojofiles;
import utilities.generation.EmailGeneration;
public class SiginPojo
{
    private String mobile;
    private String email;
    private String otp;
    private String fname;
    private String lname;

    public String getFname()
    {
        setFname("Madhan");
        return fname;
    }

    public String getFullName()
    {
        return getFname() + " " + getLname();
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname()
    {
        setLname("Kumar B");
        return lname;
    }

    public void setLname(String lname)
    {

        this.lname = lname;
    }

    public String getOtp()
    {
        setOtp("1111");
        return otp;
    }

    public void setOtp(String otp)
    {
        this.otp = otp;
    }

    public String getMobile()
    {
        return mobile;
    }
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
    public String getEmail()
    {
        setEmail(EmailGeneration.generateRandomEmail());
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
}
