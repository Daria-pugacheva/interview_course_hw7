package ru.gb.pugacheva.interview_course_hw7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.pugacheva.interview_course_hw7.repositoties.StudentRepository;
import ru.gb.pugacheva.interview_course_hw7.entities.Student;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> showAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).get(); // без проверок на наличие в БД студента с таким id, потому что логика внешней формы не предполагает ошибок
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void update(Student student) {
        Student studentForUpdate = studentRepository.findById(student.getId()).get(); //тут тоже однозначно найдем студента по логике того, что прилетает с фронта
        studentForUpdate.setName(student.getName());
        studentForUpdate.setAge(student.getAge()); // сохранится уже сам по факту закрытия транзакции (поэтому нет никакого метода типа save())
    } //ну и тут никакой оптимизации на тему сохранения только тех полей, что изменились, потому что данных мало.
}
