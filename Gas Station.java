
import java.util.*;

public class GasStation {
    public static String gasStation(String[] strArr) {
        // code goes here
        int stats = Integer.parseInt(strArr[0]); // not required
    
        //delete 0 pos. element
        strArr = Arrays.copyOfRange(strArr,1,strArr.length);
        
    
        for(int i=0;i<strArr.length;i++){
          int begin=i;
          int count=0;
          int currentgas=0;
    
          while(count<strArr.length){
            String [] station  = strArr[begin].split(":");
            //System.out.print(station[0]);
            currentgas += Integer.parseInt(station[0]);
            int wantgas = Integer.parseInt(station[1]);
    
            if(currentgas < wantgas)
            break;
            else{
              currentgas -= Integer.parseInt(station[1]);
    
              begin = begin+1 == strArr.length ? 0 : begin+1;
              count++;
            }
          }
    
          if(count == strArr.length)
          return i+1+"";
        }
        return "impossible";
      }
    
    
    
      public static void main (String[] args) {  
        // keep this function call here     
        //Scanner s = new Scanner(System.in);
        //System.out.print(gasStation(s.nextLine()));
        System.out.println(gasStation(new String[] {"4","3:1","2:2","1:2","0:1"})); // test1
        System.out.println(gasStation(new String[] {"4","1:1","2:2","1:2","0:1"})); // test2
        System.out.println(gasStation(new String[] {"4","0:1","2:2","1:2","3:1"})); // test3
        System.out.println(gasStation(new String[] {"4","0:1","2:2","1:2","1:1"})); // test4
        System.out.println(gasStation(new String[] {"2","1:2","3:2"})); // test5
        
      }
    
    }
