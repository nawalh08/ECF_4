package com.example.ECF_4.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nameCandidate;
    private String mailCandidate;

    @ManyToOne
    @JoinColumn(name = "jobOffer_id")
    private JobOffer jobOffer;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCandidate() {
        return nameCandidate;
    }

    public void setNameCandidate(String nameCandidate) {
        this.nameCandidate = nameCandidate;
    }

    public String getMailCandidate() {
        return mailCandidate;
    }

    public void setMailCandidate(String mailCandidate) {
        this.mailCandidate = mailCandidate;
    }

    public JobOffer getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(JobOffer jobOffer) {
        this.jobOffer = jobOffer;

    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", nameCandidate='" + nameCandidate + '\'' +
                ", mailCandidate='" + mailCandidate + '\'' +
                ", jobOffer=" + jobOffer +
                '}';
    }
}
