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
    /*
    public Action DESEMP_aFrom_bto_0 = new DynamicAction("DESEMP a from b to 0");
    public Action DESEMP_aFrom_bto_1 = new DynamicAction("DESEMP a from b to 1");
    public Action DESEMP_aFrom_bto_2 = new DynamicAction("DESEMP a from b to 2");
    public Action DESEMP_aFrom_cto_0 = new DynamicAction("DESEMP a from c to 0");
    public Action DESEMP_aFrom_cto_1 = new DynamicAction("DESEMP a from c to 1");
    public Action DESEMP_aFrom_cto_2 = new DynamicAction("DESEMP a from c to 1");

    public Action DESEMP_bFrom_ato_0 = new DynamicAction("DESEMP b from a to 0");
    public Action DESEMP_bFrom_ato_1 = new DynamicAction("DESEMP b from a to 1");
    public Action DESEMP_bFrom_ato_2 = new DynamicAction("DESEMP b from a to 2");
    public Action DESEMP_bFrom_cto_0 = new DynamicAction("DESEMP b from c to 0");
    public Action DESEMP_bFrom_cto_1 = new DynamicAction("DESEMP b from c to 1");
    public Action DESEMP_bFrom_cto_2 = new DynamicAction("DESEMP b from c to 1");

    public Action DESEMP_cFrom_ato_0 = new DynamicAction("DESEMP c from a to 0");
    public Action DESEMP_cFrom_ato_1 = new DynamicAction("DESEMP c from a to 1");
    public Action DESEMP_cFrom_ato_2 = new DynamicAction("DESEMP c from a to 2");
    public Action DESEMP_cFrom_bto_0 = new DynamicAction("DESEMP c from b to 0");
    public Action DESEMP_cFrom_bto_1 = new DynamicAction("DESEMP c from b to 1");
    public Action DESEMP_cFrom_bto_2 = new DynamicAction("DESEMP c from b to 1");

    public Action EMP_aFrom_0to_b = new DynamicAction("EMP a from b to 0");
    public Action EMP_aFrom_1to_b = new DynamicAction("EMP a from b to 1");
    public Action EMP_aFrom_2to_b = new DynamicAction("EMP a from b to 2");
    public Action EMP_aFrom_0to_c = new DynamicAction("EMP a from c to 0");
    public Action EMP_aFrom_1to_c = new DynamicAction("EMP a from c to 1");
    public Action EMP_aFrom_2to_c = new DynamicAction("EMP a from c to 2");

    public Action EMP_bFrom_0to_a = new DynamicAction("EMP b from a to 0");
    public Action EMP_bFrom_1to_a = new DynamicAction("EMP b from a to 1");
    public Action EMP_bFrom_2to_a = new DynamicAction("EMP b from a to 2");
    public Action EMP_bFrom_0to_c = new DynamicAction("EMP b from c to 0");
    public Action EMP_bFrom_1to_c = new DynamicAction("EMP b from c to 1");
    public Action EMP_bFrom_2to_c = new DynamicAction("EMP b from c to 2");

    public Action EMP_cFrom_0to_a = new DynamicAction("EMP c from a to 0");
    public Action EMP_cFrom_1to_a = new DynamicAction("EMP c from a to 1");
    public Action EMP_cFrom_2to_a = new DynamicAction("EMP c from a to 2");
    public Action EMP_cFrom_0to_b = new DynamicAction("EMP c from b to 0");
    public Action EMP_cFrom_1to_b = new DynamicAction("EMP c from b to 1");
    public Action EMP_cFrom_2to_b = new DynamicAction("EMP c from b to 2");
    */
    // ==================== NOVA IMPLEMENTAÇÃO ====================
    
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
    
    public void setState(char bloco1, int i1, int j1,char bloco2, int i2, int j2,char bloco3, int i3, int j3  ){
        zeraTudo();
        stacks[i1][j1] = bloco1;  //todos empilhandos na posicao 0
        stacks[i2][j2] = bloco2;
        stacks[i3][j3] = bloco3;        
    }

}
