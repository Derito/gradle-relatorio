package gradle.relatorio.dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import gradle.relatorio.domain.Cidade;
import gradle.relatorio.domain.Endereco;


public class EnderecoDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigo = 5L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if (cidade == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			Endereco endereco = new Endereco();
			endereco.setRua("Rua C");
			endereco.setBairro("Soba Kapassa");
			endereco.setCelular("+2449981234567");
			endereco.setEmail("fulanocsta@hotmail.com");
			endereco.setNumCasa("C-95");
			endereco.setTelefone("2344488");
			endereco.setCidade(cidade);
						
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			enderecoDAO.salvar(endereco);
			
			System.out.println("Registo salvo no BD ");
			System.out.println(endereco.getCodigo() + " \nBairro - " + endereco.getBairro() + " \nCidade - " + endereco.getCidade().getNomeDaCidade()+ " \nPais - " + endereco.getCidade().getPais().getNomeDoPais());
		}
		
	}

	@Test
	@Ignore
	public void listar() {
		EnderecoDAO endDAO = new EnderecoDAO();
		List<Endereco> lista = endDAO.listar();

		for (Endereco end : lista) {
			System.out.println(end.getCodigo() + "-" + end.getBairro()+ "-" + end.getRua() +" - "+end.getCidade().getNomeDaCidade()+" - "+ end.getCidade().getPais().getNomeDoPais());
		}
		System.out.println("Total de registos no BD - " + lista.size());
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;
		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco end = endDAO.buscar(codigo);

		if (end == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			System.out.println("Registo encontrado no BD ");
			System.out.println(end.getCodigo() + "-" + end.getBairro() + "-" +end.getCidade().getNomeDaCidade() + "-" + end.getCidade().getPais().getNomeDoPais() +" - "+end.getCidade().getPais().getSiglaDoPais());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 1L;
		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco end = endDAO.buscar(codigo);

		if (end == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			endDAO.excluir(end);
			System.out.println("Registo excluido do BD ");
			System.out.println(end.getCodigo() + "-" + end.getBairro() + "-" +end.getCidade().getNomeDaCidade() + "-" + end.getCidade().getPais().getNomeDoPais() +" - "+end.getCidade().getPais().getSiglaDoPais());
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 2L;
		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco end = endDAO.buscar(codigo);
		
		Long codigoC = 5L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoC);
		
		if (end == null || cidade == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			end.setBairro("Kingandu 4");
			end.setCidade(cidade);
			
			endDAO.editar(end);
			System.out.println("Registo editado com sucesso ");
			System.out.println(end.getCodigo() + "-" + end.getBairro() + "-" +end.getCidade().getNomeDaCidade() + "-" + end.getCidade().getPais().getNomeDoPais() +" - "+end.getCidade().getPais().getSiglaDoPais());
		}
	}
}
