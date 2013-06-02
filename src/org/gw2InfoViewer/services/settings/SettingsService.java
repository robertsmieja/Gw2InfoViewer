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
package org.gw2InfoViewer.services.settings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.gw2InfoViewer.models.Options;

/**
 *
 * @author Robert Smieja
 */
public class SettingsService {

    private static final String fileName = "infoviewer.properties";

    public static void SaveSettings(Options options) throws IOException {
        Properties properties = new Properties();

        properties.setProperty("world", options.getWorld().toString());
        properties.setProperty("map", options.getMap().toString());
        properties.setProperty("event", options.getEventId());
        properties.setProperty("match", options.getMatchId().toString());
        properties.setProperty("proxyEnabled", options.isProxyEnabled().toString());
        properties.setProperty("proxyAddress", options.getProxyAddress());
        properties.setProperty("proxyPort", options.getProxyPort().toString());

        properties.store(new FileOutputStream(fileName), null);
    }

    public static Options LoadSettings() throws FileNotFoundException, IOException {

        Properties prop = new Properties();
        Options options = new Options();

        prop.load(new FileInputStream(fileName));

        options.setWorld(Integer.parseInt(prop.getProperty("world")));
        options.setMap(Integer.parseInt(prop.getProperty("map")));
        options.setEventId(prop.getProperty("event"));
        options.setMatchId(Integer.parseInt(prop.getProperty("match")));
        options.setProxyEnabled(Boolean.parseBoolean(prop.getProperty("proxyEnabled")));
        options.setProxyAddress(prop.getProperty("proxyAddress"));
        options.setProxyPort(Integer.parseInt(prop.getProperty("proxyPort")));

        return options;
    }
}
