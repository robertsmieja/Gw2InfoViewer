/*
 *  Gw2InfoViewer - Java Swing based application that reads the Guild Wars 2 JSON API
 *  Copyright (C) 2013 Robert Smieja
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gw2InfoViewer.services.json.typeadaptors;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import org.gw2InfoViewer.models.Event;
import org.gw2InfoViewer.models.EventState;

/**
 *
 * @author Robert Smieja
 */
public class EventAdapter extends TypeAdapter<Event> {

    @Override
    public Event read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }

        Event event = new Event();

        reader.beginObject();
        reader.nextName(); //world id
        event.setWorldId(reader.nextInt());
        reader.nextName(); //map id
        event.setMapId(reader.nextInt());
        reader.nextName(); //event id
        event.setEventId(reader.nextString());
        reader.nextName();
        event.setState(EventState.valueOf(reader.nextString())); //state
        reader.endObject();

        return event;
    }

    @Override
    public void write(JsonWriter writer, Event event) throws IOException {
        if (event == null) {
            writer.nullValue();
            return;
        }

        writer.beginObject();
        writer.name("world_id");
        writer.value(event.getWorldId());
        writer.name("map_id");
        writer.value(event.getMapId());
        writer.name("event_id");
        writer.value(event.getEventId());
        writer.name("state");
        writer.value(event.getState().toString());
        writer.endObject();
    }
}
