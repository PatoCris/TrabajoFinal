/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cristian
 */
public class GestionTaller extends javax.swing.JInternalFrame {
    private ControladoraVista cv;
    private String bandera;
    private UtilVista util;
    private DefaultTableModel miTabla;
    /**
     * Creates new form GestionTaller
     */
    public GestionTaller(ControladoraVista controladoraVista) {
        initComponents();
        cv = controladoraVista;
        util = new UtilVista();
//        cmbJefeDeposito.setModel(util.cargarCombo(cv.traer(true)));
//        cargarTabla(tblClientes, cv.traerClientes(true));
//        estadoInicio();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtHoraSalida = new javax.swing.JFormattedTextField();
        txtHoraEntrada1 = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCorreo1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTelefono1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cmbJefeDeposito = new javax.swing.JComboBox();
        btnGuardar1 = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btnGestionEjemplares = new javax.swing.JButton();
        btnGestionDevolucion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtApellidoBusqueda = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel2.setText("Código:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 23, -1, -1));

        jLabel4.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel5.setText("Correo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel6.setText("Teléfono:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel7.setText("Dirección:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        txtCodigo.setEditable(false);
        txtCodigo.setToolTipText("");
        txtCodigo.setEnabled(false);
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 23, 90, -1));

        txtNombre.setToolTipText("");
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 141, -1));

        txtCorreo.setToolTipText("");
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 141, -1));

        txtTelefono.setToolTipText("");
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 140, -1));

        txtDireccion.setToolTipText("");
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 250, -1));

        jLabel11.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel11.setText("Hora Salida:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        btnGuardar.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 200, -1, -1));

        btnNuevo.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add-1-icon.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 200, -1, -1));

        jLabel13.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel13.setText("Hora Entrada:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        try {
            txtHoraSalida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtHoraSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 110, -1));

        try {
            txtHoraEntrada1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtHoraEntrada1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 110, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Deposito"));

        jLabel9.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel9.setText("Nombre:");

        txtNombre1.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel10.setText("Correo:");

        txtCorreo1.setToolTipText("");

        jLabel12.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel12.setText("Teléfono:");

        txtTelefono1.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel14.setText("Jefe Deposito:");

        btnGuardar1.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/save.png"))); // NOI18N
        btnGuardar1.setText("Guardar");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        btnEditar1.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil_edit.png"))); // NOI18N
        btnEditar1.setText("Editar");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        btnEliminar1.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Trash.png"))); // NOI18N
        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        btnGestionEjemplares.setText("Gestionar \nEjemplares"); // NOI18N

        btnGestionDevolucion.setText("Gestionar Devoluciones"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(4, 4, 4)
                        .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbJefeDeposito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(10, 10, 10)
                                .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(5, 5, 5)
                                .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGestionDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGestionEjemplares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addComponent(cmbJefeDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGestionEjemplares, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGestionDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar1)
                    .addComponent(btnEditar1)
                    .addComponent(btnEliminar1))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 460, 180));

        jLabel1.setFont(new java.awt.Font("Politica", 1, 24)); // NOI18N
        jLabel1.setText("GESTIÓN DE CLIENTES");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Politica", 1, 16))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btnEliminar.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Trash.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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

        btnSalir.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/close_16.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel8.setText("Nombre:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtApellidoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar)
                        .addComponent(btnEditar)
                        .addComponent(btnSalir))
                    .addComponent(btnActualizar)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addComponent(btnBusqueda)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "DNI", "Nombre", "Apellido", "Teléfono", "Dirección", "CUIL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
