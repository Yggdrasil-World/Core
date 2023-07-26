package de.yggdrasil.core.dal.pipeline;

import de.yggdrasil.core.dal.DALResponse;
import de.yggdrasil.core.dal.adapter.AdapterLibrary;
import de.yggdrasil.core.dal.requests.DALReadRequest;
import de.yggdrasil.core.dal.requests.DALRequest;
import de.yggdrasil.core.dal.requests.DALWriteRequest;
import de.yggdrasil.core.exceptions.dal.MissingPipelineException;

import java.util.HashMap;

public class DALPipelineProzessor {

    private final AdapterLibrary library = new AdapterLibrary();
    private final HashMap<Class<DALRequest>, Pipeline> requestTypePipelineMap = new HashMap<>();

    {
        setup();
    }

    private void setup(){
        this.addPipelineCollection(new DefaultPipelineCollector());
        System.out.println(requestTypePipelineMap.size());
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
        for (Class<? extends Pipeline> pipelineClass:
                collector.collectPipelines()) {
            this.addPipeline(pipelineClass);
        }
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
