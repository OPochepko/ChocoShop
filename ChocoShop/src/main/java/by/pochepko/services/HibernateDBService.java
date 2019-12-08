package by.pochepko.services;

import by.pochepko.DAO.PromoCodeDAO;
import by.pochepko.PromoCode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Service
public class HibernateDBService implements DBService {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Autowired
    private SessionFactory sf;

    public HibernateDBService() {
    }

    @Override
    public List<PromoCode> readPromocodes() {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        PromoCodeDAO dao = new PromoCodeDAO(session);
        List<PromoCode> promoCodes = dao.readPromocodes();
        transaction.commit();
        return promoCodes;
    }

}
