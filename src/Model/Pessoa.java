package Model;

import java.util.Date;

public class Pessoa {
        private Integer id;
	private String nome;
        private String cpf;
	private String sexo;
	private String nascimento;
	private String email;
	private String telefone;
	private String cidade;
        private Uf uf;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

        public Integer getId() {
          return id;
         }

        public void setId(Integer id) {
            this.id = id;
         }

        public String getCpf() {
          return cpf;
        }

  
         public void setCpf(String cpf) {
        this.cpf = cpf;
         }

   
    }
	

