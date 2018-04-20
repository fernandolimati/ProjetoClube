package util;

import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

public class ConexaoRest {
	
	private static ConexaoRest instance = null;
	
	private String authorization;
	private static DataHelper dataTokenEncerra;
	
	private ConexaoRest() throws Exception {
		loginJWT("fernando","123");
		ConexaoRest.dataTokenEncerra = new DataHelper(new Date());
		ConexaoRest.dataTokenEncerra.adicionarHoras(+24);
	}
	public static ConexaoRest getInstance() throws Exception {
		if (instance == null) {
			instance = new ConexaoRest();
		} else if (dataTokenEncerra.comparar(new Date()) == -1) {
			instance = new ConexaoRest();
		} else {
			return instance;
		}
		return instance;
	}
	
	public String getAuthorization() {
		return authorization;
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