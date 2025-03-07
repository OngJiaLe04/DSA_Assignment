/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author ongji
 */
public interface ListInterface<T> {
    void add(T item);               // add an item to the end of the list
    void add(int index, T item);    // add an item at a specifc index
    T get(int index);               // get an item by index
    T remove(int index);            // remove an item by index
    int size();                     // get the number of elements in the list
    boolean isEmpty();              // check if the list is empty
    boolean contains(T entry);
    void clear();                   // remove all elements from the list
}
