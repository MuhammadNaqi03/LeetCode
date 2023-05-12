function onceTS<T extends (...args: any[]) => any>(fn: T): 
 ((...args: Parameters<T>) => ReturnType<T> | undefined) {
  let calledOnce = false;
  return function (...args) {
    if(!calledOnce) {
      calledOnce = true;
      return fn(...args);
    }
    // By default, undefined will be returned
  };
}

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */
