package com.heo.lotto.method;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JavaTest {
    
    public int[] addTwoArr(int[] arr1, int[] arr2){
        int[] arr3 = IntStream.concat(IntStream.of(arr1), IntStream.of(arr2)).toArray();

        for(int num : arr3){
            System.out.println("num : " + num);
        }

        return arr3;
    }

    public int[] addTwoArr2(int[] arr1, int[] arr2){
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0;

        for(int num : arr1){
            arr3[i++] = num;
        }

        for(int num : arr2){
            arr3[i++] = num;
        }

        return arr3;
    }

    public int[] addTwoArr3(int[] arr1, int[] arr2){
        int[] arr3 = Arrays.copyOf(arr1, arr1.length + arr2.length);

        for(int i = 0; i < arr2.length; i++){
            arr3[arr1.length + i] = arr2[i];
        }
        
        return arr3;
    }

    @Test
    public void 두개의_배열_더하기(){
        int[] arr1 = {10,20,30};
        int[] arr2 = {40,50,60};

        int[] arr3 = addTwoArr3(arr1, arr2);

        int[] target = {10,20,30,40,50,60};
        assertEquals(true, Arrays.equals(target, arr3));
    }

    @Test
    public void test(){
        int[] sco = {1,2,3,9,10,12};
        int K = 7;
        int result = solution(sco, K);
        System.out.println("return : " + result);   
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        int[] arr3 = scoville;
        
        while(true){
            int[] arr1 = getMinSco2(arr3);
            int[] arr2 = getMinSco3(arr3);

            answer++;
            
            int num = sumScovile(arr1[0], arr1[1]);
            arr3 = null;
            arr3 = concat(arr2, num);            
            
            boolean result = check(arr3, K);
            if(result)
                return answer;
            
            if(arr3.length == 1 && !result)
                return -1;
        }
    }
    
    public boolean check(int[] arr, int k){
        for(int num : arr){
            if(num < k) 
                return false;
        }
        
        return true;
    }
    
    public int sumScovile(int sco1, int sco2) {
        return sco1 + (sco2*2);
    }
    
    public int[] getMinSco2(int [] scoville) {
        return Arrays.stream(scoville).sorted().limit(2).toArray();
    }
    
    public int[] getMinSco3(int [] scoville) {
        return Arrays.stream(scoville).sorted().skip(2).toArray();
    }
    
    public int[] concat(int[] arr1, int num){
        int[] arr2 = new int[1];
        arr2[0] = num;
        
        return IntStream.concat(IntStream.of(arr1), IntStream.of(arr2)).sorted().toArray();
    }
}
