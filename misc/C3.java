interface I1 {
    String name = "N1";
    String s1 = "S1";
}

interface I2 extends I1 {
    String name = "N2";
}

public class C3 implements I2 {
    public static void main(String[] args) {
        System.out.print(I2.name + ",");
        System.out.print(I2.s1 + ",");
        System.out.print(((I1)new C2()).name);   
    }   
}
