package com.servlet.login.DAO;

import com.servlet.login.Model.Client;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDAO {
    private final SessionFactory factory = HibernateUtil.getSessionFactory();

    public List<Client> findAll() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Client ").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Could'nt find any client " + e.getMessage());
        }
    }

    public void save(Client client) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Error persisting new client " + e.getMessage());
        }
    }

    public void delete(Client client) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Error deleting client " + e.getMessage());
        }
    }

    public Client findById(Long id) {
        try (Session session = factory.openSession()) {
            return session.get(Client.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Error finding client by Id " + e.getMessage());
        }
    }

    public boolean existsByNameAndEmail(Client client) {
        Client existingClient;
        try (Session session = factory.openSession()) {
            List<Client> clientList = session.createQuery(" from Client where email = :email or name = :name").
                    setParameter("email", client.getEmail()).setParameter("name", client.getName()).getResultList();
            if (!clientList.isEmpty()) {
                return true;
            }
            return false;
        }
    }

    public Client findByNameAndEmail(Client client) {
        try (Session session = factory.openSession()) {
            Query query = session.createQuery("from Client where name = :name and email = :email");
            query.setParameter("name", client.getName());
            query.setParameter("email", client.getEmail());
            return session.get(Client.class, query.getSingleResult());
        }
    }

    public void update(Client client) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Error updating user " + e.getMessage());
        }
    }
}

