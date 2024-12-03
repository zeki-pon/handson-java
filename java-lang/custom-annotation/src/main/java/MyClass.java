import java.lang.reflect.Method;

public class MyClass {
    MyClass() {
        try {
            Method[] methods = this.getClass().getMethods();
            for (Method method : methods) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                if (annotation != null) {
                    System.out.println("method: " + method);
                    System.out.println("value1: " + annotation.value1());
                    System.out.println("value2: " + annotation.value2());
                    method.invoke(this);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void methodParent1() {
        System.out.println("methodParent1");
    }

    @MyAnnotation(value1 = "mp2", value2 = 999)
    public void methodParent2() {
        System.out.println("methodParent2");
    }
}
