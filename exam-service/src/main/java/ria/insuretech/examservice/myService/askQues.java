package ria.insuretech.examservice.myService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ria.insuretech.examservice.entity.model;
import ria.insuretech.examservice.entity.question;
import ria.insuretech.examservice.entity.user;
import ria.insuretech.examservice.repository.quesRepository;
import ria.insuretech.examservice.repository.resultRepository;

@Service
public class askQues {
    @Autowired
    private quesRepository quesBank;

    @Autowired
    private resultRepository results;

    private int maxLevel = 3;
    private String lastQuestion = "3,1,1";

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
        lastQuestion = Integer.toString(maxLevel);
        for (int i = 0; i < maxLevel; i++) {
            lastQuestion += ",1";
        }
    }

    public String creatQues(model tModel) {

        quesBank.save(tModel);
        return tModel.toString();
    }

    public List<model> getAll() {

        return quesBank.findAll();
    }

    public Optional<model> getById(String id) {
        return quesBank.findById(id);

    }

    public String delete(String id) {
        quesBank.deleteById(id);
        return "deleted question with id : " + id;
    }

    public question nextQues(String email, String ans) {
        question next = new question();

        if (results.existsById(email)) {
            String ques = results.findById(email).get().getLastques();
            String[] tem = ques.split(",");

            if (quesBank.findById(ques).get().getAns().equalsIgnoreCase(ans)) {
                int newScore = results.findById(email).get().getScore() + 1;

                if (tem.length < maxLevel) {

                    ques = ques + ",1";
                    next = quesBank.findById(ques).get().getQues();

                } else {
                    int a = Integer.parseInt(tem[0]) + 1;
                    ques = String.valueOf(a);
                    if (tem[0].equals(Integer.toString(maxLevel)))
                        return null;
                    next = quesBank.findById(ques).get().getQues();
                }
                results.save(new user(email, ques, newScore));
                if (ques.equalsIgnoreCase(lastQuestion))
                    return null;
            } else {
                int a = Integer.parseInt(tem[0]) + 1;
                ques = String.valueOf(a);
                if (tem[0].equalsIgnoreCase(Integer.toString(maxLevel)))
                    return null;
                next = quesBank.findById(ques).get().getQues();
            }
        } else {
            user tem = new user(email, "1", 0);
            results.save(tem);
            next = quesBank.findById("1").get().getQues();
        }

        return next;
    }

    public String getScore(String email) {
        if (results.existsById(email))
            return " your score in the examinatio is " + results.findById(email).get().getScore();
        else
            return "user not found";
    }

}
