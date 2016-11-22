package sistemaacademico.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemaacademico.Util.Mensagens;
import sistemaacademico.modelo.Colaborador;
import sistemaacademico.modelo.Projeto;

// TODO: Modificar(?) nome da tabela quando ela estiver pronta
public class DaoColaboradorProjeto {

    public static String inserir(int codProjeto, int codColaboador) {
        String sql
                = "INSERT INTO colaborador_projeto "
                + "(cod_proj, cod_col) "
                + "VALUES (?, ?)";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codProjeto);
            stmt.setInt(2, codColaboador);
            stmt.executeUpdate();
            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoColaboradorProjeto.class.getName()).log(Level.SEVERE, null, ex);
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

    public static String remover(int codProjeto, int codColaborador) {
        String sql
                = "DELETE FROM colaborador_projeto "
                + "WHERE cod_proj = ?, cod_col = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codProjeto);
            stmt.setInt(2, codColaborador);
            stmt.executeUpdate();

            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoColaboradorProjeto.class.getName()).log(Level.SEVERE, null, ex);
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

    private static ArrayList<Integer> carregarCodigosProjeto(int codColaborador) {
        String sql = "SELECT cod_proj FROM projeto WHERE cod_col = ?";
        PreparedStatement stmt = null;
        ArrayList<Integer> codigos = new ArrayList<>();
        ResultSet rs = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codColaborador);
            rs = stmt.executeQuery();

            while (rs.next()) {
                codigos.add(rs.getInt("cod_proj"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoColaboradorProjeto.class.getName()).log(Level.SEVERE, null, ex);
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

        return codigos;
    }

    public static ArrayList<Projeto> recuperarProjetos(int codColaborador) {
        ArrayList<Projeto> projetos = new ArrayList<>();
        ArrayList<Integer> codigos = carregarCodigosProjeto(codColaborador);

        for (Integer codProj : codigos) {
            projetos.add(DaoProjeto.recuperar(codProj));
        }
        return projetos;
    }

    private static ArrayList<Integer> carregarCodigosColaborador(int codProjeto) {
        String sql = "SELECT cod_col FROM projeto WHERE cod_proj = ?";
        PreparedStatement stmt = null;
        ArrayList<Integer> codigos = new ArrayList<>();
        ResultSet rs = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codProjeto);
            rs = stmt.executeQuery();

            while (rs.next()) {
                codigos.add(rs.getInt("cod_col"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoColaboradorProjeto.class.getName()).log(Level.SEVERE, null, ex);
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

        return codigos;
    }

    public static ArrayList<Colaborador> recuperarColabadores(int codProjeto) {
        ArrayList<Colaborador> colaboradores = new ArrayList<>();
        ArrayList<Integer> codigos = carregarCodigosColaborador(codProjeto);

        for (Integer codColaborador : codigos) {
            colaboradores.add(DaoColaborador.recuperar(codColaborador));
        }
        return colaboradores;
    }
}
