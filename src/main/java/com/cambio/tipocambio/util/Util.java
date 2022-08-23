package com.cambio.tipocambio.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class Util {

    public static Date fechaActual() {
        ZoneId actualZone = ZoneId.systemDefault();
        ZonedDateTime actualZonedDatetime = LocalDateTime.now().atZone(actualZone);
        ZoneId limaZone = ZoneId.of("America/Lima");
        ZonedDateTime limaDatetime = actualZonedDatetime.withZoneSameInstant(limaZone);

        return Date.from(limaDatetime.toLocalDateTime().atZone(ZoneId.systemDefault()).toInstant());
    }
}
