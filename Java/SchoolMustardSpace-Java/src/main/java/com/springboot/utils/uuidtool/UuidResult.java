package com.springboot.utils.uuidtool;

import java.util.UUID;

/**
 * UuidResult
 * TODO
 * @description UuidResult
 * @author 221701412_theTuring
 * @version v 1.0.0
 * @since 2020.4.29
 */
public class UuidResult {

    /**
     * UuidResult
     * TODO
     * @description setUuidResult返回uuid
     * @author 221701412_theTuring
     * @version v 1.0.0
     * @since
     */
    public String setUuidResult() {

       return UUID.randomUUID().toString();
    }
}
    