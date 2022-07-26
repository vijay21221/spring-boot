# Microservice Communication using rest template.
* Service discovery pattern using Eureka
      Annotations used @EnableEurekaServer, @EnableEurekaClient, @LoadBalanced
      
 # Microservices communication with fault tolerance and resilience
 Can be achived in three ways
 * **Multiple instances of single microservice**
 * **Using Time out** (when micro service takes more time to respond back when called by other microservice, 
        all the request handling threads will be accumulated and new requests will not be honored or the microservice will be crashed so to handle this scenario we can add time out in calling microservice
        but still the issue is not fixed here if the microservice makes more request during the time out period then also more threads will be accumulated and waiting for response, so to fix this the better approach is circuit breaker pattern) 
 * **Circuit breaker pattern** (using hystrix - Hystrix is a library that controls the interaction between microservices to provide latency and fault tolerance. )
      https://www.javatpoint.com/fault-tolerance-with-hystrix#:~:text=Hystrix%20is%20a%20library%20that,or%20would%20take%20more%20time.
 * **Bulkhead pattern**
 
  
  
 
