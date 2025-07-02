# Description
Adyen Drop-in Payment Integration Demo
A full-stack demonstration of the Adyen Drop-in payment flow, built with a Java/Spring Boot backend.

Technology Stack
Backend: Java 17, Spring Boot 3, Maven, Adyen Java API Library
Frontend: HTML5, CSS, JavaScript

## How to Run
1. Prerequisites
JDK 17 or higher
Apache Maven 3.6 or higher

2. config

Define the variables in the `application.properties`.
```txt
ADYEN_API_KEY=yourAdyenApiKey
ADYEN_MERCHANT_ACCOUNT=yourAdyenMerchantAccount
ADYEN_CLIENT_KEY=yourAdyenClientKey
```


3. Launch
From the project's root directory, run:
```
mvn spring-boot:run

```
Visit [http://localhost:8080/](http://localhost:8080/).

Click Select on a product.

On the cart page, click Pay with Adyen.

Use an Adyen Test Card(https://docs.adyen.com/development-resources/test-cards/test-card-numbers) to complete the payment. 

Observe the redirection to the final result page.




