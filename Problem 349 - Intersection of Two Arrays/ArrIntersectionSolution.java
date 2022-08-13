class ArrIntersectionSolution {
  public int[] intersection(int[] nums1, int[] nums2) {
    /**
      * Approach 1: Using Hashset
      * Approach is simple, first we will insert all the elements of first array into a hashset.
      * Afterwards, we will find out if the second array has those numbers and put it in an arraylist.
      * Have to check if the element is already inside the arraylist before insertion, as the result has to be unique.
      * Convert the arraylist into an array and return.
      * We don't need to check for empty arrays as per constraint:
      * 1 <= nums1.length, nums2.length <= 1000
      */
    
//     HashSet <Integer> set = new HashSet<>();
//     for (int num: nums1) {
//       set.add(num);
//     }

//     ArrayList<Integer> intersect = new ArrayList<>();
//     for (int num: nums2) {
//       if (set.contains(num) & !intersect.contains(num)) {
//         intersect.add(num);
//       }
//     }
    
//     if (intersect.size() == 0) {
//       return new int[]{};
//     }

//     int [] returnedArr = new int [intersect.size()];
//     for (int i = 0; i < returnedArr.length; i++) {
//       returnedArr[i] = intersect.get(i);
//     }
//     return returnedArr;




    
    /**
      * Approach 2: Using two pointers
      * Firstly, we have to sort both arrays.
      * After that, we will use one pointer for first array and another pointer for second array.
      * We will compare the two pointers value and if we the two pointers point to the same value,
      * we will add that into a hashset and move both pointers.
      * (Adding in arraylist will also work but we have to compare if the number is present already 
      * which we did in approach 1, so yeah lets use set this time).
      * If one pointer's value is less than the other one, we will move the less one to the right.
      * Convert the hashset into an array and return the array.
      */

    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int firstPointer = 0;
    int secondPointer = 0;
    HashSet <Integer> intersectionSet = new HashSet<>();

    while (firstPointer < nums1.length && secondPointer < nums2.length) {
      if (nums1[firstPointer] == nums2[secondPointer]) {
        intersectionSet.add(nums1[firstPointer]);
        firstPointer++;
        secondPointer++;
      } else if (nums1[firstPointer] < nums2[secondPointer]) {
        firstPointer++;
      } else {
        secondPointer++;
      }
    }

    if (intersectionSet.size() == 0) {
      return new int[]{};
    }

    int [] returnedArr = new int [intersectionSet.size()];
    int i = 0;
    for (int num: intersectionSet) {
      returnedArr[i++] = num;
    }
    return returnedArr;
  }
}
