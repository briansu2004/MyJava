class Shape {}

class Quad extends Shape {}

class Triangle extends Shape {}

class test {
    public static void main(String[] args) {
        Shape shape = new Quad();
        Quad quad = new Quad();

        // Triangle tri = (Triangle) shape;
        // shape = quad;
        Triangle tri2 =  (Triangle) quad;
    }
}


