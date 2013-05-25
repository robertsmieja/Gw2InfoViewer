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
import java.util.ArrayList;
import java.util.List;
import org.gw2InfoViewer.models.Event;
import org.gw2InfoViewer.models.EventList;

/**
 *
 * @author Robert Smieja
 */
public class EventListAdapter extends TypeAdapter<EventList> {

    @Override
    public EventList read(JsonReader reader) throws IOException {
//        if (reader.peek() == JsonToken.NULL) {
//            reader.nextNull();
//            return null;
//        }
//        
//        if (reader.peek()) == JsonToken.BEGIN_OBJECT){
//        List<Event> events = new ArrayList<Event>();
//        
//        
//        reader.nextName();
//    }
//        
//        String xy = reader.nextString();
//        String[] parts = xy.split(",");
//        int x = Integer.parseInt(parts[0]);
//        int y = Integer.parseInt(parts[1]);
        return new EventList(new ArrayList<Event>());
    }

    @Override
    public void write(JsonWriter writer, EventList value) throws IOException {
        //TODO MAYBE
//        if (value == null) {
//            writer.nullValue();
//            return;
//        }
//        String xy = value.getX() + "," + value.getY();
//        writer.value(xy);
    }
}
