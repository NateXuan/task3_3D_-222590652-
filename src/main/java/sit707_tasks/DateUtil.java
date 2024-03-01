package sit707_tasks;


public class DateUtil {

	// Months in order 0-11 maps to January-December.
	private static String[] MONTHS = new String[] {
			"January", "February", "March", "April", "May", "June", 
			"July", "August", "September", "October", "November", "December"
	};
	
	private int day, month, year, hour, minute, second;
	

	public DateUtil(int day, int month, int year, int hour, int minute, int second) {
        if (day < 1 || day > 31) throw new RuntimeException("Invalid day: " + day);
        if (month < 1 || month > 12) throw new RuntimeException("Invalid month: " + month);
        if (year < 1700 || year > 2024) throw new RuntimeException("Invalid year: " + year);
        if (day > monthDuration(month, year)) throw new RuntimeException("Invalid day: " + day);
        
        if (hour < 0 || hour > 23) throw new RuntimeException("Invalid hour: " + hour);
        if (minute < 0 || minute > 59) throw new RuntimeException("Invalid minute: " + minute);
        if (second < 0 || second > 59) throw new RuntimeException("Invalid second: " + second);
        
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public int getSecond() {
		return second;
	}
	

	public void increment() {
        second++;
        if (second > 59) {
            second = 0;
            minute++;
            if (minute > 59) {
                minute = 0;
                hour++;
                if (hour > 23) {
                    hour = 0;
                    incrementDate();
                }
            }
        }
    }
	
	public void decrement() {
        second--;
        if (second < 0) {
            second = 59;
            minute--;
            if (minute < 0) {
                minute = 59;
                hour--;
                if (hour < 0) {
                    hour = 23;
                    decrementDate();
                }
            }
        }
    }
	
	private void incrementDate() {
        if (day < monthDuration(month, year)) {
            day++;
        } else if (month < 12) {
            day = 1;
            month++;
        } else {
            day = 1;
            month = 1;
            year++;
        }
    }
	
	private void decrementDate() {
        if (day > 1) {
            day--;
        } else if (month > 1) {
            month--;
            day = monthDuration(month, year);
        } else {
            month = 12;
            year--;
            day = monthDuration(month, year);
        }
    }
	
	public static int monthDuration(int month, int year) {		
		if (month == 2 && year % 4 == 0) {
			// February leap year?
			return 29;			
		} else if (month == 2) {  
			// normal 28 days February
			return 28;
			
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			// 30 days' months
			return 30;			
		}
		return 31;  // rest are 31 days' months.
	}
	

	public String toString() {
        return String.format("%02d %s %d %02d:%02d:%02d", day, MONTHS[month - 1], year, hour, minute, second);
    }
	
}
