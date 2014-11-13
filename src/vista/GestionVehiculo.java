/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Modelo.Modelo;
import Modelo.Vehiculo;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class GestionVehiculo extends javax.swing.JInternalFrame {

    private ControladoraVista cv;
    private String bandera;
    private UtilVista util;
    private DefaultTableModel miTabla;

    /**
     * Creates new form GestionVehiculo
     */
    public GestionVehiculo(ControladoraVista controladoraVista) throws Exception {
        initComponents();
        cv = controladoraVista;
        util = new UtilVista();
        cargarTabla(tblVehiculos, cv.traerVehiculos(true));
        util.cargarCombo(cv.traerModelo(true));
        estadoInicio();
    }

    public void limpiar() {
        txtCodigo.setText("");
        txtAnio.setText("");
        txtGarantia.setText("");
        txtDominio.setText("");
        txtKms.setText("");
        txtNroChasis.setText("");
        txtNroMotor.setText("");
        txtFecha.setText("");
        cmbModelo.setToolTipText("SELECCIONAR");
    }

    public void estadoInicio() {
        bandera = "";
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        txtCodigo.setEnabled(false);
        txtAnio.setEnabled(false);
        txtGarantia.setEnabled(false);
        txtDominio.setEnabled(false);
        txtKms.setEnabled(false);
        txtNroChasis.setEnabled(false);
        txtNroMotor.setEnabled(false);
        txtFecha.setEnabled(false);
        cmbModelo.setEnabled(false);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnNuevo.setEnabled(true);
        limpiar();
    }

    public void cargarTabla(JTable laTabla, List<Vehiculo> lista) throws Exception {
        miTabla = new DefaultTableModel();
        String cabecera[] = {"Código", "Dominio", "N° Chasis", "N° Motor", "Año", "Kilometraje", "Fecha", "Garantía", "Modelo"};
        miTabla.setColumnIdentifiers(cabecera);
        Object fila[] = new Object[miTabla.getColumnCount()];
        int cantidad = lista.size();
        if (cantidad > 0) {
            for (Vehiculo vehiculo : lista) {
                fila[0] = vehiculo.getCodigo();
                fila[1] = vehiculo.getDominio();
                fila[2] = vehiculo.getNroChasis();
                fila[3] = vehiculo.getNroMotor();
                fila[4] = vehiculo.getAnio();
                fila[5] = vehiculo.getKmRecorrido();
                fila[6] = vehiculo.getFechaCompra();
                fila[7] = vehiculo.getUnaGarantia();
                fila[8] = vehiculo.getUnModelo();
                miTabla.addRow(fila);
            }
        }
        laTabla.setModel(miTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDominio = new javax.swing.JTextField();
        txtNroChasis = new javax.swing.JTextField();
        txtNroMotor = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        txtKms = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtGarantia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        cmbModelo = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAccesorios = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEstados = new javax.swing.JList();
        btnAccesorio = new javax.swing.JButton();
        btnEstados = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtBusqueda = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();

        setTitle("Gestión de Vehículos");
        setName("frmVehiculos"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Politica", 1, 24)); // NOI18N
        jLabel1.setText("GESTIÓN DE VEHÍCULOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel2.setText("Código:");

        jLabel3.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel3.setText("Dominio:");

        jLabel4.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel4.setText("N° de Chasis:");

        jLabel5.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel5.setText("N° de Motor:");

        jLabel6.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel6.setText("Año:");

        jLabel7.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel7.setText("Km Recorridos:");

        jLabel8.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel8.setText("Fecha de Compra:");

        txtCodigo.setToolTipText("");

        txtDominio.setToolTipText("");

        txtNroChasis.setToolTipText("");

        txtNroMotor.setToolTipText("");

        txtAnio.setToolTipText("");

        txtKms.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel9.setText("Garantía:");

        txtGarantia.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel10.setText("Modelo:");

        cmbModelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel11.setText("Accesorios:");

        jLabel12.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel12.setText("Estados:");

        jScrollPane1.setViewportView(lstAccesorios);

        jScrollPane2.setViewportView(lstEstados);

        btnAccesorio.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnAccesorio.setText("Agregar Accesorios");

        btnEstados.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnEstados.setText("Agregar Estados");
        btnEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtKms, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAnio, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNroMotor, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNroChasis, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDominio, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha)
                    .addComponent(txtGarantia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbModelo, 0, 150, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEstados))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAccesorio))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtDominio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtNroChasis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtNroMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAnio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtKms, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(btnAccesorio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(btnEstados))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel12)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtGarantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cmbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))))
        );

        btnGuardar.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
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

        btnNuevo.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add-1-icon.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Politica", 1, 16))); // NOI18N

        btnBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel13.setText("Dominio:");

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/refresh.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnActualizar)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBusqueda, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Dominio", "N° de Chasis", "N° de Motor", "Año", "Km Recorridos", "Fecha", "Garantía", "Modelo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Long.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVehiculosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblVehiculos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar)
                            .addComponent(btnNuevo)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        estadoInicio();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblVehiculos.getSelectedRow() != -1) {
            bandera = "editar";
            //Habilitar cajas
            txtAnio.setEnabled(true);
            txtGarantia.setEnabled(true);
            txtDominio.setEnabled(true);
            txtKms.setEnabled(true);
            txtNroChasis.setEnabled(true);
            txtNroMotor.setEnabled(true);
            txtFecha.setEnabled(true);
            cmbModelo.setEnabled(true);
            ///////////////////////////
            btnGuardar.setEnabled(true);
            btnCancelar.setEnabled(true);
            btnEditar.setEnabled(false);
            btnNuevo.setEnabled(false);
            btnEliminar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Vehículo para editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadosActionPerformed

    }//GEN-LAST:event_btnEstadosActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            cargarTabla(tblVehiculos, cv.traerVehiculos(true));
            txtBusqueda.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        bandera = "nuevo";
        txtAnio.setEnabled(true);
        txtGarantia.setEnabled(true);
        txtDominio.setEnabled(true);
        txtKms.setEnabled(true);
        txtNroChasis.setEnabled(true);
        txtNroMotor.setEnabled(true);
        txtFecha.setEnabled(true);
        cmbModelo.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            String nroChasis = txtNroChasis.getText();
            String nroMotor = txtNroMotor.getText();
            int anio = Integer.valueOf(txtAnio.getText());
            long km = new Long(txtKms.getText());
            Date fecha = Date.valueOf(txtFecha.getText());
            String garantia = txtGarantia.getText();
            //verificar combo modelo
            Modelo unModelo = (Modelo)cmbModelo.getSelectedItem();
            util.verificarCombos(cmbModelo.getSelectedItem().toString(), "Modelo");
            //controlar los 6 digitos de dominio
            String dominio = txtDominio.getText();
            
            if(bandera.equals("nuevo")){
                this.cv.nuevoVehiculo(dominio, nroChasis, nroMotor, anio, km, fecha, true, unModelo);
                bandera = "";
                estadoInicio();
            }else{
                if(bandera.equals("editar")){
                    int codigo = Integer.valueOf(txtCodigo.getText());
                    this.cv.editarVehiculo(dominio, nroChasis, nroMotor, anio, km, fecha, true, unModelo);
                    estadoInicio();
                }
            }
            cargarTabla(tblVehiculos, cv.traerVehiculos(true)); //ACTUALIZAMOS LA TABLA
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
    }//GEN-LAST:event_btnGuardarActionPerformed
}
    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        if(!txtBusqueda.getText().isEmpty()){
            String busqueda = txtBusqueda.getText();
            try {
                cargarTabla(tblVehiculos, cv.traerVehiculoDominio(true, busqueda));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "El campo de busqueda está vacio.");
        }
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if(tblVehiculos.getSelectedRow() != -1){
                int seleccion = JOptionPane.showConfirmDialog(null, "¿Está seguro desea eliminar el vehículo?", "Input", JOptionPane.YES_NO_OPTION);
                if (seleccion == JOptionPane.YES_OPTION) {
                    int codigo = Integer.valueOf(tblVehiculos.getValueAt(tblVehiculos.getSelectedRow(), 0).toString());
                    cv.elminarVehiculo(codigo);
                    cargarTabla(tblVehiculos, cv.traerVehiculos(true));
                }
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione un Vehículo de la lista.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVehiculosMouseClicked
        if(tblVehiculos.getSelectedRow() != -1){
            txtCodigo.setText(tblVehiculos.getValueAt(tblVehiculos.getSelectedRow(), 0).toString());
            txtDominio.setText(tblVehiculos.getValueAt(tblVehiculos.getSelectedRow(), 1).toString());
            txtNroChasis.setText(tblVehiculos.getValueAt(tblVehiculos.getSelectedRow(), 2).toString());
            txtNroMotor.setText(tblVehiculos.getValueAt(tblVehiculos.getSelectedRow(), 3).toString());
            txtAnio.setText(tblVehiculos.getValueAt(tblVehiculos.getSelectedRow(), 4).toString());
            txtKms.setText(tblVehiculos.getValueAt(tblVehiculos.getSelectedRow(), 5).toString());
            txtFecha.setText(tblVehiculos.getValueAt(tblVehiculos.getSelectedRow(), 6).toString());
            txtGarantia.setText(tblVehiculos.getValueAt(tblVehiculos.getSelectedRow(), 7).toString());
            cmbModelo.setSelectedItem(tblVehiculos.getValueAt(tblVehiculos.getSelectedRow(), 8).toString());
        }
    }//GEN-LAST:event_tblVehiculosMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccesorio;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEstados;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbModelo;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList lstAccesorios;
    private javax.swing.JList lstEstados;
    private javax.swing.JTable tblVehiculos;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDominio;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtGarantia;
    private javax.swing.JTextField txtKms;
    private javax.swing.JTextField txtNroChasis;
    private javax.swing.JTextField txtNroMotor;
    // End of variables declaration//GEN-END:variables
}
