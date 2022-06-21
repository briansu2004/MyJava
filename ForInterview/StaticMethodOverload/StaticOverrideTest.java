/**
 * * Java Program to show that, you can not override static method in Java. * If
 * you declare same method in subclass then, It's known as method hiding.
 */

public class StaticOverrideTest {
    public static void main(String args[]) {
        Parent p = new Parent();
        p.name();
        // should call static method from super class (Parent)
        // because type of reference variable
        // p is Parent

        p = new Child();
        p.name();
        // as per overriding rules this should call to child's static
        // overridden method. Since static method can not be overridden
        // , it will call parent static method
        // because Type of p is Parent.

        Child c = new Child();
        c.name();
        // will call child static method because static method
        // get called by type of Class
    }
}

class Parent {
    /*
     * * original static method in super class which will be hidden * in subclass.
     */
    public static void name() {
        System.out.println("static method from Parent");
    }
}

class Child extends Parent {
    /*
     * * Static method with same signature as in super class, * Since static method
     * can not be overridden, this is called * method hiding. Now, if you call
     * Child.name(), this method * will be called, also any call to name() in this
     * particular * class will go to this method, because super class method is
     * hidden.
     */
    public static void name() {
        System.out.println("static method from Child");
    }
}
