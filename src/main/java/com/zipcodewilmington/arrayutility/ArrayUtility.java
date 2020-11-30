package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.lang.reflect.Field;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {

    private T[] genArray;

    public ArrayUtility(T[] input){
       this.genArray = input;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        ArrayList<T> list0 = new ArrayList<>(Arrays.asList(genArray));
        ArrayList<T> list1 = new ArrayList<>(Arrays.asList(arrayToMerge));
        list0.addAll(list1);
        this.genArray = list0.toArray(genArray);
        return Collections.frequency(list0,valueToEvaluate);
    }

    public T[] removeValue(T valueToRemove) {
        ArrayList<T> list0 = new ArrayList<>(Arrays.asList(genArray));

        while(list0.contains(valueToRemove)) {
            list0.remove(valueToRemove);
        }
        T[] newArray = (T[]) Array.newInstance(valueToRemove.getClass(),list0.size()); //Type casting new instance of the array to T
        newArray = list0.toArray(newArray);
        return newArray;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T mostCommonItem = null;
        ArrayList<T> list0 = new ArrayList<>(Arrays.asList(genArray));
        ArrayList<T> list1 = new ArrayList<>(Arrays.asList(arrayToMerge));
        list0.addAll(list1);
        Integer max = Collections.frequency(list0,list0.get(0));
        for(T item: list0){
            if(Collections.frequency(list0,item)> max){
                max = Collections.frequency(list0,item);
            }
        }
        for(T item: list0){
            if(Collections.frequency(list0,item) == max){
               mostCommonItem = item;
            }
        }
        return mostCommonItem;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        ArrayList<T> list0 = new ArrayList<>(Arrays.asList(genArray));
        return Collections.frequency(list0, valueToEvaluate);
    }
}
