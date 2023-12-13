package com.santanatextiles.cpf.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CPFD4_DBF",schema="CPF")
@IdClass(ProducaoFiacaoId.class)

public class ProducaoFiacao implements Serializable{
	
	private static final long serialVersionUID = 1L;	 
	 
	@Id
	@Column(name="IDFIL")
	private String  idfil	; 
	
	@Id  
	@Column(name="D4COD") 
	private String codigoMaquina	;

	
	@Id
	@Column(name="D4TURNO")	
	private String  turno;	
	
	
	@Id
	@Column(name="D4DATA")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date dataProducao; 	
	
	@Id
	@Column(name="D4LADO")
	private String lado	;
	
	@Id
	@Column(name="D4HRINI")
	private Integer horaInicio	; 	 
	
	@Id
	@Column(name="D4ID")	
	private Integer idSSM	;	
	
	@Column(name="D4HRFIM")
	private Integer horaFinal	;	
	
	@Column(name="D4ITEM")
	private String item;
	
	@Column(name="D4PROD")
	private Double qtdeProduzida;	
	
	@Column(name="D4EFIC")
	private Double eficiencia ;
	
	@Column(name="D4KGHR")
	private Double quilosHora;
	
	@Column(name="C4CDABER")
	private String codigoAbertura	;
	
	@Column(name="D4LOTE")
	private String loteProducao	;
	
	@Column(name="D4TITULO")
	private String tituloCadastro; 
	
	@Column(name="D4FORPOLIE")
	private String cdFornecPoliester;
	
	@Column(name="D4FORELAST")
	private String cdFornecElastano;
	
	@Column(name="D4LOTEPOLI")
	private String lotePoliester;

	@Column(name="D4LOTEELAS")
	private String loteElastano;
	
	@Column(name="D4COR")	
	private String cor;
	
	@Column(name="D4VELOC")	
	private Double rpm	;
	
	@Column(name="D4NUMFUS")	
	private Double numeroFusos	;
	
	@Column(name="D4NUMRUP")	
	private Double numRupturas	;
	
	@Column(name="D4METR")	
	private Double metragem	;  
	
	@Column(name="D4NUMTRC")	
	private Double numeroTrocas	;
	
	@Column(name="D4TRCFIO")
	private String ehTroca	;
	
	@Column(name="D4HRTRFI")	
	private Integer horaInicialTrocaFio;
	
	@Column(name="D4HRTRFF")	
	private Integer horaFinalTrocaFio;
	
	@Column(name="D4NMFORE")
	private String nomeFornElastano	;
	
	@Column(name="D4NMFORP")
	private String nomeFornPoliester	;
	
	@Column(name="D4NUMSER")
	private String numeroSerie	;
	
	@Column(name="D4LOCAL")
	private String localFisico	;
	
	@Column(name="D4REPR")
	private String ehReprocesso;
	
	@Column(name="D4OBS")
	private String obs	;
	
	@Column(name="D4ALFA")
	private Double alfaTorcao	;
	
	@Column(name="D4TPM")
	private Double TPM	;
	
	@Column(name="D4TIT")
	private Double tituloNominal	;
	
	@Column(name="D4OPER")
	private String operador	;
	
	@Column(name="D4RPMCAR")
	private Double rpmCAR	;
	
	@Column(name="D4PTON")
	private Double PTON	;
	
	@Column(name="D4PTOS")
	private Double PTOS	;
	
	@Column(name="D4PTOL")
	private Double PTOL	;
	
	@Column(name="D4PTOF")
	private Double PTOF	;
	
	@Column(name="D4MO")
	private Double MO	;
	
	@Column(name="D4CPVSL")
	private Double CPVSL	;
	
	@Column(name="D4CMVSL")
	private Double CMVSL	;
	
	@Column(name="D4CCPC")
	private Double CCPC	;
	
	@Column(name="D4CCMC")
	private Double CCMC	;
	
	@Column(name="D4JP")
	private Double JP	;
	
	@Column(name="D4JM")
	private Double JM	;
	
	@Column(name="D4CVP")
	private Double CVP	;
	
	@Column(name="D4CVM")
	private Double CVM	;
	
	@Column(name="D4PROB1")
	private Double PROB1	;
	
