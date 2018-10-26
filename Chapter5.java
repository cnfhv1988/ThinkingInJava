public class Chapter5 {

    private int i;
    private String s;
    private int j;
    private int[] array = {4,5,6};

    //static member will be initialized when the first instance of this class will be created.
    private static StaticMember staticMember;

    static {
        //static block. This block will be execute only once.
        staticMember = new StaticMember();
        System.out.println("initialize staticMember");
    }

    //j will be initialized when a new instance created, and the order is before the constructor.
    {
        j = 0;
        System.out.println("initialize j");

        array = new int[]{1,2,3}; // you can use array = {1,2,3} only with definition.
    }

    Chapter5(int i) {
        //If we create a instance of Chapter5 with 'new Chapter5(2)', i first will be initialized to 0(the default) and then change
        //to 2 through calling constructor.
        System.out.println("initialize Chapter5");
        this.i = i;
    }

    Chapter5(String s) {
        this.s = s;
    }

    Chapter5(int i, String s) {
        this(i);
        // this(s); //Error. Call to this() must be first statement in constructor body.
        this.s = s;
    }

    //j will be initialized when a new instance created, and the order is before the constructor.
    {
        j = 3;
        System.out.println("initialize j second time");
    }

    static {
        staticMember = null;
        System.out.println("initialize staticMember second time");
    }

    public static void UseStatic() {
        System.out.println("static");
        //this.method2(); //Error. In a static context, this can not be referenced.
    }

    void method1() { method2(); } // The compiler will know method2() means this.method2()

    void method2() { this.method1(); } // It is Ok, but not recommended.

    void method3(String... args) {
        //With the help of '...', you don't need String[] args, but compiler will convert the arguments to an array. Certainly,
        //you can pass a String[] as well.
        for (String arg: args) {
            System.out.println(arg);
        }
    }

    void overload(Character... args) {
        System.out.println("Character");
    }

    void overload(Integer... args) {
        System.out.println("Integer");
    }

    void overload(Long... args) {
        System.out.println("Long");
    }

    //this overload will cause ambiguous.
    /*
    void overload(float i, Long... args) {
        System.out.println("Long");
    }
    */


    public static void main(String... args) {

        //Chapter5 ch5 = new Chapter5(); //Error. Because we have a constructor, so compiler will not provide a default constructor.
        Chapter5.UseStatic(); // Call static method without instance.
        Chapter5 ch5 = new Chapter5(4);
        ch5.method3("hello","world");
        ch5.overload('a'); //If there is not a overload(Character... args), compiler error. Because compiler can not choose the right overload method.
        ch5.overload(1);
        ch5.overload(0L);
        // ch5.overload(); //compile error. Ambiguous
        System.out.println(ch5.array.length + ch5.array[0]);
        System.out.println(staticMember);

    }

    //finalize() is not destructor in C++. The only situation you will use it is that you malloc memory with native method when
    //gc will not recover it automatically.
    protected void finalize()  {
        try {
            // You must handle exception here, use try/catch or throw clause.
            System.out.println("finalize");
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}

/*Output:
Static
initialize staticMember
initialize staticMember second time
static
initialize j
initialize j second time
initialize Chapter5
hello
world
Character
Integer
Long
4
null
 */

class StaticMember {
    StaticMember() {
        System.out.println("Static");
    }
}
