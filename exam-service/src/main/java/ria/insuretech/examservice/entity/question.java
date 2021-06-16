package ria.insuretech.examservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "model")
public class question {
    public String ques;
    public String A;
    public String B;
    public String C;
    public String D;

    public question(String ques, String A, String B, String C, String D) {
        this.ques = ques;
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
    }

    public question() {
    }

    @Override
    public String toString() {
        return "question [ ques= " + ques + ", A=" + A + ", B=" + B + ", C=" + C + ", D=" + D + " ]";
    }

}
