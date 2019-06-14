package self;

public class Single {

    private static volatile Single instance;

    private Single() {
        if (instance != null) {
            throw new RuntimeException("Do not use reflection.");
        }
        System.out.println("Hello Single");
    }

    public static Single getInstance() {
        if (instance == null) {
            synchronized (Single.class) {
                if (instance == null)
                    instance = new Single();
            }
        }
        return instance;
    }
}
