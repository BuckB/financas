package br.com.bruno.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.bruno.financas.enums.TipoMovimentacao;
import br.com.bruno.financas.model.Categoria;
import br.com.bruno.financas.model.Conta;
import br.com.bruno.financas.model.Movimentacao;
import br.com.bruno.financas.util.JPAUtil;

public class TesteMovimentacaoCategoria {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setId(2);

		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");

		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Viagem à São Paulo");
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("100.0"));
		movimentacao1.setCategoria(Arrays.asList(categoria1, categoria2));
		movimentacao1.setConta(conta);

		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Viagem à Florianópolis");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("300.0"));
		movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));
		movimentacao2.setConta(conta);

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		// transformando categoria1 e categoria2 para o estado managed
		em.persist(categoria1);
		em.persist(categoria2);
		// transformando movimentacao1 e movimentacao2 para o estado managed
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		em.getTransaction().commit();
		em.close();
	}

}
