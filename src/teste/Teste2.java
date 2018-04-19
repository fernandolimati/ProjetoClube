package teste;

import java.util.ArrayList;

import entidade.EntidadePedido;
import persistencia.PersistenciaRestGenerica;

public class Teste2 {

	public static void main(String[] args) throws Exception {
		
		PersistenciaRestGenerica<EntidadePedido> dao = new PersistenciaRestGenerica<EntidadePedido>(EntidadePedido.class,EntidadePedido[].class);
		
		try {
			while(true) {
				ArrayList<EntidadePedido> lista = dao.listar();
				for(EntidadePedido obj:lista) {
					System.out.println(obj.getId());
					System.out.println(obj.getValorTotalPedido());
					System.out.println(obj.getAssociado().getNome());
					System.out.println(obj.getDataHoraPedido().getDataString());
				}
				
				
				break;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

}
