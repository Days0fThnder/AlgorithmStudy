package CTCI.animal_Shelter;

import java.util.*;;


/**
 * Created by j_rus on 2/13/2017.
 */
public class Animal_Tracking {

    private LinkedList<Dog> dogs_in = new LinkedList();
    private LinkedList<Cat> cats_in = new LinkedList();
    private  int order = 0;

    public void enqueue(int type, String name, int age){
        if(type <= 0 || type > 2){
            return;
        }

        order++;
        if(type == 1){
            dogs_in.add(new Dog(name, age, order, type ));
        }else if(type == 2){
            cats_in.add(new Cat(name, age, order, type ));
        }
    }

    public  Animal dequeueAny(){
        if(dogs_in.size() == 0 && cats_in.size() == 0){
            return null;
        }

        Cat ct = new Cat();
        Dog dg = new Dog();

        if (dogs_in.size() > 0){
            dg = dogs_in.getFirst();
        }
        if(cats_in.size() > 0){
            ct = cats_in.getFirst();
        }

        return ct.getArrival_num() < dg.getArrival_num() ? cats_in.removeFirst():dogs_in.removeFirst();
    }

    public Dog dequeueDog(){

        if(dogs_in.size() > 0){
            return dogs_in.removeFirst();
        }else{
            return null;
        }
    }

    public Cat dequeueCat(){

        if(cats_in.size() > 0){
            return cats_in.removeFirst();
        }else{
            return null;
        }
    }

    public LinkedList<Dog> getDogs_in() {
        return dogs_in;
    }

    public LinkedList<Cat> getCats_in() {
        return cats_in;
    }

    public static void main(String [] args){

        Animal_Tracking at = new Animal_Tracking();

        at.enqueue(1, "fido", 3);
        at.enqueue(1, "milo", 10);
        at.enqueue(1, "toto", 3);
        at.enqueue(2, "whisker", 2);

        at.getDogs_in();
        at.getCats_in();
        System.out.println(at.dequeueAny().getName());
        System.out.println(at.dequeueCat().getName());
        System.out.println(at.dequeueDog().getName());
    }

}
