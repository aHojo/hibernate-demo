package com.ahojo.hibernate.demo;

import com.ahojo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PirmaryKeyDemo {
    public static void main(String[] args) {
        // create the session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create the session

        Session session = factory.getCurrentSession();

        try {
            // Use the session object to save Java Object
            // create Student object
            System.out.println("Creating 3 student object....");
            Student tempStudent = new Student("Kairi1", "Hojo", "kairi1@gmail.com");
            Student tempStudent1 = new Student("Lin", "Hojo", "lin@gmail.com");
            Student tempStudent2 = new Student("Andrew", "Hojo", "andrew@gmail.com");
            // start transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the students..");
            session.save(tempStudent);
            session.save(tempStudent1);
            session.save(tempStudent2);
            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }
}
