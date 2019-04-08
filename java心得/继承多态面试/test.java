class A {
    public String run(D obj) {
        return ("A & D");
    }
    public String run(A obj) {
        return ("A & A");
    }
}
class B extends A {
    public String run(B obj) { return ("B & B"); }
    public String run(A obj) { return ("B & A"); }
}
class C extends B { }
class D extends B { }
public class test {
    public static void main(String[] args) {

        A aa = new A();
        A ab = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println(aa.run(b));//1, A & A
        System.out.println(aa.run(c));//2, A & A
        System.out.println(aa.run(d));//3, A & D
        System.out.println(ab.run(b));//4, B & A
        // alt加左键可以找到编译时的方法，运行时的方法为被子类重写的方法，
        // 因为b继承a因此编译时会找父类中的参数为A的方法，
        // 而运行时会找子类中重写了父类中的这个方法。
        // 如果子类没有就继续用父类中的方法。（比如注释掉11行）
        System.out.println(ab.run(c));//5, B & A
        System.out.println(ab.run(d));//6, A & D
        System.out.println(b.run(b));//7, B & B
        System.out.println(b.run(c));//8, B & B
        System.out.println(b.run(d));
    }
}
