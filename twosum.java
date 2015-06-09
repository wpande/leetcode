import java.util.HashMap;
public class twosum{
       int []numbs={2,7,11,15};
       int target=9;
       twosum(){
           HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
           hs.put(target-nums[0],1);
           for(int i=1;i<nums.length;i++){
               if(hs.containsKey(nums[i])){
                   System.out.println("index1="+hs.get(nums[i])+", index2="+(i+1));
               }
               else
                   hs.put(target-nums[i],i+1);
           }
       }
       public static void main(String []args){
           twosum t=new twosum();
       }

}