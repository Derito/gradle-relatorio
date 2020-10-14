package gradle.relatorio.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import gradle.relatorio.domain.Pioneiro;
import gradle.relatorio.domain.Publicador;


public class PioneiroDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {
		
		Long codigoC = 16L;
		PublicadorDAO pubDAO = new PublicadorDAO();
		Publicador pub = pubDAO.buscar(codigoC);
		
		if (pub == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			Pioneiro pio = new Pioneiro();
			pio.setPublicador(pub);
			pio.setAuxiliar(true);
			pio.setRegular(false);
			pio.setInicioPioneiro(new SimpleDateFormat("dd/MM/yyyy").parse("22/02/1979"));			
															
			PioneiroDAO pioDAO = new PioneiroDAO();
			pioDAO.salvar(pio);
			
			System.out.println("Registo salvo no BD ");
			System.out.println(pio.getCodigo() + " \nNome - " + pio.getPublicador().getPessoa().getNomePessoa() + " \nP. Auxiliar - " + pio.isAuxiliar()+" \nData - "+ pio.getInicioPioneiro());
		}
		
	}

	@Test
	@Ignore
	public void listar() {
		PioneiroDAO pioDAO = new PioneiroDAO();
		List<Pioneiro> lista = pioDAO.listar();

		for (Pioneiro pio : lista) {
			System.out.println(pio.getCodigo() + " \nNome - " + pio.getPublicador().getPessoa().getNomePessoa() + " \nP. Auxiliar - " + pio.isAuxiliar()+" \nData - "+ pio.getInicioPioneiro());
		}
		System.out.println("Total de registos no BD - " + lista.size());
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo =24L;
		PioneiroDAO pioDAO = new PioneiroDAO();
		Pioneiro pio = pioDAO.buscar(codigo);

		if (pio == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			System.out.println("Registo encontrado no BD ");
			System.out.println(pio.getCodigo() + " \nNome - " + pio.getPublicador().getPessoa().getNomePessoa() + " \nP. Auxiliar - " + pio.isAuxiliar()+" \nData - "+ pio.getInicioPioneiro());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo =24L;
		PioneiroDAO pioDAO = new PioneiroDAO();
		Pioneiro pio = pioDAO.buscar(codigo);

		if (pio == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			pioDAO.excluir(pio);
			System.out.println("Registo excluido do BD ");
			System.out.println(pio.getCodigo() + " \nNome - " + pio.getPublicador().getPessoa().getNomePessoa() + " \nP. Auxiliar - " + pio.isAuxiliar()+" \nData - "+ pio.getInicioPioneiro());
		}
	}

	@Test
	@Ignore
	public void editar() throws ParseException {
		Long codigo = 25L;
		PioneiroDAO pioDAO = new PioneiroDAO();
		Pioneiro pio = pioDAO.buscar(codigo);
				
		Long codigoP =14L;
		PublicadorDAO pubDAO = new PublicadorDAO();
		Publicador pub = pubDAO.buscar(codigoP);
		
		if (pio == null || pub == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			pio.setAuxiliar(false);
			pio.setRegular(true);
			pio.setInicioPioneiro(new SimpleDateFormat("dd/MM/yyyy").parse("18/07/1908"));
			pio.setPublicador(pub);
									
			pioDAO.editar(pio);
			System.out.println("Registo editado com sucesso ");
			System.out.println(pio.getCodigo() + " \nNome - " + pio.getPublicador().getPessoa().getNomePessoa() + " \nP. Auxiliar - " + pio.isAuxiliar()+" \nData - "+ pio.getInicioPioneiro());
		}
	}
}
