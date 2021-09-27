package pl.woochuck.brygadac.harmonogram;

public class Day {
    private Integer id;
    private String week;
    private String month;
    private int date;
    private String day;
    private String shiftEmp0;
    private String shiftEmp1;
    private String shiftEmp2;
    private String shiftEmp3;
    private String shiftEmp4;
    private String shiftEmp5;
    private String shiftEmp6;
    private String shiftEmp7;
    private String shiftEmp8;
    private String shiftEmp9;
    private String shiftEmp10;

    public Day(String week, String month, int date, String day, String shiftEmp0, String shiftEmp1, String shiftEmp2, String shiftEmp3, String shiftEmp4, String shiftEmp5, String shiftEmp6, String shiftEmp7, String shiftEmp8, String shiftEmp9, String shiftEmp10) {
        this.week = week;
        this.month = month;
        this.date = date;
        this.day = day;
        this.shiftEmp0 = shiftEmp0;
        this.shiftEmp1 = shiftEmp1;
        this.shiftEmp2 = shiftEmp2;
        this.shiftEmp3 = shiftEmp3;
        this.shiftEmp4 = shiftEmp4;
        this.shiftEmp5 = shiftEmp5;
        this.shiftEmp6 = shiftEmp6;
        this.shiftEmp7 = shiftEmp7;
        this.shiftEmp8 = shiftEmp8;
        this.shiftEmp9 = shiftEmp9;
        this.shiftEmp10 = shiftEmp10;
    }

    public Day(Integer id, String week, String month, int date, String day, String shiftEmp0, String shiftEmp1, String shiftEmp2, String shiftEmp3, String shiftEmp4, String shiftEmp5, String shiftEmp6, String shiftEmp7, String shiftEmp8, String shiftEmp9, String shiftEmp10) {
        this(week, month, date, day, shiftEmp0, shiftEmp1, shiftEmp2, shiftEmp3, shiftEmp4, shiftEmp5, shiftEmp6, shiftEmp7, shiftEmp8, shiftEmp9, shiftEmp10);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getShiftEmp0() {
        return shiftEmp0;
    }

    public void setShiftEmp0(String shiftEmp0) {
        this.shiftEmp0 = shiftEmp0;
    }

    public String getShiftEmp1() {
        return shiftEmp1;
    }

    public void setShiftEmp1(String shiftEmp1) {
        this.shiftEmp1 = shiftEmp1;
    }

    public String getShiftEmp2() {
        return shiftEmp2;
    }

    public void setShiftEmp2(String shiftEmp2) {
        this.shiftEmp2 = shiftEmp2;
    }

    public String getShiftEmp3() {
        return shiftEmp3;
    }

    public void setShiftEmp3(String shiftEmp3) {
        this.shiftEmp3 = shiftEmp3;
    }

    public String getShiftEmp4() {
        return shiftEmp4;
    }

    public void setShiftEmp4(String shiftEmp4) {
        this.shiftEmp4 = shiftEmp4;
    }

    public String getShiftEmp5() {
        return shiftEmp5;
    }

    public void setShiftEmp5(String shiftEmp5) {
        this.shiftEmp5 = shiftEmp5;
    }

    public String getShiftEmp6() {
        return shiftEmp6;
    }

    public void setShiftEmp6(String shiftEmp6) {
        this.shiftEmp6 = shiftEmp6;
    }

    public String getShiftEmp7() {
        return shiftEmp7;
    }

    public void setShiftEmp7(String shiftEmp7) {
        this.shiftEmp7 = shiftEmp7;
    }

    public String getShiftEmp8() {
        return shiftEmp8;
    }

    public void setShiftEmp8(String shiftEmp8) {
        this.shiftEmp8 = shiftEmp8;
    }

    public String getShiftEmp9() {
        return shiftEmp9;
    }

    public void setShiftEmp9(String shiftEmp9) {
        this.shiftEmp9 = shiftEmp9;
    }

    public String getShiftEmp10() {
        return shiftEmp10;
    }

    public void setShiftEmp10(String shiftEmp10) {
        this.shiftEmp10 = shiftEmp10;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", week='" + week + '\'' +
                ", month='" + month + '\'' +
                ", date=" + date +
                ", day='" + day + '\'' +
                ", shiftEmp0='" + shiftEmp0 + '\'' +
                ", shiftEmp1='" + shiftEmp1 + '\'' +
                ", shiftEmp2='" + shiftEmp2 + '\'' +
                ", shiftEmp3='" + shiftEmp3 + '\'' +
                ", shiftEmp4='" + shiftEmp4 + '\'' +
                ", shiftEmp5='" + shiftEmp5 + '\'' +
                ", shiftEmp6='" + shiftEmp6 + '\'' +
                ", shiftEmp7='" + shiftEmp7 + '\'' +
                ", shiftEmp8='" + shiftEmp8 + '\'' +
                ", shiftEmp9='" + shiftEmp9 + '\'' +
                ", shiftEmp10='" + shiftEmp10 + '\'' +
                '}';
    }
}
