package br.com.bruno.financas.teste;

import javax.persistence.EntityManager;

import br.com.bruno.financas.model.Conta;
import br.com.bruno.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
		Conta contaDoBruno = new Conta();
		contaDoBruno.setTitular("Bruno");
		contaDoBruno.setBanco("Swiss Bank");
		contaDoBruno.setAgencia("Montreaux");
		contaDoBruno.setNumero("123456");

		Conta contaDoDaniel = new Conta();
		contaDoDaniel.setTitular("Dan");
		contaDoDaniel.setBanco("TD Bank");
		contaDoDaniel.setAgencia("New England");
		contaDoDaniel.setNumero("654321");

		Conta novaConta = new Conta();
		novaConta.setTitular("Tata");
		novaConta.setBanco("Santander");
		novaConta.setAgencia("0012");
		novaConta.setNumero("102030");

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.persist(contaDoBruno);
		em.persist(contaDoDaniel);
		em.persist(novaConta);
		em.getTransaction().commit();
		em.close();

	}

}
