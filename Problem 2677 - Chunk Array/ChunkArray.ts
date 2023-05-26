function chunkTS(arr: any[], size: number): any[][] {
  let chunkedArr: any[] = [];
  for (let i = 0; i < arr.length; i = i + size) {
    chunkedArr.push(arr.slice(i, i + size));
  }

  return chunkedArr;
};

