package models;

import java.util.ArrayList;

/**
 * Класс представляющий годовую зарплату
 * 
 * @author Barkovets R. S.
 * @version 1.0
 */

public class YearSalary {
    /**
     * Зарплаты за каждый месяц
     */
    private ArrayList<Double> salaries = new ArrayList<>(12);
    
    /**
     * Количество отработанных месяцев
     */
    private int workMonths; // count of work months in year (payments >0)

    /**
     * Максимальная зарплата за последний отработанный год
     */
    private double maxSalary; 

    /**
     * Коэффициент "месяца"
     */
    private final double koef = 29.6;

    /**
     * Предел рассчитанной зарплаты, ниже которой
     * предоставляется скидка для снижения подоходного налога
     */
    private final double benefitSalary = 944;

    /**
     * Скидка в рублях на одного несовершеннолетнего ребенка
     * или студента очного отделения
     */
    private final double kidKoef = 46;

    /**
     * Процент отчислений в пенсионных фонд
     */
    private final double pensKoef = 0.01;

    /**
     * Процент отчислений в профсоюз
     */
    private final double tradeUnionKoef = 0.01;

    /**
     * Подоходный налог
     */
    private final double incomeTaxKoef = 0.13;

    /**
     * Конструктор, который инициализирует поле salaries,
     * ищет максимальную зарплату,
     * считает количество отработанных месяцев
     * @param salaries
     */
    public YearSalary(ArrayList<Double> salaries) {
        this.salaries = salaries;
        this.workMonths = findWorkMonths();
        this.maxSalary = findMaxSalary();
    }

    /**
     * Расчитывает отпускную зарплату заданного кол-ва отпускных дней
     * с учетом нахождения в профсоюзе и количества детей
     * @param kidsCount количество несовершеннолетний детей или очно обущающихся детей-студентов
     * @param isInTradeUnion является ли работник членом профсоюза
     * @param vacationDaysCount количество отпускных дней
     * @return количество отпускных дней
     */
    public double calculateVacationSalary(int kidsCount, boolean isInTradeUnion, int vacationDaysCount) {
        double vacationSalary = 0;
        double sum = 0;

        for (int i = 0; i < salaries.size(); i++) {
            if(salaries.get(i).isNaN()){
                continue;    
            }
            sum += (this.maxSalary / salaries.get(i)) * salaries.get(i);
        }

        double mid = sum / (workMonths * koef); // средняя зп за день
        double preVacSal = mid * vacationDaysCount; // безнаоговые отпускные
        double tax = (preVacSal - kidsCount * kidKoef - 156 * (preVacSal < benefitSalary ? 1 : 0)) * incomeTaxKoef; // подоходный налог
        double pensTax = preVacSal * pensKoef; //пенсионные отчисления
        double tradeUnionTax = preVacSal * tradeUnionKoef; // профсоюзные отчисления
        vacationSalary = preVacSal - tax - pensTax - tradeUnionTax * (isInTradeUnion == true ? 1 : 0); // отпускные

        if (Double.isNaN(vacationSalary)) //если числа НаН, то отпускные "не начислены"
            vacationSalary = 0.0;
        return vacationSalary;
    }

    /**
     * Ищет максимальную зарплату
     * @return максмальное значение в списке
     */
    private double findMaxSalary() {
        double max = 0; // max of salaries
        for (int i = 0; i < salaries.size(); i++) {
            if (salaries.get(i) > max) {
                max = salaries.get(i);
            }
        }
        return max;
    }

    /**
     * считает количество отработанных месяцев
     * @return количество отработанных месяцев
     */
    private int findWorkMonths() {
        int workMonths = 0;
        for (int i = 0; i < salaries.size(); i++) {
            if (salaries.get(i) > 0)
            {
                workMonths++;
            }
        }
        return workMonths;
    }

}
