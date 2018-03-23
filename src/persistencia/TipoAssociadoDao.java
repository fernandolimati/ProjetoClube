package persistencia;

import entidade.EntidadeTipoAssociado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TipoAssociadoDao {

    public void incluir(EntidadeTipoAssociado tipo) throws SQLException {

        String sql = "INSERT INTO tipoassociado (descricao, valormensalidade)"
                + " VALUES(?,?)";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, tipo.getDescricao());
        prd.setDouble(2, tipo.getValorMensalidade());

        prd.execute();
    }

    public void atualizar(EntidadeTipoAssociado tipo) throws SQLException {

        String sql = "UPDATE tipoassociado SET"
                + " descricao=?, valormensalidade=?"
                + " WHERE codigo=?";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, tipo.getDescricao());
        prd.setDouble(2, tipo.getValorMensalidade());
        prd.setInt(3, tipo.getCodigo());

        prd.execute();

    }

    public void excluir(int codigo) throws SQLException {
        String sql = "DELETE FROM tipoassociado "
                + "WHERE codigo=?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, codigo);

        prd.execute();

    }

    public EntidadeTipoAssociado consultar(int codigo) {
    	
    	
    	
    	return null;
    }

    public ArrayList<EntidadeTipoAssociado> listar() throws SQLException {
        String sql = "SELECT tb.codigo, tb.descricao, tb.valorMensalidade "
                + " FROM tipoassociado tb ORDER BY codigo";

        Connection cnn = util.Conexao.getConexao();
        Statement prd = cnn.createStatement();
        ResultSet rs = prd.executeQuery(sql);
        ArrayList<EntidadeTipoAssociado> lista = new ArrayList<EntidadeTipoAssociado>();

        while (rs.next()) {
            EntidadeTipoAssociado tipo = new EntidadeTipoAssociado();
            tipo.setCodigo(rs.getInt("codigo"));
            tipo.setDescricao(rs.getString("descricao"));
            tipo.setValorMensalidade(rs.getDouble("valormensalidade"));
            lista.add(tipo);
        }
        return lista;

    }

}
