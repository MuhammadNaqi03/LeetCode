class BrowserHistorySolution {
  /**
   * Approach: Using Stack
   * We'll use two stacks for the solution: one for tracking the current urls (currStack)
   * and another one for saving the history (historyStack) of the urls.
   * The currStack will hold the urls until the 'back' button is pressed,
   * and the historyStack will hold the urls after the back button is pressed.
   * Two important things are: the currStack will have at least one element (the 'homepage') and
   * whenever a new url is given for 'visit' the historyStack has to be cleaned.
   *
   * So, for the 'visit' method, we'll just put the url into the currStack and clean the historyStack.
   *
   * For the 'back' method, we first need to find the current size of the stack.
   * Afterwards, until the minimum between the given 'steps' and currStack.size() - 1 is reached,
   * we'll pop the elements from currStack and put them into historyStack.
   * We can't remove the homepage, thus we'll loop until the minimum between the 'steps' and currStack.size() - 1.
   * We then have to return the top element of the currStack to represent the current url.
   *
   * And lastly, for the 'forward' method, we will loop until we reach the given 'steps'.
   * Within the loop, we'll pop the elements from historyStack and put them back in the currStack.
   * If, within the loop, the historyStack becomes empty, we'll return the top element of the currStack
   * (as the current url is at the top of the currStack).
   * Otherwise, we'll return the last popped element from historyStack.
   */

  Stack <String> currStack  = new Stack<>();
  Stack <String> historyStack  = new Stack<>();
  public BrowserHistory(String homepage) {
    currStack.push(homepage);
  }
    
  public void visit(String url) {
    currStack.push(url);
    if (!historyStack.isEmpty()) {
      historyStack.clear();
    }
  }
    
  public String back(int steps) {
    int currStep = 0;
    int stackSize = currStack.size();
    while (currStep < Math.min(steps, stackSize - 1)) {
      currStep += 1;
      historyStack.push(currStack.pop());
    }
    return currStack.peek();
  }
    
  public String forward(int steps) {
    int currStep = 0;
    String currUrl = "";
    while (currStep < steps) {
      if (historyStack.isEmpty()) {
        return currStack.peek();
      }

      currStep += 1;
      currUrl = historyStack.pop();
      currStack.push(currUrl);
    }
    return currUrl;
  }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
