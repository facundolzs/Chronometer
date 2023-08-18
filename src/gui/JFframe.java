package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class JFframe extends javax.swing.JFrame {

    public Clip clip;
    public String url = "/sound/";

    BackgroundPanel background = new BackgroundPanel();

    public JFframe() {

        this.actions = (ActionEvent e) -> {

            hundredths++;

            if (hundredths == 100) {
                seconds++;
                hundredths = 0;
            }

            if (seconds == 60) {
                minutes++;
                seconds = 0;
            }

            if (minutes == 60) {
                hours++;
                minutes = 0;
            }

            if (hours == 24) {
                hours = 0;
            }

            update_lblTime();
        };

        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
        this.setTitle("CRONÓMETRO");
        setResizable(false);
        time = new Timer(10, actions);
    }

    // time variables
    private Timer time;
    private int hundredths = 0;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;

    private ActionListener actions;

    private void update_lblTime() {

        String txt = (hours <= 9 ? "0" : "") + hours + ":" + (minutes <= 9 ? "0" : "") + minutes
                + ":" + (seconds <= 9 ? "0" : "") + seconds + ":" + (hundredths <= 9 ? "0" : "") + hundredths;

        lbl_time.setText(txt);
    }

    public void sound(String archive) {

        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(url + archive + ".wav")));
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new BackgroundPanel();
        btn_start = new javax.swing.JButton();
        btn_pause = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        lbl_time = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_start.setBackground(new java.awt.Color(14, 60, 129));
        btn_start.setFont(new java.awt.Font("MADE TOMMY", 0, 20)); // NOI18N
        btn_start.setForeground(new java.awt.Color(255, 255, 255));
        btn_start.setText("INICIAR");
        btn_start.setBorder(null);
        btn_start.setBorderPainted(false);
        btn_start.setContentAreaFilled(false);
        btn_start.setFocusPainted(false);
        btn_start.setFocusable(false);
        btn_start.setRequestFocusEnabled(false);
        btn_start.setVerifyInputWhenFocusTarget(false);
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });

        btn_pause.setBackground(new java.awt.Color(14, 60, 129));
        btn_pause.setFont(new java.awt.Font("MADE TOMMY", 0, 20)); // NOI18N
        btn_pause.setForeground(new java.awt.Color(255, 255, 255));
        btn_pause.setText("PAUSAR");
        btn_pause.setBorder(null);
        btn_pause.setBorderPainted(false);
        btn_pause.setContentAreaFilled(false);
        btn_pause.setEnabled(false);
        btn_pause.setFocusPainted(false);
        btn_pause.setFocusable(false);
        btn_pause.setVerifyInputWhenFocusTarget(false);
        btn_pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pauseActionPerformed(evt);
            }
        });

        btn_reset.setBackground(new java.awt.Color(14, 60, 129));
        btn_reset.setFont(new java.awt.Font("MADE TOMMY", 0, 20)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("REINICIAR");
        btn_reset.setBorder(null);
        btn_reset.setBorderPainted(false);
        btn_reset.setContentAreaFilled(false);
        btn_reset.setEnabled(false);
        btn_reset.setFocusPainted(false);
        btn_reset.setFocusable(false);
        btn_reset.setRequestFocusEnabled(false);
        btn_reset.setVerifyInputWhenFocusTarget(false);
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        lbl_time.setFont(new java.awt.Font("MADE TOMMY", 0, 42)); // NOI18N
        lbl_time.setForeground(new java.awt.Color(255, 255, 255));
        lbl_time.setText("00:00:00:00");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btn_start, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_pause, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(177, 177, 177))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(lbl_time)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(97, 97, 97)
                .addComponent(lbl_time, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_start, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pause, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        btn_pause.setEnabled(false);
        btn_start.setText("INICIAR");
        btn_reset.setEnabled(false);

        hundredths = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;

        update_lblTime();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pauseActionPerformed
        time.stop();
        btn_pause.setEnabled(false);
        btn_start.setEnabled(true);
        btn_reset.setEnabled(true);
        clip.stop();
    }//GEN-LAST:event_btn_pauseActionPerformed

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        time.start();
        btn_start.setEnabled(false);
        btn_start.setText("REANUDAR");
        btn_pause.setEnabled(true);
        btn_reset.setEnabled(false);

        sound("soundEffect");
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }//GEN-LAST:event_btn_startActionPerformed

    class BackgroundPanel extends JPanel {

        private Image image;

        @Override
        public void paint(Graphics graphics) {
            image = new ImageIcon(getClass().getResource("/img/chronometerBackg.jpg")).getImage();
            graphics.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(graphics);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pause;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_time;
    // End of variables declaration//GEN-END:variables
}
