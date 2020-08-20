# Order Management Service 

Consist of two microservices : OrderItemService , OrderService 

Both microservices maintains their own databases where they maintain data related Order and Item seperately .

OrderService uses FeignClient to interact with OrderItemService which create/retrive data in Item database.

OrderService and OrderItemService are independent applications i.e  OrderService can create an Order without any Items attached to it and OrderItemService can create an item without any order reference. However they maintain association with <b>orderId </b>

Both applications have a TestFile to have a test run on application (it should pass only first time)


# How to run OrderManagementService

1) Clone the two repositories : 
https://github.com/adarshagar211/OrderItemService
https://github.com/adarshagar211/OrderService

2) Import these two projects in local workspace

3) Allow jars to be downloaded and project to build with no error. 

4) Run  src/main/java/com/oms/OrderServiceApplication.java  and src/main/java/com/oms/OrderItemApplication.java  to run both microservices on your local

5) Run src/test/java/com/oms/OrderItemApplicationTests.java  and src/test/java/com/oms/OrderServiceApplicationTests.java as JunitTest to perform Test run of applications.

6) If testcases run fine then applications should be up and running conditions .   
