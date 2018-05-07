package br.com.bruno.financas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Conta")
public class Conta implements java.io.Serializable {

	private static final long serialVersionUID = -5694094983534167080L;

	 private Integer id;
     private String agencia;
     private String banco;
     private String numero;
     private String titular;

    public Conta() {}

    public Conta(String agencia, String banco, String numero, String titular) {
       this.agencia = agencia;
       this.banco = banco;
       this.numero = numero;
       this.titular = titular;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="agencia")
    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    @Column(name="banco")
    public String getBanco() {
        return this.banco;
    }
    
    public void setBanco(String banco) {
        this.banco = banco;
    }

    
    @Column(name="numero")
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }

    
    @Column(name="titular")
    public String getTitular() {
        return this.titular;
    }
    
    public void setTitular(String titular) {
        this.titular = titular;
    }

}


