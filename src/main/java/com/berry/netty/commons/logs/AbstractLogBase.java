package com.berry.netty.commons.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractLogBase {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
}
