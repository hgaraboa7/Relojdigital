/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.fernandowirtz.relojdigital.ModeloReloj;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;
import vista.Reloj;

/**
 *
 * @author hecto
 */
public class ControladorReloj {

    public ModeloReloj modelo;

    public Reloj vista;
    
    private Timer timer;

    public ControladorReloj(ModeloReloj modelo, Reloj vista) {

        this.modelo = modelo;

        this.vista = vista;

        vista.getBtnFormato().addActionListener(e -> setFormato24H());

        vista.getBtnFecha().addActionListener(e -> setFechaVisible());
        
        vista.getBtnAñadirAlarma().addActionListener(e -> setAlarma() );
        
        iniciarReloj();

    }

    private void setFormato24H() {

        modelo.setFormato24h(!modelo.isFormato24h());

    }

    private void setFechaVisible() {

        modelo.setFechaVisible(!modelo.isFechaVisible());

    }
    
    private void setAlarma(){
        
       String fecha=vista.getTxtFecha().getText();
       
       String hora=vista.getTxtHora().getText();
       
       String mensaje=vista.getTxtMensaje().getText();
       
       //fecha.
       
       
       
      
       
      // Alarma alarma= new Alarma()
        
        
       // modelo.agregarAlarma(alarma);
        
    }
    
    private void iniciarReloj(){
         
        
        
        timer=new Timer(1000, e->{
            LocalDateTime fechaActual=modelo.getFechaActual();
            actualizarVista(fechaActual);
            verificarAlarmas(fechaActual);
        });
        
        timer.start();
        
        
    }
    
    
    private void actualizarVista(LocalDateTime fechaActual){
        
        DateTimeFormatter formatoHora=modelo.isFormato24h()?DateTimeFormatter.ofPattern("HH:mm:ss"):
                DateTimeFormatter.ofPattern("hh:mm:ss a");
        
        vista.actualizarHora(fechaActual.format(formatoHora));
        
        if(modelo.isFechaVisible()){
            vista.actualizarFecha(fechaActual.toLocalDate().toString());
        }else{
            vista.actualizarFecha("");
        }
        
        
    }
    
    private void verificarAlarmas(LocalDateTime fechaActual){
        
        modelo.getAlarmas().removeIf(alarma->{
            if(alarma.sonarAlarma(fechaActual)){
                System.out.println(alarma.getMensaje());
                return true;
            }else{
                return false;
            }
        });
        
    }
    
    
    
    

}
