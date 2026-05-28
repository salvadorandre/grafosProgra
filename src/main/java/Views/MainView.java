
package Views;
import Controllers.AppController;

public class MainView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainView.class.getName());
    private Controllers.AppController controller = new Controllers.AppController();
    
    
    public MainView() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        airportBtn = new javax.swing.JButton();
        flightBtn = new javax.swing.JButton();
        connectionsBtn = new javax.swing.JButton();
        routeForm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        airportBtn.setText("Crear Aeropuerto");
        airportBtn.addActionListener(this::airportBtnActionPerformed);

        flightBtn.setText("Programar Vuelos");
        flightBtn.addActionListener(this::flightBtnActionPerformed);

        connectionsBtn.setText("Log de Conexiones");
        connectionsBtn.addActionListener(this::connectionsBtnActionPerformed);

        routeForm.setText("Encontrar ruta corta");
        routeForm.addActionListener(this::routeFormActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(airportBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(flightBtn)
                        .addGap(99, 99, 99)
                        .addComponent(connectionsBtn)
                        .addGap(101, 101, 101)
                        .addComponent(routeForm)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airportBtn)
                    .addComponent(flightBtn)
                    .addComponent(connectionsBtn)
                    .addComponent(routeForm))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void airportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airportBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airportBtnActionPerformed

    private void connectionsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectionsBtnActionPerformed

    private void flightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flightBtnActionPerformed

    private void routeFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routeFormActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_routeFormActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton airportBtn;
    private javax.swing.JButton connectionsBtn;
    private javax.swing.JButton flightBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton routeForm;
    // End of variables declaration//GEN-END:variables

    private void refreshGraph() {
    jPanel1.removeAll();
    com.mxgraph.swing.mxGraphComponent graphComp =
        new com.mxgraph.swing.mxGraphComponent(new com.mxgraph.view.mxGraph());
    // ... agregar vértices y aristas desde controller.getAirports()
    jPanel1.setLayout(new java.awt.BorderLayout());
    jPanel1.add(graphComp, java.awt.BorderLayout.CENTER);
    jPanel1.revalidate();
}



}
