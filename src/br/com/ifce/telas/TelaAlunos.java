/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifce.telas;

import java.sql.*;
import com.br.ifce.dal.Conexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaAlunos extends javax.swing.JFrame {

      //UTILIZANDO FRAMEWORKS DO PACOTE MODULO DE CONEXÃO
Connection conexao = null;
PreparedStatement pst = null;
ResultSet rs = null; //exibe o resultado da conexão
    
    public TelaAlunos() {
        initComponents();
        
        conexao = Conexao.conector(); //CHAMANDO O MÉTODO CONECTOR
    }
    
    
    
    private void adicionarAluno(){
String sql ="insert into alunos(Matricula, Nome, Idade, Serie, Email, Senha) values(?,?,?,?,?,?)";
try {
pst=conexao.prepareStatement(sql);
pst.setString(1,txtMatricula.getText());
pst.setString(2,txtNome.getText());
pst.setString(3,txtIdade.getText());
pst.setString(4,txtSerie.getText());
pst.setString(5,txtEmail.getText());
pst.setString(6, txtSenha.getText());
int adicionado = pst.executeUpdate();
if(adicionado >0){
JOptionPane.showMessageDialog(null,"Aluno cadastrado com sucesso");
txtMatricula.setText(null);
txtNome.setText(null);
txtIdade.setText(null);
txtSerie.setText(null);
txtEmail.setText(null);
txtSenha.setText(null);
}
} catch (Exception e) {
JOptionPane.showMessageDialog(null, e);
}
}
    
    private void consultarAluno(){
    String sql ="select * from alunos where Matricula=?";
    try {
    pst=conexao.prepareStatement(sql);
    pst.setString(1,txtMatricula.getText());
    rs=pst.executeQuery();
    if (rs.next()) {
    txtNome.setText(rs.getString(2));
    txtIdade.setText(rs.getString(3));
    txtSerie.setText(rs.getString(4));
    txtEmail.setText(rs.getString(5));
    txtSenha.setText(rs.getString(6));
    } else {
    JOptionPane.showMessageDialog(null,"Aluno não cadastrado");
    txtNome.setText(null);
    txtIdade.setText(null);
    txtSerie.setText(null);
    txtEmail.setText(null);
    txtSenha.setText(null);
    }
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null,e);
    }
    }
    
    private void removerAluno(){
int confirma=JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este aluno?","Atenção", JOptionPane.YES_NO_OPTION);
if(confirma==JOptionPane.YES_OPTION){
String sql="delete from alunos where Matricula=?";
try {
pst=conexao.prepareStatement(sql);
pst.setString(1,txtMatricula.getText());
int apagado = pst.executeUpdate();
if (apagado>0) {
JOptionPane.showMessageDialog(null,"Aluno removido com sucesso");
}
} catch (Exception e) {
JOptionPane.showMessageDialog(null, e);
}
}
}
    
    private void alterarAluno(){
String sql ="update alunos set Nome=?, Idade=?, Serie=?, Email=?, Senha=? where Matricula=?";
try {
pst=conexao.prepareStatement(sql);
pst.setString(1,txtNome.getText());
pst.setString(2,txtIdade.getText());
pst.setString(3,txtSerie.getText());
pst.setString(4,txtEmail.getText());
pst.setString(5,txtSenha.getText());
pst.setString(6, txtMatricula.getText());
int adicionado = pst.executeUpdate();
if(adicionado >0){
JOptionPane.showMessageDialog(null,"Aluno alterado com sucesso");
txtMatricula.setText(null);
txtNome.setText(null);
txtIdade.setText(null);
txtSerie.setText(null);
txtEmail.setText(null);
txtSenha.setText(null);
}
} catch (Exception e) {
JOptionPane.showMessageDialog(null, e);
}
}
    
    private void pesquisar_aluno(){
String sql= "select * from alunos where Nome like ?";
try {
pst = conexao.prepareStatement(sql);
pst.setString(1, txtAlunoPesquisar.getText() + "%");
rs=pst.executeQuery();
tabAlunos.setModel(DbUtils.resultSetToTableModel(rs));
} catch (Exception e) {
JOptionPane.showMessageDialog(null, e);
}
}

    private void mais_informacoes() {
        String sql = "select * from disciplinas Where Aluno like ? order by disciplinas.Disciplina;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNome.getText() + "%");
            rs = pst.executeQuery();
            tabAlunos.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtAlunoPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabAlunos = new javax.swing.JTable();
        btnAddAluno = new javax.swing.JButton();
        btnPesqAluno = new javax.swing.JButton();
        btnAttAluno = new javax.swing.JButton();
        btnDeleteAluno = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnMaisInformacoes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alunos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(42, 48, 56));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(109, 203, 230));
        jLabel1.setText("ALUNOS");

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(109, 203, 230));
        jLabel2.setText("Matrícula");

        txtMatricula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(109, 203, 230)));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(109, 203, 230));
        jLabel3.setText("Nome");

        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(109, 203, 230)));

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(109, 203, 230));
        jLabel4.setText("Idade");

        txtIdade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(109, 203, 230)));

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(109, 203, 230));
        jLabel5.setText("Série");

        txtSerie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(109, 203, 230)));

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(109, 203, 230));
        jLabel6.setText("Email");

        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(109, 203, 230)));

        jLabel7.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(109, 203, 230));
        jLabel7.setText("Senha");

        txtSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(109, 203, 230)));

        jPanel2.setBackground(new java.awt.Color(109, 203, 230));
        jPanel2.setPreferredSize(new java.awt.Dimension(460, 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(109, 203, 230));
        jLabel8.setText("Pesquisa");

        txtAlunoPesquisar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(109, 203, 230)));
        txtAlunoPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAlunoPesquisarKeyReleased(evt);
            }
        });

        tabAlunos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabAlunos);

        btnAddAluno.setBackground(new java.awt.Color(109, 203, 230));
        btnAddAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ifce/icones/addaluno.png"))); // NOI18N
        btnAddAluno.setToolTipText("Adicionar aluno");
        btnAddAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAlunoActionPerformed(evt);
            }
        });

        btnPesqAluno.setBackground(new java.awt.Color(109, 203, 230));
        btnPesqAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ifce/icones/pesqaluno.png"))); // NOI18N
        btnPesqAluno.setToolTipText("Consultar aluno");
        btnPesqAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqAlunoActionPerformed(evt);
            }
        });

        btnAttAluno.setBackground(new java.awt.Color(109, 203, 230));
        btnAttAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ifce/icones/attaluno.png"))); // NOI18N
        btnAttAluno.setToolTipText("Atualizar aluno");
        btnAttAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttAlunoActionPerformed(evt);
            }
        });

        btnDeleteAluno.setBackground(new java.awt.Color(109, 203, 230));
        btnDeleteAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ifce/icones/deletealuno.png"))); // NOI18N
        btnDeleteAluno.setToolTipText("Excluir aluno");
        btnDeleteAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAlunoActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(109, 203, 230));
        btnVoltar.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnMaisInformacoes.setBackground(new java.awt.Color(109, 203, 230));
        btnMaisInformacoes.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        btnMaisInformacoes.setText("Mais informações");
        btnMaisInformacoes.setToolTipText("Mostra as notas do aluno");
        btnMaisInformacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisInformacoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnVoltar)
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtAlunoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnAddAluno)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesqAluno)
                        .addGap(18, 18, 18)
                        .addComponent(btnAttAluno)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteAluno))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(btnMaisInformacoes)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2))
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3))
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6))
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7))
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8))
                    .addComponent(txtAlunoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMaisInformacoes)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddAluno)
                    .addComponent(btnPesqAluno)
                    .addComponent(btnAttAluno)
                    .addComponent(btnDeleteAluno))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaInicial inicial = new TelaInicial();
        inicial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtAlunoPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlunoPesquisarKeyReleased
        pesquisar_aluno();
    }//GEN-LAST:event_txtAlunoPesquisarKeyReleased

    private void btnAddAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAlunoActionPerformed
        adicionarAluno();
    }//GEN-LAST:event_btnAddAlunoActionPerformed

    private void btnPesqAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqAlunoActionPerformed
        consultarAluno();
    }//GEN-LAST:event_btnPesqAlunoActionPerformed

    private void btnAttAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttAlunoActionPerformed
        alterarAluno();
    }//GEN-LAST:event_btnAttAlunoActionPerformed

    private void btnDeleteAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAlunoActionPerformed
        removerAluno();
    }//GEN-LAST:event_btnDeleteAlunoActionPerformed

    private void btnMaisInformacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisInformacoesActionPerformed
        // TODO add your handling code here:
        TelaMaisInformacoes MaisInfo = new TelaMaisInformacoes();
        MaisInfo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMaisInformacoesActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAlunos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAluno;
    private javax.swing.JButton btnAttAluno;
    private javax.swing.JButton btnDeleteAluno;
    private javax.swing.JButton btnMaisInformacoes;
    private javax.swing.JButton btnPesqAluno;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabAlunos;
    private javax.swing.JTextField txtAlunoPesquisar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
