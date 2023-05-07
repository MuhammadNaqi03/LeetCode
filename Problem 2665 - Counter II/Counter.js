/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
const createCounter = function(init) {
  let count = init
  const increment = function() {
    count = count + 1;
    return count;
  }

  const decrement = function() {
    count = count - 1;
    return count;
  }

  const reset = function() {
    count = init;
    return count;
  }

  return {
    increment,
    decrement,
    reset,
  }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */
