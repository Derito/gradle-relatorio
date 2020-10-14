package gradle.relatorio.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import gradle.relatorio.dao.EnderecoDAO;
import gradle.relatorio.dao.PessoaDAO;
import gradle.relatorio.domain.Endereco;
import gradle.relatorio.domain.Pessoa;



@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {

	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	// Para carregar a lista de paises na tela
	private List<Endereco> enderecos;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public void salvar() {

		try {
			PessoaDAO pesDAO = new PessoaDAO();
			pesDAO.merge(pessoa);

			pessoa = new Pessoa();

			EnderecoDAO endDAO = new EnderecoDAO();
			enderecos = endDAO.listar();

			pessoas = pesDAO.listar();

			Messages.addGlobalInfo("Operação realizada com sucesso.");

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar salvar a Pessoa. " + ex);
			ex.printStackTrace();
		}
	}

	// Metodo responsavel por popular na view os paises
	@PostConstruct // chama o metodo ao criar o bean e ao abrir a view
	public void listar() {
		try {
			PessoaDAO pesDAO = new PessoaDAO();
			pessoas = pesDAO.listar();

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar listar as pessoas. ");
			ex.printStackTrace();
		}
	}

	public void novo() {
		try {
			pessoa = new Pessoa();
			EnderecoDAO endDAO = new EnderecoDAO();
			// Necessidade de try porque trabalha com o BD e pode gerar erro
			enderecos = endDAO.listar();
		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar gerar uma nova Pessoa. ");
			ex.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSeleccionada");

			PessoaDAO pesDAO = new PessoaDAO();
			pesDAO.excluir(pessoa);
			
			pessoas = pesDAO.listar();

			Messages.addGlobalInfo("Pessoa excluida com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar excluir a Pessoa. ");
			ex.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSeleccionada");

			PessoaDAO pesDAO = new PessoaDAO();
			pesDAO.editar(pessoa);

			//cidade = new Cidade();

			EnderecoDAO endDAO = new EnderecoDAO();
			enderecos = endDAO.listar();

			pessoas = pesDAO.listar();
			Messages.addGlobalInfo("Pessoa editada com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar editar a Pessoa. ");
			ex.printStackTrace();
		}
	}

}
