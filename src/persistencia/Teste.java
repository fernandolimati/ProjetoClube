package persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

import entidade.EntidadeTipoAssociado;

public class Teste {

	public static void main ( String [] args ) {
        String s = "http://localhost:8080/projetoclube/rest/tipoassociado/list";

         try {
             BufferedReader br;
             URL url = new URL(s);
             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             conn.setRequestMethod("GET");
             conn.setRequestProperty("Accept", "application/json");

             InputStream in = conn.getInputStream();

             int responseCode = conn.getResponseCode();
             //aceita os status de 200 a 299
             if (responseCode / 100 != 2) {
                 System.out.println("RESPONSE CODE:" + responseCode);
                 return;
             }

             br = new BufferedReader(new InputStreamReader(in));
             try {

                 Gson gson = new Gson();

                 EntidadeTipoAssociado[] produtos = gson.fromJson(br, EntidadeTipoAssociado[].class);
                 
                 for(int i=0;i<produtos.length;i++) {
                	 System.out.println("ID..........: "+produtos[i].getCodigo());
                	 System.out.println("Descricao...: "+produtos[i].getDescricao());
                	 System.out.println("Mensalidade.: "+produtos[i].getValorMensalidade());
                	 System.out.println();
                 }
                 
             } finally {
                 conn.disconnect();
                 br.close();
                 in.close();
             }
         } catch (MalformedURLException e) {
             e.printStackTrace(); //fixme
         } catch (IOException e) {
             e.printStackTrace(); //fixme
         }
     }
		

}
