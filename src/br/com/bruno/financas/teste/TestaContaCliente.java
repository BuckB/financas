package br.com.bruno.financas.teste;

import javax.persistence.EntityManager;

import br.com.bruno.financas.model.Cliente;
import br.com.bruno.financas.model.Conta;
import br.com.bruno.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {

		Conta novaConta = new Conta();
		novaConta.setTitular("Nanda");
		novaConta.setBanco("Santander");
		novaConta.setAgencia("0012");
		novaConta.setNumero("102030");

		Cliente cliente = new Cliente();
		cliente.setNome("Fernanda");
		cliente.setEndereco("Rua dos Bobos 0");
		cliente.setProfissao("Facility Manager");
		cliente.setConta(novaConta);

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(novaConta);
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
	}

}
