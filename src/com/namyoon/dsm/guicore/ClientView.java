package com.namyoon.dsm.guicore;

import com.namyoon.dsm.appcore.Client;
import com.namyoon.dsm.guitemplate.InterfacePanel;
import com.namyoon.dsm.guitemplate.SuperPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Namyoon Kim
 * <p>
 * This class instantiates the client view, which is the main
 * chatting application view. Mainly handles displaying process
 * of the in and out stream of broadcasted messages. When the
 * client sends a message, it gets transferred to the server,
 * then broadcased to other clients on the server.
 * </p>
 */

public class ClientView extends SuperPanel implements InterfacePanel {

    // client reference after instantiated.
    private Client client;

    // GUI components.
    private JButton sendButton;
    private JTextArea chatTextArea;
    private JTextField inputTextField;

    public ClientView() {
        init();
        addComponents();
        addActions();
    }

    @Override
    // initialization.
    public void init() {
        super.init(this, Color.magenta);
    }

    @Override
    // adds GUI components.
    public void addComponents() {
        sendButton = new JButton("Send");
        inputTextField = new JTextField();
        chatTextArea = new JTextArea();
        chatTextArea.setRows(5);
        chatTextArea.setColumns(50);
        chatTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(chatTextArea);
        super.addComponent(this, scrollPane, 0.0125f, 0.02f, 600, 450);
        super.addComponent(this, inputTextField, 0.0125f, 0.77f, 600, 90);
        super.addComponent(this, sendButton, 0.733f, 0.777f, 190, 80);
    }

    @Override
    // adds corresponding actions to each GUI components.
    public void addActions() {
        sendButton.addActionListener((ActionEvent e) -> {
            String message = inputTextField.getText();
            client.sendMessage(message);
        });
    }

    // sets the client object for sending messages to the server.
    public void setClient(Client client) {
        this.client = client;
    }

    // shows client messages.
    public void showMessage(String message) {
        chatTextArea.append(message + "\n");
    }

}
