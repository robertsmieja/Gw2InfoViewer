/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gw2InfoViewer.views;

import java.util.Iterator;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.gw2InfoViewer.maps.MapNames;
import org.gw2InfoViewer.maps.WorldNames;
import org.gw2InfoViewer.models.Options;

/**
 *
 * @author Robert Smieja
 */
public class OptionsForm extends javax.swing.JDialog {

    private WorldNames worldNames;
    private MapNames mapNames;

    /**
     * Creates new form OptionsForm
     */
    public OptionsForm(java.awt.Frame parent, boolean modal, Options options, WorldNames worldNames, MapNames mapNames) {
        super(parent, modal);
        setOptions(options, worldNames, mapNames);

        this.worldNames = worldNames;
        this.mapNames = mapNames;

        initComponents();
    }

    public void setOptions(Options options, WorldNames worldNames, MapNames mapNames) {
        DefaultComboBoxModel worldComboBoxModel = new DefaultComboBoxModel();
        DefaultComboBoxModel mapComboBoxModel = new DefaultComboBoxModel();

        for (Iterator<String> it = worldNames.getMap().values().iterator(); it.hasNext();) {
            worldComboBoxModel.addElement(it.next());
        }
        for (Iterator<String> it = mapNames.getMap().values().iterator(); it.hasNext();) {
            mapComboBoxModel.addElement(it.next());
        }

        worldComboBox.setModel(worldComboBoxModel);
        mapComboBox.setModel(mapComboBoxModel);

        worldComboBox.setSelectedItem(worldNames.getMap().get(options.getCurrentWorld()));
        mapComboBox.setSelectedItem(mapNames.getMap().get(options.getCurrentMap()));
        eventIdText.setText(options.getCurrentEventId());
        matchIdText.setText(options.getCurrentMatchId().toString());
        proxyEnabledCheckbox.setSelected(options.isProxyEnabled());
        proxyAddressText.setText(options.getProxyAddress());
        proxyPortText.setText(options.getProxyPort().toString());
    }

    public Options getOptions() {
        Options options = new Options();

        options.setCurrentWorld(worldNames.getMap().inverse().get(worldComboBox.getSelectedItem()));
        options.setCurrentMap(mapNames.getMap().inverse().get(mapComboBox.getSelectedItem()));
        options.setCurrentEventId(eventIdText.getText());
        options.setCurrentMatchId(Integer.parseInt(matchIdText.getText()));
        options.setProxyEnabled(proxyEnabledCheckbox.isSelected());
        options.setProxyAddress(proxyAddressText.getText());
        options.setProxyPort(Integer.parseInt(proxyPortText.getText()));

        return options;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        worldComboBox = new javax.swing.JComboBox();
        proxyEnabledCheckbox = new javax.swing.JCheckBox();
        worldLabel = new javax.swing.JLabel();
        mapLabel = new javax.swing.JLabel();
        eventIdLabel = new javax.swing.JLabel();
        matchId = new javax.swing.JLabel();
        eventIdText = new javax.swing.JTextField();
        proxyAddressLabel = new javax.swing.JLabel();
        proxyPortText = new javax.swing.JTextField();
        proxyLabelAddress = new javax.swing.JLabel();
        proxyAddressText = new javax.swing.JTextField();
        matchIdText = new javax.swing.JTextField();
        mapComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        worldComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Loading..." }));
        worldComboBox.setPreferredSize(new java.awt.Dimension(150, 20));

        proxyEnabledCheckbox.setText("Use a Proxy:");
        proxyEnabledCheckbox.setBorder(null);
        proxyEnabledCheckbox.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        proxyEnabledCheckbox.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        worldLabel.setText("World:");

        mapLabel.setText("Map:");

        eventIdLabel.setText("Event ID:");

        matchId.setText("Match ID:");

        eventIdText.setText("Loading...");
        eventIdText.setPreferredSize(new java.awt.Dimension(200, 20));

        proxyAddressLabel.setText("Address:");

        proxyPortText.setText("Loading...");
        proxyPortText.setEnabled(proxyEnabledCheckbox.isEnabled());
        proxyPortText.setPreferredSize(new java.awt.Dimension(60, 20));

        proxyLabelAddress.setText("Port:");

        proxyAddressText.setText("Loading...");
        proxyAddressText.setEnabled(proxyEnabledCheckbox.isEnabled());
        proxyAddressText.setPreferredSize(new java.awt.Dimension(200, 20));

        matchIdText.setText("Loading...");
        matchIdText.setPreferredSize(new java.awt.Dimension(60, 20));
        matchIdText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchIdTextActionPerformed(evt);
            }
        });

        mapComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Loading..." }));
        mapComboBox.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(worldLabel)
                            .addComponent(mapLabel)
                            .addComponent(eventIdLabel)
                            .addComponent(matchId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(matchIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eventIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mapComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(worldComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(proxyEnabledCheckbox)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(proxyAddressLabel)
                            .addComponent(proxyLabelAddress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(proxyPortText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(proxyAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(worldLabel)
                    .addComponent(worldComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mapLabel)
                    .addComponent(mapComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventIdLabel)
                    .addComponent(eventIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(matchId)
                    .addComponent(matchIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(proxyEnabledCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proxyAddressLabel)
                    .addComponent(proxyAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proxyLabelAddress)
                    .addComponent(proxyPortText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void matchIdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchIdTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matchIdTextActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eventIdLabel;
    private javax.swing.JTextField eventIdText;
    private javax.swing.JComboBox mapComboBox;
    private javax.swing.JLabel mapLabel;
    private javax.swing.JLabel matchId;
    private javax.swing.JTextField matchIdText;
    private javax.swing.JLabel proxyAddressLabel;
    private javax.swing.JTextField proxyAddressText;
    private javax.swing.JCheckBox proxyEnabledCheckbox;
    private javax.swing.JLabel proxyLabelAddress;
    private javax.swing.JTextField proxyPortText;
    private javax.swing.JComboBox worldComboBox;
    private javax.swing.JLabel worldLabel;
    // End of variables declaration//GEN-END:variables
}
