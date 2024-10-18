import java.time.LocalDate;
import Estado.Estado;

public class Donacion {
    private LocalDate fecha;
    private int monto;
    private Donante donante;
    private Estado estado;
    private int id;
    private static int contadorId;

    public Donacion(Donante donante, LocalDate fecha, int monto) {
        this.donante = donante;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = Estado.PENDIENTE;
        this.id = contadorId++;
    }

    public void setCobrada(){
        this.estado = Estado.COBRADA;
    }

    public void setRechazada(){
        this.estado = Estado.RECHAZADA;
    }

    @Override
    public String toString() {
        return "Donacion " + id + "\n - Donante: " + donante.toString() + "\n - Fecha: " + fecha + "\n - Estado:" + estado + "\n - Monto: " + monto; 
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public int getMonto() {
        return monto;
    }

    public Donante getDonante() {
        return donante;
    }

    public Estado getEstado() {
        return estado;
    }

    public int getId() {
        return id;
    }

    public static int getContadorId() {
        return contadorId;
    }

    
}
