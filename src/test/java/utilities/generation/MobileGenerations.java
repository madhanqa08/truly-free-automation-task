package utilities.generation;
import java.util.concurrent.ThreadLocalRandom;

public class MobileGenerations
{
    public static String generateMobileNumber()
    {
        StringBuilder mobile = new StringBuilder();

        mobile.append("  9");

        for(int i = 0; i < 9; i++)
        {
            mobile.append(ThreadLocalRandom.current().nextInt(10));
        }

        return mobile.toString();
    }
}
