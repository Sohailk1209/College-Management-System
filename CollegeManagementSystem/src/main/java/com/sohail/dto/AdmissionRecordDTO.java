package com.sohail.dto;

import com.sohail.entity.Student;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdmissionRecordDTO {

    private Long id;

    private Integer fee;

    private Student student;
}
