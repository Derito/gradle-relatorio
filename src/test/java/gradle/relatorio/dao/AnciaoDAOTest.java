package gradle.relatorio.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import gradle.relatorio.domain.Anciao;
import gradle.relatorio.domain.Publicador;


public class AnciaoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		
		Long codigoC = 15L;
		PublicadorDAO pubDAO = new PublicadorDAO();
		Publicador pub = pubDAO.buscar(codigoC);
		
		if (pub == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			Anciao anc = new Anciao();
			anc.setPublicador(pub);
			anc.setDesignacao("Ancião Sentinela");
			try {
				anc.setInicioAnciao(new SimpleDateFormat("dd/MM/yyyy").parse("02/09/1969"));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
															
			AnciaoDAO ancDAO = new AnciaoDAO();
			ancDAO.salvar(anc);
			
			System.out.println("Registo salvo no BD ");
			System.out.println(anc.getCodigo() + " \nNome - " + anc.getPublicador().getPessoa().getNomePessoa() + " \nDesignação - " + anc.getDesignacao()+" \nData - "+ anc.getInicioAnciao());
		}
		
	}

	@Test
	@Ignore
	public void listar() {
		AnciaoDAO ancDAO = new AnciaoDAO();
		List<Anciao> lista = ancDAO.listar();

		for (Anciao anc : lista) {
			System.out.println(anc.getCodigo() + " \nNome - " + anc.getPublicador().getPessoa().getNomePessoa() + " \nDesignação - " + anc.getDesignacao()+" \nData - "+ anc.getInicioAnciao());
		}
		System.out.println("Total de registos no BD - " + lista.size());
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo =22L;
		AnciaoDAO ancDAO = new AnciaoDAO();
		Anciao anc = ancDAO.buscar(codigo);

		if (anc == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			System.out.println("Registo encontrado no BD ");
			System.out.println(anc.getCodigo() + " \nNome - " + anc.getPublicador().getPessoa().getNomePessoa() + " \nDesignação - " + anc.getDesignacao()+" \nData - "+ anc.getInicioAnciao());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo =22L;
		AnciaoDAO ancDAO = new AnciaoDAO();
		Anciao anc = ancDAO.buscar(codigo);

		if (anc == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			ancDAO.excluir(anc);
			System.out.println("Registo excluido do BD ");
			System.out.println(anc.getCodigo() + " \nNome - " + anc.getPublicador().getPessoa().getNomePessoa() + " \nDesignação - " + anc.getDesignacao()+" \nData - "+ anc.getInicioAnciao());
		}
	}

	@Test
	@Ignore
	public void editar() throws ParseException {
		Long codigo =21L;
		AnciaoDAO ancDAO = new AnciaoDAO();
		Anciao anc = ancDAO.buscar(codigo);
				
		Long codigoP =14L;
		PublicadorDAO pubDAO = new PublicadorDAO();
		Publicador pub = pubDAO.buscar(codigoP);
		
		if (anc == null || pub == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			anc.setDesignacao("Ancião Serviço Campo");
			anc.setInicioAnciao(new SimpleDateFormat("dd/MM/yyyy").parse("11/07/2011"));
			anc.setPublicador(pub);
									
			ancDAO.editar(anc);
			System.out.println("Registo editado com sucesso ");
			System.out.println(anc.getCodigo() + " \nNome - " + anc.getPublicador().getPessoa().getNomePessoa() + " \nDesignação - " + anc.getDesignacao()+" \nData - "+ anc.getInicioAnciao());
		}
	}
}
