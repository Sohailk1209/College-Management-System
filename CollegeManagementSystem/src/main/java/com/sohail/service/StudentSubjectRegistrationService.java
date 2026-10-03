package com.sohail.service;

import java.util.List;

public interface StudentSubjectRegistrationService {
    void studentSubjectRegistrationWithStudentId(Long id, List<Long> subjectIds);
}
