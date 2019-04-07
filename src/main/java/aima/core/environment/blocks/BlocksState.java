/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.blocks;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

/**
 *
 * @author jcarlos
 */
public class BlocksState {
    
    public Action MOVE_a_0_1 = new DynamicAction("MOVE a from 0 to 1");
    public Action MOVE_a_0_2 = new DynamicAction("MOVE a from 0 to 2");
    public Action MOVE_a_1_0 = new DynamicAction("MOVE a from 1 to 0");
    public Action MOVE_a_1_2 = new DynamicAction("MOVE a from 1 to 2");
    public Action MOVE_a_2_0 = new DynamicAction("MOVE a from 2 to 0");
    public Action MOVE_a_2_1 = new DynamicAction("MOVE a from 2 to 1");
    
    public Action MOVE_b_0_1 = new DynamicAction("MOVE b from 0 to 1");
    public Action MOVE_b_0_2 = new DynamicAction("MOVE b from 0 to 2");
    public Action MOVE_b_1_0 = new DynamicAction("MOVE b from 1 to 0");
    public Action MOVE_b_1_2 = new DynamicAction("MOVE b from 1 to 2");
    public Action MOVE_b_2_0 = new DynamicAction("MOVE b from 2 to 0");
    public Action MOVE_b_2_1 = new DynamicAction("MOVE b from 2 to 1");
    
    public Action MOVE_c_0_1 = new DynamicAction("MOVE c from 0 to 1");
    public Action MOVE_c_0_2 = new DynamicAction("MOVE c from 0 to 2");
    public Action MOVE_c_1_0 = new DynamicAction("MOVE c from 1 to 0");
    public Action MOVE_c_1_2 = new DynamicAction("MOVE c from 1 to 2");
    public Action MOVE_c_2_0 = new DynamicAction("MOVE c from 2 to 0");
    public Action MOVE_c_2_1 = new DynamicAction("MOVE c from 2 to 1");
    
    public char[][] stacks = new char[3][3];

    public BlocksState() {
        stacks[0][0] = 'a';  //todos empilhandos na posicao 0
        stacks[0][1] = 'b';
        stacks[0][2] = 'c';
    }
    
    private void zeraTudo(){
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3;j++){
                stacks[i][j]='\u0000';
            }
        }
    }
    
    public void setState(char bloco1, int linha1, int coluna1, char bloco2, int linha2, int coluna2, char bloco3, int linha3, int coluna3){
        zeraTudo();
        stacks[linha1][coluna1] = bloco1;  //todos empilhandos na posicao 0
        stacks[linha2][coluna2] = bloco2;
        stacks[linha3][coluna3] = bloco3;        
    }

}
