
package DAO;

import Factory.ConnectionDb;
import Model.Matricula;
import com.mysql.cj.xdevapi.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MatriculaDao  extends ConnectionDb{
    
    public Integer criarTurma(Matricula matricula){
        
        try {
             PreparedStatement stmt = getConexao().prepareStatement("INSERT INTO matricula (id_alunoFk, id_turmaFk) VALUES (?,?)");
             stmt.setInt(1, matricula.getAluno().getId());
             stmt.setInt(2, matricula.getTurma().getId());
             stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
        
    }
    
    
    public List<Matricula> mostrarMatriculaPorTurma (Integer idDaTurma){
        List<Matricula> matriculas = new ArrayList<Matricula>();
        
        
        try {
            PreparedStatement stmt = getConexao().prepareStatement("select m.id_matriculaPk, a.nome, c.nomeCurso from matricula m " +
            " inner join aluno a  on m.id_alunoFk = a.id_alunoPk " +
            " inner join turma t on t.id_turmaPk  = m.id_turmaFk " +
            " inner join curso c on  c.id_cursoPk  = t.id_cursoFk " +
            " where t.id_turmaPk  = ?");
            stmt.setInt(1, idDaTurma);
            ResultSet resultado =  stmt.executeQuery();
            while (resultado.next()) {
               Matricula matricula = new Matricula();
               matricula.setId(resultado.getInt("id_matriculaPk"));
               matricula.getAluno().setNome(resultado.getString("nome"));
               matricula.getTurma().getCurso().setNome(resultado.getString("nomeCurso"));
               matriculas.add(matricula);  
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
        return matriculas; 
    }
    
    
    public Integer verificarSeExistePorIdDoALuno(Integer idAluno){
        Integer contagem = 0;
         try {
              PreparedStatement stmt = getConexao().prepareStatement("SELECT COUNT(*) AS countRow FROM matricula WHERE id_alunoFk = ?");
             stmt.setInt(1, idAluno);
             ResultSet resultado = stmt.executeQuery();
             if(resultado.next()){
                 contagem =  resultado.getInt("countRow");
             }else{
                 contagem = 0;
             }
             
        } catch (Exception e) {
            System.out.println(e);
           contagem = 0;
             
        }
         return contagem;
    }
    public List<Matricula> mostrarMatriculaIndividual(Integer idMatricula){
        
        List<Matricula> matriculas = new ArrayList<Matricula>();
        
        try {
            
             PreparedStatement stmt = getConexao().prepareStatement("select m.id_matriculaPk, a.nome, c.nomeCurso from matricula m " +
            " inner join aluno a  on m.id_alunoFk = a.id_alunoPk " +
            " inner join turma t on t.id_turmaPk  = m.id_turmaFk " +
            " inner join curso c on  c.id_cursoPk  = t.id_cursoFk " +
            " where m.id_matriculaPk  = ?");
            stmt.setInt(1, idMatricula);
            ResultSet resultado =  stmt.executeQuery();
            while (resultado.next()) {
               Matricula matricula = new Matricula();
               matricula.setId(resultado.getInt("id_matriculaPk"));
               matricula.getAluno().setNome(resultado.getString("nome"));
               matricula.getTurma().getCurso().setNome(resultado.getString("nomeCurso"));
               matriculas.add(matricula);  
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
       
        return matriculas;
    }
    
     
    public Integer editarMatricula(Matricula matricula){
        Integer resultado ;
       
        try {
              PreparedStatement stmt = getConexao().prepareStatement("UPDATE matricula SET  id_alunoFk = ?, id_turmaFk =?  WHERE id_matriculaPk = ?");
              stmt.setInt(1, matricula.getAluno().getId());
              stmt.setInt(2, matricula.getTurma().getId());
              stmt.setInt(3, matricula.getId());
              stmt.executeUpdate();
              resultado = 1;
             
        } catch (Exception e) {
            System.out.println(e);
           resultado = 0;
             
        }
        
        return resultado;
    }
    
    public Integer deletarMatricula(Integer idMatricula){
       Integer resultado;
        try {
             PreparedStatement stmt = getConexao().prepareStatement("DELETE FROM matricula WHERE id_matriculaPk = ?");
             stmt.setInt(1, idMatricula);
             stmt.executeUpdate();
             
             resultado = 1;
        } catch (Exception e) {
            
            resultado = 0;
        }
        
        return resultado;
    }
    
    
    
}
