package de.yggdrasil.core.dal.pipeline;

import org.reflections.Reflections;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultPipelineCollector implements PipelineCollector{

    public Set<Class<? extends Pipeline>> collectPipelines() {
        Reflections reflections = new Reflections("de.yggdrasil");
        return reflections.getTypesAnnotatedWith(DALPipeline.class).stream()
                .filter(Pipeline.class::isAssignableFrom)
                .filter(aClass -> Arrays.stream(aClass.getConstructors()).anyMatch(constructor -> constructor.getParameterCount() == 0))
                .map(aClass -> (Class<Pipeline>) aClass)
                .collect(Collectors.toUnmodifiableSet());
    }

}
