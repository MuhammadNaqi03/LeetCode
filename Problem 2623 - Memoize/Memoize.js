/**
 * @param {Function} fn
 */

/**
 * Approach:
 * The problem is fairly straighforward.
 * It tells us to store the previous results and return them if the arguments are the same.
 * Now, we could've used array if there is only one argument (which is a number)
 * and used that argument as an index for our array.
 * Sadly, there are two arguments for the "sum" function.
 * We could've used the two numbers sum as an index as well,
 * but the number could get pretty big. Also, from the test cases, it is apparent that
 * sum(a,b) and sum(b,a) both call the function once, even though they produce the same output.
 * So, we'll use an object here and use the argument(s) as keys after turning those into a string.
 * We have to put a separator between the arguments; otherwise, two different arguments may
 * produce the same key. (For example, sum([101,1]), and sum[10,11]).
 */
function memoize(fn) {
  const memory = {};
  return function(...args) {
    let key = '';
    for (let arg of args) { // args is an array of passed argument(s)
      key = key + '#' + arg;
    }

    if (memory[key] !== undefined) {
      return memory[key];
    }

    const val = fn (...args);
    memory[key] = val;
    return val;
  }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */
