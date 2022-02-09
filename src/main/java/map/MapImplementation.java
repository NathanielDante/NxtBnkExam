package map;

import java.util.*;
import java.util.function.Consumer;

/**
 * My self implementation of Map
 */
public class MapImplementation implements Map{

    private final List<Unit> unitList = new ArrayList<>();

    /**
     * This is set to public so that forEach is usable otherwise this can be set to private.
     * This is immutable, you can only set a value here when creating a new Unit so there
     * should be no problem even if this is public
     */
    public record Unit(String key, Object value) {
        public String getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
    }

    /**
     * Add object to the map with a pair of key and value.
     * If the key is already existing, update the value instead
     *
     * @param key identifier of map
     * @param value value of map
     */
    @Override
    public void put(String key, Object value) {
        Unit unit = new Unit(key, value);
        int index = checkKeyIfExisting(key);
        if(index > -1){
            unitList.set(index, unit);
        } else {
            unitList.add(unit);
            sort();
        }
    }

    /**
     * get object from the map using the key
     *
     * @param key identifier of map
     * @return value if existing, else null
     */
    @Override
    public Object get(String key) {
        return unitList.stream()
                .filter(unit -> unit.getKey().equalsIgnoreCase(key))
                .findAny()
                .map(Unit::getValue)
                .orElse(null);
    }

    /**
     *
     * @return hashcode of unitList instead of this class so that we will be able to
     * check using equals() if two Maps is the same if they have the same values
     */
    @Override
    public int hashCode() {
        return unitList.hashCode();
    }

    /**
     *
     * @param obj Object to check for equality
     * @return False if different class.
     *  True if the same object or same unitList
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof MapImplementation m))
            return false;

        return (unitList.isEmpty() && m.unitList.isEmpty())
                || (unitList.equals(m.unitList));
    }

    /**
     * Same implementation of forEach in ArrayList and change its data type to Unit
     * since that will be its only data type
     * @param action action to be done
     */
    public void forEach(Consumer<Unit> action){
        Objects.requireNonNull(action);
        for (Unit u : unitList) {
            action.accept(u);
        }
    }

    /**
     * To print all the key and value in map instead of using the toString() method of Object class
     * @return pairs of key and value in String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Unit u : unitList) {
            sb.append("key: ").append(u.getKey())
                    .append(" value: ").append(u.getValue()).append("\n");
        }
        return sb.toString();
    }

    private int checkKeyIfExisting(String key){
        for (int i = 0; i < unitList.size(); i++){
            if(unitList.get(i).getKey().equalsIgnoreCase(key)){
                return i;
            }
        }

        return -1;
    }

    private void sort(){
        unitList.sort(Comparator.comparing(o -> o.key));
    }
}
