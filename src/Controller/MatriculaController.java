
package Controller;
import DAO.DaoFactory;
import Model.Matricula;
import java.util.List;

public class MatriculaController {
    
    public Integer fazerMatricula(Matricula matricula){
       
      Integer resultadoCadastro;
        
      Integer resultadoAluno =  DaoFactory.getAlunoDao().verificarSeExiste(matricula.getAluno().getId());   
      
      if(resultadoAluno == 1){
         DaoFactory.getMatriculaDao().criarTurma(matricula);
         resultadoCadastro = 1;
      }else{
          resultadoCadastro = 0;
      }
       return resultadoCadastro;
    }
    
    
    public List<Matricula> verMatriculasPorTurma(Integer idTurma){

            return DaoFactory.getMatriculaDao().mostrarMatriculaPorTurma(idTurma);
      
     
    }
    
    public List<Matricula> verMatriculaIndividual(Integer idMatricula){
        return DaoFactory.getMatriculaDao().mostrarMatriculaIndividual(idMatricula);
    }
    
    
   public Integer editarMatricula(Matricula matricula){
      
        List<Matricula> matriculaResult = DaoFactory.getMatriculaDao().mostrarMatriculaIndividual(matricula.getId());
        Integer resultado = 0;
        if(matriculaResult.size() > 0){
            resultado =  DaoFactory.getMatriculaDao().editarMatricula(matricula);
        }
        return resultado; 
   }
   
   public Integer deletarMatricula(Integer idMatricula){
     return  DaoFactory.getMatriculaDao().deletarMatricula(idMatricula);
   }
}
