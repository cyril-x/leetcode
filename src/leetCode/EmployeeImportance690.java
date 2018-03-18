package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by d-xsj on 18/03/2018.
 */
public class EmployeeImportance690 {
    /*
    * 既然不确定顺序，那就用map将其变成有序的，之后用递归求解
    * */
    HashMap<Integer, Employee> map = null;

    public int getImportance(List<Employee> employees, int id) {
        // valid check
        if( employees == null || employees.size() == 0 ) return 0;
        // if(id < 1 || id > employees.size() ) return 0;
        // employees.sort((e1, e2)-> e1.id - e2.id );

        if(map == null) {
            map = new HashMap<Integer, Employee>();
            for( Employee e: employees ) {
                map.put(e.id, e);
            }
        }

        Employee target = map.get(id);
        int sum = target.importance;

        for( int i: target.subordinates ) {
            sum += getImportance(employees, i);
        }
        return sum;

    }
    /*
    * 非递归求解，同515
    * */
    public int getImportance2(List<Employee> employees, int id) {
        int re =0;
        Queue<Employee> em = new LinkedList<Employee>();
        for(Employee e:employees){
            if(e.id == id){
                em.offer(e);
            }
        }
        while(!em.isEmpty()){
            Employee temp = em.poll();
            re+=temp.importance;
            if(!temp.subordinates.isEmpty()){
                for(int ii:temp.subordinates){
                    for(Employee e:employees){
                        if(e.id == ii){

                            em.offer(e);
                        }
                    }
                }
            }
        }
        return re;

    }
}
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
