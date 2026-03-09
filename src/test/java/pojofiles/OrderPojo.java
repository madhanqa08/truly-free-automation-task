package pojofiles;

public class OrderPojo
{
    private  String tqmsg;

    public String getTqmsg()
    {
        setTqmsg("Thank You!");
        return tqmsg;
    }

    public void setTqmsg(String tqmsg)
    {
        this.tqmsg = tqmsg;
    }
}
