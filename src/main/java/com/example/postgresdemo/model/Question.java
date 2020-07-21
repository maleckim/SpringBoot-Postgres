package com.example.postgresdemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questions")
public class Question extends AuditModel {
    @Id
    @GeneratedValue(generator = "question_generator")
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1000
    )
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    // Getters and Setters (Omitted for brevity)
    public void setTitle(final String tit) {
      this.title = tit;
    }

    public void setDescription(final String des) {
      this.description = des;
    }

    public void setId(Long num){
      this.id = num;
    }

    public Long getId(){
      return this.id;
    }

    public String getTitle(){
      return this.title;
    }
    public String getDescription(){
      return this.description;
    }
}