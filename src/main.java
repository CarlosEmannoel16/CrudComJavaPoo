
import Controller.AlunoController;
import DAO.AlunoDao;
import Model.Aluno;
import Model.Turma;
import View.AlunoView;
import View.MatriculaView;
import View.MenuView;
import View.TurmaView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class main {


    public static void main(String[] args) throws ParseException {
            AlunoDao alunoDao = new AlunoDao();
            List<Aluno> alunos = new ArrayList<>();
           
            Integer escolhaDoMenuPrincipal = null;
            
        do {
                MenuView.menu(); // Mostra o Menu principal
                Scanner jIn = new Scanner(System.in);
                escolhaDoMenuPrincipal = Integer.parseInt(jIn.nextLine());
                AlunoView alunoView = new AlunoView();
                TurmaView  turmaView = new TurmaView();
                MatriculaView matriculaView = new MatriculaView();
                Turma turma;
                
                switch (escolhaDoMenuPrincipal) { 
                    
                 //------------------------------------------------------------------ Opçao Aluno
                    
                case 1: // Escolha Aluno
                    alunoView.menuAluno(); // Mostra o SubMenu de aluno
                    int escolhaDoSubMenuAluno = Integer.parseInt(jIn.nextLine());
                    if(escolhaDoSubMenuAluno == 1){
                        alunoView.adicionarAluno();
                    }else if(escolhaDoSubMenuAluno == 2){
                        alunos =  alunoView.listar();
                        alunoView.MostrarAlunos(alunos);
                    } else if(escolhaDoSubMenuAluno == 3){
                       alunoView.deletarAluno();
                    }else if(escolhaDoSubMenuAluno == 4){
                        alunoView.atualizarAluno();
                    }else if(escolhaDoSubMenuAluno == 5){
                        alunoView.pesquisarAluno();
                        
                    }
                    break;
                    
                  //----------------------------------------------------------------- Opcão Turma 
                    
                case 2:
                    TurmaView.menuTurma();
                    int escolhaMenuTurma = Integer.parseInt(jIn.nextLine());
                    if(escolhaMenuTurma == 1){
                      turmaView.criarTurma();
                      
                    }else if (escolhaMenuTurma == 2){
                        turmaView.mostrarTurmas();
                    }else if (escolhaMenuTurma == 3){
                        turmaView.buscarTurma();
                    }else if(escolhaMenuTurma == 4){
                        turmaView.deletarTurma();
                    }
                    break;
                    
                    //------------------------------------------------------------------------- Opção Matricula
                    
                case 3:
                        matriculaView.subMenuMatricula();
                        Integer opcaoMenuMatricula = Integer.parseInt(jIn.nextLine());
                        if(opcaoMenuMatricula ==1){
                            matriculaView.fazerMatricula();
                        }else if(opcaoMenuMatricula == 2){
                            matriculaView.mostrarMatriculaPorTurma();
                        }else if(opcaoMenuMatricula == 3){
                            matriculaView.mostrarMatriculaIndividual();
                        }else if(opcaoMenuMatricula == 4){
                            matriculaView.editarMatricula();
                        }else if(opcaoMenuMatricula == 5){
                            matriculaView.deletarMatricula();
                        }
                    break;
                default:
            }
        }   while(escolhaDoMenuPrincipal != 0); 
        
          
    
    }
    
}
