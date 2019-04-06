/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aima.core.environment.jugs;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;

/**
 *
 * @author jcarlos
 */
public class JugsState {
    
    public int state[];  //vetor com 2 inteiros - pote de 5 e de 3
    
    public Action ESVASIAR_4L = new DynamicAction("ESVASIAR_4L");
    public Action ESVASIAR_3L = new DynamicAction("ESVASIAR_3L");
    public Action COMPLETAR_3L = new DynamicAction("COMPLETAR_3L");
    public Action COMPLETAR_4L = new DynamicAction("COMPLETAR_4L");
    public Action DESPEJAR_3L_4L = new DynamicAction("DESPEJAR_3L_4L");
    public Action DESPEJAR_4L_3L = new DynamicAction("DESPEJAR_4L_3L");
    public Action COMPLETAR_3L_C4L = new DynamicAction("COMPLETAR_3L_com_4L");
    public Action COMPLETAR_4L_C3L = new DynamicAction("COMPLETAR_4L_com_3L");

    
    
    public JugsState() {
        state = new int[2];
        state[0] = 4;
        state[1] = 3;
    }
    
    
    public void setState(int j5, int j3) {
        state[0]=j5;
        state[1]=j3;
    }
    
    public int[] getState() {
        return state;
    }
    //set que muda o estado
    
    public String getStateAsString() {
        String s = String.valueOf(this.state[0]);
        s = "(" +s + ","+String.valueOf(this.state[1])+")";
        return s;
    }
    
}