//        try {
//            int dniInt;
//            long cuilLong;
//            String dni = txtDni.getText();
//            String nombre = txtNombre.getText();
//            String apellido = txtCorreo.getText();
//            String telefono = txtTelefono.getText();
//            String cuil = txtCuil.getText();
//            String direccion = txtDireccion.getText();
//            String usuario = txtUsuario.getText();
//            String clave = util.password(txtClave.getPassword());
//
//            util.verificarNombre(nombre);
//            util.verificarApellido(apellido);
//            util.verificarDni(dni);
//            util.verificarCuil(cuil);
//            util.verificarCombos(cmbLocalidad.getSelectedItem().toString(), "Localidad");
//
//            Localidad localidad = (Localidad)cmbLocalidad.getSelectedItem();
//            dniInt = Integer.valueOf(dni);
//            cuilLong =  new Long(Long.parseLong(cuil));
//
//            if(bandera.equals("nuevo")){
//                this.cv.nuevoCliente(dniInt, nombre, apellido, direccion, telefono, usuario, clave, cuilLong, true, localidad);
//                bandera = "";
//                estadoInicio();
//            }else{
//                if(bandera.equals("editar")){
//                    int codigo = Integer.valueOf(txtCodigo.getText());
//                    this.cv.editarCliente(codigo, dniInt, nombre, apellido, direccion, telefono, usuario, clave, cuilLong, true, localidad);
//                    estadoInicio();
//                }
//            }
//            cargarTabla(tblClientes, cv.traerClientes(true)); //ACTUALIZAMOS LA TABLA
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
//        estadoInicio();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
//        bandera = "nuevo";
//        btnCancelar.setEnabled(true);
//        btnGuardar.setEnabled(true);
//        txtDni.setEnabled(true);
//        txtNombre.setEnabled(true);
//        txtCorreo.setEnabled(true);
//        txtTelefono.setEnabled(true);
//        txtDireccion.setEnabled(true);
//        txtCuil.setEnabled(true);
//        txtUsuario.setEnabled(true);
//        txtClave.setEnabled(true);
//        btnEditar.setEnabled(false);
//        btnEliminar.setEnabled(false);
//        btnNuevo.setEnabled(false);
//        cmbLocalidad.setEnabled(true);
//        try {
//            cmbLocalidad.setModel(util.cargarCombo(cv.traerLocalidades(true)));
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
//        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
//        if((!txtDniBusqueda.getText().isEmpty()) || (!txtApellidoBusqueda.getText().isEmpty())){
//            String dniBusqueda = txtDniBusqueda.getText();
//            String apellidoBusqueda = txtApellidoBusqueda.getText();
//            int dniBusquedaInt = 0;
//            if(dniBusqueda.length() > 0){
//                dniBusquedaInt = Integer.valueOf(dniBusqueda);
//            }
//            try {
//                cargarTabla(tblClientes, cv.traerClientesBusqueda(true, apellidoBusqueda, dniBusquedaInt));
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, ex.getMessage());
//            }
//        }else{
//            JOptionPane.showMessageDialog(null, "Los campos de busqueda están vacios.");
//        }
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
//        try {
//            cargarTabla(tblClientes, cv.traerClientes(true));
//            txtApellidoBusqueda.setText("");
//            txtDniBusqueda.setText("");
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
//        try {
//            if(tblClientes.getSelectedRow() != -1){
//                int seleccion = JOptionPane.showConfirmDialog(null, "¿Está seguro desea eliminar el Cliente?", "Input", JOptionPane.YES_NO_OPTION);
//                if (seleccion == JOptionPane.YES_OPTION) {
//                    int codigo = Integer.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString());
//                    cv.eliminarCliente(codigo);
//                    cargarTabla(tblClientes, cv.traerClientes(true));
//                }
//            }else{
//                JOptionPane.showMessageDialog(null, "Seleccione un Cliente de la lista.");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
//        if(tblClientes.getSelectedRow() != -1){
//            bandera = "editar";
//            txtDni.setEnabled(true);
//            txtNombre.setEnabled(true);
//            txtCorreo.setEnabled(true);
//            txtTelefono.setEnabled(true);
//            txtDireccion.setEnabled(true);
//            cmbLocalidad.setEnabled(true);
//            txtCuil.setEnabled(true);
//            txtUsuario.setEnabled(true);
//            txtClave.setEnabled(true);
//            btnGuardar.setEnabled(true);
//            btnCancelar.setEnabled(true);
//            btnEditar.setEnabled(false);
//            btnNuevo.setEnabled(false);
//            btnEliminar.setEnabled(false);
//        }else{
//            JOptionPane.showMessageDialog(null, "Seleccione un Cliente para editar.");
//        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
//        if(tblClientes.getSelectedRow() != -1){
//            txtCodigo.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString());
//            txtDni.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 1).toString());
//            txtNombre.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 2).toString());
//            txtCorreo.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 3).toString());
//            txtTelefono.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 4).toString());
//            txtDireccion.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 5).toString());
//            txtCuil.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 6).toString());
//            txtUsuario.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 7).toString());
//            txtClave.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 8).toString());
//            cmbLocalidad.getModel().setSelectedItem((Localidad)tblClientes.getValueAt(tblClientes.getSelectedRow(), 9));
//        }
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnGestionDevolucion;
    private javax.swing.JButton btnGestionEjemplares;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbJefeDeposito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtApellidoBusqueda;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCorreo1;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JFormattedTextField txtHoraEntrada1;
    private javax.swing.JFormattedTextField txtHoraSalida;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefono1;
    // End of variables declaration//GEN-END:variables
}
