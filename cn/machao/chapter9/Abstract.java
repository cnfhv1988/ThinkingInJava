package cn.machao.chapter9;

abstract public class Abstract {

    //This is a abstract class, you can not crate an instance of this class.

    abstract void f();
}

class Inherit  extends Abstract{

    @Override
    void f() {} //we must implements this method, otherwise this class must be decorated by abstract.

    public static void main(String... args) {

        //Abstract a = new Abstract(); //Abstract class should not be instantiated.
    }

    public void swim() {
        return ;
    }
}