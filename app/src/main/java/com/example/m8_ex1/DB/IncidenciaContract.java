package com.example.m8_ex1.DB;

import android.provider.BaseColumns;

public class IncidenciaContract {
    public static abstract class IncidenciaEntry implements BaseColumns {
        public static final String TABLE_NAME ="incidencia";
        public static final String ID = "id";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_TITLE_SPINNER = "categori";
    }

}
