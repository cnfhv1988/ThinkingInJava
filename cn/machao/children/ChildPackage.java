package cn.machao.children;

import cn.machao.Chapter6; // need a import

public class ChildPackage {

    private Chapter6 chapter6;
    public PackageMember packageMember;

    void packageAccess() {
        System.out.println("package access");
    }; //This method can not be accessed by other class out of this package.

    public ChildPackage() {
        // can not use new ChildPackage() to create a new instance outside without public.
        System.out.println("package accessed inside ChildPackage.");
        System.out.println(chapter6); //null
        // chapter6.childPackage.packageAccess(); //NullPointerException.
    }
}

class PackageMember{

    public static int i = 0;
    int j = 0; // Only two situations: private or not, because j can only be used in this package, public is meaningless.
}