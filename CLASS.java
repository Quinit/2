import java.util.Date;

record RecordX(int a, int b){}

public class CLASS {
    
    private final String NAME;
    private final String VERSION;
    private int salary;
    public static int NEXT = 0;

    public CLASS(String NAME, String VERSION, int salary) {
        this.NAME = NAME;
        this.VERSION = VERSION;
        this.salary = salary;
    }
    
    

    public int getSalary() {
        return salary;
    }



    public static int getNEXT() {
        return NEXT;
    }



    public String getNAME() {
        return NAME;
    }
    


    public String getVERSION() {
        return VERSION;
    }

    
    
    public String getRecore() {
        RecordX recordX = new RecordX(1,2);
        return "a: " + recordX.a() + " b: " + recordX.b();
    }

    public static void main(String[] args) {
        System.out.println(new Date().toString());
        
    }
}

