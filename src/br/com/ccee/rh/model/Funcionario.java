package br.com.ccee.rh.model;

public class Funcionario implements Comparable<Funcionario>{
	
	private Integer id;
	private String nome;
	private Double salarioBruto;
	private Double salarioLiquido;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSalarioBruto() {
		return salarioBruto;
	}
	public void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
	public Double getSalarioLiquido() {
		return salarioLiquido;
	}
	public void setSalarioLiquido(Double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}
	@Override
	public int compareTo(Funcionario o) {
		
		return salarioLiquido.compareTo(o.salarioLiquido);
	}
	
	

}
