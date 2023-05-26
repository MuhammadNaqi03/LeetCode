/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
const chunk = function(arr, size) {
  let chunkedArr = [];
  for (let i = 0; i < arr.length; i = i + size) {
    chunkedArr.push(arr.slice(i, i + size));
  }

  return chunkedArr;
};
