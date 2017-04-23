package domain;

import domain.Profile;

import java.util.Date;

/**
 *Contains information about  action produced on offer
 *@author KostyaHrishenko
 *
 */
public class Action {
    private final int id;
    private Date actionDate;
    private Order actionTarget;
    private ActionType type;
    private OrderState state;
    private Profile actor;


    /**
     * Create Action
     * @param id
     * @param actionDate - when action produced
     * @param actionTarget - on what offer  action produced
     * @param type - what type of action produced
     * @param state - what state of order it produced
     * @param actor - profile that create action
     */
    public Action(int id, Date actionDate, Order actionTarget, ActionType type, OrderState state, Profile actor) {
        this.id = id;
        this.actionDate = actionDate;
        this.actionTarget = actionTarget;
        this.type = type;
        this.state = state;
        this.actor = actor;
    }

    public Date getActionDate() {
        return actionDate;
    }

    /**
     * Change action creation date
     * @param actionDate -
     */

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    /**
     *
     * @return actionTarget - on what offer action was prodused
     */
    public Order getActionTarget() {
        return actionTarget;
    }

    /**
     * @param actionTarget
     */

    public void setActionTarget(Order actionTarget) {
        this.actionTarget = actionTarget;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Profile getActor() {
        return actor;
    }

    public void setActor(Profile actor) {
        this.actor = actor;
    }

    public int getId() {
        return id;
    }
}
