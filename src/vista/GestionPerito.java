/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import Modelo.InformePiezaPedido;
import Modelo.Perito;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class GestionPerito extends javax.swing.JInternalFrame {
    private ControladoraVista cv;
    private String bandera;
    private DefaultTableModel miTabla;
    private UtilVista util;
    private DefaultListModel miLista;
    /**
     * Creates new form GestionPerito
     */
    public GestionPerito(ControladoraVista controladoraVista) throws Exception {
        initComponents();
        cv = controladoraVista;
        util = new UtilVista();
        miLista = new DefaultListModel();
        cargarTabla(tblPeritos, cv.traerPeritos(true));
        estadoInicio();
    }

   public void limpiar() {
        txtDni.setText("");
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtCuil.setText("");
    }

    public void estadoInicio() {
        bandera = "";
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        txtDni.setEnabled(false);
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtCuil.setEnabled(false);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnNuevo.setEnabled(true);
        lstPedidos.setEnabled(false);
        lstPedidosPerito.setEnabled(false);
        btnAgregarInforme.setEnabled(false);
        btnQuitarInforme.setEnabled(false);
        limpiar();
    }
    
    public void cargarTabla(JTable laTabla, List<Perito> lista) throws Exception {
        miTabla = new DefaultTableModel();
        String cabecera[] = {"Código", "DNI", "Nombre", "Apellido", "Telefono", "Dirección", "CUIL"};
        miTabla.setColumnIdentifiers(cabecera);
        Object fila[] = new Object[miTabla.getColumnCount()];
        int cantidad = lista.size();
        if (cantidad > 0) {
            for (Perito unPerito : lista) {
                fila[0] = unPerito.getCodigo();
                fila[1] = unPerito.getDni();
                fila[2] = unPerito.getNombre();
                fila[3] = unPerito.getApellido();
                fila[4] = unPerito.getTelefono();
                fila[5] = unPerito.getDireccion();
                fila[6] = unPerito.getCuil();
                miTabla.addRow(fila);
            }
        }
        laTabla.setModel(miTabla);
    }

    
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
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCuil = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstPedidos = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstPedidosPerito = new javax.swing.JList();
        btnAgregarInforme = new javax.swing.JButton();
        btnQuitarInforme = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeritos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtBusquedaDni = new javax.swing.JTextField();
        txtBusquedaApellido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnBusqueda = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setTitle("Gestión de Peritos");
        setName("frmPeritos"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Politica", 1, 24)); // NOI18N
        jLabel1.setText("GESTIÓN DE PERITOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel2.setText("Código:");

        jLabel3.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel3.setText("D.N.I:");

        jLabel4.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel5.setText("Apellido:");

        jLabel6.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel6.setText("Teléfono:");

        jLabel7.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel7.setText("Dirección:");

        jLabel8.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel8.setText("CUIL:");

        txtCodigo.setEditable(false);
        txtCodigo.setToolTipText("");
        txtCodigo.setEnabled(false);

        txtDni.setToolTipText("");
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        txtNombre.setToolTipText("");

        txtApellido.setToolTipText("");

        txtTelefono.setToolTipText("");

        txtDireccion.setToolTipText("");

        txtCuil.setToolTipText("");
        txtCuil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuilActionPerformed(evt);
            }
        });
        txtCuil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuilKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel12.setText("Inormes de Piezas Pedidas");

        jScrollPane4.setViewportView(lstPedidos);

        jScrollPane5.setViewportView(lstPedidosPerito);

        btnAgregarInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/desagregar.fw.png"))); // NOI18N
        btnAgregarInforme.setEnabled(false);
        btnAgregarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarInformeActionPerformed(evt);
            }
        });

        btnQuitarInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        btnQuitarInforme.setEnabled(false);
        btnQuitarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnQuitarInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAgregarInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)))
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(19, 19, 19)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnQuitarInforme)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarInforme)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btnNuevo.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add-1-icon.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblPeritos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPeritos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeritosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeritos);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel9.setText("DNI:");

        txtBusquedaDni.setToolTipText("");
        txtBusquedaDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaDniKeyTyped(evt);
            }
        });

        txtBusquedaApellido.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Politica", 0, 16)); // NOI18N
        jLabel10.setText("Apellido:");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusquedaDni, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusquedaApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusquedaApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBusquedaDni, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnActualizar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnBusqueda)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(595, 595, 595)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addGap(10, 10, 10)
                        .addComponent(btnNuevo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnSalir))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9' || txtDni.getText().length() > 7) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtCuilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuilActionPerformed

    private void txtCuilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuilKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9' || txtCuil.getText().length() > 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCuilKeyTyped

    private void btnAgregarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarInformeActionPerformed
        if (tblPeritos.getSelectedRow() != -1) {
            if (lstPedidos.getSelectedValue() != null) {
                try {
                    int codigo = Integer.valueOf(tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 0).toString());
                    Perito unPerito = cv.traerPerito(codigo);
                    InformePiezaPedido unInforme = (InformePiezaPedido) lstPedidos.getSelectedValue();
                    cv.agregarInforme(unInforme, codigo);

                    List<InformePiezaPedido> informesSinV = cv.traerInformeSinVinculo(unPerito);
                    List<InformePiezaPedido> misInformes = cv.traerInformesConVinculo(unPerito);
                    DefaultListModel dInformes = util.cargarLista(misInformes);
                    DefaultListModel dInformesSinV = util.cargarLista(informesSinV);
                    lstPedidosPerito.setModel(dInformes);
                    lstPedidos.setModel(dInformesSinV);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: Seleccione un elemento de la lista de Informe de Pedidos para agregar.");
            }
        }
    }//GEN-LAST:event_btnAgregarInformeActionPerformed

    private void btnQuitarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarInformeActionPerformed
