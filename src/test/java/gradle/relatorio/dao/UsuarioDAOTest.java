package gradle.relatorio.dao;

import java.text.ParseException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import gradle.relatorio.domain.Publicador;
import gradle.relatorio.domain.Usuario;


public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {
		
		Long codigoC = 14L;
		PublicadorDAO pubDAO = new PublicadorDAO();
		Publicador pub = pubDAO.buscar(codigoC);
		
		if (pub == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			Usuario uso = new Usuario();
			uso.setPublicador(pub);
			uso.setSenha("1234");
			uso.setTipo('A');
			uso.setActivo(true);
																		
			UsuarioDAO usoDAO = new UsuarioDAO();
			usoDAO.salvar(uso);
			
			System.out.println("Registo salvo no BD ");
			System.out.println(uso.getCodigo() + " \nNome - " + uso.getPublicador().getPessoa().getNomePessoa() + " \nSenha - " + uso.getSenha()+" \nTipo - "+ uso.getTipo()+" \nActivo - "+ uso.isActivo());
		}
		
	}

	@Test
	@Ignore
	public void listar() {
		UsuarioDAO usoDAO = new UsuarioDAO();
		List<Usuario> lista = usoDAO.listar();

		for (Usuario uso : lista) {
			System.out.println(uso.getCodigo() + " \nNome - " + uso.getPublicador().getPessoa().getNomePessoa() + " \nSenha - " + uso.getSenha()+" \nTipo - "+ uso.getTipo()+" \nActivo - "+ uso.isActivo());
		}
		System.out.println("Total de registos no BD - " + lista.size());
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo =28L;
		UsuarioDAO usoDAO = new UsuarioDAO();
		Usuario uso = usoDAO.buscar(codigo);

		if (uso == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			System.out.println("Registo encontrado no BD ");
			System.out.println(uso.getCodigo() + " \nNome - " + uso.getPublicador().getPessoa().getNomePessoa() + " \nSenha - " + uso.getSenha()+" \nTipo - "+ uso.getTipo()+" \nActivo - "+ uso.isActivo());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo =27L;
		UsuarioDAO usoDAO = new UsuarioDAO();
		Usuario uso = usoDAO.buscar(codigo);

		if (uso == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			usoDAO.excluir(uso);
			System.out.println("Registo excluido do BD ");
			System.out.println(uso.getCodigo() + " \nNome - " + uso.getPublicador().getPessoa().getNomePessoa() + " \nSenha - " + uso.getSenha()+" \nTipo - "+ uso.getTipo()+" \nActivo - "+ uso.isActivo());
		}
	}

	@Test
	@Ignore
	public void editar() throws ParseException {
		Long codigo =26L;
		UsuarioDAO usoDAO = new UsuarioDAO();
		Usuario uso = usoDAO.buscar(codigo);
				
		Long codigoP =14L;
		PublicadorDAO pubDAO = new PublicadorDAO();
		Publicador pub = pubDAO.buscar(codigoP);
		
		if (uso == null || pub == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			uso.setActivo(false);
			uso.setSenha("12345");
			uso.setTipo('S');
			uso.setPublicador(pub);
									
			usoDAO.editar(uso);
			System.out.println("Registo editado com sucesso ");
			System.out.println(uso.getCodigo() + " \nNome - " + uso.getPublicador().getPessoa().getNomePessoa() + " \nSenha - " + uso.getSenha()+" \nTipo - "+ uso.getTipo()+" \nActivo - "+ uso.isActivo());
		}
	}
}
