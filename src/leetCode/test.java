package leetCode;

/**
 * Created by d-xsj on 2019/11/18.
 */
public class test {
    public static void main(String[] args) {
        String s = "1.1.1.1";
        String[]  m = s.split("\\.");
        System.out.println(m[0]);
        System.out.println(String.join("[.]", m ));
    }
}
