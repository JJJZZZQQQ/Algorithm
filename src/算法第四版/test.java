package 算法第四版;

public class test {
    public static void main(String[] args) {
        /*System.out.println('b');
        System.out.println('b'+'c');
        char b = 'b';
        char c= 'c';
        int a  = b+c;
        char a1 = (char)(b+c);
        char a2 = 'b'+'c';//常量优化机制，运算结果是int型，自动优化成char型.
        System.out.println(a);
        System.out.print((char)('a'+4));
        String str1 ="aa";
        String str2 = "bb";
        str1.equals(str2);*/
        Integer a = new Integer(3);
        Integer b = 3;  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b); // false 两个引用没有引用同一对象
        System.out.println(a == c); // true a自动拆箱成int类型再和c比较
        System.out.println(b == c); // true

        Integer a1 = 128;
        Integer b1 = 128;
        System.out.println(a1 == b1); // false

        Integer a2 = 127;
        Integer b2 = 127;
        System.out.println(a2 == b2); // true
    }
}
