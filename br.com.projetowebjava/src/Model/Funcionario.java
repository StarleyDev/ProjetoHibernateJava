package Model;

import javax.persistence.*;

// Definindo a classe entidade do banco de dados //
@Entity
@Table(name = "funcionario") // Tabela para banco de dados //
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id gerado automaticamente e autoincrementa //
	private int id;

	// Criando colunas //
	@Column
	private String nome;
	@Column
	private String user;
	@Column
	private String pass;
	@Column
	private String cpf;
	@Column
	private String tel;

	// Gets e Setters //
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
