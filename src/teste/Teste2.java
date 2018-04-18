package teste;

import java.util.ArrayList;

import entidade.EntidadeItemPedido;
import entidade.EntidadePedido;
import persistencia.PersistenciaRestGenerica;

public class Teste2 {

	public static void main(String[] args) {
		
		PersistenciaRestGenerica<EntidadePedido> dao = new PersistenciaRestGenerica<EntidadePedido>(EntidadePedido.class,EntidadePedido[].class);
		
		try {
			while(true) {
				ArrayList<EntidadePedido> lista = dao.listar();		
				System.out.println(lista.get(0).getListaItemPedido().size());
//				System.out.println("Pedido ID...:"+lista.get(0).getId());
//				System.out.println("Valor Total.:"+lista.get(0).getValorTotalPedido());
//				System.out.println("Data/Hora...:"+lista.get(0).getDataHoraPedido().getData());
//				System.out.println("Itens do Pedido:.....................");
//				for(EntidadeItemPedido itemPedido:lista.get(0).getListaItemPedido()) {
//					System.out.println("...........................................");
//					System.out.println("ID:. "+itemPedido.getId());
//					System.out.println("Preco Momento:. "+itemPedido.getPrecoMomento());
//					System.out.println("Qtd:. "+itemPedido.getQuantidade());
//					System.out.println("Nome Produto:. "+itemPedido.getProduto().getNomeProduto());
//					System.out.println("Id Produto:. "+itemPedido.getProduto().getId());
//				}
				
				break;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
