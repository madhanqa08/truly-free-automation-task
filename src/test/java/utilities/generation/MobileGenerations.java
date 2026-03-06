package utilities.generation;
import java.util.Random;
public class MobileGenerations
{
    public static String generateMobileNumber()
    {
        Random random = new Random();
        StringBuilder mobile = new StringBuilder();
        mobile.append("  9");
        for(int i = 0; i < 9; i++)
        {
            mobile.append(random.nextInt(10));
        }
        return mobile.toString();
    }
}
