package gradle.relatorio.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

import gradle.relatorio.dao.CongregacaoDAO;
import gradle.relatorio.dao.EnderecoDAO;
import gradle.relatorio.dao.PessoaDAO;
import gradle.relatorio.dao.PublicadorDAO;
import gradle.relatorio.domain.Congregacao;
import gradle.relatorio.domain.Endereco;
import gradle.relatorio.domain.Pessoa;
import gradle.relatorio.domain.Publicador;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PublicadorBean implements Serializable {

	private Publicador publicador;
	private List<Publicador> publicadores;
	// Para carregar a lista de paises na tela
	private List<Pessoa> pessoas;
	private List<Endereco> enderecos;
	private List<Congregacao> congregacoes;
	
	public Publicador getPublicador() {
		return publicador;
	}

	public void setPublicador(Publicador publicador) {
		this.publicador = publicador;
	}

	public List<Publicador> getPublicadores() {
		return publicadores;
	}

	public void setPublicadores(List<Publicador> publicadores) {
		this.publicadores = publicadores;
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

	public List<Congregacao> getCongregacoes() {
		return congregacoes;
	}

	public void setCongregacoes(List<Congregacao> congregacoes) {
		this.congregacoes = congregacoes;
	}

	public void salvar() {

		try {
			PublicadorDAO pubDAO = new PublicadorDAO();
			pubDAO.merge(publicador);

			publicador = new Publicador();

			PessoaDAO pesDAO = new PessoaDAO();
			pessoas = pesDAO.listar();
			
			EnderecoDAO endDAO = new EnderecoDAO();
			enderecos = endDAO.listar();
			
			CongregacaoDAO congDAO = new CongregacaoDAO();
			congregacoes = congDAO.listar();

			publicadores = pubDAO.listar();

			Messages.addGlobalInfo("Operação realizada com sucesso.");

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar salvar um Publicador. " + ex);
			ex.printStackTrace();
		}
	}

	// Metodo responsavel por popular na view os paises
	@PostConstruct // chama o metodo ao criar o bean e ao abrir a view
	public void listar() {
		try {
			PublicadorDAO pubDAO = new PublicadorDAO();
			publicadores = pubDAO.listar();

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar listar os publicadores. ");
			ex.printStackTrace();
		}
	}

	public void novo() {
		try {
			publicador = new Publicador();
			PessoaDAO pesDAO = new PessoaDAO();
			// Necessidade de try porque trabalha com o BD e pode gerar erro
			pessoas = pesDAO.listar();
			
			EnderecoDAO endDAO = new EnderecoDAO();
			enderecos = endDAO.listar();
			
			CongregacaoDAO congDAO = new CongregacaoDAO();
			congregacoes = congDAO.listar();
			
		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar gerar um novo Publicador. ");
			ex.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			publicador = (Publicador) evento.getComponent().getAttributes().get("publicadorSeleccionado");

			PublicadorDAO pubDAO = new PublicadorDAO();
			pubDAO.excluir(publicador);
			
			publicadores = pubDAO.listar();

			Messages.addGlobalInfo("Publicador excluido com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar excluir o Publicador. ");
			ex.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			publicador = (Publicador) evento.getComponent().getAttributes().get("publicadorSeleccionado");

			PublicadorDAO pubDAO = new PublicadorDAO();
			pubDAO.editar(publicador);

			PessoaDAO pesDAO = new PessoaDAO();
			pessoas = pesDAO.listar();
			
			EnderecoDAO endDAO = new EnderecoDAO();
			enderecos = endDAO.listar();

			CongregacaoDAO congDAO = new CongregacaoDAO();
			congregacoes = congDAO.listar();
			
			publicadores = pubDAO.listar();
			
			Messages.addGlobalInfo("Publicador editado com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar editar o Publicador. ");
			ex.printStackTrace();
		}
	}

}
