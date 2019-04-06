/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.blocks;

import aima.core.environment.blocks.BlocksState;
import aima.core.search.framework.GoalTest;

/**
 *
 * @author jcarlos
 */
public class BlocksGoalState implements GoalTest {

    char[][] goal = new char[3][3];//3 Blocos e 3 posições na mesa

    // todos na mesa
    public boolean isGoalState(Object state) {
        BlocksState currentState = (BlocksState) state;
        if ((currentState.stacks[0][0] == 'a') && (currentState.stacks[0][1] == 'b') && (currentState.stacks[0][2] == 'c')) {
            return true;
        }

        return false;
    }
    
    private void zeraTudo(){
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3;j++){
                goal[i][j]='\u0000';
            }
        }
    }
    
    public void setGoal(char bloco1, int i1, int j1,char bloco2, int i2, int j2,char bloco3, int i3, int j3  ){
        zeraTudo();
        goal[i1][j1] = bloco1;  //todos empilhandos na posicao 0
        goal[i2][j2] = bloco2;
        goal[i3][j3] = bloco3;        
    }

}
