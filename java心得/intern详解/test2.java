public class test2 {
    public static void main(String[] args) {
        String s = new String("4");
        //s.intern();  //这行有没有不影响  这里1.8版本不对他进行两条语句的合并优化。
        String s2 = "4";
        System.out.println(s == s2);//所以这里都是false


        String s6 = new String("7");    // 同时会生成堆中的对象1 以及常量池中的对象1，
        // 但是此时s6是指向堆中的对象的
        String s5=s6.intern();            // s5是常量池中的引用
        System.out.println(s6 == s5);    // 这里哪个版本都是false，这个与版本无关


        //String s2="1";
        //String s3= s2+s2;
        String s3 = (new String("1") + new String("1"));//16,17行等价
        s3.intern();  //这行有没有影响比较大，有的话在1.8版本他将17，18两行合为一行（运行时）；
        //String s3 = (new String("1") + new String("1")).intern()：
        // 将其加入常量池并返回常量池中的引用；
        //在1.6版本这行没有用。当然这个1.8版本中的优化只针对下面这种形式的字符串相加优化
        // String s3 = new String("1") + new String("1")，
        String s4 = "11";
        System.out.println(s3 == s4);//在1.8版本中此时两个引用都是指向常量池中的“11” true；
        // 1.6s4指向常量池，s3指向堆。false
    }
}
