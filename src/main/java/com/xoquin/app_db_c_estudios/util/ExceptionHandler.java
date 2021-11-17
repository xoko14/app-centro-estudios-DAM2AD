package com.xoquin.app_db_c_estudios.util;

import com.xoquin.app_db_c_estudios.factory.DialogFactory;

public class ExceptionHandler {
    public static void handle(Exception e){
        DialogFactory df = new DialogFactory(DialogFactory.EXCEPTION_DIALOG);
        df.setException(e);
        df.launch();
    }
}
