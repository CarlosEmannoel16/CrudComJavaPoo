
package DAO;

import Factory.ConnectionDb;
import Model.Aluno;
import Model.Pessoa;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class AlunoDao extends ConnectionDb{
    
    
    public Boolean addAluno(Aluno aluno){
     Boolean conclusao = true;
        try {
            
            PreparedStatement stmt = getConexao().prepareStatement("INSERT INTO aluno  "
                    + "(nome,sexo, email, nascimento,  telefone, cidade, logradouro, numero, bairro, cep, cpf) "
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getSexo());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getNascimento());
            stmt.setString(5, aluno.getTelefone());
            stmt.setString(6, aluno.getCidade());
            stmt.setString(7, aluno.getLogradouro());
            stmt.setString(8, aluno.getNumero());
            stmt.setString(9, aluno.getBairro());
            stmt.setString(10, aluno.getCep());
            stmt.setString(11, aluno.getCpf());
            stmt.executeUpdate();
           
        } catch (Exception e) {
            System.out.println(e);
            conclusao = false;
        } 
       return conclusao;
    }
    
    public void deletarAluno(int idDoAluno){
        try {
           PreparedStatement stmt = getConexao().prepareStatement("DELETE FROM aluno WHERE id_alunoPk= ?");
           stmt.setInt(1, idDoAluno);
           stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    
    public void AtualizarDadosDoAluno(Aluno aluno, Integer idDoAluno){
        try {
            
            PreparedStatement stmt = getConexao().prepareStatement("UPDATE  aluno SET"
                    + " nome = ?, sexo = ?, nascimento = ?, email = ?,  telefone  = ?, cidade = ?, logradouro = ?, numero = ?, bairro = ?, cep = ?, cpf = ? WHERE id_alunoPk = ?");
            
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getSexo());
            stmt.setString(3, aluno.getNascimento());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getTelefone());
            stmt.setString(6, aluno.getCidade());
            stmt.setString(7, aluno.getLogradouro());
            stmt.setString(8, aluno.getNumero());
            stmt.setString(9, aluno.getBairro());
            stmt.setString(10, aluno.getCep());
            stmt.setString(11, aluno.getCpf());
            stmt.setInt(12, idDoAluno);
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public  List<Aluno> listarTodosAlunos(){
    
        List<Aluno> alunos = new ArrayList<>();
        
        try {
            PreparedStatement stmt = getConexao().prepareStatement("SELECT id_alunoPk, nome, cidade FROM aluno");
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
               Aluno alunoAtual = new Aluno();
               alunoAtual.setId(resultado.getInt("id_alunoPk"));
               alunoAtual.setNome(resultado.getString("nome"));
               alunoAtual.setCidade(resultado.getString("cidade"));
               alunos.add(alunoAtual);  
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return alunos;
    }
    
    public List<Aluno> buscarAlunoPorNome(String buscaDoAluno){
          List<Aluno> alunos = new ArrayList<>();
        try {
            PreparedStatement stmt = getConexao().prepareStatement("SELECT id_alunoPk, nome, cidade FROM aluno WHERE nome LIKE ?");
            stmt.setString(1, "%" + buscaDoAluno + "%");
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
               Aluno alunoAtual = new Aluno();
               alunoAtual.setId(resultado.getInt("id_alunoPk"));
               alunoAtual.setNome(resultado.getString("nome"));
               alunoAtual.setCidade(resultado.getString("cidade"));
               alunos.add(alunoAtual);   
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return alunos;
    }
    
    
    public Integer verificarSeExiste(Integer idAluno){
        Integer contagem = 0;
        try {
            PreparedStatement stmt = getConexao().prepareStatement("SELECT COUNT(*) AS countRow FROM aluno WHERE id_alunoPk = ?");
             stmt.setInt(1, idAluno);
             ResultSet resultado = stmt.executeQuery();
             
             if(resultado.next()){
                 contagem =  resultado.getInt("countRow");
             }else{
                 contagem = 0;
             }
            
        } catch (Exception e) {
            contagem = 0;
        }
        
        return contagem;
    }
    
   
    
}
