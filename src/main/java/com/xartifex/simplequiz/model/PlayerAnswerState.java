package com.xartifex.simplequiz.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"question", "player"}, name = "UNIQUE_Q_P")})
public class PlayerAnswerState implements Serializable {
    @Id
    @GeneratedValue
    private long Id;

    @JoinColumn(name = "player")
    @ManyToOne
    @NotNull
    private Player player;

    @JoinColumn(name = "question")
    @ManyToOne
    @NotNull
    private Question question;

    //can be null
    @Size(min = 1, max = 2000, message = "1-2000 letters and spaces")
    private String answer;

    boolean isCorrect;

    long expiresOn;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public long getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(long expiresOn) {
        this.expiresOn = expiresOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerAnswerState that = (PlayerAnswerState) o;

        return Id == that.Id;
    }

    @Override
    public int hashCode() {
        return (int) (Id ^ (Id >>> 32));
    }

    @Override
    public String toString() {
        return "PlayerAnswer{" +
                "Id=" + Id +
                ", player=" + player.getId() +
                ", question=" + question +
                ", answer='" + answer + '\'' +
                ", isCorrect=" + isCorrect +
                ", expiresOn=" + expiresOn +
                '}';
    }
}