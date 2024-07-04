package com.example.ECF_4.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Interview {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate interviewDate;
    private String location;
    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", interviewDate=" + interviewDate +
                ", location='" + location + '\'' +
                ", application=" + application +
                '}';
    }
}
