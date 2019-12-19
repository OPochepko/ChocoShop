package by.pochepko.DAO;

import by.pochepko.model.Promocode;
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
    public List<Promocode> readPromocodes() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Promocode> criteria = builder.createQuery(Promocode.class);
        criteria.from(Promocode.class);
        return session.createQuery(criteria).list();
    }
}
