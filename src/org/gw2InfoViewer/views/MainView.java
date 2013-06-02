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
package org.gw2InfoViewer.views;

import org.gw2InfoViewer.maps.EventNames;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import org.gw2InfoViewer.controllers.MainController;
import org.gw2InfoViewer.maps.MapNames;
import org.gw2InfoViewer.maps.WorldNames;
import org.gw2InfoViewer.models.Event;
import org.gw2InfoViewer.models.EventList;
import org.gw2InfoViewer.models.Options;

/**
 * Main window
 *
 * @author Robert Smieja
 */
public class MainView extends javax.swing.JFrame {

    private MainController controller;
    private Options options;
    private EventList eventList;
    private EventNames eventNames;
    private WorldNames worldNames;
    private MapNames mapNames;

    /**
     * Creates new form MainView
     */
    public MainView(MainController controller, Options options) {
        /* Set the System look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        initComponents();

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });

        this.controller = controller;
        this.options = options;
    }

    public void setEventList(EventList eventList) {
        DefaultListModel<Event> listModel;

        listModel = new DefaultListModel<Event>();
        for (Event event : eventList.getEventList()) {
            listModel.addElement(event);
        }

        this.eventNameList.setModel(listModel);
        this.eventNameList.setSelectedIndex(0);

        this.eventList = eventList;
    }

    public EventList getEventList() {
        return eventList;
    }

    public void setEventNames(EventNames eventName) {
        this.eventNames = eventName;
    }

    public EventNames getEventNames() {
        return this.eventNames;
    }

    public WorldNames getWorldNames() {
        return worldNames;
    }

    public void setWorldNames(WorldNames worldNames) {
        this.worldNames = worldNames;
    }

    public MapNames getMapNames() {
        return mapNames;
    }

    public void setMapNames(MapNames mapNames) {
        this.mapNames = mapNames;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
        try {
            EventList eventList = MainController.getEventList(this.eventNames, this.mapNames, this.worldNames, this.options);
            this.setEventList(eventList);
        } catch (IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTabPane = new javax.swing.JTabbedPane();
        eventSplitPane = new javax.swing.JSplitPane();
        eventDetailsPanel = new org.gw2InfoViewer.views.events.EventDetailsPanel();
        eventNameListScrollPane = new javax.swing.JScrollPane();
        eventNameList = new javax.swing.JList();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        optionsMenu = new javax.swing.JMenu();
        refreshMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Guild Wars 2 - Info Viewer");
        setIconImages(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        eventSplitPane.setResizeWeight(0.75);
        eventSplitPane.setContinuousLayout(true);
        eventSplitPane.setRightComponent(eventDetailsPanel);

        eventNameListScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        eventNameListScrollPane.setMinimumSize(new java.awt.Dimension(250, 200));
        eventNameListScrollPane.setPreferredSize(new java.awt.Dimension(600, 200));

        eventNameList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Loading..." };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        eventNameList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                eventNameListValueChanged(evt);
            }
        });
        eventNameListScrollPane.setViewportView(eventNameList);

        eventSplitPane.setLeftComponent(eventNameListScrollPane);

        mainTabPane.addTab("Events", eventSplitPane);

        fileMenu.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        mainMenuBar.add(fileMenu);

        editMenu.setText("Edit");
        editMenu.setEnabled(false);
        mainMenuBar.add(editMenu);

        optionsMenu.setText("Options");
        optionsMenu.setFocusable(false);
        optionsMenu.setRequestFocusEnabled(false);
        optionsMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                optionsMenuMouseClicked(evt);
            }
        });
        optionsMenu.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                optionsMenuStateChanged(evt);
            }
        });
        optionsMenu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                optionsMenuItemStateChanged(evt);
            }
        });
        optionsMenu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                optionsMenuFocusGained(evt);
            }
        });
        mainMenuBar.add(optionsMenu);

        refreshMenu.setText("Refresh");
        refreshMenu.setToolTipText("");
        refreshMenu.setFocusable(false);
        refreshMenu.setRequestFocusEnabled(false);
        refreshMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMenuMouseClicked(evt);
            }
        });
        refreshMenu.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                refreshMenuStateChanged(evt);
            }
        });
        mainMenuBar.add(refreshMenu);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 965, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainTabPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMenuMouseClicked
        setEventList(eventList);
        refreshMenu.setSelected(false);
    }//GEN-LAST:event_refreshMenuMouseClicked

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void optionsMenuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_optionsMenuItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_optionsMenuItemStateChanged

    private void optionsMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionsMenuMouseClicked
        //TODO: Open options window
        OptionsForm optionsForm;
        optionsForm = new OptionsForm(this, true, options, worldNames, mapNames);
        optionsForm.setVisible(true);
        optionsMenu.setSelected(false);
    }//GEN-LAST:event_optionsMenuMouseClicked

    private void optionsMenuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_optionsMenuFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_optionsMenuFocusGained

    private void optionsMenuStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_optionsMenuStateChanged
        // TODO add your handling code here:
        optionsMenu.setSelected(false);
    }//GEN-LAST:event_optionsMenuStateChanged

    private void refreshMenuStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_refreshMenuStateChanged
        // TODO add your handling code here:
        refreshMenu.setSelected(false);
    }//GEN-LAST:event_refreshMenuStateChanged

    private void eventNameListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_eventNameListValueChanged
        if (eventNameList.getSelectedIndex() >= 0 && (eventNameList.getSelectedValue() instanceof Event)) {
            Event event = ((Event) eventNameList.getSelectedValue());

            this.eventDetailsPanel.setEvent(event);
        }
    }//GEN-LAST:event_eventNameListValueChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        controller.close(options);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu editMenu;
    private org.gw2InfoViewer.views.events.EventDetailsPanel eventDetailsPanel;
    private javax.swing.JList eventNameList;
    private javax.swing.JScrollPane eventNameListScrollPane;
    private javax.swing.JSplitPane eventSplitPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JTabbedPane mainTabPane;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JMenu refreshMenu;
    // End of variables declaration//GEN-END:variables
}
