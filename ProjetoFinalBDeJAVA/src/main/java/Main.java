import br.inatel.cdg.DAO.JogadorDAO;
import br.inatel.cdg.DAO.PersonagemDAO;
import br.inatel.cdg.DAO.SeversDAO;
import br.inatel.cdg.DAO.TokenDAO;
import br.inatel.cdg.jogador.Jogador;
import br.inatel.cdg.personagem.Personagem;
import br.inatel.cdg.servers.Servers;
import br.inatel.cdg.token.Token;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Personagem p1 = new Personagem();
        Personagem p2 = new Personagem();
        Personagem p3 = new Personagem();
        Personagem p4 = new Personagem();
        Personagem p5 = new Personagem();
        Personagem p6 = new Personagem();
        PersonagemDAO pd = new PersonagemDAO();
        Jogador j1 =new Jogador();
        Jogador j2 =new Jogador();
        JogadorDAO jd = new JogadorDAO();
        TokenDAO td= new TokenDAO();
        Token t1 =new Token();
        Token t2 =new Token();
        SeversDAO sd = new SeversDAO();
        Servers s1 = new Servers();
        Servers s2 = new Servers();


        j1.idJogador=16;
        j1.nome = "Gabriel";
        j1.idade = 20;
        j1.senha=2012;
        j1.endereço="Rua humberto serrano, 45";
        j2.idJogador=14;
        j2.nome="Joao";
        j2.idade =24;
        j2.senha=1232;
        j2.endereço="Bairro inatel";
        jd.inserirJogador(j1);
        jd.inserirJogador(j2);
        p1.nome= "Kana";
        p1.raça= "Elfo";
        p1.especilizaçao= "Suporte";
        p1.classe= "Barda";
        p1.id_jogador=j1.idJogador;
        pd.inserirPersonagem(p1);
        p2.nome= "Edward";
        p2.raça= "Humano";
        p2.especilizaçao= "Empunhadura dupla";
        p2.classe= "Berserker";
        p2.id_jogador=j1.idJogador;
        pd.inserirPersonagem(p2);
        p3.nome= "Astrid Hel";
        p3.raça= "Humano";
        p3.especilizaçao= "Machado Gigante";
        p3.classe= "Guardiã";
        p3.id_jogador=j1.idJogador;
        pd.inserirPersonagem(p3);
        p4.nome= "Gui Jin Yuu";
        p4.raça= "Humano";
        p4.especilizaçao= "Necromante";
        p4.classe= "Monarca das sombras";
        p4.id_jogador=j2.idJogador;
        pd.inserirPersonagem(p4);
        p5.nome= "Guts";
        p5.raça= "Humano amaldiçoada";
        p5.especilizaçao= "Porradaria";
        p5.classe= "Guerreiro";
        p5.id_jogador=j2.idJogador;
        pd.inserirPersonagem(p5);
        p6.nome= "Sylvanas Windrunner";
        p6.raça= "Elfa Nobre";
        p6.especilizaçao= "Dark ranger";
        p6.classe= "Ranger";
        p6.id_jogador=j2.idJogador;
        pd.inserirPersonagem(p6);
        t1.token = 201212;
        td.inserirToken(t1);
        t2.token = 23457;
        td.inserirToken(t2);
        s1.regiao = "Brasil";
        sd.inserirSevers(s1);
        s2.regiao = "USA";
        sd.inserirSevers(s2);


        Scanner entrada=new Scanner(System.in);
        boolean flag = true;
        while(flag){

            System.out.println("**Opcoes disponiveis**");
            System.out.println("1 - Deletar Personagem ");
            System.out.println("2 - Buscar Jogadores ");
            System.out.println("3 - Buscar Personagens ");
            System.out.println("4 - Atualizar dados de um jogador ");
            System.out.println("5 - Atualizar dados de um Personagem ");
            System.out.println("6 - Informações do Server ");
            System.out.println("7 - Atualizar dados de um Server ");

            int op= entrada.nextInt();
            switch (op){
                case 1:
                    int id2;
                    System.out.println("Digite o ID do personagem a deletar: ");
                    id2 = entrada.nextInt();
                    pd.deletarPersonagem(id2);
                    break;
                case 2:
                    jd.buscarJogadorSemFiltro();
                    break;
                case 3:
                    pd.buscarPersonagemSemFiltro();
                    break;
                case 4:
                    Jogador j3 = new Jogador();
                    j3.idJogador=16;
                    j3.nome = "Gabriel";
                    j3.idade = 20;
                    j3.senha=2016;
                    j3.endereço="Rua humberto serrano, 16";
                    jd.atualizarJogador(16,j3);
                    break;
                case 5:
                    Personagem p10 = new Personagem();
                    p10.nome= "Scorpion";
                    p10.raça= "Humano";
                    p10.especilizaçao= "Assasinato";
                    p10.classe= "Ninja";
                    p10.id_jogador=j1.idJogador;
                    pd.atualizarPersonagem(1,p10);
                    break;
                case 6:
                    sd.buscarServersSemFiltro();
                    break;
                case 7:

                    Servers s3 = new Servers();
                    s3.regiao = "Europa";
                    sd.atualizarServers(1,s3);
                    break;
            }

        }




    }
}
