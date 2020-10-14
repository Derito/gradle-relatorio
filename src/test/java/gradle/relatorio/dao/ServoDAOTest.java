package gradle.relatorio.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import gradle.relatorio.domain.Publicador;
import gradle.relatorio.domain.Servo;


public class ServoDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {
		
		Long codigoC = 16L;
		PublicadorDAO pubDAO = new PublicadorDAO();
		Publicador pub = pubDAO.buscar(codigoC);
		
		if (pub == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			Servo ser = new Servo();
			ser.setPublicador(pub);
			ser.setDesignacaoServo("Servo de Literatura");
			ser.setInicioServo(new SimpleDateFormat("dd/MM/yyyy").parse("22/02/1979"));
															
			ServoDAO serDAO = new ServoDAO();
			serDAO.salvar(ser);
			
			System.out.println("Registo salvo no BD ");
			System.out.println(ser.getCodigo() + " \nNome - " + ser.getPublicador().getPessoa().getNomePessoa() + " \nDesignação - " + ser.getDesignacaoServo()+" \nData - "+ ser.getInicioServo());
		}
		
	}

	@Test
	@Ignore
	public void listar() {
		ServoDAO serDAO = new ServoDAO();
		List<Servo> lista = serDAO.listar();

		for (Servo ser : lista) {
			System.out.println(ser.getCodigo() + " \nNome - " + ser.getPublicador().getPessoa().getNomePessoa() + " \nDesignação - " + ser.getDesignacaoServo()+" \nData - "+ ser.getInicioServo());
		}
		System.out.println("Total de registos no BD - " + lista.size());
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo =19L;
		ServoDAO serDAO = new ServoDAO();
		Servo ser = serDAO.buscar(codigo);

		if (ser == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			System.out.println("Registo encontrado no BD ");
			System.out.println(ser.getCodigo() + " \nNome - " + ser.getPublicador().getPessoa().getNomePessoa() + " \nDesignação - " + ser.getDesignacaoServo()+" \nData - "+ ser.getInicioServo());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo =19L;
		ServoDAO serDAO = new ServoDAO();
		Servo ser = serDAO.buscar(codigo);

		if (ser == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			serDAO.excluir(ser);
			System.out.println("Registo excluido do BD ");
			System.out.println(ser.getCodigo() + " \nNome - " + ser.getPublicador().getPessoa().getNomePessoa() + " \nDesignação - " + ser.getDesignacaoServo()+" \nData - "+ ser.getInicioServo());
		}
	}

	@Test
	@Ignore
	public void editar() throws ParseException {
		Long codigo = 18L;
		ServoDAO serDAO = new ServoDAO();
		Servo ser = serDAO.buscar(codigo);
				
		Long codigoP =14L;
		PublicadorDAO pubDAO = new PublicadorDAO();
		Publicador pub = pubDAO.buscar(codigoP);
		
		if (ser == null || pub == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			ser.setDesignacaoServo("Servo do som");
			ser.setInicioServo(new SimpleDateFormat("dd/MM/yyyy").parse("18/07/1908"));
			ser.setPublicador(pub);
									
			serDAO.editar(ser);
			System.out.println("Registo editado com sucesso ");
			System.out.println(ser.getCodigo() + " \nNome - " + ser.getPublicador().getPessoa().getNomePessoa() + " \nDesignação - " + ser.getDesignacaoServo()+" \nData - "+ ser.getInicioServo());
		}
	}
}
