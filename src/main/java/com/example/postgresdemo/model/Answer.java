package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "answers")
public class Answer extends AuditModel {
    @Id
    @GeneratedValue(generator = "answer_generator")
    @SequenceGenerator(
            name = "answer_generator",
            sequenceName = "answer_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(columnDefinition = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Question question;

    // Getters and Setters (Omitted for brevity)
    public void setQuestion(Question str){
      this.question = str;
    }
    public void setText(String txt){
      this.text = txt;
    }
    public void setId(Long num){
      this.id = num;
    }
    public Long getId(){
      return this.id;
    }
    public String getText(){
      return this.text;
    }
    public Question getQuestion(){
      return this.question;
    }
}