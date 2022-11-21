package fastfoodjava;

public class LugarAComer {
    private String ubicacion;                   // Ubicación del lugar. Ej. Av. 20 de octubre (🗺)
    private String nombre;                      // Nombre del lugar. Ej. Pollos María (🏪)
    private double calificacion;                // Valoracion del lugar. Ej. 3.5 de 5 (⭐)
    private double[] coord = new double[2];     // Coordenadas en Mapa del lugar. Ej. 16.231, -7.125 (🔻)

    // Contructores - Getters / Setters
    public LugarAComer() {
        this.ubicacion = "Calle falsa #123";
        this.nombre = "En renta";
        this.calificacion = 0;
        this.coord[0] = 0;
        this.coord[1] = 0;
    }
    public LugarAComer(String a, String b, double c, double[] d) {
        this.ubicacion = a;
        this.nombre = b;
        this.calificacion = c;
        this.coord = d;
    }
    public LugarAComer(String a, String b, double c, double d, double e) {
        this.ubicacion = a;
        this.nombre = b;
        this.calificacion = c;
        this.coord[0] = d;
        this.coord[1] = e;
    }


    public String getUbicacion() {
        return ubicacion;
    }
    public String getNombre() {
        return nombre;
    }
    public double getCalificacion() {
        return calificacion;
    }
    public double[] getCoord() {
        return coord;
    }


    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    public void setCoord(double[] coord) {
        this.coord = coord;
    }
    public void setTodo(String a, String b, double c, double[] d) {
        this.ubicacion = a;
        this.nombre = b;
        this.calificacion = c;
        this.coord = d;
    }
    public void setTodo(String a, String b, double c, double d, double e) {
        this.ubicacion = a;
        this.nombre = b;
        this.calificacion = c;
        this.coord[0] = d;
        this.coord[1] = e;
    }

    // Metodos

}
