package com.ami.tech.util;

import org.w3c.dom.Node;

public class ATLInkedList<T> implements ATList<T> {
     class ATNode<T>

    {
        public T data;
        public ATNode<T> next;
        ATNode(){
            this.data=null;
            this.next=null;
        }
    }
    
    

    public class ATLinkedListIterator<T> implements ATIterator<T> {
        private ATNode<T> ptr;

        public ATLinkedListIterator(ATNode<T> ptr) {
            this.ptr = ptr;
        }

        public boolean hasNext() {
            return this.ptr != null;
        }

        public T next(){
            if(ptr==null)throw new ArrayIndexOutOfBoundsException("Iterator has been invalidated");
            T data=this.ptr.data;
            this.ptr=ptr.next;
            return data;

        }
    }

    public ATIterator<T> iterator() {
        return new ATLinkedListIterator<T>(this.start);
    }

    private ATNode<T> start;
    private ATNode<T> end;
    public static int size;

    public ATLInkedList() {
       this.start = null;
        this.end = null;
        this.size = 0;
    }

   

    public Object start() {
        return start;
    }

    public void insert(T data) {

        ATNode<T> t = new ATNode<T>();
        t.data=data;
        if(this.start==null)
        {
            this.start=t;
            this.end=t;

        }
        else{
            this.end.next=t;
            end=t;

        }
        this.size++;


        // if (start == null) {
        //     start = n1;
        //     point = start;
        //     point.data = data;
        //     point.next = null;
        //     size++;
        //     System.out.println("Node Created");
        // } else {
        //     point.next = n1;
        //     point = n1;
        //     point.data = data;
        //     size++;
        //     System.out.println("Node Created");
        // }
    }
    public int size()
    {
        return this.size;
    }


    public void add(T data) {
        insert(data);
    }

    public void add(int index, T data) {
        if(index<0)throw new ArrayIndexOutOfBoundsException("invalid index");
        if(index>=size)
        {
            add(data);
            return;
        }
        ATNode<T> node=new ATNode<T>();
        node.data=data;
        if(index==0)
        {
            node.next=this.start;
            this.start=node;
        }
        else
        {
            ATNode<T> j,k;
            int i;
             j=this.start;
             i=0;
             k=null;
            while(i<index)
            {
                k=j;
                j=j.next;
                i++;
            }
            k=j;
            j=j.next;
            i++;
             k.next=node;
        node.next=j;

        }
       

        this.size++; //recheck;


        // Node node = new Node();
        // Node temp = new Node();
        // temp = start;
        // if (index <= 0 || index > (size + 1)) {
        //     throw ArrayIndexOutOfBoundsException(
        //             "Invalid Index: " + index + "\n" + "You can add from 1 to" + (size + 1));
        //     System.out.println();
        //     return;
        // }
        // if (index == 1) {
        //     node.next = start;
        //     node.data = data;
        //     start = node;

        // }
        // if (index == size + 1) {
        //     insert(data);
        //     return;
        // } else {
        //     for (int x = 1; x < index - 1; x++) {
        //         temp = temp.next;
        //     }
        //     node.next = temp.next;
        //     temp.next = node;
        //     temp.data = data;
        // }
        // size++;
    }

    public void insert(int index, T data) {
        add(index, data);

    }
    public void clear(){
       this.removeAll();
    }

    public void removeAll() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    public T removeAt(int index) {
       if(index<0 || index>=this.size) throw new ArrayIndexOutOfBoundsException("invalid index");
       T data;
       if(start==end)  //only one node
       {
        data=this.start.data;
        this.start=null;
        this.end=null;
        this.size=0;
        return data;
       }
       if(index==0) // many but remove first
       {
        data=this.start.data;
        this.start=this.start.next;
        this.size--;
        return data;
       }
       ATNode<T> j,k;
       k=null;
       int i;
       j=this.start;
       i=0;
       while(i<index)
       {
        k=j;
        j=j.next;
        i++;


       }
       data=j.data;
       k.next=j.next;
       if(this.end==j)this.end=k;
       this.size--;
       return data;
        // T data;
        // Node temp = new Node();
        // temp = start;
        // if (index > size || index < 1)
        //     throw ArrayIndexOutOfBoundsException("Invalid Index: " + index + "\n" + "You can remove from 1 to" + size);

        // if (index == 1) {
        //     start = start.next;
        //     data = start.data;
        //     size--;

        // } else {
        //     for (int i = 1; i < index - 1; i++) {
        //         temp = temp.next;
        //     }
        //     data = temp.next.data;
        //     temp.next = temp.next.next;
        // }
        // System.out.println("removed at" + index);
        // size--;
        // return data;
    }

