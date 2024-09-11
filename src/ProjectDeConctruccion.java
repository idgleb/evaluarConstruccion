import javax.swing.*;
import java.time.LocalDate;

public class ProjectDeConctruccion {
    private final String[] etapas = {"Diseno", "Conctruccion", "Entrega"};
    private static String informe = "";

    private String nombre;
    private String ubicacion;
    private Cliente cliente;
    private LocalDate fechaInicio;

    private int[] calificacionEtapas; // 1 al 10

    public ProjectDeConctruccion(String nombre, String ubicacion, Cliente cliente, LocalDate fechaInicio) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
    }

    public void evaluarEtapas() {
        calificacionEtapas = new int[etapas.length];
        for (int i = 0; i < etapas.length; i++) {
            String califStr;
            do {
                califStr = JOptionPane.showInputDialog(null, "calfica de 1 a 10 la etapa " + etapas[i]);
                if (califStr == null) califStr = "";
            } while (!isNumeroDe_1_10(califStr));
            calificacionEtapas[i] = Integer.parseInt(califStr);
        }

        agregarInfoEnInforme();
    }

    private void agregarInfoEnInforme() {

        String info = "\n Nombre de projecto: " + nombre +
                "\n ubicacion: " + ubicacion +
                "\n Cliente: " + cliente.getNombre() +
                "\n Fecha de inicio: " + fechaInicio;

        String calificasionesDeEtapas = "";
        for (int i = 0; i < calificacionEtapas.length; i++) {
            calificasionesDeEtapas += " Etapa " + etapas[i] + ": " + calificacionEtapas[i] + ", ";
        }

        informe += info + "\n " + calificasionesDeEtapas + "\n ";

    }

    public String getInforme() {
        return informe;
    }

    public static boolean isNumeroDe_1_10(String str) {
        if (str.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') return false;
            }
            int mes = Integer.parseInt(str);
            if (mes < 1 || mes > 10) {
                return false;
            }
        }
        return true;
    }

}
