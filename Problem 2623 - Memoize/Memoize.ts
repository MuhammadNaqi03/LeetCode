type Fn = (...params: any) => any

function memoizeTS(fn: Fn): Fn {
  const memory : Record<string, number> = {};
  return function(...args) {
    let key = '';
    for (let arg of args) {
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
