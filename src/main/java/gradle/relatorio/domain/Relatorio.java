package gradle.relatorio.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "relatorio")
public class Relatorio extends GenericDomain {

	@Column(name = "rel_tipo_form", length = 10)
	private String tipoFormulario;
	@Column(name = "rel_mes")
	@Temporal(TemporalType.DATE)
	private Date mes;
	@Column(name = "rel_dia_horas")
	@Temporal(TemporalType.TIME)
	private Date horaDia;
	@Column(name = "rel_mes_horas", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date totHoraMes;
	@Column(name = "rel_tot_horas", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date TotalHoras;
	@Column(name = "rel_dia_revistas")
	private Integer revistaDia;
	@Column(name = "rel_mes_revistas")
	private Integer totRevistaMes;
	@Column(name = "rel_tot_revistas")
	private Integer TotalRevistas;
	@Column(name = "rel_dia_videos")
	private Integer videoDia;
	@Column(name = "rel_mes_videos")
	private Integer totVideoMes;
	@Column(name = "rel_tot_videos")
	private Integer TotalVideos;
	@Column(name = "rel_dia_revisitas")
	private Integer revisitaDia;
	@Column(name = "rel_mes_revisitas")
	private Integer totRevisitaMes;
	@Column(name = "rel_tot_revisitas")
	private Integer TotalRevisitas;
	@Column(name = "rel_dia_estudos")
	private Integer estudoDia;
	@Column(name = "rel_mes_estudos")
	private Integer totEstudoMes;
	@Column(name = "rel_tot_estudos")
	private Integer TotalEstudos;
	@Column(name = "rel_dia_folhetos")
	private Integer folhetosDia;
	@Column(name = "rel_mes_folhetos")
	private Integer totFolhetosMes;
	@Column(name = "rel_tot_folhetos")
	private Integer TotalFolhetos;
	@Column(name = "rel_observacao", length = 100)
	private String observacoes;
	
	public String getTipoFormulario() {
		return tipoFormulario;
	}

	public void setTipoFormulario(String tipoFormulario) {
		this.tipoFormulario = tipoFormulario;
	}

	public Date getMes() {
		return mes;
	}

	public void setMes(Date mes) {
		this.mes = mes;
	}

	public Date getHoraDia() {
		return horaDia;
	}

	public void setHoraDia(Date horaDia) {
		this.horaDia = horaDia;
	}

	public Date getTotHoraMes() {
		return totHoraMes;
	}

	public void setTotHoraMes(Date totHoraMes) {
		this.totHoraMes = totHoraMes;
	}

	public Date getTotalHoras() {
		return TotalHoras;
	}

	public void setTotalHoras(Date totalHoras) {
		TotalHoras = totalHoras;
	}

	public Integer getRevistaDia() {
		return revistaDia;
	}

	public void setRevistaDia(Integer revistaDia) {
		this.revistaDia = revistaDia;
	}

	public Integer getTotRevistaMes() {
		return totRevistaMes;
	}

	public void setTotRevistaMes(Integer totRevistaMes) {
		this.totRevistaMes = totRevistaMes;
	}

	public Integer getTotalRevistas() {
		return TotalRevistas;
	}

	public void setTotalRevistas(Integer totalRevistas) {
		TotalRevistas = totalRevistas;
	}

	public Integer getVideoDia() {
		return videoDia;
	}

	public void setVideoDia(Integer videoDia) {
		this.videoDia = videoDia;
	}

	public Integer getTotVideoMes() {
		return totVideoMes;
	}

	public void setTotVideoMes(Integer totVideoMes) {
		this.totVideoMes = totVideoMes;
	}

	public Integer getTotalVideos() {
		return TotalVideos;
	}

	public void setTotalVideos(Integer totalVideos) {
		TotalVideos = totalVideos;
	}

	public Integer getRevisitaDia() {
		return revisitaDia;
	}

	public void setRevisitaDia(Integer revisitaDia) {
		this.revisitaDia = revisitaDia;
	}

	public Integer getTotRevisitaMes() {
		return totRevisitaMes;
	}

	public void setTotRevisitaMes(Integer totRevisitaMes) {
		this.totRevisitaMes = totRevisitaMes;
	}

	public Integer getTotalRevisitas() {
		return TotalRevisitas;
	}

	public void setTotalRevisitas(Integer totalRevisitas) {
		TotalRevisitas = totalRevisitas;
	}

	public Integer getEstudoDia() {
		return estudoDia;
	}

	public void setEstudoDia(Integer estudoDia) {
		this.estudoDia = estudoDia;
	}

	public Integer getTotEstudoMes() {
		return totEstudoMes;
	}

	public void setTotEstudoMes(Integer totEstudoMes) {
		this.totEstudoMes = totEstudoMes;
	}

	public Integer getTotalEstudos() {
		return TotalEstudos;
	}

	public void setTotalEstudos(Integer totalEstudos) {
		TotalEstudos = totalEstudos;
	}

	public Integer getFolhetosDia() {
		return folhetosDia;
	}

	public void setFolhetosDia(Integer folhetosDia) {
		this.folhetosDia = folhetosDia;
	}

	public Integer getTotFolhetosMes() {
		return totFolhetosMes;
	}

	public void setTotFolhetosMes(Integer totFolhetosMes) {
		this.totFolhetosMes = totFolhetosMes;
	}

	public Integer getTotalFolhetos() {
		return TotalFolhetos;
	}

	public void setTotalFolhetos(Integer totalFolhetos) {
		TotalFolhetos = totalFolhetos;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}


}
