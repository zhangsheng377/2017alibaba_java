package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.sql.Date;
import java.util.regex.*;

public class test {
	
	/** ������������������ʵ����ĿҪ��Ĺ��� **/
	 /** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^  **/
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] A={2,5,1,1,1,1,4,1,7,3,7};
		//int[] A={10,2,11,13,1,1,1,1,1};
		System.out.print(can_find(A));
	}
	
	
	static boolean can_find(int[] A){
		long sum=0;
		Map<Long, Vector<Integer>> sum_index=new HashMap<Long,Vector<Integer>>();
		Map<Integer, Long> index_sum=new HashMap<Integer,Long>();
		for(int i=0;i<A.length;i++){
			sum+=A[i];
			if(sum_index.containsKey(sum)){
				sum_index.get(sum).add(i+1);
			}else {
				Vector<Integer> temp=new Vector<Integer>();
				temp.add(i+1);
				sum_index.put(sum, temp);
			}
			index_sum.put(i+1, sum);
		}
		
		int m1=0,m3=A.length-1;
		long sum_m1=0,sum_m4=0;
		while (m1<m3) {
			if(sum_m1==sum_m4){
				if(m1>0){
					if(sum_index.containsKey(sum_m1*2+A[m1])){
						Vector<Integer> temp=sum_index.get(sum_m1*2+A[m1]);
						for (Integer m2 : temp) {
							if(m1<m2 && m2<m3){
								if(index_sum.get(m3)==sum_m1*3+A[m1]+A[m2]){
									return true;
								}
							}
						}
					}
				}
				sum_m1+=A[m1];m1++;
			}else if (sum_m1<sum_m4) {
				sum_m1+=A[m1];m1++;
			}else {
				sum_m4+=A[m3];m3--;
			}
		}
		return false;
	}
	
}
