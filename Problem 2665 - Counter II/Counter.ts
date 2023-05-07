type ReturnObj = {
  increment: () => number,
  decrement: () => number,
  reset: () => number,
}

function createCounterTS(init: number): ReturnObj {
let count = init
const increment = function(): number {
  count = count + 1;
  return count;
}

const decrement = function(): number {
  count = count - 1;
  return count;
}

const reset = function(): number {
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
