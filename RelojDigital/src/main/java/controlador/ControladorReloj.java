/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.fernandowirtz.relojdigital.Alarma;
import com.fernandowirtz.relojdigital.Alarmalistener;
import com.fernandowirtz.relojdigital.ModeloReloj;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import vista.RelojPane;

/**
 *
 * @author hecto
 */
public class ControladorReloj implements Alarmalistener {

    public ModeloReloj modelo;

    public RelojPane vista;

    private Timer timer;

    public ControladorReloj(ModeloReloj modelo, RelojPane vista) {

        this.modelo = modelo;

        this.vista = vista;

        vista.getTbtnFormato().addActionListener(e -> setFormato24H());

        vista.getTbtnFecha().addActionListener(e -> setFechaVisible());

        vista.getBtnAñadirAlarma().addActionListener(e -> setAlarma());

        vista.getBtnEliminarAlarma().addActionListener(e -> eliminarAlarma());

        vista.getBtnDialogAlarma().addActionListener(e -> abridDialogAlarma());

        vista.getBtnDialogLista().addActionListener(e -> abridDialogLista());

        actualizarListaAlarmas(modelo.getModeloAlarmas());

        modelo.addAlarmaListener(this);

        iniciarReloj();

    }

    private void setFormato24H() {

        if (vista.getTbtnFormato().isSelected()) {

            vista.getTbtnFormato().setBackground(Color.red);

            modelo.setFormato24h(!modelo.isFormato24h());

        } else if (!vista.getTbtnFormato().isSelected()) {

            vista.getTbtnFormato().setBackground(Color.green);

            modelo.setFormato24h(!modelo.isFormato24h());
        }

    }

    private void setFechaVisible() {

        if (vista.getTbtnFecha().isSelected()) {

            vista.getTbtnFecha().setBackground(Color.red);

            modelo.setFechaVisible(!modelo.isFechaVisible());

        } else if (!vista.getTbtnFecha().isSelected()) {

            vista.getTbtnFecha().setBackground(Color.green);

            modelo.setFechaVisible(!modelo.isFechaVisible());
        }

    }

    private void setAlarma() {

        try {

            String fecha = vista.getTxtFecha().getText();

            String hora = vista.getTxtHora().getText();

            String mensaje = vista.getTxtMensaje().getText();

            String fecha_hora = fecha + " " + hora;

            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

            LocalDateTime momento = LocalDateTime.parse(fecha_hora, formateador);

            Alarma alarma = new Alarma(momento, mensaje);

            modelo.agregarAlarma(alarma);

            vista.getTxtFecha().setText("yyyy/MM/dd");

            vista.getTxtHora().setText("HH:mm");

            vista.getTxtMensaje().setText("");

            actualizarListaAlarmas(modelo.getModeloAlarmas());

        } catch (DateTimeParseException ex) {

            System.out.println("Error en el formato de la alarma");

            vista.getTxtFecha().setText("yyyy/MM/dd");

            vista.getTxtHora().setText("HH:mm");

        }

    }

    private void iniciarReloj() {

        timer = new Timer(1000, e -> {
            LocalDateTime fechaActual = modelo.getFechaActual();
            actualizarVista(fechaActual);
            verificarAlarmas(fechaActual);

        });

        timer.start();

    }

    private void actualizarVista(LocalDateTime fechaActual) {

        DateTimeFormatter formatoHora = modelo.isFormato24h() ? DateTimeFormatter.ofPattern("HH:mm:ss")
                : DateTimeFormatter.ofPattern("hh:mm:ss a");

        vista.actualizarHora(fechaActual.format(formatoHora));

        if (modelo.isFechaVisible()) {
            vista.actualizarFecha(fechaActual.toLocalDate().toString());
        } else {
            vista.actualizarFecha("");
        }

    }

    private void verificarAlarmas(LocalDateTime fechaActual) {
        DefaultListModel<Alarma> modeloAlarmas = modelo.getModeloAlarmas();

        for (int i = 0; i < modeloAlarmas.getSize(); i++) {
            Alarma alarma = modeloAlarmas.get(i);
            if (alarma.sonarAlarma(fechaActual)) {
                System.out.println(alarma.getMensaje());
                int opcion = JOptionPane.showConfirmDialog(null, alarma.getMensaje() + "\n" + "  ¿Eliminar alarma?", "Alarma sonando", JOptionPane.YES_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {

                    modelo.eliminarAlarma(alarma);

                }

            }
        }

    }

    private void actualizarListaAlarmas(DefaultListModel modeloAlarmas) {

        vista.getjLAlarmas().setModel(modeloAlarmas);

    }

    private void eliminarAlarma() {

        Alarma alarma = vista.getjLAlarmas().getSelectedValue();

        modelo.eliminarAlarma(alarma);

        DefaultListModel<Alarma> modeloAlarmas = modelo.getModeloAlarmas();

        actualizarListaAlarmas(modeloAlarmas);

    }

    private void abridDialogAlarma() {

        vista.getDiaAlarma().setVisible(true);
        vista.getDiaAlarma().setSize(386, 489);

    }

    private void abridDialogLista() {

        vista.getDiaLista().setVisible(true);
        vista.getDiaLista().setSize(386, 489);

    }

    @Override
    public void alarmaActivada(Alarma alarma) {
        JOptionPane.showMessageDialog(
                vista,
                "¡Alarma activada! " + alarma.getMensaje(),
                "Alarma",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

}
