package teste;

import java.util.ArrayList;
import java.util.Scanner;

import entidade.EntidadeTipoAssociado;
import persistencia.TipoAssociadoDaoRest;

public class TesteTipoAssociado {
	
	static TipoAssociadoDaoRest dao;
    
    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	
    	boolean saida = false;
    	while(!saida) {
    		System.out.println("|---------------------------------------------------------|");
    		System.out.println("|---------------      TIPO ASSOCIADO          ------------|");
    		System.out.println("|---------------------------------------------------------|");
    		System.out.println("|---- 1- Listagem                                   ------|");
    		System.out.println("|---- 2- Incluir                                    ------|");
    		System.out.println("|---- 3- Atualizar                                  ------|");
    		System.out.println("|---- 4- Consulta                                   ------|");
    		System.out.println("|---- 5- Exluir                                     ------|");
    		System.out.println("|---------------------------------------------------------|");
    		System.out.print  ("|---- Selecione o teste pretendido:. ");
        	int opc = new Scanner(System.in).nextInt();
        	switch(opc) {
        	case 1:
        		//TIPO ASSOCIADO TESTE LISTAGEM
        		limparTela();
        		try {
					tipoAssociadoListagemTeste();
				} catch (Exception e) {
					e.printStackTrace();
				}
        		break;
        		
        	case 2:
        		//TIPO ASSOCIADO TESTE INCLUIR
        		System.out.println("Descricao:. ");
            	String descricao = new Scanner(System.in).nextLine();
            	System.out.println("Valor:. ");
            	double valor = new Scanner(System.in).nextDouble();
        		try {
					tipoAssociadoIncluirTeste(descricao,valor);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		limparTela();
        		break;
        		
        	case 3:
        		//TIPO ASSOCIADO TESTE ATUALIZAR
        		limparTela();
        		EntidadeTipoAssociado obj = new EntidadeTipoAssociado();
        		System.out.println("ID:.");
            	obj.setCodigo(new Scanner(System.in).nextInt());
            	System.out.println("Descricao Nova:.");
            	obj.setDescricao(new Scanner(System.in).nextLine());
            	System.out.println("Valor Novo:.");
            	obj.setValorMensalidade(new Scanner(System.in).nextDouble());
            	try {
					tipoAssociadoAtualizarTeste(obj);
				} catch (Exception e) {
					e.printStackTrace();
				}
        		break;
        		
        	case 4:
        		//TIPO ASSOCIADO TESTE CONSULTA
        		limparTela();
        		System.out.println("ID:.");
            	try {
					tipoAssociadoConsultaTeste(new Scanner(System.in).nextInt());
				} catch (Exception e) {
					e.printStackTrace();
				}
        		break;
        	
        	case 5:
        		//TIPO ASSOCIADO TESTE EXCLUIR
        		System.out.println("ID:.");
        		try {
					tipoAssociadoExcluirTeste(new Scanner(System.in).nextInt());
				} catch (Exception e) {
					e.printStackTrace();
				}
        		limparTela();
        		break;
        	
        	case 0:
        		limparTela();
        		saida = true;
        		System.out.println("Finalizado com sucesso....");
        		break;
        	}
    	}
    	
    	
        
        
    }
    
    public static void limparTela() {
		for(int i=0;i<50;i++)System.out.println();
	}
    
    public static void tipoAssociadoListagemTeste() throws Exception {
    	dao = TipoAssociadoDaoRest.getInstance();
    	System.out.println(" ___________________________________________________________________");
    	System.out.println("|                    LISTAGEM TIPO ASSOCIADO                        |");
    	System.out.println("|___________________________________________________________________|");
        System.out.println("|   COD   |           DESCRICAO           |    VALOR MENSALIDADE    |");
        System.out.println("|___________________________________________________________________|");
        ArrayList<EntidadeTipoAssociado> listaSaida = dao.listar();
		for(EntidadeTipoAssociado ass:listaSaida) {
			System.out.print("| "+ass.getCodigo());
			for(int i=Integer.toString(ass.getCodigo()).length();i<7;i++) System.out.print(" ");
			System.out.print(" | "+ass.getDescricao());
			for(int i=ass.getDescricao().length();i<29;i++) System.out.print(" ");
			System.out.print(" | R$"+ass.getValorMensalidade());
			for(int i=Double.toString(ass.getValorMensalidade()).length();i<22;i++) System.out.print(" ");
			System.out.println("|");
		}
		System.out.println("|___________________________________________________________________|");
		System.out.println("");
    }

    public static void tipoAssociadoIncluirTeste(String descricao, double mensalidade) throws Exception {
    	dao = TipoAssociadoDaoRest.getInstance();
    	EntidadeTipoAssociado objTipoAssociado = new EntidadeTipoAssociado();
    	objTipoAssociado.setDescricao(descricao);
    	objTipoAssociado.setValorMensalidade(mensalidade);
    	dao.incluir(objTipoAssociado);
 
    }
    
    public static void tipoAssociadoAtualizarTeste(EntidadeTipoAssociado obj) throws Exception {
    	dao = TipoAssociadoDaoRest.getInstance();
    	dao.atualizar(obj);
    }

    public static void tipoAssociadoConsultaTeste(int id) throws Exception {
    	dao = TipoAssociadoDaoRest.getInstance();
    	EntidadeTipoAssociado ass = dao.consultar(id);
		System.out.println("Cod:. "+ass.getCodigo()+" | Descrição:. "+ass.getDescricao()+" | Valor Mensalidade:. R$"+ass.getValorMensalidade());
    }

    public static void tipoAssociadoExcluirTeste(int id) throws Exception {
    	dao = TipoAssociadoDaoRest.getInstance();
    	System.out.println("Excluir Response: "+ dao.excluir(id));
    }

}
