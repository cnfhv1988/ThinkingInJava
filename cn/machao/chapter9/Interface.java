package cn.machao.chapter9;

public class Interface extends Inherit implements Fly, Swim {
    int i = 027; // i is public by default, private and protected is not permitted here.

    public void fly() { //implementation of fly()
        return ;
    }

    //Because we have a swim() in Inherit, so we have a void swim() here.
    //public int swim(){ return 0; } // Error. Incompatible return type

    public static void main(String... args) {

        A a = new A();
        A.B b = a.new B(); // B is not static class in A, so we must use instance of A to manipulate it.
        A.C c = new A.C(); // C is static class in A.
        b.aa();
        // A.Ia b = a.getB(); //Because Ia is private, it's not allowed to access it.
        //A.B b = a.getB(); // Also can not be up-casted to Ia.
        a.acceptIa(a.getB()); //It's ok, because A can access private Ia.


    }
}
/*Output:
aa in B.
aa in B.
 */

interface Fly {
    void fly();
}

interface Swim {
    void swim();
}

class A {
    private interface Ia{
        void aa();
    }

    class B implements Ia {
        public void aa() {
            System.out.println("aa in B.");
        }
    }

    static class C{}

    public Ia getB() {
        return new B();
    }

    public void acceptIa(Ia ia) {
        ia.aa();
    }
}

