package de.yggdrasil.core.dal.adapter;

import org.reflections.Reflections;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultAdapterCollector implements AdapterCollector{

    public Set<Class<? extends Adapter>> collectAdapters() {
        Reflections reflections = new Reflections("de.yggdrasil");
        return reflections.getTypesAnnotatedWith(DALAdapter.class).stream()
                .filter(Adapter.class::isAssignableFrom)
                .filter(aClass -> Arrays.stream(aClass.getConstructors()).anyMatch(constructor -> constructor.getParameterCount() == 0))
                .map(aClass -> (Class<Adapter>) aClass)
                .collect(Collectors.toUnmodifiableSet());
    }

}
