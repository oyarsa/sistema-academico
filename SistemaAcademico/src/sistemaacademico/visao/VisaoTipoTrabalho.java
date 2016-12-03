
package sistemaacademico.visao;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemaacademico.Util.Mensagens;
import sistemaacademico.controle.ControleTipoTrabalho;


public class VisaoTipoTrabalho extends javax.swing.JFrame {


    public VisaoTipoTrabalho() {
        initComponents();
        jTextFieldCodigoTT.setEnabled(false);
        jTextPaneDescricaoTT.setEnabled(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelTipoTrabalho = new javax.swing.JPanel();
        jTextFieldCodigoTT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneDescricaoTT = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTipoTrabalho = new javax.swing.JTable();
        btnNovoTipoTrab = new javax.swing.JButton();
        btnEditarTipoTrab = new javax.swing.JButton();
        btnGravarTipoTrab = new javax.swing.JButton();
        btnCancelarTipoTrab = new javax.swing.JButton();
        btnExcluirTipoTrab = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelTitulo.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tipo de Trabalho");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel2.setText("Código");

        jScrollPane1.setViewportView(jTextPaneDescricaoTT);

        jLabel3.setText("Descrição");

        jTableTipoTrabalho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableTipoTrabalho.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTableTipoTrabalho.getColumnModel().getColumn(1).setPreferredWidth(400);
        jTableTipoTrabalho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTipoTrabalhoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableTipoTrabalho);

        btnNovoTipoTrab.setText("Novo");
        btnNovoTipoTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoTipoTrabActionPerformed(evt);
            }
        });

        btnEditarTipoTrab.setText("Editar");
        btnEditarTipoTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTipoTrabActionPerformed(evt);
            }
        });

        btnGravarTipoTrab.setText("Gravar");
        btnGravarTipoTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarTipoTrabActionPerformed(evt);
            }
        });

        btnCancelarTipoTrab.setText("Cancelar");
        btnCancelarTipoTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTipoTrabActionPerformed(evt);
            }
        });

        btnExcluirTipoTrab.setText("Excluir");
        btnExcluirTipoTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTipoTrabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTipoTrabalhoLayout = new javax.swing.GroupLayout(jPanelTipoTrabalho);
        jPanelTipoTrabalho.setLayout(jPanelTipoTrabalhoLayout);
        jPanelTipoTrabalhoLayout.setHorizontalGroup(
            jPanelTipoTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTipoTrabalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTipoTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTipoTrabalhoLayout.createSequentialGroup()
                        .addComponent(btnNovoTipoTrab)
                        .addGap(49, 49, 49)
                        .addComponent(btnEditarTipoTrab)
                        .addGap(49, 49, 49)
                        .addComponent(btnGravarTipoTrab)
                        .addGap(50, 50, 50)
                        .addComponent(btnCancelarTipoTrab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluirTipoTrab))
                    .addGroup(jPanelTipoTrabalhoLayout.createSequentialGroup()
                        .addGroup(jPanelTipoTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelTipoTrabalhoLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldCodigoTT, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelTipoTrabalhoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTipoTrabalhoLayout.setVerticalGroup(
            jPanelTipoTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTipoTrabalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTipoTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigoTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTipoTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTipoTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoTipoTrab)
                    .addComponent(btnEditarTipoTrab)
                    .addComponent(btnGravarTipoTrab)
                    .addComponent(btnCancelarTipoTrab)
                    .addComponent(btnExcluirTipoTrab))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelTipoTrabalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTipoTrabalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoTipoTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoTipoTrabActionPerformed
        jTextPaneDescricaoTT.setEnabled(true);
        jTableTipoTrabalho.clearSelection();
        limpaControlesTipoTrabalho();
        habilitaControlesTipoTrabalho();
    }//GEN-LAST:event_btnNovoTipoTrabActionPerformed

    private void btnGravarTipoTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarTipoTrabActionPerformed
        desabilitaControlesTipoTrabalho();

        HashMap<String, Object> dados = new HashMap<>();

        dados.put("codigo", jTextFieldCodigoTT.getText());
        dados.put("descricao",jTextPaneDescricaoTT.getText());


        String msg = ControleTipoTrabalho.salvar(dados);
        JOptionPane.showMessageDialog(this, msg, "Gravação", JOptionPane.INFORMATION_MESSAGE);

        if (msg.equals(Mensagens.SUCESSO)) {
            int linha = jTableTipoTrabalho.getSelectedRow();
            atualizarTabela(linha, dados);
        } else {
            habilitaControlesTipoTrabalho();
        }
    }//GEN-LAST:event_btnGravarTipoTrabActionPerformed

    private void btnEditarTipoTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTipoTrabActionPerformed
        jTextPaneDescricaoTT.setEnabled(true);
        if (jTableTipoTrabalho.getSelectedRow() != -1)
            habilitaControlesTipoTrabalho();
    }//GEN-LAST:event_btnEditarTipoTrabActionPerformed

    private void btnCancelarTipoTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTipoTrabActionPerformed
        desabilitaControlesTipoTrabalho();
        limpaControlesTipoTrabalho();
    }//GEN-LAST:event_btnCancelarTipoTrabActionPerformed

    private void btnExcluirTipoTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirTipoTrabActionPerformed
        int linha = jTableTipoTrabalho.getSelectedRow();
        if (linha == -1)
            return;

        int resposta = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja apagar essa atividade?",
                "Confirmação de exlcusão", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.NO_OPTION)
            return;

        HashMap<String, Object> tipotrab = new HashMap<>();
        tipotrab.put("codigo", jTextFieldCodigoTT.getText());
        String msg = ControleTipoTrabalho.apagar(tipotrab);
        JOptionPane.showMessageDialog(this, msg, "Exclusão", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnExcluirTipoTrabActionPerformed

    private void jTableTipoTrabalhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTipoTrabalhoMouseClicked
        int linha = jTableTipoTrabalho.getSelectedRow();
        if (linha == -1)
            return;

        HashMap<String, Object> tipotrab = new HashMap<>();
        tipotrab.put("codigo", jTableTipoTrabalho.getValueAt(linha, 0));
        HashMap<String, Object> rv = ControleTipoTrabalho.recuperar(tipotrab);

        jTextFieldCodigoTT.setText(rv.get("codigo").toString());
        jTextPaneDescricaoTT.setText(rv.get("descricao").toString());

    }//GEN-LAST:event_jTableTipoTrabalhoMouseClicked


    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(VisaoTipoTrabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisaoTipoTrabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisaoTipoTrabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisaoTipoTrabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisaoTipoTrabalho().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarTipoTrab;
    private javax.swing.JButton btnEditarTipoTrab;
    private javax.swing.JButton btnExcluirTipoTrab;
    private javax.swing.JButton btnGravarTipoTrab;
    private javax.swing.JButton btnNovoTipoTrab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelTipoTrabalho;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableTipoTrabalho;
    private javax.swing.JTextField jTextFieldCodigoTT;
    private javax.swing.JTextPane jTextPaneDescricaoTT;
    // End of variables declaration//GEN-END:variables

    private void toggleControlesTipoTrabalho(boolean ativo) {
        jTextFieldCodigoTT.setEditable(ativo);
        jTextPaneDescricaoTT.setEditable(ativo);

        btnCancelarTipoTrab.setEnabled(ativo);
        btnGravarTipoTrab.setEnabled(ativo);

        btnEditarTipoTrab.setEnabled(!ativo);
        btnNovoTipoTrab.setEnabled(!ativo);
        btnExcluirTipoTrab.setEnabled(!ativo);
        jTableTipoTrabalho.setEnabled(!ativo);
    }

    private void habilitaControlesTipoTrabalho() {
        toggleControlesTipoTrabalho(true);
    }

    private void desabilitaControlesTipoTrabalho() {
        toggleControlesTipoTrabalho(false);
    }

    private void limpaControlesTipoTrabalho() {
        jTextFieldCodigoTT.setText("");
        jTextPaneDescricaoTT.setText("");
    }

    private void atualizarTabela(int linha, HashMap<String, Object> dados) {
        if (linha == -1) {
            linha = jTableTipoTrabalho.getRowCount();
            ((DefaultTableModel) jTableTipoTrabalho.getModel()).addRow(new Object[]{});
        }

        jTableTipoTrabalho.setValueAt(dados.get("codigo"), linha, 0);
        jTableTipoTrabalho.setValueAt(dados.get("descricao"), linha, 1);
    }

    private void carregarTipoTrabalho() {
        DefaultTableModel m = (DefaultTableModel) jTableTipoTrabalho.getModel();
        m.setRowCount(0);
        ArrayList<HashMap<String, Object>> tipotrab = ControleTipoTrabalho.recuperarTodos();

        for (HashMap<String, Object> tt : tipotrab) {
            m.addRow(new Object[]{tt.get("codigo"), tt.get("descricao")});
        }
    }    
    

    
    
}
