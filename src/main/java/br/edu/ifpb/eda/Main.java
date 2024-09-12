package br.edu.ifpb.eda;

import br.edu.ifpb.eda.domain.RedBlackTree;

public class Main {
    public static void main(String[] args) {
        RedBlackTree bst = new RedBlackTree();

        bst.inserir(60);
        bst.inserir(50);
        bst.inserir(20);
        bst.inserir(65);
        bst.inserir(77);
        bst.inserir(90);
        bst.inserir(45);

        bst.printInOrder();
    }
}