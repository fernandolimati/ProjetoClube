package persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

import entidade.EntidadeTipoAssociado;

public class TipoAssociadoDaoRest {
	
	  private String urlPai = "http://localhost:8080/ProjetoRest/tipoassociado/";
	  private String authorization;
	  //private Date expiraEm;
	  
	public TipoAssociadoDaoRest() {
		loginJWT("fernando","123");
	}
	
	@SuppressWarnings("resource")
	private boolean loginJWT(String login, String password) {
		String urlogin = "http://localhost:8080/ProjetoRest/login";
		String json = "{\"login\":\""+login+"\",\"senha\":\""+password+"\"}";
		URL url;
		try {
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
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void incluir(EntidadeTipoAssociado tipo) {
	}

	public void atualizar(EntidadeTipoAssociado tipo) {
	}

	public void excluir(int codigo) {

	}

	public EntidadeTipoAssociado consultar(int codigo) {
		EntidadeTipoAssociado obj = null;
		try {
            BufferedReader br;
            URL url = new URL(urlPai+"buscar/"+codigo);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer "+authorization);

            InputStream in = conn.getInputStream();

            int responseCode = conn.getResponseCode();
            //aceita os status de 200 a 299
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
        } catch (Exception e) {
        	return null;
        } 
		return obj;
	}

	public ArrayList<EntidadeTipoAssociado> listar() {
		ArrayList<EntidadeTipoAssociado> lista = new ArrayList<>();
		try {
            BufferedReader br;
            URL url = new URL(urlPai+"list");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Bearer "+authorization);

            InputStream in = conn.getInputStream();

            int responseCode = conn.getResponseCode();
            
            //aceita os status de 200 a 299
            if (responseCode / 100 != 2) {
                return null;
            }

            br = new BufferedReader(new InputStreamReader(in));
            try {
                Gson gson = new Gson();
                EntidadeTipoAssociado[] listaObj = gson.fromJson(br, EntidadeTipoAssociado[].class);
                for(int i=0;i<listaObj.length;i++) lista.add(listaObj[i]);
            } finally {
                conn.disconnect();
                br.close();
                in.close();
            }
        } catch (Exception e) {
        	return null;
        } 
		return lista;
	}
}
