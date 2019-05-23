package test;

public class 排序 {
	public static void main(String[] args) {
		int array[]={-5,29,7,10,5,16}; 
		
		//bubbleSort(array);
		
		selectionSort(array);
		
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	//冒泡
	public static int[] bubbleSort(int[] array) {
		if(array.length == 0) {
			return array;
		}
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array.length-1-i;j++) {
				if(array[j]>array[j+1]) {
					int temp;
					temp=array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
				}
			}
		}
		return array;
	}
	
	//选择
	public static int[] selectionSort(int[] array) {
		if(array.length == 0) {
			return array;
		}
		for(int i=0;i<array.length;i++) {
			int minIndex=i;
			for(int j=i;j<array.length;j++) {
				if(array[j]<array[minIndex]) {
					minIndex=j;
				}
			}
			int temp=array[minIndex];
			array[minIndex]=array[i];
			array[i]=temp;
		}
		return array;
	}
}
