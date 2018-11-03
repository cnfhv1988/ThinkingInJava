
public class Chapter4 {

    private String str = "hello";

    private String str2;

    Chapter4() {
        System.out.println(str);
        this.str2 = "world";
    }

    public static void main(String[] args) {

        Chapter4 ch4 = new Chapter4();
        UseGoTo();
    }

    public static void UseGoTo() {

        outer:
        for (int i = 0; i < 10; i++) {
            if(i < 5) continue outer;
            System.out.println(i);
            if(i == 6) break outer;
        }

        char c = 1;
        int d = c + c; // The opertaor '+' makes casting from char to int.
    }
}
