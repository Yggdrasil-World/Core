package de.yggdrasil.core.dal;

import de.yggdrasil.core.dal.pipeline.DALPipelineProzessor;
import de.yggdrasil.core.dal.requests.DALReadRequest;
import de.yggdrasil.core.dal.requests.DALWriteRequest;
import de.yggdrasil.core.exceptions.dal.MissingPipelineException;

public class DAL {

    private final static DAL instance = new DAL();
    private final DALPipelineProzessor pipelineProzessor = new DALPipelineProzessor();

    public void save(DALWriteRequest saveRequest) throws MissingPipelineException {
        this.pipelineProzessor.writeData(saveRequest);
    }

    public DALResponse read(DALReadRequest readRequest) throws MissingPipelineException {
        return this.pipelineProzessor.readData(readRequest);
    }

    public static DAL get(){
        return instance;
    }

}
