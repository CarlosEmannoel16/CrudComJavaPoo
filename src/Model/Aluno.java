package Model;

public class Aluno extends Pessoa {
    
    private EscolaridadeEnum escolaridade;


    public EscolaridadeEnum getEscolaridade() {
        return escolaridade;
    }


    public void setEscolaridade(EscolaridadeEnum escolaridade) {
        this.escolaridade = escolaridade;
    }

}

