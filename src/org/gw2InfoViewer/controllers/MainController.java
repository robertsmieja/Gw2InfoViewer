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
package org.gw2InfoViewer.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.gw2InfoViewer.views.MainView;
import org.gw2InfoViewer.factories.HttpsConnectionFactory;
import org.gw2InfoViewer.models.EventList;
import org.gw2InfoViewer.maps.EventNames;
import org.gw2InfoViewer.maps.MapNames;
import org.gw2InfoViewer.maps.WorldNames;
import org.gw2InfoViewer.models.Options;
import org.gw2InfoViewer.services.json.JsonConversionService;
import org.gw2InfoViewer.services.settings.SettingsService;

/**
 *
 * @author Robert Smieja
 */
public class MainController {

    private static final String API_BASE_URL = "https://api.guildwars2.com/";
    private static final String API_VERSION = "v1/";
    private static final String API_EVENTS = "events.json";
    private static final String API_EVENT_NAMES = "event_names.json";
    private static final String API_MAP_NAMES = "map_names.json";
    private static final String API_WORLD_NAMES = "world_names.json";
    private static final String API_WVW = "wvw/";
    private static final String API_WVW_MATCHES = "matches.json";
    private static final String API_WVW_MATCH_DETAILS = "match_details.json";
    private static final String API_WVW_OBJECTIVE_NAMES = "objective_names.json";
    private static final String API_ITEMS = "items.json";
    private static final String API_ITEM_DETAILS = "item_details.json";
    private static final String API_RECIPES = "recipes.json";
    private static final String API_RECIPE_DETAILS = "recipe_details.json";
    private static final byte[] StartComRootCertificate = {45, 45, 45, 45, 45, 66, 69, 71, 73, 78, 32, 67, 69, 82, 84, 73, 70, 73, 67, 65, 84, 69, 45, 45, 45, 45, 45, 13, 10, 77, 73, 73, 72, 104, 122, 67, 67, 66, 87, 43, 103, 65, 119, 73, 66, 65, 103, 73, 66, 76, 84, 65, 78, 66, 103, 107, 113, 104, 107, 105, 71, 57, 119, 48, 66, 65, 81, 115, 70, 65, 68, 66, 57, 77, 81, 115, 119, 67, 81, 89, 68, 86, 81, 81, 71, 69, 119, 74, 74, 84, 68, 69, 87, 13, 10, 77, 66, 81, 71, 65, 49, 85, 69, 67, 104, 77, 78, 85, 51, 82, 104, 99, 110, 82, 68, 98, 50, 48, 103, 84, 72, 82, 107, 76, 106, 69, 114, 77, 67, 107, 71, 65, 49, 85, 69, 67, 120, 77, 105, 85, 50, 86, 106, 100, 88, 74, 108, 73, 69, 82, 112, 90, 50, 108, 48, 89, 87, 119, 103, 13, 10, 81, 50, 86, 121, 100, 71, 108, 109, 97, 87, 78, 104, 100, 71, 85, 103, 85, 50, 108, 110, 98, 109, 108, 117, 90, 122, 69, 112, 77, 67, 99, 71, 65, 49, 85, 69, 65, 120, 77, 103, 85, 51, 82, 104, 99, 110, 82, 68, 98, 50, 48, 103, 81, 50, 86, 121, 100, 71, 108, 109, 97, 87, 78, 104, 13, 10, 100, 71, 108, 118, 98, 105, 66, 66, 100, 88, 82, 111, 98, 51, 74, 112, 100, 72, 107, 119, 72, 104, 99, 78, 77, 68, 89, 119, 79, 84, 69, 51, 77, 84, 107, 48, 78, 106, 77, 51, 87, 104, 99, 78, 77, 122, 89, 119, 79, 84, 69, 51, 77, 84, 107, 48, 78, 106, 77, 50, 87, 106, 66, 57, 13, 10, 77, 81, 115, 119, 67, 81, 89, 68, 86, 81, 81, 71, 69, 119, 74, 74, 84, 68, 69, 87, 77, 66, 81, 71, 65, 49, 85, 69, 67, 104, 77, 78, 85, 51, 82, 104, 99, 110, 82, 68, 98, 50, 48, 103, 84, 72, 82, 107, 76, 106, 69, 114, 77, 67, 107, 71, 65, 49, 85, 69, 67, 120, 77, 105, 13, 10, 85, 50, 86, 106, 100, 88, 74, 108, 73, 69, 82, 112, 90, 50, 108, 48, 89, 87, 119, 103, 81, 50, 86, 121, 100, 71, 108, 109, 97, 87, 78, 104, 100, 71, 85, 103, 85, 50, 108, 110, 98, 109, 108, 117, 90, 122, 69, 112, 77, 67, 99, 71, 65, 49, 85, 69, 65, 120, 77, 103, 85, 51, 82, 104, 13, 10, 99, 110, 82, 68, 98, 50, 48, 103, 81, 50, 86, 121, 100, 71, 108, 109, 97, 87, 78, 104, 100, 71, 108, 118, 98, 105, 66, 66, 100, 88, 82, 111, 98, 51, 74, 112, 100, 72, 107, 119, 103, 103, 73, 105, 77, 65, 48, 71, 67, 83, 113, 71, 83, 73, 98, 51, 68, 81, 69, 66, 65, 81, 85, 65, 13, 10, 65, 52, 73, 67, 68, 119, 65, 119, 103, 103, 73, 75, 65, 111, 73, 67, 65, 81, 68, 66, 105, 78, 115, 74, 118, 71, 120, 71, 102, 72, 105, 102, 108, 88, 117, 49, 77, 53, 68, 121, 99, 109, 76, 87, 119, 84, 89, 103, 73, 105, 82, 101, 122, 117, 108, 51, 56, 107, 77, 75, 111, 103, 90, 107, 13, 10, 112, 77, 121, 79, 78, 118, 103, 52, 53, 105, 80, 119, 98, 109, 50, 120, 80, 78, 49, 121, 111, 52, 85, 99, 111, 100, 77, 57, 116, 68, 77, 114, 48, 121, 43, 118, 47, 117, 113, 119, 81, 86, 108, 110, 116, 115, 81, 71, 102, 81, 113, 101, 100, 73, 88, 87, 101, 85, 121, 65, 78, 51, 114, 102, 13, 10, 79, 81, 86, 83, 87, 102, 102, 48, 71, 48, 90, 68, 112, 78, 75, 70, 104, 100, 76, 68, 99, 102, 78, 49, 89, 106, 83, 54, 76, 73, 112, 47, 72, 111, 47, 117, 55, 84, 84, 81, 69, 99, 101, 87, 122, 86, 73, 57, 117, 106, 80, 87, 51, 85, 51, 101, 67, 122, 116, 75, 83, 53, 47, 67, 13, 10, 74, 105, 47, 54, 116, 82, 89, 99, 99, 106, 86, 51, 121, 106, 120, 100, 53, 115, 114, 104, 74, 111, 115, 97, 78, 110, 90, 99, 65, 100, 116, 48, 70, 67, 88, 43, 55, 98, 87, 103, 105, 65, 47, 100, 101, 77, 111, 116, 72, 119, 101, 88, 77, 65, 69, 116, 99, 110, 110, 54, 82, 116, 89, 84, 13, 10, 75, 113, 105, 53, 112, 113, 117, 68, 83, 82, 51, 108, 56, 117, 47, 100, 53, 65, 71, 79, 71, 65, 113, 80, 89, 49, 77, 87, 104, 87, 75, 112, 68, 104, 107, 54, 122, 76, 86, 109, 112, 115, 74, 114, 100, 65, 102, 107, 75, 43, 70, 50, 80, 114, 82, 116, 50, 80, 90, 69, 52, 88, 78, 105, 13, 10, 72, 122, 118, 69, 118, 113, 66, 84, 86, 105, 86, 115, 85, 81, 110, 51, 113, 113, 118, 75, 118, 51, 98, 57, 98, 90, 118, 122, 110, 100, 117, 47, 80, 87, 97, 56, 68, 70, 97, 113, 114, 53, 104, 73, 108, 84, 112, 76, 51, 54, 100, 89, 85, 78, 107, 52, 100, 97, 108, 98, 54, 107, 77, 77, 13, 10, 65, 118, 43, 90, 54, 43, 104, 115, 84, 88, 66, 98, 75, 87, 87, 99, 51, 97, 112, 100, 122, 75, 56, 66, 77, 101, 119, 77, 54, 57, 75, 78, 54, 79, 113, 99, 101, 43, 90, 117, 57, 121, 100, 109, 68, 66, 112, 73, 49, 50, 53, 67, 52, 122, 47, 101, 73, 84, 53, 55, 52, 81, 49, 119, 13, 10, 43, 50, 79, 113, 113, 71, 119, 97, 86, 76, 82, 99, 74, 88, 114, 74, 111, 115, 109, 76, 70, 113, 97, 55, 76, 72, 52, 88, 88, 103, 86, 78, 87, 71, 52, 83, 72, 81, 72, 117, 69, 104, 65, 78, 120, 106, 74, 47, 71, 80, 47, 56, 57, 80, 114, 78, 98, 112, 72, 111, 78, 107, 109, 43, 13, 10, 71, 107, 104, 112, 105, 56, 75, 87, 84, 82, 111, 83, 115, 109, 107, 88, 119, 81, 113, 81, 49, 118, 112, 53, 73, 107, 105, 47, 117, 110, 116, 112, 43, 72, 68, 72, 43, 110, 111, 51, 50, 78, 103, 78, 48, 110, 90, 80, 86, 47, 43, 81, 116, 43, 79, 82, 48, 116, 51, 118, 119, 109, 67, 51, 13, 10, 90, 122, 114, 100, 47, 113, 113, 99, 56, 78, 83, 76, 102, 51, 73, 105, 122, 115, 97, 102, 108, 55, 98, 52, 114, 52, 113, 103, 69, 75, 106, 90, 43, 120, 106, 71, 116, 114, 86, 99, 85, 106, 121, 74, 116, 104, 107, 113, 99, 119, 69, 75, 68, 119, 79, 122, 69, 109, 68, 121, 101, 105, 43, 66, 13, 10, 50, 54, 78, 117, 47, 121, 89, 119, 108, 47, 87, 76, 51, 89, 108, 88, 116, 113, 48, 57, 115, 54, 56, 114, 120, 98, 100, 50, 65, 118, 67, 108, 49, 105, 117, 97, 104, 104, 81, 113, 99, 118, 98, 106, 77, 52, 120, 100, 67, 85, 115, 84, 51, 55, 117, 77, 100, 66, 78, 83, 83, 119, 73, 68, 13, 10, 65, 81, 65, 66, 111, 52, 73, 67, 69, 68, 67, 67, 65, 103, 119, 119, 68, 119, 89, 68, 86, 82, 48, 84, 65, 81, 72, 47, 66, 65, 85, 119, 65, 119, 69, 66, 47, 122, 65, 79, 66, 103, 78, 86, 72, 81, 56, 66, 65, 102, 56, 69, 66, 65, 77, 67, 65, 81, 89, 119, 72, 81, 89, 68, 13, 10, 86, 82, 48, 79, 66, 66, 89, 69, 70, 69, 52, 76, 55, 120, 113, 107, 81, 70, 117, 108, 70, 50, 109, 72, 77, 77, 111, 48, 97, 69, 80, 81, 81, 97, 55, 121, 77, 66, 56, 71, 65, 49, 85, 100, 73, 119, 81, 89, 77, 66, 97, 65, 70, 69, 52, 76, 55, 120, 113, 107, 81, 70, 117, 108, 13, 10, 70, 50, 109, 72, 77, 77, 111, 48, 97, 69, 80, 81, 81, 97, 55, 121, 77, 73, 73, 66, 87, 103, 89, 68, 86, 82, 48, 103, 66, 73, 73, 66, 85, 84, 67, 67, 65, 85, 48, 119, 103, 103, 70, 74, 66, 103, 115, 114, 66, 103, 69, 69, 65, 89, 71, 49, 78, 119, 69, 66, 65, 84, 67, 67, 13, 10, 65, 84, 103, 119, 76, 103, 89, 73, 75, 119, 89, 66, 66, 81, 85, 72, 65, 103, 69, 87, 73, 109, 104, 48, 100, 72, 65, 54, 76, 121, 57, 51, 100, 51, 99, 117, 99, 51, 82, 104, 99, 110, 82, 122, 99, 50, 119, 117, 89, 50, 57, 116, 76, 51, 66, 118, 98, 71, 108, 106, 101, 83, 53, 119, 13, 10, 90, 71, 89, 119, 78, 65, 89, 73, 75, 119, 89, 66, 66, 81, 85, 72, 65, 103, 69, 87, 75, 71, 104, 48, 100, 72, 65, 54, 76, 121, 57, 51, 100, 51, 99, 117, 99, 51, 82, 104, 99, 110, 82, 122, 99, 50, 119, 117, 89, 50, 57, 116, 76, 50, 108, 117, 100, 71, 86, 121, 98, 87, 86, 107, 13, 10, 97, 87, 70, 48, 90, 83, 53, 119, 90, 71, 89, 119, 103, 99, 56, 71, 67, 67, 115, 71, 65, 81, 85, 70, 66, 119, 73, 67, 77, 73, 72, 67, 77, 67, 99, 87, 73, 70, 78, 48, 89, 88, 74, 48, 73, 69, 78, 118, 98, 87, 49, 108, 99, 109, 78, 112, 89, 87, 119, 103, 75, 70, 78, 48, 13, 10, 89, 88, 74, 48, 81, 50, 57, 116, 75, 83, 66, 77, 100, 71, 81, 117, 77, 65, 77, 67, 65, 81, 69, 97, 103, 90, 90, 77, 97, 87, 49, 112, 100, 71, 86, 107, 73, 69, 120, 112, 89, 87, 74, 112, 98, 71, 108, 48, 101, 83, 119, 103, 99, 109, 86, 104, 90, 67, 66, 48, 97, 71, 85, 103, 13, 10, 99, 50, 86, 106, 100, 71, 108, 118, 98, 105, 65, 113, 84, 71, 86, 110, 89, 87, 119, 103, 84, 71, 108, 116, 97, 88, 82, 104, 100, 71, 108, 118, 98, 110, 77, 113, 73, 71, 57, 109, 73, 72, 82, 111, 90, 83, 66, 84, 100, 71, 70, 121, 100, 69, 78, 118, 98, 83, 66, 68, 90, 88, 74, 48, 13, 10, 97, 87, 90, 112, 89, 50, 70, 48, 97, 87, 57, 117, 73, 69, 70, 49, 100, 71, 104, 118, 99, 109, 108, 48, 101, 83, 66, 81, 98, 50, 120, 112, 89, 51, 107, 103, 89, 88, 90, 104, 97, 87, 120, 104, 89, 109, 120, 108, 73, 71, 70, 48, 73, 71, 104, 48, 100, 72, 65, 54, 76, 121, 57, 51, 13, 10, 100, 51, 99, 117, 99, 51, 82, 104, 99, 110, 82, 122, 99, 50, 119, 117, 89, 50, 57, 116, 76, 51, 66, 118, 98, 71, 108, 106, 101, 83, 53, 119, 90, 71, 89, 119, 69, 81, 89, 74, 89, 73, 90, 73, 65, 89, 98, 52, 81, 103, 69, 66, 66, 65, 81, 68, 65, 103, 65, 72, 77, 68, 103, 71, 13, 10, 67, 87, 67, 71, 83, 65, 71, 71, 43, 69, 73, 66, 68, 81, 81, 114, 70, 105, 108, 84, 100, 71, 70, 121, 100, 69, 78, 118, 98, 83, 66, 71, 99, 109, 86, 108, 73, 70, 78, 84, 84, 67, 66, 68, 90, 88, 74, 48, 97, 87, 90, 112, 89, 50, 70, 48, 97, 87, 57, 117, 73, 69, 70, 49, 13, 10, 100, 71, 104, 118, 99, 109, 108, 48, 101, 84, 65, 78, 66, 103, 107, 113, 104, 107, 105, 71, 57, 119, 48, 66, 65, 81, 115, 70, 65, 65, 79, 67, 65, 103, 69, 65, 106, 111, 47, 110, 51, 74, 82, 53, 102, 80, 71, 70, 102, 53, 57, 74, 98, 50, 118, 75, 88, 102, 117, 77, 47, 103, 84, 70, 13, 10, 119, 87, 76, 82, 102, 85, 75, 75, 118, 70, 79, 51, 108, 65, 78, 109, 77, 68, 43, 120, 53, 119, 113, 110, 85, 67, 66, 86, 74, 88, 57, 50, 101, 104, 81, 78, 54, 119, 81, 79, 81, 79, 89, 43, 50, 73, 105, 114, 66, 121, 101, 68, 113, 88, 87, 109, 78, 51, 80, 72, 47, 85, 118, 83, 13, 10, 84, 97, 48, 88, 81, 77, 104, 71, 118, 106, 116, 47, 85, 102, 122, 68, 116, 103, 85, 120, 51, 77, 50, 70, 73, 107, 53, 120, 116, 47, 74, 120, 88, 114, 65, 97, 120, 114, 113, 84, 105, 51, 105, 83, 83, 111, 88, 52, 101, 65, 43, 68, 47, 105, 43, 116, 76, 80, 102, 107, 112, 76, 115, 116, 13, 10, 48, 79, 99, 78, 79, 114, 103, 43, 122, 118, 90, 52, 57, 113, 53, 72, 74, 77, 113, 106, 78, 84, 98, 79, 120, 56, 97, 72, 109, 78, 114, 115, 43, 43, 109, 121, 122, 105, 101, 98, 105, 77, 77, 69, 111, 102, 89, 76, 87, 87, 105, 118, 121, 100, 115, 81, 68, 48, 51, 50, 90, 71, 78, 99, 13, 10, 112, 82, 74, 118, 107, 114, 75, 84, 108, 77, 101, 73, 70, 119, 54, 84, 116, 110, 53, 105, 105, 53, 66, 47, 113, 48, 54, 102, 47, 79, 78, 49, 70, 69, 56, 113, 77, 116, 57, 98, 68, 101, 68, 49, 101, 53, 77, 78, 113, 54, 72, 80, 104, 43, 71, 108, 66, 69, 88, 111, 80, 66, 75, 108, 13, 10, 67, 99, 87, 119, 48, 98, 100, 84, 56, 50, 65, 85, 117, 111, 86, 112, 97, 105, 70, 56, 72, 51, 86, 104, 70, 121, 65, 88, 101, 50, 119, 55, 81, 83, 108, 99, 52, 97, 120, 97, 48, 99, 50, 77, 109, 43, 116, 103, 72, 82, 110, 115, 57, 43, 87, 119, 50, 118, 108, 53, 71, 75, 86, 70, 13, 10, 80, 48, 108, 68, 86, 57, 76, 100, 74, 78, 85, 115, 111, 47, 50, 82, 106, 83, 101, 49, 53, 101, 115, 85, 66, 112, 112, 77, 101, 121, 71, 55, 79, 113, 48, 119, 66, 104, 106, 65, 50, 77, 70, 114, 76, 72, 57, 90, 88, 70, 50, 82, 115, 88, 65, 105, 86, 43, 117, 75, 97, 48, 104, 75, 13, 10, 49, 81, 56, 112, 55, 77, 90, 65, 119, 67, 43, 73, 84, 71, 103, 66, 70, 51, 102, 48, 74, 66, 108, 80, 118, 102, 114, 104, 115, 105, 65, 104, 83, 57, 48, 97, 50, 67, 108, 57, 113, 114, 106, 101, 86, 79, 119, 104, 86, 89, 66, 115, 72, 118, 85, 119, 121, 75, 77, 81, 53, 98, 76, 109, 13, 10, 75, 104, 81, 120, 119, 52, 85, 116, 106, 74, 105, 120, 104, 108, 112, 80, 105, 86, 107, 116, 117, 99, 102, 51, 72, 77, 105, 75, 102, 56, 67, 100, 66, 85, 114, 109, 81, 107, 57, 105, 111, 50, 48, 112, 112, 66, 43, 70, 113, 57, 118, 108, 103, 99, 105, 116, 75, 106, 49, 77, 88, 86, 117, 69, 13, 10, 74, 110, 72, 69, 104, 86, 53, 120, 74, 77, 113, 108, 71, 50, 122, 89, 89, 100, 77, 97, 52, 70, 84, 98, 122, 114, 113, 112, 77, 114, 85, 105, 57, 110, 78, 66, 67, 86, 50, 52, 70, 49, 48, 79, 68, 53, 109, 81, 49, 107, 102, 97, 98, 119, 111, 54, 89, 105, 103, 85, 90, 52, 76, 90, 13, 10, 56, 100, 67, 65, 87, 90, 118, 76, 77, 100, 105, 98, 68, 52, 120, 51, 84, 114, 86, 111, 105, 118, 74, 115, 57, 105, 81, 79, 76, 87, 120, 119, 120, 88, 80, 82, 51, 104, 84, 81, 99, 89, 43, 50, 48, 51, 115, 67, 57, 117, 79, 52, 49, 65, 108, 117, 97, 53, 53, 49, 104, 68, 110, 109, 13, 10, 102, 121, 87, 108, 56, 107, 103, 65, 119, 75, 81, 66, 50, 106, 56, 61, 13, 10, 45, 45, 45, 45, 45, 69, 78, 68, 32, 67, 69, 82, 84, 73, 70, 73, 67, 65, 84, 69, 45, 45, 45, 45, 45, 13, 10};
    private static MainController instance;
    private static MainView view;

