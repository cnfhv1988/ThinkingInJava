import java.util.Random;

public class Chapter3 {

    public static void main(String[] args) {

        UseRandom();
        UseMonadic();

        //byte c = 0xffff; //0xffff is out of range of byte, the compiler will prompt an error.

        UseToBinary();
        UseExp();

        UseBitWise();
        UseShift();

        char a = 'a', b = 'b';
        //a = a * b; // a * b will be promoted to int.
        System.out.println(a * b);
    }

    public static void UseRandom() {
        Random rand = new Random(47);
        System.out.println(rand.nextInt(100));
        System.out.println(rand.nextFloat());
    }

    public static void UseMonadic() {
        char c = 'A';
        System.out.println(c);
        System.out.println(+c);
    }

    public static void UseToBinary() {

        short a = 0x7fff;
        System.out.println(Integer.toBinaryString(a)); // The argument will be promoted to int.
    }

    public static void UseExp() {

        double a = 47e-30;
        System.out.println(a);

        // float b = 15e13; //Compiler will treat exponents as double, so we must use cast to change double to float.
        float b = (float)47e30;
        System.out.println(b);
    }

    public static void UseBitWise() {

        boolean a = true;
        boolean b = false;

        System.out.println(a ^ b);
    }

    public static void UseShift() {

        short a = -10;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(a << 3);
        System.out.println(a >> 3);
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(a >>> 3);
        System.out.println(Integer.toBinaryString(536870910));
    }

}
