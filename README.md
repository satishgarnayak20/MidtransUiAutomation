# Assignment1
# website automation for Payment using credit card
# 1.This Project is Based on BDD framework with Junit
# 2.For this firefox broswer should be higher than V60 and for chrome any latest version should be fine.
# 3.After chcekout project please resolve dependencies by doing maven force update.
# 4.Java8 features  has been used so need to add java 8 along with all compartible jars as mentioned in pom.xml
# 5.For execution below are the ways you can execute-:
  # a.Using Junit Runner Class
  # b.Using Cucumber Feature file 
  # c.Using Maven test
# 6.For execution to make sure use Junit-4 version and JRE should be Jdk rather than Jre
# 7.For bdd report find the results inside target/bdd/index.html
# 8.To execute in chrome and firefox you need to set parameter in application.properties 
# ex-: for execution in firefox-: browser=firefox in aplication.properties file.
# 9.To execute feature file please run as feature file.
# 10.In feature file two scenarios are there-:
  # a-Purchase pillow from midtrans website with successful credit card payment
  # b-Purchase pillow from midtrans website with unsuccessful credit card payment
# 11.All test data is stored in application.properties and accessed by propertyManager by encodeing and decoding using Base64 from JavaUtils.

# Notes-: This midtrans website having some issue in chrome so it not proceeding for successful payment.but for firefox it is working as expected.


