package com.example;

public class Jogo {
    
    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();
    
    public Jogo() {
        monte.embaralhar();
    }

    public Carta distribuirCartaParaJogador(Jogador jogador){
        if (!jogador.parou()){
            var carta = monte.virar();
            jogador.receberCarta(carta);
            return carta;
        }

        return null;
    }

    public boolean acabou(){
        boolean osDoisPararam = computador.parou() && jogador.parou();
        boolean alguemEstourou = computador.getPontos() > 21 || jogador.getPontos() > 21;

        return osDoisPararam || alguemEstourou;
    }

    public String resultado(){

        boolean jogadorEstourou = jogador.getPontos() > 21;
        boolean computadorEstourou = computador.getPontos() > 21;

        return 
            jogadorEstourou && computadorEstourou? "Empate"
            : jogadorEstourou ? "Computador ganhou"
            : computadorEstourou ? "Jogador ganhou"
            : jogador.getPontos() > computador.getPontos() ? "Jogador ganhou"
            : jogador.getPontos() < computador.getPontos() ? "Computador ganhou"
            : "Empate";
    }

    

}
