public class Chapter2 {

    private static int i = 1;

    public static void UseStatic() {
        System.out.println("This is a static method. It can be used by Class or Instance.");
    }

    public static void main(String[] args) {

        //The class name and file name must be consistent.
        //Main class must have a main() method, it accept an args of String[] type.
        UseArray();
        UseScope();

        //Both class or instance can use static members and methods, but class is recommended.
        Chapter2 chapter2 = new Chapter2();
        chapter2.UseStatic();
        chapter2.i++;

        System.getProperties().list(System.out);

        UseJavaDoc(1);
    }

    public static void UseArray() {

        int[] iArray = new int[10];
        Object[] oArray = new Object[10];

        System.out.print("Primitive Array will be initialized with 0:");
        System.out.println(iArray[0] == 0);

        System.out.print("Object Array will be initialized with null:");
        System.out.println(oArray[0] == null);
    }

    public static void UseScope() {

        {
            int x = 100;
            {
                //If x is defined here, we can not use it out of the block
                x = 200;
                System.out.println("In the internal scope, x is " + x);
            }
            System.out.println("In the external scope, x is " + x);
        }
    }

    /**
     * @param param just a param
     * @return param
     */
    public static int UseJavaDoc(int param) {
        System.out.println("Usage: javadoc Chapter2.java to see the output.");
        return param;
    }

}
