package site.j2k.worldbox.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Log {
    private static Logger logger = LogManager.getLogger("worldcolonies");

    private Log() {
    }

    public static Logger getLogger() {
        return logger;
    }
}
