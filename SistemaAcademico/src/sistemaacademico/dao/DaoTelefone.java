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
import sistemaacademico.modelo.Telefone;

public class DaoTelefone {
    public static String inserir(sistemaacademico.modelo.Telefone t, int codigo) {
        String sql
                = "INSERT INTO telefone "
                + "     (ddi_tel, ddd_tel, numero_tel, "
                + "      operadora_tel, colaborador) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, t.getDdi());
            stmt.setString(2, t.getDdd());
            stmt.setString(3, t.getNumero());
            stmt.setString(4, t.getOperadora());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                t.setCodigo(rs.getInt(1));

            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoColaborador.class.getName()).log(Level.SEVERE, null, ex);
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

    public static String atualizar(Telefone t) {
        String sql
                = "UPDATE telefone "
                + "SET ddi_tel = ?, ddd_tel = ?, numero_tel = ?, operadora_tel = ?, "
                + "    colaborador = ?"
                + "WHERE cod_tel = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, t.getDdd());
            stmt.setString(2, t.getDdi());
            stmt.setString(3, t.getNumero());
            stmt.setString(4, t.getOperadora());
            stmt.setInt(5, t.getCodigo());
            stmt.executeUpdate();

            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTelefone.class.getName()).log(Level.SEVERE, null, ex);
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
                = "DELETE FROM telefone WHERE cod_tel = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoColaborador.class.getName()).log(Level.SEVERE, null, ex);
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

    public static sistemaacademico.modelo.Telefone recuperar(int codigo) {
        ArrayList<sistemaacademico.modelo.Telefone> result = recuperarQuery("where cod_tel = " + codigo);
        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    public static ArrayList<Telefone> recuperarTodos(int codigo) {
        return recuperarQuery("WHERE colaborador = " + codigo);
    }

    public static ArrayList<Telefone> recuperarQuery(String where) {
        String sql
                = "SELECT cod_tel, ddi_tel, ddd_tel, numero_tel, operadora_tel, "
                + "FROM telefone "
                + where;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Telefone> telefones = new ArrayList<>();

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Telefone t = new Telefone();

                t.setCodigo(rs.getInt("cod_tel"));
                t.setDdd(rs.getString("ddd_tel"));
                t.setDdi(rs.getString("ddi_tel"));
                t.setNumero(rs.getString("numero_tel"));
                t.setOperadora(rs.getString("operadora_tel"));
          

                telefones.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTelefone.class.getName()).log(Level.SEVERE, null, ex);
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

        return telefones;
    }

}
