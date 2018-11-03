package cn.machao.chapter11;

import java.util.*;

public class Chapter11 {
    public static void main(String... args){
        Containers.main(null);
    }
}

class Snow{}
class Powder extends Snow{}
class Light extends Powder{

    public int i = 0;
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
class Heavy extends Powder{}
class Crusty extends Snow{}

class Containers {


    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Powder());
        List<Snow> snow2=Arrays.asList(new Light(),new Heavy());//won't get a compile error after JDK1.8
        System.out.println(snow2);

        //indexOf, removeAll, retainAll, contains.... are all based on equals()
        System.out.println(snow2.indexOf(new Light()));

        // change to sub list will be reflected to origin and vice versa
        List<Integer> i = Arrays.asList(1, 5, 2, 7, 3);
        List<Integer> ii = i.subList(1,3);
        System.out.println(ii);
        java.util.Collections.sort(ii);
        System.out.println(ii);
        System.out.println(i);

        //Iterator
        ArrayList<Integer> iii = new ArrayList<>();
        iii.addAll(Arrays.asList(1,2,3,4,5));
        Iterator<Integer> it = iii.iterator();
        System.out.println(it.next()); //will return last element it pointed.
        it.remove(); //remove() will remove last element returned by next(), not current.
        System.out.println(iii);

        //ListIterator
        ListIterator<Integer> li = iii.listIterator(2);
        while (li.hasNext()) {
            li.next(); // must call next() first
            li.set(10);
        }
        while(li.hasPrevious()) {
            li.previous(); //list iterator is bidirectional.
        }
        System.out.println(iii);


        //LinkedList has methods that directly implement Stack and Queue functionality.
        LinkedList<Integer> ls = new LinkedList<>();
        System.out.println(ls.poll()); //return null, call element() will get an exception, both of them will not change the list.
        ls.addAll(Arrays.asList(1, 3, 5));
        ls.peek();
        System.out.println(ls);
        ls.poll(); //will return null if the list is null, call remove() will get an exception, both of them will change the list.
        System.out.println(ls);
        ls.offer(7);
        System.out.println(ls);
        ls.element();
        System.out.println(ls);
        ls.remove();
        System.out.println(ls);

        //The Set prevents duplication.
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        System.out.println(set);

        //Map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "hello");
        map.put(2, "world");
        for (Map.Entry entry: map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println(map.keySet());
        System.out.println(map.values());
    }
}