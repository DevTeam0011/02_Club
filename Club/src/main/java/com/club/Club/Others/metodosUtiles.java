package com.club.Club.Others;

import java.util.List;

public class metodosUtiles {
    private static void checkArraysHaveSameLength(Object[] array1, Object[] array2) throws Exception {
        if (array1.length != array2.length)
            throw new Exception("Arrays don't have the same length");
    }

    public static void validateFieldsAreNotEmptyOrNull(String[] fieldNames, Object... fields) throws Exception {
        checkArraysHaveSameLength(fieldNames, fields);
        for (int i = 0; i < fieldNames.length; i++) {
            if (fields[i] == null)
                throw new Exception(fieldNames[i]);
            if (fields[i] instanceof String && ((String) fields[i]).isBlank())
                throw new Exception(fieldNames[i]);
            if (fields[i] instanceof List) {
                List<?> lista = (List<?>) fields[i];
                for (Object object : lista) {
                    if (object == null)
                        throw new Exception(fieldNames[i]);
                }
            }
        }
    }

}
