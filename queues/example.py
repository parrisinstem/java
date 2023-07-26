
class Node:
  def __init__(self, value, next_node=None):
    self.value = value
    self.next_node = next_node
    
  def set_next(self, next_node):
    self.next_node = next_node
    
  def get_next(self):
    return self.next_node
  
  def get_value(self):
    return self.value
  
class Queue:
  def __init__(self, max_size=None):
    self.head = None  # Initialize the head of the queue
    self.tail = None  # Initialize the tail of the queue
    self.max_size = max_size  # Maximum size of the queue
    self.size = 0  # Current size of the queue
    
  def enqueue(self, value):
    if self.has_space():  # Check if there is space in the queue
      item_to_add = Node(value)  # Create a new node with the given value
      print(f"Adding {item_to_add.get_value()} to the queue!")  # Print the value being added
      if self.is_empty():  # Check if the queue is empty
        self.head = item_to_add  # Set the head and tail to the new node
        self.tail = item_to_add
      else:
        self.tail.set_next(item_to_add)  # Set the next node of the tail to the new node
        self.tail = item_to_add  # Update the tail to the new node
      self.size += 1  # Increment the size of the queue
    else:
      print("Sorry, no more room!")  # Print a message if there is no more space in the queue
         
  def dequeue(self):
    if self.get_size() > 0:  # Check if the queue is not empty
      item_to_remove = self.head  # Get the node to remove from the head
      print(f"{item_to_remove.get_value()} is served!")  # Print the value being removed
      if self.get_size() == 1:  # Check if there is only one node in the queue
        self.head = None  # Set the head and tail to None
        self.tail = None
      else:
        self.head = self.head.get_next()  # Update the head to the next node
      self.size -= 1  # Decrement the size of the queue
      return item_to_remove.get_value()  # Return the value of the removed node
    else:
      print("The queue is totally empty!")  # Print a message if the queue is empty
  
  def peek(self):
    if self.size > 0:  # Check if the queue is not empty
      return self.head.get_value()  # Return the value of the head node
    else:
      print("No orders waiting!")  # Print a message if the queue is empty
  
  def get_size(self):
    return self.size  # Return the size of the queue
  
  def has_space(self):
    if self.max_size is None:  # Check if there is no maximum size
      return True
    else:
      return self.max_size > self.get_size()  # Compare the current size with the maximum

  def is_empty(self): #check if the queue is empty 
    return self.size == 0

print("Creating a deli line with up to 10 orders...\n------------")
deli_line = Queue(10)
print("Adding orders to our deli line...\n------------")
deli_line.enqueue("egg and cheese on a roll")
deli_line.enqueue("bacon, egg, and cheese on a roll")
deli_line.enqueue("toasted sesame bagel with butter and jelly")
deli_line.enqueue("toasted roll with butter")
deli_line.enqueue("bacon, egg, and cheese on a plain bagel")
deli_line.enqueue("two fried eggs with home fries and ketchup")
deli_line.enqueue("egg and cheese on a roll with jalapeos")
deli_line.enqueue("plain bagel with plain cream cheese")
deli_line.enqueue("blueberry muffin toasted with butter")
deli_line.enqueue("bacon, egg, and cheese on a roll")
# ------------------------ #
# Uncomment the line below:
deli_line.enqueue("western omelet with home fries")
# ------------------------ #
print("------------\nOur first order will be " + deli_line.peek())
print("------------\nNow serving...\n------------")
deli_line.dequeue()
deli_line.dequeue()
deli_line.dequeue()
deli_line.dequeue()
deli_line.dequeue()
deli_line.dequeue()
deli_line.dequeue()
deli_line.dequeue()
deli_line.dequeue()
deli_line.dequeue()
# ------------------------ #
# Uncomment the line below:
deli_line.dequeue()
# ------------------------ #