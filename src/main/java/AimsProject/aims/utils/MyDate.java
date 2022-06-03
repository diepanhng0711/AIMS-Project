package AimsProject.aims.utils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
//import javax.swing.JOptionPane;

public class MyDate {
    private int day;
    private int month;
    private int year;
    private LocalDate dateOrdered = LocalDate.now();

    public LocalDate getLocalDate() {
        return this.dateOrdered;
    }

    public MyDate() {
        Calendar calendar = Calendar.getInstance();
        this.day = calendar.get(Calendar.DATE);
        this.month = calendar.get(Calendar.MONTH) + 1; //Since January <=> Calendar.MONTH == 0 and so on
        this.year = calendar.get(Calendar.YEAR);
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate(String date) {
        String[] dtime = date.split(" ");
        HashMap<String, Integer> dmonth = new HashMap<String, Integer>();
        dmonth.put("January", 1);
        dmonth.put("February", 2);
        dmonth.put("March", 3);
        dmonth.put("April", 4);
        dmonth.put("May", 5);
        dmonth.put("June", 6);
        dmonth.put("July", 7);
        dmonth.put("August", 8);
        dmonth.put("September", 9);
        dmonth.put("October", 10);
        dmonth.put("November", 11);
        dmonth.put("December", 12);

        this.day = Integer.parseInt(dtime[1].substring(0, dtime[1].length() - 2));
        this.month = dmonth.get(dtime[0]);
        this.year = Integer.parseInt(dtime[2]);
    }

    public MyDate(String sday, String smonth, String syear) {
        HashMap<String, Integer> dday = new HashMap<String, Integer>();
        HashMap<String, Integer> dmonth = new HashMap<String, Integer>();
        HashMap<String, Integer> dyear = new HashMap<String, Integer>();

        //Assign keys for Month HashMap
        dmonth.put("january", 1);
        dmonth.put("february", 2);
        dmonth.put("march", 3);
        dmonth.put("april", 4);
        dmonth.put("may", 5);
        dmonth.put("june", 6);
        dmonth.put("july", 7);
        dmonth.put("august", 8);
        dmonth.put("september", 9);
        dmonth.put("october", 10);
        dmonth.put("november", 11);
        dmonth.put("december", 12);

        //Assign keys for Day HashMap
        dday.put("first", 1);
        dday.put("second", 2);
        dday.put("third", 3);
        dday.put("fourth", 4);
        dday.put("fifth", 5);
        dday.put("sixth", 6);
        dday.put("seventh", 7);
        dday.put("eighth", 8);
        dday.put("ninth", 9);
        dday.put("tenth", 10);
        dday.put("eleventh", 11);
        dday.put("twelfth", 12);
        dday.put("thirteenth", 13);
        dday.put("fourteenth", 14);
        dday.put("fifteenth", 15);
        dday.put("sixteenth", 16);
        dday.put("seventeenth", 17);
        dday.put("eightennth", 18);
        dday.put("nineteenth", 19);
        dday.put("twentieth", 20);
        dday.put("twenty-first", 21);
        dday.put("twenty-second", 22);
        dday.put("twenty-third", 23);
        dday.put("twenty-fourth", 24);
        dday.put("twenty-fifth", 25);
        dday.put("twenty-sixth", 26);
        dday.put("twenty-seventh", 27);
        dday.put("twenty-eighth", 28);
        dday.put("twenty-ninth", 29);
        dday.put("thirtieth", 30);
        dday.put("thirty-first", 31);

        //Assign keys for Year HashMap (only supported for years from 1980 to 2030)
        dyear.put("nineteen eighty", 1980);
        dyear.put("nineteen eighty-one", 1981);
        dyear.put("nineteen eighty-two", 1982);
        dyear.put("nineteen eighty-three", 1983);
        dyear.put("nineteen eighty-four", 1984);
        dyear.put("nineteen eighty-five", 1985);
        dyear.put("nineteen eighty-six", 1986);
        dyear.put("nineteen eighty-seven" , 1987);
        dyear.put("nineteen eighty-eight", 1988);
        dyear.put("nineteen eighty-nine", 1989);
        dyear.put("nineteen ninety", 1990);
        dyear.put("nineteen ninety-one", 1991);
        dyear.put("nineteen ninety-two", 1992);
        dyear.put("nineteen ninety-three", 1993);
        dyear.put("nineteen ninety-four", 1994);
        dyear.put("nineteen ninety-five", 1995);
        dyear.put("nineteen ninety-six", 1996);
        dyear.put("nineteen ninety-seven", 1997);
        dyear.put("nineteen ninety-eight", 1998);
        dyear.put("nineteen ninety-nine", 1999);
        dyear.put("two thousand", 2000);

        //2000 - 2030 with and + thousand
        dyear.put("two thousand and one", 2001);
        dyear.put("two thousand and two", 2002);
        dyear.put("two thousand and three", 2003);
        dyear.put("two thousand and four", 2004);
        dyear.put("two thousand and five", 2005);
        dyear.put("two thousand and six", 2006);
        dyear.put("two thousand and seven", 2007);
        dyear.put("two thousand and eight", 2008);
        dyear.put("two thousand and nine", 2009);
        dyear.put("two thousand and ten", 2010);
        dyear.put("two thousand and eleven", 2011);
        dyear.put("two thousand and twelve", 2012);
        dyear.put("two thousand and thirteen", 2013);
        dyear.put("two thousand and fourteen", 2014);
        dyear.put("two thousand and fifteen", 2015);
        dyear.put("two thousand and sixteen", 2016);
        dyear.put("two thousand and seventeen", 2017);
        dyear.put("two thousand and eighteen", 2018);
        dyear.put("two thousand and nineteen", 2019);
        dyear.put("two thousand and twenty", 2020);
        dyear.put("two thousand and twenty-one", 2021);
        dyear.put("two thousand and twenty-two", 2022);
        dyear.put("two thousand and twenty-three", 2023);
        dyear.put("two thousand and twenty-four", 2024);
        dyear.put("two thousand and twenty-five", 2025);
        dyear.put("two thousand and twenty-six", 2026);
        dyear.put("two thousand and twenty-seven", 2027);
        dyear.put("two thousand and twenty-eight", 2028);
        dyear.put("two thousand and twenty-nine", 2029);
        dyear.put("two thousand and thirty", 2030);

        //2000 - 2030 with thousand
        dyear.put("two thousand-one", 2001);
        dyear.put("two thousand-two", 2002);
        dyear.put("two thousand-three", 2003);
        dyear.put("two thousand-four", 2004);
        dyear.put("two thousand-five", 2005);
        dyear.put("two thousand-six", 2006);
        dyear.put("two thousand-seven", 2007);
        dyear.put("two thousand-eight", 2008);
        dyear.put("two thousand-nine", 2009);
        dyear.put("two thousand-ten", 2010);
        dyear.put("two thousand-eleven", 2011);
        dyear.put("two thousand-twelve", 2012);
        dyear.put("two thousand-thirteen", 2013);
        dyear.put("two thousand-fourteen", 2014);
        dyear.put("two thousand-fifteen", 2015);
        dyear.put("two thousand-sixteen", 2016);
        dyear.put("two thousand-seventeen", 2017);
        dyear.put("two thousand-eighteen", 2018);
        dyear.put("two thousand-nineteen", 2019);
        dyear.put("two thousand-twenty", 2020);
        dyear.put("two thousand-twenty-one", 2021);
        dyear.put("two thousand-twenty-two", 2022);
        dyear.put("two thousand-twenty-three", 2023);
        dyear.put("two thousand-twenty-four", 2024);
        dyear.put("two thousand-twenty-five", 2025);
        dyear.put("two thousand-twenty-six", 2026);
        dyear.put("two thousand-twenty-seven", 2027);
        dyear.put("two thousand-twenty-eight", 2028);
        dyear.put("two thousand-twenty-nine", 2029);
        dyear.put("two thousand-thirty", 2030);

        //2000 - 2030 with twele
        dyear.put("twenty oh one", 2001);
        dyear.put("twenty oh two", 2002);
        dyear.put("twenty oh three", 2003);
        dyear.put("twenty oh four", 2004);
        dyear.put("twenty oh five", 2005);
        dyear.put("twenty oh six", 2006);
        dyear.put("twenty oh seven", 2007);
        dyear.put("twenty oh eight", 2008);
        dyear.put("twenty oh nine", 2009);
        dyear.put("twenty ten", 2010);
        dyear.put("twenty eleven", 2011);
        dyear.put("twenty twelve", 2012);
        dyear.put("twenty thirteen", 2013);
        dyear.put("twenty fourteen", 2014);
        dyear.put("twenty fifteen", 2015);
        dyear.put("twenty sixteen", 2016);
        dyear.put("twenty seventeen", 2017);
        dyear.put("twenty eighteen", 2018);
        dyear.put("twenty nineteen", 2019);
        dyear.put("twenty twenty", 2020);
        dyear.put("twenty twenty-one", 2021);
        dyear.put("twenty twenty-two", 2022);
        dyear.put("twenty twenty-three", 2023);
        dyear.put("twenty twenty-four", 2024);
        dyear.put("twenty twenty-five", 2025);
        dyear.put("twenty twenty-six", 2026);
        dyear.put("twenty twenty-seven", 2027);
        dyear.put("twenty twenty-eight", 2028);
        dyear.put("twenty twenty-nine", 2029);
        dyear.put("twenty thirty", 2030);

        //Convert Date from input strings to valid date values
        this.day = dday.get(sday.toLowerCase());
        this.month = dmonth.get(smonth.toLowerCase());
        this.year = dyear.get(syear.toLowerCase());
    }


    public void print() {
        HashMap<Integer, String> dmonth = new HashMap<Integer, String>();
        dmonth.put(1, "January");
        dmonth.put(2, "February");
        dmonth.put(3, "March");
        dmonth.put(4, "April");
        dmonth.put(5, "May");
        dmonth.put(6, "June");
        dmonth.put(7, "July");
        dmonth.put(8, "August");
        dmonth.put(9, "September");
        dmonth.put(10, "October");
        dmonth.put(11, "November");
        dmonth.put(12, "December");

        if(this.day == 1 || this.day == 21 || this.day == 31) {
            System.out.println("\nDate = " + dmonth.get(this.month) + " " + this.day + "st " + this.year);
            System.out.println();
        } else if (this.day == 2 || this.day == 22) {
            System.out.println("\nDate = " + dmonth.get(this.month) + " " + this.day + "nd " + this.year);
            System.out.println();
        } else if (this.day == 3 || this.day == 23) {
            System.out.println("\nDate = " + dmonth.get(this.month) + " " + this.day + "rd " + this.year);
            System.out.println();
        } else {
            System.out.println("\nDate = " + dmonth.get(this.month) + " " + this.day + "th " + this.year);
            System.out.println();
        }
    }

    public void printDate() {
        System.out.println(this.month + "/" + this.day + "/" + this.year);
    }

    public void choosePrintingFormat(int key) {
        HashMap<Integer, String> dmonth = new HashMap<Integer, String>();
        dmonth.put(1, "Jan");
        dmonth.put(2, "Feb");
        dmonth.put(3, "Mar");
        dmonth.put(4, "Apr");
        dmonth.put(5, "May");
        dmonth.put(6, "Jun");
        dmonth.put(7, "Jul");
        dmonth.put(8, "Aug");
        dmonth.put(9, "Sep");
        dmonth.put(10, "Oct");
        dmonth.put(11, "Nov");
        dmonth.put(12, "Dec");

        switch(key) {
            case 1:
                if ((this.day < 10) && (this.month < 10)) {
                    System.out.println(this.year + "-0" + this.month + "-0" + this.day);
                } else if (this.day < 10) {
                    System.out.println(this.year + "-" + this.month + "-0" + this.day);
                } else if (this.month < 10) {
                    System.out.println(this.year + "-0" + this.month + "-" + this.day);
                } else {
                    System.out.println(this.year + "-" + this.month + "-" + this.day);
                }
                break;
            case 2:
                System.out.println(this.day + "/" + this.month + "/" + this.year);
                break;
            case 3:
                if (this.day < 10) {
                    System.out.println("0" + this.day + "-" + dmonth.get(this.month) + "-" + this.year);
                } else {
                    System.out.println(this.day + "-" + dmonth.get(this.month) + "-" + this.year);
                }
                break;
            case 4:
                System.out.println(dmonth.get(this.month) + " " + this.day + " " + this.year);
                break;
            case 5:
                if ((this.day < 10) && (this.month < 10)) {
                    System.out.println("0" + this.day + "-0" + this.month + "-" + this.year);
                } else if (this.day < 10) {
                    System.out.println("0" + this.day + "-" + this.month + "-" + this.year);
                } else if (this.month < 10) {
                    System.out.println(this.day + "-0" + this.month + "-" + this.year);
                } else {
                    System.out.println(this.day + "-" + this.month + "-" + this.year);
                }
        }
    }
}