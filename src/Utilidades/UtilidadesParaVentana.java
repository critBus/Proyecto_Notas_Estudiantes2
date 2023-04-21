/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

/**
 *
 * @author PC
 */
public abstract class UtilidadesParaVentana {
    public static void cambiarIconoDeDireccion(JButton boton, boolean arriba) {
        try {
            Class rfe = EnMemoria.BD.getClass();
            ImageIcon iconoArriba = new ImageIcon(rfe.getResource("../imgs/arriba double reducida.png"));
            ImageIcon iconoAbajo = new ImageIcon(rfe.getResource("../imgs/abajo double copia.png"));

            boton.setIcon(arriba ? iconoArriba : iconoAbajo);
        } catch (Exception ex) {
           
            try {
                File f=new File("../src/imgs/arriba double reducida.png");
                URL url = new URL(f.toURI().toURL().toString());
                
                
                ImageIcon iconoArriba = new ImageIcon(url);
                f=new File("../src/imgs/abajo double copia.png");
                url = new URL(f.toURI().toURL().toString());
                ImageIcon iconoAbajo = new ImageIcon(url);
                
                boton.setIcon(arriba ? iconoArriba : iconoAbajo);
            } catch (MalformedURLException ex1) {
                Logger.getLogger(UtilidadesParaVentana.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public static void ponerIconoDeVentana_Principal(Window w) {
        try {
            Class rfe = EnMemoria.BD.getClass();
            Image iconoVentana = Toolkit.getDefaultToolkit().getImage(rfe.getResource("../imgs/Sin título-1 ajustado 30.png"));

            w.setIconImage(iconoVentana);
        } catch (Exception ex) {
            try {
              
                File f=new File("../src/imgs/Sin título-1 ajustado 30.png");
                
                URL url = new URL(f.toURI().toURL().toString());
                ImageIcon icono = new ImageIcon(url);
                Image iconoVentana = icono.getImage();

                w.setIconImage(iconoVentana);
            } catch (MalformedURLException ex1) {
                ex.printStackTrace();
                Logger.getLogger(UtilidadesParaVentana.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    
    
    public static void ponerFechaActual(JFormattedTextField fechaTextField) {
        ponerFecha(new Date(),fechaTextField);
    }
    public static String obtenerFechaConFormato(Date d){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        String fechaActualTexto = formatoFecha.format(d);
        return fechaActualTexto;
    }
    public static void ponerFecha(Date d, JFormattedTextField fechaTextField) {
        
        fechaTextField.setText(obtenerFechaConFormato(d));
    }

    public static Date obtenerFecha(String fechaStr) throws ParseException{
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);
        Date fechaParseada = formatoFecha.parse(fechaStr);
        return fechaParseada;
    }
    
}
