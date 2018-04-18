package entidade;

public class EntidadeItemPedido {
	
	private int id;
	private double precoMomento;
	private int quantidade;
	private EntidadeProduto produto;
	private EntidadePedido pedido;
	
	public EntidadeItemPedido(int id, double precoMomento, int quantidade, EntidadeProduto produto,
			EntidadePedido pedido) {
		super();
		this.id = id;
		this.precoMomento = precoMomento;
		this.quantidade = quantidade;
		this.produto = produto;
		this.pedido = pedido;
	}
	public EntidadeItemPedido(double precoMomento, int quantidade, EntidadeProduto produto,
			EntidadePedido pedido) {
		super();
		this.precoMomento = precoMomento;
		this.quantidade = quantidade;
		this.produto = produto;
		this.pedido = pedido;
	}
	public EntidadeItemPedido() {
		this.produto = null;
		this.pedido = null;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrecoMomento() {
		return precoMomento;
	}
	public void setPrecoMomento(double precoMomento) {
		this.precoMomento = precoMomento;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
