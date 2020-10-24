package HomeWork23;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = null;

        try {
            factory = new Configuration().configure().buildSessionFactory();
            StudentDAO studentDAO = new StudentDAO(factory);

            final Student student1 = new Student();

            student1.setStudentId(10);
            student1.setFullName("user1");
            student1.setAdmissionYear(2222);
            student1.setGroupId(null);

            final Student student2 = new Student();

            student2.setStudentId(11);
            student2.setFullName("user1");
            student2.setAdmissionYear(3333);
            student2.setGroupId(null);

            studentDAO.create(student1);
            studentDAO.create(student2);

            System.out.println("===========");
            System.out.println(studentDAO.findStudentsById(10));
            System.out.println("===========");
            System.out.println(studentDAO.findStudentsByName("user1"));
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
