package fastfoodjava;

public class Pension extends LugarAComer {
    // * Pension es SUBCLASE de LugarAComer
    // ? Posiblemente la clase sera una "CLASE ABSTRACTA"

    public Pension() {
        super();
    }
    public Pension(String a, String b, double c, double[] d) {
        super(a, b, c, d);
    }
    public Pension(String a, String b, double c, double d, double e) {
        super(a, b, c, d, e);
    }
}