	@Column(name="D4PROB2")
	private Double PROB2  ;
	
	@Column(name="D4PROB3")
	private Double PROB3	;
	
	@Column(name="D4TBOB")
	private Double tensaoBobina	;
	
	@Column(name="D4CNAT")
	private Double cnat	;
	
	@Column(name="D4PRDTUR")
	private Double prdtur	;
	
	@Column(name="D4TITFT")
	private Double tituloReal	;   
	
	@Column(name="D4ESTIRG")  
	private Double estiragem;
	
	@Column(name="D4QTFITA")
	private Integer qtdeFitas;
	
	@Column(name="D4D")   
	private Double d_percent;
	
	@Column(name="D4CV")  
	private Double cv;
	
	@Column(name="D4CVIN")
	private Double cvIn;
	
	@Column(name="D4PG")	
	private Double pg;
	
	@Column(name="D4A")   
	private Double a_percent;
	
	@Column(name="D4T25")   
	private Double t25;
	
	@Column(name="D4T20")
	private Double t20;
	
	@Column(name="D4T15")
	private Double t15;
	
    @Column(name="D4T125")
    private Double t125;
    
    @Column(name="D4T120")
    private Double t120;
    
	@Column(name="D4T115")
	private Double t115;
	
    @Column(name=" D4T225")
    private Double t225;
    
	@Column(name="D4T220")
	private Double t220;
	
	@Column(name="D4T215")    
	private Double t215;  
	 
	
	
 
	@ManyToOne 
	@JoinColumns({
	    @JoinColumn(name="IDFIL", referencedColumnName="IDFIL", insertable = false, updatable = false),
	    @JoinColumn(name="D4TURNO", referencedColumnName="K1CDTURN", insertable = false, updatable = false)
	})
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Turno  fkTurno;	
	
	
	@ManyToOne 
	@JoinColumns({
	    @JoinColumn(name="IDFIL", referencedColumnName="IDFIL", insertable = false, updatable = false),
	    @JoinColumn(name="D4COD", referencedColumnName="C3COD", insertable = false, updatable = false)
	})
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Maquina fkMaquina	;	
	
	public ProducaoFiacao() {
		
	}

	public ProducaoFiacao(String idfil, String codigoMaquina, String turno, Date dataProducao, String lado,
			Integer horaInicio, Integer horaFinal, String item, Double qtdeProduzida, Double eficiencia,
			Double quilosHora, String codigoAbertura, String loteProducao, String tituloCadastro,
			String cdFornecPoliester, String cdFornecElastano, String lotePoliester, String loteElastano, String cor,
			Double rpm, Double numeroFusos, Double numRupturas, Double metragem, Integer idSSM, Double numeroTrocas,
			String ehTroca, Integer horaInicialTrocaFio, Integer horaFinalTrocaFio, String nomeFornElastano,
			String nomeFornPoliester, String numeroSerie, String localFisico, String ehReprocesso, String obs,
			Double alfaTorcao, Double tPM, Double tituloNominal, String operador, Double rpmCAR, Double pTON,
			Double pTOS, Double pTOL, Double pTOF, Double mO, Double cPVSL, Double cMVSL, Double cCPC, Double cCMC,
			Double jP, Double jM, Double cVP, Double cVM, Double pROB1, Double pROB2, Double pROB3, Double tensaoBobina,
			Double cnat, Double prdtur, Double tituloReal) {
		super();
		this.idfil = idfil;
		this.codigoMaquina = codigoMaquina;
		this.turno = turno;
		this.dataProducao = dataProducao;
		this.lado = lado;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.item = item;
		this.qtdeProduzida = qtdeProduzida;
		this.eficiencia = eficiencia;
		this.quilosHora = quilosHora;
		this.codigoAbertura = codigoAbertura;
		this.loteProducao = loteProducao;
		this.tituloCadastro = tituloCadastro;
		this.cdFornecPoliester = cdFornecPoliester;
		this.cdFornecElastano = cdFornecElastano;
		this.lotePoliester = lotePoliester;
		this.loteElastano = loteElastano;
		this.cor = cor;
		this.rpm = rpm;
		this.numeroFusos = numeroFusos;
		this.numRupturas = numRupturas;
		this.metragem = metragem;
		this.idSSM = idSSM;
		this.numeroTrocas = numeroTrocas;
		this.ehTroca = ehTroca;
		this.horaInicialTrocaFio = horaInicialTrocaFio;
		this.horaFinalTrocaFio = horaFinalTrocaFio;
		this.nomeFornElastano = nomeFornElastano;
		this.nomeFornPoliester = nomeFornPoliester;
		this.numeroSerie = numeroSerie;
		this.localFisico = localFisico;
		this.ehReprocesso = ehReprocesso;
		this.obs = obs;
		this.alfaTorcao = alfaTorcao;
		TPM = tPM;
		this.tituloNominal = tituloNominal;
		this.operador = operador;
		this.rpmCAR = rpmCAR;
		PTON = pTON;
		PTOS = pTOS;
		PTOL = pTOL;
		PTOF = pTOF;
		MO = mO;
		CPVSL = cPVSL;
		CMVSL = cMVSL;
		CCPC = cCPC;
		CCMC = cCMC;
		JP = jP;
		JM = jM;
		CVP = cVP;
		CVM = cVM;
		PROB1 = pROB1;
		PROB2 = pROB2;
		PROB3 = pROB3;
		this.tensaoBobina = tensaoBobina;
		this.cnat = cnat;
		this.prdtur = prdtur;
		this.tituloReal = tituloReal;
	}
 
	
	
