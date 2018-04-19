package teste;

import java.util.Date;

import util.DataHelper;

public class Teste {

	public static void main(String[] args) {
		DataHelper data = new DataHelper(new Date());
		System.out.println(data.getHorario());
		System.out.println(data.getDataMesAno());
	}

}
