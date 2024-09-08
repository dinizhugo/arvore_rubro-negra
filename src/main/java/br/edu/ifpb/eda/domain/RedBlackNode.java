package br.edu.ifpb.eda.domain;

public class RedBlackNode {
    private Integer valor;
    private RedBlackNode esquerda, direita, pai;
    private boolean cor; // TRUE - VERMELHA / FALSE - PRETA

    public RedBlackNode(Integer valor) {
        this.valor = valor;
        this.esquerda = this.direita = this.pai = null;
        this.cor = true;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public RedBlackNode getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(RedBlackNode esquerda) {
        this.esquerda = esquerda;
    }

    public RedBlackNode getDireita() {
        return direita;
    }

    public void setDireita(RedBlackNode direita) {
        this.direita = direita;
    }

    public RedBlackNode getPai() {
        return pai;
    }

    public void setPai(RedBlackNode pai) {
        this.pai = pai;
    }

    public boolean isCor() {
        return cor;
    }

    public void setCor(boolean cor) {
        this.cor = cor;
    }
}
