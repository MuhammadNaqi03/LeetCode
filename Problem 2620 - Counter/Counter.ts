function createCounterTS(n: number): () => number {
  return () => n++;
}

/** 
 * const counter = createCounterTS(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */
