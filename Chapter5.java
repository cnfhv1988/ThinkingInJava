public class Chapter5 {

    private int i;
    private String s;

    Chapter5(int i) {
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

    public static void UseStatic() {
        System.out.println("static");
        //this.method2(); //Error. In a static context, this can not be referenced.
    }

    void method1() { method2(); } // The compiler will know method2() means this.method2()

    void method2() { this.method1(); } // It is Ok, but not recommended.

    public static void main(String[] args) {

        //Chapter5 ch5 = new Chapter5(); //Error. Because we have a constructor, so compiler will not provide a default constructor.
        Chapter5.UseStatic(); // Call static method without instance.

    }
}
