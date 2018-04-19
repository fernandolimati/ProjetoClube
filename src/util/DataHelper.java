package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataHelper {

	private Date data;
	private transient SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public DataHelper() {}
	public DataHelper(Date data) {
		this.data = data;
	}
	public DataHelper(String dataString) throws Exception {
		this.data = new Date(formatador.parse(dataString).getTime());
	}

	public Date getData() {
		return data;
	}
	public String getDataString() {
		return formatador.format(data);
	}

	public void setData(Date data) {
		this.data = data;
	}
	public void setData(String dataString) throws Exception {
		this.data = new Date(formatador.parse(dataString).getTime());
	}

	public SimpleDateFormat getFormatador() {
		return formatador;
	}
	public void setFormatador(SimpleDateFormat formatador) {
		this.formatador = formatador;
	}
	
	private void adicionar(int quantidade, int tipoCampo) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(data);
		gc.add(tipoCampo, quantidade);
		data = gc.getTime();
	}
	public void adicionarDias(int quantidade) {
		adicionar(quantidade, Calendar.DAY_OF_MONTH);
	}
	public void adicionarMeses(int quantidade) {
		adicionar(quantidade, Calendar.MONTH);
	}
	public void adicionarAnos(int quantidade) {
		adicionar(quantidade, Calendar.YEAR);
	}
	public void adicionarHoras(int quantidade) {
		adicionar(quantidade, Calendar.HOUR);
	}
	public void adicionarMinutos(int quantidade) {
		adicionar(quantidade, Calendar.MINUTE);
	}
	public void adicionarSegundos(int quantidade) {
		adicionar(quantidade, Calendar.SECOND);
	}
	
	public int comparar(Date data) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(data);
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		return gc.compareTo(c);
	}
	public Integer comparar(String data) throws Exception {
		try {
			return comparar(formatador.parse(data));
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}
	}
	
}