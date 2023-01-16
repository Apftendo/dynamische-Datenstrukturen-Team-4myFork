package de.hebk.gamemode;

import de.hebk.gamemode.Gamemode;
import de.hebk.model.queue.Queue;

import java.util.Random;

public class ModeJeopardy extends Gamemode {
    private int lvl;
    private Questions currentQuestion;

    /**
     * Konstruktor
     */
    public ModeJeopardy(){
        setModeJeopardy(getModeJeopardy());
    }
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
     * Generiert eine Randomfrage aus der Queue modeSurvive
     * Diese Frage muss das gleiche Thema haben, wie der Parameter pTopic
     */
    public void randomQuestion(String pTopic) {
        Random rand = new Random();
        Queue<Questions> tmp = new Queue<>();
        Queue<Questions> topic = new Queue<>();
        while(!modeJeopardy.isEmpty()){
            if(modeJeopardy.front().getTopic().equals(pTopic)){
                topic.enqueue(modeJeopardy.front());
                modeJeopardy.dequeue();
            }else{
                tmp.enqueue(modeJeopardy.front());
                modeJeopardy.dequeue();
            }
        }
        int j = rand.nextInt(topic.getLenght()+1);
        System.out.println(j);
        for(int i = 0; i <= j;i++){
            topic.enqueue(topic.front());
            topic.dequeue();
        }
        if(topic.front().getDifficulty() == lvl) {
            currentQuestion = topic.front();
            topic.dequeue();
        }else{
            while(currentQuestion == null){
                if(topic.front().getDifficulty() == lvl) {
                    currentQuestion = topic.front();
                    topic.dequeue();
                }
                topic.enqueue(topic.front());
                topic.dequeue();
            }
        }
        while (!topic.isEmpty()) {
            tmp.enqueue(topic.front());
            topic.dequeue();
        }
        while (!tmp.isEmpty()) {
            modeJeopardy.enqueue(tmp.front());
            tmp.dequeue();
        }
    }

    @Override
    /**
     * wird nicht verwendet
     */
    public void nextQuestion() {
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
     * setzt die momentane Frage
     */
    public void setCurrentQuestion(Questions pCurrentQuestion) {
        currentQuestion = pCurrentQuestion;
    }

    @Override
    /**
     * liefert das aktuelle Level zurück
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * setzt das aktuelle Level
     * @param lvl
     */
    @Override
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
}


