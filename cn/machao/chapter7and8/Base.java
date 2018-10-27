package cn.machao.chapter7and8;

public class Base {

    public int i = 0;

    Base() {
        method(i); //will call method of Inherit, and i will be assigned to 0.
    }

    public Base method3() {return this;}

    private void method2() {
        System.out.println("Base private method2.");
    }

    public static void call(Base base) {
        base.method2();
    }

    void method(int i) {
        System.out.println("base method(int)");
    }

    void method(char c) {
        System.out.println("base method(char)");
    }

    final void canNotOverride(){}
}
