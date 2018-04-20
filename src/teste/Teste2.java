package teste;

import java.util.ArrayList;

import entidade.EntidadeItemPedido;
import persistencia.PersistenciaRestGenerica;

public class Teste2 {

	public static void main(String[] args) throws Exception {
		
		PersistenciaRestGenerica<EntidadeItemPedido> persistencia = new PersistenciaRestGenerica<EntidadeItemPedido>(EntidadeItemPedido.class,EntidadeItemPedido[].class);
		while(true) {
			ArrayList<EntidadeItemPedido> teste = persistencia.listar();
		}
	}

}
