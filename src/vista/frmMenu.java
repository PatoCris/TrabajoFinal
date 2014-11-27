/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import Modelo.Vehiculo;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author cristian
 */
public class frmMenu extends javax.swing.JFrame {
    private ControladoraVista cv = new ControladoraVista();
    /**
     * Creates new form frmMenu
     */
    public frmMenu() {
        initComponents();
        this.setTitle(".: Taller Mecánico :.");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
    }

   //ICONO
   @Override
   public Image getIconImage(){
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/car1.png"));
       return retValue;
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jdpPanelPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuAcercaDe = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuGestionCliente = new javax.swing.JMenuItem();
        mnuVincularClientesVehiculos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuVehiculo = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        mnuMarca = new javax.swing.JMenuItem();
        mnuModelo = new javax.swing.JMenuItem();
        mnuGestionEquipamiento = new javax.swing.JMenuItem();
        mnuGestionSegmento = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        mnuEspecialidades = new javax.swing.JMenuItem();
        mnuEmpleados = new javax.swing.JMenuItem();
        mnuMecanico = new javax.swing.JMenuItem();
        mnuJefeTaller = new javax.swing.JMenuItem();
        mnuJefeDeposito = new javax.swing.JMenuItem();
        mnuPerito = new javax.swing.JMenuItem();
        mnuDeposito = new javax.swing.JMenu();
        mnuGestionAccesorios = new javax.swing.JMenuItem();
        mnuPiezaRecambio = new javax.swing.JMenuItem();
        mnuPedidos = new javax.swing.JMenuItem();
        mnuServicio = new javax.swing.JMenu();
        mnuTipoReparacion = new javax.swing.JMenuItem();
        mnuTipoAnomalia = new javax.swing.JMenuItem();
        mnuTipoDiagnostico = new javax.swing.JMenuItem();
        mnuAnomalias = new javax.swing.JMenuItem();
        mnuDiagnosticos = new javax.swing.JMenuItem();
        mnuReparaciones = new javax.swing.JMenuItem();
        mnuProveedores = new javax.swing.JMenu();
        mnuGestionProveedores = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        javax.swing.GroupLayout jdpPanelPrincipalLayout = new javax.swing.GroupLayout(jdpPanelPrincipal);
        jdpPanelPrincipal.setLayout(jdpPanelPrincipalLayout);
        jdpPanelPrincipalLayout.setHorizontalGroup(
            jdpPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
        );
        jdpPanelPrincipalLayout.setVerticalGroup(
            jdpPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        mnuAcercaDe.setText("Acerca de");
        mnuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAcercaDeActionPerformed(evt);
            }
        });
        jMenu1.add(mnuAcercaDe);

        jMenuItem6.setText("Salir");
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Clientes");

        mnuGestionCliente.setText("Gestión Cliente");
        mnuGestionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGestionClienteActionPerformed(evt);
            }
        });
        jMenu2.add(mnuGestionCliente);

        mnuVincularClientesVehiculos.setText("Vincular Clientes con Vehiculos");
        mnuVincularClientesVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVincularClientesVehiculosActionPerformed(evt);
            }
        });
        jMenu2.add(mnuVincularClientesVehiculos);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Vehículo");

        mnuVehiculo.setText("Gestión Vehículo");
        mnuVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVehiculoActionPerformed(evt);
            }
        });
        jMenu3.add(mnuVehiculo);

        jMenuItem3.setText("Gestión Estado");
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Gestión Prueba Rodaje");
        jMenu3.add(jMenuItem4);

        jMenuItem10.setText("Gestión Garantía");
        jMenu3.add(jMenuItem10);

        mnuMarca.setText("Gestión Marca");
        mnuMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMarcaActionPerformed(evt);
            }
        });
        jMenu3.add(mnuMarca);

        mnuModelo.setText("Gestión Modelo");
        mnuModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModeloActionPerformed(evt);
            }
        });
        jMenu3.add(mnuModelo);

        mnuGestionEquipamiento.setText("Gestión Equipamiento");
        mnuGestionEquipamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGestionEquipamientoActionPerformed(evt);
            }
        });
        jMenu3.add(mnuGestionEquipamiento);

        mnuGestionSegmento.setText("Gestión Segmento");
        mnuGestionSegmento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGestionSegmentoActionPerformed(evt);
            }
        });
        jMenu3.add(mnuGestionSegmento);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Taller");

        jMenuItem11.setText("Gestión Taller");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Empleados");

        mnuEspecialidades.setText("Gestión de Especialidades");
        mnuEspecialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEspecialidadesActionPerformed(evt);
            }
        });
        jMenu6.add(mnuEspecialidades);

        mnuEmpleados.setText("Gestión Empleados");
        mnuEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEmpleadosActionPerformed(evt);
            }
        });
        jMenu6.add(mnuEmpleados);

        mnuMecanico.setText("Gestión Mecánico");
        mnuMecanico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMecanicoActionPerformed(evt);
            }
        });
        jMenu6.add(mnuMecanico);

        mnuJefeTaller.setText("Gestión Jefe de Taller");
        mnuJefeTaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuJefeTallerActionPerformed(evt);
            }
        });
        jMenu6.add(mnuJefeTaller);

        mnuJefeDeposito.setText("Gestión Jefe de Depósito");
        mnuJefeDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuJefeDepositoActionPerformed(evt);
            }
        });
        jMenu6.add(mnuJefeDeposito);

        mnuPerito.setText("Gestión Perito");
        mnuPerito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPeritoActionPerformed(evt);
            }
        });
        jMenu6.add(mnuPerito);

        jMenuBar1.add(jMenu6);

        mnuDeposito.setText("Depósito");

        mnuGestionAccesorios.setText("Gestión Accesorios");
        mnuGestionAccesorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGestionAccesoriosActionPerformed(evt);
            }
        });
        mnuDeposito.add(mnuGestionAccesorios);

        mnuPiezaRecambio.setText("Gestión Pieza Recambio");
        mnuPiezaRecambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPiezaRecambioActionPerformed(evt);
            }
        });
        mnuDeposito.add(mnuPiezaRecambio);

        mnuPedidos.setText("Gestion Pedidos");
        mnuPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPedidosActionPerformed(evt);
            }
        });
        mnuDeposito.add(mnuPedidos);

        jMenuBar1.add(mnuDeposito);

        mnuServicio.setText("Servicios");

        mnuTipoReparacion.setText("Gestión Tipos de Reparación");
        mnuTipoReparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTipoReparacionActionPerformed(evt);
            }
        });
        mnuServicio.add(mnuTipoReparacion);

        mnuTipoAnomalia.setText("Gestión Tipo de Anomalia");
        mnuTipoAnomalia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTipoAnomaliaActionPerformed(evt);
            }
        });
        mnuServicio.add(mnuTipoAnomalia);

        mnuTipoDiagnostico.setText("Gestión Tipo de Diagnóstico");
        mnuTipoDiagnostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTipoDiagnosticoActionPerformed(evt);
            }
        });
        mnuServicio.add(mnuTipoDiagnostico);

        mnuAnomalias.setText("Gestión de Anomalias");
        mnuAnomalias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAnomaliasActionPerformed(evt);
            }
        });
        mnuServicio.add(mnuAnomalias);

        mnuDiagnosticos.setText("Gestión de Diagnósticos");
        mnuDiagnosticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDiagnosticosActionPerformed(evt);
            }
        });
        mnuServicio.add(mnuDiagnosticos);

        mnuReparaciones.setText("Gestión de Reparaciones");
        mnuServicio.add(mnuReparaciones);

        jMenuBar1.add(mnuServicio);

        mnuProveedores.setText("Proveedores");

        mnuGestionProveedores.setText("Gestión de Proveedores");
        mnuGestionProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGestionProveedoresActionPerformed(evt);
            }
        });
        mnuProveedores.add(mnuGestionProveedores);

        jMenuBar1.add(mnuProveedores);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPanelPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPanelPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuGestionAccesoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGestionAccesoriosActionPerformed
        GestionAccesorio unaGestionAccesorio;
        try {
            unaGestionAccesorio = new GestionAccesorio(cv);
            unaGestionAccesorio.setVisible(true);
            jdpPanelPrincipal.add(unaGestionAccesorio);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
    }//GEN-LAST:event_mnuGestionAccesoriosActionPerformed

    private void mnuMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMarcaActionPerformed
        GestionMarca unaGestionMarca;
        try {
            unaGestionMarca = new GestionMarca(cv);
             unaGestionMarca.setVisible(true);
            jdpPanelPrincipal.add(unaGestionMarca);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
       
    }//GEN-LAST:event_mnuMarcaActionPerformed

    private void mnuTipoReparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTipoReparacionActionPerformed
        GestionTipoReparacion unaGestionTipoReparacion;
        try {
            unaGestionTipoReparacion = new GestionTipoReparacion(cv);
            unaGestionTipoReparacion.setVisible(true);
            jdpPanelPrincipal.add(unaGestionTipoReparacion);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_mnuTipoReparacionActionPerformed

    private void mnuAnomaliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAnomaliasActionPerformed
        GestionAnomalia unaGestionAnomalia;
        try {
            unaGestionAnomalia = new GestionAnomalia(cv);
            unaGestionAnomalia.setVisible(true);
            jdpPanelPrincipal.add(unaGestionAnomalia);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_mnuAnomaliasActionPerformed

    private void mnuDiagnosticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDiagnosticosActionPerformed
        GestionDiagnostico unaGD;
        try{
            unaGD = new GestionDiagnostico(cv);
            unaGD.setVisible(true);
            jdpPanelPrincipal.add(unaGD);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_mnuDiagnosticosActionPerformed

    private void mnuTipoAnomaliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTipoAnomaliaActionPerformed
        GestionTipoAnomalia unaGestionTipoAnomalia;
        try {
            unaGestionTipoAnomalia = new GestionTipoAnomalia(cv);
            unaGestionTipoAnomalia.setVisible(true);
            jdpPanelPrincipal.add(unaGestionTipoAnomalia);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_mnuTipoAnomaliaActionPerformed

    private void mnuGestionEquipamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGestionEquipamientoActionPerformed
        GestionEquipamiento unaGestionEquipamiento;
        try {
            unaGestionEquipamiento = new GestionEquipamiento(cv);
            unaGestionEquipamiento.setVisible(true);
            jdpPanelPrincipal.add(unaGestionEquipamiento);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_mnuGestionEquipamientoActionPerformed

    private void mnuGestionSegmentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGestionSegmentoActionPerformed
        GestionSegmento unaGestionSegmento;
        try {
            unaGestionSegmento = new GestionSegmento(cv);
            unaGestionSegmento.setVisible(true);
            jdpPanelPrincipal.add(unaGestionSegmento);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_mnuGestionSegmentoActionPerformed

    private void mnuModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModeloActionPerformed
        GestionModelo unGestionModelo;
        try {
            unGestionModelo = new GestionModelo(cv);
            unGestionModelo.setVisible(true);
            jdpPanelPrincipal.add(unGestionModelo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_mnuModeloActionPerformed

    private void mnuEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEmpleadosActionPerformed
        GestionEmpleado gestionEmpleado;
        try {
            gestionEmpleado = new GestionEmpleado(cv);
            gestionEmpleado.setVisible(true);
            jdpPanelPrincipal.add(gestionEmpleado);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_mnuEmpleadosActionPerformed

    private void mnuEspecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEspecialidadesActionPerformed
        GestionEspecialidad gestionEspecialidad;
        try{
            gestionEspecialidad = new GestionEspecialidad(cv);
            gestionEspecialidad.setVisible(true);
            jdpPanelPrincipal.add(gestionEspecialidad);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_mnuEspecialidadesActionPerformed

    private void mnuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAcercaDeActionPerformed
        AcercaDe acerca;
        acerca = new AcercaDe();
        acerca.setVisible(true);
        jdpPanelPrincipal.add(acerca);
    }//GEN-LAST:event_mnuAcercaDeActionPerformed

    private void mnuVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVehiculoActionPerformed
        GestionVehiculo miVehiculo;
        try {
            miVehiculo = new GestionVehiculo(cv);
            miVehiculo.setVisible(true);
            jdpPanelPrincipal.add(miVehiculo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_mnuVehiculoActionPerformed

    private void mnuGestionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGestionClienteActionPerformed
        GestionCliente miCliente;
        try {
            miCliente = new GestionCliente(cv);
            miCliente.setVisible(true);
            jdpPanelPrincipal.add(miCliente);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_mnuGestionClienteActionPerformed

    private void mnuPiezaRecambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPiezaRecambioActionPerformed
        GestionPiezaRecambio miPiezaRecambio;
        try {
            miPiezaRecambio = new GestionPiezaRecambio(cv);
            miPiezaRecambio.setVisible(true);
            jdpPanelPrincipal.add(miPiezaRecambio);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_mnuPiezaRecambioActionPerformed

    private void mnuGestionProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGestionProveedoresActionPerformed
        GestionProveedor miGestionProveedor;
        try {
            miGestionProveedor = new GestionProveedor(cv);
            miGestionProveedor.setVisible(true);
            jdpPanelPrincipal.add(miGestionProveedor);
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_mnuGestionProveedoresActionPerformed

    private void mnuMecanicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMecanicoActionPerformed
        GestionMecanico miGMecanico;
        try {
            miGMecanico = new GestionMecanico(cv);
            miGMecanico.setVisible(true);
            jdpPanelPrincipal.add(miGMecanico);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_mnuMecanicoActionPerformed


    private void mnuJefeDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuJefeDepositoActionPerformed
        GestionJefeDeposito miGJD;
        try {
            miGJD = new GestionJefeDeposito(cv);
            miGJD.setVisible(true);
            jdpPanelPrincipal.add(miGJD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_mnuJefeDepositoActionPerformed

    private void mnuJefeTallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuJefeTallerActionPerformed
        GestionJefeTaller miGJT;
        try {
            miGJT = new GestionJefeTaller(cv);
            miGJT.setVisible(true);
            jdpPanelPrincipal.add(miGJT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_mnuJefeTallerActionPerformed

    private void mnuPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPedidosActionPerformed
        GestionPedido miGPedido;
        try {
            miGPedido = new GestionPedido(cv);
            miGPedido.setVisible(true);
            jdpPanelPrincipal.add(miGPedido);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_mnuPedidosActionPerformed

    private void mnuVincularClientesVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVincularClientesVehiculosActionPerformed
        VincularClienteVehiculo vincularCV;
        try {
            vincularCV = new VincularClienteVehiculo(cv);
            vincularCV.setVisible(true);
            jdpPanelPrincipal.add(vincularCV);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_mnuVincularClientesVehiculosActionPerformed


    private void mnuPeritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPeritoActionPerformed
        GestionPerito unPerito;
        try {
            unPerito = new GestionPerito(cv);
            unPerito.setVisible(true);
            jdpPanelPrincipal.add(unPerito);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_mnuPeritoActionPerformed

    private void mnuTipoDiagnosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTipoDiagnosticoActionPerformed
        GestionTipoDiagnostico miGTD;
        try {
            miGTD = new GestionTipoDiagnostico(cv);
            miGTD.setVisible(true);
            jdpPanelPrincipal.add(miGTD);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_mnuTipoDiagnosticoActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        GestionTaller gestionTaller;
        try {
            gestionTaller = new GestionTaller(cv);
            gestionTaller.setVisible(true);
            jdpPanelPrincipal.add(gestionTaller);
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed



    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmMenu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    public static javax.swing.JDesktopPane jdpPanelPrincipal;
    private javax.swing.JMenuItem mnuAcercaDe;
    private javax.swing.JMenuItem mnuAnomalias;
    private javax.swing.JMenu mnuDeposito;
    private javax.swing.JMenuItem mnuDiagnosticos;
    private javax.swing.JMenuItem mnuEmpleados;
    private javax.swing.JMenuItem mnuEspecialidades;
    private javax.swing.JMenuItem mnuGestionAccesorios;
    private javax.swing.JMenuItem mnuGestionCliente;
    private javax.swing.JMenuItem mnuGestionEquipamiento;
    private javax.swing.JMenuItem mnuGestionProveedores;
    private javax.swing.JMenuItem mnuGestionSegmento;
    private javax.swing.JMenuItem mnuJefeDeposito;
    private javax.swing.JMenuItem mnuJefeTaller;
    private javax.swing.JMenuItem mnuMarca;
    private javax.swing.JMenuItem mnuMecanico;
    private javax.swing.JMenuItem mnuModelo;
    private javax.swing.JMenuItem mnuPedidos;
    private javax.swing.JMenuItem mnuPerito;
    private javax.swing.JMenuItem mnuPiezaRecambio;
    private javax.swing.JMenu mnuProveedores;
    private javax.swing.JMenuItem mnuReparaciones;
    private javax.swing.JMenu mnuServicio;
    private javax.swing.JMenuItem mnuTipoAnomalia;
    private javax.swing.JMenuItem mnuTipoDiagnostico;
    private javax.swing.JMenuItem mnuTipoReparacion;
    private javax.swing.JMenuItem mnuVehiculo;
    private javax.swing.JMenuItem mnuVincularClientesVehiculos;
    // End of variables declaration//GEN-END:variables
}