    private MainController() {
        EventList eventList;
        EventNames eventNames;
        WorldNames worldNames;
        MapNames mapNames;
        Options options = null;
        
        try {
            options = SettingsService.LoadSettings();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Error loading settings!");
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (options == null) {
            System.out.println("Settings not found, using defaults.");
            options = new Options();
        }

        view = new MainView(this, options);
        try {
            eventNames = getEventNames(options);
            mapNames = getMapNames(options);
            worldNames = getWorldNames(options);

            eventList = getEventList(eventNames, mapNames, worldNames, options);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        view.setEventList(eventList);
        view.setEventNames(eventNames);
        view.setWorldNames(worldNames);
        view.setMapNames(mapNames);
    }

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }

        return instance;
    }

    public static EventList getEventList(EventNames eventNames, MapNames mapNames, WorldNames worldNames, Options options) throws IOException {
        String eventsUrl = API_BASE_URL + API_VERSION + API_EVENTS;
        eventsUrl += "?world_id=" + options.getWorld();
        eventsUrl += "&map_id=" + options.getMap();
        eventsUrl += "&event_id=" + options.getEventId();

        EventList eventList;
        HttpClient httpClient;
        HttpGet getEvents;

        getEvents = new HttpGet(eventsUrl);

        if (options.isProxyEnabled()) {
            httpClient = HttpsConnectionFactory.getHttpsClientWithProxy(StartComRootCertificate, options.getProxyAddress(), options.getProxyPort());
        } else {
            httpClient = HttpsConnectionFactory.getHttpsClient(StartComRootCertificate);
        }
        
        InputStream json = httpClient.execute(getEvents).getEntity().getContent();
        eventList = JsonConversionService.parseEventList(json, eventNames, mapNames, worldNames);
        httpClient.getConnectionManager().shutdown();

        Collections.sort(eventList.getEventList());
        
        return eventList;
    }

