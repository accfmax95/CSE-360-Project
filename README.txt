This is a quick rundown of all everything i've done so far. Feel free to add/remove/change whatever is neccessary. Customers are pretty functional right now, being able to add, remove items from their cart and create orders. estimated wait time and users ahead are also calculated. Items can be created, but there isn't any backend menu functionality yet. Employees also don't have any functionality yet.

I made 8 classes:

User:
	base class which has basic information like username, password, and phone number. customers and employees inherit from this
	class. Each user has a type id so the program can determine if the user is a customer or employee. Customers are hardcoded 	
	to 1 and employees are hard coded to 0. if there's a better way to do this feel free to change it.
Customer: 
	customers inherit from User, and have a Linked List of items as their current shopping cart, and a linked list of orders
	showing all of the orders that user has made. both are EMPTY when a customer is created.
Employee:
	employees don't have any functionality yet. in the future they will be able to add, edit, or remove items from the menu, 
	and give coupons out to customers

Item: 
	items can be created using this class. each item has a linked list of ingredients, which are strings. each item has a price 		and a name
Menu:
	takes all of the item info from a text file and creates a menu object? (editable by employee?)
Order:
	each order has an id, which starts from 0 and increments for each order created. it has the cart, a total price, and 	calculates users ahead and estimated time. estimated time increments by 10 minutes per order and users ahead increments 
	by 1
CreditCard:
	class to hold user credit card information, each customer should have one which is initialized to null. When they make an 	
	order it can be set when they put their information in.
test:
	test class with main method to demo what i have done so far

