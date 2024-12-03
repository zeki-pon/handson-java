public class Foo extends MyClass {
    @MyAnnotation(value1 = "ABC", value2 = 123)
    public void methodA() {
        System.out.println("methodA");
    }
    @MyAnnotation(value1 = "XYZ", value2 = 789)
    public void methodB() {
        System.out.println("methodB");
    }
}
