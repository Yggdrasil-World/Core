package de.yggdrasil.logger;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public interface Markers {
    Marker GUILD = MarkerManager.getMarker("GUILD");
}
