package org.gw2InfoViewer.models;

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
