package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Author zyf
 * @Description
 * @ClassName Demo
 * @Date 2020/7/30 21:59
 **/
public class Demo {
    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 9;
//        int[] ints = twoSum(nums, target);
//        System.out.println(Arrays.toString(ints));

//        ArrayList<Object> objects = new ArrayList<>(Arrays.asList(1,2,3,4,5));
//        Queue queue = new ConcurrentLinkedDeque<>();
//        queue.offer(1);
//        queue.add(4);
//        queue.offer(2);
//        queue.offer(3);
//        System.out.println(queue);
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//        Stack stack = new Stack();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        System.out.println(stack);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        System.out.println("0.3*3=  "+0.3*3);
        System.out.println("0.3*3==0.3  "+(0.3*3 == 0.3));

        byte a = 1;
//        a = a+1;
        a += 1;//+=会隐式强转为持有结果的类型


    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = null;
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if(diff==nums[j]&&j!=i){
                    result = new int[2];
                    result[0] = i;
                    result[1] = j;
                }
            }

        }
        return result;
    }

//    public static int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                return new int[] { map.get(complement), i };
//            }
//            map.put(nums[i], i);
//        }
//        return null;
//    }
}
