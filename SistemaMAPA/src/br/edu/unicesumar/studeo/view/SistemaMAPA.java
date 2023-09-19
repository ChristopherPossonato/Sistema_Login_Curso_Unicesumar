package br.edu.unicesumar.studeo.view;

import br.edu.unicesumar.studeo.core.DAO.ConexaoDAO;


public class SistemaMAPA {

  
    public static void main(String[] args) {
       try {
            ConexaoDAO.getConexao();
            // Faça o que precisar com a conexão aqui
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro na classe principal: " + e.getMessage());
        }
       
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setVisible(true);
        
    }
    
}
