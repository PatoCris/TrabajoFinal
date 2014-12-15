/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import Modelo.Cliente;
import Modelo.JefeDeposito;
import Modelo.JefeTaller;
import Modelo.Pedido;
import Modelo.PiezaRecambio;
import Modelo.Vehiculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class GestionPedido extends javax.swing.JInternalFrame {
    private ControladoraVista cv;
    private String bandera;
    private UtilVista util;
    private DefaultTableModel miTabla;
    /**
     * Creates new form GestionPedido
     */
    public GestionPedido(ControladoraVista controladoraVista) throws Exception {
        cv = controladoraVista;
        initComponents();
        util = new UtilVista();
        cargarTablaCliente(tblClientes, cv.traerClientes(true));
        cargarTablaPedidos(tblPedidos, cv.traerPedidos(true));
        estadoInicio();
        try{
            this.cmbJDeposito.setModel(util.cargarCombo(cv.traerJefesDeposito(true)));
            this.cmbJTaller.setModel(util.cargarCombo(cv.traerJefesTaller(true)));
            this.cmbPieza.setModel(util.cargarCombo(cv.traerPiezaRecambios(true)));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void limpiar() {
        txtCodigo.setText("");
        txtCantidad.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        tarDescripcion.setText("");
        chkAutorizado.setSelected(false);
        chkParaRecambio.setSelected(false);
        cmbJDeposito.setToolTipText("SELECCIONAR");
        cmbJTaller.setToolTipText("SELECCIONAR");
        cmbPieza.setToolTipText("SELECCIONAR");
        cmbVehiculo.setToolTipText("SELECCIONAR");
    }

    public void estadoInicio() {
        bandera = "";
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        txtCodigo.setEnabled(false);
        txtFecha.setEnabled(false);
        txtCantidad.setEnabled(false);
        txtHora.setEnabled(false);
        tarDescripcion.setEnabled(false);
        chkAutorizado.setEnabled(false);
        chkParaRecambio.setEnabled(false);
        cmbJDeposito.setToolTipText("SELECCIONAR");
        cmbJTaller.setToolTipText("SELECCIONAR");
        cmbPieza.setToolTipText("SELECCIONAR");
        cmbVehiculo.setToolTipText("SELECCIONAR");
        cmbJDeposito.setEnabled(false);
        cmbJTaller.setEnabled(false);
        cmbPieza.setEnabled(false);
        cmbVehiculo.setEnabled(false);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnNuevo.setEnabled(true);
        tblClientes.setEnabled(false);
        limpiar();
    }
    public void cargarTablaCliente(JTable laTabla, List<Cliente> lista) throws Exception {
        miTabla = new DefaultTableModel();
        String cabecera[] = {"Código", "DNI", "Nombre", "Apellido"};
        miTabla.setColumnIdentifiers(cabecera);
        Object fila[] = new Object[miTabla.getColumnCount()];
        int cantidad = lista.size();
        if (cantidad > 0) {
            for (Cliente cliente : lista) {
                fila[0] = cliente.getCodigo();
                fila[1] = cliente.getDni();
                fila[2] = cliente.getNombre();
                fila[3] = cliente.getApellido();
                miTabla.addRow(fila);
            }
        }
        laTabla.setModel(miTabla);
    }
    
    public void cargarTablaPedidos(JTable laTabla, List<Pedido> lista) throws Exception {
        miTabla = new DefaultTableModel();
        String cabecera[] = {"Código", "Fecha", "Hora", "Cantidad", "Para recambio", "Autorizado", "J. Taller", "J. Depósito", "Pieza", "Cliente", "Vehiculo"};
        miTabla.setColumnIdentifiers(cabecera);
        Object fila[] = new Object[miTabla.getColumnCount()];
        int cantidad = lista.size();
        if (cantidad > 0) {
            for (Pedido unPedido : lista) {
                fila[0] = unPedido.getCodigo();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String fechaDate = formato.format(unPedido.getFecha());
                fila[1] = fechaDate;
                SimpleDateFormat formatoHs = new SimpleDateFormat("hh:mm:ss");
                String horaDate = formatoHs.format(unPedido.getHora());
                fila[2] = horaDate;
                fila[3] = unPedido.getCantidad();
                fila[4] = unPedido.isParaRecambio();
                fila[5] = unPedido.isAutorizado();
                fila[6] = unPedido.getUnJefeTaller();
                fila[7] = unPedido.getUnJefeDeposito();
                fila[8] = unPedido.getUnaPieza();
                fila[9] = unPedido.getUnCliente();
                fila[10]= unPedido.getUnVehiculo();
                miTabla.addRow(fila);
            }
        }
        laTabla.setModel(miTabla);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tarDescripcion = new javax.swing.JTextArea();
        txtFecha = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHora = new javax.swing.JFormattedTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        chkParaRecambio = new javax.swing.JCheckBox();
        chkAutorizado = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtApellidoBusqueda = new javax.swing.JTextField();
        btnBusquedaCliente = new javax.swing.JButton();
        btnActualizarCliente = new javax.swing.JButton();
        txtDniBusqueda = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cmbVehiculo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbJTaller = new javax.swing.JComboBox();
        cmbJDeposito = new javax.swing.JComboBox();
        cmbPieza = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCrearInfo = new javax.swing.JButton();

        setTitle("Gestión de Pedidos");
        setName("frmPedidos"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel2.setText("Código:");

        jLabel3.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel3.setText("Fecha:");

        jLabel4.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel4.setText("Descripción:");

        tarDescripcion.setColumns(20);
        tarDescripcion.setRows(5);
        jScrollPane1.setViewportView(tarDescripcion);

        try {
            txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFecha.setNextFocusableComponent(txtHora);

        jLabel5.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel5.setText("Hora:");

        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHora.setNextFocusableComponent(txtCantidad);

        txtCantidad.setNextFocusableComponent(chkParaRecambio);
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel6.setText("Cantidad:");

        chkParaRecambio.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        chkParaRecambio.setText("Para Recambio");
        chkParaRecambio.setNextFocusableComponent(chkAutorizado);

        chkAutorizado.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        chkAutorizado.setText("Autorizado");
        chkAutorizado.setNextFocusableComponent(tblClientes);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda de Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Politica", 0, 16))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnBusquedaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btnBusquedaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaClienteActionPerformed(evt);
            }
        });

        btnActualizarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/refresh.png"))); // NOI18N
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });

        txtDniBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniBusquedaKeyTyped(evt);
            }
        });

        jLabel9.setText("DNI:");

        jLabel12.setText("Apellido:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDniBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDniBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtApellidoBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusquedaCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnActualizarCliente, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "DNI", "Nombre", "Apellido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setNextFocusableComponent(cmbVehiculo);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblClientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );

        jLabel7.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel7.setText("Vehiculo:");

        cmbVehiculo.setNextFocusableComponent(cmbJTaller);

        jLabel8.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel8.setText("Jefe de Taller:");

        jLabel10.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel10.setText("Jefe de Depósito:");

        jLabel11.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel11.setText("Pieza de Recambio:");

        cmbJTaller.setNextFocusableComponent(cmbJDeposito);

        cmbJDeposito.setNextFocusableComponent(cmbPieza);

        cmbPieza.setNextFocusableComponent(btnGuardar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chkParaRecambio)
                .addGap(18, 18, 18)
                .addComponent(chkAutorizado)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbJDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbJTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkAutorizado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkParaRecambio, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbVehiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbJTaller, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbJDeposito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(cmbPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(72, 72, 72))
        );

        jLabel1.setFont(new java.awt.Font("Politica", 1, 24)); // NOI18N
        jLabel1.setText("GESTIÓN DE PEDIDOS");
        jLabel1.setToolTipText("");

        btnGuardar.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setNextFocusableComponent(btnNuevo);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add-1-icon.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Politica", 1, 16))); // NOI18N
        jPanel4.setName("frmTipoRecambio"); // NOI18N

        btnBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/refresh.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel13.setText("Dominio del Vehiculo");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBusqueda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblPedidos.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Fecha", "Hora", "Cantidad", "Para recambio", "Autorizado", "Jefe Taller", "Jefe Depósitol", "Pieza"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPedidos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnEditar.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil_edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Trash.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/close_16.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnCrearInfo.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnCrearInfo.setText("Crear Informe");
        btnCrearInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(btnNuevo))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrearInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnCrearInfo))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusquedaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaClienteActionPerformed
        if((!txtDniBusqueda.getText().isEmpty()) || (!txtApellidoBusqueda.getText().isEmpty())){
            String dniBusqueda = txtDniBusqueda.getText();
            String apellidoBusqueda = txtApellidoBusqueda.getText();
            int dniBusquedaInt = 0;
            if(dniBusqueda.length() > 0){
                dniBusquedaInt = Integer.valueOf(dniBusqueda);
            }
            try {
                cargarTablaCliente(tblClientes, cv.traerClientesBusqueda(true, apellidoBusqueda, dniBusquedaInt));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Los campos de busqueda están vacios.");
        }
    }//GEN-LAST:event_btnBusquedaClienteActionPerformed

    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
        try {
            cargarTablaCliente(tblClientes, cv.traerClientes(true));
            txtApellidoBusqueda.setText("");
            txtDniBusqueda.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    private void txtDniBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniBusquedaKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9' || txtDniBusqueda.getText().length() > 7) evt.consume();
    }//GEN-LAST:event_txtDniBusquedaKeyTyped

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        if(tblClientes.getSelectedRow() != -1){          
            try {
                int codigo = Integer.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString());
                this.cmbVehiculo.setModel(util.cargarCombo(this.cv.traerVehiculosConCliente(cv.traerCliente(codigo))));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            java.util.Date fecha = null;
            java.util.Date hora = null;
            String cantidad = txtCantidad.getText();
            int cant = Integer.valueOf(cantidad);
            boolean recambio = chkParaRecambio.isSelected();
            boolean autorizado = chkAutorizado.isSelected();
            String fechaS = txtFecha.getText();
            String horaS = txtHora.getText();
            String descripcion = tarDescripcion.getText();
            
            fecha = util.ParseFecha(fechaS, "Error: La fecha ingresa no es válida. Formato: 'dd-MM-yyyy'");
            hora = util.convertirHora(horaS, "Error: Hora incorrecta. Formato; 'hh:mm'");
            
            int codigo = Integer.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString());
            Cliente unCliente = cv.traerCliente(codigo);
            
            
            util.verificarCombos(cmbVehiculo.getSelectedItem().toString(), "Vehículo");
            Vehiculo unVehiculo = (Vehiculo) cmbVehiculo.getSelectedItem();
            util.verificarCombos(cmbJTaller.getSelectedItem().toString(), "Jefe de Taller");
            JefeTaller unJefeT = (JefeTaller) cmbJTaller.getSelectedItem();
            util.verificarCombos(cmbJDeposito.getSelectedItem().toString(), "Jefe de Depósito");
            JefeDeposito unJefeD = (JefeDeposito) cmbJDeposito.getSelectedItem();
            util.verificarCombos(cmbPieza.getSelectedItem().toString(), "Pieza");
            PiezaRecambio unaPieza = (PiezaRecambio) cmbPieza.getSelectedItem();

            if(bandera.equals("nuevo")){
                this.cv.nuevoPedido(fecha, hora, descripcion, cant, autorizado, recambio, true, unJefeD, unJefeT, unCliente, unaPieza, unVehiculo);
                bandera = "";
                estadoInicio();
                
            }else{
                if(bandera.equals("editar")){
                    int codigoPedido = Integer.valueOf(txtCodigo.getText());
                    this.cv.editarPedido(codigoPedido, fecha, hora, descripcion, cant, autorizado, recambio, true, unJefeD, unJefeT, unCliente, unaPieza, unVehiculo);
                    estadoInicio();
                }
            }
           cargarTablaPedidos(tblPedidos, cv.traerPedidos(true));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       estadoInicio();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        bandera = "nuevo";
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        txtCodigo.setEnabled(false);
        txtFecha.setEnabled(true);
        txtCantidad.setEnabled(true);
        txtHora.setEnabled(true);
        tarDescripcion.setEnabled(true);
        chkAutorizado.setEnabled(true);
        chkParaRecambio.setEnabled(true);
        cmbJDeposito.setEnabled(true);
        cmbJTaller.setEnabled(true);
        cmbPieza.setEnabled(true);
        cmbVehiculo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnNuevo.setEnabled(true);
        tblClientes.setEnabled(true);
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        if(!txtBusqueda.getText().isEmpty()){
            String busqueda = txtBusqueda.getText();
//            String patenteV = (tblClientes.getValueAt(tblClientes.getSelectedRow(), 10).toString());
            try {
                cargarTablaPedidos(tblPedidos, cv.traerPedidosDeVehiculo(busqueda));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "El campo de busqueda está vacio.");
        }
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            cargarTablaPedidos(tblPedidos, cv.traerPedidos(true));
            txtBusqueda.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tblPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidosMouseClicked
        if(tblPedidos.getSelectedRow() != -1){
            txtCodigo.setText(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 0).toString());
            txtFecha.setText(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 1).toString());
            txtHora.setText(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 2).toString());
            txtCantidad.setText(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 3).toString());
            if(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 4).toString().equalsIgnoreCase("TRUE")){
                chkParaRecambio.setSelected(true);
            }else{
                chkParaRecambio.setSelected(false);
            }
            if(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 5).toString().equalsIgnoreCase("TRUE")){
                chkAutorizado.setSelected(true);
            }else{
                chkAutorizado.setSelected(false);
            }
            
            cmbJTaller.getModel().setSelectedItem(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 6));
            cmbJDeposito.getModel().setSelectedItem(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 7));
            cmbPieza.getModel().setSelectedItem(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 8));
            
            int codigo = Integer.valueOf(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 0).toString());
            Pedido unPedido = null;
            try {
                unPedido = cv.traerPedido(codigo);
                cargarTablaCliente(tblClientes, this.cv.traerClientesBusqueda(true, unPedido.getUnCliente().getApellido(), unPedido.getUnCliente().getDni()));
//                this.cmbVehiculo.setModel(util.cargarCombo(this.cv.traerVehiculosConCliente(unPedido.getUnCliente())));
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            if(tblClientes.getSelectedRow() != -1){
            cmbVehiculo.getModel().setSelectedItem(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 10));
            }
        }
    }//GEN-LAST:event_tblPedidosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(tblPedidos.getSelectedRow() != -1){
        bandera = "editar";
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        txtCodigo.setEnabled(false);
        txtFecha.setEnabled(true);
        txtCantidad.setEnabled(true);
        txtHora.setEnabled(true);
        tarDescripcion.setEnabled(true);
        chkAutorizado.setEnabled(true);
        chkParaRecambio.setEnabled(true);
        cmbJDeposito.setEnabled(true);
        cmbJTaller.setEnabled(true);
        cmbPieza.setEnabled(true);
        cmbVehiculo.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        tblClientes.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un pedido para editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if(tblPedidos.getSelectedRow() != -1){
                int seleccion = JOptionPane.showConfirmDialog(null, "¿Está seguro desea eliminar el Pedido?", "Input", JOptionPane.YES_NO_OPTION);
                if (seleccion == JOptionPane.YES_OPTION) {
                    int codigo = Integer.valueOf(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 0).toString());
                    cv.eliminarPedido(codigo);
                    cargarTablaPedidos(tblPedidos, cv.traerPedidos(true));
                }
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione un pedido de la lista.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCrearInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearInfoActionPerformed
        if(tblPedidos.getSelectedRow() != -1){
        GestionInforme miGestionInfo;
        try {
            int codigo = Integer.valueOf(tblPedidos.getValueAt(tblPedidos.getSelectedRow(), 0).toString());
//            Pedido unP = this.cv.traerPedido(codigo);
            miGestionInfo = new GestionInforme(cv, codigo);
            miGestionInfo.setVisible(true);
            frmMenu.jdpPanelPrincipal.add(miGestionInfo);
            this.setIcon(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Pedido de la Tabla.");
        }
    }//GEN-LAST:event_btnCrearInfoActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c>'9' || txtCantidad.getText().length() > 3) evt.consume();
    }//GEN-LAST:event_txtCantidadKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarCliente;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnBusquedaCliente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearInfo;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox chkAutorizado;
    private javax.swing.JCheckBox chkParaRecambio;
    private javax.swing.JComboBox cmbJDeposito;
    private javax.swing.JComboBox cmbJTaller;
    private javax.swing.JComboBox cmbPieza;
    private javax.swing.JComboBox cmbVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea tarDescripcion;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtApellidoBusqueda;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDniBusqueda;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JFormattedTextField txtHora;
    // End of variables declaration//GEN-END:variables
}
