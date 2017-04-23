package domain;

/**
 * Contain information about FeedbackType
 * @author KostyaHrishenko
 */
public class FeedbackType {
    private String name;

    /**
     * Create ne FeedbackType wuth given name
     * @param name - feedbackType name
     */
    public FeedbackType(String name) {
        this.name = name;
    }

    /**
     * Get name of feedback typee
     * @return String - feedback type name
     */
    public String getName() {
        return name;
    }

    /**
     * Change name of feedback type
     * @param name - feedbackType name
     */
    public void setName(String name) {
        this.name = name;
    }
}
