package org.senai.dao;

import org.senai.dao.interf.IDAO;
import org.senai.model.Estudante;
import org.senai.model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO implements IDAO<Estudante> {

    public void inserir(Estudante estudante) {
        String sqlPessoa = "INSERT INTO pessoas (nome, email) VALUES (?, ?)";
        String sqlEstudante = "INSERT INTO estudantes (pessoa_id, matricula) VALUES (?, ?)";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmtPessoa = conexao.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtEstudante = conexao.prepareStatement(sqlEstudante)) {

            conexao.setAutoCommit(false);

            // Inserir na tabela de pessoas
            stmtPessoa.setString(1, estudante.getNome());
            stmtPessoa.setString(2, estudante.getEmail());
            stmtPessoa.executeUpdate();

            try (ResultSet generatedKeys = stmtPessoa.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    estudante.setId(generatedKeys.getInt(1));
                }
            }
            // Inserir na tabela de estudantes
            stmtEstudante.setInt(1, estudante.getId());
            stmtEstudante.setString(2, estudante.getMatricula());
            stmtEstudante.executeUpdate();

            conexao.commit();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir estudante: " + e.getMessage());
        }
    }

    @Override
    public Estudante buscarPorId(int id) {
        String sql = "SELECT e.id, e.nome, e.email, es.matricula " +
                "FROM pessoas e " +
                "JOIN estudantes es " +
                "ON e.id = es.pessoa_id WHERE e.id = ?";

        Estudante estudante = null;

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                estudante = new Estudante(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("matricula")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudante;
    }

    @Override
    public List<Estudante> listarTodos() {
        String sql = "SELECT e.id, e.nome, e.email, es.matricula " +
                "FROM pessoas e " +
                "JOIN estudantes es " +
                "ON e.id = es.pessoa_id";
        List<Estudante> estudantes = new ArrayList<>();

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estudante estudante = new Estudante(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("matricula")
                );
                estudantes.add(estudante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudantes;
    }

    @Override
    public void atualizar(Estudante entidade) {
        String sqlPessoa = "UPDATE pessoas SET nome = ?, email = ? WHERE id = ?";
        String sqlProfessor = "UPDATE estudantes SET matricula = ? WHERE pessoa_id = ?";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmtPessoa = conexao.prepareStatement(sqlPessoa);
             PreparedStatement stmtProfessor = conexao.prepareStatement(sqlProfessor)) {

            conexao.setAutoCommit(false);

            Pessoa estudante = null;

            stmtPessoa.setString(1, estudante.getNome());
            stmtPessoa.setString(2, estudante.getEmail());
            stmtPessoa.setInt(3, estudante.getId());
            stmtPessoa.executeUpdate();

            PreparedStatement stmtEstudante = null;

            stmtEstudante.setString(1, entidade.getMatricula());
            stmtEstudante.setInt(2, estudante.getId());
            stmtEstudante.executeUpdate();

            conexao.commit();
        }  catch (SQLException rollbackEx) {
            System.err.println("Erro no rollback: " + rollbackEx.getMessage());
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM pessoas WHERE id = ?";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

