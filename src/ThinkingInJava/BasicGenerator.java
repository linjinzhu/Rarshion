package ThinkingInJava;


/**
 * Created by rarshion on 16/9/3.
 */
/*
public class BasicGenerator<T> implements Generator<T> {

    private Class<T> type;
    public BasicGenerator(Class<T> type){
        this.type = type;
    }

    public T next(){
        try{
            return type.newInstance();
        }catch (Exception ex){

        }
    }

    public static <T>Generator<T> create(Class<T> type){
        return new BasicGenerator<T>(type);
    }
}
*/