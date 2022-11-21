package fastfoodjava;

public class FastFoodJava {

    public static void main(String[] args) {
        System.out.println("FastFood:v");
        Menu m = new Menu();
        Comida ramen = new Comida("Ramen", 2.12);
        ramen.mostrar();
    }

}
