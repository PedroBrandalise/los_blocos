/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.blocks;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author jcarlos
 */
public class BlocksFunctionFactory {

    private static ActionsFunction _actionsFunction = null;
    private static ResultFunction _resultFunction = null;

    public static ActionsFunction getActionsFunction() {
        if (null == _actionsFunction) {
            _actionsFunction = new BlocksActionsFunction();
        }
        return _actionsFunction;
    }

    public static ResultFunction getResultFunction() {
        if (null == _resultFunction) {
            _resultFunction = new BlocksResultFunction();
        }
        return _resultFunction;
    }

    private static class BlocksActionsFunction implements ActionsFunction {

            // DEFININDO A AÇÃO DE CADA BLOCO DEPENDO DO ESTADO DE CADA UM
            // NESSE CASO ELE VERIFICA SE UM BLOCO ESTA EM CIMA DE OUTRO && SE O BLOCO QUE SERÁ MOVIDO ESTÁ NO TOPO
            // && SE A POSIÇÃO QUE ELE DESEJA COLOCAR ESTÁ LIVRE
            
            public Set<Action> actions(Object state) {
            BlocksState board = (BlocksState) state;
            Set<Action> actions = new LinkedHashSet<Action>();
            
            
            // MOVIMENTAÇÃO DO BLOCO 'A'
            
            
            if ((isFree('a',0, board)) && colunaLivre(1, board) ) {
                actions.add(board.MOVE_a_0_1);
            }            
            if ((isFree('a',0, board)) && colunaLivre(2, board) ) {
                actions.add(board.MOVE_a_0_2);
            }            
            if ((isFree('a',1, board)) && colunaLivre(0, board) ) {
                actions.add(board.MOVE_a_1_0);
            }            
            if ((isFree('a',1, board)) && colunaLivre(2, board) ) {
                actions.add(board.MOVE_a_1_2);
            }
            if ((isFree('a',2, board)) && colunaLivre(0, board) ) {
                actions.add(board.MOVE_a_2_0);
            }
            if ((isFree('a',2, board)) && colunaLivre(1, board) ) {
                actions.add(board.MOVE_a_2_1);
            }
            
            // MOVIMENTAÇÃO DO BLOCO 'B'
            
            if ((isFree('b',0, board)) && colunaLivre(1, board) ) {
                actions.add(board.MOVE_b_0_1);
            }            
            if ((isFree('b',0, board)) && colunaLivre(2, board) ) {
                actions.add(board.MOVE_b_0_2);
            }            
            if ((isFree('b',1, board)) && colunaLivre(0, board) ) {
                actions.add(board.MOVE_b_1_0);
            }            
            if ((isFree('b',1, board)) && colunaLivre(2, board) ) {
                actions.add(board.MOVE_b_1_2);
            }
            if ((isFree('b',2, board)) && colunaLivre(0, board) ) {
                actions.add(board.MOVE_b_2_0);
            }
            if ((isFree('b',2, board)) && colunaLivre(1, board) ) {
                actions.add(board.MOVE_b_2_1);
            }
            
            // MOVIMENTAÇÃO DO BLOCO 'c'
            
            if ((isFree('c',0, board))&& colunaLivre(1, board) ) {
                actions.add(board.MOVE_c_0_1);
            }            
            if ((isFree('c',0, board)) && colunaLivre(2, board) ) {
                actions.add(board.MOVE_c_0_2);
            }            
            if ((isFree('c',1, board)) && colunaLivre(0, board) ) {
                actions.add(board.MOVE_c_1_0);
            }            
            if ((isFree('c',1, board)) && colunaLivre(2, board) ) {
                actions.add(board.MOVE_c_1_2);
            }
            if ((isFree('c',2, board)) && colunaLivre(0, board) ) {
                actions.add(board.MOVE_c_2_0);
            }
            if ((isFree('c',2, board)) && colunaLivre(1, board) ) {
                actions.add(board.MOVE_c_2_1);
            }
            
            //****************************************************************************
                System.out.println(actions);
             
            return actions;
        }

