package de.yggdrasil.core.dal.pipeline;

import java.util.Set;

public interface PipelineCollector {

    Set<Class<? extends Pipeline>> collectPipelines();

}
