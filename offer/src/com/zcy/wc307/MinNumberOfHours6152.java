package com.zcy.wc307;

public class MinNumberOfHours6152 {
    //easy
    //自写的感觉速度不太行
    //好像也就这样做了
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int trainEnergy = 0;
        int trainExp = 0;
        int sum = 0;
        for(int i = 0;i < energy.length;i++){
            sum+=energy[i];
        }
        if(sum >=initialEnergy){
            trainEnergy = sum - initialEnergy + 1;
        }


        int exp = initialExperience;
        for(int i = 0;i < experience.length;i++){
            if(experience[i] < exp){
                exp+=experience[i];
            }else{
                trainExp+= experience[i] - exp+1;
                exp = experience[i]*2 + 1;
            }
        }
        return trainEnergy + trainExp;
    }
}
