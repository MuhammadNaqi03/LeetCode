type Fn = (accum: number, curr: number) => number

function reduceTS(nums: number[], fn: Fn, init: number): number {
  let accumulator = init;
  nums.forEach(num => accumulator = fn (accumulator, num));
  return accumulator;
};
