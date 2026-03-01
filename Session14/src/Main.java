import java.util.*;

public class Main {
    //Tao list 100 so random 1-1000
    //1 loai bo trung lap
    //2 Dem so lan xuat hien
    public static void main(String[] args) {
        List<Integer> list100 = new ArrayList<>();
        Random rad = new Random();
        for (int i = 0; i < 100; i++) {
            list100.add(rad.nextInt(100));
        }
        System.out.println(list100);
        System.out.println(list100.size());
        Set<Integer> unquiList100=new HashSet<>(list100);
        System.out.println(unquiList100.size());
        Map<Integer,Integer> countList =new HashMap<>();
        for(Integer e:list100){
            if(countList.keySet().contains(e)){
                countList.put(e,countList.get(e)+1);
            }else {
                countList.put(e,1);
            }
        }
        System.out.println(countList);
    }
}
