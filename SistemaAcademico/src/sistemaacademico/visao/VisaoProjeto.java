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
import sistemaacademico.controle.ControleAtividade;
import sistemaacademico.controle.ControleColaborador;
import sistemaacademico.controle.ControleProjeto;

/**
 *
 * @author Italo Silva
 */
public class VisaoProjeto extends javax.swing.JFrame {

    private final HashMap<String, Object> dados;
    private final HashMap<String, Integer> colabToCod = new HashMap<>();
    private final HashMap<Integer, String> codToColab = new HashMap<>();

    /**
     * Creates new form VisaoProjeto
     */
    public VisaoProjeto() {
        initComponents();
        dados = new HashMap<>();
        inicializar();
    }

    public VisaoProjeto(int codigoProjeto) {
        this.dados = ControleProjeto.recuperar(codigoProjeto);
        inicializar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogDependencias = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaDependencias = new javax.swing.JTable();
        painelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelPrincipal = new javax.swing.JPanel();
        labelCodigo = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        textNome = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        labelGerente = new javax.swing.JLabel();
        labelObjetivo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taObjetivo = new javax.swing.JTextArea();
        labelRecursos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taRecursos = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        comboGerente = new javax.swing.JComboBox<>();
        painelAtividades = new javax.swing.JPanel();
        labelCodAtividade = new javax.swing.JLabel();
        textCodAtividade = new javax.swing.JTextField();
        labelTituloAtividade = new javax.swing.JLabel();
        textTituloAtividade = new javax.swing.JTextField();
        labelDataInicioAtividade = new javax.swing.JLabel();
        textDataInicioAtividade = new javax.swing.JTextField();
        labelDataFimAtividade = new javax.swing.JLabel();
        textDataFimAtividade = new javax.swing.JTextField();
        labelDuracaoEstimadaAtividade = new javax.swing.JLabel();
        textDuracaoEstimadaAtividade = new javax.swing.JTextField();
        btnDependencias = new javax.swing.JButton();
        btnTarefas = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaAtividades = new javax.swing.JTable();
        btnNovoAtiv = new javax.swing.JButton();
        btnEditarAtiv = new javax.swing.JButton();
        btnGravarAtiv = new javax.swing.JButton();
        btnCancelarAtiv = new javax.swing.JButton();
        btnExcluirAtiv = new javax.swing.JButton();

        dialogDependencias.setModal(true);
        dialogDependencias.setSize(new java.awt.Dimension(500, 500));

        tabelaDependencias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tabelaDependencias);
        if (tabelaDependencias.getColumnModel().getColumnCount() > 0) {
            tabelaDependencias.getColumnModel().getColumn(0).setMinWidth(50);
            tabelaDependencias.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout dialogDependenciasLayout = new javax.swing.GroupLayout(dialogDependencias.getContentPane());
        dialogDependencias.getContentPane().setLayout(dialogDependenciasLayout);
        dialogDependenciasLayout.setHorizontalGroup(
            dialogDependenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        dialogDependenciasLayout.setVerticalGroup(
            dialogDependenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelTitulo.setBackground(new java.awt.Color(204, 204, 255));

        labelTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTitulo.setText("Projeto");

        javax.swing.GroupLayout painelTituloLayout = new javax.swing.GroupLayout(painelTitulo);
        painelTitulo.setLayout(painelTituloLayout);
        painelTituloLayout.setHorizontalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelTituloLayout.setVerticalGroup(
            painelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelCodigo.setText("Código");

        labelNome.setText("Nome");

        labelGerente.setText("Gerente");

        labelObjetivo.setText("Objetivo");

        taObjetivo.setColumns(20);
        taObjetivo.setRows(5);
        jScrollPane1.setViewportView(taObjetivo);

        labelRecursos.setText("Recursos");

        taRecursos.setColumns(20);
        taRecursos.setRows(5);
        jScrollPane2.setViewportView(taRecursos);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelar)
                            .addGroup(painelPrincipalLayout.createSequentialGroup()
                                .addComponent(labelCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelNome)))
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelPrincipalLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btnGravar)
                                .addGap(74, 74, 74)
                                .addComponent(btnExcluir)
                                .addGap(0, 132, Short.MAX_VALUE))
                            .addGroup(painelPrincipalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelGerente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboGerente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(labelObjetivo)
                    .addComponent(labelRecursos))
                .addContainerGap())
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigo)
                    .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNome)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelGerente)
                    .addComponent(comboGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelObjetivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelRecursos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGravar)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Principal", painelPrincipal);

        labelCodAtividade.setText("Código");

        labelTituloAtividade.setText("Título");

        labelDataInicioAtividade.setText("Data Início");

        labelDataFimAtividade.setText("Data Fim");

        labelDuracaoEstimadaAtividade.setText("Duração Estimada");

        btnDependencias.setText("Dependências");
        btnDependencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDependenciasActionPerformed(evt);
            }
        });

        btnTarefas.setText("Tarefas");

        tabelaAtividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Título"
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
        tabelaAtividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAtividadesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaAtividades);
        if (tabelaAtividades.getColumnModel().getColumnCount() > 0) {
            tabelaAtividades.getColumnModel().getColumn(0).setMinWidth(60);
            tabelaAtividades.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        btnNovoAtiv.setText("Novo");
        btnNovoAtiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoAtivActionPerformed(evt);
            }
        });

        btnEditarAtiv.setText("Editar");
        btnEditarAtiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAtivActionPerformed(evt);
            }
        });

        btnGravarAtiv.setText("Gravar");
        btnGravarAtiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarAtivActionPerformed(evt);
            }
        });

        btnCancelarAtiv.setText("Cancelar");
        btnCancelarAtiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAtivActionPerformed(evt);
            }
        });

        btnExcluirAtiv.setText("Excluir");
        btnExcluirAtiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirAtivActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelAtividadesLayout = new javax.swing.GroupLayout(painelAtividades);
        painelAtividades.setLayout(painelAtividadesLayout);
        painelAtividadesLayout.setHorizontalGroup(
            painelAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAtividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(painelAtividadesLayout.createSequentialGroup()
                        .addGroup(painelAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelAtividadesLayout.createSequentialGroup()
                                .addComponent(labelDataInicioAtividade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDataInicioAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelDataFimAtividade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDataFimAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelDuracaoEstimadaAtividade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDuracaoEstimadaAtividade))
                            .addGroup(painelAtividadesLayout.createSequentialGroup()
                                .addGroup(painelAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelAtividadesLayout.createSequentialGroup()
                                        .addComponent(labelCodAtividade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textCodAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelTituloAtividade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(textTituloAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(painelAtividadesLayout.createSequentialGroup()
                                        .addGap(152, 152, 152)
                                        .addComponent(btnDependencias)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTarefas)))
                                .addGap(0, 17, Short.MAX_VALUE)))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAtividadesLayout.createSequentialGroup()
                        .addComponent(btnNovoAtiv)
                        .addGap(67, 67, 67)
                        .addComponent(btnEditarAtiv)
                        .addGap(47, 47, 47)
                        .addComponent(btnGravarAtiv)
                        .addGap(55, 55, 55)
                        .addComponent(btnCancelarAtiv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluirAtiv)))
                .addContainerGap())
        );
        painelAtividadesLayout.setVerticalGroup(
            painelAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelAtividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodAtividade)
                    .addComponent(textCodAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTituloAtividade)
                    .addComponent(textTituloAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataInicioAtividade)
                    .addComponent(textDataInicioAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDataFimAtividade)
                    .addComponent(textDataFimAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDuracaoEstimadaAtividade)
                    .addComponent(textDuracaoEstimadaAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painelAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelAtividadesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDependencias)
                            .addComponent(btnTarefas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAtividadesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovoAtiv)
                            .addComponent(btnEditarAtiv)
                            .addComponent(btnGravarAtiv)
                            .addComponent(btnCancelarAtiv)
                            .addComponent(btnExcluirAtiv))
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Atividades", painelAtividades);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        resetCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        dados.put("nome", textNome.getText());
        dados.put("objetivo", taObjetivo.getText());
        dados.put("recursos", taRecursos.getText());
        dados.put("codigoGerente", colabToCod.get(comboGerente.getSelectedItem().toString()));

        String msg = ControleProjeto.salvar(dados);
        JOptionPane.showMessageDialog(this, msg, "Gravação", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja apagar esse projeto?",
                "Confirmação de exlcusão", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.NO_OPTION)
            return;

        String msg = ControleProjeto.apagar(dados);
        JOptionPane.showMessageDialog(this, msg, "Exclusão", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoAtivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoAtivActionPerformed
        tabelaAtividades.clearSelection();
        limpaControlesAtividade();
        habilitaControlesAtividade();
    }//GEN-LAST:event_btnNovoAtivActionPerformed

    private void btnEditarAtivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAtivActionPerformed
        if (tabelaAtividades.getSelectedRow() != -1)
            habilitaControlesAtividade();
    }//GEN-LAST:event_btnEditarAtivActionPerformed

    private void btnGravarAtivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarAtivActionPerformed
        desabilitaControlesAtividade();

        HashMap<String, Object> dados = new HashMap<>();

        dados.put("codigo", textCodAtividade.getText());
        dados.put("titulo", textTituloAtividade.getText());
        dados.put("dataInicio", textDataInicioAtividade.getText());
        dados.put("dataFim", textDataFimAtividade.getText());
        dados.put("duracaoEstimada", textDuracaoEstimadaAtividade.getText());

        String msg = ControleAtividade.salvar(dados);
        JOptionPane.showMessageDialog(this, msg, "Gravação", JOptionPane.INFORMATION_MESSAGE);

        if (msg.equals(Mensagens.SUCESSO)) {
            int linha = tabelaAtividades.getSelectedRow();
            atualizarTabela(linha, dados);
        } else {
            habilitaControlesAtividade();
        }
    }//GEN-LAST:event_btnGravarAtivActionPerformed

    private void btnCancelarAtivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAtivActionPerformed
        desabilitaControlesAtividade();
        limpaControlesAtividade();
    }//GEN-LAST:event_btnCancelarAtivActionPerformed

    private void btnExcluirAtivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirAtivActionPerformed
        int linha = tabelaAtividades.getSelectedRow();
        if (linha == -1)
            return;

        int resposta = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja apagar essa atividade?",
                "Confirmação de exlcusão", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.NO_OPTION)
            return;

        HashMap<String, Object> ativ = new HashMap<>();
        ativ.put("codigo", textCodAtividade.getText());
        String msg = ControleAtividade.apagar(ativ);
        JOptionPane.showMessageDialog(this, msg, "Exclusão", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnExcluirAtivActionPerformed

    private void tabelaAtividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAtividadesMouseClicked
        int linha = tabelaAtividades.getSelectedRow();
        if (linha == -1)
            return;

        HashMap<String, Object> ativ = new HashMap<>();
        ativ.put("codigo", tabelaAtividades.getValueAt(linha, 0));
        HashMap<String, Object> rv = ControleAtividade.recuperar(ativ);

        textCodAtividade.setText(rv.get("codigo").toString());
        textTituloAtividade.setText(rv.get("titulo").toString());
        textDataFimAtividade.setText(rv.get("dataFim").toString());
        textDataInicioAtividade.setText(rv.get("dataInicio").toString());
        textDuracaoEstimadaAtividade.setText(rv.get("duracaoEstimada").toString());
    }//GEN-LAST:event_tabelaAtividadesMouseClicked

    private void btnDependenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDependenciasActionPerformed
        int linha = tabelaAtividades.getSelectedRow();
        if (linha == -1)
            return;

        HashMap<String, Object> ativ = new HashMap<>();
        ativ.put("codigo", tabelaAtividades.getValueAt(linha, linha));
        ArrayList<HashMap<String, Object>> dependencias
                = ControleAtividade.recuperarDependencias(ativ);

        DefaultTableModel m = (DefaultTableModel) tabelaAtividades.getModel();
        m.setRowCount(0);

        for (HashMap<String, Object> a : dependencias) {
            m.addColumn(new Object[]{a.get("codigo"), a.get("titulo")});
        }

        dialogDependencias.setVisible(true);
    }//GEN-LAST:event_btnDependenciasActionPerformed

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
            java.util.logging.Logger.getLogger(VisaoProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisaoProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisaoProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisaoProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisaoProjeto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarAtiv;
    private javax.swing.JButton btnDependencias;
    private javax.swing.JButton btnEditarAtiv;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluirAtiv;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnGravarAtiv;
    private javax.swing.JButton btnNovoAtiv;
    private javax.swing.JButton btnTarefas;
    private javax.swing.JComboBox<String> comboGerente;
    private javax.swing.JDialog dialogDependencias;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelCodAtividade;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelDataFimAtividade;
    private javax.swing.JLabel labelDataInicioAtividade;
    private javax.swing.JLabel labelDuracaoEstimadaAtividade;
    private javax.swing.JLabel labelGerente;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelObjetivo;
    private javax.swing.JLabel labelRecursos;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTituloAtividade;
    private javax.swing.JPanel painelAtividades;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel painelTitulo;
    private javax.swing.JTextArea taObjetivo;
    private javax.swing.JTextArea taRecursos;
    private javax.swing.JTable tabelaAtividades;
    private javax.swing.JTable tabelaDependencias;
    private javax.swing.JTextField textCodAtividade;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textDataFimAtividade;
    private javax.swing.JTextField textDataInicioAtividade;
    private javax.swing.JTextField textDuracaoEstimadaAtividade;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textTituloAtividade;
    // End of variables declaration//GEN-END:variables

    private void inicializar() {
        carregarColaboradores();
        carregarAtividades();
        initComboGerentes();
        resetCampos();

        if (!dados.containsKey("codigo")) {
            btnExcluir.setEnabled(false);
        }
    }

    private void resetCampos() {
        textCodigo.setText(dados.getOrDefault("codigo", "").toString());
        textNome.setText(dados.getOrDefault("nome", "").toString());
        taObjetivo.setText(dados.getOrDefault("objetivo", "").toString());
        taRecursos.setText(dados.getOrDefault("recursos", "").toString());

        if (!dados.containsKey("codigoGerente"))
            return;

        int codigo;
        try {
            codigo = Integer.parseInt(dados.get("codigoGerente").toString());
        } catch (NumberFormatException ex) {
            System.err.println("Erro ao capturar código do gerente");
            return;
        }

        String gerente = codToColab.get(codigo);
        for (int i = 0; i < comboGerente.getItemCount(); i++) {
            String colab = comboGerente.getItemAt(i);
            if (colab.equals(gerente)) {
                comboGerente.setSelectedIndex(i);
                break;
            }
        }
    }

    private void carregarColaboradores() {
        ArrayList<HashMap<String, Object>> todos = ControleColaborador.recuperarTodos();

        for (HashMap<String, Object> c : todos) {
            colabToCod.put((String) c.get("nome"), (Integer) c.get("codigo"));
            codToColab.put((Integer) c.get("codigo"), (String) c.get("nome"));
        }
    }

    private void initComboGerentes() {
        comboGerente.removeAllItems();
        for (String gerente : colabToCod.keySet()) {
            comboGerente.addItem(gerente);
        }
    }

    private void toggleControlesAtividades(boolean ativo) {
        textCodAtividade.setEditable(ativo);
        textTituloAtividade.setEditable(ativo);
        textDataFimAtividade.setEditable(ativo);
        textDataInicioAtividade.setEditable(ativo);
        textDuracaoEstimadaAtividade.setEditable(ativo);

        btnCancelarAtiv.setEnabled(ativo);
        btnGravarAtiv.setEnabled(ativo);

        btnEditarAtiv.setEnabled(!ativo);
        btnNovoAtiv.setEnabled(!ativo);
        btnExcluirAtiv.setEnabled(!ativo);
        tabelaAtividades.setEnabled(!ativo);
    }

    private void habilitaControlesAtividade() {
        toggleControlesAtividades(true);
    }

    private void desabilitaControlesAtividade() {
        toggleControlesAtividades(false);
    }

    private void limpaControlesAtividade() {
        textCodAtividade.setText("");
        textTituloAtividade.setText("");
        textDataFimAtividade.setText("");
        textDataInicioAtividade.setText("");
        textDuracaoEstimadaAtividade.setText("");
    }

    private void atualizarTabela(int linha, HashMap<String, Object> dados) {
        if (linha == -1) {
            linha = tabelaAtividades.getRowCount();
            ((DefaultTableModel) tabelaAtividades.getModel())
                    .addRow(new Object[]{});
        }

        tabelaAtividades.setValueAt(dados.get("codigo"), linha, 0);
        tabelaAtividades.setValueAt(dados.get("titulo"), linha, 1);
    }

    private void carregarAtividades() {
        DefaultTableModel m = (DefaultTableModel) tabelaAtividades.getModel();
        m.setRowCount(0);
        ArrayList<HashMap<String, Object>> atividades = ControleAtividade.recuperarTodos();

        for (HashMap<String, Object> a : atividades) {
            m.addRow(new Object[]{a.get("codigo"), a.get("titulo")});
        }
    }
}
