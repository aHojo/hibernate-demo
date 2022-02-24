package com.ahojo.hibernate.demo;


import com.ahojo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {
        // create the session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create the session

        Session session = factory.getCurrentSession();

        try {
            // Use the session object to save Java Object

            // start transaction
            session.beginTransaction();

            // query students
            List<Student> thestudents = session.createQuery("from Student").getResultList();
            // display the students
            displayStudent(thestudents);

            //query students with last name hojo
            thestudents = session.createQuery("FROM Student s where s.lastName = 'Hojo'").getResultList();
            System.out.println();
            displayStudent(thestudents);


            // query students: last name hojo or first name = kairi

            thestudents = session.createQuery("FROM Student s where s.lastName = 'Hojo' OR s.firstName = 'Kairi'").getResultList();
            System.out.println("--OR--");
            displayStudent(thestudents);

            thestudents = session.createQuery("FROM Student s where s.email LIKE '%airi%@gmail.com'").getResultList();
            System.out.println("--LIKE--");
            displayStudent(thestudents);
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }

    private static void displayStudent(List<Student> thestudents) {
        for (Student tempS: thestudents) {
            System.out.println(tempS);
        }
    }
}
