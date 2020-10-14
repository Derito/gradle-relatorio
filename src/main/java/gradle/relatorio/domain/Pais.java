package gradle.relatorio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "pais")
public class Pais extends GenericDomain {
	
	
	@Column(name = "nome_pais", length = 50, nullable = false)
	private String nomeDoPais;
	@Column(name = "sigla_pais", length = 3, nullable = false)
	private String siglaDoPais;
		
	public String getNomeDoPais() {
		return nomeDoPais;
	}
	public void setNomeDoPais(String nomeDoPais) {
		this.nomeDoPais = nomeDoPais;
	}
	public String getSiglaDoPais() {
		return siglaDoPais;
	}
	public void setSiglaDoPais(String siglaDoPais) {
		this.siglaDoPais = siglaDoPais;
	}
	
}
