/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
const filter = function(arr, fn) {
  const returnArr = [];
  let returnArrIndex = 0;
  for (let i = 0; i < arr.length; i++) {
    if (fn(arr[i], i)) { // Filter the elements that satisfy the condition given in the function
      returnArr[returnArrIndex++] = arr[i];
    }
  }
  return returnArr;
};
