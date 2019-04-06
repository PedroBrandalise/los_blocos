/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.test.core.unit.enviroment.blocks;

import aima.core.environment.blocks.BlocksFunctionFactory;
import aima.core.environment.blocks.BlocksGoalState;
import aima.core.environment.blocks.BlocksState;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rafam
 */
public class BlocksGoalTestTest {

    BlocksFunctionFactory functions;
    BlocksGoalState goalState;
    BlocksState state;

    @Before
    public void setUp() {
        BlocksGoalState goal = new BlocksGoalState();
        BlocksState board = new BlocksState();
    }


    @Test
    public void testInCorrectPlacement() {
        // verificar se ao colocar a posicao diferente da final ele retorna falso
        state.stacks[0][0] = 'a';
        state.stacks[1][1] = 'b';
        state.stacks[2][2] = 'c';
        Assert.assertFalse(goalState.isGoalState(state));
    }

    @Test
    public void testCorrectPlacement() {
        // verificar se ao colocar a posicao final ele retorna sucesso
        state.stacks[0][0] = 'a';
        state.stacks[0][1] = 'b';
        state.stacks[0][2] = 'c';
        Assert.assertTrue(goalState.isGoalState(state));
    }

}
