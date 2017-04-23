package leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by rarshion on 16/9/3.
 */

class NestedInteger{

    public List<Integer> listV;
    public int intV;
    private boolean isInt = false;
    private boolean isList = false;

    public NestedInteger(int intV, List<Integer> listV){
        this.intV = intV;
        this.listV = listV;
    }

    public List<Integer> getList(){
        return this.listV;
    }

    public Integer getInteger(){
        return this.intV;
    }

    public void setIsList(boolean isList){
        this.isList = isList;
    }

    public boolean isList(){
        return this.isList;
    }

    public void setIsInteger(boolean isInt){
        this.isInt = isInt;
    }

    public boolean isInteger(){
        return isInt;
    }
}
