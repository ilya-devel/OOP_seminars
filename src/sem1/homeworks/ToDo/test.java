package sem1.homeworks.ToDo;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Closet tst = new Closet();
        tst.putIn("socks");
        tst.putIn("socks");
        tst.putIn("socks");
        tst.viewContent();
        tst.getOut("socks");
        tst.viewContent();
        Person p = new Person();
        Scanner in = new Scanner(System.in);
        while (true) {
            p.iThink(tst);
            System.out.println("Do you want to do something else? (y/n)");
            String ans = in.next().strip();
            if (ans.equals("n") || ans.equals("N")) break;
        }

    }
}
