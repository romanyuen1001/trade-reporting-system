# Trade Reporting System 💹

The Trade Report Generator is a Java application designed to generate detailed reports for various types of trades. This project supports multiple trade types through the use of a common interface, allowing for flexibility and extensibility.

## Requirements 📂
1. Java 21
2. Maven 
3. Spring Boot

## Steps to Setup 🌐
**1. Download the zip file or clone the repository**
```bash
git clone https://github.com/romanyuen1001/trade-reporting-system.git
```

**2. Run the app using Maven**
```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>.

## Explore Rest APIs 🔗

The app defines the following CRUD APIs.
  
    GET localhost:8080/api/reports/:productType/:brokerName (Reports by type of product and name of broker)
    
You can test them using Postman or any other rest client.

## Screenshots of APIs call 📷
<img width="1125" alt="image" src="https://github.com/user-attachments/assets/dc2a18f6-ac54-4d15-b327-9179ad83eee4">
<img width="1125" alt="image" src="https://github.com/user-attachments/assets/e07446ca-3b75-4e03-b785-0b3dc96bdfbd">

## Possible improvements / out of scope ✨ 
It is coming, stay tuned.

## Thankyou 🤗
Thank you for taking the time to explore my project. I hope you find them informative and useful in learning Java and enhancing your programming skills.

