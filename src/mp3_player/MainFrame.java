package mp3_player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MainFrame extends javax.swing.JFrame
{

    long total_length;
    long pouse;
    FileInputStream FIS;
    BufferedInputStream BIS;
    Player player;

    File myFile = null;

    public MainFrame()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        lbl = new javax.swing.JLabel();
        btn_play = new javax.swing.JButton();
        btn_pause = new javax.swing.JButton();
        btn_resume = new javax.swing.JButton();
        btn_stop = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        lbl.setBackground(new java.awt.Color(204, 255, 204));
        lbl.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        lbl.setForeground(new java.awt.Color(255, 0, 0));
        lbl.setText("                         Group Study Mp3 Player");

        btn_play.setText("Play");
        btn_play.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                btn_playMouseReleased(evt);
            }
        });

        btn_pause.setText("Pause");
        btn_pause.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                btn_pauseMouseReleased(evt);
            }
        });

        btn_resume.setText("Resume");
        btn_resume.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                btn_resumeMouseReleased(evt);
            }
        });

        btn_stop.setText("Stop");
        btn_stop.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                btn_stopMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_play)
                .addGap(18, 18, 18)
                .addComponent(btn_pause)
                .addGap(18, 18, 18)
                .addComponent(btn_resume)
                .addGap(18, 18, 18)
                .addComponent(btn_stop)
                .addGap(133, 133, 133))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_stop)
                    .addComponent(btn_resume)
                    .addComponent(btn_pause)
                    .addComponent(btn_play))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_playMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_playMouseReleased
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int val = chooser.showOpenDialog(null);

        if (val == JFileChooser.APPROVE_OPTION)
        {
            myFile = chooser.getSelectedFile();
            String song = myFile + "";

            String name = chooser.getSelectedFile().getName();
            lbl.setText(name);
        }
        try
        {
            try
            {
                FIS = new FileInputStream(myFile);
            }
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            try
            {
                total_length = FIS.available();
            }
            catch (IOException ex)
            {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            new Thread()
            {
                @Override
                public void run()
                {
                    try
                    {
                        player.play();
                    }
                    catch (JavaLayerException ex)
                    {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
        catch (JavaLayerException ex)
        {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_playMouseReleased

    private void btn_pauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pauseMouseReleased
        // TODO add your handling code here:
        if (player != null)
        {
            try
            {
                pouse = FIS.available();
                player.close();
            }
            catch (IOException ex)
            {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_pauseMouseReleased

    private void btn_resumeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resumeMouseReleased
        // TODO add your handling code here:
        try
        {
            FIS = new FileInputStream(myFile);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            FIS.skip(total_length - pouse);
            new Thread()
            {
                @Override
                public void run()
                {
                    try
                    {
                        player.play();
                    }
                    catch (JavaLayerException ex)
                    {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        }
        catch (IOException ex)
        {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (JavaLayerException ex)
        {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_resumeMouseReleased

    private void btn_stopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stopMouseReleased
        // TODO add your handling code here:
        if(player!=null){
            player.close();
            lbl.setText(null);
        }
    }//GEN-LAST:event_btn_stopMouseReleased

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new MainFrame().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pause;
    private javax.swing.JButton btn_play;
    private javax.swing.JButton btn_resume;
    private javax.swing.JButton btn_stop;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl;
    // End of variables declaration//GEN-END:variables
}
