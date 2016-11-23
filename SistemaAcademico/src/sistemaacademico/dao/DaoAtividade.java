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
import sistemaacademico.modelo.Atividade;

public class DaoAtividade {

    // TODO: O campo titulo_atv ainda não existe, deve ser criado
    public static String inserir(Atividade a) {
        String sql
                = "INSERT INTO atividade "
                + "     (titulo_atv, dataini_atv, datafim_atv, duracaoestimada_atv) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, a.getTitulo());
            stmt.setDate(2, new java.sql.Date(a.getDataInicio().getTime()));
            stmt.setDate(3, new java.sql.Date(a.getDataTermino().getTime()));
            stmt.setDate(4, new java.sql.Date(a.getDuracaoEstimada().getTime()));

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                a.setCodigo(rs.getInt(1));

            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoAtividade.class.getName()).log(Level.SEVERE, null, ex);
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

    public static String atualizar(Atividade a) {
        String sql
                = "UPDATE atividade "
                + "SET titulo_atv = ?, dataini_atv = ?, datafim_atv = ?, "
                + "    duracaoestimada_atv = ? "
                + "WHERE cod_atv = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, a.getTitulo());
            stmt.setDate(2, new java.sql.Date(a.getDataInicio().getTime()));
            stmt.setDate(3, new java.sql.Date(a.getDataTermino().getTime()));
            stmt.setDate(4, new java.sql.Date(a.getDuracaoEstimada().getTime()));

            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoAtividade.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql = "DELETE FROM atividade WHERE cod_atv = ?";
        PreparedStatement stmt = null;

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            return Mensagens.SUCESSO;
        } catch (SQLException ex) {
            Logger.getLogger(DaoAtividade.class.getName()).log(Level.SEVERE, null, ex);
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

    public static Atividade recuperar(int codigo) {
        ArrayList<Atividade> resultado = recuperarQuery("WHERE cod_atv = " + codigo);
        if (!resultado.isEmpty()) {
            return resultado.get(0);
        } else {
            return null;
        }
    }

    public static ArrayList<Atividade> recuperarTodos() {
        return recuperarQuery("");
    }

    private static ArrayList<Atividade> recuperarQuery(String where) {
        String sql
                = "SELECT cod_atv, titulo_atv, dataini_atv, datafim_atv, duracaoestimada_atv "
                + "FROM atividade "
                + where;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Atividade> atividades = new ArrayList<>();

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Atividade a = new Atividade();

                a.setCodigo(rs.getInt("cod_atv"));
                a.setTitulo(rs.getString("titulo_atv"));
                a.setDataInicio(rs.getDate("dataini_atv"));
                a.setDataTermino(rs.getDate("datafim_atv"));
                a.setDuracaoEstimada(rs.getDate("duracaoestimada_atv"));

                atividades.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAtividade.class.getName()).log(Level.SEVERE, null, ex);
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

        return atividades;
    }

    // TODO: É necessário existir uma tabela NxN entre atividades, uma vez que é
    // uma relacionamento recursivo. Um atividade pode depender de várias, enquanto
    // uma atividade pode ser dependências de várias.
    // Assume-se aqui que essa tabela será chamada 'dependencia_atividades'
    // com os campos 'cod_dependencia' (que é a atiivdade original) e
    // 'cod_dependente' (que é a atividade que possui a dependência).
    // Se outros nomes forem utilizados, esse código deve ser modificado.
    private static ArrayList<Integer> carregarCodigoDependencias(int codigo) {
        String sql
                = "SELECT cod_dependencia FROM dependencia_atividades "
                + "WHERE cod_dependente = codigo";
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> codigos = new ArrayList<>();

        try {
            Connection conn = FabricaConexao.GeraConexao();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                codigos.add(rs.getInt("cod_dependencia"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAtividade.class.getName()).log(Level.SEVERE, null, ex);
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

    public static ArrayList<Atividade> carregarDependencias(int codigo) {
        ArrayList<Integer> codigos = carregarCodigoDependencias(codigo);
        ArrayList<Atividade> dependencias = new ArrayList<>();

        for (Integer codDependencia : codigos) {
            dependencias.add(recuperar(codDependencia));
        }

        return dependencias;
    }

}
