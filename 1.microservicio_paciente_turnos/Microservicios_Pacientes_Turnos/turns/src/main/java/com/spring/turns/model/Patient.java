package com.spring.turns.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private Long patientId;
    private String name;
    private String lastName;
    private String dni;
    private LocalDate birthDate;
    private String phoneNumber;
}
