package ria.insuretech.examservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "results")
public class user {
    @Id
    private String id;
    private String lastques;
    private int score;

    public user(String id, String lastques, int score) {
        this.id = id;
        this.lastques = lastques;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastques() {
        return lastques;
    }

    public void setLastques(String lastques) {
        this.lastques = lastques;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
