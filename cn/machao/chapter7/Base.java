package cn.machao.chapter7;

public class Base {

    private int i;

    Base(int i) {

    }


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
