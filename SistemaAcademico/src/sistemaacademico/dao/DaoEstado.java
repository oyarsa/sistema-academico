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
import sistemaacademico.modelo.Estado;

public class DaoEstado {

    public static String inserir(sistemaacademico.modelo.Estado e, int codigo) {
        String sql
                = "INSERT INTO estado "
                + "     (nome_est, dataini_est, "
                + "      datafim_est, colaborador) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, e.getNome());
            stmt.setDate(2, new java.sql.Date(e.getDataInicio().getTime()));
            stmt.setDate(3, new java.sql.Date(e.getDataTermino().getTime()));
            stmt.setInt(4, codigo);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                e.setCodigo(rs.getInt(1));

            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstado.class.getName()).log(Level.SEVERE, null, ex);
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

    public static String atualizar(sistemaacademico.modelo.Estado e) {
        String sql
                = "UPDATE estado "
                + "SET nome_est = ?, dataini_est = ?, datafim_est = ?, "
                + "WHERE cod_est = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, e.getNome());
            stmt.setDate(2, new java.sql.Date(e.getDataInicio().getTime()));
            stmt.setDate(3, new java.sql.Date(e.getDataTermino().getTime()));
            stmt.setInt(5, e.getCodigo());
            stmt.executeUpdate();

            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstado.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql
                = "DELETE FROM estado WHERE cod_est = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstado.class.getName()).log(Level.SEVERE, null, ex);
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

    public static sistemaacademico.modelo.Estado recuperar(int codigo) {
        ArrayList<sistemaacademico.modelo.Estado> result = recuperarQuery("where cod_est = " + codigo);
        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    public static ArrayList<Estado> recuperarTodos(int codigo) {
        return recuperarQuery("WHERE colaborador = " + codigo);
    }

    public static ArrayList<Estado> recuperarQuery(String where) {
        String sql
                = "SELECT cod_est, nome_est, dataini_est, datafim_est "
                + "FROM estado "
                + where;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Estado> estados = new ArrayList<>();

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Estado e = new Estado();

                e.setCodigo(rs.getInt("cod_est"));
                e.setNome(rs.getString("nome_est"));
                e.setDataInicio(rs.getDate("dataini_est"));
                e.setDataTermino(rs.getDate("datafim_est"));

                estados.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstado.class.getName()).log(Level.SEVERE, null, ex);
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

        return estados;
    }

}
