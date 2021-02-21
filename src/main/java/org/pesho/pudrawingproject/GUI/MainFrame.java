/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pesho.pudrawingproject.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.IconUIResource;

public class MainFrame extends javax.swing.JFrame {
    
    List<Shape> shapes = new ArrayList<>();
    List<Shape> selectedShapes = new ArrayList<>();
    Graphics2D graphics;
    Graphics selectingGraphics;
    private Rectangle2D mouseRec;
    private int mouseX;
    private int mouseY;
    
    public MainFrame() {
        initComponents();
        graphics = (Graphics2D) mainPanel.getGraphics();
        //setButtonsIcons();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        createElipse = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        createElipse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createElipseMouseClicked(evt);
            }
        });

        mainPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mainPanelMouseDragged(evt);
            }
        });
        mainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mainPanelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1001, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );

        jButton1.setText("rect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createElipse, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(createElipse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createElipseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createElipseMouseClicked
        Shape shape = new Ellipse2D.Double(getRandomCoord(900),getRandomCoord(440), 50, 60);
        drawShape(shape);
       
    }//GEN-LAST:event_createElipseMouseClicked

    private int getRandomCoord(int topLimit){
         Random random = new Random();
         return random.nextInt(topLimit);
    }
    
    private void drawShape(Shape shape){
        Graphics2D graphics = (Graphics2D) this.graphics.create();
        shapes.add(shape);
        graphics.draw(shape);
        graphics.dispose();
    }
    
    private void drawShape(Shape shape, Color color){
        Graphics2D graphics = (Graphics2D) this.graphics.create();
        graphics.setColor(color);
        graphics.fill(shape);
        graphics.draw(shape);
        graphics.dispose();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Rectangle rec = new Rectangle(getRandomCoord(900), getRandomCoord(440), 50, 60);
        drawShape(rec);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mainPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPanelMouseReleased
        Graphics2D graphics = (Graphics2D) this.graphics.create();
        graphics.setColor(graphics.getBackground());
        graphics.fill(mouseRec);
        selectedShapes.forEach(shape -> {
            if(shape.intersects(mouseRec)){
                graphics.setColor(Color.red);
                graphics.fill(shape);
            }
        });
    }//GEN-LAST:event_mainPanelMouseReleased

    private void mainPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPanelMousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
        mouseRec = new Rectangle(evt.getPoint());
        selectingGraphics = graphics.create();
    }//GEN-LAST:event_mainPanelMousePressed

    private void mainPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPanelMouseDragged
        int resizeByWidth = Math.abs(mouseX - evt.getX());
        int resizeByHeight = Math.abs(mouseY - evt.getY());
        if(mouseX > evt.getX() && mouseY > evt.getY()){
            drawAndFillRec(selectingGraphics,mouseRec, evt.getX(), evt.getY(), resizeByWidth, resizeByHeight);
        }else if(mouseX > evt.getX() && mouseY < evt.getY()){
            drawAndFillRec(selectingGraphics, mouseRec, evt.getX(), mouseY, resizeByWidth, resizeByHeight);
        }else if (mouseX < evt.getX() && mouseY > evt.getY()){
            drawAndFillRec(selectingGraphics, mouseRec, mouseX, evt.getY(), resizeByWidth, resizeByHeight);
        }else if(mouseX < evt.getX() && mouseY < evt.getY()) {
            drawAndFillRec(selectingGraphics, mouseRec, mouseX, mouseY, resizeByWidth, resizeByHeight);
        }

        if(shapes.get(0).intersects(mouseRec)){
            graphics.setColor(Color.RED);
            graphics.fill(shapes.get(0));
            graphics.draw(shapes.get(0));
        }
        shapes.forEach(shape -> {
            if(shape.intersects(mouseRec) && !selectedShapes.contains(shape)){
                graphics.setColor(Color.RED);
                graphics.fill(shapes.get(0));
                graphics.draw(shapes.get(0));
                selectedShapes.add(shape);
            }
        });
    }//GEN-LAST:event_mainPanelMouseDragged

    private void drawAndFillRec(Graphics graph,Rectangle2D rec, int x, int y, int width, int height){
        rec.setRect(x, y, width, height);
        Color color = new Color(192,192,192,50);
        graph.setColor(color);
        graph.fillRect(x, y, width, height); 
    }
    
    public static void main(String args[]) {
       EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    public void setButtonsIcons(){
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("/RectangleTool.png"));
        createElipse.setIcon(image);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createElipse;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
