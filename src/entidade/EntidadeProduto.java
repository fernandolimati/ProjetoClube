package entidade;

public class EntidadeProduto {
	
	private int id;
	private String nomeProduto;
	private double valorVenda;
	
	public EntidadeProduto(int id, String nomeProduto, double valorVenda) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.valorVenda = valorVenda;
	}
	public EntidadeProduto(String nomeProduto, double valorVenda) {
		super();
		this.nomeProduto = nomeProduto;
		this.valorVenda = valorVenda;
	}
	public EntidadeProduto() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	
}
