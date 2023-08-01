package de.yggdrasil.core.dal.pipeline;

import java.util.Set;

public interface PipelineCollector {

    public Set<Class<? extends Pipeline>> collectPipelines();

}
