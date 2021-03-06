package gui;

import client.ConnectionStatus;
import client.RequestSender;
import client.UserAction;
import resources.ResourceController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConsoleCommandsGUI {
    private JTextField commandField;
    private JPanel commandFieldPanel;
    private JPanel messagePanePanel;
    private JPanel mainPanel;
    private JPanel userPanel;
    private JLabel userNameLabel;
    private JButton backButton;
    private JTextPane messagePane;
    private JScrollPane scrollPane;
    private JPanel backButtonPanel;
    private JComboBox languageComboBox;
    private RequestSender requestSender;
    private String login;
    private String password;
    private boolean isRegistered;
    private String[] languages = {"Russian", "Portuguese", "Albanian", "English (Canada)"};
    private ResourceController resourceController;

    public ConsoleCommandsGUI(RequestSender requestSender, String login, String password, boolean isRegistered, ResourceController resourceController) {
        this.requestSender = requestSender;
        this.login = login;
        this.password = password;
        this.isRegistered = isRegistered;
        this.resourceController = resourceController;
        $$$setupUI$$$();
    }

    public void setMessage(String message) {
        messagePane.setText(message);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setAutoscrolls(false);
        mainPanel.setBackground(new Color(-13025985));
        mainPanel.setPreferredSize(new Dimension(700, 450));
        messagePanePanel = new JPanel();
        messagePanePanel.setLayout(new GridBagLayout());
        messagePanePanel.setBackground(new Color(-13025985));
        messagePanePanel.setEnabled(true);
        messagePanePanel.setForeground(new Color(-4473925));
        messagePanePanel.setPreferredSize(new Dimension(600, 200));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(messagePanePanel, gbc);
        scrollPane.setBackground(new Color(-13025985));
        scrollPane.setForeground(new Color(-1));
        scrollPane.setOpaque(true);
        scrollPane.setPreferredSize(new Dimension(600, 200));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        messagePanePanel.add(scrollPane, gbc);
        messagePane.setBackground(new Color(-13025985));
        messagePane.setCaretColor(new Color(-1));
        messagePane.setDisabledTextColor(new Color(-1));
        messagePane.setEditable(false);
        Font messagePaneFont = this.$$$getFont$$$("Franklin Gothic Demi Cond", Font.PLAIN, 14, messagePane.getFont());
        if (messagePaneFont != null) messagePane.setFont(messagePaneFont);
        messagePane.setForeground(new Color(-1));
        messagePane.setOpaque(false);
        messagePane.setPreferredSize(new Dimension(600, 200));
        scrollPane.setViewportView(messagePane);
        commandFieldPanel = new JPanel();
        commandFieldPanel.setLayout(new GridBagLayout());
        commandFieldPanel.setBackground(new Color(-13025985));
        commandFieldPanel.setEnabled(true);
        commandFieldPanel.setPreferredSize(new Dimension(500, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 10, 0);
        mainPanel.add(commandFieldPanel, gbc);
        commandField.setBackground(new Color(-13025985));
        commandField.setCaretColor(new Color(-1));
        commandField.setDisabledTextColor(new Color(-1));
        commandField.setEditable(true);
        commandField.setForeground(new Color(-1));
        commandField.setMargin(new Insets(2, 6, 2, 6));
        commandField.setPreferredSize(new Dimension(350, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        commandFieldPanel.add(commandField, gbc);
        userPanel = new JPanel();
        userPanel.setLayout(new GridBagLayout());
        userPanel.setAutoscrolls(false);
        userPanel.setBackground(new Color(-13025985));
        userPanel.setMinimumSize(new Dimension(537, 55));
        userPanel.setPreferredSize(new Dimension(600, 55));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 0);
        mainPanel.add(userPanel, gbc);
        userNameLabel = new JLabel();
        userNameLabel.setDoubleBuffered(false);
        userNameLabel.setEnabled(true);
        Font userNameLabelFont = this.$$$getFont$$$("Franklin Gothic Demi", Font.PLAIN, 24, userNameLabel.getFont());
        if (userNameLabelFont != null) userNameLabel.setFont(userNameLabelFont);
        userNameLabel.setForeground(new Color(-1));
        userNameLabel.setHorizontalAlignment(4);
        userNameLabel.setHorizontalTextPosition(0);
        userNameLabel.setMaximumSize(new Dimension(537, 28));
        userNameLabel.setMinimumSize(new Dimension(537, 55));
        userNameLabel.setPreferredSize(new Dimension(300, 55));
        userNameLabel.setRequestFocusEnabled(true);
        userNameLabel.setText("Name");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        userPanel.add(userNameLabel, gbc);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setBackground(new Color(-13025985));
        panel1.setPreferredSize(new Dimension(300, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        userPanel.add(panel1, gbc);
        languageComboBox.setBackground(new Color(-13025985));
        languageComboBox.setForeground(new Color(-1));
        languageComboBox.setOpaque(true);
        languageComboBox.setPreferredSize(new Dimension(150, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 150);
        panel1.add(languageComboBox, gbc);
        backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new GridBagLayout());
        backButtonPanel.setBackground(new Color(-13025985));
        backButtonPanel.setPreferredSize(new Dimension(400, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(20, 0, 20, 0);
        mainPanel.add(backButtonPanel, gbc);
        backButton.setActionCommand("");
        backButton.setAlignmentX(0.5f);
        backButton.setAlignmentY(0.5f);
        backButton.setAutoscrolls(false);
        backButton.setBackground(new Color(-13025985));
        backButton.setBorderPainted(true);
        backButton.setFocusPainted(false);
        Font backButtonFont = this.$$$getFont$$$("Franklin Gothic Demi", Font.PLAIN, 18, backButton.getFont());
        if (backButtonFont != null) backButton.setFont(backButtonFont);
        backButton.setForeground(new Color(-1));
        backButton.setPreferredSize(new Dimension(180, 30));
        backButton.setText("??????????");
        backButton.putClientProperty("hideActionText", Boolean.FALSE);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        backButtonPanel.add(backButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

    public void setUserName() {
        userNameLabel.setText(login);
    }

    public void drawMessages() {
        backButton.setText(resourceController.getMainResourceBundle().getString("??????????"));
    }

    private void createUIComponents() {
        commandField = new JTextField();
        messagePane = new JTextPane();
        backButton = new JButton();
        scrollPane = new JScrollPane(messagePane);
        scrollPane.getViewport().setBackground(new Color(-13025985));

        languageComboBox = new JComboBox(languages);
        languageComboBox.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resourceController.setMainResourceBundleByIndex(languageComboBox.getSelectedIndex());
                drawMessages();
            }
        });
        languageComboBox.setSelectedIndex(resourceController.getSelectedLanguage());

        commandField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String[] userCommandPart = commandField.getText().toLowerCase().trim().split(" ", 2);
                    if (userCommandPart[0].equals("insert")) {
                        try {
                            if (userCommandPart[1] != null) {
                                messagePanePanel.setVisible(false);
                                commandFieldPanel.setVisible(false);
                                mainPanel.removeAll();
                                AskFlatGUI askFlatGUI = new AskFlatGUI(requestSender, login, password, isRegistered, true, Integer.parseInt(userCommandPart[1]), 0, resourceController);
                                askFlatGUI.drawMessages();
                                mainPanel.add(askFlatGUI.$$$getRootComponent$$$());
                            }
                        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e1) {
                            messagePane.setText(resourceController.getMainResourceBundle().getString("???????????????? ???????????? ??????????????????!"));
                            commandField.setText("");
                        }
                    } else if (userCommandPart[0].equals("update")) {
                        try {
                            if (userCommandPart[1] != null) {
                                messagePanePanel.setVisible(false);
                                commandFieldPanel.setVisible(false);
                                mainPanel.removeAll();
                                AskFlatGUI askFlatGUI = new AskFlatGUI(requestSender, login, password, isRegistered, false, Integer.parseInt(userCommandPart[1]), 0, resourceController);
                                askFlatGUI.drawMessages();
                                mainPanel.add(askFlatGUI.$$$getRootComponent$$$());
                            }
                        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e1) {
                            messagePane.setText(resourceController.getMainResourceBundle().getString("???????????????? ???????????? ??????????????????!"));
                            commandField.setText("");
                        }
                    } else {
                        messagePane.setText("");
                        String message;
                        message = UserAction.consoleMoves(commandField.getText(), requestSender, login, password, isRegistered, resourceController);
                        if (!ConnectionStatus.isConnected()) {
                            if (requestSender.setConnection()) {
                                message = UserAction.consoleMoves(commandField.getText(), requestSender, login, password, isRegistered, resourceController);
                            } else {
                                messagePane.setText(resourceController.getMainResourceBundle().getString("???????????? ???????????????????? ?? ????????????????!"));
                            }
                        }
                        commandField.setText("");
                        messagePane.setText(message);
                    }
                }
            }
        });
        backButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPanel.setVisible(false);
                messagePanePanel.setVisible(false);
                commandFieldPanel.setVisible(false);
                backButtonPanel.setVisible(false);
                mainPanel.removeAll();
                MainGUI mainGUI = new MainGUI(requestSender, login, password, isRegistered, resourceController);
                mainGUI.drawMessages();
                mainGUI.setUserName();
                mainPanel.add(mainGUI.$$$getRootComponent$$$());
            }
        });
    }
}
