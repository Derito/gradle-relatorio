package gradle.relatorio.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import gradle.relatorio.dao.CidadeDAO;
import gradle.relatorio.dao.PaisDAO;
import gradle.relatorio.domain.Cidade;
import gradle.relatorio.domain.Pais;



@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {

	private Cidade cidade;
	private List<Cidade> cidades;
	// Para carregar a lista de paises na tela
	private List<Pais> paises;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	public void salvar() {

		try {
			CidadeDAO cidDAO = new CidadeDAO();
			cidDAO.merge(cidade);

			cidade = new Cidade();

			PaisDAO paisDAO = new PaisDAO();
			paises = paisDAO.listar();

			cidades = cidDAO.listar();

			Messages.addGlobalInfo("Operação realizada com sucesso.");

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar salvar a cidade. " + ex);
			ex.printStackTrace();
		}
	}

	// Metodo responsavel por popular na view os paises
	@PostConstruct // chama o metodo ao criar o bean e ao abrir a view
	public void listar() {
		try {
			CidadeDAO cidDAO = new CidadeDAO();
			cidades = cidDAO.listar();

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar listar as cidades. ");
			ex.printStackTrace();
		}
	}

	public void novo() {
		try {
			cidade = new Cidade();
			PaisDAO paisDAO = new PaisDAO();
			// Necessidade de try porque trabalha com o BD e pode gerar erro
			paises = paisDAO.listar("nomeDoPais");
		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar gerar uma nova cidade. ");
			ex.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSeleccionada");

			CidadeDAO cidDAO = new CidadeDAO();
			cidDAO.excluir(cidade);
			
			//PaisDAO paisDAO = new PaisDAO();
			//paises = paisDAO.listar();
			cidades = cidDAO.listar();

			Messages.addGlobalInfo("Cidade excluida com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar excluir a Cidade. ");
			ex.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSeleccionada");

			CidadeDAO cidDAO = new CidadeDAO();
			cidDAO.editar(cidade);

			//cidade = new Cidade();

			PaisDAO paisDAO = new PaisDAO();
			paises = paisDAO.listar();

			cidades = cidDAO.listar();
			Messages.addGlobalInfo("Cidade editada com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar editar a Cidade. ");
			ex.printStackTrace();
		}
	}

}
