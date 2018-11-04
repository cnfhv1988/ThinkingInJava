package cn.machao.chapter12;

public class Chapter12 {

    public static void main(String... args) {

        try {

            method();
        }
        catch (Throwable e){ // if we put another catch(Throwable e), we'll get an error from compiler.
            e.printStackTrace(System.out); //printStackTrace will output to standard error.
        }

        try {

            method2();
        }
        catch (Throwable e){ // if we put another catch(Throwable e), we'll get an error from compiler.
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getName()); //package name + class name
            System.out.println(e.getClass().getSimpleName()); //class name

            for(StackTraceElement el : e.getStackTrace()){
                System.out.println(el.getMethodName());
            }
        }

        try{
            method();
        }
        finally {
            return; //exception lost.
        }

    }

    static void method() throws Throwable{
        try {
            throw new MyThrow("rethrow");
        }
        catch (Throwable e){
            throw e.initCause(new NullPointerException()); // rethrow this exception, will be caught in main. Use initCause() to save the origin cause.
        }
        finally {
            System.out.println("finally will always be executed.");
        }
    }

    static void method2() throws Throwable{
        try {
            method();
        }
        catch(Throwable e) {
            throw e.fillInStackTrace(); //fillInStackTrace will change the place where exceptions happened.
        }
    }


}

class MyThrow extends Throwable {

    MyThrow(String message) {
        super(message);
    }
}

class E1 extends Exception{}
class E2 extends Exception{}
class E3 extends Exception{}
class E21 extends E2{}

class Base {
    Base() throws E1 {}

    public void m1() throws E2{}

    public void m2() throws E3{}
}

interface I{
    void m2() throws E2;
}

class Inherit extends Base implements I{
    Inherit() throws E1, E2{} // inherit must handle exception from base class(here is E1), and can handle other exceptions like E2

    @Override
    public void m1() throws E21 {} //the overrode method must throws exception(or subclass type) in base class, E21 can also be caught by catch(E1 e).

    @Override
    public void m2() {} //throws E1 or throws E2 will get a compile error.

    public static void main(String... args){
        try{
            Inherit inherit = new Inherit();
            inherit.m2();
        }
        catch (E1 e){

        }
        catch (E2 e){

        }

        try {
            Base b = new Inherit();
            b.m2();
        }
        catch (E1 e){

        }
        catch (E2 e){

        }
        catch (E3 e){
            //up-casting, must catch exceptions from the base-class.
        }

    }
}

/*Output:
finally will always be executed.
cn.machao.chapter12.MyThrow: rethrow
	at cn.machao.chapter12.Chapter12.method(Chapter12.java:40)
	at cn.machao.chapter12.Chapter12.main(Chapter12.java:9)
Caused by: java.lang.NullPointerException
	at cn.machao.chapter12.Chapter12.method(Chapter12.java:43)
	... 1 more
finally will always be executed.
rethrow
cn.machao.chapter12.MyThrow
MyThrow
method2
main
finally will always be executed.
 */