package DAO;

import defPac.Pet;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    Configuration con = new Configuration().configure()
            .addAnnotatedClass(Pet.class);
    StandardServiceRegistryBuilder st = new StandardServiceRegistryBuilder()
            .applySettings(con.getProperties());
    SessionFactory sessionFactory = con.buildSessionFactory(st.build());

    public HibernateSessionFactory() throws HibernateException {
    }
}
