/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import conexao.banco_de_dados.ResponsavelConexao;
import conexao.banco_de_dados.telas_conexao.CadastroResponsavelConexao;
import entidades.Contato;
import entidades.Responsavel;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author My Space
 */
public class CadastroResponsavel extends javax.swing.JDialog {

    private MaskFormatter mascaraTelefone = new MaskFormatter();
    private String errosDoUsuario;

    public CadastroResponsavel(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jButtonRemover.setEnabled(false);
    }

    public Calendar ConvertendoData() {
        Calendar c = Calendar.getInstance();
        Locale eua = Locale.US;
        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL, eua);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        int ano = parseInt(jFormattedTextFieldDataNascimento.getText().substring(6, 10));
        int mes = parseInt(jFormattedTextFieldDataNascimento.getText().substring(3, 5));
        int dia = parseInt(jFormattedTextFieldDataNascimento.getText().substring(0, 2));

        mes = mes - 1;
        c.set(ano, mes, dia);
        //Date data = c.getTime();
        //System.out.println(f.format(data));
        return c;
    }

    public void liberaBotaoSalvar() {
        this.errosDoUsuario = "";

        if (jTextFieldNome.getText().isEmpty()) {
            this.errosDoUsuario = "- Campo Nome está vazio.";
        }
        if (jFormattedTextFieldRg.getValue() == null) {
            this.errosDoUsuario += "\n- Campo RG está vazio.";
        }
        if (jFormattedTextFieldDataNascimento.getValue() == null) {
            this.errosDoUsuario += "\n- Campo Data de Nascimento está vazio.";
        }
        if (jTextFieldRua.getText().isEmpty()) {
            this.errosDoUsuario += "\n- Campo Rua está vazio.";
        }
        if (jTextFieldNumero.getText() == null) {
            this.errosDoUsuario += "\n- Campo Número está vazio.";
        }
        if (jTextFieldBairro.getText().isEmpty()) {
            this.errosDoUsuario += "\n- Campo Bairro está vazio.";
        }
        if (jTextFieldCidade.getText().isEmpty()) {
            this.errosDoUsuario += "\n- Campo Cidade está vazio.";
        }
    }

    public ArrayList<Contato> criaListaDeContatos() {

        Responsavel responsavel;
        try {
            responsavel = ResponsavelConexao.BuscaResponsavelPeloRG(jFormattedTextFieldRg.getText());

            ArrayList<Contato> listaContato = new ArrayList<Contato>();
            int quantidadeDeContatos = jTableTabelaContato.getRowCount();
            Contato contato;
            for (int indice = 0; indice < quantidadeDeContatos; indice++) {
                contato = new Contato();
                contato.setIdResponsavel(responsavel.getIdResponsavel());
                contato.setNome(jTableTabelaContato.getValueAt(indice, 0).toString());
                contato.setTelefone(jTableTabelaContato.getValueAt(indice, 1).toString());
                contato.setOperadora(jTableTabelaContato.getValueAt(indice, 2).toString());

                if (jTableTabelaContato.getValueAt(indice, 3).toString() == "Sim") {
                    contato.setIsWhatsapp(true);
                } else {
                    contato.setIsWhatsapp(false);
                }
                listaContato.add(contato);
            }

            return listaContato;
        } catch (SQLException ex) {
            Logger.getLogger(CadastroResponsavel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao encontrar Responsável.", "Erro ao cadastrar Contatos...", ERROR_MESSAGE);
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jPanelContato = new javax.swing.JPanel();
        jLabelNomeContato = new javax.swing.JLabel();
        jTextFieldNomeContato = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabelaContato = new javax.swing.JTable();
        jComboBoxOperadoraContato = new javax.swing.JComboBox();
        jButtonAdicionarContato = new javax.swing.JButton();
        jCheckBoxWhatsapp = new javax.swing.JCheckBox();
        jLabelOperadoraContato = new javax.swing.JLabel();
        jLabelTelefoneContato = new javax.swing.JLabel();
        jFormattedTextFieldTelefoneContato = new javax.swing.JFormattedTextField();
        jButtonRemover = new javax.swing.JButton();
        jPanelDadosPessoais = new javax.swing.JPanel();
        jLabelBairro = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jComboBoxEscolaridade = new javax.swing.JComboBox();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabelProfissao = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldComplemento = new javax.swing.JTextField();
        jTextFieldProfissao = new javax.swing.JTextField();
        jTextFieldRua = new javax.swing.JTextField();
        jLabelLogradouro = new javax.swing.JLabel();
        jLabelEstadoCivil = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelFacebook = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldFacebook = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabelComplemento = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabelEscolaridade = new javax.swing.JLabel();
        jLabelDataDeNascimento = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jComboBoxEstadoCivil = new javax.swing.JComboBox();
        jLabelRg = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jFormattedTextFieldCep = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDataNascimento = new javax.swing.JFormattedTextField();
        jFormattedTextFieldRg = new javax.swing.JFormattedTextField();
        jButtonSalvar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButtonSalvar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Responsável");

        jPanelPrincipal.setBackground(new java.awt.Color(56, 136, 211));

        jPanelContato.setBackground(new java.awt.Color(56, 136, 211));
        jPanelContato.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contatos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabelNomeContato.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNomeContato.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNomeContato.setText("* Nome:");

        jTableTabelaContato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Telefone", "Operadora", "Whats App"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTabelaContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTabelaContatoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTabelaContato);

        jComboBoxOperadoraContato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tim", "Vivo", "Oi", "Claro", "Fixo" }));
        jComboBoxOperadoraContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOperadoraContatoActionPerformed(evt);
            }
        });

        jButtonAdicionarContato.setText("Adicionar");
        jButtonAdicionarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarContatoActionPerformed(evt);
            }
        });

        jCheckBoxWhatsapp.setText("Whatsapp");
        jCheckBoxWhatsapp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxWhatsappActionPerformed(evt);
            }
        });

        jLabelOperadoraContato.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelOperadoraContato.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOperadoraContato.setText("* Operadora:");

        jLabelTelefoneContato.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTelefoneContato.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefoneContato.setText("* Telefone:");

        try {
            jFormattedTextFieldTelefoneContato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) 9####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldTelefoneContato.setText("(  )     -    ");
        jFormattedTextFieldTelefoneContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldTelefoneContatoActionPerformed(evt);
            }
        });

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelContatoLayout = new javax.swing.GroupLayout(jPanelContato);
        jPanelContato.setLayout(jPanelContatoLayout);
        jPanelContatoLayout.setHorizontalGroup(
            jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContatoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanelContatoLayout.createSequentialGroup()
                        .addComponent(jLabelNomeContato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNomeContato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelTelefoneContato)
                        .addGap(18, 18, 18)
                        .addComponent(jFormattedTextFieldTelefoneContato, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelOperadoraContato)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxOperadoraContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jCheckBoxWhatsapp)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonAdicionarContato, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(jPanelContatoLayout.createSequentialGroup()
                        .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelContatoLayout.setVerticalGroup(
            jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContatoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldNomeContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeContato)
                    .addComponent(jLabelTelefoneContato)
                    .addComponent(jLabelOperadoraContato)
                    .addComponent(jComboBoxOperadoraContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxWhatsapp)
                    .addComponent(jButtonAdicionarContato)
                    .addComponent(jFormattedTextFieldTelefoneContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRemover))
        );

        jPanelDadosPessoais.setBackground(new java.awt.Color(56, 136, 211));
        jPanelDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabelBairro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelBairro.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBairro.setText("* Bairro:");

        jLabelEstado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelEstado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEstado.setText("* Estado:");

        jComboBoxEscolaridade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ensino Fundamental Incompleto", "Ensino Fundamental Completo", "Ensino Médio Incompleto", "Ensino Médio Completo", "Superior Incompleto", "Superior Completo" }));
        jComboBoxEscolaridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEscolaridadeActionPerformed(evt);
            }
        });

        jTextFieldNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumeroActionPerformed(evt);
            }
        });

        jLabelProfissao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelProfissao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProfissao.setText("Profissão:");

        jTextFieldProfissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProfissaoActionPerformed(evt);
            }
        });

        jTextFieldRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRuaActionPerformed(evt);
            }
        });

        jLabelLogradouro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelLogradouro.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogradouro.setText("* Logradouro");

        jLabelEstadoCivil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelEstadoCivil.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEstadoCivil.setText("* Estado Civil:");

        jLabelNumero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNumero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumero.setText("* Numero:");

        jLabelFacebook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelFacebook.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFacebook.setText(" Facebook:");

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jComboBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoActionPerformed(evt);
            }
        });

        jTextFieldNome.setToolTipText("");
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jTextFieldBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBairroActionPerformed(evt);
            }
        });

        jLabelComplemento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelComplemento.setForeground(new java.awt.Color(255, 255, 255));
        jLabelComplemento.setText("Complemento:");

        jTextFieldCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCidadeActionPerformed(evt);
            }
        });

        jLabelEscolaridade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelEscolaridade.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEscolaridade.setText(" Escolaridade:");

        jLabelDataDeNascimento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDataDeNascimento.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDataDeNascimento.setText("* Data de Nascimento:");

        jLabelCidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCidade.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCidade.setText("* Cidade:");

        jLabelNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNome.setText("* Nome:");

        jComboBoxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Solteiro(a)", "Casado(a)", "Divorciado(a)", "Viúvo(a)"}));
        jComboBoxEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoCivilActionPerformed(evt);
            }
        });

        jLabelRg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelRg.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRg.setText("* RG:");

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmail.setText(" Email:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Cep:");

        try {
            jFormattedTextFieldCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDataNascimentoActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UU-########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldRgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDadosPessoaisLayout = new javax.swing.GroupLayout(jPanelDadosPessoais);
        jPanelDadosPessoais.setLayout(jPanelDadosPessoaisLayout);
        jPanelDadosPessoaisLayout.setHorizontalGroup(
            jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(jLabelProfissao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabelEscolaridade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDataDeNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFormattedTextFieldDataNascimento))
                    .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(jLabelNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelRg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldRg, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEstadoCivil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(jLabelCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(jLabelFacebook)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(jLabelLogradouro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelNumero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelComplemento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelBairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDadosPessoaisLayout.setVerticalGroup(
            jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRg)
                    .addComponent(jLabelEstadoCivil)
                    .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProfissao)
                    .addComponent(jLabelEscolaridade)
                    .addComponent(jComboBoxEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDataDeNascimento)
                    .addComponent(jFormattedTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFacebook)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogradouro)
                    .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumero)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelComplemento)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBairro)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCidade)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstado)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("Campos Obrigatórios");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("*");

        jButtonSalvar1.setText("Cancelar");
        jButtonSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelDadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelContato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8)
                        .addGap(230, 230, 230)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButtonSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonSalvar1))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 988, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxOperadoraContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOperadoraContatoActionPerformed

        jFormattedTextFieldTelefoneContato.setValue(null);

        if (jComboBoxOperadoraContato.getSelectedItem().toString().equals("Fixo")) {
            jFormattedTextFieldTelefoneContato.setValue(null);
            jCheckBoxWhatsapp.setEnabled(false);

            try {
                this.mascaraTelefone.setMask("(##)####-####");

                JFormattedTextField.AbstractFormatter fixo = this.mascaraTelefone;
                JFormattedTextField.AbstractFormatterFactory maskFixo = new DefaultFormatterFactory(fixo);

                jFormattedTextFieldTelefoneContato.setFormatterFactory(maskFixo);

            } catch (ParseException ex) {
                Logger.getLogger(CadastroResponsavel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jCheckBoxWhatsapp.setEnabled(true);

            try {
                this.mascaraTelefone.setMask("(##)9####-####");

                JFormattedTextField.AbstractFormatter celular = this.mascaraTelefone;
                JFormattedTextField.AbstractFormatterFactory maskCelular = new DefaultFormatterFactory(celular);

                jFormattedTextFieldTelefoneContato.setFormatterFactory(maskCelular);

            } catch (ParseException ex) {
                Logger.getLogger(CadastroResponsavel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBoxOperadoraContatoActionPerformed

    private void jButtonAdicionarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarContatoActionPerformed
        if (jTextFieldNomeContato.getText().isEmpty() || jFormattedTextFieldTelefoneContato.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Campo vazio...", ERROR_MESSAGE);
        } else if (jTableTabelaContato.getRowCount() < 4) {

            String[] a = new String[4];
            a[0] = jTextFieldNomeContato.getText();
            a[1] = jFormattedTextFieldTelefoneContato.getText().replace("-", "").replace("(", "").replace(")", "");

            a[2] = jComboBoxOperadoraContato.getItemAt(jComboBoxOperadoraContato.getSelectedIndex()).toString();
            if (jCheckBoxWhatsapp.isSelected()) {
                a[3] = "Sim";
            } else {
                a[3] = "Não";
            }
            DefaultTableModel model = (DefaultTableModel) jTableTabelaContato.getModel();
            model.addRow(a);

            jTextFieldNomeContato.setText("");
            jFormattedTextFieldTelefoneContato.setText("");
            jComboBoxOperadoraContato.setSelectedIndex(0);
            jCheckBoxWhatsapp.setSelected(false);
        } else {
            JOptionPane.showMessageDialog(null, "Não é possível adicionar mais contatos.", "Lista de contados cheia...", ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAdicionarContatoActionPerformed

    private void jCheckBoxWhatsappActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxWhatsappActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxWhatsappActionPerformed

    private void jFormattedTextFieldTelefoneContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTelefoneContatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldTelefoneContatoActionPerformed

    private void jTextFieldNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroActionPerformed

    private void jTextFieldRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRuaActionPerformed

    private void jComboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEstadoActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed

    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBairroActionPerformed

    private void jTextFieldCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCidadeActionPerformed

    private void jComboBoxEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEstadoCivilActionPerformed

    private void jFormattedTextFieldDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldDataNascimentoActionPerformed

    private void jFormattedTextFieldRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldRgActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            liberaBotaoSalvar();
            if (this.errosDoUsuario != "") {
                JOptionPane.showMessageDialog(null, this.errosDoUsuario, "Campo vazio...", ERROR_MESSAGE);
                this.errosDoUsuario = "";
            } else {
                
                if (CadastroResponsavelConexao.isResponsavelExiste(jFormattedTextFieldRg.getText())) {
                    JOptionPane.showMessageDialog(null, "Este Responsável já está cadastrado.", "Erro ao cadastrar responsavel...", ERROR_MESSAGE);
                } else {

                    Responsavel responsavel = new Responsavel();
                    responsavel.setNome(jTextFieldNome.getText());
                    responsavel.setRG(jFormattedTextFieldRg.getText());

                    if (jComboBoxEstadoCivil.getSelectedItem().toString() == "Solteiro(a)") {
                        responsavel.setEstadoCivil("S");
                    } else if (jComboBoxEstadoCivil.getSelectedItem().toString() == "Casado(a)") {
                        responsavel.setEstadoCivil("C");
                    } else if (jComboBoxEstadoCivil.getSelectedItem().toString() == "Divorciado(a)") {
                        responsavel.setEstadoCivil("D");
                    } else if (jComboBoxEstadoCivil.getSelectedItem().toString() == "Viúvo(a)") {
                        responsavel.setEstadoCivil("V");
                    }

                    responsavel.setProfissao(jTextFieldProfissao.getText());

                    if (jComboBoxEscolaridade.getSelectedItem().toString() == "Ensino Fundamental Incompleto") {
                        responsavel.setEscolaridade("FI");
                    } else if (jComboBoxEscolaridade.getSelectedItem().toString() == "Ensino Fundamento Completo") {
                        responsavel.setEscolaridade("FC");
                    } else if (jComboBoxEscolaridade.getSelectedItem().toString() == "Ensino Médio Incompleto") {
                        responsavel.setEscolaridade("MI");
                    } else if (jComboBoxEscolaridade.getSelectedItem().toString() == "Ensino Médio Completo") {
                        responsavel.setEscolaridade("MC");
                    } else if (jComboBoxEscolaridade.getSelectedItem().toString() == "Superior Incompleto") {
                        responsavel.setEscolaridade("SI");
                    } else if (jComboBoxEscolaridade.getSelectedItem().toString() == "Superior Completo") {
                        responsavel.setEscolaridade("SC");
                    }

                    responsavel.setDataNascimento(ConvertendoData());
                    responsavel.setFacebook(jTextFieldFacebook.getText());
                    responsavel.setEmail(jTextFieldEmail.getText());
                    responsavel.setRua(jTextFieldRua.getText());
                    responsavel.setNumero(jTextFieldNumero.getText());
                    responsavel.setComplemento(jTextFieldComplemento.getText());
                    responsavel.setBairro(jTextFieldBairro.getText());
                    responsavel.setCidade(jTextFieldCidade.getText());
                    responsavel.setCep(jFormattedTextFieldCep.getText());
                    responsavel.setEstado(jComboBoxEstado.getSelectedItem().toString());

                    try {
                        ResponsavelConexao.InsereResponsavel(responsavel);
                        JOptionPane.showMessageDialog(null,"Responsável cadastrado com sucesso!","Cadastro realizado...",INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        Logger.getLogger(CadastroResponsavel.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o Responsável.", "Erro ao cadastrar Responsável...", ERROR_MESSAGE);
                    }

                    if (jTableTabelaContato.getRowCount() >= 1) {
                        ArrayList<Contato> lista_contato = criaListaDeContatos();
                        try {
                            ResponsavelConexao.InsereContato(lista_contato);
                        } catch (SQLException ex) {
                            Logger.getLogger(CadastroResponsavel.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar os contatos.", "Erro ao cadastrar Contatos...", ERROR_MESSAGE);
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroResponsavel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jTextFieldProfissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProfissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProfissaoActionPerformed

    private void jComboBoxEscolaridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEscolaridadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEscolaridadeActionPerformed

    private void jButtonSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvar1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSalvar1ActionPerformed

    private void jTableTabelaContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTabelaContatoMouseClicked

        if (jTableTabelaContato.getSelectedRow() != -1) {
            jButtonRemover.setEnabled(true);
        }
    }//GEN-LAST:event_jTableTabelaContatoMouseClicked

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        DefaultTableModel nova = (DefaultTableModel) jTableTabelaContato.getModel();
        nova.removeRow(jTableTabelaContato.getSelectedRow());
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroResponsavel dialog = new CadastroResponsavel(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarContato;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSalvar1;
    private javax.swing.JCheckBox jCheckBoxWhatsapp;
    private javax.swing.JComboBox jComboBoxEscolaridade;
    private javax.swing.JComboBox jComboBoxEstado;
    private javax.swing.JComboBox jComboBoxEstadoCivil;
    private javax.swing.JComboBox jComboBoxOperadoraContato;
    private javax.swing.JFormattedTextField jFormattedTextFieldCep;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataNascimento;
    private javax.swing.JFormattedTextField jFormattedTextFieldRg;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefoneContato;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelComplemento;
    private javax.swing.JLabel jLabelDataDeNascimento;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEscolaridade;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelEstadoCivil;
    private javax.swing.JLabel jLabelFacebook;
    private javax.swing.JLabel jLabelLogradouro;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeContato;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelOperadoraContato;
    private javax.swing.JLabel jLabelProfissao;
    private javax.swing.JLabel jLabelRg;
    private javax.swing.JLabel jLabelTelefoneContato;
    private javax.swing.JPanel jPanelContato;
    private javax.swing.JPanel jPanelDadosPessoais;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabelaContato;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFacebook;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNomeContato;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldProfissao;
    private javax.swing.JTextField jTextFieldRua;
    // End of variables declaration//GEN-END:variables
}
