tasking one: parking lot  

1. given a car   
   when parking car in space slot lot  
   then parked the car in this lot and got a ticket  
   
2. given a car   
   when parking lot is full  
   then the car can't park in the lot 

3. given a valid ticket  
   when take a car with the ticket  
   then take a car successfully.
   
4. given a invalid ticket  
   when take a car with the ticket  
   then take a car failure.  
   
   
   
tasking two: parking boy 

1.Given： 给定一辆车，和一个有空位的停车场
  When：小弟去停车
  Then：小弟找了一个空位，停好车，得到了小弟给的停车票

2.Given: 给定一辆车，和两个停车场，其中第一个停车场满了  
  When：小弟去停车  
  Then：小弟将车停在了第二个停车场的空位上，车停好了，得到了小弟给的停车票  

3.Given：给定一辆车，两个停车场，其中第一个停车场有空位  
  When：小弟去停车  
  Then：小弟将车停在第一个停车场的空位，得到了小弟给的停车票  

4.Given：给定一辆车，所有停车场都满了  
  When：小弟去停车  
  Then：小弟找不到有空位的停车场，无法停车  
  
5.Given：给定一个有效的停车票  
  When：小弟拿停车票去取车  
  Then：小弟取到车  

6.Given：给定一个有效的停车票  
  When：小弟拿停车票取车两次  
  Then：小弟第一次取到车，第二次取车失败  

7.Given：给定一个无效的停车票    
  When：小弟拿停车取车    
  Then：小弟取车失败  
  

tasking three: smart parking policy


1.given: 给定一个有空位的停车场  
  when：获取停车场  
  then：得到一个停车场
   
2.given：给定一个满的停车场    
  when：获取停车场    
  then：获取停车场失败    

3.given：给定两个满的停车场  
  when：获取停车场  
  then：获取停车场失败 
   
4.given：给定两个空位不等的停车场  
  when：获取停车场  
  then：获取空位最多的停车场  

5.given：给定两个空车位相等的停车场  
  when：获取停车场  
  then：获取第一个停车场  

   
tasking four：super parking policy
  
1.given: 给定一个有空位的停车场  
  when：获取停车场  
  then：得到一个停车场
   
2.given：给定一个满的停车场    
  when：获取停车场    
  then：获取停车场失败    

3.given：给定两个满的停车场  
  when：获取停车场  
  then：获取停车场失败 
  
4.given：给定两个空车率不等的停车场  
  when：获取停车场  
  then：获取空车率高的停车场  
  
5.given：给定两个空车率相等的停车场  
  when：获取停车场  
  then：获取第一个停车场    
