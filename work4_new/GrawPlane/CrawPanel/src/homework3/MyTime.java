package homework3;

public class MyTime {
    int hour,minute,second;
    private String day = "AM";
    
    private void renewTime(){
        if(hour == 0)   hour +=12;
        if(hour == 12) {
            if(minute ==0&&second == 0) this.day = "AM";
            else this.day = "PM";
        }
    }
    private String getRightForm(int x){
        if(x>=10)return Integer.toString(x);
        else return "0"+x;
    }
    private boolean getRightTime(){
        if(hour>23||hour<0||minute<0||minute>59||second<0||second>59)return true;
        else return false;
    }
    private String whereWrong(){
        return ifHour()+ifMinute()+ifSecond();
    }
    public String ifHour(){
        if(hour>23||hour<0) return "hour must be 0-23\n";
        else return "";
    }
    public String ifMinute(){
        if(minute>59||minute<0) return "minute must be 0-59\n";
        else return "";
    }
    public String ifSecond(){
        if(second>59||second<0) return "second must be 0-59\n";
        else return "";
    }
    //构造函数
    public MyTime(int hour,int minute,int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        if(hour>12){
            this.day = "PM";
            this.hour-=12;
        }
        if(hour == 12 ){
            if(minute!=0||second!=0) this.day = "PM";
        } 
        if(hour==0){
            if(minute!=0||second!=0) this.day = "PM";
            hour+=12;
        }
    }
    public MyTime(){
        this(0,0,0);
    }
    public MyTime(int hour){
        this(hour,0,0);
    }
    public MyTime(int hour,int minute){
        this(hour,minute,0);
    }
    public MyTime(MyTime t){
        this(t.hour,t.minute,t.second);
    }
    //方法函数
    public String toUniversalString(){
        int hour = this.hour;
        if(getRightTime()) return whereWrong();
        if(this.day.equals("PM")){
            if(hour!=12) hour+=12;
            if(hour == 24) hour =0;
        }
        return getRightForm(hour)+" : "+getRightForm(minute)+" : "+getRightForm(second);
    }
    public String toString() {
        int hour = this.hour;
        if(getRightTime()) return whereWrong();
        if(hour==0) hour += 12;
        return getRightForm(hour)+" : "+getRightForm(minute)+" : "+getRightForm(second)+" "+day;
    }
    public void incrementHour(){
        this.hour ++;
        if(hour == 13){
            this.day = "PM";
            hour -=12;
        } 
        renewTime();
    }
    public void incrementMiinute(){
        this.minute++;
        if(minute==60){
            minute = 0;
            incrementHour();
        }
        renewTime();
    }
    public void incrementSecond(){
        this.second++;
        if(second == 60){
            second =0;
            incrementMiinute();
        }
        renewTime();

    }
    
}