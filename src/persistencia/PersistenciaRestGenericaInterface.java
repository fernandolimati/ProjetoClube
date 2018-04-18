package persistencia;

import java.util.ArrayList;

public interface PersistenciaRestGenericaInterface<T> {
	public boolean incluir(T tipo) throws Exception;
	public boolean excluir(int id) throws Exception;
	public boolean atualizar(T tipo) throws Exception;
	public ArrayList<T> consultar(int codigo) throws Exception;
	public ArrayList<T> listar() throws Exception;
}
