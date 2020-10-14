package gradle.relatorio.bean;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import gradle.relatorio.dao.CidadeDAO;
import gradle.relatorio.dao.EnderecoDAO;
import gradle.relatorio.domain.Cidade;
import gradle.relatorio.domain.Endereco;



@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EnderecoBean implements Serializable {

	private Endereco endereco;
	private List<Endereco> enderecos;
	// Para carregar a lista de paises na tela
	private List<Cidade> cidades;
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public void salvar() {

		try {
			EnderecoDAO endDAO = new EnderecoDAO();
			endDAO.merge(endereco);

			endereco = new Endereco();

			CidadeDAO cidDAO = new CidadeDAO();
			cidades = cidDAO.listar();

			enderecos = endDAO.listar();

			Messages.addGlobalInfo("Operação realizada com sucesso.");

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar salvar o endereço. " + ex);
			ex.printStackTrace();
		}
	}

	// Metodo responsavel por popular na view os paises
	@PostConstruct // chama o metodo ao criar o bean e ao abrir a view
	public void listar() {
		try {
			EnderecoDAO endDAO = new EnderecoDAO();
			enderecos = endDAO.listar();

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar listar os endereços. ");
			ex.printStackTrace();
		}
	}

	public void novo() {
		try {
			endereco = new Endereco();
			CidadeDAO cidDAO = new CidadeDAO();
			// Necessidade de try porque trabalha com o BD e pode gerar erro
			cidades = cidDAO.listar();
		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar gerar um novo endereco. ");
			ex.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			endereco = (Endereco) evento.getComponent().getAttributes().get("enderecoSeleccionado");

			EnderecoDAO endDAO = new EnderecoDAO();
			endDAO.excluir(endereco);
			
			enderecos = endDAO.listar();

			Messages.addGlobalInfo("Endereco excluido com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar excluir o endereço. ");
			ex.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			endereco = (Endereco) evento.getComponent().getAttributes().get("enderecoSeleccionado");

			EnderecoDAO endDAO = new EnderecoDAO();
			endDAO.editar(endereco);

			//cidade = new Cidade();

			CidadeDAO cidDAO = new CidadeDAO();
			cidades = cidDAO.listar();

			enderecos = endDAO.listar();
			Messages.addGlobalInfo("Endereço editado com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar editar o Endereço. ");
			ex.printStackTrace();
		}
	}

}
