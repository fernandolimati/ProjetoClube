package entidade;

import java.util.ArrayList;

import util.DataHelper;


public class EntidadePedido {
	
	private int id;
	private EntidadeAssociado associado;
	private double valorTotalPedido;
	private DataHelper dataHoraPedido;
	ArrayList<EntidadeItemPedido> listaItemPedido;
	
	public EntidadePedido() {
		this.listaItemPedido = null;
		this.dataHoraPedido = null;
		this.associado = null;
	}
	
	public EntidadePedido(int id, EntidadeAssociado associado, double valorTotalPedido, DataHelper dataHoraPedido,
			ArrayList<EntidadeItemPedido> listaItemPedido) {
		super();
		this.id = id;
		this.associado = associado;
		this.valorTotalPedido = valorTotalPedido;
		this.dataHoraPedido = dataHoraPedido;
		this.listaItemPedido = listaItemPedido;
	}
	public EntidadePedido(int id, EntidadeAssociado associado, double valorTotalPedido, DataHelper dataHoraPedido) {
		super();
		this.id = id;
		this.associado = associado;
		this.valorTotalPedido = valorTotalPedido;
		this.dataHoraPedido = dataHoraPedido;
	}
	public EntidadePedido(EntidadeAssociado associado, double valorTotalPedido, DataHelper dataHoraPedido) {
		super();
		this.associado = associado;
		this.valorTotalPedido = valorTotalPedido;
		this.dataHoraPedido = dataHoraPedido;
	}
	
	
	public ArrayList<EntidadeItemPedido> getListaItemPedido() {
		return listaItemPedido;
	}
	public void setListaItemPedido(ArrayList<EntidadeItemPedido> listaItemPedido) {
		this.listaItemPedido = listaItemPedido;
	}
	public EntidadeAssociado getAssociado() {
		return associado;
	}
	public void setAssociado(EntidadeAssociado associado) {
		this.associado = associado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValorTotalPedido() {
		return valorTotalPedido;
	}
	public void setValorTotalPedido(double valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}
	public DataHelper getDataHoraPedido() {
		return dataHoraPedido;
	}
	public void setDataHoraPedido(DataHelper dataHoraPedido) {
		this.dataHoraPedido = dataHoraPedido;
	};
	
}
