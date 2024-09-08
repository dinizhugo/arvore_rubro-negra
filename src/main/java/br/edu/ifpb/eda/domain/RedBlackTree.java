package br.edu.ifpb.eda.domain;

public class RedBlackTree {
    private RedBlackNode raiz;
    private RedBlackNode filho;

    public RedBlackTree() {
        this.filho = new RedBlackNode(0);
        this.filho.setCor(false);
        this.filho = this.raiz;
    }

    public void inserir(int valor) {
        RedBlackNode novoNodo = new RedBlackNode(valor);
        this.raiz = inserirRecursivamente(this.raiz, novoNodo);
        balancearArvore(novoNodo);
    }

    private RedBlackNode inserirRecursivamente(RedBlackNode atual, RedBlackNode novoNodo) {
        if (atual == this.filho) {
            return novoNodo;
        }

        if (novoNodo.getValor() < atual.getValor()) {
            atual.setEsquerda(inserirRecursivamente(atual.getEsquerda(), novoNodo));
            atual.getEsquerda().setPai(atual);
        }else {
            atual.setDireita(inserirRecursivamente(atual.getDireita(), novoNodo));
            atual.getDireita().setPai(atual);
        }

        return atual;
    }

    private void balancearArvore(RedBlackNode nodoInserido) {
        // VERMELHO CONSECUTIVO
        while (nodoInserido != this.raiz && nodoInserido.getPai().isCor()) { // ENQUANTO O PAI FOR VERMELHO

            RedBlackNode pai = nodoInserido.getPai();
            RedBlackNode avo = nodoInserido.getPai().getPai();

            if (pai == avo.getDireita()) { // ANALISANDO PELA DIREITA
                RedBlackNode tio = avo.getEsquerda();

                if (tio.isCor()) { // SE O TIO FOR VERMELHO TBM, ENTÃO:
                    tio.setCor(false);
                    pai.setCor(false);
                    avo.setCor(true);
                    nodoInserido = avo;
                } else { // SE O TIO FOR PRETO OU NULO, ENTÃO:
                    if (nodoInserido == pai.getEsquerda()) { // SEGUNDO CASO, SE O NODO TIVER NO MESMO LADO QUE O PAI
                        nodoInserido = pai;
                        girarADireita(nodoInserido);
                    }
                    pai.setCor(false);
                    avo.setCor(true);
                     girarAEsquerda(avo);
                }
            } else { // ANALISANDO PELA ESQUERDA
                RedBlackNode tio = avo.getDireita();

                if (tio.isCor()) {
                    tio.setCor(false);
                    pai.setCor(false);
                    avo.setCor(true);
                    nodoInserido = avo;
                } else {
                    if (nodoInserido == pai.getDireita()) {
                        nodoInserido = pai;
                        girarAEsquerda(nodoInserido);
                    }
                    pai.setCor(false);
                    avo.setCor(true);
                    girarADireita(avo);
                }
            }
        }
        this.raiz.setCor(false); // OBRIGANDO QUE A RAIZ SEJA SEMPRE PRETA.
    }

    private void girarAEsquerda(RedBlackNode nodo) {
        RedBlackNode filhoDireita = nodo.getDireita();
        nodo.setDireita(filhoDireita.getEsquerda());

        if (filhoDireita.getEsquerda() != this.filho) {
            filhoDireita.getEsquerda().setPai(nodo);
        }

        filhoDireita.setPai(nodo.getPai());

        if (nodo.getPai() == null) {
            this.raiz = filhoDireita;
        } else if (nodo == nodo.getPai().getEsquerda()) {
            nodo.getPai().setEsquerda(filhoDireita);
        } else {
            nodo.getPai().setDireita(filhoDireita);
        }
        filhoDireita.setEsquerda(nodo);
        nodo.setPai(filhoDireita);
    }


    private void girarADireita(RedBlackNode nodo) {
        RedBlackNode filhoEsquerda = nodo.getEsquerda();
        nodo.setEsquerda(filhoEsquerda.getDireita());

        if (filhoEsquerda.getDireita() != this.filho) {
            filhoEsquerda.getDireita().setPai(nodo);
        }

        filhoEsquerda.setPai(nodo.getPai());

        if (nodo.getPai() == null) {
            this.raiz = filhoEsquerda;
        } else if (nodo == nodo.getPai().getDireita()) {
            nodo.getPai().setDireita(filhoEsquerda);
        } else {
            nodo.getPai().setEsquerda(filhoEsquerda);
        }
        filhoEsquerda.setDireita(nodo);
        nodo.setPai(filhoEsquerda);
    }

    public void printInOrder() {
        printInOrderHelper(raiz);
        System.out.println(); // Nova linha no final
    }

    private void printInOrderHelper(RedBlackNode node) {
        if (node != filho) {
            printInOrderHelper(node.getEsquerda());
            String sColor = node.isCor() ? "\033[31m" : "\033[30m";
            System.out.print("(" + sColor + node.getValor() + "\033[0m), ");
            printInOrderHelper(node.getDireita());
        }
    }


    public RedBlackNode getRaiz() {
        return raiz;
    }

    public void setRaiz(RedBlackNode raiz) {
        this.raiz = raiz;
    }

    public RedBlackNode getFilho() {
        return filho;
    }

    public void setFilho(RedBlackNode filho) {
        this.filho = filho;
    }
}
