
package DAO;

import Factory.ConnectionDb;
import Model.Aluno;
import java.sql.PreparedStatement;
import Model.Turma;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class TurmaDao  extends ConnectionDb{
    
    
    
    
    public Integer adiciocarAluno(Turma turma){
        
        try {
            PreparedStatement stmt = getConexao().prepareStatement("INSERT INTO turma (dataInicio, dataFim, horarioInicio, horarioFim,"
                    + "id_instrutorFk, id_cursoFk)  VALUES (?,?,?,?,?,?)");
            
            stmt.setString(1, turma.getDataInicio());
            stmt.setString(2, turma.getDataFim());
            stmt.setString(3, turma.getHorarioInicio());
            stmt.setString(4, turma.getHorarioFim());
            stmt.setInt(5, turma.getInstrutor().getId());
            stmt.setInt(6, turma.getCurso().getId());
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }
    
    
    public List<Turma> pegarTodasAsTurmas(){
         List<Turma> turmas = new ArrayList<Turma>();
        
        try {
             PreparedStatement stmt = getConexao().prepareStatement("SELECT c.nomeCurso, i.nome, t.id_turmaPk, t.dataFim, t.dataInicio, t.horarioInicio, t.horarioFim  FROM turma t " +
                "INNER JOIN curso c ON t.id_cursoFk = c.id_cursoPk INNER JOIN instrutor i ON t.id_instrutorFk = i.id_instrutorPk ");
             
             ResultSet resultado = stmt.executeQuery();
             
             while(resultado.next()){    
               Turma turmaAtual = new Turma();
               
               turmaAtual.setId(resultado.getInt("id_turmaPk"));
               turmaAtual.setDataInicio(resultado.getString("dataInicio"));
               turmaAtual.setDataFim(resultado.getString("dataFim"));
               turmaAtual.setHorarioInicio(resultado.getString("horarioInicio"));
               turmaAtual.setHorarioFim(resultado.getString("horarioFim"));
               turmaAtual.getCurso().setNome(resultado.getString("nomeCurso"));
               turmaAtual.getInstrutor().setNome(resultado.getString("nome"));
   
               turmas.add(turmaAtual);  
            }
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
        
        return turmas;
        
    }
    
    public Integer deletarTurma(Integer id){
        
        try {
            PreparedStatement stmt = getConexao().prepareStatement("DELETE FROM matricula WHERE id_matriculaPk = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            PreparedStatement stmt2 = getConexao().prepareStatement("DELETE FROM turma WHERE id_turmaPk = ?");
            stmt2.setInt(1, id);
            stmt2.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }
    
    
    
    public Integer verficarTurma(Integer idTurma){
        Integer contagem = 0;
        try {
             PreparedStatement stmt = getConexao().prepareStatement("SELECT COUNT(*) AS countRow FROM turma WHERE id_turmaPk = ?");
             stmt.setInt(1, idTurma);
             ResultSet resultado = stmt.executeQuery();
             
             if(resultado.next()){
                 contagem =  resultado.getInt("countRow");
             }
            
              
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        return contagem;
    }
    
    public List<Turma> buscarTurma(Integer idDoAluno){
        List<Turma> turmas = new ArrayList<>();
        try {
            
           PreparedStatement stmt = getConexao().prepareStatement("SELECT c.nomeCurso, i.nome, t.id_turmaPk, t.dataFim, t.dataInicio, t.horarioInicio, t.horarioFim  FROM turma t " +
                "INNER JOIN curso c ON t.id_cursoFk = c.id_cursoPk INNER JOIN instrutor i ON t.id_instrutorFk = i.id_instrutorPk WHERE id_turmaPk = ?");
            stmt.setInt(1, idDoAluno);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
               Turma turmaAtual = new Turma();
               turmaAtual.setId(resultado.getInt("id_turmaPk"));
               turmaAtual.setDataInicio(resultado.getString("dataInicio"));
               turmaAtual.setDataFim(resultado.getString("dataFim"));
               turmaAtual.setHorarioInicio(resultado.getString("horarioInicio"));
               turmaAtual.setHorarioFim(resultado.getString("horarioFim"));
               turmaAtual.getCurso().setNome(resultado.getString("nomeCurso"));
               turmaAtual.getInstrutor().setNome(resultado.getString("nome"));
               turmas.add(turmaAtual);

            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return turmas;
        
    }
    
}
