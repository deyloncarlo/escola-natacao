/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package software;

import conexao.banco_de_dados.AlunoConexao;
import conexao.banco_de_dados.NivelConexao;
import conexao.banco_de_dados.ResponsavelConexao;
import conexao.banco_de_dados.TurmaConexao;
import entidades.Aluno;
import entidades.AnamneseAluno;
import entidades.AntropometriaAluno;
import entidades.Contato;
import entidades.Endereco;
import entidades.Nivel;
import entidades.ObjetivoAluno;
import entidades.Responsavel;
import entidades.Turma;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import telas.Home;
import telas.TelaPrincipal;

/**
 *
 * @author My Space
 */
public class Software {

    static JFrame home;
    static JFrame telaPrincipal;
    public static void main(String[] args) throws SQLException {
        
        //TESTE DE INSERÇÃO DE ALUNO NO BANCO DE DADOS
        /*
        Aluno aluno = new Aluno();
        Calendar data = Calendar.getInstance();
        data.set(1996,Calendar.MARCH,30);
        aluno.setDataNascimento(data);
        aluno.setEmail("teste@gmail.com");
        aluno.setEscolaridade("SC");
        aluno.setEstadoCivil("S");
        aluno.setFacebook("Face");
        aluno.setIdNivel(28);
        aluno.setIdResponsavel(18);                 OK!
        aluno.setIdTurma(78);
        aluno.setIsAlunoGoverno(true);
        aluno.setIsHidroginastica(true);
        aluno.setIsNatacao(false);
        aluno.setMotivo("Teste");
        aluno.setNome("Teste");
        aluno.setProfissao("Testador");
        aluno.setRG("MG-12365985");
        
        AlunoConexao.InsereAluno(aluno);
        
        */
        //TESTE DE INSERÇÃO DE ENDEREÇO NO BANCO DE DADOS
        /*
        Endereco endereco1 = new Endereco();
        
        endereco1.setBairro("Santa Terezinha");
        endereco1.setCep("31365090");
        endereco1.setCidade("Contagem");
        endereco1.setComplemento("Blablalba");
        endereco1.setEstado("MG");
        endereco1.setIdAluno(47);
        endereco1.setNumero("123");
        endereco1.setRua("Rua chapada");
        
        Endereco endereco2 = new Endereco();            OK!
        
        endereco2.setBairro("Eldorado");
        endereco2.setCep("31365090");
        endereco2.setCidade("Contagem");
        endereco2.setComplemento("glalgilojk");
        endereco2.setEstado("MG");
        endereco2.setIdAluno(47);
        endereco2.setNumero("654");
        endereco2.setRua("Rua Rio");
        
        ArrayList<Endereco> lista_endereco = new ArrayList();
        lista_endereco.add(endereco1);
        lista_endereco.add(endereco2);
        
        AlunoConexao.InsereEndereco(lista_endereco, 47);
        */
        
        //TESTE DE INSERÇÃO DE CONTATO NO BANCO DE DADOS
        /*
        Contato contato1 = new Contato();
        contato1.setIsWhatsapp(true);
        contato1.setNome("Deylon");
        contato1.setOperadora("Tim");
        contato1.setTelefone("(31)999999999");
        
        Contato contato2 = new Contato();           //OK!
        contato2.setIsWhatsapp(true);
        contato2.setNome("Douglas");
        contato2.setOperadora("Oi");
        contato2.setTelefone("(31)999999999");
        
        ArrayList<Contato> lista_contato = new ArrayList();
        
        lista_contato.add(contato1);
        lista_contato.add(contato2);
                
        ResponsavelConexao.InsereContato(lista_contato, 19);
        */
        
        //TESTE DE INSERÇAO DE OBJETIVO DO ALUNO NO BANCO DE DADOS
        /*
        AlunoConexao.InsereObjetivo(15, 48);            OK!
        */
        
        //TESTE DE INSERÇÃO DE ANAMNESE DO ALUNO NO BANCO DE DADOS
        /*
        AnamneseAluno anamneseAluno = new AnamneseAluno();
        anamneseAluno.setPergunta1(true);
        anamneseAluno.setPergunta2(true);
        anamneseAluno.setPergunta3(true);
        anamneseAluno.setPergunta4(true);
        anamneseAluno.setPergunta5(true);
        anamneseAluno.setPergunta6(true);
        anamneseAluno.setPergunta7(true);
        anamneseAluno.setPergunta8(true);               OK!
        anamneseAluno.setPergunta9(true);
        anamneseAluno.setPergunta10(true);
        anamneseAluno.setPergunta11(true);
        anamneseAluno.setPergunta12(true);
        anamneseAluno.setPergunta13(true);
        anamneseAluno.setPergunta14(true);
        anamneseAluno.setPergunta15(true);
        
        AlunoConexao.InsereAnamnese(anamneseAluno, 48);
        */
        
        //TESTE DE INSERÇÃO DE ANTROPOMETRIA DO ALUNO NO BANCO DE DADOS
        /*
        AntropometriaAluno antropometriaAluno = new AntropometriaAluno();
        
        antropometriaAluno.setAltura(2);
        antropometriaAluno.setClassificacao1("Boa");
        antropometriaAluno.setClassificacao2("Boa");
        antropometriaAluno.setClassificacao3("Boa");
        antropometriaAluno.setFrequenciaCardiaca(60);           OK!
        antropometriaAluno.setICQ(30);
        antropometriaAluno.setIMC(22);
        antropometriaAluno.setPressaoArterial(60);
        antropometriaAluno.setQuadril(90);
        
        AlunoConexao.InsereAntropometria(antropometriaAluno, 51);
        */
        
        //TESTE DE INSERÇÃO DE RESPONSÁVEL NO BANCO DE DADOS
        /*
        Responsavel responsavel = new Responsavel();
        
        responsavel.setBairro("Santa Terezinha");
        responsavel.setCep("31365090");
        responsavel.setCidade("BH");
        responsavel.setComplento("xixixixi");
        
        Calendar data = Calendar.getInstance();
        data.set(1996,Calendar.MARCH,30);
        
        responsavel.setDataNascimento(data);
        responsavel.setEmail("Email@teste");            OK!
        responsavel.setEscolaridade("SC");
        responsavel.setEstado("SC");
        responsavel.setEstadoCivil("S");
        responsavel.setFacebook("FACEtESTE");
        responsavel.setNome("Roberto");
        responsavel.setNumero("123456");
        responsavel.setProfissao("Professor");
        responsavel.setRG("mg18195623");
        responsavel.setRua("Rua teste");
        
        ResponsavelConexao.InsereResponsavel(responsavel);
        */
        
        //TESTE DE INSERÇÃO DE TURMA NO BANCO DE DADOS
        /*
        Turma turma = new Turma();
        turma.setHorarioFim("11:00");
        turma.setHorarioInicio("10:00");
        turma.setNome("Quarta-Sexta");          OK!
        turma.setPrimairoDia("Quarta");
        turma.setSegundoDia("Sexta");
        
        TurmaConexao.InsereTurma(turma);
        */
        
        //TESTE DE INSERÇÃO DE NÍVEL NO BANCO DE DADOS
        /*
        Nivel nivel = new Nivel();
        
        nivel.setCor(-256998);          OK!
        nivel.setDescricao("Teste");
        nivel.setNome("Intermediário");
        
        NivelConexao.InsereNivel(nivel);
        */
        
        //TESTE DE BUSCA DE NÍVEL DO BANCO DE DADOS
        /*
        ArrayList<Nivel> lista_nivel = NivelConexao.BuscaNivel();
        
        for(int indice = 0; indice < lista_nivel.size(); indice++){
            System.out.println(lista_nivel.get(indice).getIdNivel());           OK!
            System.out.println(lista_nivel.get(indice).getNome());
            System.out.println(lista_nivel.get(indice).getDescricao());
            System.out.println(lista_nivel.get(indice).getCor());
        }
        */
    }
    
}
