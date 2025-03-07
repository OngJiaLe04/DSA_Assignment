/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author ongji
 */
import java.io.Serializable;
import java.util.Arrays;

public class ArrayList<T> implements ListInterface<T>, Serializable {
    
    private T[] array;
    private int size;
    private static final int INITIAL_CAPACITY = 10;
    
    // constructor
    public ArrayList(){
        array = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }
    
    public void add(T item){
        ensureCapacity();
        array[size++] = item;
    }
    
    public void add(int index, T item){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        ensureCapacity();
        System.arraycopy(array, index, array, index+1, size-index);
        array[index] = item;
        size++;
    }
    
    public T get(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }
    
    public T remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        T removedItem = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        return removedItem;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public boolean contains(T entry){
        boolean found = false;
        for(int index = 0; !found && (index < size); index++){
            if(array[index].equals(entry)){
                found = true;
            }
        }
        return found;
    }
    
    public void clear(){
        size =0;
    }
    
    private void ensureCapacity(){
        if(size == array.length){
            T[] oldArray = array;
            array = (T[]) new Object[oldArray.length * 2];
            for(int i = 0; i < oldArray.length; i++){
                array[i] = oldArray[i];
            }
        }
    }
}
