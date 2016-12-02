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
import sistemaacademico.modelo.RegistroAcademico;

public class DaoRegistroAcademico {

    public static String inserir(RegistroAcademico r) {
        String sql
                = "INSERT INTO registro_academico "
                + "     (matricula_ra, curso_ra, periodo_ra, "
                + "      colaborador) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, r.getMatricula());
            stmt.setString(2, r.getCurso());
            stmt.setString(3, r.getPeriodo());
            stmt.setInt(4, r.getColaborador().getCodigo());
            stmt.executeUpdate();

            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoRegistroAcademico.class.getName()).log(Level.SEVERE, null, ex);
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

    public static String atualizar(RegistroAcademico r) {
        String sql
                = "UPDATE registro_academico "
                + "SET matricula_ra = ?, curso_ra = ?, periodo_ra = ?, colaborador = ?, "
                + "WHERE colaborador = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, r.getMatricula());
            stmt.setString(2, r.getCurso());
            stmt.setString(3, r.getPeriodo());
            stmt.setInt(4, r.getColaborador().getCodigo());
            stmt.executeUpdate();

            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoRegistroAcademico.class.getName()).log(Level.SEVERE, null, ex);
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
                = "DELETE FROM registro_academico WHERE colaborador = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoRegistroAcademico.class.getName()).log(Level.SEVERE, null, ex);
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

    public static sistemaacademico.modelo.RegistroAcademico recuperar(int codigo) {
        ArrayList<sistemaacademico.modelo.RegistroAcademico> result = recuperarQuery("WHERE colaborador = " + codigo);
        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    public static ArrayList<RegistroAcademico> recuperarTodos(int codigo) {
        return recuperarQuery("WHERE colaborador = " + codigo);
    }

    public static ArrayList<RegistroAcademico> recuperarQuery(String where) {
        String sql
                = "SELECT colaborador, matricula_ra, curso_ra, periodo_ra "
                + "FROM registro_academico "
                + where;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<RegistroAcademico> registros = new ArrayList<>();

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RegistroAcademico r = new RegistroAcademico();

                r.setColaborador(DaoColaborador.recuperar(rs.getInt("colaborador")));
                r.setMatricula(rs.getString("matricula_ra"));
                r.setCurso(rs.getString("curso_ra"));
                r.setPeriodo(rs.getString("periodo_ra"));
                registros.add(r);
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

        return registros;
    }

}
