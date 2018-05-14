package br.com.bruno.financas.teste;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.bruno.financas.enums.TipoMovimentacao;
import br.com.bruno.financas.model.Conta;
import br.com.bruno.financas.model.Movimentacao;
import br.com.bruno.financas.util.DateConverterUtil;
import br.com.bruno.financas.util.JPAUtil;

public class TesteContaMovimentacao {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		Conta conta1 = em.find(Conta.class, 2);
		//
		// Movimentacao movi1 = new Movimentacao();
		// movi1.setConta(conta1);
		// movi1.setData(Calendar.getInstance());
		// movi1.setDescricao("Cafe");
		// movi1.setTipo(TipoMovimentacao.SAIDA);
		// movi1.setValor(new BigDecimal("50.00"));

		String jpql = "SELECT m from Movimentacao m WHERE m.conta = :pConta "
				+ "AND m.tipo = :pTipo ORDER BY m.valor DESC";

		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta1);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		List<Movimentacao> result = query.getResultList();

//		System.out.println(result);
		System.out.println();
		result.forEach(item -> System.out.println("Descrição: " + item.getDescricao() +
				"  Quanto: R$" + item.getValor() + "  Quando: " + DateConverterUtil.CalToString(item.getData())));
		// em.persist(movi1);
		//
		em.getTransaction().commit();
		em.close();
		return;
	}

}
