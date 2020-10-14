package gradle.relatorio.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import gradle.relatorio.dao.PaisDAO;
import gradle.relatorio.domain.Pais;


//o ViewScoped define o tempo de visão dos objectos na tela
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped 
public class PaisBean implements Serializable {
	// Para ligar ao modelo ou domain
	private Pais pais;
	// Para preenchimento da tabela na visao
	private List<Pais> paises;

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	// Metodo responsavel por popular na view os paises
	@PostConstruct // chama o metodo ao criar o bean e ao abrir a view
	public void listar() {
		try {
			PaisDAO paisDAO = new PaisDAO();
			paises = paisDAO.listar();

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar listar os paises. ");
			ex.printStackTrace();
		}
	}

//Funciona como limpador da tela
	public void novo() {
		pais = new Pais();
	}

	public void salvar() {
		/*
		 * String msg = "Testando com JSF"; FacesMessage msn = new
		 * FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		 * 
		 * FacesContext contexto = FacesContext.getCurrentInstance();
		 * contexto.addMessage(null, msn); Usando o mesmo codigo por meio do Omnifaces
		 * simplificado
		 */
		try {
			PaisDAO paisDAO = new PaisDAO();
			paisDAO.merge(pais);
			novo();
			//Para actualizar os dados na tela
			paises = paisDAO.listar();
			
			Messages.addGlobalInfo("Operação realizada com sucesso.");

		} catch (RuntimeException ex) {
			Messages.addGlobalInfo("Erro ao tentar salvar o Pais. ");
			ex.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			//Erro resolvido na view por retirar os parenteses do metodo.
			pais =  (Pais) evento.getComponent().getAttributes().get("paisSeleccionado");

			PaisDAO paisDAO = new PaisDAO();
			paisDAO.excluir(pais);
			
			paises = paisDAO.listar();

			Messages.addGlobalInfo("Pais excluido com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar excluir o Pais. ");
			ex.printStackTrace();
		}

	}
	public void editar(ActionEvent evento) {
		try {
			//Erro resolvido na view por retirar os parenteses do metodo.
			pais =  (Pais) evento.getComponent().getAttributes().get("paisSeleccionado");
						
			PaisDAO paisDAO = new PaisDAO();			
			paisDAO.editar(pais);
			
			paises = paisDAO.listar();

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar editar o Pais. ");
			ex.printStackTrace();
		}
	}

}
