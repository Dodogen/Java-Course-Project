package models;

import java.util.Date;

import javax.swing.JFileChooser;

import listeners.SaveButtonListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Класс представляющий работника для которого нуно рассчитать отпускные выплаты
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */

public class Employee {
    /**
     * ФИО работника
     */
    private String fullName;
    
    /**
     * Начала отпуска
     */
    private Date startVacation;

    /**
     * Конец отпуска
     */
    private Date endVacation;

    /**
     * Отпускные выплаты
     */
    private double vacationSalary;

    /**
     * Количество отпускных дней
     */
    private int vacationPeriod;

    /**
     * Конструктор класса, который генерирует полную информацию об объекте
     * Инициализирует поле слушателя кнопки "Сохранить" для сохранения информации об объекте
     * @param fullName - ФИО работника
     * @param yearSalary - ArrayList типа Double, содержащий зарплату за каждый месяц
     * @param start - Начало отпуска
     * @param end - Конец отпуска
     * @param kidsCount - Количество детей работника
     * @param isInTradeUnion - Состоит ли работник в профсоюзе
     */
    public Employee(String fullName, YearSalary yearSalary, Date start, Date end, int kidsCount,
            boolean isInTradeUnion) {
        this.fullName = fullName;
        this.startVacation = start;
        this.endVacation = end;
        this.vacationPeriod = calculateDaysBetween(startVacation, endVacation);
        this.vacationSalary = yearSalary.calculateVacationSalary(kidsCount, isInTradeUnion, vacationPeriod);

        SaveButtonListener.emp = this;
    }

    /**
     * Рассчитывает количество дней между двумя датами
     * @param date1 - Ранняя дата
     * @param date2 - Поздняя дата
     * @return количество дней между @param date1 и @param date2
     */
    private static int calculateDaysBetween(Date date1, Date date2) {
        LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return (int) java.time.temporal.ChronoUnit.DAYS.between(localDate1, localDate2);
    }

    /**
     * Вызывает JFileChooser и записывает в выбранную директорию инормацию о работнике
     */
    public void reportToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                FileWriter writer = new FileWriter(fileToSave + ".txt", false);
                writer.write(this.toString());
                writer.close();
                System.out.println("Текст успешно записан в файл " + fileToSave.getName());
            } catch (IOException e) {
                System.out
                        .println("Произошла ошибка при записи в файл " + fileToSave.getName() + ": " + e.getMessage());
            }

        }

    }

    /**
     * Перегруженный метод, который возвращает информацию об объекте
     * 
     * @return ФИО, период отпуска и кол-во дней отпуска, отпускные выплаты для работника
     */
    @Override
    public String toString() {
        return "Работник: " + this.fullName + "\n" +
                "Отпуск: с " + this.startVacation + " по " + this.endVacation + " (" + vacationPeriod + " к. д.)" + "\n"
                +
                "Отпускные выплаты: " + String.format("%.2f", this.vacationSalary) + " рублей";
    }
}
