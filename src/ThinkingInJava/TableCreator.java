package ThinkingInJava;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rarshion on 16/9/7.
 */
public class TableCreator {

    public static void main(String[] args) throws ClassNotFoundException {
        for(String className : args){
            Class<?> cl = Class.forName(className);
            DBSQL.DBTable dbTable = cl.getAnnotation(DBSQL.DBTable.class);
            if(dbTable == null){
                System.out.println("No DBTable annotations in class" + className);
                continue;
            }

            String tableNaem = dbTable.name();
            if(tableNaem.length() < 1)
                tableNaem = cl.getName().toUpperCase();
            List<String> columnDefs = new ArrayList<String>();
            for(Field field : cl.getDeclaredFields()){
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if(anns.length < 1){
                    continue;
                }

                if(anns[0] instanceof DBSQL.SQLInteger){
                    DBSQL.SQLInteger sInt = (DBSQL.SQLInteger)anns[0];
                    if(sInt.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else{
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName);
                }
            }
        }
    }
}
