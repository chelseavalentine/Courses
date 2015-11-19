/**
 * Created by Chelsea on 11/1/2015.
 */

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Scanner;

public class Korean {
    public static void main(String[] args) {
//        Locale korean = new Locale("ko_KR");
//        String korea3 = "??? ??";
        String test = "c 0.4 0.1 0.9 0.3 1.3 0.5\n" + "c -3.4 0.8 0.3";
        Scanner in = new Scanner(test);

        while (in.hasNextLine()) {
            System.out.println(in.next());
            while (in.hasNextFloat()) System.out.println(in.nextFloat());
        }
//        System.out.println(in.next());
//        while (in.hasNextFloat()) System.out.println(in.nextFloat());
//        System.out.println(in.next());
//        while (in.hasNextFloat()) System.out.println(in.nextFloat());
//        System.out.println("ok");
//        System.out.println(korea3);
}
}
