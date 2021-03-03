package com.heo.lotto.domain;

import java.util.Arrays;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Numbers {
    int num1;
    int num2;
    int num3;
    int num4;
    int num5;
    int num6;

    public Numbers(int[] nums){
        this.num1 = nums[0];
        this.num2 = nums[1];
        this.num3 = nums[2];
        this.num4 = nums[3];
        this.num5 = nums[4];
        this.num6 = nums[5];
    }

    public Numbers(int num1, int num2, int num3, int num4, int num5, int num6){
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.num5 = num5;
        this.num6 = num6;
    }

    public void sort(){
        int[] nums = new int[6];

        nums[0] = num1;
        nums[1] = num2;
        nums[2] = num3;
        nums[3] = num4;
        nums[4] = num5;
        nums[5] = num6;

        Arrays.sort(nums);

        setNum1(nums[0]);
        setNum2(nums[0]);
        setNum3(nums[0]);
        setNum4(nums[0]);
        setNum5(nums[0]);
        setNum6(nums[0]);
    }
    
}
