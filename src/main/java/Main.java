import map.Map;
import map.MapImplementation;

public class Main {

    public static void main(String[] args){

        //Sample usage of Map, you can also check the unit test
        Map m = new MapImplementation();
        m.put("a", "a"); // add object to map since this is a unique key
        System.out.println(m.get("a"));

        m.put("a", 1); // update value of existing key
        System.out.println(m.get("a"));
        System.out.println("----------------------\n");

        // check hashCode and if equal
        Map m2 = new MapImplementation();
        m2.put("a", 1);
        System.out.println("m:\n" + m);
        System.out.println("m2:\n" + m2);
        System.out.println("Is m and m2 are equal? " + m.equals(m2));
        System.out.println("Is m and m2 have same hashCode? " + (m.hashCode() == m2.hashCode()) + "\n");

        m2.put("a", 2);
        System.out.println("m:\n" + m);
        System.out.println("m2:\n" + m2);
        System.out.println("Is m and m2 still equal? " + m.equals(m2));
        System.out.println("Is m and m2 still have same hashCode? " + (m.hashCode() == m2.hashCode()));
        System.out.println("----------------------\n");

        // forEach only usable in MapImplementation
        MapImplementation map = new MapImplementation();
        map.put("e", 5);
        map.put("c", 3);
        map.put("b", 2);
        map.put("d", 4);

        map.forEach(
                unit -> System.out.println(unit.getKey())
        );
    }

}
