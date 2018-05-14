package br.com.bruno.financas.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.bruno.financas.enums.TipoMovimentacao;

@Entity
@Table(name = "Movimentacao", schema = "financas")
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = 2174193527089811687L;

	private Integer id;
	private BigDecimal valor;
	private String descricao;
	private Calendar data;
	private TipoMovimentacao tipo;
	private Conta conta;
	private List<Categoria> categoria;

	public Movimentacao() {
	}

	public Movimentacao(BigDecimal valor, String descricao, Calendar data, TipoMovimentacao tipo, Conta conta,
			List<Categoria> categoria) {
		this.valor = valor;
		this.descricao = descricao;
		this.data = data;
		this.tipo = tipo;
		this.conta = conta;
		this.categoria = categoria;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	@Enumerated(EnumType.STRING)
	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

	@ManyToOne
	@JoinColumn(name = "contaID")
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@ManyToMany
	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
}