//        if (tblPeritos.getSelectedRow() != -1) {
//            if (lstPedidosPerito.getSelectedValue() != null) {
//                try {
//                    int codigo = Integer.valueOf(tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 0).toString());
//                    Mecanico unMecanico = cv.traerMecanico(codigo);
//                    int miPedido = lstPedidosPerito.getSelectedIndex();
//                    cv.quitarPedido(miPedido, codigo);
//
//                    List<Pedido> pedidosSinV = cv.traerPedidosSinVinculo(unMecanico);
//                    List<Pedido> misPedidos = cv.traerPedidosConVinculo(unMecanico);
//                    DefaultListModel dPedidos = util.cargarLista(misPedidos);
//                    DefaultListModel dPedidosSinV = util.cargarLista(pedidosSinV);
//                    lstPedidosPerito.setModel(dPedidos);
//                    lstEspecialidades.setModel(dPedidosSinV);
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, ex.getMessage());
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Error: Seleccione un elemento de la lista de Pedidos para quitar.");
//            }
//        }
    }//GEN-LAST:event_btnQuitarInformeActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            int dniInt = 0;
            long cuilInt = 0;
            String dni = txtDni.getText();
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String telefono = txtTelefono.getText();
            String direccion = txtDireccion.getText();
            String cuil = txtCuil.getText();

            util.verificarNombre(nombre);
            util.verificarApellido(apellido);
            util.verificarDni(dni);
            util.verificarCuil(cuil);
            dniInt = Integer.valueOf(dni);
            cuilInt = new Long(Long.parseLong(cuil));

            if (bandera.equals("nuevo")) {
                this.cv.nuevoPerito(dniInt, nombre, apellido, telefono, direccion, cuilInt, true);
                bandera = "";
                estadoInicio();
            } else {
                if (bandera.equals("editar")) {
                    int codigo = Integer.valueOf(txtCodigo.getText());
                    this.cv.editarPerito(codigo, dniInt, nombre, apellido, telefono, direccion, cuilInt, true);
                    estadoInicio();
                }
            }
            cargarTabla(tblPeritos, cv.traerPeritos(true)); //ACTUALIZAMOS LA TABLA
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
        txtDni.setEnabled(true);
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtCuil.setEnabled(true);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tblPeritosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeritosMouseClicked
        try {
            if (tblPeritos.getSelectedRow() != -1) {
                int codigo = Integer.valueOf(tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 0).toString());
                txtCodigo.setText(tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 0).toString());
                txtDni.setText(tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 1).toString());
                txtNombre.setText(tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 2).toString());
                txtApellido.setText(tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 3).toString());
                txtTelefono.setText(tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 4).toString());
                txtDireccion.setText(tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 5).toString());
                txtCuil.setText(tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 6).toString());
                Perito unPerito = null;

                unPerito = cv.traerPerito(codigo);

                lstPedidosPerito.setModel(util.cargarLista(cv.traerInformesConVinculo(unPerito)));
                lstPedidos.setModel(util.cargarLista(cv.traerInformeSinVinculo(unPerito)));
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }//GEN-LAST:event_tblPeritosMouseClicked

    private void txtBusquedaDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaDniKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9' || txtBusquedaDni.getText().length() > 7) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBusquedaDniKeyTyped

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        if ((!txtBusquedaDni.getText().isEmpty()) || (!txtBusquedaApellido.getText().isEmpty())) {
            String dniBusqueda = txtBusquedaDni.getText();
            String apellidoBusqueda = txtBusquedaApellido.getText();
            int dniBusquedaInt = 0;
            if (dniBusqueda.length() > 0) {
                dniBusquedaInt = Integer.valueOf(dniBusqueda);
            }
            try {
                cargarTabla(tblPeritos, cv.traerPeritosBusqueda(true, apellidoBusqueda, dniBusquedaInt));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos de busqueda están vacios.");
        }
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            cargarTabla(tblPeritos, cv.traerPeritos(true));
            txtBusquedaApellido.setText("");
            txtBusquedaDni.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblPeritos.getSelectedRow() != -1) {
            bandera = "editar";
            txtDni.setEnabled(true);
            txtNombre.setEnabled(true);
            txtApellido.setEnabled(true);
            txtDireccion.setEnabled(true);
            txtTelefono.setEnabled(true);
            txtCuil.setEnabled(true);
            btnGuardar.setEnabled(true);
            btnCancelar.setEnabled(true);
            btnEditar.setEnabled(false);
            btnNuevo.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnAgregarInforme.setEnabled(true);
            btnQuitarInforme.setEnabled(true);
            lstPedidos.setEnabled(true);
            lstPedidosPerito.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Perito para editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (tblPeritos.getSelectedRow() != -1) {
                int seleccion = JOptionPane.showConfirmDialog(null, "¿Está seguro desea eliminar el Perito?", "Input", JOptionPane.YES_NO_OPTION);
                if (seleccion == JOptionPane.YES_OPTION) {
                    int codigo = Integer.valueOf(tblPeritos.getValueAt(tblPeritos.getSelectedRow(), 0).toString());
                    cv.elminarPerito(codigo);
                    cargarTabla(tblPeritos, cv.traerPeritos(true));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un Perito de la lista.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarInforme;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitarInforme;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList lstPedidos;
    private javax.swing.JList lstPedidosPerito;
    private javax.swing.JTable tblPeritos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBusquedaApellido;
    private javax.swing.JTextField txtBusquedaDni;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCuil;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
