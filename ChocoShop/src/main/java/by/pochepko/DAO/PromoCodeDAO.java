package by.pochepko.DAO;

import by.pochepko.PromoCode;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PromoCodeDAO {
    private Session session;

    public PromoCodeDAO(Session session) {
        this.session = session;
    }

    public List<PromoCode> readPromocodes() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PromoCode> criteria = builder.createQuery(PromoCode.class);
        criteria.from(PromoCode.class);
        return session.createQuery(criteria).list();
    }
}
