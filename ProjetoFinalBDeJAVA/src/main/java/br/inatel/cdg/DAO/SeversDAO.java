package br.inatel.cdg.DAO;

import br.inatel.cdg.personagem.Personagem;
import br.inatel.cdg.servers.Servers;

import java.sql.SQLException;
import java.util.ArrayList;

public class SeversDAO extends ConnectionDAO {
        //DAO - Data Access Object
        boolean sucesso = false; //Para saber se funcionou
        public boolean inserirSevers(Servers s) {
            connectToDB();
            String sql = "INSERT INTO Servers (Regiao) values(?)";
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, s.regiao);
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

        public boolean atualizarServers(int id, Servers s) {
            connectToDB();
            String sql = "UPDATE Servers SET regiao=? where idServers=?";
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, s.regiao);
                pst.setInt(2, id);


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
    public ArrayList<Servers> buscarServersSemFiltro() {
        ArrayList<Servers> listaDeServers = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM servers";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de Servers: ");
            while (rs.next()) {
                Servers serversAux = new Servers();
                serversAux.id = rs.getInt("idServers");
                serversAux.regiao = rs.getString("regiao");
                System.out.println("idServers = " + serversAux.id);
                System.out.println("regiao = " + serversAux.regiao);
                System.out.println("--------------------------------");
                listaDeServers.add(serversAux);
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
        return listaDeServers;
    }

}
