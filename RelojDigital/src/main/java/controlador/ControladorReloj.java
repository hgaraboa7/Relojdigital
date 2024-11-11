/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.fernandowirtz.relojdigital.Alarma;
import com.fernandowirtz.relojdigital.ModeloReloj;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.DefaultListModel;
import javax.swing.Timer;
import vista.Reloj;
import vista.RelojPane;

/**
 *
 * @author hecto
 */
public class ControladorReloj {

    public ModeloReloj modelo;

    public RelojPane vista;
    
    private Timer timer;
    
    static DefaultListModel modeloAlarmas= new DefaultListModel() ;

    public ControladorReloj(ModeloReloj modelo, RelojPane vista) {

        this.modelo = modelo;

        this.vista = vista;

        vista.getjLAlarmas().setModel(modeloAlarmas);
        
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
        
        try{
        
       String fecha=vista.getTxtFecha().getText();
       
       String hora=vista.getTxtHora().getText();
       
       String mensaje=vista.getTxtMensaje().getText();
       
       
       String fecha_hora=fecha+" "+hora;
       
       //java.time.format.DateTimeParseException
       
//       LocalDate fechaLD=LocalDate.parse(fecha);
//       
//       
      DateTimeFormatter formateador= DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
//       
       LocalDateTime momento= LocalDateTime.parse(fecha_hora, formateador);
      
       
       
      Alarma alarma= new Alarma(momento, mensaje);
        
        
        modelo.agregarAlarma(alarma);
        
        
        }catch(DateTimeParseException ex){
            
            System.out.println("Error en el formato de la alarma");
            
            vista.getTxtFecha().setText("yyyy-MM-dd");
            
             vista.getTxtHora().setText("HH:mm");
            
            
        }
        
        
        
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
