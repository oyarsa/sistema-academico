package sistemaacademico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemaacademico.Util.Mensagens;
import sistemaacademico.modelo.TipoTrabalho;

public class DaoTipoTrabalho {

    public static String inserir(TipoTrabalho t) {
        String sql
                = "INSERT INTO tipo_trabalho "
                + "(tipo_tt) "
                + "VALUES (?)";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, t.getDescricao());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                t.setCodigo(rs.getInt(1));

            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipoTrabalho.class.getName()).log(Level.SEVERE, null, ex);
            return Mensagens.ERRO + ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    public static String atualizar(TipoTrabalho t) {
        String sql
                = "UPDATE tipo_trabalho "
                + "SET tipo_tt = ?"
                + "WHERE cod_tt = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, t.getDescricao());
            stmt.setInt(2, t.getCodigo());

            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipoTrabalho.class.getName()).log(Level.SEVERE, null, ex);
            return Mensagens.ERRO + ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    public static String remover(int codigo) {
        String sql = "DELETE FROM tipo_trabalho WHERE cod_tt = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipoTrabalho.class.getName()).log(Level.SEVERE, null, ex);
            return Mensagens.ERRO + ex.getMessage();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    public static TipoTrabalho recuperar(int codigo) {
        ArrayList<TipoTrabalho> resultado = recuperarQuery("WHERE cod_tt = " + codigo);
        if (!resultado.isEmpty()) {
            return resultado.get(0);
        } else {
            return null;
        }
    }

    public static ArrayList<TipoTrabalho> recuperarTodos() {
        return recuperarQuery("");
    }

    private static ArrayList<TipoTrabalho> recuperarQuery(String where) {
        String sql
                = "SELECT cod_tt, tipo_tt "
                + "FROM tipo_trabalho "
                + where;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<TipoTrabalho> tipoTrabalho = new ArrayList<>();

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                TipoTrabalho t = new TipoTrabalho();

                t.setCodigo(rs.getInt("cod_tt"));
                t.setDescricao(rs.getString("tipo_tt"));

                tipoTrabalho.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipoTrabalho.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
        }

        return tipoTrabalho;
    }

}
