package gradle.relatorio.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

import gradle.relatorio.dao.PessoaDAO;
import gradle.relatorio.dao.PublicadorDAO;
import gradle.relatorio.dao.UsuarioDAO;
import gradle.relatorio.domain.Pessoa;
import gradle.relatorio.domain.Publicador;
import gradle.relatorio.domain.Usuario;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private Usuario usuario;
	private List<Usuario> usuarios;
	// Para carregar a lista de paises na tela
	private List<Publicador> publicadores;
	private List<Pessoa> pessoas;
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.merge(usuario);

			usuario = new Usuario();

			PessoaDAO pesDAO = new PessoaDAO();
			pessoas = pesDAO.listar();
			
			PublicadorDAO pubDAO = new PublicadorDAO();
			publicadores = pubDAO.listar();

			usuarios = usuDAO.listar();

			Messages.addGlobalInfo("Operação realizada com sucesso.");

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar salvar um Usuário. " + ex);
			ex.printStackTrace();
		}
	}

	// Metodo responsavel por popular na view os paises
	@PostConstruct // chama o metodo ao criar o bean e ao abrir a view
	public void listar() {
		try {
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuarios = usuDAO.listar();

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar listar os usuarios. ");
			ex.printStackTrace();
		}
	}

	public void novo() {
		try {
			usuario = new Usuario();
			PessoaDAO pesDAO = new PessoaDAO();
			// Necessidade de try porque trabalha com o BD e pode gerar erro
			pessoas = pesDAO.listar();
			
			PublicadorDAO pubDAO = new PublicadorDAO();
			publicadores = pubDAO.listar();
			
		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar gerar um novo Usuario. ");
			ex.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSeleccionado");

			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.excluir(usuario);
			
			usuarios = usuDAO.listar();

			Messages.addGlobalInfo("Usuário excluido com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar excluir o Usuário. ");
			ex.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSeleccionado");

			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.editar(usuario);

			PessoaDAO pesDAO = new PessoaDAO();
			pessoas = pesDAO.listar();

			PublicadorDAO pubDAO = new PublicadorDAO();
			publicadores = pubDAO.listar();
			
			publicadores = pubDAO.listar();
			
			Messages.addGlobalInfo("Usuario editado com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar editar o Publicador. ");
			ex.printStackTrace();
		}
	}

}
