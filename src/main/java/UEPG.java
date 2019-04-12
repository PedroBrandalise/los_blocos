
import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.environment.blocks.BlocksFunctionFactory;
import aima.core.environment.blocks.BlocksGoalState;
import aima.core.environment.blocks.BlocksState;
import aima.core.environment.jugs.JugsFunctionFactory;
import aima.core.environment.jugs.JugsGoalTest;
import aima.core.environment.jugs.JugsState;

import aima.core.logic.propositional.parsing.ast.Sentence;
import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.uninformed.DepthLimitedSearch;
import java.util.List;

import aima.core.logic.propositional.inference.PLResolution;
import aima.core.logic.propositional.kb.KnowledgeBase;
import aima.core.logic.propositional.parsing.PLParser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jcarlos
 */
public class UEPG {

    public static void main(String[] args) {
        UEPG vUEPG = new UEPG();
        try {
            //vUEPG.testPLResolveExercicio();
            vUEPG.testBlocksLDS10();
        } catch (Exception erro) {
            erro.printStackTrace();
            System.out.println("ERRO: " + erro);
        }

    }

    public void testBlocksLDS10() throws Exception {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("sb");
        sb.append("bs");

        BlocksState blockState = new BlocksState();
        BlocksGoalState goalState = new BlocksGoalState();

        blockState.setState('a', 0, 0, 'b', 1, 0, 'c', 2, 0);
        goalState.setGoal('a', 0, 0, 'b', 0, 1, 'c', 0, 2);

        Problem problem = new Problem(blockState, BlocksFunctionFactory.getActionsFunction(),
                BlocksFunctionFactory.getResultFunction(), goalState);

        DepthLimitedSearch search = new DepthLimitedSearch(6);
        SearchAgent agent = new SearchAgent(problem, search);

        List<Action> actions = agent.getActions();
        printGeneralActions(actions);
        System.out.println(search.getMetrics().toString());
        //Assert.assertEquals(true, search.isCutOff(actions));
    }

    public void JugsDepthLimitedSearch() throws Exception {
        Problem problem = new Problem(new JugsState(),
                JugsFunctionFactory.getActionsFunction(),
                JugsFunctionFactory.getResultFunction(),
                new JugsGoalTest());
        Search search = new DepthLimitedSearch(12);
        SearchAgent agent = new SearchAgent(problem, search);
        List<Action> actions = agent.getActions();
//		assertCorrectPlacement(actions);
//              printActions(actions);
//		Assert.assertEquals("113",agent.getInstrumentation().getProperty("nodesExpanded"));
    }

    public void testPLResolveExercicio() {
        PLResolution resolution;
        resolution = new PLResolution(true);
        PLParser parser;
        parser = new PLParser();
        KnowledgeBase kb = new KnowledgeBase();
        // e.g. from AIMA3e pg. 254
        kb.tell("(A <=> (B & E))");
        kb.tell("(E => D)");
        kb.tell("((C & E) => ~D)");
        kb.tell("(E => B)");
        kb.tell("(B => F)");
        kb.tell("(B => C)");
        Sentence alpha = parser.parse("~A");

        boolean b = resolution.plResolution(kb, alpha);
        System.out.println("resp");
        System.out.println(b);
    }

    private void printGeneralActions(List<Action> actions) {
        java.util.Iterator<Action> ai = actions.iterator();
        while (ai.hasNext()) {
            Action a = ai.next();
//                aima.core.environment.jugs.JugsState q;
//                q = (aima.core.environment.jugs.JugsState) a;
//                System.out.println(q.getState());
            System.out.println(((DynamicAction) a).getName());
        }

    }

}
