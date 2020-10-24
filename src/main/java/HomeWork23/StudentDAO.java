package HomeWork23;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.List;

public class StudentDAO{

    private final SessionFactory factory;

    public StudentDAO(SessionFactory factory){
        this.factory = factory;
    }

    public void create(Student student) {
        try(final Session session = factory.openSession()) {

            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();

        }
    }

    public Student findStudentsById(Integer id) {
        try (final Session session = factory.openSession()) {
            return session.createQuery("SELECT i FROM Student i WHERE i.studentId = " + id, Student.class).getSingleResult();
        }
    }

    public List<Student> findStudentsByName(String fullName) {
        try (final Session session = factory.openSession()) {
            TypedQuery<Student> query = session.createQuery("SELECT n FROM Student n WHERE n.fullName = :fullName", Student.class);
            return query.setParameter("fullName", fullName).getResultList();
        }
    }

}
