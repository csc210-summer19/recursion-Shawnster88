/**
 * Complete the seven methods methods in this file using recursion, no loops. 
 * Also complete these three methods inside LinkedList<E>:
 *   get(int)
 *   removeAll(E)
 *   duplicateAll(E)
 *   
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 *   findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will
 * be using this same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Shawn Hill 
 */
public class RecursionFun {

  // Complete recursive method combinations that returns from n choose k.
  // This method is described in 17_SimpleRecursion.pptx.
  public int combinations(int n, int k) {
	  if (k == 1) {
		  return n;
	  }
	  if (n == k) {
		  return 1; 
	  }
	  return combinations(n-1, k-1) + combinations(n-1,k);
  }

 
  // Complete recursive method intWithCommas that returns the argument as a String
  // with commas in the correct places.
  //
  // intWithCommas(999) returns "999"
  // intWithCommas(1234) returns "1,234"
  // intWithCommas(1007) returns "1,007"
  // intWithCommas(1023004567) returns "1,023,004,567"
  //
  // Precondition: n >= 0
  public String intWithCommas(int n) {
	  if (n < 1000) {
		  return "" + n;
	  }
	  else {
		  String str = "";
		  if ((n % 1000) < 10) {
			  str = "00";
		  }
		  else if ((n % 1000 )< 100) {
			  str = "0";
		  }	  
		  return intWithCommas(n/1000) + "," + str + (n % 1000);
	  }
  }

  // Write recursive method reverseArray that reverses the array elements in a
  // filled array of ints. Use recursion; do not use a loop. The following
  // assertions must pass:
  //
  // int[] a = { 2, 4, 6 };
  // rf.reverseArray(a);
  // assertEquals(6, a[0]);
  // assertEquals(4, a[1]);
  // assertEquals(2, a[2]);
  //
  // Precondition: x.length > 0
  public void reverseArray(int[] x) {
    // You need a private helper that needs additional arguments.
    // like x and x.length to keep track of array the indexes
    // with no loop. Here is an example with the private helper
    // immediately below.
    reverseArray(x, 0, x.length-1);
  }

  private void reverseArray(int[] x, int index, int len) {
	  if (index < len) {
		  int temp = x[index];
		  x[index] = x[len];
		  x[len] = temp;
		  reverseArray(x,index+1,len-1);
	  }
  } 
  // Write recursive method arrayRange that returns the maximum
  // integer minus the minimum integer in the filled array of 
  // integers, Use recursion; do not use a loop. 
  // Precondition: a.length > 0
  public int arrayRange(int[] a) {
	  return arrayRange(a,1,a[0],a[0]);
  }  
  private int arrayRange(int[] a, int index , int min , int max) {
	  if (index == a.length)
		  return max - min;
	  if (a[index] > max)
		  max = a[index];
	  if (a[index] < min)
		  min = a[index];
	  return arrayRange(a, index + 1, min, max);  
  }
  
  // Return true if nums has all int elements in ascending order.
  // If not isSorted, return false.
  public boolean isSorted(int[] nums) {
	  return isSorted(nums,nums.length);
  }
  private boolean isSorted(int[] nums, int size) {
	  if (nums.length == 0 || size < 2) {
		  return true;
	  }
	  else if (nums[size-2] > nums[size-1]){
		  return false;
	  }
	  return isSorted(nums,size -1);
  }
	  
  // Complete method found to return true if search is found in strs.
  // If not found, return false. Use equals, not ==.
  public boolean found(String search, String[] strs) {
	  return found(search,strs,0,strs.length-1); 
	  
  } 
  private boolean found(String search, String[] strs,int l, int r) {
	  if (r < l) {
		  return false;
	  }
	  if (strs[l] == search) {
		  return true;
	  }
	  if (strs[r] == search) {
		  return true;
	  }
	  return found(search,strs,l+1,r-1);
  }
  
}
