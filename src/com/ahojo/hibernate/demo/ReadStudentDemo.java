package com.ahojo.hibernate.demo;


import com.ahojo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.rmi.StubNotFoundException;


public class ReadStudentDemo {
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
            System.out.println("Creating the student object....");
            Student tempStudent = new Student("Kairi", "Hojo", "kairi@gmail.com");
            // start transaction
//            session.beginTransaction();

            // save the student object
//            System.out.println("Saving the student");
//            session.save(tempStudent);
            // commit the transaction
//            session.getTransaction().commit();
            // REtrieve the student from the db
            System.out.println("Getting the student by ID " + tempStudent.getId());

            // start a new transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\n----\n");
            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Got ---- " + myStudent);

            session.getTransaction().commit();


            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }
}
