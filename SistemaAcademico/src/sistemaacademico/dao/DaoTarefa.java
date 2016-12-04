package sistemaacademico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemaacademico.Util.Mensagens;
import sistemaacademico.modelo.Tarefa;

public class DaoTarefa {

    public static String inserir(Tarefa t, int codigoAtividade) {
        String sql
                = "INSERT INTO tarefa "
                + "(horain_trf, horaterm_trf, observacao_trf, tipo_trabalho, colaborador, atividade) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setDate(1, new java.sql.Date(t.getHoraInicio().getTime()));
            stmt.setDate(2, new java.sql.Date(t.getHoraTermino().getTime()));
            stmt.setString(3, t.getObservacao());
            stmt.setInt(4, t.getTipo().getCodigo());
            stmt.setInt(5, t.getResponsavel().getCodigo());
            stmt.setInt(6, codigoAtividade);

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

    public static String atualizar(Tarefa t, int codigoAtividade) {
        String sql
                = "UPDATE tarefa "
                + "SET horain_trf =?, horaterm_trf=?, observacao_trf=?, tipo_trabalho=?, "
                + "    colaborador=?, atividade=? "
                + "WHERE cod_trf = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setDate(1, new java.sql.Date(t.getHoraInicio().getTime()));
            stmt.setDate(2, new java.sql.Date(t.getHoraTermino().getTime()));
            stmt.setString(3, t.getObservacao());
            stmt.setInt(4, t.getTipo().getCodigo());
            stmt.setInt(5, t.getResponsavel().getCodigo());
            stmt.setInt(6, codigoAtividade);
            stmt.setInt(7, t.getCodigo());

            stmt.executeUpdate();

            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTarefa.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql = "DELETE FROM tarefa WHERE cod_trf = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTarefa.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Tarefa recuperar(int codigo) {
        ArrayList<Tarefa> resultado = recuperarQuery("WHERE cod_trf = " + codigo);
        if (!resultado.isEmpty()) {
            return resultado.get(0);
        } else {
            return null;
        }
    }

    public static ArrayList<Tarefa> recuperarTodos(int codigo) {
        return recuperarQuery("WHERE atividade = " + codigo);
    }

    private static ArrayList<Tarefa> recuperarQuery(String where) {
        String sql
                = "SELECT cod_trf, horain_trf, horaterm_trf, observacao_trf, tipo_trabalho, colaborador "
                + "FROM tarefa "
                + where;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Tarefa> tarefas = new ArrayList<>();

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Tarefa t = new Tarefa();

                t.setCodigo(rs.getInt("cod_trf"));
                t.setHoraInicio(new Date(rs.getDate("horain_trf").getTime()));
                t.setHoraTermino(new Date(rs.getDate("horaterm_trf").getTime()));
                t.setObservacao(rs.getString("observacao_trf"));
                t.setTipo(DaoTipoTrabalho.recuperar(rs.getInt("tipo_trabalho")));
                t.setResponsavel(DaoColaborador.recuperar(rs.getInt("colaborador")));

                tarefas.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoTarefa.class.getName()).log(Level.SEVERE, null, ex);
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

        return tarefas;
    }

}
