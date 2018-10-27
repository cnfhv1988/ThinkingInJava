package cn.machao.chapter7and8;

public final class Inherit extends Base {

    public int i = 1;

    private final int j; //If we assign a value for j here, line 11 will get an error.
    private final static int k = 0; // must initialize with definition.

    Inherit() {
        super();
        j = 2; // final member must be initialize in constructor or definition.
    }

    void method(float f) {
        System.out.println("inherit method(float)");
    }

    @Override
    public Inherit method3() {
        //override method3, but return value is a reference of Inherit, not Base.
        return this;
    }

    @Override
    void method(int i) {
        System.out.println("inherit method(int)" + i);
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

        Base b = new Inherit();
        System.out.println(b.i); // polymorphic is aimed at non-static methods, not for members and static method.

    }
}
