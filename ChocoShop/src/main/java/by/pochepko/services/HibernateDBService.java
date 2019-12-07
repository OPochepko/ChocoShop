package by.pochepko.services;

import by.pochepko.DAO.PromoCodeDAO;
import by.pochepko.PromoCode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HibernateDBService implements DBService {
    private final SessionFactory sf;

    public HibernateDBService() {
        Configuration configuration = new Configuration();
//        configuration.addAnnotatedClass(PromoCode.class);
//        configuration.setProperty("connection.url", "jdbc:postgresql://localhost:5432/ChocoShopDB");
//        configuration.setProperty("connection.driver_class", "org.postgresql.Driver");
//        configuration.setProperty("connection.username", "postgres");
//        configuration.setProperty("connection.password", "3211385");
//        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        configuration.setProperty("hbm2ddl.auto", "auto");
//        configuration.setProperty("show_sql", "true");
//        configuration.setProperty("format_sql", "true");
//        configuration.setProperty("hibernate.connection.useSSL", "false");
        sf = configuration.configure().buildSessionFactory();
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
