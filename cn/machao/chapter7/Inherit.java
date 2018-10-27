package cn.machao.chapter7;

public final class Inherit extends Base {

    private int i;

    private final int j; //If we assign a value for j here, line 11 will get an error.
    private final static int k = 0; // must initialize with definition.

    Inherit() {
        super(10);
        j = 2; // final member must be initialize in constructor or definition.
    }

    void method(float f) {
        System.out.println("inherit method(float)");
    }


    @Override
    void method(int i) {
        System.out.println("inherit method(int)");
    }

    // void canNotOverride(){} //Because the final in Base, this method can not be overridden.

    public  static void main(String... args) {

        //start from main, load Inherit.class, find its base class, load Base.class, initialize static in Base, initialize static in Inherit.
        //Call constructor of Inherit, and Inherit() will call Base() first.

        Inherit inherit = new Inherit();
        System.out.println(inherit.i);
        inherit.method(1);
        inherit.method('a');
        Base.call(inherit);
        inherit.i++; // methods of final class are final, but members of final class depends whether there is a final keyword.
    }
}
