package com.pcbuilder.view;

import com.pcbuilder.builder.ComputadoraBuilder;
import com.pcbuilder.model.Computadora;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {

    private JComboBox<String> procesadorBox;
    private JComboBox<String> ramBox;
    private JComboBox<String> discoBox;
    private JComboBox<String> graficaBox;
    private JComboBox<String> soBox;
    private JTextArea resultadoArea;

    private Computadora computadoraActual;

    public MainGUI() {

        setTitle("Sistema PC Builder - Prototype & Builder");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(6, 2));

        procesadorBox = new JComboBox<>(new String[]{"Intel i5", "Intel i7", "Ryzen 5", "Ryzen 7"});
        ramBox = new JComboBox<>(new String[]{"8GB", "16GB", "32GB"});
        discoBox = new JComboBox<>(new String[]{"512GB SSD", "1TB SSD"});
        graficaBox = new JComboBox<>(new String[]{"GTX 1660", "RTX 3060", "RTX 4070"});
        soBox = new JComboBox<>(new String[]{"Windows 11", "Linux", "Sin SO"});

        panel.add(new JLabel("Procesador:"));
        panel.add(procesadorBox);
        panel.add(new JLabel("RAM:"));
        panel.add(ramBox);
        panel.add(new JLabel("Disco:"));
        panel.add(discoBox);
        panel.add(new JLabel("Tarjeta Gráfica:"));
        panel.add(graficaBox);
        panel.add(new JLabel("Sistema Operativo:"));
        panel.add(soBox);

        JButton construirBtn = new JButton("Construir PC");
        JButton clonarBtn = new JButton("Clonar PC");

        panel.add(construirBtn);
        panel.add(clonarBtn);

        add(panel, BorderLayout.NORTH);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        add(new JScrollPane(resultadoArea), BorderLayout.CENTER);

        construirBtn.addActionListener(e -> construirPC());
        clonarBtn.addActionListener(e -> clonarPC());
    }

    private void construirPC() {
        ComputadoraBuilder builder = new ComputadoraBuilder();

        computadoraActual = builder
                .setProcesador((String) procesadorBox.getSelectedItem())
                .setRam((String) ramBox.getSelectedItem())
                .setDisco((String) discoBox.getSelectedItem())
                .setTarjetaGrafica((String) graficaBox.getSelectedItem())
                .setSistemaOperativo((String) soBox.getSelectedItem())
                .build();

        resultadoArea.setText("PC Construida:\n\n" + computadoraActual);
    }

    private void clonarPC() {
        if (computadoraActual != null) {
            Computadora clon = (Computadora) computadoraActual.clone();
            resultadoArea.setText("PC Clonada:\n\n" + clon);
        } else {
            JOptionPane.showMessageDialog(this, "Primero construya una PC.");
        }
    }
}