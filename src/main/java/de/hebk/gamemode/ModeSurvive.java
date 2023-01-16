package de.hebk.gamemode;

import de.hebk.gamemode.Gamemode;
import de.hebk.model.stack.Stack;

import java.util.Random;

public class ModeSurvive extends Gamemode {

    private Questions currentQuestion;
    private int count = 0;
    /**
     * Konstruktor
     */
    public ModeSurvive() {setModeSurvive(getModeSurvive());}
    @Override
    /**
     * Da der Gamemode Joker hat, wird diese Methode nicht verwendet
     */
    public void useJoker(int pInput) {
    }


    @Override
    /**
     * Da der Gamemode Joker hat, wird diese Methode nicht verwendet
     */
    public void jokerHinzufuegen(Joker pJoker) {

    }

    @Override
    /**
     * überprüft den Parameter, ob dieser gleich ist wie die korrekte Antwort der momentanen Frage
     */
    public boolean checkcorrect(String pAnswer) {
        return pAnswer.equals(currentQuestion.getCorrect());
    }

    @Override
    /**
     *
     */
    public void randomQuestion(String pContext) {
        Stack<Questions> tmp = new Stack<>();
        Random rand = new Random();
        int j = rand.nextInt(modeSurvive.getLenght()+1);
        System.out.println(modeSurvive.getLenght());
        for(int i = 0; i < j ; i++){
            tmp.push(modeSurvive.top());
            modeSurvive.pop();
        }
        currentQuestion = modeSurvive.top();
        modeSurvive.pop();
        while(!tmp.isEmpty()){
            modeSurvive.push(tmp.top());
            tmp.pop();
        }
    }

    @Override
    /**
     * nöchste Frage
     */
    public void nextQuestion() {
        modeSurvive.pop();
        count++;
    }

    @Override
    /**
     * liefert die momentane Frage zurück
     */
    public Questions getCurrentQuestion() {
        return currentQuestion;
    }

    @Override
    /**
     * setzt die momentan Frage
     */
    public void setCurrentQuestion(Questions pCurrentQuestion) {
        currentQuestion=pCurrentQuestion;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
