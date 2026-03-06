package pojofiles;
import utilities.generation.EmailGeneration;
public class SiginPojo
{
    private String mobile;
    private String email;
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
