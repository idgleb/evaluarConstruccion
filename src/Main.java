import javax.swing.*;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Cliente newCliente = null;
        ProjectDeConctruccion newProj = null;

        int seleccion = 0;
        do {
            String[] opciones = {"Registrar projecto", "evaluar etapas", "Leer informe", "Salir"};
            seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Ursol",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            switch (seleccion) {
                case 0:
                    String nombreCliente = JOptionPane.showInputDialog("Nmbre de cliente?");
                    String dniCliente = JOptionPane.showInputDialog("Dni de cliente?");
                    newCliente = new Cliente(nombreCliente, dniCliente);

                    String nombreProj = JOptionPane.showInputDialog("Nombre de projecto?");
                    String ubicacionProj = JOptionPane.showInputDialog("Ubicacion?");
                    LocalDate fechaInicioProj = LocalDate.now();
                    newProj = new ProjectDeConctruccion(nombreProj, ubicacionProj, newCliente, fechaInicioProj);

                    break;
                case 1:
                    if (newProj != null) {
                        newProj.evaluarEtapas();
                    } else
                        JOptionPane.showMessageDialog(null, "No hay projecto, de primero pulsa <Registrar projecto>");
                    break;
                case 2:
                    if (newProj != null) {
                        JOptionPane.showMessageDialog(null, newProj.getInforme());
                    } else
                        JOptionPane.showMessageDialog(null, "No hay projecto, de primero pulsa <Registrar projecto>");
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        } while (seleccion != 3);


//projectos de construccion


    }
}