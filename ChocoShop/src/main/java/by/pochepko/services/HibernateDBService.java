package by.pochepko.services;

import by.pochepko.DAO.PromoCodeDAO;
import by.pochepko.DAO.PromoCodeDAOImpl;
import by.pochepko.model.Chocolate;
import by.pochepko.model.Promocode;
import by.pochepko.model.Stock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

@Service
public class HibernateDBService implements DBService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Autowired
    private SessionFactory sf;

    @Transactional
    @Override
    public Iterable<Promocode> readPromocodes() {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        PromoCodeDAO dao = new PromoCodeDAOImpl(session);
        List<Promocode> promoCodes = dao.readPromocodes();
        transaction.commit();
        return promoCodes;
    }

    @Override
    public Iterable<Stock> loadStock() {
        return null;
    }

    @Override
    public Iterable<Chocolate> readChocolates() {
        return null;
    }

    @Override
    public Promocode getPromocodeByCode(String code) {
        return null;
    }

    @Override
    public int getStockQuantityByChocolate(Chocolate chocolate) {
        return 0;
    }

    @Override
    public Chocolate saveChocolate(Chocolate chocolate) {
        return null;
    }

    @Override
    public Optional<Chocolate> findChocolateById(int id) {
        return Optional.empty();
    }


}
