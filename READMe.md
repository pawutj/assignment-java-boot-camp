## Assignments for Java Boot Camp

- [Week 1 :: Design and Develop RESTful API with Spring Boot](https://github.com/up1/assignment-java-boot-camp/wiki/Week-01)

## Project Task

https://github.com/pawutj/assignment-java-boot-camp/projects/1

## User Flow

0. ในระบบ มี "product1" และ "product2" มี User มาใช้ระบบ โดยมี UserId = 0

1. User ต้องการค้นหาสินค้าที่มี "product" ในชื่อ  
   User พบสินค้า "product1" , "product2"
2. User ต้องการรายละเอียดของ "product1" จึงกดเข้า detail ของ "product1"  
   User ทราบราคาของ "product1" = 20 บาท
3. User ต้องการซื้อ "product1" จึงนำ "product1" ใส่ Basket  
   User นำ "product1" ใส่ Basket ที่มี UserId = 0 เป็นจำนวน 2 ea.
4. User เลือกสินค้าที่ต้องการครบแล้ว จึงต้องการเช็คสินค้าใน Basket  
   User ค้นหา Basket ที่มี UserId = 0 ได้ พบว่ามี "product1" จำนวน 2 ea.
5. เมื่อตรวจสินค้าแล้ว User ต้องการซื้อสินค้านั้น จึงย้ายสินค้าใน Basket ไปอยู่ใน Order(ใบสั่งซื้อ)  
   User สร้าง Order ที่มี UserId = 0 มี "product1" จำนวน 2ea. และเมื่อย้ายสินค้าลงใบสั่งซื้อแล้ว Basket ที่มี UserId = 0 ต้องว่างเปล่า
6. เมื่อ User ได้ใบสั่งซื้อแล้ว ต้องกรอก Address(ที่อยู่)  
   User กรอกที่อยู่ ให้ชื่อผู้รับเป็น "testAddress"
7. User ต้องกรอก Payment(วิธีการชำระค่าสินค้า)  
   User กรอก Payment ให้ชื่อผู้จ่ายเป็น "testPayment"
8. User ต้องชำระค่าสินค้าผ่าน 3rd Party  
   Backend ต้องตรวจสอบกับ 3rd Party ว่า OrderId นี้ มีการจ่ายเงินจริงหรือไหม
9. User เมือชำระสินค้าแล้ว User ต้องการทราบใบเสร็จ  
   User ต้องเรียกดู OrderSummary(ใบเสร็จ) ที่มี Payment และAmount(ราคารวม)ได้

## Integrated test

- flowTest_FindProductAndChosenProduct  
  ขั้นตอนที่ 1,2
- flowTest_AddProductToBasketAndShowBasketAndCheckout  
  ขั้นตอนที่ 3,4,5
- testFlow_AddAddressAddPayment  
  ขั้นตอนที่ 6,7
- testFlow_ConfirmOrderGetOrderSummary  
  -ขั้นตอนที่ 8,9

## Entity

- Product : productName , price
- Basket : products , userId
- Address : email , name ,address ,order
- Payment : name , transactionDate, expiredDate payee,detail
- Order : products , userId , address , payment , orderStatus
- OrderSummary : amount , payment

## API

| Method | Url                                           | Description                                   | Valid Request Body | Valid Response Body |
| ------ | --------------------------------------------- | --------------------------------------------- | ------------------ | ------------------- |
| GET    | "/product/findProductsByName/{productname}"   | find products contain productname             | -                  | Product             |
| GET    | "/product/findProductById/{productId}"        | find product by id                            | -                  | Product             |
| POST   | "/basket/addProductToBasketByUserId/{userId}" | add Product to Basket By UserId               | Product            | Basket              |
| GET    | "/basket/findBasketByUserId/{userId}"         | find Basket By UserId                         | -                  | Basket              |
| GET    | "/order/checkout/{userId}                     | create Order , Add Product in Basket to Order | -                  | Order               |
| POST   | "/order/setAddressById/{orderId}"             | set Address By orderId                        | Address            | Order               |
| POST   | "/order/setPaymentById/{orderId}"             | set Payment By orderId                        | Payment            | Order               |
| GET    | "/order/checkIsPaid/{orderId}"                | Check order is paid from 3rd party            | -                  | Order               |
| GET    | "/order/getOrderSummary/{orderId}"            | find Order Summary by orderId                 | -                  | OrderSummary        |

## Start & Test

> mvnw spring-boot:run  
> mvnw clean test

## Resources

- [Spring Boot Reference](https://spring.io/projects/spring-boot)
- https://www.baeldung.com/
- https://start.spring.io/
- [Git commit message](https://www.conventionalcommits.org/en/v1.0.0/)
