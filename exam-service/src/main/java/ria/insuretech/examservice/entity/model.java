package ria.insuretech.examservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "model")
public class model {

    @Id
    public String id;
    public question ques;
    public String ans;

    public model(String id, question ques, String ans) {
        this.id = id;
        this.ques = ques;
        this.ans = ans;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public question getQues() {
        return ques;
    }

    public void setQues(question ques) {
        this.ques = ques;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    @Override
    public String toString() {
        return "model [ans=" + ans + ", id=" + id + ", ques=" + ques.toString() + "]";
    }

}
