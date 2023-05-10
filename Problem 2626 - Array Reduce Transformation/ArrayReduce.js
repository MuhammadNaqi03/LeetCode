/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
const reduce = function(nums, fn, init) {
  let accumulator = init;
  nums.forEach(num => accumulator = fn (accumulator, num));
  return accumulator;
};
