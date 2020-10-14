package gradle.relatorio.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario")
public class Usuario extends GenericDomain {
	
	@Column(name = "usu_senha", length = 10, nullable = false)
	private String Senha;
	@Column(name = "usu_tipo", length = 3, nullable = false)
	private Character tipo;
	@Column( name = "usu_activo",length = 3,  nullable = false)
	private boolean activo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	private Publicador publicador;
	
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public Character getTipo() {
		return tipo;
	}
	//Visa preencher a view, o campo transiente mostra que nao é um campo do banco.
	@Transient
	public String getTipoFormatado() {
		String tipoFormatado = null;
		
		if(tipo == 'A') {
			tipoFormatado = "Administrador";
		}else if(tipo == 'S') {
			tipoFormatado = "Secretario";
		}else if(tipo == 'P') {
				tipoFormatado = "Publicador";
		}
			return tipoFormatado;
	}
	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	//Visa preencher a view, o campo transiente mostra que nao é um campo do banco.
		@Transient
		public String getActivoFormatado() {
			String activoFormatado = null;
			
			if(activo) {
				activoFormatado = "Sim";
			}else {
				activoFormatado = "Nao";			
			}
				return activoFormatado;
		}
	public Publicador getPublicador() {
		return publicador;
	}
	
	public void setPublicador(Publicador publicador) {
		this.publicador = publicador;
	}

}
