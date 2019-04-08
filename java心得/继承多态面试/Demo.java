public class Demo {
    public boolean equals(Demo other) {
        System.out.println("use Demo equals.");//为什么会执行到这里，
        // 因为（o3.equals(o4)）这段语句会走到这里，与“o1.equals(o2)”这行无关
        return true;
    }
    public static void main(String[] args) {
        Object o1 = new Demo();
        Object o2 = new Demo();
        Demo o3 = new Demo();
        Demo o4 = new Demo();
        if (o1.equals(o2)) {
            System.out.println("o1 is equal with o2.");
        }
        if (o3.equals(o4)) {
            System.out.println("o3 is equal with o4.");
        }
    }
}