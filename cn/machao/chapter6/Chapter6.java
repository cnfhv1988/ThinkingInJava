
package cn.machao.chapter6;


import cn.machao.chapter6.chapter6.children.ChildPackage;

public class Chapter6 {

    public ChildPackage childPackage;

    private int i; // can not accessed by anything out of this class.

    // private Chapter5 chapter5; // can not use class in default package.
    protected static void method() {}

    public static void main(String... args) {

        Chapter6 ch6 = new Chapter6();
        ch6.childPackage = new ChildPackage();
        //ch6.childPackage.packageAccess(); // Error. packageAccess() is package access.
        System.out.println(ch6.i);
        System.out.println(ch6.childPackage.packageMember); // Because the public definition in ChildPackage, we can get this reference, but we can not access it because it is package access.

    }
}
/*Output:
package accessed inside ChildPackage.
null
0
null
 */
