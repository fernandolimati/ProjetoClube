package persistencia;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

import util.ConexaoRest;

public class PersistenciaRestGenerica<T> implements PersistenciaRestGenericaInterface<T> {

	private String urlPai;
	private Class<T[]> classeVetor;
	
	public PersistenciaRestGenerica(Class<T> classe,Class<T[]> classeVetor){
		this.classeVetor = classeVetor;
		switch (classe.getName()) {
		case "entidade.EntidadeAssociado":
			this.urlPai = "http://localhost:8080/ProjetoRest/associado/";
			break;
		case "entidade.EntidadeItemPedido":
			this.urlPai = "http://localhost:8080/ProjetoRest/itempedido/";
			break;
		case "entidade.EntidadePedido":
			this.urlPai = "http://localhost:8080/ProjetoRest/pedido/";
			break;
		case "entidade.EntidadeProduto":
			this.urlPai = "http://localhost:8080/ProjetoRest/produto/";
			break;
		case "entidade.EntidadeTipoAssociado":
			this.urlPai = "http://localhost:8080/ProjetoRest/tipoassociado/";
			break;
		default:
			break;
		}
	}
	
	@Override
	public boolean incluir(T tipo) throws Exception {
		URL url;
		url = new URL(urlPai + "adicionar");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-type", "application/json");
		conn.setRequestProperty("Authorization", "Bearer " + ConexaoRest.getInstance().getAuthorization());
		conn.setDoOutput(true);

		PrintStream printStream = new PrintStream(conn.getOutputStream());
		Gson gson = new Gson();
		String json = gson.toJson(tipo);
		printStream.println(json);

		conn.connect();
		@SuppressWarnings("resource")
		int saida = new Scanner(conn.getInputStream()).nextInt();
		
		if (saida > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean excluir(int id) throws Exception {
		int resp = 0;
		BufferedReader br;
		URL url = new URL(urlPai + "remover/" + id);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization", "Bearer " + ConexaoRest.getInstance().getAuthorization());

		InputStream in = conn.getInputStream();

		int responseCode = conn.getResponseCode();
		if (responseCode / 100 != 2) {
			return false;
		}

		br = new BufferedReader(new InputStreamReader(in));
		try {
			resp = Integer.parseInt(br.readLine());
		} finally {
			conn.disconnect();
			br.close();
			in.close();
		}
		if (resp > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean atualizar(T tipo) throws Exception {
		URL url;
		url = new URL(urlPai + "atualizar");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-type", "application/json");
		conn.setRequestProperty("Authorization", "Bearer " + ConexaoRest.getInstance().getAuthorization());
		conn.setDoOutput(true);

		PrintStream printStream = new PrintStream(conn.getOutputStream());
		Gson gson = new Gson();
		String json = gson.toJson(tipo);
		printStream.println(json);

		conn.connect();

		@SuppressWarnings("resource")
		int saida = new Scanner(conn.getInputStream()).nextInt();
		if (saida > 0)
			return true;
		else
			return false;
	}

	@Override
	public ArrayList<T> consultar(int codigo) throws Exception {
		ArrayList<T> lista = new ArrayList<>();
		BufferedReader br;
		URL url = new URL(urlPai + "buscar/" + codigo);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Authorization", "Bearer " + ConexaoRest.getInstance().getAuthorization());

		InputStream in = conn.getInputStream();

		int responseCode = conn.getResponseCode();

		if (responseCode / 100 != 2) {
			return null;
		}

		br = new BufferedReader(new InputStreamReader(in));
		try {
			Gson gson = new Gson();
			T[] listaObj = gson.fromJson(br, classeVetor);
			for (int i = 0; i < listaObj.length; i++)
				lista.add(listaObj[i]);
		} finally {
			conn.disconnect();
			br.close();
			in.close();
		}
		return lista;
	}

	@Override
	public ArrayList<T> listar() throws Exception {
		ArrayList<T> lista = new ArrayList<>();
		BufferedReader br;
		URL url = new URL(urlPai + "listar");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Authorization", "Bearer " + ConexaoRest.getInstance().getAuthorization());

		InputStream in = conn.getInputStream();

		int responseCode = conn.getResponseCode();

		if (responseCode / 100 != 2) {
			return null;
		}

		br = new BufferedReader(new InputStreamReader(in));
		try {
			Gson gson = new Gson();
			T[] listaObj = gson.fromJson(br, classeVetor);
			for (int i = 0; i < listaObj.length; i++)
				lista.add(listaObj[i]);
		} finally {
			conn.disconnect();
			br.close();
			in.close();
		}
		return lista;
	}
	
}
