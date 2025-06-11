
package com.gestorempleados.gui;

import com.gestorempleados.dao.EmpleadoDAO;
import com.gestorempleados.model.Empleado;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

/**
 *
 * @author JUAN
 */
public class FrmPrincipal extends javax.swing.JFrame {
    private final EmpleadoDAO empleadoDAO;
    private DefaultTableModel modeloTabla;
    private int idSeleccionado = -1;
    
    public FrmPrincipal() {
      initComponents();
        empleadoDAO = new EmpleadoDAO();

        addPlaceholderStyle(txtNombre, "Nombre del empleado");
        addPlaceholderStyle(txtApellido, "Apellido del empleado");
        addPlaceholderStyle(txtPuesto, "Puesto de trabajo");
        addPlaceholderStyle(txtSalario, "salario");
        addPlaceholderStyle(txtFechaContratacion, "YYYY-MM-DD");
     

        configurarTabla();
        cargarTabla();
        setLocationRelativeTo(null);
        idSeleccionado = -1;
        btnGuardar.setText("Guardar");
        btnNuevo.setText("Nuevo");
        btnEliminar.setText("Eliminar");
        btnLimpiar.setText("Limpiar");
        
        if (tblEmpleados != null) {
            tblEmpleados.clearSelection();
        }
        txtNombre.requestFocus();
    }

    private void configurarTabla() {
        modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Puesto");
        modeloTabla.addColumn("Salario");
        modeloTabla.addColumn("F. Contratación");
        tblEmpleados.setModel(modeloTabla);
    }

    private void cargarTabla() {
        if (modeloTabla == null) {
            configurarTabla();
        }
        modeloTabla.setRowCount(0);

        List<Empleado> empleados = empleadoDAO.obtenerTodosLosEmpleados();
        for (Empleado emp : empleados) {
            Object[] fila = {
                emp.getId(),
                emp.getNombre(),
                emp.getApellido(),
                emp.getPuesto(),
                emp.getSalario(),
                emp.getFechaContratacion()
            };
            modeloTabla.addRow(fila);
        }
    }

    private void limpiarCampos() {
    addPlaceholderStyle(txtNombre, "Nombre del empleado");
    addPlaceholderStyle(txtApellido, "Apellido del empleado");
    addPlaceholderStyle(txtPuesto, "Puesto de trabajo");
    addPlaceholderStyle(txtSalario, "salario");
    addPlaceholderStyle(txtFechaContratacion, "YYYY-MM-DD");
    txtId.setText("");

    idSeleccionado = -1;
    btnGuardar.setText("Guardar");
    if (tblEmpleados != null) {
        tblEmpleados.clearSelection();
    }
    txtNombre.requestFocus();
}

private void addPlaceholderStyle(JTextField textField, String placeholderText) {
    final Color defaultTextColor = textField.getForeground();
    final Color placeholderColor = Color.GRAY;

    textField.setText(placeholderText);
    textField.setForeground(placeholderColor);

    textField.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (textField.getText().equals(placeholderText) && textField.getForeground().equals(placeholderColor)) {
                textField.setText("");
                textField.setForeground(defaultTextColor);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (textField.getText().isEmpty()) {
                textField.setText(placeholderText);
                textField.setForeground(placeholderColor);
            }
        }
    });
}

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtPuesto = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        txtFechaContratacion = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtId.setEditable(false);
        txtId.setText("ID");
        txtId.setToolTipText("ID");
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNombre.setText("txtNombre");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellido.setText("txtApellido");
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        txtPuesto.setText("txtPuesto");

        txtSalario.setText("txtSalario");

        txtFechaContratacion.setText("txtFechaContratacion");

        btnNuevo.setText("btnNuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("btnGuardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("btnEliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("btnLimpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        jLabel1.setText("ID");

        jLabel2.setText("Fecha contratacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(493, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar)
                                .addGap(145, 145, 145)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed

    }//GEN-LAST:event_txtIdActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
      
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
     limpiarCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String puesto = txtPuesto.getText().trim();
        String salarioStr = txtSalario.getText().trim();
        String fechaStr = txtFechaContratacion.getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre y Apellido son obligatorios.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocus();
            return;
        }

        BigDecimal salario = null;
        if (!salarioStr.isEmpty()) {
            try {
                salario = new BigDecimal(salarioStr);
                if (salario.compareTo(BigDecimal.ZERO) < 0) {
                    JOptionPane.showMessageDialog(this, "El salario no puede ser negativo.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                    txtSalario.requestFocus();
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Salario debe ser un número válido (ej: 1500.50).", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                txtSalario.requestFocus();
                return;
            }
        }

        java.sql.Date fechaContratacion = null;
        if (!fechaStr.isEmpty()) {
            if (!fechaStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
                 JOptionPane.showMessageDialog(this, "Formato de fecha debe ser YYYY-MM-DD.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                 txtFechaContratacion.requestFocus();
                 return;
            }
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
                sdf.setLenient(false);
                java.util.Date utilDate = sdf.parse(fechaStr);
                fechaContratacion = new java.sql.Date(utilDate.getTime());
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Fecha inválida. Verifique día, mes y año (ej: 2023-12-31).", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                txtFechaContratacion.requestFocus();
                return;
            }
        }

        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setPuesto(puesto.isEmpty() ? null : puesto);
        empleado.setSalario(salario);
        empleado.setFechaContratacion(fechaContratacion);

        try {
            if (idSeleccionado == -1) {
                empleadoDAO.agregarEmpleado(empleado);
                JOptionPane.showMessageDialog(this, "Empleado agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                empleado.setId(idSeleccionado);
                empleadoDAO.actualizarEmpleado(empleado);
                JOptionPane.showMessageDialog(this, "Empleado actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            cargarTabla();
            limpiarCampos();
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Error al interactuar con la base de datos: " + e.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         if (idSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un empleado de la tabla para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar a este empleado?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                empleadoDAO.eliminarEmpleado(idSeleccionado);
                JOptionPane.showMessageDialog(this, "Empleado eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();
                limpiarCampos();
            } catch (HeadlessException e) {
                 JOptionPane.showMessageDialog(this, "Error al eliminar el empleado: " + e.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int filaSeleccionada = tblEmpleados.getSelectedRow();
        if (filaSeleccionada >= 0) {
            idSeleccionado = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
            txtId.setText(String.valueOf(idSeleccionado));
            txtNombre.setText(modeloTabla.getValueAt(filaSeleccionada, 1).toString());
            txtApellido.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());

            Object puestoObj = modeloTabla.getValueAt(filaSeleccionada, 3);
            txtPuesto.setText(puestoObj == null ? "" : puestoObj.toString());

            Object salarioObj = modeloTabla.getValueAt(filaSeleccionada, 4);
            txtSalario.setText(salarioObj == null ? "" : salarioObj.toString());

            Object fechaObj = modeloTabla.getValueAt(filaSeleccionada, 5);
            if (fechaObj != null) {
                if (fechaObj instanceof java.sql.Date fechaSQL) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    txtFechaContratacion.setText(sdf.format(fechaSQL));
                } else {
                    txtFechaContratacion.setText(fechaObj.toString());
                }
            } else {
                txtFechaContratacion.setText("");
            }
            btnGuardar.setText("Actualizar");
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed

    }//GEN-LAST:event_txtApellidoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) { // O "Windows", "GTK+", etc.
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FrmPrincipal().setVisible(true);
       });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtFechaContratacion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}
