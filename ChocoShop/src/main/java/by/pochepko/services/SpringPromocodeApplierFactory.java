package by.pochepko.services;

import by.pochepko.model.Promocode;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Service
public class SpringPromocodeApplierFactory implements PromocodeApplierFactory {

    private Promocode promocode;

    private Map<Class<?>, PromocodeApplier> registeredAppliers;

    public SpringPromocodeApplierFactory(ApplicationContext context) {

        registeredAppliers = context.getBeansOfType(PromocodeApplier.class)
                .values()
                .stream()
                .collect(toMap(PromocodeApplier::compitableWith, r -> r));

    }

    @Override
    public <P extends Promocode> PromocodeApplier getPromocodeApplier(Class<P> promocodeClazz) {
        PromocodeApplier promocodeApplier = registeredAppliers.get(promocodeClazz);
        if (promocodeApplier == null) {
            throw new IllegalArgumentException("There is no registered PromocodeApplier implementation for passed Promocode");
        }
        return promocodeApplier;

    }

}
