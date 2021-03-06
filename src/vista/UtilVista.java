/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author cristian
 */
public class UtilVista {

    public UtilVista() {
    }

    public DefaultComboBoxModel cargarCombo(List<?> miLista) {
        DefaultComboBoxModel miCombo = new DefaultComboBoxModel();
        if (miLista != null) {
            miCombo.addElement("[SELECCIONAR]");
            for (Object object : miLista) {
                miCombo.addElement(object);
            }
        }
        return miCombo;
    }
    
    public DefaultComboBoxModel cargarComboUnElemento(Object miClase){
        DefaultComboBoxModel miCombo = new DefaultComboBoxModel();
        miCombo.addElement(miClase);
        return miCombo;
    }

    public DefaultListModel cargarLista(List<?> miLista) {
        DefaultListModel miList = new DefaultListModel();
        if (miLista != null) {
            int cantidad = miLista.size();
            for (int i = 0; i < cantidad; i++) {
                miList.addElement(miLista.get(i));
            }
        }
        return miList;
    }

    public void verificarNombre(String nombre) throws Exception {
        if (nombre.length() < 2) {
            throw new Exception("Error: Por favor ingrese un Nombre.");
        }
    }

    public void verificarApellido(String apellido) throws Exception {
        if (apellido.length() < 2) {
            throw new Exception("Error: Por favor ingrese un Apellido.");
        }
    }

    public void verificarDescripcion(String descripcion) throws Exception {
        if (descripcion.length() < 2) {
            throw new Exception("Error: Por favor ingrese una Descripción.");
        }
    }

    public void verificarDni(String dni) throws Exception {
        if (dni.length() != 8) {
            throw new Exception("Error: Por favor ingrese un DNI válido (8 digitos).");
        }
    }

    public void verificarCuil(String cuil) throws Exception {
        if (cuil.length() != 11) {
            throw new Exception("Error: Por favor ingrese un CUIL válido (11 digitos).");
        }
    }

    public void verificarCuit(String cuit) throws Exception {
        if (cuit.length() != 11) {
            throw new Exception("Error: Por favor ingrese un CUIT válido (11 digitos).");
        }
    }

    public void verificarCombos(String seleccionado, String nombre) throws Exception {
        if (seleccionado.equals("[SELECCIONAR]")) {
            throw new Exception("Error: Debe seleccionar un/una " + nombre + ".");
        }
    }

    public String password(char[] password) {
        String pass = new String(password);
        return pass;
    }

    public void verificarString(String string, String nombre) throws Exception {
        if (string.equals("")) {
            throw new Exception("Error: El campo " + nombre + " está vacio.");
        }
    }

    public Date ParseFecha(String fecha, String error) throws Exception {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            throw new Exception(error);

        }
        return fechaDate;
    }

    void verificarTelefono(String telefono) throws Exception {
        if (telefono.isEmpty()) {
            throw new Exception("Error: Por favor ingrese un Teléfono válido.");
        }
    }

    
   public Date ParseHora (String hora, String error)throws Exception{
   SimpleDateFormat formato = new SimpleDateFormat("H:mm");
   Date horaDate = null;
       try {
           horaDate = formato.parse(hora);
       } catch (ParseException ex) {
           throw new Exception(error);
       }
       return horaDate;
   }
    public String getHora(Date date) throws Exception {
        try {
            Date ahora = date;
        SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");
        return formateador.format(ahora);
        } catch (Exception e) {
            throw new Exception(e);
        }
        
    }
    public Date convertirHora(String horaS, String error) throws ParseException, Exception {
        DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(horaS);
        }catch (ParseException ex) {
            throw new Exception(error);
        }
        return date;
        }
    public Date hora(String myTime, String error) throws Exception { 
        //String myTime = "10:30:54"; 
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm"); 
        Date date = null; 
        try { 
            date = sdf.parse(myTime); 
        } catch (ParseException e) { 
            throw new Exception(error); 
        } 
//        String formattedTime = sdf.format(date); 
//        System.out.println(formattedTime); +" "+e.printStackTrace()
        return date;
    } 



//    public Date ParseHora(String hora, String error) throws Exception {
//        SimpleDateFormat formato = new SimpleDateFormat("hh:mm:ss");
//        Date horaDate = null;
//        try {
//            horaDate = formato.parse(hora);
//        } catch (ParseException ex) {
//            throw new Exception(error);
//        }
//        return horaDate;
//    }
//
//    public Date convertirHora(String horaS, String error) throws ParseException, Exception {
//        DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
//        Date date = null;
//        try {
//        date = sdf.parse(horaS);
//        }catch (ParseException ex) {
//            throw new Exception(error);
//        }
//        return date;
//    }
}
