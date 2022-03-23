
package Controller;

import DAO.DaoFactory;
import Model.Turma;
import java.util.List;

public class TurmaController {
    
    
    
    public void novaTurma(Turma turma){
        
        DaoFactory.getTurmaDao().adiciocarAluno(turma);
       
    }
    
    
    public List<Turma> listarTurmas(){
        return DaoFactory.getTurmaDao().pegarTodasAsTurmas();
    }
    
    
    public Integer deletarTurma(Integer id){
        return DaoFactory.getTurmaDao().deletarTurma(id);
    }
    
    public List<Turma> buscaPorId(Integer id){
       return  DaoFactory.getTurmaDao().buscarTurma(id);   
    }
    
    public Integer verificarSeExiste(Integer id){
        return DaoFactory.getTurmaDao().verficarTurma(id);
    }
}
