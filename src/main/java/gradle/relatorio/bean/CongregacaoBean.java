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
import gradle.relatorio.domain.Congregacao;
import gradle.relatorio.domain.Endereco;
import gradle.relatorio.domain.Publicador;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CongregacaoBean implements Serializable {

	private Congregacao congregacao;
	private List<Congregacao> congregacoes;
	// Para carregar a lista de paises na tela
	private List<Endereco> enderecos;
	private List<Publicador> publicadores;

	public Congregacao getCongregacao() {
		return congregacao;
	}

	public void setCongregacao(Congregacao congregacao) {
		this.congregacao = congregacao;
	}

	public List<Congregacao> getCongregacoes() {
		return congregacoes;
	}

	public void setCongregacoes(List<Congregacao> congregacoes) {
		this.congregacoes = congregacoes;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Publicador> getPublicadores() {
		return publicadores;
	}

	public void setPublicadores(List<Publicador> publicadores) {
		this.publicadores = publicadores;
	}

	public void salvar() {

		try {
			CongregacaoDAO congDAO = new CongregacaoDAO();
			congDAO.merge(congregacao);

			congregacao = new Congregacao();

			EnderecoDAO endDAO = new EnderecoDAO();
			enderecos = endDAO.listar();

			congregacoes = congDAO.listar();

			Messages.addGlobalInfo("Operação realizada com sucesso.");

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar salvar a congregação. " + ex);
			ex.printStackTrace();
		}
	}

	// Metodo responsavel por popular na view os paises
	@PostConstruct // chama o metodo ao criar o bean e ao abrir a view
	public void listar() {
		try {
			CongregacaoDAO congDAO = new CongregacaoDAO();
			congregacoes = congDAO.listar();

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar listar as congregações. ");
			ex.printStackTrace();
		}
	}

	public void novo() {
		try {
			congregacao = new Congregacao();
			EnderecoDAO endDAO = new EnderecoDAO();
			// Necessidade de try porque trabalha com o BD e pode gerar erro
			enderecos = endDAO.listar();
		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar gerar um novo endereço. ");
			ex.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			congregacao = (Congregacao) evento.getComponent().getAttributes().get("cidadeSeleccionada");

			CongregacaoDAO congDAO = new CongregacaoDAO();
			congDAO.excluir(congregacao);
			
			congregacoes = congDAO.listar();

			Messages.addGlobalInfo("Congregação excluida com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar excluir a Congregação. ");
			ex.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			congregacao = (Congregacao) evento.getComponent().getAttributes().get("congregacaoSeleccionada");

			CongregacaoDAO congDAO = new CongregacaoDAO();
			congDAO.editar(congregacao);

			//cidade = new Cidade();

			EnderecoDAO endDAO = new EnderecoDAO();
			enderecos = endDAO.listar();

			congregacoes = congDAO.listar();
			Messages.addGlobalInfo("Congregação editada com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar editar a Congregação. ");
			ex.printStackTrace();
		}
	}

}
