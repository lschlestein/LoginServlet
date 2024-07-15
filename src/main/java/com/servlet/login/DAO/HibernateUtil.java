package com.servlet.login.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    /*Cria uma nova SessionFactory. Essa SessionFactory será criada somente uma vez,
     *na incialização do nosso programa. Após o método getSessionFactory() passará a factory
     * para que as DAOs, façam uso dessa mesma SessionFactory para fazer buscar e inserções
     *no banco de dados.
     */
    private static SessionFactory sessionFactory = buildSessionFactory();

    /*Cria uma nova Configuration, com base nas informações do hibernate.cfg.xml
     *
     */
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError("Erro ao configurar o Hibernate" + e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}