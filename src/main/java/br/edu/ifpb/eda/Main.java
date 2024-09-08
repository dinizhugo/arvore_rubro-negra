package br.edu.ifpb.eda;

import br.edu.ifpb.eda.domain.RedBlackTree;

public class Main {
    public static void main(String[] args) {
        RedBlackTree bst = new RedBlackTree();

        bst.inserir(55);
        bst.inserir(40);
        bst.inserir(65);
        bst.inserir(60);
        bst.inserir(70);
        bst.inserir(63);
        bst.inserir(50);

        bst.printInOrder();
    }
}