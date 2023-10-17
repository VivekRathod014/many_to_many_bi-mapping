package many_to_many_bi;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vivek");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student s1 = new Student();
		s1.setName("abc");
		s1.setEmail("abc@gmail.com");
		
		Student s2 = new Student();
		s2.setName("def");
		s2.setEmail("def@gmail.com");
		
		Student s3 = new Student();
		s3.setName("xyz");
		s3.setEmail("xyz@gmail.com");
		
		Courses c1 = new Courses();
		c1.setCourse_name("HTML");
		
		Courses c2 = new Courses();
		c2.setCourse_name("CSS");
		
		Courses c3 = new Courses();
		c3.setCourse_name("JAVA");
		
		ArrayList<Courses>course = new ArrayList<Courses>();
		course.add(c1);
		course.add(c2);
		course.add(c3);
		
		ArrayList<Student>students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		
       s1.setCourse(course);
       s2.setCourse(course);
       s3.setCourse(course);
       
       
       c1.setStudents(students);
       c2.setStudents(students);
       c3.setStudents(students);
       
       
       entityTransaction.begin();
       entityManager.persist(s1);
       entityManager.persist(s2);
       entityManager.persist(s3);
       entityManager.persist(c1);
       entityManager.persist(c2);
       entityManager.persist(c3);
       entityTransaction.commit();
	}

}
