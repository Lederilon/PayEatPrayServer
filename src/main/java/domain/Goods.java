package domain;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Contains information about goods
 * @author KostyaHrishenko
 */
public class Goods implements Serializable{
    private String name;
    private LinkedList<Specification> specification;

    /**
     *Create new goods with guven name
     * @param name - goods name
     */
    public Goods(String name) {
        this.name = name;
        specification = new LinkedList<Specification>();
    }

    /**
     *
     * @return String - goods name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name - characteristic name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param spec - goods specification
     */
    public void addSpecification(Specification spec){
        specification.add(spec);
    }
}
