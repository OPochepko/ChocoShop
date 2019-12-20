package by.pochepko.services;

import by.pochepko.model.Promocode;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class SpringPromocodeApplierFactoryImpl implements PromocodeApplierFactory, ApplicationContextAware {

    private ApplicationContext context;

    private Promocode promocode;
    @Autowired
    private DBService dbService;

    @Override
    public PromocodeApplier getPromocodeApplier(String code) {

        promocode = dbService.getPromocodeByCode(code);

        PromocodeApplier promocodeApplier = context.getBeansOfType(PromocodeApplier.class)
                .get(getPromocodeApplierBeanNameFromPromocode(promocode));
        promocodeApplier.setPromocode(promocode);
        return promocodeApplier;

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    private String getPromocodeApplierBeanNameFromPromocode(Promocode promocode) {
        String promocodeClassName = promocode.getClass().getSimpleName();
        String defaultPromocodeApplierBeanName = Character.toLowerCase(promocodeClassName.charAt(0))
                + promocodeClassName.substring(1) + "Applier";
        return defaultPromocodeApplierBeanName;
    }
}
