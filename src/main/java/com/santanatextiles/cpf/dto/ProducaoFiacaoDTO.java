package com.santanatextiles.cpf.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;

public class ProducaoFiacaoDTO  implements Serializable {

	private static final long serialVersionUID = 1L;	

	private String  idfil	; 	
	private String codigoMaquina;
	private String  turno;	
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR",timezone="Brazil/East")
	private Date    dataProducao; 
	
	
	private String lado; 
	private Integer horaInicio; 
	private Integer horaFinal;	
	private String item;
	private Double qtdeProduzida;	
	private Double eficiencia ;
	private Double quilosHora;
	private String codigoAbertura;
	private String loteProducao;
	private String tituloCadastro; 
	private String cdFornecPoliester;
	private String cdFornecElastano;
	private String lotePoliester;
	private String loteElastano;
	private String cor;
	private Double rpm;
	private Double numeroFusos;
	private Double numRupturas;
	private Double metragem	;
	private Integer idSSM	;
	private Double numeroTrocas;
	private String ehTroca	;
	private Integer horaInicialTrocaFio;
	private Integer horaFinalTrocaFio;
	private String nomeFornElastano	;
	private String nomeFornPoliester;
	private String numeroSerie;
	private String localFisico;
	private String ehReprocesso; 
	private String obs	; 
	private Double alfaTorcao; 
	private Double TPM	; 
	private Double tituloNominal; 
	private String operador	; 
	private Double rpmCAR	; 
	private Double PTON	; 
	private Double PTOS	;  
	private Double PTOL	; 
	private Double PTOF	; 
	private Double MO	; 
	private Double CPVSL	; 
	private Double CMVSL	; 
	private Double CCPC	;  
	private Double CCMC	; 
	private Double JP	; 
	private Double JM	; 
	private Double CVP	; 
	private Double CVM	; 
	private Double PROB1	;  
	private Double PROB2  ; 
	private Double PROB3	; 
	private Double tensaoBobina; 
	private Double cnat	; 
	private Double prdtur	; 
	private Double tituloReal;
	private Double  estiragem;
	private Integer qtdeFitas;
	private Double  d_percent;
	private Double  cv;
	private Double  cvIn;
	private Double  pg;
	private Double  a_percent;
	private Double  t25;
	private Double  t20;
	private Double  t15;
    private Double  t125;
    private Double  t120;
	private Double  t115;
    private Double  t225;
    private Double  t220;
	private Double  t215;  
		
	private String    dataProducaoInicial;  
	private String    dataProducaoFinal;
	private String    tipoMaquina;  
	

	public ProducaoFiacaoDTO(String idfil, String codigoMaquina, String turno, Date dataProducao, String lado,
			Integer horaInicio, Integer horaFinal, String item, Double qtdeProduzida, Double eficiencia,
			Double quilosHora, String codigoAbertura, String loteProducao, String tituloCadastro,
			String cdFornecPoliester, String cdFornecElastano, String lotePoliester, String loteElastano, String cor,
			Double rpm, Double numeroFusos, Double numRupturas, Double metragem, Integer idSSM, Double numeroTrocas,
			String ehTroca, Integer horaInicialTrocaFio, Integer horaFinalTrocaFio, String nomeFornElastano,
			String nomeFornPoliester, String numeroSerie, String localFisico, String ehReprocesso, String obs,
			Double alfaTorcao, Double tPM, Double tituloNominal, String operador, Double rpmCAR, Double pTON,
			Double pTOS, Double pTOL, Double pTOF, Double mO, Double cPVSL, Double cMVSL, Double cCPC, Double cCMC,
			Double jP, Double jM, Double cVP, Double cVM, Double pROB1, Double pROB2, Double pROB3, Double tensaoBobina,
			Double cnat, Double prdtur, Double tituloReal, Double  estiragem, Integer qtdeFitas, Double  d_percent, Double  cv,
			Double  cvIn, Double  pg, Double  a_percent, Double  t25, Double  t20, Double  t15, Double  t125, Double  t120, Double  t115,
			Double  t225, Double  t220, Double  t215, String dataProducaoInicial, String dataProducaoFinal,
			String tipoMaquina) {
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
		this.dataProducaoInicial = dataProducaoInicial;
		this.dataProducaoFinal = dataProducaoFinal;
		this.tipoMaquina = tipoMaquina;
	}

	public ProducaoFiacaoDTO() {
		super();
	}
  
	public ProducaoFiacaoDTO(String idfil, String codigoMaquina, String turno, String dataProducaoInicial,
			String dataProducaoFinal, String tipoMaquina) {
		super();
		this.idfil = idfil;
		this.codigoMaquina = codigoMaquina;
		this.turno = turno;
		this.dataProducaoInicial = dataProducaoInicial;
		this.dataProducaoFinal = dataProducaoFinal;
		this.tipoMaquina = tipoMaquina;
	}

 

	public ProducaoFiacaoDTO(String idfil, String codigoMaquina, String turno, Date dataProducao, String lado,
			Integer horaInicio) {
		super();
		this.idfil = idfil;
		this.codigoMaquina = codigoMaquina;
		this.turno = turno;
		this.dataProducao = dataProducao;
		this.lado = lado;
		this.horaInicio = horaInicio;
	}


	public ProducaoFiacaoDTO(String idfil, Integer horaInicio, Integer horaFinal, String item) {
		super();
		this.idfil = idfil;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.item = item;
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
	

	public String getDataProducaoInicial() {
		return dataProducaoInicial;
	}


	public void setDataProducaoInicial(String dataProducaoInicial) {
		this.dataProducaoInicial = dataProducaoInicial;
	}


	public String getDataProducaoFinal() {
		return dataProducaoFinal;
	}


	public void setDataProducaoFinal(String dataProducaoFinal) {
		this.dataProducaoFinal = dataProducaoFinal;
	}
	

	public String getTipoMaquina() {
		return tipoMaquina;
	}



	public void setTipoMaquina(String tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
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
	
	
	
	
	
	
}
