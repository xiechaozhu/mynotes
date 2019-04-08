public class Test1 {
    public static void main(String[] args) {
        Base base = new Sub();
        base.print("hello");//1    编译的时候使用的是父类的方法，但是运
        // 行的时候使用的子类的方法至于为什么hello可以匹配到数组这个时候看。class文件就知道了
        //。class文件中“hello”被转化为new String[]{"hello"}
		//编译器会在背地里把这最后一个形参转化为一个数组形参
		//在一个类中出现一个可变参数和一个数组会编译报错，因为他们本质是一样的
        Sub sub = new Sub();
     //   sub.print("hello");//这里编译报错
    }
}
class Base {
    void print(String... args) {
        System.out.println("Base print.");
    }
}
class Sub extends Base {
        @Override
        void print(String[] args) {
            System.out.println("Sub print."+args[0]);
        }
}


