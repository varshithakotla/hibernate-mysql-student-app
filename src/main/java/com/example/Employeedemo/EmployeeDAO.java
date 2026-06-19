package com.example.Employeedemo;

import java.util.List;



public class EmployeeDAO {

    public void saveEmployee(Employee employee) {

        Transaction tx = null;

        try (Session session =
                     Utility.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.persist(employee);

            tx.commit();

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {

        try (Session session =
                     Utility.getSessionFactory().openSession()) {

            return session.createQuery(
                    "from Employee",
                    Employee.class
            ).list();
        }
    }

    public Employee getEmployeeById(int id) {

        try (Session session =
                     Utility.getSessionFactory().openSession()) {

            return session.get(Employee.class, id);
        }
    }

    public void updateEmployee(Employee employee) {

        Transaction tx = null;

        try (Session session =
                     Utility.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.merge(employee);

            tx.commit();

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {

        Transaction tx = null;

        try (Session session =
                     Utility.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Employee employee =
                    session.get(Employee.class, id);

            if (employee != null) {
                session.remove(employee);
            }

            tx.commit();

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        }
    }
}