package br.inatel.cdg.DAO;
import br.inatel.cdg.personagem.Personagem;
import java.sql.SQLException;
import java.util.ArrayList;
    public class PersonagemDAO extends ConnectionDAO {
        //DAO - Data Access Object
        boolean sucesso = false; //Para saber se funcionou
        public boolean inserirPersonagem(Personagem p) {
            connectToDB();
            String sql = "INSERT INTO Personagem (nome,raça,especializaçao,classe,Jogador_idJogador) values(?,?,?,?,?)";
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, p.nome);
                pst.setString(2, p.raça);
                pst.setString(3, p.especilizaçao);
                pst.setString(4, p.classe);
                pst.setInt(5, p.id_jogador);
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

        public boolean atualizarPersonagem(int id, Personagem p) {
            connectToDB();
            String sql = "UPDATE Personagem SET nome=?, raça=?, classe=?, especializaçao=? where idPersonagem=?";
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, p.nome);
                pst.setString(2, p.raça);
                pst.setString(3, p.classe);
                pst.setString(4, p.especilizaçao);
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
        public boolean deletarPersonagem(int id) {
            connectToDB();
            String sql = "DELETE FROM Personagem where idPersonagem=?";
            try {
                pst = con.prepareStatement(sql);
                pst.setInt(1, id);
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
        public ArrayList<Personagem> buscarPersonagemSemFiltro() {
            ArrayList<Personagem> listaDePersonagens = new ArrayList<>();
            connectToDB();
            String sql = "SELECT * FROM Personagem";
            try {
                st = con.createStatement();
                rs = st.executeQuery(sql);
                System.out.println("Lista de Personagens: ");
                while (rs.next()) {
                    Personagem personagemAux = new Personagem();
                    personagemAux.idPersonagem = rs.getInt("idPersonagem");
                    personagemAux.nome = rs.getString("nome");
                    personagemAux.raça = rs.getString("raça");
                    personagemAux.classe = rs.getString("classe");
                    personagemAux.especilizaçao = rs.getString("especializaçao");
                    personagemAux.id_jogador=rs.getInt("Jogador_idJogador");
                    System.out.println("idPersonagem = " + personagemAux.idPersonagem);
                    System.out.println("nome = " + personagemAux.nome);
                    System.out.println("raça = " + personagemAux.raça);
                    System.out.println("classe = " + personagemAux.classe);
                    System.out.println("especializaçao = " + personagemAux.especilizaçao);
                    System.out.println("Jogador_idJogador = " + personagemAux.id_jogador);
                    System.out.println("--------------------------------");
                    listaDePersonagens.add(personagemAux);
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
            return listaDePersonagens;
        }

    }