	public ProducaoFiacao(String idfil, String codigoMaquina, String turno, Date dataProducao, String lado,
			Integer horaInicio, Integer idSSM, Integer horaFinal, String item, Double qtdeProduzida, Double eficiencia,
			Double quilosHora, String codigoAbertura, String loteProducao, String tituloCadastro,
			String cdFornecPoliester, String cdFornecElastano, String lotePoliester, String loteElastano, String cor,
			Double rpm, Double numeroFusos, Double numRupturas, Double metragem, Double numeroTrocas, String ehTroca,
			Integer horaInicialTrocaFio, Integer horaFinalTrocaFio, String nomeFornElastano, String nomeFornPoliester,
			String numeroSerie, String localFisico, String ehReprocesso, String obs, Double alfaTorcao, Double tPM,
			Double tituloNominal, String operador, Double rpmCAR, Double pTON, Double pTOS, Double pTOL, Double pTOF,
			Double mO, Double cPVSL, Double cMVSL, Double cCPC, Double cCMC, Double jP, Double jM, Double cVP,
			Double cVM, Double pROB1, Double pROB2, Double pROB3, Double tensaoBobina, Double cnat, Double prdtur,
			Double tituloReal, Double estiragem, Integer qtdeFitas, Double d_percent, Double cv, Double cvIn, Double pg,
			Double a_percent, Double t25, Double t20, Double t15, Double t125, Double t120, Double t115, Double t225,
			Double t220, Double t215, Turno fkTurno, Maquina fkMaquina) {
		super();
		this.idfil = idfil;
		this.codigoMaquina = codigoMaquina;
		this.turno = turno;
		this.dataProducao = dataProducao;
		this.lado = lado;
		this.horaInicio = horaInicio;
		this.idSSM = idSSM;
		this.horaFinal = horaFinal;
		this.item = item;
		this.qtdeProduzida = qtdeProduzida;
		this.eficiencia = eficiencia;
		this.quilosHora = quilosHora;
		this.codigoAbertura = codigoAbertura;
		this.loteProducao = loteProducao;
		this.tituloCadastro = tituloCadastro;
		this.cdFornecPoliester = cdFornecPoliester;
		this.cdFornecElastano = cdFornecElastano;
		this.lotePoliester = lotePoliester;
		this.loteElastano = loteElastano;
		this.cor = cor;
		this.rpm = rpm;
		this.numeroFusos = numeroFusos;
		this.numRupturas = numRupturas;
		this.metragem = metragem;
		this.numeroTrocas = numeroTrocas;
		this.ehTroca = ehTroca;
		this.horaInicialTrocaFio = horaInicialTrocaFio;
		this.horaFinalTrocaFio = horaFinalTrocaFio;
		this.nomeFornElastano = nomeFornElastano;
		this.nomeFornPoliester = nomeFornPoliester;
		this.numeroSerie = numeroSerie;
		this.localFisico = localFisico;
		this.ehReprocesso = ehReprocesso;
		this.obs = obs;
		this.alfaTorcao = alfaTorcao;
		TPM = tPM;
		this.tituloNominal = tituloNominal;
		this.operador = operador;
		this.rpmCAR = rpmCAR;
		PTON = pTON;
		PTOS = pTOS;
		PTOL = pTOL;
		PTOF = pTOF;
		MO = mO;
		CPVSL = cPVSL;
		CMVSL = cMVSL;
		CCPC = cCPC;
		CCMC = cCMC;
		JP = jP;
		JM = jM;
		CVP = cVP;
		CVM = cVM;
		PROB1 = pROB1;
		PROB2 = pROB2;
		PROB3 = pROB3;
		this.tensaoBobina = tensaoBobina;
		this.cnat = cnat;
		this.prdtur = prdtur;
		this.tituloReal = tituloReal;
		this.estiragem = estiragem;
		this.qtdeFitas = qtdeFitas;
		this.d_percent = d_percent;
		this.cv = cv;
		this.cvIn = cvIn;
		this.pg = pg;
		this.a_percent = a_percent;
		this.t25 = t25;
		this.t20 = t20;
		this.t15 = t15;
		this.t125 = t125;
		this.t120 = t120;
		this.t115 = t115;
		this.t225 = t225;
		this.t220 = t220;
		this.t215 = t215;
		this.fkTurno = fkTurno;
		this.fkMaquina = fkMaquina;
	}

