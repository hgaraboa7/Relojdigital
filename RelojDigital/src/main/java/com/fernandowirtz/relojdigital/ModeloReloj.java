/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernandowirtz.relojdigital;

import controlador.ControladorReloj;
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.DefaultListModel;

/**
 *
 * @author hecto
 */
public class ModeloReloj {

    public boolean formato24h = true;

    public boolean fechaVisible = true;

    public Font fuente2 = new Font("Arial", Font.PLAIN, 35);

    public Font fuente = new Font("Arial", Font.PLAIN, 12);

    public Color colorFondo = Color.BLACK;

    private List<Alarma> alarmas = new ArrayList<>();

    private List<Alarmalistener > listeners = new ArrayList<>();

    static DefaultListModel<Alarma> modeloAlarmas = new DefaultListModel();

    private Preferences preferencias;

    private Serializer serializador;

    public ModeloReloj() {

        this.preferencias = Preferences.userNodeForPackage(ModeloReloj.class);
        cargarPreferencias();
        cargarAlarmas();

    }

    public LocalDateTime getFechaActual() {
        return LocalDateTime.now();

    }

    public boolean isFormato24h() {
        return formato24h;
    }

    public void setFormato24h(boolean formato24h) {
        System.out.println(formato24h);
        this.preferencias.putBoolean("formato24h", formato24h);
        this.formato24h = formato24h;

    }

    public boolean isFechaVisible() {
        return fechaVisible;
    }

    public void setFechaVisible(boolean fechaVisible) {
        System.out.println(fechaVisible);
        this.preferencias.putBoolean("formatoFecha", fechaVisible);
        this.fechaVisible = fechaVisible;
    }

    public Font getFuente() {
        return fuente;
    }

    public Font getFuente2() {
        return fuente2;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void agregarAlarma(Alarma alarma) {

        if (alarma.futura()) {

            modeloAlarmas.addElement(alarma);

            alarmas.add(alarma);

            serializador.save("info.ser", new ArrayList<>(alarmas));

        } else {
            System.out.println("Alarma en fecha/hora ya pasada");
        }
    }

    public void eliminarAlarma(Alarma alarma) {

        modeloAlarmas.removeElement(alarma);
        alarmas.remove(alarma);
        notificarAlarmaborrada(alarma);

        serializador.save("info.ser", new ArrayList<>(alarmas));

    }

    public static DefaultListModel getModeloAlarmas() {
        return modeloAlarmas;
    }

    public void cargarPreferencias() {

        this.formato24h = preferencias.getBoolean("formato24h", true);
        this.fechaVisible = preferencias.getBoolean("formatoFecha", true);

    }

    
    //funciona incorrectamente
    private void notificarAlarmaActivada(Alarma alarma) {
        for (Alarmalistener  listener : listeners) {
            listener.alarmaActivada(alarma);
        }
    }
     private void notificarAlarmaborrada(Alarma alarma) {
        for (Alarmalistener  listener : listeners) {
            listener.alarmaBorrada(alarma);
        }
    }

    public void addAlarmaListener(Alarmalistener  listener) {
        listeners.add(listener);
    }

    public void cargarAlarmas()  {
        
        
        
        List<Alarma> cargadas = serializador.read("info.ser", ArrayList.class);
        if (cargadas != null) {
            alarmas.clear();
            for (Alarma alarma : cargadas) {
                if (alarma.sonarAlarma(LocalDateTime.now())) {
                    System.out.println("Alarma vencida detectada: " + alarma.getMensaje());
                    notificarAlarmaActivada(alarma); //funciona incorrectamente

                } else {
                    alarmas.add(alarma);
                    modeloAlarmas.addElement(alarma);
                }
            }
            serializador.save("info.ser", new ArrayList<>(alarmas));
        }
        
    }

}