    public static EventList getEventListWithoutNames(Options options) throws IOException {
        String eventsUrl = API_BASE_URL + API_VERSION + API_EVENTS;
        eventsUrl += "?world_id=" + options.getWorld();
        eventsUrl += "&map_id=" + options.getMap();
        eventsUrl += "&event_id=" + options.getEventId();

        EventList eventList;
        HttpClient httpClient;
        HttpGet getEvents;

        getEvents = new HttpGet(eventsUrl);

        if (options.isProxyEnabled()) {
            httpClient = HttpsConnectionFactory.getHttpsClientWithProxy(StartComRootCertificate, options.getProxyAddress(), options.getProxyPort());
        } else {
            httpClient = HttpsConnectionFactory.getHttpsClient(StartComRootCertificate);
        }
        eventList = JsonConversionService.parseEventListWithoutNames(httpClient.execute(getEvents).getEntity().getContent());
        httpClient.getConnectionManager().shutdown();

        return eventList;
    }

    public static EventNames getEventNames(Options options) throws IOException {
        String eventNamesUrl = API_BASE_URL + API_VERSION + API_EVENT_NAMES;
        EventNames eventNames;
        HttpClient httpClient;
        HttpGet getEventNames;
        String eventNamesJson;

        getEventNames = new HttpGet(eventNamesUrl);

        if (options.isProxyEnabled()) {
            httpClient = HttpsConnectionFactory.getHttpsClientWithProxy(StartComRootCertificate, options.getProxyAddress(), options.getProxyPort());
        } else {
            httpClient = HttpsConnectionFactory.getHttpsClient(StartComRootCertificate);
        }
        eventNamesJson = HttpsConnectionFactory.getStringFromHttpResponse(httpClient.execute(getEventNames));
        eventNames = JsonConversionService.parseEventNames(eventNamesJson);
        httpClient.getConnectionManager().shutdown();
        return eventNames;
    }

