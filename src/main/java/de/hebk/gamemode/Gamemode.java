package de.hebk.gamemode;


import de.hebk.model.list.List;
import de.hebk.model.queue.Queue;
import de.hebk.model.stack.Stack;

public abstract class Gamemode {
    /**
     * Diese Klasse ist eine abstrakte Klasse und liefert die Methoden und Variabeln für den jeweiligen Gamemode
     * Diese Klasse ist außerdem die Oberklasse(Polymorphie) der Klassen ModerNormal,ModeJeopardy und ModeSurvive
     */
    private Joker[] joker = new Joker[3];
    private int lvl;
    public List<Questions> modeNormal;
    public Stack<Questions> modeSurvive;
    public Queue<Questions> modeJeopardy;
    public abstract void useJoker(int pInput);
    public abstract void jokerHinzufuegen(Joker pJoker);
    public abstract boolean checkcorrect(String pAnswer);
    public abstract void randomQuestion(String pContext);
    public abstract void nextQuestion();
    public Joker[] getJoker() {
        return joker;
    }
    public void setJoker(Joker[] joker) {
        this.joker = joker;
    }
    public List<Questions> getModeNormal() {
        return modeNormal;
    }
    public void setModeNormal(List<Questions> modeNormal) {
        this.modeNormal = modeNormal;
    }
    public Stack<Questions> getModeSurvive() {
        return modeSurvive;
    }
    public void setModeSurvive(Stack<Questions> modeSurvive) {
        this.modeSurvive = modeSurvive;
    }
    public Queue<Questions> getModeJeopardy() {
        return modeJeopardy;
    }
    public void setModeJeopardy(Queue<Questions> modeJeopardy) {
        this.modeJeopardy = modeJeopardy;
    }
    public abstract Questions getCurrentQuestion();
    public abstract void setCurrentQuestion(Questions currentQuestion);
    public int getLvl() {
        return lvl;
    }
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
}

