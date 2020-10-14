package gradle.relatorio.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import gradle.relatorio.domain.Congregacao;
import gradle.relatorio.domain.Endereco;


public class CongregacaoDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigo = 2L;
		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco end = endDAO.buscar(codigo);
		
		if (end == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			Congregacao cong = new Congregacao();
			cong.setNomeDaCongregacao("Vila Estoril 15");
			cong.setEndereco(end);
												
			CongregacaoDAO congDAO = new CongregacaoDAO();
			congDAO.salvar(cong);
			
			System.out.println("Registo salvo no BD ");
			System.out.println(cong.getCodigo() + " \nNome - " + cong.getNomeDaCongregacao() + " \nPais - " + cong.getEndereco().getCidade().getNomeDaCidade());
		}
		
	}

	@Test
	@Ignore
	public void listar() {
		CongregacaoDAO congDAO = new CongregacaoDAO();
		List<Congregacao> lista = congDAO.listar();

		for (Congregacao cong : lista) {
			System.out.println(cong.getCodigo() + " \nNome - " + cong.getNomeDaCongregacao() + " \nCidade - " + cong.getEndereco().getCidade().getNomeDaCidade());
		}
		System.out.println("Total de registos no BD - " + lista.size());
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 7L;
		CongregacaoDAO congDAO = new CongregacaoDAO();
		Congregacao cong = congDAO.buscar(codigo);

		if (cong == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			System.out.println("Registo encontrado no BD ");
			System.out.println(cong.getCodigo() + " \nNome - " + cong.getNomeDaCongregacao() + " \nCidade - " + cong.getEndereco().getCidade().getNomeDaCidade());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 8L;
		CongregacaoDAO congDAO = new CongregacaoDAO();
		Congregacao cong = congDAO.buscar(codigo);

		if (cong == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			congDAO.excluir(cong);
			System.out.println("Registo excluido do BD ");
			System.out.println(cong.getCodigo() + " \nNome - " + cong.getNomeDaCongregacao() + " \nCidade - " + cong.getEndereco().getCidade().getNomeDaCidade());
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 2L;
		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco end = endDAO.buscar(codigo);
		
		Long codigop = 9L;
		CongregacaoDAO congDAO = new CongregacaoDAO();
		Congregacao cong = congDAO.buscar(codigop);
		
		if (end == null || cong == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			cong.setNomeDaCongregacao("Terra Nova Norte");
			cong.setEndereco(end);
			
			congDAO.editar(cong);
			System.out.println("Registo editado com sucesso ");
			System.out.println(cong.getCodigo() + " \nNome - " + cong.getNomeDaCongregacao() + " \nCidade - " + cong.getEndereco().getCidade().getNomeDaCidade());
		}
	}
}
