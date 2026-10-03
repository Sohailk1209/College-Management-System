# College Management System

A backend **College Management System REST API** built with **Spring Boot** and **PostgreSQL**.

This project provides REST APIs to manage students, professors, subjects, admission records, and the relationships between students, subjects, and professors.

## 🚀 Features

- Student management
- Professor management
- Subject management
- Admission management
- Student-subject registration
- Professor-subject mapping
- CRUD operations
- Partial update operations using PATCH
- PostgreSQL database integration
- Hibernate ORM
- Spring Data JPA
- DTO-based architecture
- ModelMapper integration
- Custom exception handling
- JPA entity relationships

## 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| Java 21 | Programming Language |
| Spring Boot 4.1.1 | Backend Framework |
| Spring Web MVC | REST API Development |
| Spring Data JPA | Data Persistence |
| Hibernate | ORM |
| PostgreSQL | Database |
| Maven | Build & Dependency Management |
| Lombok | Boilerplate Code Reduction |
| ModelMapper | Entity-DTO Mapping |
| Jakarta Persistence | Entity Relationships |

## 🏗️ Project Architecture

The application follows a layered architecture:

```text
Controller
     ↓
Service
     ↓
Repository
     ↓
PostgreSQL Database





########Project Structure#######

src/main/java/com/sohail/
│
├── config/
│   └── AppConfig.java
│
├── controller/
│   ├── StudentController.java
│   ├── ProfessorController.java
│   ├── SubjectController.java
│   ├── AdmissionRecordController.java
│   ├── StudentSubjectRegistration.java
│   └── ProfessorSubjectMapping.java
│
├── dto/
│   ├── StudentDTO.java
│   ├── ProfessorDTO.java
│   ├── SubjectDTO.java
│   └── AdmissionRecordDTO.java
│
├── entity/
│   ├── Student.java
│   ├── Professor.java
│   ├── Subject.java
│   └── AdmissionRecord.java
│
├── repository/
│   ├── StudentRepository.java
│   ├── ProfessorRepository.java
│   ├── SubjectRepository.java
│   └── AdmissionRecordRepository.java
│
├── service/
│   ├── StudentService.java
│   ├── ProfessorService.java
│   ├── SubjectService.java
│   ├── AdmissionRecordService.java
│   ├── StudentSubjectRegistrationService.java
│   └── ProfessorSubjectMappingService.java
│
├── service/impl/
│   └── Service Implementations
│
└── exception/
    └── ResourceNotFoundException.java