        /**
         * 
         * @param blocoA
         * @param blocoB
         * @param board
         * @return true se o blocoA estiver em cima do blocoB
         */
        private boolean isAt(char blocoA, char blocoB, BlocksState board) {
            for (int linha = 1; linha < 3; linha++) {
                for (int coluna = 0; coluna < 3; coluna++) {
                    if (board.stacks[linha][coluna] == blocoA && board.stacks[linha-1][coluna] == blocoB) {
                        System.out.println("O BLOCO " + blocoA +" ESTA EM CIMA DO BLOCO " + blocoB);
                        return true;
                    }
                }
            }
            return false;
        }
        
        private boolean colunaLivre(int coluna, BlocksState board){
            for (int i = 2; i>=0;i--){
                if(board.stacks[i][coluna]=='\u0000'){
                    return true;
                }
            }
            return false;
            
        }
        
        /**
        * @param a
        * @param coluna
        * @return true se o bloco esta na coluna i 
        */
        private boolean isAtPos(char bloco, int coluna, BlocksState board){
            for (int linha = 0; linha < 3; linha++) {
                if(board.stacks[linha][coluna] == bloco){
                    System.out.println("O BLOCO " + bloco + " ESTA NA POSICAO " + board.stacks[linha][coluna]);
                    return true;
                }
            }
            return false;
        }
        
        
        /**
         * 
         * @param coluna
         * @param board
         * @return true se a posição escolhida estiver vazia no nível 0
         */
        private boolean isFreePos(int coluna, BlocksState board) {

            if (board.stacks[0][coluna] == '\u0000') {    // se for igual a null
                System.out.println("A POSICAO NO NIVEL 0" + coluna + " É LIVRE");
                return true;
            }

            return false;
        }

        /**
         * 
         * @param bloco
         * @param board
         * @return esta no topo da pilha
         *  
         */
        private boolean isFree(char bloco, int colunaatual, BlocksState board) {
            
            for (int linha = 2; linha >0; linha--) {
                    if (board.stacks[linha][colunaatual] != '\u0000') {
                        if (board.stacks[linha][colunaatual] == bloco) {
                            //System.out.println(bloco + "ESTÁ LIVRE");
                            return true;
                        } else{
                            return false;
                        }
                    }
            }

            return false;
        }

        /**
         * @return retorna um array 0 a pos i e 1 a pos j
         * 
         *   
        */
        private int[] blockPosition(char bloco, BlocksState board){
            int[] aux = new int[2];
            
            for(int linha = 0; linha < 3; linha++){
                for(int coluna = 0; coluna < 3; coluna++){
                    
                    if(board.stacks[linha][coluna] == bloco) {
                        aux[0]=linha;
                        aux[1]=coluna;
                        return aux;    //retorna um número, a dezena é linha e a unidade é coluna
                    }
                    
                }
            }
            aux[0]=-1;
            aux[1]=-1;
            return aux;
        }

        /**
         * 
         * @param coluna
         * @param board
         * @return nivel se a posicao desse nível for vazia senão retorna -1
         */
        private int freeNivel(int coluna, BlocksState board){
            for(int nivel = 0 ; nivel<3; nivel++){
                if (board.stacks[nivel][coluna]== '\u0000'){
                    return nivel;
                }
            }
          return -1;  
        }
    } 

    private static class BlocksResultFunction implements ResultFunction {

