package br.com.bruno.financas.teste;

import javax.persistence.EntityManager;

import br.com.bruno.financas.model.Cliente;
import br.com.bruno.financas.model.Conta;
import br.com.bruno.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Conta testeConta = em.find(Conta.class, 3);

		Cliente cliente = new Cliente();
		cliente.setNome("Fernanda");
		cliente.setEndereco("Rua dos Bobos 0");
		cliente.setProfissao("Facility Manager");
		cliente.setConta(testeConta);


		em.persist(testeConta);
		em.persist(cliente);

		em.getTransaction().commit();
		em.close();
	}

}
