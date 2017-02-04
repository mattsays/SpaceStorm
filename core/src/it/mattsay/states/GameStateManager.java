package it.mattsay.states;

/**
 * Created by MattSay on 04/02/2017.
 */
public class GameStateManager {

    static GameStates gstate = GameStates.IN_MENU;

    public enum GameStates {
        IN_MENU,IN_GAME;
    }

    public static GameStates getState() {
        return gstate;
    }

    public static void setState(GameStates state) {
        gstate = state;
    }

}
