package com.ami.tech.util;
import com.ami.tech.util.*;
public interface ATList<T>{
    public void add(T data);

    public void add(int index, T data);

    public void insert(T data);

    public void insert(int index, T data);

    

    public void removeAll();

    public T removeAt(int index);

  //  public T remove();
    public void clear(); 


public int size();
 public T get(int index);
  public void update(int index, T data);

    public void copyTo(ATList<T> atList);

    public void copyFrom(ATList<T> atList);

    public void appendTo(ATList<T> atList);

    public void appendFrom(ATList<T> atList);

   public void forEach(ATListItemAcceptor<T> a);

    public ATIterator<T> iterator();
    // public Object start();
    // public void getAll();

}