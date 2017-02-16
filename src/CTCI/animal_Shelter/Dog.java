package CTCI.animal_Shelter;

/**
 * Created by j_rus on 2/13/2017.
 */
public class Dog extends Animal {


    public Dog(){

    }

    public Dog(String name, int age, int arrival_num, int type){
        this.setName(name);
        this.setAge(age);
        this.setArrival_num(arrival_num);
        this.setType(type);
    }



}
