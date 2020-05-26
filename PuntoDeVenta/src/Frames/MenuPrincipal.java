/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Datos.ReporteDAO;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class MenuPrincipal extends javax.swing.JFrame {

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Images/logo.png"));

        return retValue;
    }

    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm;
    String db_path = "src/Mingo.db";

    ReporteDAO rp = new ReporteDAO();

    String DetallesTable = "", UltimaFactura = "";
    String ValorUnd = "";
    Double totalTabla1 = 0.00, totaTabla = 0.00;
    LocalDate myObj = LocalDate.now();
    String Fecha = myObj.toString();

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() throws SQLException {
        initComponents();
        importar();
        importar1();
    }

    public void importar() throws SQLException {
        System.err.println(Fecha + "  inicio");
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
            PreparedStatement ps = conn.prepareStatement("select ID,Nombre,Talla,Marca,Cantidad,Precio from Inventario");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) this.jTable1.getModel();
            dtm.setRowCount(0);
            for (int i = 0; i < data.size(); i++) {//Recorro las filas

                dtm.addRow(data.get(i));
            }
            JOptionPane.showMessageDialog(null, "Cargado Correctamente");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void importar1() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
            PreparedStatement ps = conn.prepareStatement("select ID,Nombre,Talla,Marca,Cantidad,Precio from Inventario");
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) this.jTable3.getModel();
            dtm.setRowCount(0);
            for (int i = 0; i < data.size(); i++) {//Recorro las filas

                dtm.addRow(data.get(i));
            }
            //JOptionPane.showMessageDialog(null, "Cargado Correctamente");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        jSelecFiltro = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        ButtonAddItemTable = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        txtTotalTabla = new javax.swing.JLabel();
        ButtonFacturar = new javax.swing.JButton();
        ButtonLimpiarTable = new javax.swing.JButton();
        txtIUltimaf = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        VentasRealizada = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Vendido_total = new javax.swing.JLabel();
        rbFechaActual = new javax.swing.JRadioButton();
        rbIngresarFecha = new javax.swing.JRadioButton();
        rbPorProducto = new javax.swing.JRadioButton();
        buttonGenerarReporte = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        rbAll = new javax.swing.JRadioButton();
        buttonGenerarReporte1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        ButtonAgregarItem = new javax.swing.JToggleButton();
        txtNombre = new javax.swing.JTextField();
        txtTalla = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtCantidadI = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        ButtonUpdateItem = new javax.swing.JToggleButton();
        ButtonDeleteItem = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jToggleButton4 = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        btnAdmin = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        rbID = new javax.swing.JRadioButton();
        rbAuto = new javax.swing.JRadioButton();
        jtxtID = new javax.swing.JTextField();
        ButtonAddCantidad = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mingo accessories");
        setIconImage(getIconImage());

        jTabbedPane1.setToolTipText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Talla", "Marca", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable1);

        jLabel1.setText("Buscar");

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
            }
        });

        jSelecFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "ID", "Nombre", "Marca", "Talla", "Cantidad" }));

        jLabel2.setText("ID");

        txtID.setEnabled(false);

        jLabel3.setText("Cantidad");

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel4.setText("Total");

        txtTotal.setText("0.00");
        txtTotal.setOpaque(false);

        ButtonAddItemTable.setText("Aceptar");
        ButtonAddItemTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddItemTableActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Detalles", "Cantidad", "Valor Unidad", "Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(3).setResizable(false);
        }

        txtTotalTabla.setText("0.00");

        ButtonFacturar.setText("Facturar");
        ButtonFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonFacturarActionPerformed(evt);
            }
        });

        ButtonLimpiarTable.setText("Limpiar Tabla");
        ButtonLimpiarTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLimpiarTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 650, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSelecFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(360, 360, 360))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonAddItemTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonLimpiarTable)
                        .addGap(258, 258, 258))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIUltimaf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTotalTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonFacturar)
                .addGap(260, 260, 260))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSelecFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonLimpiarTable)
                    .addComponent(ButtonAddItemTable)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ButtonFacturar)
                        .addComponent(txtTotalTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIUltimaf, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane1.addTab("Facturacion", jScrollPane1);

        jButton2.setText("Calcular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Ventas Realizadas ");

        jLabel12.setText("Total Vendido");

        buttonGroup1.add(rbFechaActual);
        rbFechaActual.setText("Hoy");
        rbFechaActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFechaActualActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbIngresarFecha);
        rbIngresarFecha.setText("Ingresar Fecha");

        buttonGroup1.add(rbPorProducto);
        rbPorProducto.setText("Por Producto");

        buttonGenerarReporte.setText("Generar Reporte");
        buttonGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerarReporteActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo Factura", "Codigo Producto", "Detalle", "Cantidad", "Total", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTable4);

        buttonGroup1.add(rbAll);
        rbAll.setText("Todo");
        rbAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAllActionPerformed(evt);
            }
        });

        buttonGenerarReporte1.setText("Exportar");
        buttonGenerarReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerarReporte1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(435, 435, 435)
                        .addComponent(jButton2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(27, 27, 27)
                                .addComponent(Vendido_total))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(VentasRealizada, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rbFechaActual)
                                .addGap(18, 18, 18)
                                .addComponent(rbIngresarFecha)
                                .addGap(18, 18, 18)
                                .addComponent(rbPorProducto)
                                .addGap(18, 18, 18)
                                .addComponent(rbAll)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonGenerarReporte)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonGenerarReporte1)))))
                .addContainerGap(594, Short.MAX_VALUE))
            .addComponent(jScrollPane7)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jButton2)
                .addGap(85, 85, 85)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(VentasRealizada, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Vendido_total))
                .addGap(74, 74, 74)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbFechaActual)
                    .addComponent(rbIngresarFecha)
                    .addComponent(rbPorProducto)
                    .addComponent(buttonGenerarReporte)
                    .addComponent(rbAll)
                    .addComponent(buttonGenerarReporte1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jScrollPane2.setViewportView(jPanel3);

        jTabbedPane1.addTab("Reportes de Ventas", jScrollPane2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Talla", "Marca", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable3);

        ButtonAgregarItem.setText("Agregar Producto");
        ButtonAgregarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAgregarItemActionPerformed(evt);
            }
        });

        ButtonUpdateItem.setText("Modificar Producto");
        ButtonUpdateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUpdateItemActionPerformed(evt);
            }
        });

        ButtonDeleteItem.setText("Eliminar Producto");
        ButtonDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteItemActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre");

        jLabel6.setText("Talla");

        jLabel7.setText("Marca");

        jLabel8.setText("Cantidad");

        jLabel9.setText("Precio");

        jToggleButton4.setText("Actualizar");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jLabel10.setText("ID");

        btnAdmin.setText("Admin");
        btnAdmin.setEnabled(false);
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        btnLogOut.setText("Salir Admin");
        btnLogOut.setEnabled(false);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbID);
        rbID.setText("ID");
        rbID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbIDActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbAuto);
        rbAuto.setText("Automatico");

        jtxtID.setEnabled(false);

        ButtonAddCantidad.setText("Agregar Cantidades");
        ButtonAddCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddCantidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(txtTalla, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(jtxtID)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbAuto)))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ButtonAgregarItem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidadI, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAdmin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLogOut))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ButtonUpdateItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonDeleteItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButtonAddCantidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                                .addComponent(jToggleButton4)))))
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidadI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnAdmin)
                    .addComponent(btnLogOut)
                    .addComponent(rbAuto)
                    .addComponent(rbID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jtxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonAgregarItem)
                    .addComponent(ButtonUpdateItem)
                    .addComponent(ButtonDeleteItem)
                    .addComponent(jToggleButton4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(ButtonAddCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane3.setViewportView(jPanel2);

        jTabbedPane1.addTab("Inventario Abordo", jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Facturacion");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    TableRowSorter trs;
    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped
        // TODO add your handling code here:
        txtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                if (jSelecFiltro.getSelectedItem().equals("ID")) {
                    trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtFiltro.getText(), 0));
                }
                if (jSelecFiltro.getSelectedItem().equals("Nombre")) {
                    trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtFiltro.getText(), 1));
                }
                if (jSelecFiltro.getSelectedItem().equals("Talla")) {
                    trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtFiltro.getText(), 2));
                }
                if (jSelecFiltro.getSelectedItem().equals("Marca")) {
                    trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtFiltro.getText(), 3));
                }

            }

        });

        trs = new TableRowSorter(dtm);
        jTable1.setRowSorter(trs);

    }//GEN-LAST:event_txtFiltroKeyTyped

    public void resetSearch() {
        // TODO add your handling code here:
        txtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + "", 0));
            }

        });

        trs = new TableRowSorter(dtm);
        jTable1.setRowSorter(trs);

    }

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed

    }//GEN-LAST:event_txtCantidadKeyPressed

    public void SumarCantidad() {
        int sel = jTable1.getSelectedRow();
        int sel1 = jTable2.getSelectedRow();
        String Comp = jTable2.getValueAt(sel1, 0).toString();
        //System.out.println(Comp);
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (jTable1.getValueAt(i, 0).toString().equals(Comp)) {
                System.out.println(jTable1.getValueAt(i, 0).toString() + " dos " + " " + Comp);
                int sumar1 = Integer.parseInt(jTable2.getValueAt(sel1, 2).toString());
                int sumar2 = Integer.parseInt(jTable1.getValueAt(i, 4).toString());
                int total = sumar1 + sumar2;
                System.out.println(total);
                jTable1.setValueAt(total, i, 4);

            } else {
                System.out.println(jTable1.getValueAt(i, 0).toString() + "uno " + " " + Comp);
            }
        }
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int sel = jTable1.getSelectedRow();
        txtID.setText(String.valueOf(jTable1.getValueAt(sel, 0)));
        ValorUnd = String.valueOf(jTable1.getValueAt(sel, 5));
        DetallesTable = (String.valueOf(jTable1.getValueAt(sel, 1)) + "|" + String.valueOf(jTable1.getValueAt(sel, 2) + "|" + String.valueOf(jTable1.getValueAt(sel, 3))));
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        try {
            int sel = jTable1.getSelectedRow();
            Double Cantidad = Double.parseDouble(txtCantidad.getText().toString());
            Double CantidaEx = Double.parseDouble(String.valueOf(jTable1.getValueAt(sel, 4)));
            Double Valor = Double.parseDouble(String.valueOf(jTable1.getValueAt(sel, 5)));
            totalTabla1 = Cantidad * Valor;
            if (Cantidad <= CantidaEx) {
                String Total = String.valueOf(Cantidad * Valor);

                txtTotal.setText(Total);

                //txtTotalTabla.setText(total.toString());
            } else {
                txtTotal.setText("0.00");
                JOptionPane.showMessageDialog(null, "No hay Suficientes Productos");
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_txtCantidadKeyTyped

    private void ButtonAddItemTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddItemTableActionPerformed
        try {

            if (txtCantidad.getText().equals("") || txtID.getText().equals("") || txtTotal.getText().equals("") || txtTotal.getText().equals("0.00") || txtTotal.getText().equals("0.0")) {
                JOptionPane.showMessageDialog(null, "Existen Campos Vacios", "Error Datos ", JOptionPane.ERROR_MESSAGE);
            } else {

                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.addRow(new Object[]{txtID.getText(), DetallesTable, txtCantidad.getText(), ValorUnd, txtTotal.getText()});

                int sel = jTable1.getSelectedRow();
                int Resta = 0;
                int CantidaExistente = Integer.parseInt(String.valueOf(jTable1.getValueAt(sel, 4)));
                int Cantidad1 = Integer.parseInt(txtCantidad.getText().toString());
                Resta = CantidaExistente - Cantidad1;
                Resta = CantidaExistente - Cantidad1;
                System.out.println(Resta);
                jTable1.setValueAt(Resta, sel, 4);
                totalTabla1 = Double.parseDouble(txtTotal.getText());
                totaTabla = Double.parseDouble(txtTotalTabla.getText());
                totalTabla1 = totalTabla1 + totaTabla;
                txtTotal.setText("0.00");
                //SumarCantidad();

                String Total = String.valueOf(totalTabla1);
                txtTotalTabla.setText(Total);
                resetSearch();
            }
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No puede ingresar caracteres que no son numeros", "Error Datos ", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ButtonAddItemTableActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        try {
            SumarCantidad();
            txtID.setText("");
            txtCantidad.setText("");
            txtTotal.setText("");
            int sel = jTable2.getSelectedRow();

            txtID.setText(String.valueOf(jTable2.getValueAt(sel, 0)));
            DetallesTable = (String.valueOf(jTable2.getValueAt(sel, 1)));
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            //------------------------------------------------------------------
            Double total = 0.00;
            Double Total = 0.00;
            Double TTabla1 = 0.00;
            TTabla1 = Double.parseDouble(jTable2.getValueAt(sel, 4).toString());
            System.out.println(TTabla1);
            Total = Double.parseDouble(txtTotalTabla.getText().toString());
            System.out.println(Total);
            total = Total - TTabla1;
            System.out.println(total);
            String valor = String.valueOf(total);
            model.removeRow(sel);
            total = 0.00;
            Total = 0.00;
            TTabla1 = 0.00;
            txtTotalTabla.setText(valor);
            //SumarCantidad();
        } catch (java.lang.NumberFormatException e) {
        }

        //total=total--;
        //txtTotalTabla.setText(total.toString());

    }//GEN-LAST:event_jTable2MouseClicked

    public void AddFactura() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
            PreparedStatement ps = conn.prepareStatement("insert into Factura (Fecha) values ('" + Fecha + "');");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void GetID() {
        try {

            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
            PreparedStatement ps1 = conn.prepareStatement("SELECT ID FROM Factura WHERE ID = (SELECT MAX( ID )  FROM Factura);");
            ResultSet rs = ps1.executeQuery();
            UltimaFactura = rs.getString("ID");

            txtIUltimaf.setText(UltimaFactura);

            ps1.close();
            System.out.println(UltimaFactura);

        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AddFacturaDetalles() {
        try {
            // set all the preparedstatement parameters
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
            for (int i = 0; i < jTable2.getRowCount(); i++) {
                PreparedStatement ps = conn.prepareStatement("insert into FacturaDetalles (CodigoFactura,CodigoProducto,Detalle,Cantidad,Total,Fecha) values (?,?,?,?,?,'" + Fecha + "')");
                ps.setString(1, UltimaFactura);
                ps.setString(2, jTable2.getValueAt(i, 0).toString());
                ps.setString(3, jTable2.getValueAt(i, 1).toString());
                ps.setString(4, jTable2.getValueAt(i, 2).toString());
                ps.setString(5, jTable2.getValueAt(i, 4).toString());
                ps.executeUpdate();
            }
            importar();
            importar1();

            txtNombre.setText("");
            txtTalla.setText("");
            txtMarca.setText("");
            txtCantidadI.setText("");
            txtPrecio.setText("");
            limpiarTabla();
        } catch (SQLException se) {
            // log exception
            JOptionPane.showMessageDialog(null, "Error en el guardado:  " + se);

        }
    }

    private void ButtonFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonFacturarActionPerformed
        try {

            if (txtTotalTabla.getText().equals("0.00") || txtTotalTabla.getText().equals("0.0") || txtTotalTabla.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "El Total de la factura es 0 ", "Error Datos Vacios", JOptionPane.ERROR_MESSAGE);
            } else {
                int facturar = JOptionPane.showConfirmDialog(null, "Desea Facturar los Productos con un valor de " + txtTotalTabla.getText().toString());
                int imprimir = JOptionPane.showConfirmDialog(null, "Desea Imprimir Documentos");

                if (facturar == JOptionPane.YES_OPTION) {
                    //limpiarTabla();
                    actualizarFactura();
                    rp.setTotal("TOTAL| C$" + txtTotalTabla.getText().toString());
                    AddFactura();
                    GetID();
                    rp.setNumero(txtIUltimaf.getText().toString());
                    AddFacturaDetalles();

                    if (imprimir == JOptionPane.YES_OPTION) {
                        try {

                            ImprimirFactura im = new ImprimirFactura(rp);
                            im.setVisible(true);
                            limpiarTabla();
                        } catch (SQLException ex) {
                            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonFacturarActionPerformed

    //String id[]= new String[10];
    public void limpiarTabla() throws SQLException {
        DefaultTableModel tb = (DefaultTableModel) jTable2.getModel();
        txtTotalTabla.setText("0.00");
        int a = jTable2.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
            txtTotalTabla.setText("0.00");
            importar();
        }
    }

    private void ButtonLimpiarTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimpiarTableActionPerformed

        try {
            limpiarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonLimpiarTableActionPerformed

    public void actualizarFactura() throws SQLException {
        try {

            int rows = jTable1.getRowCount();
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
            //PreparedStatement st = conn.prepareStatement("");

            for (int row = 0; row < rows; row++) {
                String query = "Update Inventario set "
                        + " Nombre=?,"
                        + " Talla=?,"
                        + " Marca=?,"
                        + " Cantidad=?,"
                        + " Precio=? where id=" + jTable1.getValueAt(row, 0);
                PreparedStatement st = conn.prepareStatement(query);

                st.setString(1, jTable1.getValueAt(row, 1).toString());
                st.setString(2, jTable1.getValueAt(row, 2).toString());
                st.setString(3, jTable1.getValueAt(row, 3).toString());
                st.setString(4, jTable1.getValueAt(row, 4).toString());
                st.setString(5, jTable1.getValueAt(row, 5).toString());

                st.executeUpdate();
                st.close();
            }

            JOptionPane.showMessageDialog(this, "Actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    //-------------------------------------------------------------------------------
    //-----------------------------InventarioAbordo----------------------------------
    //-------------------------------------------------------------------------------
    String query;

    public void addItem()
            throws SQLException {

        if (rbAuto.isSelected()) {
            jtxtID.setEnabled(false);
            query = "INSERT INTO Inventario ("
                    + " Nombre,"
                    + " Talla,"
                    + " Marca,"
                    + " Cantidad,"
                    + " Precio"
                    + ") VALUES ("
                    + " ?, ?, ?, ?, ?)";

            try {
                // set all the preparedstatement parameters
                Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, txtNombre.getText().toString());
                st.setString(2, txtTalla.getText().toString());
                st.setString(3, txtMarca.getText().toString());
                st.setString(4, txtCantidadI.getText().toString());
                st.setString(5, txtPrecio.getText().toString());

                // execute the preparedstatement insert
                st.executeUpdate();
                st.close();
                JOptionPane.showMessageDialog(null, "Guardado Correctamente");
                importar();
                importar1();

                txtNombre.setText("");
                txtTalla.setText("");
                txtMarca.setText("");
                txtCantidadI.setText("");
                txtPrecio.setText("");

            } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, "Error en el guardado:  " + se);
                throw se;
            }
        } else {
            if (rbID.isSelected()) {
                jtxtID.setEnabled(true);
                query = "INSERT INTO Inventario ("
                        + " ID,"
                        + " Nombre,"
                        + " Talla,"
                        + " Marca,"
                        + " Cantidad,"
                        + " Precio"
                        + ") VALUES ("
                        + "?, ?, ?, ?, ?, ?)";

                try {
                    // set all the preparedstatement parameters
                    Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
                    PreparedStatement st = conn.prepareStatement(query);
                    st.setString(1, jtxtID.getText().toString());
                    st.setString(2, txtNombre.getText().toString());
                    st.setString(3, txtTalla.getText().toString());
                    st.setString(4, txtMarca.getText().toString());
                    st.setString(5, txtCantidadI.getText().toString());
                    st.setString(6, txtPrecio.getText().toString());

                    // execute the preparedstatement insert
                    st.executeUpdate();
                    st.close();
                    JOptionPane.showMessageDialog(null, "Guardado Correctamente");
                    importar();
                    importar1();

                    txtNombre.setText("");
                    txtTalla.setText("");
                    txtMarca.setText("");
                    txtCantidadI.setText("");
                    txtPrecio.setText("");

                } catch (SQLException se) {
                    JOptionPane.showMessageDialog(null, "Error en el guardado:  " + se);
                    throw se;
                }
            }

        }

    }

    public void addItemCant()
            throws SQLException {
        query = "Update Inventario set "
                + " Cantidad='?'"
                + "where id=" + jtxtID.getText().toString();

        try {
            // set all the preparedstatement parameters
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, txtCantidadI.getText().toString());

            // execute the preparedstatement insert
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Guardado Correctamente");
            importar();
            importar1();

            txtNombre.setText("");
            txtTalla.setText("");
            txtMarca.setText("");
            txtCantidadI.setText("");
            txtPrecio.setText("");

        } catch (SQLException se) {
            // log exception
            JOptionPane.showMessageDialog(null, "Error en el guardado:  " + se);
            throw se;
        }
    }

    public void updateItem()
            throws SQLException {
        query = "Update Inventario set "
                + " Nombre=?,"
                + " Talla=?,"
                + " Marca=?,"
                + " Cantidad=?,"
                + " Precio=? where id=" + jtxtID.getText().toString();

        try {
            // set all the preparedstatement parameters
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, txtNombre.getText().toString());
            st.setString(2, txtTalla.getText().toString());
            st.setString(3, txtMarca.getText().toString());
            st.setString(4, txtCantidadI.getText().toString());
            st.setString(5, txtPrecio.getText().toString());

            // execute the preparedstatement insert
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Guardado Correctamente");
            importar();
            importar1();

            txtNombre.setText("");
            txtTalla.setText("");
            txtMarca.setText("");
            txtCantidadI.setText("");
            txtPrecio.setText("");

        } catch (SQLException se) {
            // log exception
            JOptionPane.showMessageDialog(null, "Error en el guardado:  " + se);
            throw se;
        }
    }
    //boolean AccesoAdmin =false;

    public void PanelAdmin() {
        JTextField username = new JTextField();
        JTextField password = new JPasswordField();

        Object[] message = {
            "Username:", username,
            "Password:", password
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (username.getText().toString().equals("Admin") && password.getText().toString().equals("1234")) {
            // ButtonAgregarItem.setEnabled(true);
            ButtonUpdateItem.setEnabled(true);
            ButtonDeleteItem.setEnabled(true);
            btnAdmin.setEnabled(false);
            btnLogOut.setEnabled(true);
        }
    }

    public void deleteItem()
            throws SQLException {
        //String query = "delte from Inventario where ID=";

        try {
            // set all the preparedstatement parameters
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
            PreparedStatement st = conn.prepareStatement("delete from Inventario where ID=" + jtxtID.getText().toString());

            // execute the preparedstatement insert
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
            importar();
            importar1();

            txtNombre.setText("");
            txtTalla.setText("");
            txtMarca.setText("");
            txtCantidadI.setText("");
            txtPrecio.setText("");
            jtxtID.setText("");

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Error en eliminar:  " + se);
        }

    }

    public void exportarExcel(JTable t) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            try {
                File archivoXLS = new File(ruta);
                if (archivoXLS.exists()) {
                    archivoXLS.delete();
                }
                archivoXLS.createNewFile();
                Workbook libro = new HSSFWorkbook();
                FileOutputStream archivo = new FileOutputStream(archivoXLS);
                Sheet hoja = libro.createSheet("Mi hoja de trabajo 1");
                hoja.setDisplayGridlines(false);
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(f);
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (f == 0) {
                            celda.setCellValue(t.getColumnName(c));
                        }
                    }
                }
                int filaInicio = 1;
                for (int f = 0; f < t.getRowCount(); f++) {
                    Row fila = hoja.createRow(filaInicio);
                    filaInicio++;
                    for (int c = 0; c < t.getColumnCount(); c++) {
                        Cell celda = fila.createCell(c);
                        if (t.getValueAt(f, c) instanceof Double) {
                            celda.setCellValue(Double.parseDouble(t.getValueAt(f, c).toString()));
                        } else if (t.getValueAt(f, c) instanceof Float) {
                            celda.setCellValue(Float.parseFloat((String) t.getValueAt(f, c)));
                        } else {
                            celda.setCellValue(String.valueOf(t.getValueAt(f, c)));
                        }
                    }
                }
                libro.write(archivo);
                archivo.close();
                Desktop.getDesktop().open(archivoXLS);
            } catch (IOException | NumberFormatException e) {
                throw e;
            }
        }
    }

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        try {
            importar1();
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void ButtonAgregarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAgregarItemActionPerformed
        try {
            // TODO add your handling code here:
            addItem();
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonAgregarItemActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        int sel = jTable3.getSelectedRow();
        jtxtID.setText(String.valueOf(jTable3.getValueAt(sel, 0)));
        txtNombre.setText(String.valueOf(jTable3.getValueAt(sel, 1)));
        txtTalla.setText(String.valueOf(jTable3.getValueAt(sel, 2)));
        txtMarca.setText(String.valueOf(jTable3.getValueAt(sel, 3)));
        txtCantidadI.setText(String.valueOf(jTable3.getValueAt(sel, 4)));
        txtPrecio.setText(String.valueOf(jTable3.getValueAt(sel, 5)));
    }//GEN-LAST:event_jTable3MouseClicked

    private void ButtonUpdateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUpdateItemActionPerformed
        try {
            updateItem();
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonUpdateItemActionPerformed

    private void ButtonDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteItemActionPerformed
        try {
            // TODO add your handling code here:
            deleteItem();
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonDeleteItemActionPerformed
    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {
        PanelAdmin();
    }

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {
        ButtonAgregarItem.setEnabled(false);
        ButtonUpdateItem.setEnabled(false);
        ButtonDeleteItem.setEnabled(false);
        btnAdmin.setEnabled(true);
        btnLogOut.setEnabled(false);
    }
    //-------------------------------------------------------------------------------
    //-----------------------------Reporte de Ventas---------------------------------
    //-------------------------------------------------------------------------------

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            ObtenerCantidadVentas();
            ObteneTotalVendido();
        } catch (SQLException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buttonGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerarReporteActionPerformed

        if (rbFechaActual.isSelected()) {

            rp.setQuery("where Fecha= '" + Fecha + "'");
            importarReporte();
        }
        if (rbIngresarFecha.isSelected()) {
            String Fecha = JOptionPane.showInputDialog("Ingrese la fecha en el Formato anio-mes-dia");
            //JOptionPane.showMessageDialog(null, "Hello " + Fecha);
            if (Fecha.equals("")) {
                JOptionPane.showMessageDialog(null, "Error la fecha esta vacia");
            } else {
                rp.setQuery("where Fecha= " + "'" + Fecha + "'");
                importarReporte();
            }
        }
        if (rbPorProducto.isSelected()) {
            String Codigo = JOptionPane.showInputDialog("Ingrese el codigo del producto");
            //JOptionPane.showMessageDialog(null, "Hello " + Fecha);
            if (Codigo.equals("")) {
                JOptionPane.showMessageDialog(null, "Error el codigo esta vacio");
            } else {
                rp.setQuery("where CodigoProducto=" + Codigo);
                importarReporte();
            }
        }
        if (rbAll.isSelected()) {

            rp.setQuery("");
            importarReporte();
        }
        System.out.println(rp.getQuery());

    }//GEN-LAST:event_buttonGenerarReporteActionPerformed

    private void rbFechaActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFechaActualActionPerformed
    }//GEN-LAST:event_rbFechaActualActionPerformed
    /*
    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
    }//GEN-LAST:event_btnAdminActionPerformed
    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
    }//GEN-LAST:event_btnLogOutActionPerformed
*/
    private void rbIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbIDActionPerformed
        // TODO add your handling code here:
        jtxtID.setEnabled(true);
    }//GEN-LAST:event_rbIDActionPerformed

    private void rbAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAllActionPerformed

    private void buttonGenerarReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerarReporte1ActionPerformed
        try {
            exportarExcel(jTable4);
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonGenerarReporte1ActionPerformed

    private void ButtonAddCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddCantidadActionPerformed
        String CantidadStr = JOptionPane.showInputDialog("Ingrese cuanto desea agregar del producto " + txtNombre.getText());

        if (CantidadStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Error la cantidad esta vacio");
            
        } else {
            //rp.setQuery("where CodigoProducto=" + Codigo);
            //importarReporte();
            String CantidadExistente = txtCantidadI.getText().toString();
            int CantEx = Integer.valueOf(CantidadExistente);
            int CantStr = Integer.valueOf(CantidadStr);
            int CantTotal = CantEx+CantStr;
            txtCantidadI.setText(""+CantTotal);
            try {
                updateItem();
            } catch (SQLException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_ButtonAddCantidadActionPerformed

    public void ObteneTotalVendido() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
            PreparedStatement ps1 = conn.prepareStatement("select Total from FacturaDetalles where Fecha= '" + Fecha + "'");
            ResultSet rs1;
            ResultSetMetaData rsm1;
            rs1 = ps1.executeQuery();
            rsm1 = rs1.getMetaData();
            int j = 0;
            Double total = 0.0, valor1 = 0.0;
            ResultSetMetaData metadata = rs1.getMetaData();
            int columnCount = metadata.getColumnCount();
            while (rs1.next()) {
                j++;
                System.out.println(rs1.getString(1));
                total = Double.parseDouble(rs1.getString(1));
                valor1 = total + valor1;
                System.out.println(total);
                System.out.println(valor1);
            }
            Vendido_total.setText("" + valor1);
            System.out.println(j);
        } catch (SQLException e) {
        }

    }

    public void ObtenerCantidadVentas() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
            PreparedStatement ps1 = conn.prepareStatement("select * from Factura where Fecha= '" + Fecha + "'");
            ResultSet rs1;
            ResultSetMetaData rsm1;
            rs1 = ps1.executeQuery();
            rsm1 = rs1.getMetaData();
            int j = 0;
            ResultSetMetaData metadata = rs1.getMetaData();
            while (rs1.next()) {
                String row = " ";
                j++;
                VentasRealizada.setText("" + j);
            }
        } catch (SQLException e) {
        }

    }

    public void importarReporte() {

        try {

            limpiarTabla();

            System.err.println(rp.getQuery());
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db_path);
            PreparedStatement ps = conn.prepareStatement("select * from FacturaDetalles " + rp.getQuery());
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) this.jTable4.getModel();
            dtm.setRowCount(0);
            for (int i = 0; i < data.size(); i++) {//Recorro las filas

                dtm.addRow(data.get(i));
            }
            JOptionPane.showMessageDialog(null, "Cargado Correctamente");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuPrincipal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ButtonAddCantidad;
    private javax.swing.JButton ButtonAddItemTable;
    private javax.swing.JToggleButton ButtonAgregarItem;
    private javax.swing.JToggleButton ButtonDeleteItem;
    private javax.swing.JButton ButtonFacturar;
    private javax.swing.JButton ButtonLimpiarTable;
    private javax.swing.JToggleButton ButtonUpdateItem;
    private javax.swing.JLabel Vendido_total;
    private javax.swing.JLabel VentasRealizada;
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton buttonGenerarReporte;
    private javax.swing.JButton buttonGenerarReporte1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JComboBox<String> jSelecFiltro;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JTextField jtxtID;
    private javax.swing.JRadioButton rbAll;
    private javax.swing.JRadioButton rbAuto;
    private javax.swing.JRadioButton rbFechaActual;
    private javax.swing.JRadioButton rbID;
    private javax.swing.JRadioButton rbIngresarFecha;
    private javax.swing.JRadioButton rbPorProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidadI;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtID;
    private javax.swing.JLabel txtIUltimaf;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTalla;
    private javax.swing.JTextField txtTotal;
    public static javax.swing.JLabel txtTotalTabla;
    // End of variables declaration//GEN-END:variables
}
