package gradle.relatorio.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import gradle.relatorio.domain.Publicador;
import gradle.relatorio.domain.Relatorio;


public class RelatorioDAOTest {

	@Test
    @Ignore
	public void salvar() throws ParseException {
		
		Long codigoC = 15L;
		PublicadorDAO pubDAO = new PublicadorDAO();
		Publicador pub = pubDAO.buscar(codigoC);
		
		if (pub == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			Relatorio rel = new Relatorio();
			rel.setTipoFormulario("wsss");			
			rel.setEstudoDia(1);
			rel.setTotEstudoMes(3);
			rel.setTotalEstudos(6);
			rel.setFolhetosDia(5);
			rel.setTotFolhetosMes(8);
			rel.setTotalFolhetos(10);
			rel.setRevisitaDia(2);
			rel.setTotRevisitaMes(2);
			rel.setTotalRevisitas(2);
			rel.setRevistaDia(2);
			rel.setTotRevistaMes(5);
			rel.setTotalRevistas(7);
			rel.setVideoDia(2);
			rel.setTotVideoMes(8);
			rel.setTotalVideos(7);
			rel.setMes(new SimpleDateFormat("dd/MM/yyyy").parse("21/09/2020"));
			rel.setHoraDia(new SimpleDateFormat("H:m:s").parse("2:30:0") );
			rel.setTotHoraMes(new SimpleDateFormat("H:m:s").parse("12:40:10"));
			rel.setTotalHoras(new SimpleDateFormat("H:m:s").parse("22:30:0"));
			rel.setObservacoes("Testando o registro de actividade de Campo ");
																							
			RelatorioDAO relDAO = new RelatorioDAO();
			relDAO.salvar(rel);
			
			System.out.println("Registo salvo no BD ");
			System.out.println(rel.getCodigo() +  " \nRevistas - " + rel.getTotalRevistas()
			+" \nHoras - "+ rel.getTotalHoras()+" \nObs - "+ rel.getObservacoes());
		}
		
	}

	@Test
	@Ignore
	public void listar() {
		RelatorioDAO relDAO = new RelatorioDAO();
		List<Relatorio> lista = relDAO.listar();

		for (Relatorio rel : lista) {
			System.out.println(rel.getCodigo() +  " \nRevistas - " + rel.getTotalRevistas()
			+" \nHoras - "+ rel.getTotalHoras()+" \nObs - "+ rel.getObservacoes());
		}
		System.out.println("Total de registos no BD - " + lista.size());
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo =33L;
		RelatorioDAO relDAO = new RelatorioDAO();
		Relatorio rel = relDAO.buscar(codigo);

		if (rel == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			System.out.println("Registo encontrado no BD ");
			System.out.println(rel.getCodigo() +  " \nRevistas - " + rel.getTotalRevistas()
			+" \nHoras - "+ rel.getTotalHoras()+" \nObs - "+ rel.getObservacoes());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo =34L;
		RelatorioDAO relDAO = new RelatorioDAO();
		Relatorio rel = relDAO.buscar(codigo);

		if (rel == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			relDAO.excluir(rel);
			System.out.println("Registo excluido do BD ");
			System.out.println(rel.getCodigo() +  " \nRevistas - " + rel.getTotalRevistas()
			+" \nHoras - "+ rel.getTotalHoras()+" \nObs - "+ rel.getObservacoes());
		}	
	}

	@Test
	@Ignore
	public void editar() throws ParseException {
		Long codigo =33L;
		RelatorioDAO relDAO = new RelatorioDAO();
		Relatorio rel = relDAO.buscar(codigo);
				
		Long codigoP =14L;
		PublicadorDAO pubDAO = new PublicadorDAO();
		Publicador pub = pubDAO.buscar(codigoP);
		
		if (rel == null || pub == null) {
			System.out.println("Nenhum registo encontrado no BD ");
		} else {
			rel.setMes(new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2020"));
												
			relDAO.editar(rel);
			System.out.println("Registo editado com sucesso ");
			System.out.println(rel.getCodigo()  +" \nRevistas - " + rel.getTotalRevistas()
			+" \nHoras - "+ rel.getTotalHoras()+" \nObs - "+ rel.getObservacoes());
		}	
	}
}
