/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gw2apitest;


enum eventState {
    ACTIVE, SUCCESS, FAIL, WARMUP, PREPERATION;
}
/**
 *
 * @author Robert Smieja
 */
public class Event {
    private Integer worldId;
    private Integer mapId;
    private String  eventId;
    private eventState state;
}
