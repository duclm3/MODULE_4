package service;

import model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService{
    private static Map<Integer, Student> studentMap = new HashMap<>();
    static {
        studentMap.put(1,new Student(1,"Tuyen","Ha Noi"));
        studentMap.put(2, new Student(2,"Thien", "CodeGym"));
        studentMap.put(3, new Student(3,"Phuong", "C1220G1"));
    }
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public void save(Student student) {
        studentMap.put(student.getId(),student);
    }

    @Override
    public Student findById(int id) {
        return studentMap.get(id);
    }

    @Override
    public void delete(int id) {
        studentMap.remove(id);
    }
}
