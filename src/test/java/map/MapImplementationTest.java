package map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MapImplementationTest {

    @Test
    public void test(){
        Map map = new MapImplementation();
        map.put("a", 1);

        assertEquals(map.get("a"), 1);
    }

    @Test
    public void updateValue(){
        Map map = new MapImplementation();
        map.put("a", 1);
        assertEquals(map.get("a"), 1);

        map.put("a", 2);
        assertEquals(map.get("a"), 2);
    }

    @Test
    public void equalTest(){
        Map m = new MapImplementation();
        m.put("a", "b");

        Map m2 = new MapImplementation();
        m2.put("a", "b");

        assertEquals(m, m2);
    }

    @Test
    public void notEqualTest(){
        Map m = new MapImplementation();
        m.put("a", "1");

        Map m2 = new MapImplementation();
        m2.put("a", 1);

        assertNotEquals(m, m2);
    }


    @Test
    public void hashCodeTest(){
        Map m = new MapImplementation();
        m.put("a", "b");

        MapImplementation m2 = new MapImplementation();
        m2.put("a", "b");

        assertAll(
                //test hashcode of certain value only
                () -> assertEquals(m.get("a").hashCode(), m2.get("a").hashCode()),

                // test hashcode of the whole map
                () -> assertEquals(m.hashCode(), m2.hashCode())
        );
    }

}