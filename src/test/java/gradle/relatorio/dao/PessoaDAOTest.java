package gradle.relatorio.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import gradle.relatorio.domain.Endereco;
import gradle.relatorio.domain.Pessoa;


public class PessoaDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigo = 2L;
		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco end = endDAO.buscar(codigo);
		
		if (end == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			Pessoa pes = new Pessoa();
			pes.setNomePessoa("Marco");
			pes.setNumBi("498kLA776");
			pes.setEndereco(end);
									
			PessoaDAO pesDAO = new PessoaDAO();
			pesDAO.salvar(pes);
			
			System.out.println("Registo salvo no BD ");
			System.out.println(pes.getCodigo() + " \nNome - " + pes.getNomePessoa() + " \nBi - " + pes.getNumBi()+ " \nPais - " + pes.getEndereco().getEmail());
		}
		
	}

	@Test
	@Ignore
	public void listar() {
		PessoaDAO pesDAO = new PessoaDAO();
		List<Pessoa> lista = pesDAO.listar();

		for (Pessoa pes : lista) {
			System.out.println(pes.getCodigo() + "\nNome - " + pes.getNomePessoa()+ "\nBI - " + pes.getNumBi() +" \nEmail - "+pes.getEndereco().getEmail()+" \nCelular -  "+ pes.getEndereco().getCelular());
		}
		System.out.println("Total de registos no BD - " + lista.size());
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 4L;
		PessoaDAO pesDAO = new PessoaDAO();
		Pessoa pes = pesDAO.buscar(codigo);

		if (pes == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			System.out.println("Registo encontrado no BD ");
			System.out.println(pes.getCodigo() + "\nNome - " + pes.getNomePessoa()+ "\nBI - " + pes.getNumBi() +" \nEmail - "+pes.getEndereco().getEmail()+" \nCelular -  "+ pes.getEndereco().getCelular());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;
		PessoaDAO pesDAO = new PessoaDAO();
		Pessoa pes = pesDAO.buscar(codigo);

		if (pes == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			pesDAO.excluir(pes);
			System.out.println("Registo excluido do BD ");
			System.out.println(pes.getCodigo() + "\nNome - " + pes.getNomePessoa()+ "\nBI - " + pes.getNumBi() +" \nEmail - "+pes.getEndereco().getEmail()+" \nCelular -  "+ pes.getEndereco().getCelular());
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 2L;
		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco end = endDAO.buscar(codigo);
		
		Long codigop = 5L;
		PessoaDAO pesDAO = new PessoaDAO();
		Pessoa pes = pesDAO.buscar(codigop);
		
		if (end == null || pes == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			pes.setNomePessoa("Marco António");
			pes.setEndereco(end);
			
			pesDAO.editar(pes);
			System.out.println("Registo editado com sucesso ");
			System.out.println(pes.getCodigo() + "\nNome - " + pes.getNomePessoa()+ "\nBI - " + pes.getNumBi() +" \nEmail - "+pes.getEndereco().getEmail()+" \nCelular -  "+ pes.getEndereco().getCelular());
		}
	}
}
