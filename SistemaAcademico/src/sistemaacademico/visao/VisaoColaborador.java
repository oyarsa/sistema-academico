/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaacademico.visao;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemaacademico.Util.Mensagens;
import sistemaacademico.controle.ControleColaborador;

/**
 *
 * @author Italo Silva
 */
public class VisaoColaborador extends javax.swing.JFrame {

    private void limparComponentesColaborador() {
        checkAcademico.setSelected(false);
        checkAtivo.setSelected(false);
        textCPF.setText("");
        textCategoria.setText("");
        textCodigo.setText("");
        textEmail.setText("");
        textNome.setText("");
        textNomeMae.setText("");
        textNomePai.setText("");
        textRG.setText("");
    }

    private void toggleComponentesColaborador(boolean ativo) {
        // Ativo será verdadeiro quando o formulário aceitar entradas
        btnCancelar.setEnabled(ativo);
        btnGravar.setEnabled(ativo);
        btnEditar.setEnabled(!ativo);
        btnExcluir.setEnabled(!ativo);
        btnNovo.setEnabled(!ativo);

        checkAcademico.setEnabled(ativo);
        checkAtivo.setEnabled(ativo);
        textCPF.setEnabled(ativo);
        textCategoria.setEnabled(ativo);
        textCodigo.setEnabled(ativo);
        textEmail.setEnabled(ativo);
        textNome.setEnabled(ativo);
        textNomeMae.setEnabled(ativo);
        textNomePai.setEnabled(ativo);
        textRG.setEnabled(ativo);
    }

    private void habilitarControlesColaborador() {
        toggleComponentesColaborador(true);
    }

    private void desabilitarControlesColaborador() {
        toggleComponentesColaborador(false);
    }

    private void inicializarColaboradores() {
        desabilitarControlesColaborador();
        carregarTabela();
    }

    /**
     * Creates new form VisaoColaborador
     */
    public VisaoColaborador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        painelAbas = new javax.swing.JTabbedPane();
        painelPrincipal = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        labelCPF = new javax.swing.JLabel();
        textCPF = new javax.swing.JTextField();
        labelRG = new javax.swing.JLabel();
        textRG = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        checkAtivo = new javax.swing.JCheckBox();
        labelNomePai = new javax.swing.JLabel();
        textNomePai = new javax.swing.JTextField();
        labelNomeMae = new javax.swing.JLabel();
        textNomeMae = new javax.swing.JTextField();
        labelCategoria = new javax.swing.JLabel();
        textCategoria = new javax.swing.JTextField();
        checkAcademico = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaColaboradores = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        labelCodigo = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        painelTelefones = new javax.swing.JPanel();
        painelRegistroAcad = new javax.swing.JPanel();
        painelHistorico = new javax.swing.JPanel();
        painelProjetos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProjetos = new javax.swing.JTable();
        painelProjetosGerenciados = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaProjetosGerenciados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelTitulo.setBackground(new java.awt.Color(153, 153, 153));

        labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("Colaboradores");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelAbas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                painelAbasStateChanged(evt);
            }
        });

        labelNome.setText("Nome");

        labelCPF.setText("CPF");

        labelRG.setText("RG");

        labelEmail.setText("E-mail");

        checkAtivo.setText("Ativo");

        labelNomePai.setText("Nome do Pai");

        labelNomeMae.setText("Nome da Mãe");

        labelCategoria.setText("Categoria");

        checkAcademico.setText("Acadêmico");

        tabelaColaboradores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód", "Nome", "E-mail", "Categoria", "Acadêmico", "Ativo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaColaboradores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaColaboradoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaColaboradores);
        if (tabelaColaboradores.getColumnModel().getColumnCount() > 0) {
            tabelaColaboradores.getColumnModel().getColumn(0).setMinWidth(40);
            tabelaColaboradores.getColumnModel().getColumn(0).setMaxWidth(40);
            tabelaColaboradores.getColumnModel().getColumn(3).setMinWidth(120);
            tabelaColaboradores.getColumnModel().getColumn(3).setMaxWidth(120);
            tabelaColaboradores.getColumnModel().getColumn(4).setMinWidth(65);
            tabelaColaboradores.getColumnModel().getColumn(4).setMaxWidth(65);
            tabelaColaboradores.getColumnModel().getColumn(5).setMinWidth(45);
            tabelaColaboradores.getColumnModel().getColumn(5).setMaxWidth(45);
        }

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        labelCodigo.setText("Código");

        textCodigo.setEditable(false);

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(labelEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkAcademico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkAtivo))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(labelCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelCPF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(labelRG)
                        .addGap(18, 18, 18)
                        .addComponent(textRG, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNomePai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelNomeMae)
                        .addGap(18, 18, 18)
                        .addComponent(textNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(btnNovo)
                .addGap(79, 79, 79)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGravar)
                .addGap(82, 82, 82)
                .addComponent(btnCancelar)
                .addGap(69, 69, 69)
                .addComponent(btnExcluir)
                .addGap(89, 89, 89))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCPF)
                    .addComponent(textCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCodigo)
                    .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmail)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkAtivo)
                    .addComponent(labelCategoria)
                    .addComponent(textCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkAcademico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeMae)
                    .addComponent(textNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNomePai)
                    .addComponent(labelRG)
                    .addComponent(textRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnGravar)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        painelAbas.addTab("Principal", painelPrincipal);

        javax.swing.GroupLayout painelTelefonesLayout = new javax.swing.GroupLayout(painelTelefones);
        painelTelefones.setLayout(painelTelefonesLayout);
        painelTelefonesLayout.setHorizontalGroup(
            painelTelefonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );
        painelTelefonesLayout.setVerticalGroup(
            painelTelefonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );

        painelAbas.addTab("Telefones", painelTelefones);

        javax.swing.GroupLayout painelRegistroAcadLayout = new javax.swing.GroupLayout(painelRegistroAcad);
        painelRegistroAcad.setLayout(painelRegistroAcadLayout);
        painelRegistroAcadLayout.setHorizontalGroup(
            painelRegistroAcadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );
        painelRegistroAcadLayout.setVerticalGroup(
            painelRegistroAcadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );

        painelAbas.addTab("Registro Acadêmico", painelRegistroAcad);

        javax.swing.GroupLayout painelHistoricoLayout = new javax.swing.GroupLayout(painelHistorico);
        painelHistorico.setLayout(painelHistoricoLayout);
        painelHistoricoLayout.setHorizontalGroup(
            painelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );
        painelHistoricoLayout.setVerticalGroup(
            painelHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );

        painelAbas.addTab("Histórico", painelHistorico);

        tabelaProjetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaProjetos);
        if (tabelaProjetos.getColumnModel().getColumnCount() > 0) {
            tabelaProjetos.getColumnModel().getColumn(0).setMinWidth(70);
            tabelaProjetos.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        javax.swing.GroupLayout painelProjetosLayout = new javax.swing.GroupLayout(painelProjetos);
        painelProjetos.setLayout(painelProjetosLayout);
        painelProjetosLayout.setHorizontalGroup(
            painelProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProjetosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelProjetosLayout.setVerticalGroup(
            painelProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProjetosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelAbas.addTab("Projetos", painelProjetos);

        tabelaProjetosGerenciados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelaProjetosGerenciados);
        if (tabelaProjetosGerenciados.getColumnModel().getColumnCount() > 0) {
            tabelaProjetosGerenciados.getColumnModel().getColumn(0).setMinWidth(70);
            tabelaProjetosGerenciados.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        javax.swing.GroupLayout painelProjetosGerenciadosLayout = new javax.swing.GroupLayout(painelProjetosGerenciados);
        painelProjetosGerenciados.setLayout(painelProjetosGerenciadosLayout);
        painelProjetosGerenciadosLayout.setHorizontalGroup(
            painelProjetosGerenciadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProjetosGerenciadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelProjetosGerenciadosLayout.setVerticalGroup(
            painelProjetosGerenciadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelProjetosGerenciadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelAbas.addTab("Projetos Gerenciados", painelProjetosGerenciados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelAbas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelAbas))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        inicializarColaboradores();
    }//GEN-LAST:event_formWindowOpened

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparComponentesColaborador();
        desabilitarControlesColaborador();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        limparComponentesColaborador();

        DefaultTableModel m = (DefaultTableModel) tabelaColaboradores.getModel();
        int linha = tabelaColaboradores.getSelectedRow();
        if (linha == -1)
            return;

        int codigo = (Integer) m.getValueAt(linha, 0);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("codigo", codigo);

        String msg = ControleColaborador.remover(dados);
        JOptionPane.showMessageDialog(this, msg, "Exclusão", JOptionPane.INFORMATION_MESSAGE);

        if (msg.equals(Mensagens.SUCESSO))
            m.removeRow(linha);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limparComponentesColaborador();
        textCodigo.setText("");
        tabelaColaboradores.clearSelection();
        habilitarControlesColaborador();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tabelaColaboradores.getSelectedRow() != -1)
            habilitarControlesColaborador();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        desabilitarControlesColaborador();

        HashMap<String, Object> dados = new HashMap<>();

        dados.put("codigo", textCodigo.getText());
        dados.put("cpf", textCPF.getText());
        dados.put("categoria", textCategoria.getText());
        dados.put("email", textEmail.getText());
        dados.put("nome", textNome.getText());
        dados.put("nomeMae", textNomeMae.getText());
        dados.put("nomePai", textNomePai.getText());
        dados.put("rg", textRG.getText());
        dados.put("academico", checkAcademico.isSelected());
        dados.put("ativo", checkAtivo.isSelected());

        String msg = ControleColaborador.salvar(dados);
        JOptionPane.showMessageDialog(this, msg, "Gravação", JOptionPane.INFORMATION_MESSAGE);

        if (msg.equals(Mensagens.SUCESSO)) {
            limparComponentesColaborador();
            int linha = tabelaColaboradores.getSelectedRow();
            atualizarTabela(linha, dados);
        } else {
            habilitarControlesColaborador();
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void tabelaColaboradoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaColaboradoresMouseClicked
        DefaultTableModel m = (DefaultTableModel) tabelaColaboradores.getModel();
        int linha = tabelaColaboradores.getSelectedRow();
        if (linha == -1)
            return;

        int codigo = (Integer) m.getValueAt(linha, 0);
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("codigo", codigo);

        HashMap<String, Object> c = ControleColaborador.carregarColaborador(dados);
        if (c == null) {
            JOptionPane.showMessageDialog(this, "Erro ao recuperar o colaborador selecionado",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }

        textCodigo.setText(c.get("codigo").toString());
        textCPF.setText(c.get("cpf").toString());
        textCategoria.setText(c.get("categoria").toString());
        textEmail.setText(c.get("email").toString());
        textNome.setText(c.get("nome").toString());
        textNomeMae.setText(c.get("nomeMae").toString());
        textNomePai.setText(c.get("nomePai").toString());
        textRG.setText(c.get("rg").toString());

        checkAcademico.setSelected((Boolean) c.get("academico"));
        checkAtivo.setSelected((Boolean) c.get("ativo"));
    }//GEN-LAST:event_tabelaColaboradoresMouseClicked

    private void painelAbasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_painelAbasStateChanged
        String aba = painelAbas.getTitleAt(painelAbas.getSelectedIndex());
        if (aba.equals("Projetos")) {
            carregarProjetos();
        } else if (aba.equals("Projetos Gerenciados")) {
            carregarProjetosGerenciados();
        }
    }//GEN-LAST:event_painelAbasStateChanged

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
            java.util.logging.Logger.getLogger(VisaoColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisaoColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisaoColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisaoColaborador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisaoColaborador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JCheckBox checkAcademico;
    private javax.swing.JCheckBox checkAtivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNomeMae;
    private javax.swing.JLabel labelNomePai;
    private javax.swing.JLabel labelRG;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTabbedPane painelAbas;
    private javax.swing.JPanel painelHistorico;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelProjetos;
    private javax.swing.JPanel painelProjetosGerenciados;
    private javax.swing.JPanel painelRegistroAcad;
    private javax.swing.JPanel painelTelefones;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTable tabelaColaboradores;
    private javax.swing.JTable tabelaProjetos;
    private javax.swing.JTable tabelaProjetosGerenciados;
    private javax.swing.JTextField textCPF;
    private javax.swing.JTextField textCategoria;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textNomeMae;
    private javax.swing.JTextField textNomePai;
    private javax.swing.JTextField textRG;
    // End of variables declaration//GEN-END:variables

    private void carregarTabela() {
        ArrayList<HashMap<String, Object>> colaboradores = ControleColaborador.recuperarTodos();
        DefaultTableModel m = (DefaultTableModel) tabelaColaboradores.getModel();

        for (HashMap<String, Object> c : colaboradores) {
            m.addRow(new Object[]{
                c.get("codigo"),
                c.get("nome"),
                c.get("email"),
                c.get("categoria"),
                c.get("academico"),
                c.get("ativo")});
        }
    }

    private void carregarProjetos() {
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("codigo", textCodigo.getText());

        ArrayList<HashMap<String, Object>> projetos = ControleColaborador.carregarProjetos(dados);
        DefaultTableModel m = (DefaultTableModel) tabelaProjetos.getModel();
        m.setRowCount(0);

        for (HashMap<String, Object> p : projetos) {
            m.addRow(new Object[]{p.get("codigo"), p.get("nome")});
        }
    }

    private void carregarProjetosGerenciados() {
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("codigo", textCodigo.getText());

        ArrayList<HashMap<String, Object>> projetos = ControleColaborador.carregarProjetosGerenciados(dados);
        DefaultTableModel m = (DefaultTableModel) tabelaProjetosGerenciados.getModel();
        m.setRowCount(0);

        for (HashMap<String, Object> p : projetos) {
            m.addRow(new Object[]{p.get("codigo"), p.get("nome")});
        }
    }

    private void atualizarTabela(int linha, HashMap<String, Object> dados) {
        if (linha == -1) {
            ((DefaultTableModel) tabelaColaboradores.getModel())
                    .addRow(new Object[]{});
            linha = tabelaColaboradores.getRowCount() - 1;
        }

        tabelaColaboradores.setValueAt(dados.get("codigo"), linha, 0);
        tabelaColaboradores.setValueAt(dados.get("nome"), linha, 1);
        tabelaColaboradores.setValueAt(dados.get("email"), linha, 2);
        tabelaColaboradores.setValueAt(dados.get("categoria"), linha, 3);
        tabelaColaboradores.setValueAt(dados.get("academico"), linha, 4);
        tabelaColaboradores.setValueAt(dados.get("ativo"), linha, 5);
    }

}
