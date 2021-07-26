package gui;

import client.RequestSender;
import resources.ResourceController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainGUI {

    private JPanel mainPanel;
    private JPanel userPanel;
    private JPanel menuPanel;
    private JLabel userNameLabel;
    private JButton consoleCommandsButton;
    private JButton tableButton;
    private JButton visualizationButton;
    private JComboBox languageComboBox;
    private RequestSender requestSender;
    private String login;
    private String password;
    private boolean isRegistered;
    private String[] languages = {"Russian", "Portuguese", "Albanian", "English (Canada)"};
    private ResourceController resourceController;

    public MainGUI(RequestSender requestSender, String login, String password, boolean isRegistered, ResourceController resourceController) {
        this.requestSender = requestSender;
        this.login = login;
        this.password = password;
        this.isRegistered = isRegistered;
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
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(-13025985));
        mainPanel.setPreferredSize(new Dimension(700, 450));
        userPanel = new JPanel();
        userPanel.setLayout(new GridBagLayout());
        userPanel.setAutoscrolls(false);
        userPanel.setBackground(new Color(-13025985));
        userPanel.setMinimumSize(new Dimension(537, 55));
        userPanel.setPreferredSize(new Dimension(600, 55));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
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
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        menuPanel.setAutoscrolls(false);
        menuPanel.setBackground(new Color(-13025985));
        menuPanel.setMinimumSize(new Dimension(537, 282));
        menuPanel.setPreferredSize(new Dimension(600, 280));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 50, 0);
        mainPanel.add(menuPanel, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        panel2.setBackground(new Color(-13025985));
        panel2.setPreferredSize(new Dimension(300, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 0, 0, 0);
        menuPanel.add(panel2, gbc);
        consoleCommandsButton.setActionCommand("");
        consoleCommandsButton.setAlignmentX(0.5f);
        consoleCommandsButton.setAlignmentY(0.5f);
        consoleCommandsButton.setAutoscrolls(false);
        consoleCommandsButton.setBackground(new Color(-13025985));
        consoleCommandsButton.setBorderPainted(true);
        consoleCommandsButton.setFocusPainted(false);
        Font consoleCommandsButtonFont = this.$$$getFont$$$("Franklin Gothic Demi", Font.PLAIN, 18, consoleCommandsButton.getFont());
        if (consoleCommandsButtonFont != null) consoleCommandsButton.setFont(consoleCommandsButtonFont);
        consoleCommandsButton.setForeground(new Color(-1));
        consoleCommandsButton.setPreferredSize(new Dimension(220, 30));
        consoleCommandsButton.setText("Консольные команды");
        consoleCommandsButton.putClientProperty("hideActionText", Boolean.FALSE);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(consoleCommandsButton, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        panel3.setBackground(new Color(-13025985));
        panel3.setPreferredSize(new Dimension(300, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 0, 0, 0);
        menuPanel.add(panel3, gbc);
        tableButton.setActionCommand("");
        tableButton.setAlignmentX(0.5f);
        tableButton.setAlignmentY(0.5f);
        tableButton.setAutoscrolls(false);
        tableButton.setBackground(new Color(-13025985));
        tableButton.setBorderPainted(true);
        tableButton.setFocusPainted(false);
        Font tableButtonFont = this.$$$getFont$$$("Franklin Gothic Demi", Font.PLAIN, 18, tableButton.getFont());
        if (tableButtonFont != null) tableButton.setFont(tableButtonFont);
        tableButton.setForeground(new Color(-1));
        tableButton.setPreferredSize(new Dimension(220, 30));
        tableButton.setText("Таблица");
        tableButton.putClientProperty("hideActionText", Boolean.FALSE);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(tableButton, gbc);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridBagLayout());
        panel4.setBackground(new Color(-13025985));
        panel4.setPreferredSize(new Dimension(300, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 0, 80, 0);
        menuPanel.add(panel4, gbc);
        visualizationButton.setActionCommand("");
        visualizationButton.setAlignmentX(0.5f);
        visualizationButton.setAlignmentY(0.5f);
        visualizationButton.setAutoscrolls(false);
        visualizationButton.setBackground(new Color(-13025985));
        visualizationButton.setBorderPainted(true);
        visualizationButton.setFocusPainted(false);
        Font visualizationButtonFont = this.$$$getFont$$$("Franklin Gothic Demi", Font.PLAIN, 18, visualizationButton.getFont());
        if (visualizationButtonFont != null) visualizationButton.setFont(visualizationButtonFont);
        visualizationButton.setForeground(new Color(-1));
        visualizationButton.setPreferredSize(new Dimension(220, 30));
        visualizationButton.setText("Визуализация");
        visualizationButton.putClientProperty("hideActionText", Boolean.FALSE);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(visualizationButton, gbc);
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
        consoleCommandsButton.setText(resourceController.getMainResourceBundle().getString("Консольные команды"));
        tableButton.setText(resourceController.getMainResourceBundle().getString("Таблица"));
        visualizationButton.setText(resourceController.getMainResourceBundle().getString("Визуализация"));
    }

    private void createUIComponents() {
        consoleCommandsButton = new JButton();
        tableButton = new JButton();
        visualizationButton = new JButton();

        languageComboBox = new JComboBox(languages);
        languageComboBox.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resourceController.setMainResourceBundleByIndex(languageComboBox.getSelectedIndex());
                drawMessages();
            }
        });
        languageComboBox.setSelectedIndex(resourceController.getSelectedLanguage());

        consoleCommandsButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPanel.setVisible(false);
                menuPanel.setVisible(false);
                mainPanel.removeAll();
                ConsoleCommandsGUI consoleCommandsGUI = new ConsoleCommandsGUI(requestSender, login, password, isRegistered, resourceController);
                consoleCommandsGUI.drawMessages();
                consoleCommandsGUI.setUserName();
                mainPanel.add(consoleCommandsGUI.$$$getRootComponent$$$());
            }
        });

        tableButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPanel.setVisible(false);
                menuPanel.setVisible(false);
                mainPanel.removeAll();
                TableGUI tableGUI = new TableGUI(requestSender, login, password, isRegistered, resourceController);
                tableGUI.drawMessages();
                tableGUI.setUserName();
                mainPanel.add(tableGUI.$$$getRootComponent$$$());
            }
        });

        visualizationButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPanel.setVisible(false);
                menuPanel.setVisible(false);
                mainPanel.removeAll();
                VisualizationGUI visualizationGUI = new VisualizationGUI(requestSender, login, password, isRegistered, resourceController);
                visualizationGUI.drawMessages();
                visualizationGUI.setUserName();
                mainPanel.add(visualizationGUI.$$$getRootComponent$$$());
            }
        });
    }
}
