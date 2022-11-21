package fastfoodjava;

public class Restaurante extends LugarAComer {
    // * Restaurante es SUBCLASE de LugarAComer

    private String paginaWeb;   // Pagina del restaurante si es que lo tuviera (🌐)
    private Menu menu;          // Lista de opciones que posee el restaurante (📄)

    // Contructores - Getters / Setters
    public Restaurante() {
        super();
        this.paginaWeb = "polloscopacabana.com";
        this.menu = new Menu();
    }
    public Restaurante(String a, String b, double c, double[] d, String e, Menu f) {
        super(a, b, c, d);
        this.paginaWeb = e;
        this.menu = f;
    }
    public Restaurante(String a, String b, double c, double d, double e, String f, Menu g) {
        super(a, b, c, d, e);
        this.paginaWeb = f;
        this.menu = g;
    }


    public String getPaginaWeb() {
        return paginaWeb;
    }
    public Menu getMenu() {
        return menu;
    }


    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public void setTodo(String a, Menu b) {
        this.paginaWeb = a;
        this.menu = b;
    }
    public void setTodo(String a, String b, double c, double d, double e, String f, Menu G) {
        super.setTodo(a, b, c, d, e);
        this.paginaWeb = f;
        this.menu = G;
    }

    // Metodos

    public Comida getOpcion(int index) {
        return this.menu.getComida(index);
    }
    public Comida getOpcion(String nombre) {
        return this.menu.getComida(nombre);
    }

}