    public T remove() {
        T data;
        data = start.data;
        start = start.next;
        size--;
        return data;
    }

    // public void getAll() {
    //     Node temp = new Node();
    //     temp = start;

    //     while (temp != null) {
    //         System.out.println(temp.data);
    //         temp = temp.next;

    //     }
    // }

    public T get(int index) {
        if(index<0|| index>=this.size)throw new ArrayIndexOutOfBoundsException("invalid index");
        int x;
        x=0;
        ATNode<T> t;
        t=start;
        while(x<index)
        {
            t=t.next;
            x++;

        }
        return t.data;
    
        // if (index < 1 || index > size)
        //     throw ArrayIndexOutOfBoundsException("Invalid Index: " + index + "\n" + "You can get  from 1 to" + index);
        // Node temp = new Node();
        // temp = start;
        // for (int i = 1; i < index; i++) {
        //     temp = temp.next;
        // }
        // return temp.data;
    }
 public void update(int index, T data) {
        if(index<0 || index>=this.size)throw new ArrayIndexOutOfBoundsException("invalid index");
        if(index==0)
        {
            this.start.data=data;
            return;

        }
        if(index==this.size-1)
        {
            this.end.data=data;
            return;
        }
        ATNode<T> j;
        int i;
        i=0;
        j=this.start;
        while(i<index)
        {
            j=j.next;
            i++;
        }
        j.data=data;


        // Node temp = new Node();
        // temp = start;
        // for (int i = 1; i < index; i++) {
        //     temp = temp.next;
        // }
        // temp.data = data;
        // System.out.println("Data successfully updated ");

    }
    public void copyTo(ATList<T> other) {
        other.clear();
        for(int e=0; e<this.size(); e++) other.add(this.get(e));

        // ATNode<T> temp = new ATNode<T>();
        // temp = start;
        // int i = 1;
        // atList.removeAll();
        // while (temp != null) {
        //     atList.add(this.getAt(i));
        //     i++;
        //     temp = temp.next;
        // }

    }

    public void copyFrom(ATList<T> other) {
        this.clear();
        for(int e=0; e<other.size(); e++) this.add(other.get(e));
        // this.removeAll();
        // Node temp = new Node();
        // temp = (Node) atList.start();
        // int i = 1;
        // while (temp != null) {
        //     this.add(atList.getAt(i));
        //     i++;
        //     temp = temp.next;
        // }
    }

    public void appendTo(ATList<T> other) {
        for(int e=0; e<this.size(); e++) other.add(this.get(e));
        // Node temp = new Node();
        // temp = start;
        // while (temp != null) {
        //     atList.add(temp.data);
        //     temp = temp.next;
        // }
    }


    public void appendFrom(ATList<T> other) {
        for(int e=0; e<other.size(); e++) this.add(other.get(e));
        // Node temp = new Node();
        // temp = (Node) atList.start();
        // while (temp != null) {
        //     this.add(temp.data);
        //     temp = temp.next;
        // }
    }
    public void forEach(ATListItemAcceptor<T> a)
    {
        if (a==null) return;
        ATNode<T> t;
        for(t=start; t!=null; t=t.next) a.accept(t.data);
    }

   

}

// class ATLinkedListMain {
//     public static void main(String ami[]) {
//         ATLInkedList<Integer> List1 = new ATLInkedList<>();
//         for (int x = 0; x < 200; x++) {
//             List1.add(x);
//         }
//         // List1.insert(100);
//         // List1.insert(1020);
//         // List1.insert(100131);
//         List1.getAll();
//         List1.getAt(200);
//         List1.removeAt(200);
//         List1.getAt(199);
//         // System.out.println(List1.getAt(2));

//     }
// }
