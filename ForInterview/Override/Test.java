import java.sql.SQLException;

public class Test {
    public static void main(String args[]) throws SQLException {
        A a = new A();
        a.myMethod();

        B b = new B();
        b.myMethod();
    }
}

class A {
    void myMethod() throws SQLException {
        System.out.println("Super Class");
    }
}

class B extends A {

    @Override
    void myMethod() throws SQLException {
        System.out.println("Sub Class");
    }
}