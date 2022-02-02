package ru.gb.pugacheva.interview_course_hw7.repositoties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.pugacheva.interview_course_hw7.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
