public class FinalExampleTest {
    // declaring final variable
    final int age = 18;

    void display() {
        // reassigning value to age variable
        // gives compile time error
        // age = 55;

        System.out.printf("Age is final: %s", age);
    }

    public static void main(String[] args) {

        FinalExampleTest obj = new FinalExampleTest();
        // gives compile time error
        obj.display();
    }
}