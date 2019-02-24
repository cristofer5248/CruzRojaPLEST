/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cruzplest.www.utils;

/**
 *
 * @author cristofer
 */
public class LimitAttempts {

    private int AttemptsUser = 2;
    private int AttemptsXX = 2;

    /**
     * @return the AttemptsUser
     */
    public int getAttemptsUser() {
        return AttemptsUser;
    }

    /**
     * @param AttemptsUser the AttemptsUser to set
     */
    public void setAttemptsUser(int AttemptsUser) {
        this.AttemptsUser = AttemptsUser;
    }

    /**
     * @return the AttemptsXX
     */
    public int getAttemptsXX() {
        return AttemptsXX;
    }

    /**
     * @param AttemptsXX the AttemptsXX to set
     */
    public void setAttemptsXX(int AttemptsXX) {
        this.AttemptsXX = AttemptsXX;
    }

}
