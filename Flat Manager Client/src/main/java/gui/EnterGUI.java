package gui;

import client.ConnectionStatus;
import client.RequestSender;
import org.apache.commons.codec.digest.DigestUtils;
import resources.ResourceController;
import tools.Message;
import tools.Request;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EnterGUI {
    private JPanel mainPanel;
    private JButton loginButton;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton enterButton;
    private JLabel messageLabel;
    private JPanel enterPanel;
    private JPanel registrationPanel;
    private JPanel messageLabelPanel;
    private JPanel loginFieldPanel;
    private JPanel passwordFieldPanel;
    private JPanel enterButtonPanel;
    private JComboBox languageComboBox;
    private RequestSender requestSender;
    private ResourceController resourceController;
    private String[] languages = {"Russian", "Portuguese", "Albanian", "English (Canada)"};

    public EnterGUI(RequestSender requestSender, ResourceController resourceController) {
        this.requestSender = requestSender;
        this.resourceController = resourceController;
        $$$setupUI$$$();
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
        mainPanel.setLayout(new BorderLayout(0, 0));
        mainPanel.setBackground(new Color(-4473925));
        mainPanel.setEnabled(true);
        mainPanel.setMinimumSize(new Dimension(199, 71));
        mainPanel.setPreferredSize(new Dimension(700, 450));
        registrationPanel = new JPanel();
        registrationPanel.setLayout(new GridBagLayout());
        registrationPanel.setAutoscrolls(false);
        registrationPanel.setBackground(new Color(-13025985));
        registrationPanel.setPreferredSize(new Dimension(700, 100));
        mainPanel.add(registrationPanel, BorderLayout.NORTH);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setBackground(new Color(-13025985));
        panel1.setPreferredSize(new Dimension(300, 55));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        registrationPanel.add(panel1, gbc);
        languageComboBox.setBackground(new Color(-13025985));
        languageComboBox.setForeground(new Color(-1));
        languageComboBox.setOpaque(true);
        languageComboBox.setPreferredSize(new Dimension(150, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 150);
        panel1.add(languageComboBox, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        panel2.setBackground(new Color(-13025985));
        panel2.setPreferredSize(new Dimension(300, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        registrationPanel.add(panel2, gbc);
        loginButton.setActionCommand("");
        loginButton.setAlignmentX(0.5f);
        loginButton.setBackground(new Color(-13025985));
        loginButton.setBorderPainted(true);
        loginButton.setEnabled(true);
        loginButton.setFocusPainted(false);
        loginButton.setFocusable(true);
        Font loginButtonFont = this.$$$getFont$$$("Franklin Gothic Demi", Font.PLAIN, 18, loginButton.getFont());
        if (loginButtonFont != null) loginButton.setFont(loginButtonFont);
        loginButton.setForeground(new Color(-1));
        loginButton.setHideActionText(false);
        loginButton.setHorizontalAlignment(0);
        loginButton.setHorizontalTextPosition(0);
        loginButton.setInheritsPopupMenu(false);
        loginButton.setMaximumSize(new Dimension(180, 30));
        loginButton.setOpaque(true);
        loginButton.setPreferredSize(new Dimension(180, 30));
        loginButton.setRolloverEnabled(true);
        loginButton.setSelected(false);
        loginButton.setText("Регистрация");
        loginButton.setVerifyInputWhenFocusTarget(true);
        loginButton.setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 150, 0, 0);
        panel2.add(loginButton, gbc);
        enterPanel = new JPanel();
        enterPanel.setLayout(new GridBagLayout());
        enterPanel.setAutoscrolls(false);
        enterPanel.setBackground(new Color(-13025985));
        mainPanel.add(enterPanel, BorderLayout.CENTER);
        messageLabelPanel = new JPanel();
        messageLabelPanel.setLayout(new GridBagLayout());
        messageLabelPanel.setBackground(new Color(-13025985));
        messageLabelPanel.setPreferredSize(new Dimension(450, 40));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        enterPanel.add(messageLabelPanel, gbc);
        Font messageLabelFont = this.$$$getFont$$$("Franklin Gothic Demi", Font.PLAIN, 24, messageLabel.getFont());
        if (messageLabelFont != null) messageLabel.setFont(messageLabelFont);
        messageLabel.setForeground(new Color(-1));
        messageLabel.setHorizontalAlignment(0);
        messageLabel.setHorizontalTextPosition(0);
        messageLabel.setPreferredSize(new Dimension(200, 30));
        messageLabel.setText("Авторизация");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.ipadx = 250;
        gbc.ipady = 10;
        messageLabelPanel.add(messageLabel, gbc);
        loginFieldPanel = new JPanel();
        loginFieldPanel.setLayout(new GridBagLayout());
        loginFieldPanel.setBackground(new Color(-13025985));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 0, 0, 0);
        enterPanel.add(loginFieldPanel, gbc);
        loginField = new JTextField();
        loginField.setBackground(new Color(-13025985));
        loginField.setCaretColor(new Color(-1));
        loginField.setDisabledTextColor(new Color(-1));
        loginField.setEditable(true);
        loginField.setEnabled(true);
        loginField.setForeground(new Color(-1));
        loginField.setPreferredSize(new Dimension(180, 30));
        loginField.setRequestFocusEnabled(true);
        loginField.setVisible(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginFieldPanel.add(loginField, gbc);
        passwordFieldPanel = new JPanel();
        passwordFieldPanel.setLayout(new GridBagLayout());
        passwordFieldPanel.setBackground(new Color(-13025985));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(2, 0, 0, 0);
        enterPanel.add(passwordFieldPanel, gbc);
        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(-13025985));
        passwordField.setCaretColor(new Color(-1));
        passwordField.setDisabledTextColor(new Color(-1));
        passwordField.setForeground(new Color(-1));
        passwordField.setPreferredSize(new Dimension(180, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        passwordFieldPanel.add(passwordField, gbc);
        enterButtonPanel = new JPanel();
        enterButtonPanel.setLayout(new GridBagLayout());
        enterButtonPanel.setBackground(new Color(-13025985));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 0, 150, 0);
        enterPanel.add(enterButtonPanel, gbc);
        enterButton.setActionCommand("");
        enterButton.setAlignmentX(0.5f);
        enterButton.setAlignmentY(0.5f);
        enterButton.setAutoscrolls(false);
        enterButton.setBackground(new Color(-13025985));
        enterButton.setBorderPainted(true);
        enterButton.setFocusPainted(false);
        Font enterButtonFont = this.$$$getFont$$$("Franklin Gothic Demi", Font.PLAIN, 18, enterButton.getFont());
        if (enterButtonFont != null) enterButton.setFont(enterButtonFont);
        enterButton.setForeground(new Color(-1));
        enterButton.setPreferredSize(new Dimension(180, 30));
        enterButton.setText("Вход");
        enterButton.putClientProperty("hideActionText", Boolean.FALSE);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        enterButtonPanel.add(enterButton, gbc);
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

    public void drawMessages() {
        messageLabel.setText(resourceController.getMainResourceBundle().getString("Авторизация"));
        enterButton.setText(resourceController.getMainResourceBundle().getString("Вход"));
        loginButton.setText(resourceController.getMainResourceBundle().getString("Регистрация"));
    }

    private void createUIComponents() {
        enterButton = new JButton();
        loginButton = new JButton();
        messageLabel = new JLabel();
        languageComboBox = new JComboBox(languages);
        languageComboBox.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resourceController.setMainResourceBundleByIndex(languageComboBox.getSelectedIndex());
                drawMessages();
            }
        });
        languageComboBox.setSelectedIndex(resourceController.getSelectedLanguage());
        enterButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                char[] passwordChars = passwordField.getPassword();
                if (login.equals("") || String.valueOf(passwordChars).equals("")) {
                    messageLabel.setText(resourceController.getMainResourceBundle().getString("Введите логин и пароль!"));
                } else {
                    loginField.setText("");
                    passwordField.setText("");
                    String password = DigestUtils.sha1Hex(String.valueOf(passwordChars));
                    Request request = new Request("auth", login, password, true, resourceController.getMainResourceBundle().getBaseBundleName());
                    if (requestSender.sendRequest(request)) {
                        getMessage(login, password);
                        ConnectionStatus.setConnectionStatus(true);
                    } else {
                        ConnectionStatus.setConnectionStatus(false);
                        messageLabel.setText(resourceController.getMainResourceBundle().getString("Соединение с сервером разорвано!"));
                    }
                    if (!ConnectionStatus.isConnected()) {
                        if (requestSender.setConnection()) {
                            ConnectionStatus.setConnectionStatus(true);
                            requestSender.sendRequest(request);
                            getMessage(login, password);
                        } else {
                            messageLabel.setText(resourceController.getMainResourceBundle().getString("Ошибка соединения с сервером!"));
                        }
                    }
                }
            }
        });

        loginButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrationPanel.setVisible(false);
                enterPanel.setVisible(false);
                mainPanel.removeAll();
                RegistrationGUI registrationGUI = new RegistrationGUI(requestSender, resourceController);
                registrationGUI.drawMessages();
                mainPanel.add(registrationGUI.$$$getRootComponent$$$());
            }
        });
    }

    private Timer timer;

    private void getMessage(String login, String password) {
        Message message = requestSender.getAnswer();
        if (message != null) {
            messageLabel.setText(message.getMessage());
            if (message.getAuthorizationCondition() == 0) {
                registrationPanel.setVisible(false);
                loginFieldPanel.setVisible(false);
                passwordFieldPanel.setVisible(false);
                enterButtonPanel.setVisible(false);
                timer = new Timer(1000, new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enterPanel.setVisible(false);
                        mainPanel.removeAll();
                        MainGUI mainGUI = new MainGUI(requestSender, login, password, true, resourceController);
                        mainGUI.drawMessages();
                        mainGUI.setUserName();
                        mainPanel.add(mainGUI.$$$getRootComponent$$$());
                        timer.stop();
                    }
                });
                timer.start();
            }
        }
    }
}