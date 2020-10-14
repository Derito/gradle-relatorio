package gradle.relatorio.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

import gradle.relatorio.dao.AnciaoDAO;
import gradle.relatorio.dao.PessoaDAO;
import gradle.relatorio.dao.PublicadorDAO;
import gradle.relatorio.domain.Anciao;
import gradle.relatorio.domain.Pessoa;
import gradle.relatorio.domain.Publicador;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AnciaoBean implements Serializable {

	private Anciao anciao;
	private List<Anciao> anciaos;
	// Para carregar a lista de paises na tela
	private List<Publicador> publicadores;
	private List<Pessoa> pessoas;
		
	public Anciao getAnciao() {
		return anciao;
	}

	public void setAnciao(Anciao anciao) {
		this.anciao = anciao;
	}

	public List<Anciao> getAnciaos() {
		return anciaos;
	}

	public void setAnciaos(List<Anciao> anciaos) {
		this.anciaos = anciaos;
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

	public void salvar() {

		try {
			AnciaoDAO ancDAO = new AnciaoDAO();
			ancDAO.merge(anciao);

			anciao = new Anciao();

			PublicadorDAO pubDAO = new PublicadorDAO();
			pubDAO.listar();
			
			PessoaDAO pesDAO = new PessoaDAO();
			pesDAO.listar();
						
			anciaos = ancDAO.listar();

			Messages.addGlobalInfo("Operação realizada com sucesso.");

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar salvar um Anciao. " + ex);
			ex.printStackTrace();
		}
	}

	// Metodo responsavel por popular na view os paises
	@PostConstruct // chama o metodo ao criar o bean e ao abrir a view
	public void listar() {
		try {
			AnciaoDAO ancDAO = new AnciaoDAO();
			anciaos = ancDAO.listar();

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar listar os Anciaos. ");
			ex.printStackTrace();
		}
	}

	public void novo() {
		try {
			anciao = new Anciao();
			PublicadorDAO pubDAO = new PublicadorDAO();
			// Necessidade de try porque trabalha com o BD e pode gerar erro
			publicadores = pubDAO.listar();
			PessoaDAO pesDAO = new PessoaDAO();
			pessoas = pesDAO.listar();
						
		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar gerar um novo Anciao. ");
			ex.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			anciao = (Anciao) evento.getComponent().getAttributes().get("anciaoSeleccionado");

			AnciaoDAO ancDAO = new AnciaoDAO();
			ancDAO.excluir(anciao);
			
			anciaos = ancDAO.listar();

			Messages.addGlobalInfo("Anciao excluido com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar excluir o Anciao. ");
			ex.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			anciao = (Anciao) evento.getComponent().getAttributes().get("anciaoSeleccionado");

			AnciaoDAO ancDAO = new AnciaoDAO();
			ancDAO.editar(anciao);

			PublicadorDAO pubDAO = new PublicadorDAO();
			publicadores = pubDAO.listar();
			
			PessoaDAO pesDAO = new PessoaDAO();
			pessoas = pesDAO.listar();
			
			anciaos = ancDAO.listar();
			
			Messages.addGlobalInfo("Anciao editado com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar editar o Anciao. ");
			ex.printStackTrace();
		}
	}

}
