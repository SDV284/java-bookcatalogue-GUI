package com.bookcatalogueGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BookGUI extends JFrame implements ActionListener {
    private Catalogue catalogue;

    private JTextField titleField;
    private JTextField authorField;
    private JTextField publisherField;
    private JTextField genreField;
    private JTextField yearField;
    private JTextArea outputArea;

    private JButton addButton, deleteButton, updateButton, saveButton, loadButton, searchButton, resetButton;

    public BookGUI() {
        catalogue = new Catalogue();
        setTitle("Керування каталогом книг");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Дані про книгу"));

        inputPanel.add(new JLabel("Назва:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Автор:"));
        authorField = new JTextField();
        inputPanel.add(authorField);

        inputPanel.add(new JLabel("Видавництво:"));
        publisherField = new JTextField();
        inputPanel.add(publisherField);

        inputPanel.add(new JLabel("Жанр:"));
        genreField = new JTextField();
        inputPanel.add(genreField);

        inputPanel.add(new JLabel("Рік видання:"));
        yearField = new JTextField();
        inputPanel.add(yearField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        addButton = new JButton("Додати книгу");
        deleteButton = new JButton("Видалити книгу");
        updateButton = new JButton("Оновити книгу");
        saveButton = new JButton("Зберегти у файл");
        loadButton = new JButton("Завантажити з файлу");
        searchButton = new JButton("Пошук");
        resetButton = new JButton("Скинути параметри пошуку");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(resetButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Список публікацій"));

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        scrollPane.setPreferredSize(new Dimension(680, 200));

        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
        searchButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Обробка подій
    }
}