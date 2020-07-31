# Getting Started

### Introduction
iInvoice service expose APIs (HATEOAS) for read/save resources such as Invoice. Swagger-ui is rendered at runtime to make it easier to call APIs.


### Guides
Building jar file by maven
```sh
$ mvn clean install
```
Starting iInvoice instance with "dev" profile.
```sh
$ cd target
...
$ java -jar icom-invoice-{version}.jar --spring.profiles.active=dev
```
Access iInvoice by http://localhost:8004/swagger-ui.html

### Noted CURL
-Create an Invoice
```sh
curl -X POST "http://localhost:8004/invoice" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"customerName\": \"George Bane\", \"orderId\": \"order_id\", \"status\": \"init\", \"totalAmount\": 700}"
```
-Update Invoice Status to confirmed
```sh
curl -X PATCH "http://localhost:8004/invoice/invoice_id" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"status\": \"confirmed\"}"
```