package br.inatel.cdg.DAO;
import br.inatel.cdg.token.Token;

import java.sql.SQLException;


public class TokenDAO extends ConnectionDAO{
    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou
    public boolean inserirToken(Token t) {
        connectToDB();
        String sql = "INSERT INTO Token (token) values(?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, t.token);
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


}
