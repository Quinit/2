import java.util.Date;

record RecordX(int a, int b){}

public class CLASS {
    
    private final String NAME;
    private String VERSION;
    public static int NEXT = 0;


    public CLASS(String aNAME) {
        this.NAME = aNAME;
        System.out.println(new Date().toString());
        
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

