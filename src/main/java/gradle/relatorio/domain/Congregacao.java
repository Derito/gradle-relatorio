package gradle.relatorio.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "congregacao")
public class Congregacao extends GenericDomain{
	
	@Column(name = "nome_congregacao", length = 50, nullable = false)
	private String nomeDaCongregacao;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false )
	private Endereco endereco;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false )
	private Publicador publicador;
	
	public String getNomeDaCongregacao() {
		return nomeDaCongregacao;
	}
	public void setNomeDaCongregacao(String nomeDaCongregacao) {
		this.nomeDaCongregacao = nomeDaCongregacao;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Publicador getPublicador() {
		return publicador;
	}
	public void setPublicador(Publicador publicador) {
		this.publicador = publicador;
	}
	
}
