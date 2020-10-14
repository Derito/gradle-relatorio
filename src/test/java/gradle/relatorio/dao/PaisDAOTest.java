package gradle.relatorio.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import gradle.relatorio.domain.Pais;


public class PaisDAOTest {

	@Test
	@Ignore
	public void salvar() {

		PaisDAO paisDAO = new PaisDAO();
		Pais pais = new Pais();
		pais.setNomeDoPais("França");
		pais.setSiglaDoPais("FRA");

		paisDAO.salvar(pais);
	}

	@Test
	@Ignore
	public void listar() {
		PaisDAO paisDAO = new PaisDAO();
		List<Pais> lista = paisDAO.listar();

		for (Pais pais : lista) {
			System.out.println(pais.getCodigo() + "-" + pais.getNomeDoPais() + "-" + pais.getSiglaDoPais());
		}
		System.out.println("Total de registos no BD - " + lista.size());
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;
		PaisDAO paisDAO = new PaisDAO();

		Pais pais = paisDAO.buscar(codigo);

		if (pais == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			System.out.println("Registo encontrado no BD ");
			System.out.println(pais.getCodigo() + "- " + pais.getNomeDoPais() + "-" + pais.getSiglaDoPais());

		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;
		PaisDAO paisDAO = new PaisDAO();
		Pais pais = paisDAO.buscar(codigo);

		if (pais == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			paisDAO.excluir(pais);
			System.out.println("Registo excluido do BD ");

		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 4L;
		PaisDAO paisDAO = new PaisDAO();
		Pais pais = paisDAO.buscar(codigo);

		if (pais == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			pais.setNomeDoPais("Namibia");
			pais.setSiglaDoPais("NIB");
			paisDAO.editar(pais);
			System.out.println("Registo editado com sucesso ");
		}
	}

	@Test
	@Ignore
	public void merge() {
		// Salva um novo Pais
		/*
		 * Pais pais = new Pais(); pais.setNomeDoPais("França");
		 * pais.setSiglaDoPais("FRA"); PaisDAO paisDAO = new PaisDAO();
		 * paisDAO.merge(pais);
		 */
		// Edita um Pais existente
		PaisDAO paisDAO = new PaisDAO();
		Pais pais = paisDAO.buscar(4L);
		pais.setSiglaDoPais("NAM");
		paisDAO.merge(pais);

	}
}
