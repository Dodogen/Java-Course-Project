package windows.InformationalWindows;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс, представляющий окно "О программе" с информацией о программе.
 */
public class About extends JFrame {
    
    /**
     * Конструктор класса About, инициализирующий окно "О программе".
     * 
     * @author Barkovets R. S.
     * @version 1.0
     */
    public About() {
        super("О программе");
        setSize(600, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Закрывать только текущее окно
        setLayout(null);
        setLocationRelativeTo(null);
        Font aboutProgramWindowFont_1 = new Font("Times New Roman", Font.BOLD, 14);
        JLabel lblNameOfProgram = new JLabel("Расчет начисления заработной платы за дни отпуска");
        JLabel lblAboutProgramAbility = new JLabel("Программа позволяет:");
        JLabel lblAboutEaseEnteringData = new JLabel("1. Считать отпускные выплаты за рабочий период");
        JLabel lblAboutEaseContainData = new JLabel("2. Создавать персонализированный отчёт для работника");
        JLabel lblAboutEaseUploadData = new JLabel("3. Сохранять отчёт в файл");
        setFont(aboutProgramWindowFont_1);
        lblNameOfProgram.setBounds(200, 30, 350, 20);
        lblAboutProgramAbility.setBounds(200, 70, 500, 20);
        lblAboutEaseEnteringData.setBounds(200, 85, 500, 20);
        lblAboutEaseContainData.setBounds(200, 100, 500, 20);
        lblAboutEaseUploadData.setBounds(200,115,500,20);
        JLabel lblIcon = new JLabel();
        ImageIcon img = new ImageIcon("C:\\Users\\roman\\VSCodeProjects\\VacationPaymentsCalculator\\images\\splash.png");
        lblIcon.setIcon(img);
        lblIcon.setBounds(20, 50, 150, 150);

        JButton btnBack = new JButton("Выход");
        btnBack.setBounds(480, 240, 100, 20);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // При нажатии на "Назад" делаем окно "О программе" невидимым
                setVisible(false);
            }
        });

        add(lblNameOfProgram);
        add(lblAboutProgramAbility);
        add(lblAboutEaseEnteringData);
        add(lblAboutEaseContainData);
        add(lblAboutEaseUploadData);
        add(lblIcon);
        add(btnBack);
    }

    /**
     * Главный метод, запускающий окно "О программе".
     *
     * @param args Параметры командной строки (не используются).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new About().setVisible(true);
            }
        });
    }
}