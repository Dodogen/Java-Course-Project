package windows.InformationalWindows;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс, представляющий стартовое окно приложения.
 */
public class SplashScreen extends JFrame {
    /**
     * Конструктор класса Start, инициализирующий стартовое окно приложения.
     * 
     * @author Barkovets R. S.
     * @version 1.0
     */
    public SplashScreen() {
        super("Стартовое окно");
        this.setSize(560, 500);
        // Установка операции закрытия окна по умолчанию
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Запрет изменения размера окна пользователем
        this.setResizable(false);
        Timer timer = new Timer(60000, e -> dispose());
        timer.start();
        setLocationRelativeTo(null);
        JLabel startWindowLabelData_1 = new JLabel("Беларусский национальный технический университет");
        JLabel startWindowLabelData_2 = new JLabel("Факультет информационных технологий и робототехники");
        JLabel startWindowLabelData_3 = new JLabel("Кафедра программного обеспечения информационных систем и технологий");
        JLabel startWindowLabelData_4 = new JLabel("Курсовая работа");
        JLabel startWindowLabelData_5 = new JLabel("по дисциплине \"программирование на языке Java\"");
        JLabel startWindowLabelData_6 = new JLabel("Расчет начисления отпускной заработной платы");
        JLabel startWindowLabelData_7 = new JLabel("Выполнил: Студент группы 10702221");
        JLabel startWindowLabelData_8 = new JLabel("Барковец Роман Сергеевич");
        JLabel startWindowLabelData_9 = new JLabel("Преподователь: к.ф.-м.н., доц.");
        JLabel startWindowLabelData_10 = new JLabel("Сидорик Валерий Владимирович");
        JLabel startWindowLabelData_11 = new JLabel("Минск, 2023");
        // Настройка шрифта для меток
        Font startWindowLabelFont_1 = new Font("Times New Roman", Font.BOLD, 14);
        Font startWindowLabelFont_2 = new Font("Times New Roman", Font.BOLD, 20);
        Font startWindowLabelFont_3 = new Font("Times New Roman", Font.BOLD, 18);
        // Установка шрифта для меток
        startWindowLabelData_1.setFont(startWindowLabelFont_1);
        startWindowLabelData_2.setFont(startWindowLabelFont_1);
        startWindowLabelData_3.setFont(startWindowLabelFont_1);
        startWindowLabelData_4.setFont(startWindowLabelFont_2);
        startWindowLabelData_5.setFont(startWindowLabelFont_3);
        startWindowLabelData_6.setFont(startWindowLabelFont_2);
        startWindowLabelData_7.setFont(startWindowLabelFont_1);
        startWindowLabelData_8.setFont(startWindowLabelFont_1);
        startWindowLabelData_9.setFont(startWindowLabelFont_1);
        startWindowLabelData_10.setFont(startWindowLabelFont_1);
        startWindowLabelData_11.setFont(startWindowLabelFont_1);

        JButton start = new JButton("Запустить");
        JButton stop = new JButton("Закончить");

// Создание панели для компоновки компонентов
        JPanel startWindowPanel = new JPanel();
        // Установка менеджера компоновки в null, что позволяет явно задавать позиции компонентов
        startWindowPanel.setLayout(null);
        // Установка расположения меток
        startWindowLabelData_1.setBounds(80, 10, 370, 20);
        startWindowLabelData_2.setBounds(75, 30, 400, 20);
        startWindowLabelData_3.setBounds(15, 50, 520, 20);
        startWindowLabelData_4.setBounds(200, 150, 200, 20);
        startWindowLabelData_5.setBounds(50, 175, 450, 20);
        startWindowLabelData_6.setBounds(50, 200, 500, 20);
        startWindowLabelData_7.setBounds(280, 250, 250, 20);
        startWindowLabelData_8.setBounds(280, 270, 280, 20);
        startWindowLabelData_9.setBounds(280, 310, 250, 20);
        startWindowLabelData_10.setBounds(280, 330, 250, 20);
        startWindowLabelData_11.setBounds(225, 400, 100, 20);
        start.setBounds(175, 430, 100, 25);
        stop.setBounds(275, 430, 100, 25);
        // Добавление меток в панель
        startWindowPanel.add(startWindowLabelData_1);
        startWindowPanel.add(startWindowLabelData_2);
        startWindowPanel.add(startWindowLabelData_3);
        startWindowPanel.add(startWindowLabelData_4);
        startWindowPanel.add(startWindowLabelData_5);
        startWindowPanel.add(startWindowLabelData_6);
        startWindowPanel.add(startWindowLabelData_7);
        startWindowPanel.add(startWindowLabelData_8);
        startWindowPanel.add(startWindowLabelData_9);
        startWindowPanel.add(startWindowLabelData_10);
        startWindowPanel.add(startWindowLabelData_11);
        startWindowPanel.add(start);
        startWindowPanel.add(stop);
        this.add(startWindowPanel);
        this.setVisible(true);

        // Создание метки для отображения изображения
        JLabel icon = new JLabel();
        ImageIcon img = new ImageIcon("C:\\Users\\roman\\VSCodeProjects\\VacationPaymentsCalculator\\images\\splash.png");
        // Установка изображения для метки
        icon.setIcon(img);
        // Установка позиции и размеров метки на панели
        icon.setBounds(40, 222, 223, 150);
        startWindowPanel.add(icon);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Скрыть стартовое окно
                setVisible(false);
                // Создание и отображение главного окна
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Закрыть стартовое окно
                dispose();
            }
        });

    }

    /**
     * Главный метод, запускающий приложение.
     *
     * @param args Параметры командной строки (не используются).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SplashScreen app = new SplashScreen();
                app.setVisible(true);
            }
        });
    }
}