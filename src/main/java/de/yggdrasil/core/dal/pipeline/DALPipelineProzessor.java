package de.yggdrasil.core.dal.pipeline;

import de.yggdrasil.core.dal.responses.DALResponse;
import de.yggdrasil.core.dal.adapter.AdapterLibrary;
import de.yggdrasil.core.dal.requests.DALReadRequest;
import de.yggdrasil.core.dal.requests.DALRequest;
import de.yggdrasil.core.dal.requests.DALWriteRequest;
import de.yggdrasil.core.exceptions.dal.MissingPipelineException;
import de.yggdrasil.core.strings.logging.DALPipelineProzessorLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class DALPipelineProzessor {

    private final AdapterLibrary library = new AdapterLibrary();
    private Logger logger = LogManager.getLogger(DALPipelineProzessor.class);
    private final HashMap<Class<DALRequest>, Pipeline> requestTypePipelineMap = new HashMap<>();

    {
        setup();
    }

    private void setup(){
        this.addPipelineCollection(new DefaultPipelineCollector());
    }

    public DALResponse readData(DALReadRequest readRequest) throws MissingPipelineException {
        Pipeline pipeline = this.selectPipeline(readRequest);
        if (pipeline == null){
            throw new MissingPipelineException(readRequest);
        }
        return pipeline.readBytes(readRequest);
    }

    public void writeData(DALWriteRequest writeRequest) throws MissingPipelineException {
        Pipeline pipeline =  this.selectPipeline(writeRequest);
        if (pipeline == null){
            throw new MissingPipelineException(writeRequest);
        }
        pipeline.writeBytes(writeRequest);
    }

    public void addPipelineCollection(PipelineCollector collector){
        int count = 0;
        for (Class<? extends Pipeline> pipelineClass:
                collector.collectPipelines()) {
            this.addPipeline(pipelineClass);
            count++;
        }
        logger.info(DALPipelineProzessorLogger.ADD_PIPELINE_COLLECTION.formatted(count, requestTypePipelineMap.size()));
    }

    private void addPipeline(Class<? extends Pipeline> pipelineClass){
        try {
            Pipeline pipelineInstance = pipelineClass.newInstance();
            for (Class<DALRequest> requestType:
                    pipelineInstance.applyForRequestTypes()) {
                requestTypePipelineMap.put(requestType, pipelineInstance);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private Pipeline selectPipeline(DALRequest request) {
        return this.requestTypePipelineMap.get(request.getClass());
    }

}
