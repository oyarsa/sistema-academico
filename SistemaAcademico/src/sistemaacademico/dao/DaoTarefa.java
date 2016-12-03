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
import sistemaacademico.modelo.Tarefa;


public class DaoTarefa {
    public static String inserir(Tarefa t) {
        String sql
                = "INSERT INTO tarefa "
                + "(horain_trf, horaterm_trf, observacao_trf, tipo_trabalho, colaborador) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, t.getHoraInicio().toString());
            stmt.setString(2, t.getHoraTermino().toString());
            stmt.setString(3, t.getObservacao());
            stmt.setInt(4, t.getTipo().getCodigo());
            stmt.setInt(5,t.getResponsavel().getCodigo());

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
  
    public static String atualizar(Tarefa t) {
        String sql
                = "UPDATE tarefa "
                + "SET horain_trf =?, horaterm_trf=?, observacao_trf=?, tipo_trabalho=?, colaborador=?"
                + "WHERE cod_trf = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, (t.getHoraInicio().getTime()));
            stmt.setString(2, (t.getHoraTermino().getTime()));
            stmt.setString(3, t.getObservacao());
            stmt.setString(4, t.getTipo().toString());
            stmt.setString(5, t.getResponsavel().toString());

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

    public static ArrayList<Tarefa> recuperarTodos() {
        return recuperarQuery("");
    }

    private static ArrayList<Tarefa> recuperarQuery(String where) {
        String sql
                = "SELECT cod_trf, horaini_trf, horaterm_trf, observacao_trf, tipo_trabalho, colaborador "
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
                t.setHoraInicio(rs.getTime("horaini_trf"));
                t.setHoraTermino(rs.getTime("horaterm_trf"));
                t.setObservacao(rs.getString("observacao_trf"));
                t.setTipo(DaoTipoTrabalho.recuperar(rs.getInt("cod_tt")));
                t.setResponsavel(DaoColaborador.recuperar(rs.getInt("cod_col")));

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
