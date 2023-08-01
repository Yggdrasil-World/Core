package de.yggdrasil.core.dal.data;

import org.reflections.Reflections;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultDatasourceCollector implements DatasourceCollector{

    @Override
    public Set<Class<? extends DataSource>> collectDatasources() {
        Reflections reflections = new Reflections("de.yggdrasil");
        Set<Class<?>> ignored = reflections.getTypesAnnotatedWith(HideFromDefaultCollector.class);
        return reflections.getTypesAnnotatedWith(DALDatasource.class).stream()
                .filter(DataSource.class::isAssignableFrom)
                .filter(aClass -> {return  !ignored.contains(aClass);})
                .filter(aClass -> Arrays.stream(aClass.getConstructors()).anyMatch(constructor -> constructor.getParameterCount() == 0))
                .map(aClass -> (Class<DataSource>) aClass)
                .collect(Collectors.toUnmodifiableSet());
    }

}
