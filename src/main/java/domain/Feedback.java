package domain;

import domain.Profile;

/**
 * Contains information about feedback
 * @author Kostya Hrishenko
 */
public class Feedback {
    private String text;
    private int mark;
    private Profile creator;
    private Profile acceptor;
    private FeedbackType type;

    /**
     * Create ne feedabck
     * @param text - feedback text
     * @param mark - feedback mark
     * @param creator - feedback creator profile
     * @param acceptor - who should accept feedback
     * @param type - feedback type
     */
    public Feedback(String text, int mark, Profile creator, Profile acceptor, FeedbackType type) {
        this.text = text;
        this.mark = mark;
        this.creator = creator;
        this.acceptor = acceptor;
        this.type = type;
    }

    /**
     * Return feedback text
     * @return - String
     */
    public String getText() {
        return text;
    }

    /**
     * change feedback text
     * @param text - feedback text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return int - feedback type
     */
    public int getMark() {
        return mark;
    }

    /**
     * Change feedback mark
     * @param mark - feedback mark
     */
    public void setMark(int mark) {
        this.mark = mark;
    }

    /**
     *
     * @return reference on creator
     */
    public Profile getCreator() {
        return creator;
    }

    /**
     * Change feedback creator
     * @param creator - who creates feedback
     */
    public void setCreator(Profile creator) {
        this.creator = creator;
    }

    /**
     *
     * @return who will accept feedback
     */
    public Profile getAcceptor() {
        return acceptor;
    }

    /**
     * Change feedback acceptor
     * @param acceptor - who will accept feedback
     */
    public void setAcceptor(Profile acceptor) {
        this.acceptor = acceptor;
    }

    /**
     * get reference on feedback type
     * @return - FeedbackType
     */
    public FeedbackType getType() {
        return type;
    }

    /**
     * Change FeedbackType
     * @param type - FeedbackType
     */
    public void setType(FeedbackType type) {
        this.type = type;
    }
}
