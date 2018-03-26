package self;

public class Single {

    private static Single instance;

    private Single()
    {
        System.out.println("Hello Single");
    }

    public static Single getInstance()
    {
        if(instance==null)
        {
            instance = new Single();
        }

        return instance;
    }
}
