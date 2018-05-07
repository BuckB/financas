package br.com.bruno.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.bruno.financas.enums.TipoMovimentacao;
import br.com.bruno.financas.model.Conta;
import br.com.bruno.financas.model.Movimentacao;
import br.com.bruno.financas.util.JPAUtil;

public class TesteContaMovimentacao {

	public static void main(String[] args) {

		Conta conta1 = new Conta();
		conta1.setAgencia("1234");
		conta1.setBanco("Bradesco");
		conta1.setNumero("111213");
		conta1.setTitular("Bruno");
		
		Movimentacao movi1 = new Movimentacao();
		movi1.setConta(conta1);
		movi1.setData(Calendar.getInstance());
		movi1.setDescricao("Cafe");
		movi1.setTipo(TipoMovimentacao.SAIDA);
		movi1.setValor(new BigDecimal("50.00"));
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(conta1);
		em.persist(movi1);
		
		em.getTransaction().commit();
		em.close();
	}

}
