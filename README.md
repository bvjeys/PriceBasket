# Scala Program based PriceBasket application
# About the application:
The application calculates the subtotal and the Total price when you pass the Items as an argument to the application.
Subtotal is without the offer price
If there are any offers on the Items automatically the offers will be applied
The Total price gives you the value after applying the discount on the actual Item Price

# Prerequisite - 
Step 1: Your Windows Environment should have JDK 8+ setup, if not please install JDK 8+

Step 2: Download GitHub Desktop for Windows and install it - https://desktop.github.com/download/

Step 3: Clone the Repository - https://github.com/bvjeys/PriceBasket.git
        After installing GitHub, right click in a folder and open git bash here to clone the repo

# Steps to run the application in Windows Environment using SBT:

Step 1: Install sbt for running the program 
	Open https://www.scala-sbt.org/download/ , download and install - sbt-1.12.0.msi (Windows)

Step 2: Now, navigate into the cloned Repo - PriceBasket and open command Prompt, type "sbt" . It will launch sbt for you to run the application. 
	
	sbt

Step 3: To run the PriceBasket application, type command as mentioned below, PriceBasket is the main object name followed by arguments(Items)
	
	runMain com.pricebasket.application.com.shopping.PriceBasket Apples Milk Bread

# Kindly note, the Pound symbol is not properly displayed in command prompt. So, the output will be like 

[info] running com.pricebasket.application.com.shopping.PriceBasket Apples Milk Bread

Subtotal: ┬ú3.10

Apples 10% off: 10p

Total price: ┬ú3.00

[success] Total time: 0 s, completed 29-Jan-2026, 9:38:49 PM

You could run the same application in IntelliJ IDE which shows the Pound symbol properly. 
I have attached - Application_Executed_Output.jpg the snapshot of the run output using IntelliJ IDE

Steps to run the application in Windows Environment using IntelliJ IDE:

Step 1: Download and install IntelliJ IDE - https://www.jetbrains.com/idea/download/

Step 2: After installing the IDE, navigate to the cloned repository PriceBasket and right-click and open the build.sbt with IntelliJ IDE

Step 3: In IDE, go to setting -> Plugins -> Search Scala and Install from the MarketPlace

Step 4: In IDE, go to Project Structure -> Project -> Select the JDK which you have installed

Step 5: In IDE, go to Project Structure -> Global Libraries -> Click + to installed Scala SDK 2.11.12 version

Step 6: Then, in the project navigate to PriceBasket.scala and run it
	Main Class - 
		com.pricebasket.application.com.shopping.PriceBasket
	Arguments - 
		Apple Milk Bread

The output of IntelliJ IDE will be 

"C:\Program Files\Java\jdk-10.0.2\bin\java.exe" "-javaagent:C:\Users\HP\AppData\Local\Programs\IntelliJ IDEA 2025.3.2\lib\idea_rt.jar=58693" -Dfile.encoding=UTF-8 -classpath D:\project\PriceBasket\target\scala-3.3.7\classes;C:\Users\HP\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.7\scala3-library_3-3.3.7.jar;C:\Users\HP\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.16\scala-library-2.13.16.jar com.pricebasket.application.com.shopping.PriceBasket Apples Milk Bread
Subtotal: £3.10
Apples 10% off: 10p
Total price: £3.00
