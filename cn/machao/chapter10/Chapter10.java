package cn.machao.chapter10;

public class Chapter10 {

    private int i;

    private class Inner {
        private int j;
        //private static int k; // Error, can not have a static member, so do static method.

        Inner() {
            j = i++; //An inner class can access everything of the outer class.
        }

        private int getJ() {
            return j;
        }

        private Chapter10 getOuter() { //through .this to get reference of outer class.
            return Chapter10.this;
        }
    }

    public static class InnerStatic{
        public static void main(String... args) {
            System.out.println("We can put some tests here."); // run this with java Chapter10$InnerStatic
        }
    } // Static inner class;

    public Inner getInner() {
        return new Inner();
    }

    public void method(int argument){
        class InnerClassInMethod{ //Inner class in method, can not be used out of this method
            private int inMethod = argument;
            public void changeArg() {
                // argument = 1; // Error, argument is accessed in the inner class, needs to be final.
            }
        }
        InnerClassInMethod i = new InnerClassInMethod();
        if(i.inMethod == argument) {
            class InnerClassInBlock{ //Inner class in method, can not be used out of this block
                private int inBlock = argument;
            }
            InnerClassInBlock ii = new InnerClassInBlock();
            System.out.println(ii.inBlock);
        }
    }

    public Base getBase(int x, Object ss){
        return new Base(x) { //anonymous inner class, inherit from base, as an anonymous class, only can inherit from one class or interface
            private int i;
            {
                //this block acts as a constructor.
                i = super.getI() * 10;
                // ss = null; // ss is accessed in the inner class, need to be final.
            }
            @Override
            public int getI() {
                System.out.println(ss);
                return this.i;
            }
        };
    }

    public IBase getIBase(){

        return new IBase() {
            @Override
            public int getI() {
                return 0;
            }
        };
    }


    public static void main(String... args) {

        Chapter10 ch10 = new Chapter10();
        System.out.println(ch10.getInner().getJ());
        System.out.println(ch10.i); // We can only access i in this class!!

        System.out.println(ch10.getInner().getOuter() == ch10); //getOuter is also accessed only in this class.

        ch10.method(1);

        System.out.println(ch10.getBase(10, new String("abc")).getI());
        System.out.println(ch10.getIBase().getI());

        Chapter10.InnerStatic innerStatic = new Chapter10.InnerStatic(); //can not get a reference of outer class.
    }
}

class Base{
    private int i;
    Base(int i) {
        this.i = i;
    }

    public int getI() {
        return this.i;
    }
}

interface IBase {
    int getI();
}