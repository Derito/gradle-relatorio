package gradle.relatorio.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import gradle.relatorio.domain.Cidade;
import gradle.relatorio.domain.Pais;


public class CidadeDAOTest {

	@Test
	@Ignore
	public void salvar() {

		PaisDAO paisDAO = new PaisDAO();
		Pais pais = paisDAO.buscar(2L);
		
		if (pais == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			Cidade cidade = new Cidade();
			cidade.setNomeDaCidade("Benguela");
			cidade.setSiglaDaCidade("BUG");
			cidade.setPais(pais);
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.salvar(cidade);
			
			System.out.println("Registo salvo no BD ");
			System.out.println(cidade.getCodigo() + " \nNome - " + cidade.getNomeDaCidade() + " \nSigla - " + cidade.getSiglaDaCidade()+ " \nPais - " + cidade.getPais().getNomeDoPais());
		}
		
	}

	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> lista = cidadeDAO.listar();

		for (Cidade cidade : lista) {
			System.out.println(cidade.getCodigo() + "-" + cidade.getNomeDaCidade() + "-" + cidade.getSiglaDaCidade() +" - "+cidade.getPais().getNomeDoPais());
		}
		System.out.println("Total de registos no BD - " + lista.size());
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 8L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);

		if (cidade == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			System.out.println("Registo encontrado no BD ");
			System.out.println(cidade.getCodigo() + "-" + cidade.getNomeDaCidade() + "-" + cidade.getSiglaDaCidade() +" - "+cidade.getPais().getNomeDoPais());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 9L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);

		if (cidade == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			cidadeDAO.excluir(cidade);
			System.out.println("Registo excluido do BD ");
			System.out.println(cidade.getCodigo() + "-" + cidade.getNomeDaCidade() + "-" + cidade.getSiglaDaCidade() +" - "+cidade.getPais().getNomeDoPais());
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 11L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		Long codigop = 19L;
		PaisDAO paisDAO = new PaisDAO();
		Pais pais = paisDAO.buscar(codigop);

		if (cidade == null || pais == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			cidade.setNomeDaCidade("Namibe");
			cidade.setSiglaDaCidade("MSZ");
			cidade.setPais(pais);
			cidadeDAO.editar(cidade);
			System.out.println("Registo editado com sucesso ");
			System.out.println(cidade.getCodigo() + "-" + cidade.getNomeDaCidade() + "-" + cidade.getSiglaDaCidade() +" - "+cidade.getPais().getNomeDoPais());
		}
	}
}
