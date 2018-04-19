package entidade;

public class EntidadeItemPedido {
	
	private int idItemPedido;
	private double precoMomentoItemPedido;
	private int quantidadeItemPedido;
	private EntidadeProduto produto;
	private EntidadePedido pedido;
	
	public EntidadeItemPedido(int id, double precoMomento, int quantidade, EntidadeProduto produto,
			EntidadePedido pedido) {
		super();
		this.idItemPedido = id;
		this.precoMomentoItemPedido = precoMomento;
		this.quantidadeItemPedido = quantidade;
		this.produto = produto;
		this.pedido = pedido;
	}
	public EntidadeItemPedido(double precoMomento, int quantidade, EntidadeProduto produto,
			EntidadePedido pedido) {
		super();
		this.precoMomentoItemPedido = precoMomento;
		this.quantidadeItemPedido = quantidade;
		this.produto = produto;
		this.pedido = pedido;
	}
	public EntidadeItemPedido() {
		this.produto = null;
		this.pedido = null;
	}
		
	public int getIdItemPedido() {
		return idItemPedido;
	}
	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	public double getPrecoMomentoItemPedido() {
		return precoMomentoItemPedido;
	}
	public void setPrecoMomentoItemPedido(double precoMomentoItemPedido) {
		this.precoMomentoItemPedido = precoMomentoItemPedido;
	}
	public int getQuantidadeItemPedido() {
		return quantidadeItemPedido;
	}
	public void setQuantidadeItemPedido(int quantidadeItemPedido) {
		this.quantidadeItemPedido = quantidadeItemPedido;
	}
	public EntidadeProduto getProduto() {
		return produto;
	}
	public void setProduto(EntidadeProduto produto) {
		this.produto = produto;
	}
	public EntidadePedido getPedido() {
		return pedido;
	}
	public void setPedido(EntidadePedido pedido) {
		this.pedido = pedido;
	};
	
}
