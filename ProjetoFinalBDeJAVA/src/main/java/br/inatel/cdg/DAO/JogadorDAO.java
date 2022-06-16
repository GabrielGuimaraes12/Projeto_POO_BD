package br.inatel.cdg.DAO;

import br.inatel.cdg.jogador.Jogador;


import java.sql.SQLException;
import java.util.ArrayList;

public class JogadorDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    public boolean inserirJogador(Jogador j) {
        connectToDB();
        String sql = "INSERT INTO Jogador (idJogador,nome,idade,endereco,senha) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, j.idJogador);
            pst.setString(2, j.nome);
            pst.setInt(3, j.idade);
            pst.setString(4, j.endereço);
            pst.setInt(5, j.senha);
            pst.execute();
            sucesso = true;
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean atualizarJogador(int id, Jogador j) {
        connectToDB();
        String sql = "UPDATE Jogador SET nome=?, idade=?, endereco=?, senha=? where idJogador=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, j.nome);
            pst.setInt(2, j.idade);
            pst.setString(3, j.endereço);
            pst.setInt(4, j.senha);
            pst.setInt(5, id);
            pst.execute();
            sucesso = true;
        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
    public ArrayList<Jogador> buscarJogadorSemFiltro() {
        ArrayList<Jogador> listaDeJogadores = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Jogador";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Jogadores: ");
            while (rs.next()) {
                Jogador jogadorAux = new Jogador();
                jogadorAux.idJogador = rs.getInt("idJogador");
                jogadorAux.nome = rs.getString("nome");
                jogadorAux.idade = rs.getInt("idade");
                jogadorAux.endereço = rs.getString("endereco");
                jogadorAux.senha = rs.getInt("senha");
                System.out.println("idJogador = " + jogadorAux.idJogador);
                System.out.println("nome = " + jogadorAux.nome);
                System.out.println("idade = " + jogadorAux.idade);
                System.out.println("endereco = " + jogadorAux.endereço);
                System.out.println("senha = " + jogadorAux.senha);
                System.out.println("--------------------------------");
                listaDeJogadores.add(jogadorAux);
            }
            sucesso = true;
        } catch(SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch(SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return listaDeJogadores;
    }


}
