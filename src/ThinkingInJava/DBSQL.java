package ThinkingInJava;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by rarshion on 16/9/6.
 */
public class DBSQL {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DBTable{
        public String name() default "";
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Constraints{
        boolean primaryKey() default false;
        boolean allowNull() default true;
        boolean unique() default false;
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SQLString{
        int value() default 0;
        String name() default "";
        Constraints constraints() default @Constraints;
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SQLInteger {
        String name() default "";
        Constraints constraints() default @Constraints;
    }

    public @interface Uniqueness{
        Constraints constraints() default @Constraints(unique = true);
    }

    @DBSQL.DBTable(name = "MEMBER")
    public class Member{
        @SQLString(30) String firstName;
        @SQLString(50) String lastName;
        @SQLInteger
        Integer age;
        @SQLString(value=3, constraints = @Constraints(primaryKey = true)) String handle;
        /*
        static int memberCount;
        public String getHandle() { return this.handle;}
        public String getFirstName() {return this.firstName;}
        public String getLastName() {return this.lastName;}
        public String toString(){return handle;}
        public Integer getAge() { return this.age;}
        */

    }


}
