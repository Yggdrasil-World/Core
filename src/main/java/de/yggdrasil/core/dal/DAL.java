package de.yggdrasil.core.dal;

import de.yggdrasil.core.dal.pipeline.DALPipelineProzessor;
import de.yggdrasil.core.dal.requests.DALReadRequest;
import de.yggdrasil.core.dal.requests.DALWriteRequest;
import de.yggdrasil.core.dal.responses.DALResponse;
import de.yggdrasil.core.exceptions.dal.MissingPipelineException;
import de.yggdrasil.core.strings.logging.DALLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DAL {

    private Logger logger = LogManager.getLogger(DAL.class);

    private final static DAL instance = new DAL();
    private final DALPipelineProzessor pipelineProzessor = new DALPipelineProzessor();

    public void save(DALWriteRequest saveRequest) {
        try {
            logger.info(DALLogger.DAL_SAVE.formatted(saveRequest.getClass().getName()));
            this.pipelineProzessor.writeData(saveRequest);
        } catch (MissingPipelineException e) {
            logger.error(DALLogger.DAL_EXCEPTION_PIPELINE.formatted(saveRequest.getClass().getName()));
            e.printStackTrace();
        }
    }

    public DALResponse read(DALReadRequest readRequest) {
        try {
            logger.info(DALLogger.DAL_READ.formatted(readRequest.getClass().getName()));
            return this.pipelineProzessor.readData(readRequest);
        } catch (MissingPipelineException e) {
            logger.error(DALLogger.DAL_EXCEPTION_PIPELINE.formatted(readRequest.getClass().getName()));
            e.printStackTrace();
            return null;
        }
    }

    public static DAL get(){
        return instance;
    }

}
