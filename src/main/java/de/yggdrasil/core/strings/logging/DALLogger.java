package de.yggdrasil.core.strings.logging;

public interface DALLogger {

    String DAL_SAVE = "DAL Save Request: %s";

    String DAL_READ = "DAL Load Request: %s";

    String DAL_EXCEPTION_PIPELINE = "No Pipeline for Request %s configured.";

}
