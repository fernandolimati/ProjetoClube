package persistencia;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;

import entidade.EntidadeTipoAssociado;
import util.DataHelper;

public class TipoAssociadoDaoRest {
	
	private static TipoAssociadoDaoRest instance = null;
	
	private String urlPai = "http://localhost:8080/ProjetoRest/tipoassociado/";
	private String authorization;
	private static DataHelper dataTokenEncerra;
	  
	private TipoAssociadoDaoRest() throws Exception {
		loginJWT("fernando","123");
		dataTokenEncerra = new DataHelper(new Date());
		dataTokenEncerra.adicionarHoras(+23);
		System.out.println("gerou o token");
	}
	public static TipoAssociadoDaoRest getInstance() throws Exception {
	      if(instance == null) {
	         instance = new TipoAssociadoDaoRest();
	      }else if(dataTokenEncerra.comparar(new Date()) <= 0) {
	    	  instance = new TipoAssociadoDaoRest();   	  
	      }else {
	    	  return instance;
	      }
		return instance;
	}
	
	public boolean incluir(EntidadeTipoAssociado tipo) throws Exception {
		URL url;
		url = new URL(urlPai + "adicionar");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-type", "application/json");
		conn.setRequestProperty("Authorization", "Bearer " + authorization);
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

	public boolean atualizar(EntidadeTipoAssociado tipo) throws Exception {
		URL url;
		url = new URL(urlPai + "atualizar");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-type", "application/json");
		conn.setRequestProperty("Authorization", "Bearer " + authorization);
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

	public boolean excluir(int codigo) throws Exception {
		int resp = 0;
		BufferedReader br;
		URL url = new URL(urlPai + "remover/" + codigo);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization", "Bearer " + authorization);

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

	public EntidadeTipoAssociado consultar(int codigo) throws Exception {
		EntidadeTipoAssociado obj = null;
		BufferedReader br;
		URL url = new URL(urlPai + "buscar/" + codigo);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Authorization", "Bearer " + authorization);

		InputStream in = conn.getInputStream();

		int responseCode = conn.getResponseCode();
		
		if (responseCode / 100 != 2) {
			return null;
		}

		br = new BufferedReader(new InputStreamReader(in));
		try {
			Gson gson = new Gson();
			obj = gson.fromJson(br, EntidadeTipoAssociado.class);
		} finally {
			conn.disconnect();
			br.close();
			in.close();
		}
		return obj;
	}

	public ArrayList<EntidadeTipoAssociado> listar() throws Exception {
		ArrayList<EntidadeTipoAssociado> lista = new ArrayList<>();
		BufferedReader br;
		URL url = new URL(urlPai + "listar");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Authorization", "Bearer " + authorization);

		InputStream in = conn.getInputStream();

		int responseCode = conn.getResponseCode();

		if (responseCode / 100 != 2) {
			return null;
		}

		br = new BufferedReader(new InputStreamReader(in));
		try {
			Gson gson = new Gson();
			EntidadeTipoAssociado[] listaObj = gson.fromJson(br, EntidadeTipoAssociado[].class);
			for (int i = 0; i < listaObj.length; i++)
				lista.add(listaObj[i]);
		} finally {
			conn.disconnect();
			br.close();
			in.close();
		}
		return lista;
	}
	
	@SuppressWarnings("resource")
	private boolean loginJWT(String login, String password) throws Exception {
		
		String urlogin = "http://localhost:8080/ProjetoRest/login";
		String json = "{\"login\":\"" + login + "\",\"senha\":\"" + password + "\"}";
		URL url;
		url = new URL(urlogin);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-type", "application/json");
		conn.setDoOutput(true);

		PrintStream printStream = new PrintStream(conn.getOutputStream());
		printStream.println(json);

		conn.connect();

		this.authorization = new Scanner(conn.getInputStream()).next();
		return true;
		
	}
}
