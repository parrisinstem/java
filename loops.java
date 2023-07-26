import java.util.ArrayList;

class Lunch {
 
  public static ArrayList<String> removeAnts(ArrayList<String> lunchBox) {
  // terates through the elements 
    for (int i = 0; i < lunchBox.size(); i++) {
        // if the element at index 'i' is equal to the string "ant".
        if (lunchBox.get(i) == "ant") {
            // remove it from the ArrayList 
            // decrement 'i' to avoid skipping the next element.
            lunchBox.remove(lunchBox.get(i));
            i--; // Decrement 'i' to stay at the same index in the next iteration.
        }
    }
   
      // start iterating from the beginning of the ArrayList.
    int i = 0;
    
    // While 'i' is less than the size of the ArrayList
    while (i < lunchBox.size()) {
        // if the element at index 'i' is equal to the string "ant".
        if (lunchBox.get(i).equals("ant")) {
            // remove it from the ArrayList using the "remove" method.
            lunchBox.remove(lunchBox.get(i));
        } else {
            // move to the next element by incrementing 'i'.
            i++;
        }
    }
    return lunchBox;

  }
 
  
  public static void main(String[] args) {
    ArrayList<String> lunchContainer = new ArrayList<String>();
    lunchContainer.add("apple");
    lunchContainer.add("ant");
    lunchContainer.add("ant");
    lunchContainer.add("sandwich");
    lunchContainer.add("ant");
    lunchContainer = removeAnts(lunchContainer);
    System.out.println(lunchContainer);



  }
}
