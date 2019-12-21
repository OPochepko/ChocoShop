package by.pochepko.services;

import by.pochepko.model.Promocode;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link PromocodeApplierFactory} and {@link ApplicationContextAware}: gives implementation
 * of {@link PromocodeApplier} that suitable for given promocode.
 * Automatically search for {@link PromocodeApplier} beans in ApplicationContex by promocode.
 * Bean name of {@link PromocodeApplier} bean should start from simple class name of given promocode with suffix
 * "Applier" and first char should be in lower case. For example {@link PromocodeApplier} bean name for ExamplePromocode.class should be
 * "examplePromocodeApplier. This meet the default Spring bean name for ExamplePromocodeApplier.class.
 *
 * @author Oleg Pochepko
 */

@Service
public class SpringPromocodeApplierFactoryImpl implements PromocodeApplierFactory, ApplicationContextAware {
    /** ApplicationContext that this object runs in */
    private ApplicationContext context;
    /** Promocode to apply*/
    private Promocode promocode;
    /** Service to excess data base*/
    @Autowired
    private DBService dbService;

    /**
     *
     * @param code - code of {@link Promocode} to get suitable PromocodeApplier bean for
     * @return PromocodeApplier bean for this promocode
     */
    @Override
    public PromocodeApplier getPromocodeApplier(String code) {

        promocode = dbService.getPromocodeByCode(code);

        PromocodeApplier promocodeApplier = context.getBeansOfType(PromocodeApplier.class)
                .get(getPromocodeApplierBeanNameFromPromocode(promocode));
        promocodeApplier.setPromocode(promocode);
        return promocodeApplier;

    }

    /**
     * Set ApplicationContext that this object runs in
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * @param promocode - promocode
     * @return name of Promocode bean suitable to apply promocode
     */
    private String getPromocodeApplierBeanNameFromPromocode(Promocode promocode) {
        String promocodeClassName = promocode.getClass().getSimpleName();
        String defaultPromocodeApplierBeanName = Character.toLowerCase(promocodeClassName.charAt(0))
                + promocodeClassName.substring(1) + "Applier";
        return defaultPromocodeApplierBeanName;
    }
}
