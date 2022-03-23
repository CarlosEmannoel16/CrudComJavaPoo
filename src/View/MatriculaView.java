
package View;

import Controller.MatriculaController;
import Model.Matricula;
import java.util.List;
import java.util.Scanner;


public class MatriculaView {
    
    
    private Scanner jIn;
    private MatriculaController matriculaController;
    
    public MatriculaView(){
       
         this.jIn = new Scanner(System.in);
         this.matriculaController =  new MatriculaController();
        
    }
    
    
    public void subMenuMatricula(){
        System.out.println("|||--------Menu Matricula------------- |");
        System.out.println("|1| -  Fazer Matricula                 |");
        System.out.println("|2| -  Ver Matricula por Turma         |");
        System.out.println("|3| -  Ver matricula Individual        |");
        System.out.println("|4| -  Editar Matricula                |");
        System.out.println("|5| -  Deletar Matricula               |");
        System.out.println("|||------------------------------------|");
        
    }
    
    public void fazerMatricula(){
        
        Matricula matricula = new Matricula();
        System.out.println("Digite o código do aluno ");
        Integer codigoAluno = Integer.parseInt(this.jIn.nextLine());
        matricula.getAluno().setId(codigoAluno);
        
        System.out.println("Digite o código da turma: ");
        Integer codigoTurma = Integer.parseInt(this.jIn.nextLine());
        matricula.getTurma().setId(codigoTurma);
        
        Integer resultado = matriculaController.fazerMatricula(matricula);
        
        if(resultado == 1){
            System.out.println(" \n\n Matricula efetuada com sucesso! \n\n");
        }else{
            System.out.println("\n\n Oops!, Não foi possivel cadastrar, tente novamente \n\n");
        }
    }
    
    public void mostrarMatriculaPorTurma(){
        List<Matricula> matriculas;
        System.out.println("Digite o código da  turma");
        Integer idTurma = Integer.parseInt(this.jIn.nextLine());
        matriculas = matriculaController.verMatriculasPorTurma(idTurma);
        if(matriculas.size() > 0){
            imprimirMatriculas(matriculas);
        }else{
            System.out.println(" \n\n Oops!, Nehuma Matricula foi encontrada \n\n");
        }
    }
    
    
    public void mostrarMatriculaIndividual(){
        System.out.println("Digite o código da  matricula");
        Integer idMatricula = Integer.parseInt(this.jIn.nextLine());    
        List<Matricula> matricula = matriculaController.verMatriculaIndividual(idMatricula);
        
        if(matricula.size() > 0){
            imprimirMatriculas(matricula);
        }else{
            System.out.println(" \n\n Oops!, Não existe Matriculas com esse código \\n");
        }
        
        
    }
    
    public void imprimirMatriculas(List<Matricula> matriculas){
       
        System.out.println("************************************************************");
        System.out.println("****__*******__*** _____*** _______*******_________*********");
        System.out.println("***|  | ****|  |**|  ___|**|_______|*****|  _____  |********");
        System.out.println("***|  |*****|  |**| |___ *****| |********| |_____| |********");
        System.out.println("***|  |*****|  |**|___  |***  | |  ******| |_____| |********");
        System.out.println("***|  |_  **|  |** ___| |***  | |********| |*****| |********");
        System.out.println("***|____|***|__|**|_____| *** |_|********|_|*****|_| *******");
        System.out.println("************************************************************ \n");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv \n");
        for (Matricula matriculaAtual : matriculas) {
            System.out.println("Código Matricula: " + matriculaAtual.getId() + "   Nome: "+ matriculaAtual.getAluno().getNome()+ "   Curso: " + matriculaAtual.getTurma().getCurso().getNome());
            System.out.println("=============================================================");
        }
        
    }
    
    
    public void editarMatricula(){
        Matricula matricula = new Matricula();
        
        System.out.println("Digite o código da matricula");
        Integer codMatricula = Integer.parseInt(this.jIn.nextLine());
        matricula.setId(codMatricula);
        
        System.out.println("Digite o código do aluno");
        Integer codAluno = Integer.parseInt(this.jIn.nextLine());
        matricula.getAluno().setId(codAluno);
        
        System.out.println("Digite o código da turma");
        Integer codTurma = Integer.parseInt(this.jIn.nextLine());
        matricula.getTurma().setId(codTurma);
        
        
        Integer resultado = matriculaController.editarMatricula(matricula);
        
        if(resultado == 1){
            System.out.println("Atualizado com Sucesso");
        }else{
            System.out.println("\n\n Oops, Não foi possível atualizar, tente novamente! \n\n");
        }
    }
    
    public void deletarMatricula(){
        System.out.println("Digite o código da matricula");
        Integer codMatricula = Integer.parseInt(this.jIn.nextLine());
       
        Integer resultado = matriculaController.deletarMatricula(codMatricula);
        
        if(resultado == 1){
            System.out.println("Matricula Deletada com sucesso!!");
        }else{
            System.out.println("\n\n Oops, Impossível deletar, Tente Novamente \n\n");
        }
    }
}
