package fastfoodjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoPension {
    private String nomArch;

    public ArchivoPension() {
        this.nomArch = "./src/Persistencia/Pension.obj";
    }

    public ArchivoPension(String nom) {
        this.nomArch = nom;
    }

    public void crear() throws FileNotFoundException, IOException {
        ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(this.nomArch));
        archivo.close();
        System.out.println("Archivo creado exitosamente");
    }

    public void agregar(Pension nuevoPension) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension penTemp = (Pension) archivo.readObject();
                temporal.writeObject(penTemp);
            }
        } catch (Exception e) {
            temporal.writeObject(nuevoPension);
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto adicionado");
        }
    }

    public void agregar(String nombre) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension penTemp = (Pension) archivo.readObject();
                temporal.writeObject(penTemp);
            }
        } catch (Exception e) {
            temporal.writeObject(new Pension(nombre));
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto adicionado");
        }
    }

    public void eliminar(Pension PensionEliminar) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension penTemp = (Pension) archivo.readObject();
                if (PensionEliminar.getNombre().equals(penTemp.getNombre())
                        && PensionEliminar.getUbicacion().equals(penTemp.getUbicacion())) {
                    continue;
                }
                temporal.writeObject(penTemp);
            }
        } catch (Exception e) {
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto eliminado");
        }

    }

    public void eliminar(String nombre, String ubicacion) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension penTemp = (Pension) archivo.readObject();
                if (penTemp.getNombre().equals(nombre) && penTemp.getUbicacion().equals(ubicacion)) {
                    continue;
                }
                temporal.writeObject(penTemp);
            }
        } catch (Exception e) {
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto eliminado");
        }

    }

    public void eliminar(int index) throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        int con = 0;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension penTemp = (Pension) archivo.readObject();
                if (con == index) {
                    continue;
                }
                temporal.writeObject(penTemp);
                con++;
            }
        } catch (Exception e) {
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto eliminado");
        }

    }

    public void editar(String nombre, String ubicacion, Pension PensionEdit)
            throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension penTemp = (Pension) archivo.readObject();
                if (penTemp.getNombre().equals(nombre) && penTemp.getUbicacion().equals(ubicacion)) {
                    penTemp = PensionEdit;
                }
                temporal.writeObject(penTemp);
            }
        } catch (Exception e) {
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto editado");
        }
    }

    public void editar(int index, Pension PensionEdit)
            throws FileNotFoundException, IOException {
        ObjectOutputStream temporal = null;
        ObjectInputStream archivo = null;
        int con = 0;
        try {
            temporal = new ObjectOutputStream(new FileOutputStream("./src/Persistencia/temporal.obj"));
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension penTemp = (Pension) archivo.readObject();
                if (con == index) {
                    penTemp = PensionEdit;
                }
                temporal.writeObject(penTemp);
                con++;
            }
        } catch (Exception e) {
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Objeto editado");
        }
    }

    public void listar() throws FileNotFoundException, IOException {
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension penTemp = (Pension) archivo.readObject();
                penTemp.mostrar();
            }
        } catch (Exception e) {
            // System.out.println("Error: " + e);
        } finally {
            archivo.close();
        }
    }

    public void listarFormat() throws FileNotFoundException, IOException {
        ObjectInputStream archivo = null;
        int con = 0;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension penTemp = (Pension) archivo.readObject();
                System.out.println(con + " " + penTemp.mostrarString());
                con++;
            }
        } catch (Exception e) {
            // System.out.println("Error: " + e);
        } finally {
            archivo.close();
        }
    }

    public Pension getElement(int index) throws FileNotFoundException, IOException {
        ObjectInputStream archivo = null;
        int con = 0;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension penTemp = (Pension) archivo.readObject();
                if (con == index) {
                    archivo.close();
                    return penTemp;
                }
                con++;
            }
        } catch (Exception e) {
            archivo.close();
        }
        return null;
    }

    public Pension getElement(String nombre, String ubicacion) throws FileNotFoundException, IOException {
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension penTemp = (Pension) archivo.readObject();
                if (penTemp.getNombre().equals(nombre) && penTemp.getUbicacion().equals(ubicacion)) {
                    archivo.close();
                    return penTemp;
                }
            }
        } catch (Exception e) {
            archivo.close();
        }
        return new Pension();
    }

    public ArrayList<Pension> getPensiones() throws FileNotFoundException, IOException {
        ArrayList<Pension> lista = new ArrayList<Pension>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension penTemp = (Pension) archivo.readObject();
                lista.add(penTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        return lista;
    }

    public ArrayList<LugarAComer> getLugarAComer() throws FileNotFoundException, IOException {
        ArrayList<LugarAComer> lista = new ArrayList<LugarAComer>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                LugarAComer Temp = (LugarAComer) archivo.readObject();
                lista.add(Temp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        return lista;
    }

    public void BORRARTODO() throws FileNotFoundException, IOException {
        try {
            ObjectOutputStream temporal = new ObjectOutputStream(
                    new FileOutputStream("./src/Persistencia/temporal.obj"));
            ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            temporal.close();
            archivo.close();

            File fileReal = new File(this.nomArch);
            File fileTemp = new File("./src/Persistencia/temporal.obj");

            fileReal.delete();
            fileTemp.renameTo(fileReal);

            System.out.println("Se Borro todo");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Pension masBarato() throws FileNotFoundException, IOException {
        ArrayList<Pension> lista = new ArrayList<Pension>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension resTemp = (Pension) archivo.readObject();
                lista.add(resTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        Pension minPen = lista.get(0);
        double minPrecio = minPen.minimoComida();

        for (Pension i : lista) {
            if (i.minimoComida() < minPrecio) {
                minPen = i;
                minPrecio = i.minimoComida();
            }
        }
        return minPen;
    }

    public Pension masCerca(double[] coord) throws FileNotFoundException, IOException {
        ArrayList<Pension> lista = new ArrayList<Pension>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension resTemp = (Pension) archivo.readObject();
                lista.add(resTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        Pension minPen = lista.get(0);
        double minDistancia = Math
                .sqrt(Math.pow((coord[0] + minPen.getCoord()[0]), 2) + Math.pow((coord[1] + minPen.getCoord()[1]), 2));

        for (Pension i : lista) {
            double distancia_i = Math
                    .sqrt(Math.pow((coord[0] + minPen.getCoord()[0]), 2)
                            + Math.pow((coord[1] + minPen.getCoord()[1]), 2));
            if (distancia_i < minDistancia) {
                minPen = i;
                minDistancia = distancia_i;
            }
        }

        return minPen;
    }

    public Pension masValorado() throws FileNotFoundException, IOException {
        ArrayList<Pension> lista = new ArrayList<Pension>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension resTemp = (Pension) archivo.readObject();
                lista.add(resTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        Pension minPen = lista.get(0);
        double minVal = minPen.getCalificacion();

        for (Pension i : lista) {
            if (i.minimoComida() > minVal) {
                minPen = i;
                minVal = i.getCalificacion();
            }
        }
        return minPen;
    }

    public ArrayList<Pension> buscarNombre(String nombre) throws FileNotFoundException, IOException {
        ArrayList<Pension> lista = new ArrayList<Pension>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension resTemp = (Pension) archivo.readObject();
                if (resTemp.getNombre().equals(nombre)) {
                    lista.add(resTemp);
                }
            }
        } catch (Exception e) {
            archivo.close();
        }
        return lista;
    }

    public void precioMayorQue(double a) throws IOException {
        ArrayList<Pension> lista = new ArrayList<Pension>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension quiTemp = (Pension) archivo.readObject();
                lista.add(quiTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        for (Pension i : lista) {
            i.precioMayorQue(a);
        }
    }

    public void precioMenorQue(double a) throws IOException {
        ArrayList<Pension> lista = new ArrayList<Pension>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension quiTemp = (Pension) archivo.readObject();
                lista.add(quiTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        for (Pension i : lista) {
            i.precioMenorQue(a);
        }
    }

    public void precioIgualQue(double a) throws IOException {
        ArrayList<Pension> lista = new ArrayList<Pension>();
        ObjectInputStream archivo = null;
        try {
            archivo = new ObjectInputStream(new FileInputStream(this.nomArch));
            while (true) {
                Pension quiTemp = (Pension) archivo.readObject();
                lista.add(quiTemp);
            }
        } catch (Exception e) {
            archivo.close();
        }
        for (Pension i : lista) {
            i.precioIgualQue(a);
        }
    }

}
