/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author cristian
 */
public class UtilVista {

    public UtilVista() {
    }
    
    public DefaultComboBoxModel cargarCombo (List<?> miLista){
        DefaultComboBoxModel miCombo = new DefaultComboBoxModel();
        if(miLista != null){
            miCombo.addElement("[SELECCIONAR]");
            for (Object object : miLista) {
                miCombo.addElement(object); 
            }
        }
        return miCombo;
    }
    public void verificarNombre(String nombre) throws Exception{
        if(nombre.length() < 2){
            throw new Exception("Error: Por favor ingrese un Nombre.");
        }
    }
    
    public void verificarApellido(String apellido) throws Exception{
        if(apellido.length() < 2){
            throw new Exception ("Error: Por favor ingrese un Apellido.");
        }
    }
    
    public void verificarDescripcion(String descripcion) throws Exception{
        if(descripcion.length() < 2){
            throw new Exception ("Error: Por favor ingrese una Descripción.");
        }
    }
    
    public void verificarDni(String dni) throws Exception{
        if(dni.length() != 8){
            throw new Exception ("Error: Por favor ingrese un DNI válido (8 digitos).");
        }
    }
    
    public void verificarCuil(String cuil) throws Exception{
        if(cuil.length() != 11){
            throw new Exception ("Error: Por favor ingrese un CUIL válido (11 digitos).");
        }
    }
    
    public void verificarCuit(String cuit) throws Exception{
        if(cuit.length() != 11){
            throw new Exception ("Error: Por favor ingrese un CUIT válido (11 digitos).");
        }
    }
    public void verificarCombos(String seleccionado, String nombre) throws Exception{
        if(seleccionado.equals("[SELECCIONAR]")){
            throw new Exception("Error: Debe seleccionar un/una "+nombre+".");
        }
    }
}
    

