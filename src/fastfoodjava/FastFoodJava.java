package fastfoodjava;

public class FastFoodJava {

    public static void main(String[] args) {
        System.out.println("FastFood:v");
        Menu m = new Menu();
        m.agregarComida("ramen", 12.3);
        m.mostrar();
    }

}
