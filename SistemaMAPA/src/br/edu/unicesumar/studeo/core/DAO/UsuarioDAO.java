package br.edu.unicesumar.studeo.core.DAO;

import br.edu.unicesumar.studeo.core.entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class UsuarioDAO {
   
    Connection conexao;
    
    public boolean inserirUsuario(Usuario usuario){
        conexao = ConexaoDAO.getConexao();
        
        try {
            String sql = "INSERT INTO usuario (nome, login, senha, email) VALUES (?, ?, ?, ?)";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getLogin());
            pstm.setString(3, usuario.getSenha());
            pstm.setString(4, usuario.getEmail());
            
            int rowsAffected = pstm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuário: " + e.getMessage());
            return false;
        } 
    }
  
   
    public ResultSet autenticacaoUsuario(Usuario usuario) {
        conexao = ConexaoDAO.getConexao();
        
        try {
            String sql = " SELECT id, nome, login, senha , email from usuario where login = ? AND senha = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, usuario.getLogin());
            pstm.setString(2, usuario.getSenha());

            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException err) {
                JOptionPane.showMessageDialog(null, "Erro ao autenticar usuário: " + err.getMessage());
                return null;
        }
    }   
}

