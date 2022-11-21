package fastfoodjava;

public class PensionFijo extends Pension {
    // * PensionFijo SUBCLASE de Pension

    private Menu menu;  // Lista de opciones que posee el restaurante (📄)

    // Constructores - Getters / Setters
    public PensionFijo() {
        super();
        this.menu = new Menu();
    }
    public PensionFijo(String a, String b, double c, double[] d, Menu menu) {
        super(a, b, c, d);
        this.menu = menu;
    }
    public PensionFijo(String a, String b, double c, double d, double e, Menu menu) {
        super(a, b, c, d, e);
        this.menu = menu;
    }


    public Menu getMenu() {
        return menu;
    }


    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public void setTodo(String a, String b, double c, double d, double e, Menu f) {
        super.setTodo(a, b, c, d, e);
        this.menu = f;
    }


    // Metodos

}
