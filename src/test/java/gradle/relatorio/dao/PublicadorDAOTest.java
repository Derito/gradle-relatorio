package gradle.relatorio.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import gradle.relatorio.domain.Pessoa;
import gradle.relatorio.domain.Publicador;


public class PublicadorDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		Long codigo = 5L;
		PessoaDAO pesDAO = new PessoaDAO();
		Pessoa pes = pesDAO.buscar(codigo);
						
		if (pes == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			Publicador pub = new Publicador();
			pub.setPessoa(pes);			
			pub.setInicioPublicador(new SimpleDateFormat("dd/MM/yyyy").parse("22/02/1979"));
												
			PublicadorDAO pubDAO = new PublicadorDAO();
			pubDAO.salvar(pub);
			
			System.out.println("Registo salvo no BD ");
			System.out.println(pub.getCodigo() + " \nNome - " + pub.getPessoa().getNomePessoa() + " \nData - "+ pub.getInicioPublicador());
		}
		
	}

	@Test
	@Ignore
	public void listar() {
		PublicadorDAO pubDAO = new PublicadorDAO();
		List<Publicador> lista = pubDAO.listar();

		for (Publicador pub : lista) {
			System.out.println(pub.getCodigo() + " \nNome - " + pub.getPessoa().getNomePessoa() + " \nData - "+ pub.getInicioPublicador());
		}
		System.out.println("Total de registos no BD - " + lista.size());
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo =11L;
		PublicadorDAO pubDAO = new PublicadorDAO();
		Publicador pub = pubDAO.buscar(codigo);

		if (pub == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			System.out.println("Registo encontrado no BD ");
			System.out.println(pub.getCodigo() + " \nNome - " + pub.getPessoa().getNomePessoa() + " \nData - "+ pub.getInicioPublicador());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo =11L;
		PublicadorDAO pubDAO = new PublicadorDAO();
		Publicador pub = pubDAO.buscar(codigo);

		if (pub == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			pubDAO.excluir(pub);
			System.out.println("Registo excluido do BD ");
			System.out.println(pub.getCodigo() + " \nNome - " + pub.getPessoa().getNomePessoa() + " \nData - "+ pub.getInicioPublicador());
		}
	}

	@Test
	@Ignore
	public void editar() throws ParseException {
		Long codigo = 6L;
		PessoaDAO pesDAO = new PessoaDAO();
		Pessoa pes = pesDAO.buscar(codigo);
		
		Long codigoP =14L;
		PublicadorDAO pubDAO = new PublicadorDAO();
		Publicador pub = pubDAO.buscar(codigoP);
		
		if (pes == null || pub == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			pub.setInicioPublicador(new SimpleDateFormat("dd/MM/yyyy").parse("15/07/1988"));			
			pub.setPessoa(pes);
						
			pubDAO.editar(pub);
			System.out.println("Registo editado com sucesso ");
			System.out.println(pub.getCodigo() + " \nNome - " + pub.getPessoa().getNomePessoa() +" \nData - "+ pub.getInicioPublicador());
		}
	}
}
