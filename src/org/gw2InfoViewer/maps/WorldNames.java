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
package org.gw2InfoViewer.maps;

import com.google.common.collect.BiMap;

/**
 *
 * @author Robert Smieja
 */
public class WorldNames {

    private BiMap<Integer, String> map;

    public WorldNames(BiMap<Integer, String> nameMap) {
        this.map = nameMap;
    }

    public BiMap<Integer, String> getMap() {
        return map;
    }

    public void setMap(BiMap<Integer, String> map) {
        this.map = map;
    }
}
