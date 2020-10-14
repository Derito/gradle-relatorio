package gradle.relatorio.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa")
public class Pessoa extends GenericDomain {
	
	@Column(name = "nome_pessoa", length = 50, nullable = false)
	private String nomePessoa;
	@Column(name = "numero_bi", length = 10, nullable = false)
	private String numBi;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Endereco endereco;
		
	public String getNomePessoa() {
		return nomePessoa;
	}
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	public String getNumBi() {
		return numBi;
	}
	public void setNumBi(String numBi) {
		this.numBi = numBi;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
