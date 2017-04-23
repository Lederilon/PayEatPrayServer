package domain;

/**
 * Describes goods specification
 * @author KostyaHrishenko
 */
public class Specification {
    private final int id;
    private int value;
    private Characteristic characteristic;

    /**
     * Create specivication with given characteristic and it's value
     * @param id
     * @param value characteristic value
     */
    public Specification(int id, int value, Characteristic characteristic) {
        this.id = id;
        this.value = value;
        this.characteristic = characteristic;
    }

    /**
     *
     * @return characteristic value
     */
    public int getValue() {
        return value;
    }

    /**
     * Change characteristic value
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     *
     * @return Characteristic - that describes
     */

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    /**
     * Change described characteristic
     * @param characteristic
     */

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    /**
     *
     * @return int - specification id
     */
    public int getId() {
        return id;
    }


}
