/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import conexao.banco_de_dados.TurmaConexao;
import conexao.banco_de_dados.telas_conexao.CadastroTurmaConexao;
import entidades.Turma;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author My Space
 */
public class CadastroTurma extends javax.swing.JDialog {

    /**
     * Creates new form cadastroTurma
     */
    public CadastroTurma() {
        initComponents();
        jRadioButton1dia.setSelected(true);
        jLabelSegundoDia.setEnabled(false);
        jComboBoxSegundoDia.setEnabled(false);
    }

    public void ordenaDia() {
        if (jRadioButton2dias.isSelected()) {
            if (jComboBoxPrimeiroDia.getSelectedIndex() > jComboBoxSegundoDia.getSelectedIndex()) {
                int valor = jComboBoxPrimeiroDia.getSelectedIndex();
                jComboBoxPrimeiroDia.setSelectedIndex(jComboBoxSegundoDia.getSelectedIndex());
                jComboBoxSegundoDia.setSelectedIndex(valor);
            }
        }
    }

    public Time converteHoraParaTime(String tempo) {

        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
        Date data = null;
        try {
            data = formatador.parse(tempo);
            Time time = new Time(data.getTime());

            return time;
        } catch (ParseException ex) {
            Logger.getLogger(CadastroTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isHoraInicioCorreta(String horarioInicial, String horarioFinal) {

        int horaInicio, minutoInicio, horaFim, minutoFim;

        horaInicio = Integer.parseInt(horarioInicial.substring(0, 2));
        minutoInicio = Integer.parseInt(horarioInicial.substring(3, 5));
        horaFim = Integer.parseInt(horarioFinal.substring(0, 2));
        minutoFim = Integer.parseInt(horarioFinal.substring(3, 5));

        if (horaInicio == horaFim && minutoInicio == minutoFim) {
            JOptionPane.showMessageDialog(null, "Horário de inicio igual ao horário de fim.", "Horário incorreto...", ERROR_MESSAGE);
            return false;
        } else if (horaInicio > horaFim) {
            JOptionPane.showMessageDialog(null, "Horário de inicio superior ao horário de fim.", "Horário incorreto...", ERROR_MESSAGE);
            return false;
        } else if (horaInicio == horaFim && minutoInicio > minutoFim) {
            JOptionPane.showMessageDialog(null, "Horário de inicio superior ao horário de fim.", "Horário incorreto...", ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean isHoraCerta(String horaInicio, String horaFim) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        // com setLenient() a data não se adapta a numeros  
        // muito grandes. Se não setado, por exemplo ao  
        // inserir 25h a data ficaria como 1h da manhã  
        // do dia seguinte. 
        Date inicio, fim;

        sdf.setLenient(false);
        try {
            inicio = sdf.parse(horaInicio);
            fim = sdf.parse(horaFim);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Hora incorreta.", "Horário incorreto...", ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public String geraNomeDaTurma() {
        String nome;
        String horarioInicio = jFormattedTextFieldHorarioInicio.getText().substring(0, 5);

        if (jRadioButton1dia.isSelected()) {
            nome = jComboBoxPrimeiroDia.getSelectedItem().toString() + "-" + horarioInicio;
            jLabelNomeGerado.setText(nome);
        } else {
            nome = jComboBoxPrimeiroDia.getSelectedItem().toString() + "-" + jComboBoxSegundoDia.getSelectedItem().toString() + "-" + horarioInicio;
            jLabelNomeGerado.setText(nome);
        }
        return nome;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupNumeroDeDias = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelNomeGerado = new javax.swing.JLabel();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel3p1 = new javax.swing.JPanel();
        jPanel1p3 = new javax.swing.JPanel();
        jRadioButton1dia = new javax.swing.JRadioButton();
        jRadioButton2dias = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxSegundoDia = new javax.swing.JComboBox();
        jLabelSegundoDia = new javax.swing.JLabel();
        jComboBoxPrimeiroDia = new javax.swing.JComboBox();
        jLabelPrimeiroDia = new javax.swing.JLabel();
        jPanel4p1 = new javax.swing.JPanel();
        jFormattedTextFieldHorarioInicio = new javax.swing.JFormattedTextField();
        jFormattedTextFieldHorarioFim = new javax.swing.JFormattedTextField();
        jLabelFim = new javax.swing.JLabel();
        jLabelInicio = new javax.swing.JLabel();
        jLabelCamposObrigatorios = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Turma");

        jPanel1.setBackground(new java.awt.Color(56, 136, 211));

        jLabelNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNome.setText("Nome:");

        jLabelNomeGerado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNomeGerado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNomeGerado.setText("...");

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jPanel3p1.setBackground(new java.awt.Color(56, 136, 211));
        jPanel3p1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dias da semana", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel1p3.setBackground(new java.awt.Color(56, 136, 211));

        jRadioButton1dia.setBackground(new java.awt.Color(56, 136, 211));
        buttonGroupNumeroDeDias.add(jRadioButton1dia);
        jRadioButton1dia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton1dia.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1dia.setText("1 dia");
        jRadioButton1dia.setToolTipText("Número de dias");
        jRadioButton1dia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1diaMouseClicked(evt);
            }
        });

        jRadioButton2dias.setBackground(new java.awt.Color(56, 136, 211));
        buttonGroupNumeroDeDias.add(jRadioButton2dias);
        jRadioButton2dias.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton2dias.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2dias.setText("2 dias");
        jRadioButton2dias.setToolTipText("Número de dias");
        jRadioButton2dias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2diasMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("*");

        javax.swing.GroupLayout jPanel1p3Layout = new javax.swing.GroupLayout(jPanel1p3);
        jPanel1p3.setLayout(jPanel1p3Layout);
        jPanel1p3Layout.setHorizontalGroup(
            jPanel1p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1p3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1dia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jRadioButton2dias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1p3Layout.setVerticalGroup(
            jPanel1p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1p3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1dia)
                    .addComponent(jRadioButton2dias)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBoxSegundoDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado" }));
        jComboBoxSegundoDia.setToolTipText("Dia da semana");
        jComboBoxSegundoDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSegundoDiaActionPerformed(evt);
            }
        });

        jLabelSegundoDia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSegundoDia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSegundoDia.setText("Segundo dia:");

        jComboBoxPrimeiroDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado" }));
        jComboBoxPrimeiroDia.setToolTipText("Dia da semana");
        jComboBoxPrimeiroDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPrimeiroDiaActionPerformed(evt);
            }
        });

        jLabelPrimeiroDia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelPrimeiroDia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPrimeiroDia.setText("*Primeiro dia:");

        javax.swing.GroupLayout jPanel3p1Layout = new javax.swing.GroupLayout(jPanel3p1);
        jPanel3p1.setLayout(jPanel3p1Layout);
        jPanel3p1Layout.setHorizontalGroup(
            jPanel3p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3p1Layout.createSequentialGroup()
                .addGroup(jPanel3p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3p1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelPrimeiroDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxPrimeiroDia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelSegundoDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSegundoDia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3p1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jPanel1p3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(124, 124, 124)))
                .addContainerGap())
        );
        jPanel3p1Layout.setVerticalGroup(
            jPanel3p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3p1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrimeiroDia)
                    .addComponent(jComboBoxPrimeiroDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSegundoDia)
                    .addComponent(jComboBoxSegundoDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4p1.setBackground(new java.awt.Color(56, 136, 211));
        jPanel4p1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Horário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        try {
            jFormattedTextFieldHorarioInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldHorarioInicio.setText("");
        jFormattedTextFieldHorarioInicio.setToolTipText("Horário de início");
        jFormattedTextFieldHorarioInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldHorarioInicioActionPerformed(evt);
            }
        });
        jFormattedTextFieldHorarioInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldHorarioInicioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldHorarioInicioKeyTyped(evt);
            }
        });

        try {
            jFormattedTextFieldHorarioFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldHorarioFim.setText("");
        jFormattedTextFieldHorarioFim.setToolTipText("Horário de fim");
        jFormattedTextFieldHorarioFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldHorarioFimActionPerformed(evt);
            }
        });
        jFormattedTextFieldHorarioFim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldHorarioFimKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldHorarioFimKeyTyped(evt);
            }
        });

        jLabelFim.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelFim.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFim.setText("*Fim:");

        jLabelInicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelInicio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInicio.setText("*Início");

        javax.swing.GroupLayout jPanel4p1Layout = new javax.swing.GroupLayout(jPanel4p1);
        jPanel4p1.setLayout(jPanel4p1Layout);
        jPanel4p1Layout.setHorizontalGroup(
            jPanel4p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4p1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldHorarioInicio)
                .addGap(30, 30, 30)
                .addComponent(jLabelFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldHorarioFim)
                .addGap(34, 34, 34))
        );
        jPanel4p1Layout.setVerticalGroup(
            jPanel4p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4p1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelInicio)
                    .addComponent(jLabelFim)
                    .addComponent(jFormattedTextFieldHorarioFim, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldHorarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabelCamposObrigatorios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCamposObrigatorios.setForeground(new java.awt.Color(255, 51, 51));
        jLabelCamposObrigatorios.setText("Campos Obrigatórios");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNomeGerado, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel4p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(2, 2, 2)
                        .addComponent(jLabelCamposObrigatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(312, 312, 312))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelNomeGerado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCamposObrigatorios)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastrar)
                    .addComponent(jButtonCancelar))
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxPrimeiroDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPrimeiroDiaActionPerformed

    }//GEN-LAST:event_jComboBoxPrimeiroDiaActionPerformed

    private void jComboBoxSegundoDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSegundoDiaActionPerformed

    }//GEN-LAST:event_jComboBoxSegundoDiaActionPerformed

    private void jFormattedTextFieldHorarioInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldHorarioInicioActionPerformed

    }//GEN-LAST:event_jFormattedTextFieldHorarioInicioActionPerformed

    private void jFormattedTextFieldHorarioInicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldHorarioInicioKeyReleased

    }//GEN-LAST:event_jFormattedTextFieldHorarioInicioKeyReleased

    private void jFormattedTextFieldHorarioInicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldHorarioInicioKeyTyped

    }//GEN-LAST:event_jFormattedTextFieldHorarioInicioKeyTyped

    private void jFormattedTextFieldHorarioFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldHorarioFimActionPerformed

    }//GEN-LAST:event_jFormattedTextFieldHorarioFimActionPerformed

    private void jFormattedTextFieldHorarioFimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldHorarioFimKeyReleased

    }//GEN-LAST:event_jFormattedTextFieldHorarioFimKeyReleased

    private void jFormattedTextFieldHorarioFimKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldHorarioFimKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldHorarioFimKeyTyped

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        if (jFormattedTextFieldHorarioInicio.getValue() == null
                || jFormattedTextFieldHorarioFim.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Preencha os campos de horário.", "Campo Vazio...", ERROR_MESSAGE);
        } else if (isHoraInicioCorreta(jFormattedTextFieldHorarioInicio.getText(), jFormattedTextFieldHorarioFim.getText()) == false
                || isHoraCerta(jFormattedTextFieldHorarioInicio.getText(), jFormattedTextFieldHorarioFim.getText()) == false) {

        } else if (jComboBoxPrimeiroDia.getSelectedItem().toString() == jComboBoxSegundoDia.getSelectedItem().toString()) {
            JOptionPane.showMessageDialog(null, "Dias escolhidos são iguais.", "Dias iguais...", ERROR_MESSAGE);

        } else {

            try {
                geraNomeDaTurma();
                
                if (CadastroTurmaConexao.isTurmaExiste(jLabelNomeGerado.getText()) == true) {
                    
                    JOptionPane.showMessageDialog(null, "Já existe uma Turma cadastrada neste horário.", "Erro ao cadastrar turma...", ERROR_MESSAGE);
                } else {

                    Turma turma = new Turma();
                    turma.setNome(jLabelNomeGerado.getText());
                    turma.setPrimairoDia(jComboBoxPrimeiroDia.getSelectedItem().toString());
                    
                    if (!jRadioButton2dias.isSelected()) {
                        turma.setSegundoDia(null);
                    } else {
                        turma.setSegundoDia(jComboBoxSegundoDia.getSelectedItem().toString());
                    }
                    
                    turma.setHorarioInicio(converteHoraParaTime(jFormattedTextFieldHorarioInicio.getText().toString()));
                    turma.setHorarioFim(converteHoraParaTime(jFormattedTextFieldHorarioFim.getText().toString()));
                    
                    ordenaDia();
                    
                    turma.setNome(jLabelNomeGerado.getText());
                    
                    try {
                        TurmaConexao.InsereTurma(turma);
                    } catch (SQLException ex) {
                        Logger.getLogger(CadastroTurma.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(CadastroTurma.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jRadioButton1diaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1diaMouseClicked
        jLabelSegundoDia.setEnabled(false);
        jComboBoxSegundoDia.setEnabled(false);

    }//GEN-LAST:event_jRadioButton1diaMouseClicked

    private void jRadioButton2diasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2diasMouseClicked
        jLabelSegundoDia.setEnabled(true);
        jComboBoxSegundoDia.setEnabled(true);

    }//GEN-LAST:event_jRadioButton2diasMouseClicked

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
            java.util.logging.Logger.getLogger(CadastroTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroTurma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupNumeroDeDias;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox jComboBoxPrimeiroDia;
    private javax.swing.JComboBox jComboBoxSegundoDia;
    private javax.swing.JFormattedTextField jFormattedTextFieldHorarioFim;
    private javax.swing.JFormattedTextField jFormattedTextFieldHorarioInicio;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCamposObrigatorios;
    private javax.swing.JLabel jLabelFim;
    private javax.swing.JLabel jLabelInicio;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeGerado;
    private javax.swing.JLabel jLabelPrimeiroDia;
    private javax.swing.JLabel jLabelSegundoDia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel1p3;
    private javax.swing.JPanel jPanel3p1;
    private javax.swing.JPanel jPanel4p1;
    private javax.swing.JRadioButton jRadioButton1dia;
    private javax.swing.JRadioButton jRadioButton2dias;
    // End of variables declaration//GEN-END:variables
}
