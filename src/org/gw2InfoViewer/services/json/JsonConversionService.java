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
package org.gw2InfoViewer.services.json;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.gw2InfoViewer.services.json.models.IdNamePair;
import org.gw2InfoViewer.maps.EventNames;
import org.gw2InfoViewer.maps.MapNames;
import org.gw2InfoViewer.maps.WorldNames;
import org.gw2InfoViewer.models.Event;
import org.gw2InfoViewer.models.EventList;
import org.gw2InfoViewer.services.json.typeadaptors.EventAdapter;

/**
 *
 * @author Robert Smieja
 */
public class JsonConversionService {

    private static GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(Event.class, new EventAdapter());
    private Gson gson;
    private JsonParser jsonParser;

    private JsonConversionService() {
        this.gson = gsonBuilder.create();
        this.jsonParser = new JsonParser();
    }

    @Deprecated
    public static EventList parseEventList(String json) {

        EventList eventList = gsonBuilder.create().fromJson(json, EventList.class);

        return eventList;
    }

    public static EventList parseEventList(InputStream json, EventNames eventNames, MapNames mapNames, WorldNames worldNames) throws IOException {
        EventList eventList;

        eventList = parseEventListWithoutNames(json);

        for (Event event : eventList.getEventList()) {
            event.setEventName(eventNames.getMap().get(event.getEventId()));
            event.setMapName(mapNames.getMap().get(event.getMapId()));
            event.setWorldName(worldNames.getMap().get(event.getWorldId()));
        }

        return eventList;
    }

    public static EventList parseEventListWithoutNames(InputStream json) throws IOException {
        List<Event> events;

        events = new ArrayList<Event>();

        JsonReader reader = new JsonReader(new InputStreamReader(json));
        reader.beginObject();
        if (reader.nextName().equals("events")) {
            reader.beginArray();
            while (reader.peek() != JsonToken.END_ARRAY) {
                Event event = gsonBuilder.create().fromJson(reader, Event.class);
                events.add(event);
            }
            reader.endArray();
            reader.endObject();
        }
        return new EventList(events);
    }

    public static EventNames parseEventNames(String json) {
        Map<String, String> nameHashMap;
        JsonArray jsonArray;

        nameHashMap = new HashMap<>();
        jsonArray = new JsonParser().parse(json).getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {
            IdNamePair namePair;
            namePair = gsonBuilder.create().fromJson(jsonArray.get(i), IdNamePair.class);
            nameHashMap.put(namePair.getId(), namePair.getName());
        }
        return new EventNames(nameHashMap);
    }

    public static MapNames parseMapNames(String json) {
        BiMap<Integer, String> nameHashBiMap;
        JsonArray jsonArray;

        nameHashBiMap = HashBiMap.create();
        jsonArray = new JsonParser().parse(json).getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {
            IdNamePair namePair;
            namePair = gsonBuilder.create().fromJson(jsonArray.get(i), IdNamePair.class);
            nameHashBiMap.put(Integer.parseInt(namePair.getId()), namePair.getName());
        }
        return new MapNames(nameHashBiMap);
    }

    public static WorldNames parseWorldNames(String json) {
        BiMap<Integer, String> nameHashBiMap;
        JsonArray jsonArray;

        nameHashBiMap = HashBiMap.create();
        jsonArray = new JsonParser().parse(json).getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {
            IdNamePair namePair;
            namePair = gsonBuilder.create().fromJson(jsonArray.get(i), IdNamePair.class);
            nameHashBiMap.put(Integer.parseInt(namePair.getId()), namePair.getName());
        }
        return new WorldNames(nameHashBiMap);
    }
}
