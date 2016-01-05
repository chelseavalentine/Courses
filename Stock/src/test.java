import data_structures.LinkedList;

/**
 * Created by chelsea on 1/4/16.
 */
public class test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Before");
        System.out.println(list);
        System.out.println("After");
        System.out.println(list.get(1));
        System.out.println(list);
    }


}
