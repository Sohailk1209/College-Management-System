package com.sohail.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdmissionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer fee;

    @OneToOne(cascade = {CascadeType.PERSIST , CascadeType.REMOVE , CascadeType.MERGE})
    @JoinColumn(nullable = false)
    private Student student;
}
