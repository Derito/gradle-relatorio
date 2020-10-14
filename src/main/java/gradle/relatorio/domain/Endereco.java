package gradle.relatorio.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "endereco")
public class Endereco extends GenericDomain{
	
	@Column(name = "nome_bairro", length = 50, nullable = false)
	private String bairro;
	@Column(name = "nome_rua", length = 50, nullable = false)
	private String rua;
	@Column(name = "numero_casa", length = 5, nullable = false)
	private String numCasa;
	@Column(name = "numero_telefone", length = 15, nullable = false)
	private String telefone;
	@Column(name = "email", length = 30, nullable = false)
	private String email;
	@Column(name = "numero_celular", length = 15, nullable = false)
	private String celular;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Cidade cidade;
		
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumCasa() {
		return numCasa;
	}
	public void setNumCasa(String numCasa) {
		this.numCasa = numCasa;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}
