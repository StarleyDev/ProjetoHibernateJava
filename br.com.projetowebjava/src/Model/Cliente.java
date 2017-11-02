package Model;

import javax.persistence.*;

//Definindo a classe entidade do banco de dados //
@Entity
@Table(name = "cliente") // Tabela para bando de dados //
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Criando colunas, e identificando no banco de dados //
	@Column
	private String nome;
	@Column
	private String cpf;
	@Column
	private String telefone;
	@Column
	private String endereco;

	// Gets e Setters //
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