	public String getIdfil() {
		return idfil;
	}

	
	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getCodigoMaquina() {
		return codigoMaquina;
	}

	public void setCodigoMaquina(String codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Date getDataProducao() {
		return dataProducao;
	}

	public void setDataProducao(Date dataProducao) {
		this.dataProducao = dataProducao;
	}

	public String getLado() {
		return lado;
	}

	public void setLado(String lado) {
		this.lado = lado;
	}

	public Integer getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Integer horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Integer getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Integer horaFinal) {
		this.horaFinal = horaFinal;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getQtdeProduzida() {
		return qtdeProduzida;
	}

	public void setQtdeProduzida(Double qtdeProduzida) {
		this.qtdeProduzida = qtdeProduzida;
	}

	public Double getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(Double eficiencia) {
		this.eficiencia = eficiencia;
	}

	public Double getQuilosHora() {
		return quilosHora;
	}

	public void setQuilosHora(Double quilosHora) {
		this.quilosHora = quilosHora;
	}

	public String getCodigoAbertura() {
		return codigoAbertura;
	}

	public void setCodigoAbertura(String codigoAbertura) {
		this.codigoAbertura = codigoAbertura;
	}

	public String getLoteProducao() {
		return loteProducao;
	}

	public void setLoteProducao(String loteProducao) {
		this.loteProducao = loteProducao;
	}

	public String getTituloCadastro() {
		return tituloCadastro;
	}

	public void setTituloCadastro(String tituloCadastro) {
		this.tituloCadastro = tituloCadastro;
	}

	public String getCdFornecPoliester() {
		return cdFornecPoliester;
	}

	public void setCdFornecPoliester(String cdFornecPoliester) {
		this.cdFornecPoliester = cdFornecPoliester;
	}

	public String getCdFornecElastano() {
		return cdFornecElastano;
	}

	public void setCdFornecElastano(String cdFornecElastano) {
		this.cdFornecElastano = cdFornecElastano;
	}

	public String getLotePoliester() {
		return lotePoliester;
	}

	public void setLotePoliester(String lotePoliester) {
		this.lotePoliester = lotePoliester;
	}

	public String getLoteElastano() {
		return loteElastano;
	}

	public void setLoteElastano(String loteElastano) {
		this.loteElastano = loteElastano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Double getRpm() {
		return rpm;
	}

	public void setRpm(Double rpm) {
		this.rpm = rpm;
	}

	public Double getNumeroFusos() {
		return numeroFusos;
	}

	public void setNumeroFusos(Double numeroFusos) {
		this.numeroFusos = numeroFusos;
	}

	public Double getNumRupturas() {
		return numRupturas;
	}

	public void setNumRupturas(Double numRupturas) {
		this.numRupturas = numRupturas;
	}

	public Double getMetragem() {
		return metragem;
	}

	public void setMetragem(Double metragem) {
		this.metragem = metragem;
	}

	public Integer getIdSSM() {
		return idSSM;
	}

	public void setIdSSM(Integer idSSM) {
		this.idSSM = idSSM;
	}

	public Double getNumeroTrocas() {
		return numeroTrocas;
	}

	public void setNumeroTrocas(Double numeroTrocas) {
		this.numeroTrocas = numeroTrocas;
	}

	public String getEhTroca() {
		return ehTroca;
	}

	public void setEhTroca(String ehTroca) {
		this.ehTroca = ehTroca;
	}

	public Integer getHoraInicialTrocaFio() {
		return horaInicialTrocaFio;
	}

	public void setHoraInicialTrocaFio(Integer horaInicialTrocaFio) {
		this.horaInicialTrocaFio = horaInicialTrocaFio;
	}

	public Integer getHoraFinalTrocaFio() {
		return horaFinalTrocaFio;
	}

	public void setHoraFinalTrocaFio(Integer horaFinalTrocaFio) {
		this.horaFinalTrocaFio = horaFinalTrocaFio;
	}

	public String getNomeFornElastano() {
		return nomeFornElastano;
	}

	public void setNomeFornElastano(String nomeFornElastano) {
		this.nomeFornElastano = nomeFornElastano;
	}

	public String getNomeFornPoliester() {
		return nomeFornPoliester;
	}

	public void setNomeFornPoliester(String nomeFornPoliester) {
		this.nomeFornPoliester = nomeFornPoliester;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getLocalFisico() {
		return localFisico;
	}

	public void setLocalFisico(String localFisico) {
		this.localFisico = localFisico;
	}

	public String getEhReprocesso() {
		return ehReprocesso;
	}

	public void setEhReprocesso(String ehReprocesso) {
		this.ehReprocesso = ehReprocesso;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Double getAlfaTorcao() {
		return alfaTorcao;
	}

	public void setAlfaTorcao(Double alfaTorcao) {
		this.alfaTorcao = alfaTorcao;
	}

	public Double getTPM() {
		return TPM;
	}

	public void setTPM(Double tPM) {
		TPM = tPM;
	}

	public Double getTituloNominal() {
		return tituloNominal;
	}

	public void setTituloNominal(Double tituloNominal) {
		this.tituloNominal = tituloNominal;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public Double getRpmCAR() {
		return rpmCAR;
	}

	public void setRpmCAR(Double rpmCAR) {
		this.rpmCAR = rpmCAR;
	}

	public Double getPTON() {
		return PTON;
	}

	public void setPTON(Double pTON) {
		PTON = pTON;
	}

	public Double getPTOS() {
		return PTOS;
	}

	public void setPTOS(Double pTOS) {
		PTOS = pTOS;
	}

	public Double getPTOL() {
		return PTOL;
	}

	public void setPTOL(Double pTOL) {
		PTOL = pTOL;
	}

	public Double getPTOF() {
		return PTOF;
	}

	public void setPTOF(Double pTOF) {
		PTOF = pTOF;
	}

	public Double getMO() {
		return MO;
	}

	public void setMO(Double mO) {
		MO = mO;
	}

	public Double getCPVSL() {
		return CPVSL;
	}

	public void setCPVSL(Double cPVSL) {
		CPVSL = cPVSL;
	}

	public Double getCMVSL() {
		return CMVSL;
	}

	public void setCMVSL(Double cMVSL) {
		CMVSL = cMVSL;
	}

	public Double getCCPC() {
		return CCPC;
	}

	public void setCCPC(Double cCPC) {
		CCPC = cCPC;
	}

	public Double getCCMC() {
		return CCMC;
	}

	public void setCCMC(Double cCMC) {
		CCMC = cCMC;
	}

	public Double getJP() {
		return JP;
	}

	public void setJP(Double jP) {
		JP = jP;
	}

	public Double getJM() {
		return JM;
	}

	public void setJM(Double jM) {
		JM = jM;
	}

	public Double getCVP() {
		return CVP;
	}

	public void setCVP(Double cVP) {
		CVP = cVP;
	}

	public Double getCVM() {
		return CVM;
	}

	public void setCVM(Double cVM) {
		CVM = cVM;
	}

	public Double getPROB1() {
		return PROB1;
	}

	public void setPROB1(Double pROB1) {
		PROB1 = pROB1;
	}

	public Double getPROB2() {
		return PROB2;
	}

	public void setPROB2(Double pROB2) {
		PROB2 = pROB2;
	}

	public Double getPROB3() {
		return PROB3;
	}

	public void setPROB3(Double pROB3) {
		PROB3 = pROB3;
	}

	public Double getTensaoBobina() {
		return tensaoBobina;
	}

	public void setTensaoBobina(Double tensaoBobina) {
		this.tensaoBobina = tensaoBobina;
	}

	public Double getCnat() {
		return cnat;
	}

	public void setCnat(Double cnat) {
		this.cnat = cnat;
	}

	public Double getPrdtur() {
		return prdtur;
	}

	public void setPrdtur(Double prdtur) {
		this.prdtur = prdtur;
	}

	public Double getTituloReal() {
		return tituloReal;
	}

	public void setTituloReal(Double tituloReal) {
		this.tituloReal = tituloReal;
	}

	public Turno getFkTurno() {
		return fkTurno;
	}

	public void setFkTurno(Turno fkTurno) {
		this.fkTurno = fkTurno;
	}

	public Maquina getFkMaquina() {
		return fkMaquina;
	}

	public void setFkMaquina(Maquina fkMaquina) {
		this.fkMaquina = fkMaquina;
	}  
	
	public Double getEstiragem() {
		return estiragem;
	}

	public void setEstiragem(Double estiragem) {
		this.estiragem = estiragem;
	}

	public Integer getQtdeFitas() {
		return qtdeFitas;
	}

	public void setQtdeFitas(Integer qtdeFitas) {
		this.qtdeFitas = qtdeFitas;
	}

	public Double getD_percent() {
		return d_percent;
	}

	public void setD_percent(Double d_percent) {
		this.d_percent = d_percent;
	}

	public Double getCv() {
		return cv;
	}

	public void setCv(Double cv) {
		this.cv = cv;
	}

	public Double getCvIn() {
		return cvIn;
	}

	public void setCvIn(Double cvIn) {
		this.cvIn = cvIn;
	}

	public Double getPg() {
		return pg;
	}

	public void setPg(Double pg) {
		this.pg = pg;
	}

	public Double getA_percent() {
		return a_percent;
	}

	public void setA_percent(Double a_percent) {
		this.a_percent = a_percent;
	}

	public Double getT25() {
		return t25;
	}

	public void setT25(Double t25) {
		this.t25 = t25;
	}

	public Double getT20() {
		return t20;
	}

	public void setT20(Double t20) {
		this.t20 = t20;
	}

	public Double getT15() {
		return t15;
	}

	public void setT15(Double t15) {
		this.t15 = t15;
	}

	public Double getT125() {
		return t125;
	}

	public void setT125(Double t125) {
		this.t125 = t125;
	}

	public Double getT120() {
		return t120;
	}

	public void setT120(Double t120) {
		this.t120 = t120;
	}

	public Double getT115() {
		return t115;
	}

	public void setT115(Double t115) {
		this.t115 = t115;
	}

	public Double getT225() {
		return t225;
	}

	public void setT225(Double t225) {
		this.t225 = t225;
	}

	public Double getT220() {
		return t220;
	}

	public void setT220(Double t220) {
		this.t220 = t220;
	}

	public Double getT215() {
		return t215;
	}

	public void setT215(Double t215) {
		this.t215 = t215;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoMaquina, dataProducao, horaInicio, idfil, lado, turno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProducaoFiacao other = (ProducaoFiacao) obj;
		return Objects.equals(codigoMaquina, other.codigoMaquina) && Objects.equals(dataProducao, other.dataProducao)
				&& Objects.equals(horaInicio, other.horaInicio) && Objects.equals(idfil, other.idfil)
				&& Objects.equals(lado, other.lado) && Objects.equals(turno, other.turno);
	}

 


 



 
 
	 
 
	
	 
}


