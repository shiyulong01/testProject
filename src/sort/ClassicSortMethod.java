package sort;

public class ClassicSortMethod {
	//冒泡排序
	public int[] bubbleaSort(int[] src){
		int length = src.length;
		for(int i=0; i<length; i++)
		{
			for(int j=i+1; j<length; j++)
			{
				if(src[j]<src[i])
				{
					int tem = src[i];
					src[i] = src[j];
					src[j] = tem;
				}
			}
		}
		return src;
	}
	
	//选择排序
	public int[] chooseSort(int[] src){
		int length = src.length;
		for(int i=0; i<length; i++)
		{
			int k=i;
			for(int j=i+1; j<length; j++)
			{
				if(src[j]<src[k]){
					k=j;
				}
			}
			if(k!=i){
				int tem = src[i];
				src[i] = src[k];
				src[k] = tem;
			}
		}
		return src;
	}
	
	//插入排序
	public int[] insertSort(int[] src){
		int length = src.length;
		for(int i=1; i<length; i++)
		{
			int tem = src[i];
			int j;
			for(j=i; j>0; j--)
			{
				if(tem < src[j-1]){
					src[j] = src[j-1];
				}
				else
					break;
			}
			src[j] = tem;
//			System.out.println("------------------------");
//			display(src);
		}
		return src;
	}
	
	//快速排序
	public int[] quickSort(int[] src, int low, int high){
		int i = low;
		int j = high;
		//递归结束条件
		if(i < j)
		{
			int tem = src[i];
			while(i < j){
				while(src[j] > tem)
					j--;
				if(i < j){
					src[i] = src[j];
					i++;
				}
				while(src[i] < tem)
					i++;
				if(i < j){
					src[j] = src[i];
					j--;
				}
			}
			src[i] = tem;
			quickSort(src, low, i-1);
			quickSort(src, i+1, high);

		}
		return src;
	}
	
	//归并排序
	public void mergeSort(int[] data){
		
	}
	
	public void merge(int[] data, int increment){
		
	}
	
	//希尔排序
	public int[] shellSort(int[] data){
		int increment = data.length;
		do{
			increment = increment/3 +1;
			shellPass(data, increment);
		}while(increment> 1);
		return data;
	}
	
	public void shellPass(int[] data, int increment){
		for(int i = increment; i < data.length; i++){
			int j = i;
			int tem = data[j];
			j = j-increment;
			while(j>=0&&tem<data[j]){
				data[j+increment] = data[j];
				j = j - increment;
			}
			data[j+increment] = tem;
		}
	}
	
	public void display(int[] data){
		if(data==null)
			return;
		for(int i : data){
			System.out.println(i);
		}
	}
	
	
	
	public static void main(String[] args){
		ClassicSortMethod csm = new ClassicSortMethod();
		int[] a = {4, 2, 1, 6, 3, 6, 0, -5};
		System.out.println("before sort: ");
		csm.display(a);
		a = csm.shellSort(a);
		//a = csm.quickSort(a, 0, a.length-1);
		//a = csm.insertSort(a);
		//a = csm.bubbleaSort(a);
		System.out.println("after sort: ");
		csm.display(a);
	}

}
