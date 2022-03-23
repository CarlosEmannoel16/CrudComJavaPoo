
package View;

import Controller.TurmaController;
import Model.Aluno;
import Model.Turma;
import java.security.Provider.Service;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;


public class TurmaView {
    
    private Scanner jIn;
    private TurmaController turmaController;
    private Turma turma;
    
    
    public TurmaView(){
        this.turmaController = new TurmaController();
        this.jIn = new Scanner(System.in);
        this.turma = new Turma();
    }
    
     public static void menuTurma(){
        System.out.println("|||-------Menu Turma--------- |");
        System.out.println("|1| -  Nova Turma             |");
        System.out.println("|2| -  Ver Turmas             |");
        System.out.println("|3| -  Buscar Turma           |");
        System.out.println("|42| -  Deletar Turma          |");
        System.out.println("|||---------------------------|");
       
    }
     
     
  
     public Integer criarTurma(){
         
       
        Turma turma = new Turma();
        System.out.println("Digite a data de inicio da Turma");
        String dataInicio = this.jIn.nextLine();
        turma.setDataInicio(dataInicio);
        
        System.out.println("Digite a data do fim da Turma");
        String dataFim = this.jIn.nextLine();
        turma.setDataFim(dataFim);
        
        System.out.println("Digite o horario de inicio da Turma");
        String horarioInicio = this.jIn.nextLine();
        turma.setHorarioInicio(horarioInicio);
        
        System.out.println("Digite o horario do fim  da Turma");
        String horarioFim = this.jIn.nextLine();
        turma.setHorarioFim(horarioFim);
        
        System.out.println("Digite o código do Instrutor ");
        Integer idInstrutor = Integer.parseInt(this.jIn.nextLine());
        turma.getInstrutor().setId(idInstrutor);
                
        System.out.println("Digite o código do curso");
        Integer idCurso = Integer.parseInt(this.jIn.nextLine());
        turma.getCurso().setId(idCurso);
        
        turmaController.novaTurma(turma);
        return 1;
            
     }
     
     
     public void mostrarTurmas(){
         
        this.imprimirTurmas(turmaController.listarTurmas());
     }
     
     
     public static void imprimirTurmas(List<Turma> turmas){
        System.out.println("+---------Lista das Turmas--------+");
        for(Turma turmaAtual : turmas){
            System.out.println("Id: " + turmaAtual.getId() + "     Curso: " + turmaAtual.getCurso().getNome()+  "   "
                    + "  Professor: "  + turmaAtual.getInstrutor().getNome() + "     Data de Inicio: " + turmaAtual.getDataInicio() + "    "
                            + "Data de Conclusão: " + turmaAtual.getDataFim()+ "    Horário: " + turmaAtual.getHorarioInicio()+ " ÀS "+ turmaAtual.getHorarioFim());
            System.out.println("---------------------------------+");
        }
        
    }
     
     public  void deletarTurma(){
        System.out.println("Digite o código da turma ");
        Integer idDaTurma = Integer.parseInt(this.jIn.nextLine());
        Integer verificador  = turmaController.verificarSeExiste(idDaTurma);
        if(verificador == 0){
            System.out.println("Impossivel deletar turma");
 
        }else{
             turmaController.deletarTurma(idDaTurma);
        }
     }
     
     
     public void buscarTurma(){
         System.out.println("Digite o código da turma");
         Integer idDaTurma = Integer.parseInt(this.jIn.nextLine());
         List<Turma> turmas =  turmaController.buscaPorId(idDaTurma);
         if(turmas.size() > 0){
             this.imprimirTurmas(turmas);
         }else{
             System.out.println("\n\n Oops! Nenhuma Turma foi encontrada! \n\n");
         }
         
         
         
     }
    
}
