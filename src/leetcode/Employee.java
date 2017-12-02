package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Author ： Martin
 * Date : 17/11/13
 * Description :
 * Version : 2.0
 */
public class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;


    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee>  employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(employeeMap.get(id));
        int sum  = 0;
        while (!queue.isEmpty()) {
            Employee employee = queue.poll();
            sum += employee.importance;
            List<Integer> sub = employee.subordinates;
            for (Integer elem : sub) {
                queue.offer(employeeMap.get(elem));
            }
        }
        return sum;
    }


    public static void main(String[] args) {

    }
}
