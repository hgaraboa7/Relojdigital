/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernandowirtz.relojdigital;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.swing.DefaultListModel;

/**
 *
 * @author hecto
 */
public class Alarma implements Serializable {
    
    public LocalDateTime momento;
    
    public String mensaje;
    
   
    
    public Alarma(LocalDateTime momento, String mensaje){
        
        this.momento=momento;
        
        this.mensaje=mensaje;
        
        
        
    }

    

    public LocalDateTime getMomento() {
        return momento;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
    public boolean futura(){
        
        return momento.isAfter(LocalDateTime.now());
        
    }
    
    public boolean sonarAlarma(LocalDateTime ahora){
        
       return ahora.isAfter(momento) || ahora.isEqual(momento);
        
        
    }

    @Override
    public String toString() {
        
    
        
        return "Alarma " + "momento= " + momento.toLocalDate()+" " + momento.toLocalTime() + ", mensaje=" + mensaje + '.';
    }

   
    
    
    
    
    
}
