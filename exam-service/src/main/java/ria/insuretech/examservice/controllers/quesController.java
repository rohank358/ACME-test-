package ria.insuretech.examservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ria.insuretech.examservice.entity.model;
import ria.insuretech.examservice.entity.question;
import ria.insuretech.examservice.myService.askQues;

@RestController
public class quesController {
    @Autowired
    private askQues questions;

    @PostMapping("/create")
    public String create(@RequestBody model tModel) {

        return questions.creatQues(tModel);
    }

    @PutMapping("/update")
    public String update(@RequestBody model tModel) {

        return questions.creatQues(tModel);
    }

    @GetMapping("/getAll")
    public List<model> getAll() {
        return questions.getAll();
    }

    @GetMapping("/get/{id}")
    public Optional<model> get(@PathVariable String id) {
        return questions.getById(id);
    }

    @GetMapping("/nextQues/{email}/{ans}")
    public question getNext(@PathVariable String email, @PathVariable String ans) {
        return questions.nextQues(email, ans);
    }

    @GetMapping("/score/{email}")
    public String getNext(@PathVariable String email) {
        return questions.getScore(email);
    }

    @DeleteMapping("/ACME/delete")
    public String deleteQues(@RequestBody String id) {
        return questions.delete(id);
    }

    @RequestMapping()
    public String nothing() {
        return "Site working successfully";
    }
}