    public static WorldNames getWorldNames(Options options) throws IOException {
        String eventNamesUrl = API_BASE_URL + API_VERSION + API_WORLD_NAMES;
        WorldNames worldNames;
        HttpClient httpClient;
        HttpGet getWorldNames;
        String worldNamesJson;

        getWorldNames = new HttpGet(eventNamesUrl);

        if (options.isProxyEnabled()) {
            httpClient = HttpsConnectionFactory.getHttpsClientWithProxy(StartComRootCertificate, options.getProxyAddress(), options.getProxyPort());
        } else {
            httpClient = HttpsConnectionFactory.getHttpsClient(StartComRootCertificate);
        }
        worldNamesJson = HttpsConnectionFactory.getStringFromHttpResponse(httpClient.execute(getWorldNames));
        worldNames = JsonConversionService.parseWorldNames(worldNamesJson);
        httpClient.getConnectionManager().shutdown();
        return worldNames;
    }

    public static MapNames getMapNames(Options options) throws IOException {
        String eventNamesUrl = API_BASE_URL + API_VERSION + API_MAP_NAMES;
        MapNames mapNames;
        HttpClient httpClient;
        HttpGet getMapNames;
        String mapNamesJson;

        getMapNames = new HttpGet(eventNamesUrl);

        if (options.isProxyEnabled()) {
            httpClient = HttpsConnectionFactory.getHttpsClientWithProxy(StartComRootCertificate, options.getProxyAddress(), options.getProxyPort());
        } else {
            httpClient = HttpsConnectionFactory.getHttpsClient(StartComRootCertificate);
        }
        mapNamesJson = HttpsConnectionFactory.getStringFromHttpResponse(httpClient.execute(getMapNames));
        mapNames = JsonConversionService.parseMapNames(mapNamesJson);
        httpClient.getConnectionManager().shutdown();       
        return mapNames;
    }

    public void close(Options options) {
        try {
            SettingsService.SaveSettings(options);
        } catch (IOException ex) {
            System.out.println("Error saving settings!");
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
