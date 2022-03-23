
package View;
import Controller.AlunoController;
import DAO.AlunoDao;
import Model.Aluno;
import Model.Pessoa;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class AlunoView {
    
      private Scanner jIn;
      private AlunoController alunoController;
      
      public AlunoView(){
          this.alunoController = new AlunoController();
          this.jIn = new Scanner(System.in);
      }
    
    public static void menuAluno(){
        System.out.println("|||-------Menu Aluno--------- |");
        System.out.println("|1| -  Cadastrar Aluno        |");
        System.out.println("|2| -  Ver Alunos             |");
        System.out.println("|3| -  Deletar Aluno          |");
        System.out.println("|4| -  Editar Aluno           |");
        System.out.println("|5| -  Buscar Aluno           |");
        System.out.println("|||---------------------------|");
       
    }
    
    public Aluno subMenuAdicionarOuModificarAluno(Boolean update){
        String fraseNovo = ":Modificar";
        Aluno aluno = new Aluno();
        System.out.println("Digite o  Nome " + ((update)? fraseNovo : ""));
        String nomeAluno = this.jIn.nextLine();
        aluno.setNome(nomeAluno);
        
        System.out.println("Digite o  Cpf " + ((update)? fraseNovo : ""));
        String cpfAluno = this.jIn.nextLine();
        aluno.setCpf(cpfAluno);
        System.out.println("Digite o  sexo "  + ((update)? fraseNovo : ""));
        String sexoAluno = this.jIn.nextLine();
        aluno.setSexo(sexoAluno);
        System.out.println("Digite a data de Nascimento "  + ((update)? fraseNovo : ""));
        String nascimentoAluno = this.jIn.nextLine();
        aluno.setNascimento(nascimentoAluno);
        System.out.println("Digite o E-mail "  + ((update)? fraseNovo : ""));
        String emailAluno  = this.jIn.nextLine();
        aluno.setEmail(emailAluno);
        System.out.println("Digite o telefone "  + ((update)? fraseNovo : ""));
        String telefoneAluno = this.jIn.nextLine();
        aluno.setTelefone(telefoneAluno);
        System.out.println("Digite a Cidade "  + ((update)? fraseNovo : ""));
        String cidadeLAuno = this.jIn.nextLine();
        aluno.setCidade(cidadeLAuno);
        System.out.println("Digite o logradouro "  + ((update)? fraseNovo : ""));
        String logradouroAluno = this.jIn.nextLine();
        aluno.setLogradouro(logradouroAluno);
        System.out.println("Digite o número "  + ((update)? fraseNovo : ""));
        String numeroEnderecoAluno = this.jIn.nextLine();
        aluno.setNumero(numeroEnderecoAluno);
        System.out.println("Digite o bairro "  + ((update)? fraseNovo : ""));
        String bairroAluno = this.jIn.nextLine();
        aluno.setBairro(bairroAluno);
        System.out.println("Digite o Cep "  + ((update)? fraseNovo : ""));
        String cepAluno = this.jIn.nextLine();
        aluno.setCep(cepAluno);
        
        
       return aluno;
    }
    
    public Integer adicionarAluno(){
        Aluno aluno = this.subMenuAdicionarOuModificarAluno(false);
        alunoController.salvarAluno(aluno);
        return 1;
    }
    
    public void atualizarAluno(){
        System.out.println("Digite o id do Aluno");
        Integer id = Integer.parseInt(this.jIn.nextLine());
        
        Aluno aluno = this.subMenuAdicionarOuModificarAluno(true);
        Integer resultado = alunoController.atualizarAluno(aluno, id);
        if(resultado == 1){
            System.out.println("Atualizado com sucesso! !");
        }else{
            System.out.println(" \n\n Não foi possivel casdastrar aluno, tente novamente! \n\n");
        }
        
    }
 
    
    public  void pesquisarAluno(){
        List<Aluno> alunos;
        System.out.println("Digite o nome do aluno");
        String opcaoEscolhida  = this.jIn.nextLine();
         alunos = alunoController.buscar(opcaoEscolhida);
         
         if(alunos.size() > 0){
               this.MostrarAlunos(alunos);
         }else{
             System.out.println("\n\n Nenhum aluno encontrado! \n\n");
         }
       
       
    }
    
    public Integer deletarAluno(){
        System.out.println("Digite o id do Aluno: ");
        Integer opcaoEscolhida  = Integer.parseInt(this.jIn.nextLine());
         
  
        Integer resultado  = alunoController.deletarAluno(opcaoEscolhida);
        
        if(resultado == 1){
            System.out.println("Aluno deleteado \n\n");
        }else{
            System.out.println(" \n Não foi possível deletar o aluno \n Aluno com matricula ativa");
        }
        return 1;
    }  
    
 
      
      
    public List<Aluno> listar(){
        return alunoController.listar();
    }
    
    public static void MostrarAlunos(List<Aluno> alunos){
        System.out.println("+---------Lista de Alunos--------+");
        for(Aluno aluno : alunos){
            System.out.println("Id: " + aluno.getId() + "     Nome: " + aluno.getNome() +  "     Cidade: "  + aluno.getCidade() + "");
            System.out.println("---------------------------------+");
        }
        
    }
}
