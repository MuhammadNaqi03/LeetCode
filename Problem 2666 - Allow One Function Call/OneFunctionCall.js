/**
 * @param {Function} fn
 * @return {Function}
 */

// Approach 1: Mutating the given function
// const once = function(fn) {
//   return function(...args){
//     const val =  fn(...args);
//     // Change the given function
//     fn = function(...args) {
//       // Do nothing, as functions return undefined by default
//     }
//     return val;
//   }
// };




// Approach 2: Using a flag
const once = function(fn) {
  let calledAlready = false;
  return function(...args){
    if (!calledAlready) {
      calledAlready = true;
      return fn(...args);
    }
    // By default, undefined will be returned
  }
};


/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */
