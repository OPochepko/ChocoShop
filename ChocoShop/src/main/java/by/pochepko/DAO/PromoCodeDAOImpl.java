package by.pochepko.DAO;

import by.pochepko.model.PromoCode;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PromoCodeDAOImpl implements PromoCodeDAO {
    private Session session;

    public PromoCodeDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public List<PromoCode> readPromocodes() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PromoCode> criteria = builder.createQuery(PromoCode.class);
        criteria.from(PromoCode.class);
        return session.createQuery(criteria).list();
    }
}
