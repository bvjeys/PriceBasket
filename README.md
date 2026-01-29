# Scala Programming based PriceBasket application for supermarket

# Prerequisite - Your Windows Environment should have JDK 8+ setup

# Steps to run the application in Windows Environment:

Step 1: Download GitHub Desktop for Windows and install it - https://desktop.github.com/download/

Step 2: Clone the Repository - https://github.com/bvjeys/PriceBasket.git
        After installing GitHub, right click in any folder and open git bash here to clone the repo

Step 3: Install sbt for running the program 
	Open https://www.scala-sbt.org/download/ , download and install - sbt-1.12.0.msi (Windows)

Step 4: Now, navigate into the cloned Repo - PriceBasket and open command Prompt, type sbt
	
	D:\project\PriceBasket> sbt

Step 5: To run the PriceBasket application, type as mentioned below
	
	sbt:PriceBasket> runMain com.pricebasket.application.com.shopping.PriceBasket Apples Milk Bread

# Kindly note, the Pound symbol is not properly displayed in command prompt. So, the output will be like 

[info] running com.pricebasket.application.com.shopping.PriceBasket Apples Milk Bread

Subtotal: ┬ú3.10
Apples 10% off: 10p
Total price: ┬ú3.00
[success] Total time: 0 s, completed 29-Jan-2026, 9:38:49 PM

You could run the same application in IntelliJ IDE which shows the Pound symbol properly. 
I have given the snapshot of the run using IntelliJ IDE
