class ArrIntersection2Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    
    /**
     * Approach 1: Using two pointers
     * Will follow the approach 2 of problem 349 (Intersection of Two Arrays).
     * Firstly, we have to sort both arrays.
     * After that, we will use one pointer for first array and another pointer for second array.
     * We will compare the two pointers' values and if we the two pointers point to the same value,
     * we will add that into an arraylist and move both pointers.
     * If one pointer's value is less than the other one we will move the less one to the right.
     * Lastly, will convert the arraylist into an array and return the array.
     * We don't need to check for empty array as per constraint:
     * 1 <= nums1.length, nums2.length <= 1000.
     */
    
//     Arrays.sort(nums1);
//     Arrays.sort(nums2);

//     int nums1Pointer = 0;
//     int nums2Pointer = 0;
//     ArrayList <Integer> intersectionList = new ArrayList<>();
  
//     while (nums1Pointer < nums1.length && nums2Pointer < nums2.length) {
//       if (nums1[nums1Pointer] == nums2[nums2Pointer]) {
//         intersectionList.add(nums1[nums1Pointer]);
//         nums1Pointer++;
//         nums2Pointer++;
//       } else if (nums1[nums1Pointer] > nums2[nums2Pointer]) {
//         nums2Pointer++;
//       } else {
//         nums1Pointer++;
//       }
//     }

//     int [] arrToReturn = new int [intersectionList.size()];
//     for (int i = 0; i < intersectionList.size(); i++) {
//       arrToReturn[i] = intersectionList.get(i);
//     }
//     return arrToReturn;
    
    
    
    
    
    
    /**
     * Approach 2: Using extra array
     * Firstly, we will have an array of size 1001 (say, numsArr), because the value will range from 1 - 1000.
     * Given constraint: 0 <= nums1[i], nums2[i] <= 1000
     * Then, we will traverse the nums1 array and with every number of nums1, 
     * we will increment the corresponding index's value of the numsArr.
     * Afterwards, we will traverse the value of nums2 and will find out if the numsArr's 
     * corresponding index has a value of more than 0.
     * If the value is more than 0, that indicates that the nums1 has the same value in it.
     * We will add the value of nums2 in an arraylist in this case
     * and decrement the value of the corresponding index of numsArr by 1.
     * After traversing the nums2 array we will convert the arraylist into an array and return the array.
     */
    
    int [] numsArr = new int [1001];
    ArrayList <Integer> intersectionList = new ArrayList<>();
      
    for (int i = 0; i < nums1.length; i++) {
      numsArr[nums1[i]]++;
    }

    for (int i = 0; i < nums2.length; i++) {
      if (numsArr[nums2[i]] > 0) {
        intersectionList.add(nums2[i]);
        numsArr[nums2[i]]--;
      }
    }

    int [] arrToReturn = new int [intersectionList.size()];
    for (int i = 0; i < intersectionList.size(); i++) {
      arrToReturn[i] = intersectionList.get(i);
    }
    return arrToReturn;
  }
}
