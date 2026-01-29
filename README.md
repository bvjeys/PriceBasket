# Scala Program based PriceBasket application
# About the application:
The application calculates the subtotal and the Total price when you pass the Items as an argument to the application.
Subtotal is without the offer price
If there are any offers on the Items automatically the offers will be applied
The Total price gives you the value after applying the discount on the actual Item Price

# Prerequisite - Your Windows Environment should have JDK 8+ setup

# Steps to run the application in Windows Environment using SBT:

Step 1: Download GitHub Desktop for Windows and install it - https://desktop.github.com/download/

Step 2: Clone the Repository - https://github.com/bvjeys/PriceBasket.git
        After installing GitHub, right click in a folder and open git bash here to clone the repo

Step 3: Install sbt for running the program 
	Open https://www.scala-sbt.org/download/ , download and install - sbt-1.12.0.msi (Windows)

Step 4: Now, navigate into the cloned Repo - PriceBasket and open command Prompt, type "sbt" . It will launch sbt for you to run the application. 
	
	sbt

Step 5: To run the PriceBasket application, type command as mentioned below, PriceBasket is the main object name followed by arguments(Items)
	
	runMain com.pricebasket.application.com.shopping.PriceBasket Apples Milk Bread

# Kindly note, the Pound symbol is not properly displayed in command prompt. So, the output will be like 

[info] running com.pricebasket.application.com.shopping.PriceBasket Apples Milk Bread

Subtotal: ┬ú3.10

Apples 10% off: 10p

Total price: ┬ú3.00

[success] Total time: 0 s, completed 29-Jan-2026, 9:38:49 PM

You could run the same application in IntelliJ IDE which shows the Pound symbol properly. 
I have attached - Application_Executed_Output.jpg the snapshot of the run output using IntelliJ IDE
