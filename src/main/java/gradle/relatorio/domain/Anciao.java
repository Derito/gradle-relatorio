package gradle.relatorio.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@SuppressWarnings("serial")
@Entity
@Table(name = "anciao")
public class Anciao extends GenericDomain{
	
	@Column(name = "data_ini_anciao",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date inicioAnciao;
	@Column(name = "tipo_designacao", length = 30, nullable = false)
	private String designacao;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Publicador publicador;
	
	public Date getInicioAnciao() {
		return inicioAnciao;
	}
	public void setInicioAnciao(Date inicioAnciao) {
		this.inicioAnciao = inicioAnciao;
	}
	public String getDesignacao() {
		return designacao;
	}
	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}
	public Publicador getPublicador() {
		return publicador;
	}
	public void setPublicador(Publicador publicador) {
		this.publicador = publicador;
	}
	
}
