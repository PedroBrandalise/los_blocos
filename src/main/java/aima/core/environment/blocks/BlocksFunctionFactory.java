/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.blocks;

import aima.core.agent.Action;
import aima.core.environment.blocks.BlocksState;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;
import aima.core.util.math.Vector;
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
           

            /*
            if ((isAt('c', 'b', board)) && (isFree('c', board)) && (isFreePos(0, board))) {
                actions.add(board.DESEMP_cFrom_bto_0);
            }
            if ((isAt('c', 'a', board)) && (isFree('c', board)) && (isFreePos(0, board))) {
                actions.add(board.DESEMP_cFrom_ato_0);
            }
            if ((isAt('b', 'a', board)) && (isFree('b', board)) && (isFreePos(0, board))) {
                actions.add(board.DESEMP_bFrom_ato_0);
            }
            if ((isAt('b', 'c', board)) && (isFree('b', board)) && (isFreePos(0, board))) {
                actions.add(board.DESEMP_bFrom_cto_0);
            }
            if ((isAt('a', 'b', board)) && (isFree('a', board)) && (isFreePos(0, board))) {
                actions.add(board.DESEMP_aFrom_bto_0);
            }
            if ((isAt('a', 'c', board)) && (isFree('a', board)) && (isFreePos(0, board))) {
                actions.add(board.DESEMP_aFrom_cto_0);
            }

            //*******************************************************************************
            
             if ((isAt('c', 'b', board)) && (isFree('c', board)) && (isFreePos(1, board))) {
                actions.add(board.DESEMP_cFrom_bto_1);
            }
            if ((isAt('c', 'a', board)) && (isFree('c', board)) && (isFreePos(1, board))) {
                actions.add(board.DESEMP_cFrom_ato_1);
            }
            if ((isAt('b', 'a', board)) && (isFree('b', board)) && (isFreePos(1, board))) {
                actions.add(board.DESEMP_bFrom_ato_1);
            }
            if ((isAt('b', 'c', board)) && (isFree('b', board)) && (isFreePos(1, board))) {
                actions.add(board.DESEMP_bFrom_cto_1);
            }
            if ((isAt('a', 'b', board)) && (isFree('a', board)) && (isFreePos(1, board))) {
                actions.add(board.DESEMP_aFrom_bto_1);
            }
            if ((isAt('a', 'c', board)) && (isFree('a', board)) && (isFreePos(1, board))) {
                actions.add(board.DESEMP_aFrom_cto_1);
            }
            
            //******************************************************************************
            
             if ((isAt('c', 'b', board)) && (isFree('c', board)) && (isFreePos(2, board))) {
                actions.add(board.DESEMP_cFrom_bto_2);
            }
            if ((isAt('c', 'a', board)) && (isFree('c', board)) && (isFreePos(2, board))) {
                actions.add(board.DESEMP_cFrom_ato_2);
            }
            if ((isAt('b', 'a', board)) && (isFree('b', board)) && (isFreePos(2, board))) {
                actions.add(board.DESEMP_bFrom_ato_2);
            }
            if ((isAt('b', 'c', board)) && (isFree('b', board)) && (isFreePos(2, board))) {
                actions.add(board.DESEMP_bFrom_cto_2);
            }
            if ((isAt('a', 'b', board)) && (isFree('a', board)) && (isFreePos(2, board))) {
                actions.add(board.DESEMP_aFrom_bto_2);
            }
            if ((isAt('a', 'c', board)) && (isFree('a', board)) && (isFreePos(2, board))) {
                actions.add(board.DESEMP_aFrom_cto_2);
            }
            
            //*********************************EMPILHAR***************************************
            
            //Testa se os 2 são topo e o 1° esta na posição certa
            
             if ((isFree('b', board)) && (isFree('a', board)) && (isAtPos('a', 0, board) )) {  
                actions.add(board.EMP_aFrom_0to_b);
            }
            if ((isFree('a', board)) && (isFree('c', board)) && (isAtPos('a', 0, board))) {
                actions.add(board.EMP_aFrom_0to_c);
            }
            if ((isFree('b', board)) && (isFree('a', board)) && (isAtPos('b', 0, board))) {
                actions.add(board.EMP_bFrom_0to_a);
            }
            if ((isFree('b', board)) && (isFree('c', board)) && (isAtPos('b', 0, board))) {
                actions.add(board.EMP_bFrom_0to_c);
            }
            if ((isFree('c', board)) && (isFree('a', board)) && (isAtPos('c', 0, board))) {
                actions.add(board.EMP_cFrom_0to_a);
            }
            if ((isFree('c', board)) && (isFree('b', board)) && (isAtPos('c', 0, board))) {
                actions.add(board.EMP_cFrom_0to_b);
            }
            
            //****************************************************************************8
            
             if ((isFree('b', board)) && (isFree('a', board)) && (isAtPos('a', 1, board))) {  
                actions.add(board.EMP_aFrom_1to_b);
            }
            if ((isFree('a', board)) && (isFree('c', board)) && (isAtPos('a', 1, board))) {
                actions.add(board.EMP_aFrom_1to_c);
            }
            if ((isFree('b', board)) && (isFree('a', board)) && (isAtPos('b', 1, board))) {
                actions.add(board.EMP_bFrom_1to_a);
            }
            if ((isFree('b', board)) && (isFree('c', board)) && (isAtPos('b', 1, board))) {
                actions.add(board.EMP_bFrom_1to_c);
            }
            if ((isFree('c', board)) && (isFree('a', board)) && (isAtPos('c', 1, board))) {
                actions.add(board.EMP_cFrom_1to_a);
            }
            if ((isFree('c', board)) && (isFree('b', board)) && (isAtPos('c', 1, board))) {
                actions.add(board.EMP_cFrom_1to_b);
            }
            
            //*************************************************************************
            
           if ((isFree('b', board)) && (isFree('a', board)) && (isAtPos('a', 2, board))) {  
                actions.add(board.EMP_aFrom_2to_b);
            }
            if ((isFree('a', board)) && (isFree('c', board)) && (isAtPos('a', 2, board))) {
                actions.add(board.EMP_aFrom_2to_c);
            }
            if ((isFree('b', board)) && (isFree('a', board)) && (isAtPos('b', 2, board))) {
                actions.add(board.EMP_bFrom_2to_a);
            }
            if ((isFree('b', board)) && (isFree('c', board)) && (isAtPos('b', 2, board))) {
                actions.add(board.EMP_bFrom_2to_c);
            }
            if ((isFree('c', board)) && (isFree('a', board)) && (isAtPos('c', 2, board))) {
                actions.add(board.EMP_cFrom_2to_a);
            }
            if ((isFree('c', board)) && (isFree('b', board)) && (isAtPos('c', 2, board))) {
                actions.add(board.EMP_cFrom_2to_b);
            }
            */
            
            
            // MOVIMENTAÇÃO DO BLOCO 'A'
            
            
            if ((isFree('a', board)) && freePosition(1,board)<3 && (isAtPos('a', 0, board)) ) {
                actions.add(board.MOVE_a_0_1);
            }            
            if ((isFree('a', board)) && freePosition(2,board)<3 && (isAtPos('a', 0, board)) ) {
                actions.add(board.MOVE_a_0_2);
            }            
            if ((isFree('a', board)) && freePosition(0,board)<3 && (isAtPos('a', 1, board)) ) {
                actions.add(board.MOVE_a_1_0);
            }            
            if ((isFree('a', board)) && freePosition(2,board)<3 && (isAtPos('a', 1, board)) ) {
                actions.add(board.MOVE_a_1_2);
            }
            if ((isFree('a', board)) && freePosition(0,board)<3 && (isAtPos('a', 2, board)) ) {
                actions.add(board.MOVE_a_2_0);
            }
            if ((isFree('a', board)) && freePosition(1,board)<3 && (isAtPos('a', 2, board)) ) {
                actions.add(board.MOVE_a_2_1);
            }
            
            // MOVIMENTAÇÃO DO BLOCO 'B'
            
            if ((isFree('b', board)) && freePosition(1,board)<3 && (isAtPos('a', 0, board)) ) {
                actions.add(board.MOVE_b_0_1);
            }            
            if ((isFree('b', board)) && freePosition(2,board)<3 && (isAtPos('a', 0, board)) ) {
                actions.add(board.MOVE_b_0_2);
            }            
            if ((isFree('b', board)) && freePosition(0,board)<3 && (isAtPos('a', 1, board)) ) {
                actions.add(board.MOVE_b_1_0);
            }            
            if ((isFree('b', board)) && freePosition(2,board)<3 && (isAtPos('a', 1, board)) ) {
                actions.add(board.MOVE_b_1_2);
            }
            if ((isFree('b', board)) && freePosition(0,board)<3 && (isAtPos('a', 2, board)) ) {
                actions.add(board.MOVE_b_2_0);
            }
            if ((isFree('b', board)) && freePosition(1,board)<3 && (isAtPos('a', 2, board)) ) {
                actions.add(board.MOVE_b_2_1);
            }
            
            // MOVIMENTAÇÃO DO BLOCO 'c'
            
            if ((isFree('c', board)) && freePosition(1,board)<3 && (isAtPos('a', 0, board)) ) {
                actions.add(board.MOVE_c_0_1);
            }            
            if ((isFree('c', board)) && freePosition(2,board)<3 && (isAtPos('a', 0, board)) ) {
                actions.add(board.MOVE_c_0_2);
            }            
            if ((isFree('c', board)) && freePosition(0,board)<3 && (isAtPos('a', 1, board)) ) {
                actions.add(board.MOVE_c_1_0);
            }            
            if ((isFree('c', board)) && freePosition(2,board)<3 && (isAtPos('a', 1, board)) ) {
                actions.add(board.MOVE_c_1_2);
            }
            if ((isFree('c', board)) && freePosition(0,board)<3 && (isAtPos('a', 2, board)) ) {
                actions.add(board.MOVE_c_2_0);
            }
            if ((isFree('c', board)) && freePosition(1,board)<3 && (isAtPos('a', 2, board)) ) {
                actions.add(board.MOVE_c_2_1);
            }
            
            //****************************************************************************

             
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
            for (int i = 1; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.stacks[i][j] == blocoA && board.stacks[i-1][j] == blocoB) {
                        System.out.println(blocoA+" ESTA EM CIMA DE "+blocoB);
                        return true;
                    }
                }
            }
            return false;
        }
        
        /**
         * 
         * @param coluna
         * @param board
         * @return linha mais alta de dada coluna
         
        private int top(int coluna,  BlocksState board){
            for (int i = 0 ; i<3;i++){
                if(board.stacks[i][coluna]== '\u0000') {
                    return i;
                }
            }
            return 0;            
        }*/
        
        /**
        * @param a
        * @param i
        * @return true esta na coluna i 
        */
        private boolean isAtPos(char a, int i, BlocksState board){
            for (int j = 0; j <3; j++) {
                if(board.stacks[i][j] == a){
                    System.out.println(a+" ESTA NA POSICAO "+board.stacks[i][j]);
                    return true;
                }
            }
            return false;
        }
        
        
        /**
         * 
         * @param i
         * @param board
         * @return true se a posição escolhida estiver vazia
         */
        private boolean isFreePos(int i, BlocksState board) {

            if (board.stacks[0][i] == '\u0000') {    // se for igual a null
                System.out.println("A POSICAO NO NIVEL 0" + i + " É LIVRE");
                return true;
            }

            return false;
        }

        /**
         * 
         * @param bloco
         * @param board
         * @return true se não tiver ninguém acima do bloco escolhido e nao for o ultimo
         *  
         */
        private boolean isFree(char bloco, BlocksState board) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {

                    if (board.stacks[i][j] == bloco) {
                        if (board.stacks[i+1][j] == '\u0000' && j < 2) {
                            System.out.println(bloco + "TA LIVRE ");
                            return true;
                        }
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
            int[] aux= new int[2];
            for(int i = 0; i<3; i++){
                for(int j=0;j<3;j++){
                    if(board.stacks[i][j]==bloco)
                        aux[0]=i;
                        aux[1]=j;
                        return aux;    //retorna um numero, a dezena é i e a unidade é j
                }
            }
            aux[0]=-1;
            aux[1]=-1;
            return aux;
        }


        private int freePosition(int col, BlocksState board){
            for(int i = 0 ; i<3; i++){
                if (board.stacks[col][i]== '\u0000'){
                    return i;
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
            System.out.println("result");
            BlocksState board = (BlocksState) state;
            BlocksState newBoard = new BlocksState();
            newBoard = board;
            BlocksActionsFunction baf = new BlocksActionsFunction();
            /*
            if (board.DESEMP_aFrom_bto_0.equals(action)) {
            System.out.println("Criar o novo objeto do tipo BlocksState");
            int posiOld= baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[0][baf.freePosition(0, board)]= 'a';
            
            } else if (board.DESEMP_aFrom_cto_0.equals(action)) {
            System.out.println("Criar o novo objeto do tipo BlocksState");
            int posiOld= baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[0][baf.freePosition(0, board)]= 'a';
            
            } else if (board.DESEMP_bFrom_ato_0.equals(action)) {
            System.out.println("Criar o novo objeto do tipo BlocksState");
            int posiOld= baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[0][baf.freePosition(0, board)]= 'b';
            
            } else if (board.DESEMP_bFrom_cto_0.equals(action)) {
            //System.out.println("Criar o novo objeto do tipo BlocksState");
            int posiOld= baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[0][baf.freePosition(0, board)]= 'b';
            
            } else if (board.DESEMP_cFrom_bto_0.equals(action)) {
            //System.out.println("Criar o novo objeto do tipo BlocksState");
            int posiOld= baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[0][baf.freePosition(0, board)]= 'c';
            
            } else if (board.DESEMP_cFrom_ato_0.equals(action)) {
            //System.out.println("Criar o novo objeto do tipo BlocksState");
            int posiOld= baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[0][baf.freePosition(0, board)]= 'c';
            }
            
            //++++++++++++++++++
            // pilha 1
            //------------------
            
            else if (board.DESEMP_aFrom_bto_1.equals(action)) {
            System.out.println("Criar o novo objeto do tipo BlocksState");
            int posiOld= baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[1][baf.freePosition(1, board)]= 'a';
            
            } else  if (board.DESEMP_aFrom_cto_1.equals(action)) {
            System.out.println("Criar o novo objeto do tipo BlocksState");
            int posiOld= baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[1][baf.freePosition(1, board)]= 'a';
            
            } else  if (board.DESEMP_bFrom_ato_1.equals(action)) {
            System.out.println("Criar o novo objeto do tipo BlocksState");
            int posiOld= baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[1][baf.freePosition(1, board)]= 'b';
            
            } else if (board.DESEMP_bFrom_cto_1.equals(action)) {
            int posiOld= baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[1][baf.freePosition(1, board)]= 'b';
            
            } else if (board.DESEMP_cFrom_bto_1.equals(action)) {
            int posiOld= baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[1][baf.freePosition(1, board)]= 'c';
            
            } else if (board.DESEMP_cFrom_ato_1.equals(action)) {
            int posiOld= baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[1][baf.freePosition(1, board)]= 'c';
            }
            
            
            //++++++++++++++++++
            // pilha 2
            //------------------
            
            else if (board.DESEMP_aFrom_bto_2.equals(action)) {
            System.out.println("DESEMP_aFrom_bto_2");
            int posiOld= baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[2][baf.freePosition(2, board)]= 'a';
            
            } else  if (board.DESEMP_aFrom_cto_2.equals(action)) {
            System.out.println("DESEMP_aFrom_cto_2");
            int posiOld= baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[2][baf.freePosition(2, board)]= 'a';
            
            } else  if (board.DESEMP_bFrom_ato_2.equals(action)) {
            System.out.println("DESEMP_bFrom_ato_2");
            int posiOld= baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[2][baf.freePosition(2, board)]= 'b';
            
            } else   if (board.DESEMP_bFrom_cto_2.equals(action)) {
            System.out.println("DESEMP_bFrom_cto_2");
            int posiOld= baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[2][baf.freePosition(2, board)]= 'b';
            
            } else    if (board.DESEMP_cFrom_bto_2.equals(action)) {
            System.out.println("DESEMP_cFrom_bto_2");
            int posiOld= baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[2][baf.freePosition(2, board)]= 'c';
            
            } else    if (board.DESEMP_cFrom_ato_2.equals(action)) {
            System.out.println("DESEMP_cFrom_ato_2");
            int posiOld= baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            newBoard.stacks[2][baf.freePosition(2, board)]= 'c';
            } else
            
            
            //**********************empilhar**************************
            
            if (board.EMP_aFrom_0to_b.equals(action)) {
            System.out.println("EMP_aFrom_0to_b");
            int posiOld= baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'a';
            
            } else  if (board.EMP_aFrom_0to_c.equals(action)) {
            System.out.println("EMP_aFrom_0to_c");
            int posiOld= baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'a';
            
            } else if (board.EMP_bFrom_0to_a.equals(action)) {
            System.out.println("EMP_bFrom_0to_a");
            int posiOld= baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'b';
            
            } else if (board.EMP_bFrom_0to_c.equals(action)) {
            System.out.println("EMP_bFrom_0to_c");
            int posiOld= baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'b';
            
            } else  if (board.EMP_cFrom_0to_a.equals(action)) {
            System.out.println("EMP_cFrom_0to_a");
            int posiOld= baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'c';
            
            } else if (board.EMP_cFrom_0to_b.equals(action)) {
            System.out.println("EMP_cFrom_0to_b");
            int posiOld= baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'c';
            
            } else if (board.EMP_aFrom_1to_b.equals(action)) {
            System.out.println("EMP_aFrom_1to_b");
            int posiOld= baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'a';
            
            } else if (board.EMP_aFrom_1to_c.equals(action)) {
            System.out.println("EMP_aFrom_1to_c");
            int posiOld= baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'a';
            
            } else if (board.EMP_bFrom_1to_a.equals(action)) {
            System.out.println("EMP_bFrom_1to_a");
            int posiOld= baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'b';
            
            } else if (board.EMP_bFrom_1to_c.equals(action)) {
            System.out.println("EMP_bFrom_1to_c");
            int posiOld= baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'b';
            
            } else if (board.EMP_cFrom_1to_a.equals(action)) {
            System.out.println("EMP_cFrom_1to_a");
            int posiOld= baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'c';
            
            } else if (board.EMP_cFrom_1to_b.equals(action)) {
            System.out.println("EMP_cFrom_1to_b");
            int posiOld= baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'c';
            
            } else  if (board.EMP_aFrom_2to_b.equals(action)) {
            System.out.println("EMP_aFrom_2to_b");
            int posiOld= baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'a';
            
            } else  if (board.EMP_aFrom_2to_c.equals(action)) {
            System.out.println("EMP_aFrom_2to_c");
            int posiOld= baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'a';
            
            } else  if (board.EMP_bFrom_2to_a.equals(action)) {
            System.out.println("EMP_bFrom_2to_a");
            int posiOld= baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'b';
            
            } else  if (board.EMP_bFrom_2to_c.equals(action)) {
            System.out.println("EMP_bFrom_2to_c");
            int posiOld= baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'b';
            
            } else   if (board.EMP_cFrom_2to_a.equals(action)) {
            System.out.println("EMP_cFrom_2to_a");
            int posiOld= baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('a', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'c';
            
            } else   if (board.EMP_cFrom_2to_b.equals(action)) {
            System.out.println("EMP_cFrom_2to_b");
            int posiOld= baf.blockPosition('c', board);
            System.out.println(posiOld);
            newBoard.stacks[ (posiOld%100-posiOld%10)/10][ posiOld%10] = '\u0000';
            posiOld = baf.blockPosition('b', board);
            System.out.println(posiOld);
            newBoard.stacks[(posiOld%100 - posiOld%10)/10][ (posiOld%10) +1]= 'c';
            
            } else {
            newBoard = null; //oras, n da pra colocar = null na matriz em vez de '\u0000'?
            }*/
            int[] posiOld;
            char bloc;
            int col;
            System.out.println("AQUI");
            //BLOCO A
            if (board.MOVE_a_0_1.equals(action)) {
                System.out.println("MOVE A 0 1");
                posiOld= baf.blockPosition('a', board);
                bloc= 'a';
                col = 1;
                
            }else if (board.MOVE_a_0_2.equals(action)) {
                System.out.println("MOVE A 0 2");
                posiOld= baf.blockPosition('a', board);
                bloc= 'a';
                col = 2;
                
            }else if (board.MOVE_a_1_0.equals(action)) {
                System.out.println("MOVE A 1 0");
                posiOld= baf.blockPosition('a', board);
                bloc= 'a';
                col = 0;
                
            }else if (board.MOVE_a_1_2.equals(action)) {
                System.out.println("MOVE A 1 2");
                posiOld= baf.blockPosition('a', board);
                bloc= 'a';
                col = 2;
            }else if (board.MOVE_a_2_0.equals(action)) {
                System.out.println("MOVE A 2 0");
                posiOld= baf.blockPosition('a', board);
                bloc= 'a';
                col = 0;
            }else if (board.MOVE_a_2_1.equals(action)) {
                System.out.println("MOVE A 2 1");
                posiOld= baf.blockPosition('a', board);
                bloc= 'a';
                col = 1;
            }
            
            //BLOCO B
            else if (board.MOVE_b_0_1.equals(action)) {
                System.out.println("MOVE b 0 1");
                posiOld= baf.blockPosition('b', board);
                bloc= 'b';
                col = 1;
                
            }else if (board.MOVE_b_0_2.equals(action)) {
                System.out.println("MOVE b 0 2");
                posiOld= baf.blockPosition('b', board);
                bloc= 'b';
                col = 2;
                
            }else if (board.MOVE_b_1_0.equals(action)) {
                System.out.println("MOVE b 1 0");
                posiOld= baf.blockPosition('b', board);
                bloc= 'b';
                col = 0;
                
            }else if (board.MOVE_b_1_2.equals(action)) {
                System.out.println("MOVE A 1 2");
                posiOld= baf.blockPosition('b', board);
                bloc= 'b';
                col = 2;
            }else if (board.MOVE_b_2_0.equals(action)) {
                System.out.println("MOVE b 2 0");
                posiOld= baf.blockPosition('b', board);
                bloc= 'b';
                col = 0;
            }else if (board.MOVE_b_2_1.equals(action)) {
                System.out.println("MOVE b 2 1");
                posiOld= baf.blockPosition('b', board);
                bloc= 'b';
                col = 1;
            }
            
            //BLOCO C
            else if (board.MOVE_c_0_1.equals(action)) {
                System.out.println("MOVE b 0 1");
                posiOld= baf.blockPosition('c', board);
                bloc= 'c';
                col = 1;
                
            }else if (board.MOVE_c_0_2.equals(action)) {
                System.out.println("MOVE b 0 2");
                posiOld= baf.blockPosition('c', board);
                bloc= 'c';
                col = 2;
                
            }else if (board.MOVE_c_1_0.equals(action)) {
                System.out.println("MOVE b 1 0");
                posiOld= baf.blockPosition('c', board);
                bloc= 'c';
                col = 0;
                
            }else if (board.MOVE_c_1_2.equals(action)) {
                System.out.println("MOVE A 1 2");
                posiOld= baf.blockPosition('c', board);
                bloc= 'c';
                col = 2;
            }else if (board.MOVE_c_2_0.equals(action)) {
                System.out.println("MOVE b 2 0");
                posiOld= baf.blockPosition('c', board);
                bloc= 'c';
                col = 0;
            }else if (board.MOVE_c_2_1.equals(action)) {
                System.out.println("MOVE b 2 1");
                posiOld= baf.blockPosition('c', board);
                bloc= 'c';
                col = 1;
            }
            
            
            else {
                posiOld= null;
                bloc= 'e';
                col = -1;
                newBoard = null; //oras, n da pra colocar = null na matriz em vez de '\u0000'?
            }
            if(newBoard!=null){
                newBoard.stacks[posiOld[0]][posiOld[1]] = '\u0000';
                newBoard.stacks[baf.freePosition(col,board)][col]= bloc;
            }
            
            
            System.out.println("============");
            for(int i=2; i>-1;i--){
                for(int j=0;j<3;j++){
                    if(newBoard.stacks[i][j]=='\u0000'){
                        System.out.print("0");
                    }else{
                        System.out.print(newBoard.stacks[i][j]);
                    }
                }
                System.out.print("\n");
            }
            System.out.println("============");

              
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
