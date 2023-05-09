function filterTS(arr: number[], fn: (n: number, i: number) => any): number[] {
  const returnArr: number[] = [];
  let returnArrIndex = 0;
  for (let i = 0; i < arr.length; i++) {
    if (fn(arr[i], i)) { // Filter the elements that satisfy the condition given in the function
      returnArr[returnArrIndex++] = arr[i];
    }
  }
  return returnArr;
};
