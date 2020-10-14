package gradle.relatorio.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "pioneiro")
public class Pioneiro extends GenericDomain{
	
	@Column(name = "pio_regular", nullable = false)
	private boolean regular;
	@Column(name = "pio_auxiliar", nullable = false)
	private boolean auxiliar;
	@Column(name = "data_ini_pioneiro", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date inicioPioneiro;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Publicador publicador;
	
	public boolean isRegular() {
		return regular;
	}
	public void setRegular(boolean regular) {
		this.regular = regular;
	}
	public boolean isAuxiliar() {
		return auxiliar;
	}
	public void setAuxiliar(boolean auxiliar) {
		this.auxiliar = auxiliar;
	}
	
	public Date getInicioPioneiro() {
		return inicioPioneiro;
	}
	public void setInicioPioneiro(Date inicioPioneiro) {
		this.inicioPioneiro = inicioPioneiro;
	}
	public Publicador getPublicador() {
		return publicador;
	}
	public void setPublicador(Publicador publicador) {
		this.publicador = publicador;
	}
	
}
