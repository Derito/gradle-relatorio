package gradle.relatorio.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "cidade")
public class Cidade extends GenericDomain {
	
	@Column(name = "nome_cidade", length = 50, nullable = false)
	private String nomeDaCidade;
	@Column(name = "sigla_cidade", length = 3, nullable = false)
	private String siglaDaCidade;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Pais pais;
	
	public String getNomeDaCidade() {
		return nomeDaCidade;
	}
	public void setNomeDaCidade(String nomeDaCidade) {
		this.nomeDaCidade = nomeDaCidade;
	}
	public String getSiglaDaCidade() {
		return siglaDaCidade;
	}
	public void setSiglaDaCidade(String siglaDaCidade) {
		this.siglaDaCidade = siglaDaCidade;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	
	
}
