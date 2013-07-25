package com.devicehive.messages.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Params {

    public final static long DEFAULT_WAIT_TIMEOUT = 30L;
    public final static long MAX_WAIT_TIMEOUT = 60L;
    public final static DateFormat UTC_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    private Params() {
    }

    public static long parseWaitTimeout(String waitTimeout) {
        long timeout = waitTimeout == null ? DEFAULT_WAIT_TIMEOUT : Long.parseLong(waitTimeout);
        return timeout > MAX_WAIT_TIMEOUT ? MAX_WAIT_TIMEOUT : timeout;

    }

    public static Date parseUTCDate(String timestampUTC) {
        if (timestampUTC == null) {
            return null;
        }

        try {
            return UTC_DATE_FORMAT.parse(timestampUTC);
        }
        catch (ParseException e) {
            return null;
        }
    }

}