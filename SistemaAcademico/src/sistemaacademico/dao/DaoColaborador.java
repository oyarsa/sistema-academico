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
import sistemaacademico.modelo.Colaborador;

public class DaoColaborador {

    public static String inserir(Colaborador c) {
        String sql
                = "INSERT INTO colaborador "
                + "     (nome_col, cpf_col, rg_col, ativo_col, "
                + "      email_col, mae_col, pai_col, categoria_col, "
                + "      login_col, senha_col) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getRg());
            stmt.setBoolean(4, c.isAtivo());
            stmt.setString(5, c.getEmail());
            stmt.setString(6, c.getNomeMae());
            stmt.setString(7, c.getNomePai());
            stmt.setString(8, c.getCategoria());
            stmt.setString(9, c.getLogin());
            stmt.setString(10, c.getSenha());
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

    public static String atualizar(Colaborador c) {
        String sql
                = "UPDATE colaborador "
                + "SET nome_col = ?, cpf_col = ?, rg_col = ?, ativo_col = ?, "
                + "    email_col = ?, mae_col = ?, pai_col = ?, categoria_col = ?, "
                + "    login_col = ?, senha_col = ? "
                + "WHERE cod_col = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getRg());
            stmt.setBoolean(4, c.isAtivo());
            stmt.setString(5, c.getEmail());
            stmt.setString(6, c.getNomeMae());
            stmt.setString(7, c.getNomePai());
            stmt.setString(8, c.getCategoria());
            stmt.setString(9, c.getLogin());
            stmt.setString(10, c.getSenha());
            stmt.setInt(11, c.getCodigo());
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

    public static String remover(int codigo) {
        String sql
                = "DELETE FROM colaborador WHERE cod_col = ?";
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

    public static Colaborador recuperar(int codigo) {
        ArrayList<Colaborador> result = recuperarQuery("where cod_col = " + codigo);
        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    public static ArrayList<Colaborador> recuperarTodos() {
        return recuperarQuery("");
    }

    public static ArrayList<Colaborador> recuperarQuery(String where) {
        String sql
                = "SELECT cod_col, nome_col, cpf_col, rg_col, ativo_col, "
                + "       email_col, mae_col, pai_col, categoria_col, "
                + "       login_col, senha_col "
                + "FROM colaborador "
                + where;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Colaborador> colaboradores = new ArrayList<>();

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Colaborador c = new Colaborador();

                c.setCodigo(rs.getInt("cod_col"));
                c.setNome(rs.getString("nome_col"));
                c.setCpf(rs.getString("cpf_col"));
                c.setRg(rs.getString("rg_col"));
                c.setAtivo(rs.getBoolean("ativo_col"));
                c.setEmail(rs.getString("email_col"));
                c.setNomeMae(rs.getString("mae_col"));
                c.setNomePai(rs.getString("pai_col"));
                c.setCategoria(rs.getString("categoria_col"));
                c.setLogin(rs.getString("login_col"));
                c.setSenha(rs.getString("senha_col"));

                colaboradores.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoColaborador.class.getName()).log(Level.SEVERE, null, ex);
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

        return colaboradores;
    }

}
