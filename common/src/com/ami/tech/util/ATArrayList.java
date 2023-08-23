package com.amit.tech.util;

import com.ami.tech.util.*;

public class ATArrayList<T> implements ATList<T> {

    private Object collection[];
    private int size;
    public class ATArrayListIterator<T> implements ATIterator<T>{
        private int index;
        public ATArrayListIterator()
        {
            this.index=0;
        }
        public boolean hasNext()
        {
            return index!=size;
        }
        public T next()
        {
            if(index==size)throw new ArrayIndexOutOfBoundsException("Iterator has not been inatilized");
            T data=(T)get(index);
            index++;
            return data;
        }
    }
    public ATIterator<T> iterator()
    {
        return new ATArrayListIterator<T>();
    }
    public ATArrayList()
    {
        this.collection=new Object[10];
        this.size=0;
    }
    public void clear()
    {
        this.size=0;
    }
    public T removeAt(int index)
    {
        if(index<0 || index>=this.size)throw new IndexOutOfBoundsException("index out of bound");
        T data=(T)this.collection[index];
        int ep=this.size-2;
        for(int e=index; e<=ep; e++)
        {
            this.collection[e]=this.collection[e+1];
        }
        this.size--;
        return data;
    }
    public void add(T data)
    {
        if(this.size==collection.length)
        {
            Object [] tmp=new Object[this.size+10];
            for(int e=0; e<this.size; e++)tmp[e]=this.collection[e];
            this.collection=tmp;
        }
        this.collection[this.size]=data;
        this.size++;
    }
    public void add(int index, T data)
    {
        if(index<0 || index>this.size)throw new IndexOutOfBoundsException("Index out of bound");
        if(this.size==collection.length)
        {
            Object []tmp=new Object[this.size+10];
            for(int e=0; e<this.size; e++)tmp[e]=this.collection[e];
            this.collection=tmp;
        }
        for(int e=this.size; e>index; e--)
        {
            this.collection[e]=this.collection[e-1];
        }
        this.collection[index]=data;
        this.size++;
    }
    public T get(int index)
    {
        if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Index out of Bounds");
        return (T)this.collection[index];
    }
    public int size()
    {
        return this.size();
    }
    public void insert(int index, T data)
    {
        add( index, data);

    }
    public void insert(T data)
    {
        add(data);
    }
    public void removeAll()
    {
        clear();
    }
    // public T remove()
    // {
    //     clear();
    // }
    public void update(int index, T data)
    {
        if(index<0 || index>=this.size)throw new IndexOutOfBoundsException("Index out of bound");
        this.collection[index]=data;

    }
    public void copyTo(ATList<T> other)
    {
        other.clear();
        for(int i=0; i<this.size(); i++)other.add(this.get(i));
    }
    public void copyFrom(ATList<T> other)
    {
        this.clear();
        for(int i=0; i<other.size(); i++)this.add(other.get(i));
    }
    public void appendTo(ATList<T> other)
    {
        for(int i=0; i<this.size(); i++)other.add(this.get(i));
    }
    public void appendFrom(ATList<T> other)
    {
        for(int i=0; i<other.size(); i++)this.add(other.get(i)); 
    }
    public void forEach(ATListItemAcceptor<T> a)
    {
        if(a==null)return;
        for(int e=0; e<this.size; e++)a.accept((T)collection[e]);
    }



}
