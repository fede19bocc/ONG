import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Estado.Estado;

public class ONG {
    private String razonSocial;
    private List<Donante> donantes;
    private List<Donacion> donaciones;

    public ONG(String razonSocial) {
        this.razonSocial = razonSocial;
        this.donantes = new ArrayList<>();
        this.donaciones = new ArrayList<>();
    }

    public Donante registrarDonante(String apellido, String nombre) {
        Donante donante = buscarDonante(apellido, nombre);
        if (donante == null) {
            donante = new Donante(apellido, nombre);
            agregarDonanteAlListado(donante);
        }
        return donante;
    }        

    public void agregarDonanteAlListado(Donante donante) {
        if (!esDonante(donante.getNombre(), donante.getApellido())) {
            this.donantes.add(donante);
        }
    }

    public Donante buscarDonante (String apellido, String nombre) {
        for (Donante donante : donantes) {
            if (donante.getApellido().equals(apellido) && donante.getNombre().equals(nombre)) {
                return donante;
            }
        }
        return null;
    }

    public boolean esDonante(String apellido, String nombre) {
        Donante existeDonante = buscarDonante(apellido, nombre);
        return existeDonante != null;
    }

    public Donacion cargarDonacion (Donante donante, LocalDate fecha, int monto) {
        Donacion donacion = new Donacion(donante, fecha, monto);
        this.donaciones.add(donacion);
        return donacion;
    }

    public void mostrarDonantes() {
        System.out.println("Listado de donantes de " + this.razonSocial.toString());
        for (Donante donante : donantes) {
            System.out.println(donante.toString());
        }
    }

    public void mostrarDonaciones() {
        System.out.println("Listado de donaciones de " + this.razonSocial.toString());
        for (Donacion donacion : donaciones) {
            System.out.println(donacion.toString());
        }
    }

    public void mostrarResultadoFecha(LocalDate fecha) {
        int cobradas = 0;
        int rechazadas = 0;
        int pendientes = 0;
        int montoTotal = 0;
        int max = 0;
        int min = 0;
        float promedio;

        for (Donacion donacion : donaciones) {
            if (donacion.getFecha().isAfter(fecha)) {
                if(donacion.getEstado() == Estado.COBRADA) {
                    cobradas++;
                    montoTotal += donacion.getMonto();
                    if (max < donacion.getMonto()) {
                        max = donacion.getMonto();
                    }
                    if (min > donacion.getMonto()) {
                        min = donacion.getMonto();
                }
            } else if (donacion.getEstado() == Estado.RECHAZADA) {
                rechazadas++;
            } else if (donacion.getEstado() == Estado.PENDIENTE) {
                pendientes++;
            }
        }
        promedio = montoTotal / cobradas;
        
        System.out.println("Estado de Resultado de " + razonSocial + " al " + fecha.toString());
        System.out.println(" - Cobradas: " + cobradas + "\n - Rechazadas: " + rechazadas +
                            "\n - Pendientes: " + pendientes + "\n - Monto total: " + montoTotal +
                            "\n - Monto máximo: " + max + "\n - Monton mínimo: " + min + "\n - Monto medio: " + promedio);
        }
    }
}