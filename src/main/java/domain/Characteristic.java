package domain;
/**
 * Describe goods characteristic
 * @author KostyaHrishenko
 */
public class Characteristic {
    private String name;
    private String comment;
    private String mesurementUnits;
    /**
     * Construct characteristic
     * @param name - characteristic name
     * @param comment - comment to this characteristic
     * @param mesurementUnits -
     */
    public Characteristic(String name, String comment, String mesurementUnits) {
        this.name = name;
        this.comment = comment;
        this.mesurementUnits = mesurementUnits;
    }

    /**
     *
     * @return String - what we use to  describe characteristic
     */
    public String getMesurementUnits() {
        return mesurementUnits;
    }

    /**
     * Change mesurementUnits
     * @param mesurementUnits -
     */
    public void setMesurementUnits(String mesurementUnits) {
        this.mesurementUnits = mesurementUnits;
    }

    /**
     *
     * @return String - characteristic name
     */
    public String getName() {
        return name;
    }

    /**
     * Change characteristic name
     * @param name - characteristic name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return String - characteristic description
     */
    public String getComment() {
        return comment;
    }

    /**
     * Change description
     * @param comment - characteristic descriprion
     */

    public void setComment(String comment) {
        this.comment = comment;
    }
}
