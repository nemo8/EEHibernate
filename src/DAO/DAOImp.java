package DAO;

import Pojo.Pet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.PrintWriter;
import java.util.List;

public class DAOImp extends DAO<Pet> {
    PrintWriter pw;
    public DAOImp(PrintWriter pw) {
        this.pw = pw;
    }

    @Override
    public boolean insert(Pet entity) {
            try {
            Session session = new HibernateSessionFactory().sessionFactory.openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            session.close();
                return true;
            } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    return false;
    }

    @Override
    public boolean update(Pet entity) {
        try {
           Session session = new HibernateSessionFactory().sessionFactory.openSession();
           session.beginTransaction();
           session.update(entity);
           session.getTransaction().commit();
           session.close();
                return true;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Session session = new HibernateSessionFactory().sessionFactory.openSession();
            Pet pet = session.load(Pet.class,id);
            session.beginTransaction();
            session.delete(pet);
            session.getTransaction().commit();
            session.close();
                return true;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Pet> selectAll() {
        try {
           Session session = new HibernateSessionFactory().sessionFactory.openSession();
           session.beginTransaction();
           Query query = session.createQuery("select from pets");
           List<Pet> pets =query.list();
           session.close();
            return pets;
        } catch (HibernateException e) {
           System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Pet selectOne(int id) {
        Pet pet = null;
        try {
            Session session = new HibernateSessionFactory().sessionFactory.openSession();
            pet = session.get(Pet.class,id);
            return pet;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
