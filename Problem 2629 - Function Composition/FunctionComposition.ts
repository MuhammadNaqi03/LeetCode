type F = (x: number) => number;

function composeTS(functions: F[]): F {
	return function(x) {
    let currX = x;
    for(let i = functions.length - 1; i >= 0; i--) {
      const currFunction: F = functions[i];
      currX = currFunction(currX);
    }
    return currX;
  }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */
