package gradle.relatorio.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import gradle.relatorio.dao.PublicadorDAO;
import gradle.relatorio.dao.RelatorioDAO;
import gradle.relatorio.domain.Publicador;
import gradle.relatorio.domain.Relatorio;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RelatorioBean implements Serializable {

	private Relatorio relatorio;
	private List<Relatorio> relatorios;
	// Para carregar a lista de paises na tela
	private List<Publicador> publicadores;

	public Relatorio getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}

	public List<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(List<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}

	public List<Publicador> getPublicadores() {
		return publicadores;
	}

	public void setPublicadores(List<Publicador> publicadores) {
		this.publicadores = publicadores;
	}

	public void salvar() {

		try {
			RelatorioDAO relDAO = new RelatorioDAO();
			relDAO.merge(relatorio);

			relatorio = new Relatorio();

			PublicadorDAO pubDAO = new PublicadorDAO();
			publicadores = pubDAO.listar();

			relatorios = relDAO.listar();

			Messages.addGlobalInfo("Operação realizada com sucesso.");

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar salvar o relatório. " + ex);
			ex.printStackTrace();
		}
	}

	// Metodo responsavel por popular na view os paises
	@PostConstruct // chama o metodo ao criar o bean e ao abrir a view
	public void listar() {
		try {
			RelatorioDAO relDAO = new RelatorioDAO();
			relatorios = relDAO.listar();

		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar listar os Relatórios. ");
			ex.printStackTrace();
		}
	}

	public void novo() {
		try {
			relatorio = new Relatorio();
			PublicadorDAO pubDAO = new PublicadorDAO();
			// Necessidade de try porque trabalha com o BD e pode gerar erro
			publicadores = pubDAO.listar();
		} catch (RuntimeException ex) {
			Messages.addFlashGlobalError("Erro ao tentar gerar um novo relatório. ");
			ex.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			relatorio = (Relatorio) evento.getComponent().getAttributes().get("relatorioSeleccionado");

			RelatorioDAO relDAO = new RelatorioDAO();
			relDAO.excluir(relatorio);
			
			relatorios = relDAO.listar();

			Messages.addGlobalInfo("Relatório excluido com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar excluir  relatório. ");
			ex.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {
		try {
			// Erro resolvido na view por retirar os parenteses do metodo.
			relatorio = (Relatorio) evento.getComponent().getAttributes().get("relatorioSeleccionado");

			RelatorioDAO relDAO = new RelatorioDAO();
			relDAO.editar(relatorio);

			//cidade = new Cidade();

			PublicadorDAO pubDAO = new PublicadorDAO();
			publicadores = pubDAO.listar();

			relatorios = relDAO.listar();
			Messages.addGlobalInfo("Relatório editado com sucesso. ");

		} catch (RuntimeException ex) {
			Messages.addGlobalError("Erro ao tentar editar o Relatório. ");
			ex.printStackTrace();
		}
	}

}
