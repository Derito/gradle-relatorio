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
@Table(name = "servo")
public class Servo extends GenericDomain{
	
	@Column(name = "data_ini_servo",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date inicioServo;
	@Column(name = "tipo_desig_servo", length = 30, nullable = false)
	private String designacaoServo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Publicador publicador;
	
	public Date getInicioServo() {
		return inicioServo;
	}
	public void setInicioServo(Date inicioServo) {
		this.inicioServo = inicioServo;
	}
	public String getDesignacaoServo() {
		return designacaoServo;
	}
	public void setDesignacaoServo(String designacaoServo) {
		this.designacaoServo = designacaoServo;
	}
	public Publicador getPublicador() {
		return publicador;
	}
	public void setPublicador(Publicador publicador) {
		this.publicador = publicador;
	}

}
