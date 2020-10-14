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
@Table(name = "publicador")
public class Publicador extends GenericDomain {
	
	@Column(name = "data_ini_publicador", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date inicioPublicador;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Endereco endereco;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Congregacao congregacao;
	
	public Date getInicioPublicador() {
		return inicioPublicador;
	}
	public void setInicioPublicador(Date inicioPublicador) {
		this.inicioPublicador = inicioPublicador;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Congregacao getCongregacao() {
		return congregacao;
	}
	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}
	
}