        // AQUI HÁ UMA VERIFICAÇÃO PARA VER SE A AÇÃO DO BLOCO É VALIDA,
        //COM ISSO ELE ATUALIZA O BOARD PARA PROSSEGUIR 
        // CASO CONTRÁRIO ELE MANTÉM A INSTANCIA DE BOARD JÁ USADA ANTERIORMENTE
        public Object result(Object state, Action action) {
            
            System.out.println(" RESULT ");
            BlocksState board = (BlocksState) state;
            BlocksState newBoard = new BlocksState();
            newBoard = board;
            BlocksActionsFunction baf = new BlocksActionsFunction();

            int[] posiOld;
            char bloco;
            int coluna;
            
            //BLOCO A
            if (board.MOVE_a_0_1.equals(action)) {
                System.out.println("MOVE A 0 1");
                posiOld= baf.blockPosition('a', board);
                bloco= 'a';
                coluna = 1;
                
            }else if (board.MOVE_a_0_2.equals(action)) {
                System.out.println("MOVE A 0 2");
                posiOld= baf.blockPosition('a', board);
                bloco = 'a';
                coluna = 2;
                
            }else if (board.MOVE_a_1_0.equals(action)) {
                System.out.println("MOVE A 1 0");
                posiOld= baf.blockPosition('a', board);
                bloco = 'a';
                coluna = 0;
                
            }else if (board.MOVE_a_1_2.equals(action)) {
                System.out.println("MOVE A 1 2");
                posiOld= baf.blockPosition('a', board);
                bloco = 'a';
                coluna = 2;
            }else if (board.MOVE_a_2_0.equals(action)) {
                System.out.println("MOVE A 2 0");
                posiOld= baf.blockPosition('a', board);
                bloco = 'a';
                coluna = 0;
            }else if (board.MOVE_a_2_1.equals(action)) {
                System.out.println("MOVE A 2 1");
                posiOld= baf.blockPosition('a', board);
                bloco = 'a';
                coluna = 1;
            }
            
            //BLOCO B
            else if (board.MOVE_b_0_1.equals(action)) {
                System.out.println("MOVE b 0 1");
                posiOld= baf.blockPosition('b', board);
                bloco = 'b';
                coluna = 1;
                
            }else if (board.MOVE_b_0_2.equals(action)) {
                System.out.println("MOVE b 0 2");
                posiOld= baf.blockPosition('b', board);
                bloco = 'b';
                coluna = 2;
                
            }else if (board.MOVE_b_1_0.equals(action)) {
                System.out.println("MOVE b 1 0");
                posiOld= baf.blockPosition('b', board);
                bloco = 'b';
                coluna = 0;
                
            }else if (board.MOVE_b_1_2.equals(action)) {
                System.out.println("MOVE A 1 2");
                posiOld= baf.blockPosition('b', board);
                bloco = 'b';
                coluna = 2;
            }else if (board.MOVE_b_2_0.equals(action)) {
                System.out.println("MOVE b 2 0");
                posiOld= baf.blockPosition('b', board);
                bloco = 'b';
                coluna = 0;
            }else if (board.MOVE_b_2_1.equals(action)) {
                System.out.println("MOVE b 2 1");
                posiOld= baf.blockPosition('b', board);
                bloco = 'b';
                coluna = 1;
            }
            
            //BLOCO C
            else if (board.MOVE_c_0_1.equals(action)) {
                System.out.println("MOVE b 0 1");
                posiOld= baf.blockPosition('c', board);
                bloco = 'c';
                coluna = 1;
                
            }else if (board.MOVE_c_0_2.equals(action)) {
                System.out.println("MOVE b 0 2");
                posiOld= baf.blockPosition('c', board);
                bloco = 'c';
                coluna = 2;
                
            }else if (board.MOVE_c_1_0.equals(action)) {
                System.out.println("MOVE b 1 0");
                posiOld= baf.blockPosition('c', board);
                bloco = 'c';
                coluna = 0;
                
            }else if (board.MOVE_c_1_2.equals(action)) {
                System.out.println("MOVE A 1 2");
                posiOld= baf.blockPosition('c', board);
                bloco = 'c';
                coluna = 2;
            }else if (board.MOVE_c_2_0.equals(action)) {
                System.out.println("MOVE b 2 0");
                posiOld= baf.blockPosition('c', board);
                bloco = 'c';
                coluna = 0;
            }else if (board.MOVE_c_2_1.equals(action)) {
                System.out.println("MOVE b 2 1");
                posiOld= baf.blockPosition('c', board);
                bloco = 'c';
                coluna = 1;
            }
            
            
            else {
                posiOld= null;
                bloco = 'e';
                coluna = -1;
                newBoard = null; //oras, n da pra colocar = null na matriz em vez de '\u0000'?
            }
            if(newBoard!=null){
                newBoard.stacks[posiOld[0]][posiOld[1]] = '\u0000';
                newBoard.stacks[baf.freeNivel(coluna, board)][coluna] = bloco;
            }
            
            
            System.out.println("====== BOARD ======");
            for(int linha = 2; linha>-1; linha--){
                for(coluna = 0; coluna<3; coluna++){
                    if(newBoard.stacks[linha][coluna]=='\u0000'){
                        System.out.print("0");
                    }else{
                        System.out.print(newBoard.stacks[linha][coluna]);
                    }
                }
                System.out.print("\n");
            }
            System.out.println("===================");

              
            // The Action is not understood or is a NoOp
            // the result will be the current state.
            if (newBoard != null) {
                return newBoard;
            } else {
                return state;
            }
        }
    }
}
