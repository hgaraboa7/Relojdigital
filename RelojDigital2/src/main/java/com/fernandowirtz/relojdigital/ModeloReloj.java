/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernandowirtz.relojdigital;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author hecto
 */
public class ModeloReloj {

    public boolean formato24h = true;

    public boolean fechaVisible = true;

    public Font fuente = new Font("Arial", Font.PLAIN, 20);

    public Color colorFondo = Color.BLACK;

    static DefaultListModel<Alarma> modeloAlarmas = new DefaultListModel();

    public ModeloReloj() {
    }

    public LocalDateTime getFechaActual() {
        return LocalDateTime.now();

    }

    public boolean isFormato24h() {
        return formato24h;
    }

    public void setFormato24h(boolean formato24h) {
        this.formato24h = formato24h;
    }

    public boolean isFechaVisible() {
        return fechaVisible;
    }

    public void setFechaVisible(boolean fechaVisible) {
        this.fechaVisible = fechaVisible;
    }

    public Font getFuente() {
        return fuente;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void agregarAlarma(Alarma alarma) {

        if (alarma.futura()) {

            modeloAlarmas.addElement(alarma);
            
        } else {
            System.out.println("Alarma en fecha/hora ya pasada");
        }
    }

    public void eliminarAlarma(Alarma alarma) {

        modeloAlarmas.removeElement(alarma);

    }

    public static DefaultListModel getModeloAlarmas() {
        return modeloAlarmas;
    }

}
