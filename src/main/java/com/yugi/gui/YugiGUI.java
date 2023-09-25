package com.yugi.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class YugiGUI extends JFrame {

    private JTextArea dataTextArea;
    private JButton fetchDataButton;

    public YugiGUI() {
        setTitle("Yugi Data Viewer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dataTextArea = new JTextArea();
        dataTextArea.setEditable(false);

        fetchDataButton = new JButton("Fetch Data");
        fetchDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchData();
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(dataTextArea), BorderLayout.CENTER);
        getContentPane().add(fetchDataButton, BorderLayout.SOUTH);
    }

    private void fetchData() {
        try {
            // Realiza una solicitud HTTP GET al endpoint y muestra la respuesta en el JTextArea
            URL url = new URL("http://localhost:8080/api/monsters//Blue-Eyes");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            dataTextArea.setText(response.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}