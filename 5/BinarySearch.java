https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package search;

public class BinarySearch {

	public static boolean binarySearch(int[] list, int target) {

		int lo=0, hi=list.length-1;
		while (lo <= hi) {
			int mid = (lo+hi)/2;
			if (target == list[mid]) {
				return true;
			}
			if (target < list[mid]) {
				hi = mid-1;
			} else {
				lo = mid+1;
			}
		}
		return false;
	}
	
	
	private static boolean 
	recursiveBinarySearch2(int[] list, int target, int lo, int hi) {

		if (lo > hi) {
			return false;
		}
		int mid = (lo+hi)/2;
		if (target == list[mid]) {
			return true;
		}
		if (target < list[mid]) {
			return recursiveBinarySearch2(list, target, lo, mid-1);
		} else {
			return recursiveBinarySearch2(list, target, mid+1, hi);
		}
	}
	
	public static boolean binarySearch2(int[] list, int target) {
		return recursiveBinarySearch2(list, target, 0, list.length-1);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2,4,16,19,26,29,32,66,67,90};

        for (int i=0; i < arr.length; i++) {
            System.out.println(arr[i]+": "+ binarySearch2(arr,arr[i]));
        }
        
        System.out.println("75: " + binarySearch2(arr,75));

	}

}
