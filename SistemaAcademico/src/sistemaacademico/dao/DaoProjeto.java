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
import sistemaacademico.modelo.Projeto;

public class DaoProjeto {

    public static String inserir(Projeto p) {
        String sql
                = "INSERT INTO projeto "
                + "(nome_proj, objetivo_proj, recursos_proj) "
                + "VALUES (?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getObjetivo());
            stmt.setString(3, p.getRecursos());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                p.setCodigo(rs.getInt(1));

            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjeto.class.getName()).log(Level.SEVERE, null, ex);
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

    public static String atualizar(Projeto p) {
        String sql
                = "UPDATE projeto "
                + "SET nome_proj = ?, objetivo_proj = ?, recursos_proj = ? "
                + "WHERE cod_proj = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getObjetivo());
            stmt.setString(3, p.getRecursos());
            stmt.setInt(4, p.getCodigo());

            stmt.executeUpdate();
            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjeto.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql = "DELETE FROM projeto WHERE cod_proj = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();

            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjeto.class.getName()).log(Level.SEVERE, null, ex);
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

    // TODO: É necessário introduzir o campo 'gerente_proj' na tabela 'projeto',
    // que é uma FK para o Colaborador que é gerente do projeto.
    public static ArrayList<Projeto> recuperarProjetosDoGerente(int codigoGerente) {
        return recuperarQuery("WHERE gerente_proj = " + codigoGerente);
    }

    public static Projeto recuperar(int codigo) {
        ArrayList<Projeto> result = recuperarQuery("where cod_proj = " + codigo);
        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    public static ArrayList<Projeto> recuperarTodos() {
        return recuperarQuery("");
    }

    public static ArrayList<Projeto> recuperarQuery(String where) {
        String sql
                = "SELECT cod_proj, nome_proj, objetivo_proj, recursos_proj "
                + "FROM projeto "
                + where;

        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Projeto> projetos = new ArrayList<>();

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Projeto p = new Projeto();

                p.setCodigo(rs.getInt("cod_proj"));
                p.setNome(rs.getString("nome_proj"));
                p.setObjetivo(rs.getString("objetivo_proj"));
                p.setRecursos(rs.getString("recursos_proj"));

                projetos.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoProjeto.class.getName()).log(Level.SEVERE, null, ex);
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

        return projetos;
    }
}
