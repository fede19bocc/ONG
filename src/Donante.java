import java.util.Objects;

public class Donante {
    private String nombre;
    private String apellido;
    private int id;
    private static int contadorDonante = 1;

    public Donante(String apellido, String nombre) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = contadorDonante++;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
        return result;
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj)
    //         return true;
    //     if (obj == null)
    //         return false;
    //     if (getClass() != obj.getClass())
    //         return false;
    //     Donante other = (Donante) obj;
    //     if (nombre == null) {
    //         if (other.nombre != null)
    //             return false;
    //     } else if (!nombre.equals(other.nombre))
    //         return false;
    //     if (apellido == null) {
    //         if (other.apellido != null)
    //             return false;
    //     } else if (!apellido.equals(other.apellido))
    //         return false;
    //     return true;
    // }

    @Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null || getClass() != obj.getClass())
        return false;
    Donante other = (Donante) obj;
    return Objects.equals(nombre, other.nombre) && 
           Objects.equals(apellido, other.apellido);
}


    @Override
    public String toString() {
        return "(" + id + ") " + apellido + ", " + nombre;
    }
}
