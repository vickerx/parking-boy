tasking one:

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
   
   
   
tasking two:

1.Given： 给定一辆车  
  When：小弟找了一个还有空位停车场，将车停在了空位上
  Then：车停好了，得到了小弟给的停车票

2.Given: 给定一辆车，第一个停车场满了  
  When：小弟找老板要了个空停车场，将车停在了空位上  
  Then：车停好了，得到了小弟给的停车票；停车票记录车所在停车场及空位  

3.Given： 给定一辆车，第一个停车场有空位了  
  When：小弟将车停在第一个停车场的空位
  Then： 车停好了，得到了小弟给的停车票

4.Given： 给定一辆车，所有停车场都满了  
  When：小弟找不到有空位的停车场，无法停车  
  Then：
  
5.Given： 给定一个停车票
  When：小弟拿着停车票将车从停车场取出来
  Then：
  
  
  
  
 tasking three:
 
1.given: 给定一辆车，一个有空位停车场  
  when：小弟将车停在停车场的空位上  
  then：车停好了，得到小弟给的停车票
   
2.given：给定一辆车，一个没有空位的停车场  
  when：小弟来停车  
  then： 没有空位，无法停车  

3.given：给定一辆车，两个空位不等的停车场  
  when：小弟来停车  
  then：小弟选择一个空车位多的停车场，停好车，得到小弟的停车票  

4.given：给定一辆车，两个空车位相等的停车场  
  when：小弟来停车，  
  then：小弟选择第一个停车场，停好车，得到小弟的停车票  
  
5.given：给定一个停车票   
  when：小弟拿停车票来取车  
  then：小弟取好车  

6.given：给定一个非法停车票  
  when：小弟拿停车票来取车  
  then：小弟取不到车    

7.given：给定一个停车票  
  when：小弟拿停车票来取了两次车  
  then：小弟第一次取车成功，第二次驱车失败  
  
tasking four

1.given: 给定一辆车，一个有空位停车场  
  when：小弟将车停在停车场的空位上  
  then：车停好了，得到小弟给的停车票
   
2.given：给定一辆车，一个没有空位的停车场  
  when：小弟来停车  
  then： 没有空位，无法停车  

3.given：给定一辆车，两个空置率不等的停车场  
  when：小弟来停车  
  then：小弟选择一个空置率高的停车场，停好车，得到小弟的停车票  

4.given：给定一辆车，两个空置率位相等的停车场  
  when：小弟来停车，  
  then：小弟选择第一个停车场，停好车，得到小弟的停车票  
  
5.given：给定一辆车，两个满的停车场
  when：小弟来停车  
  then：停车失败 
  
6.given：给定一个有效的停车票   
  when：小弟拿停车票来取车  
  then：小弟取好车  

7.given：给定一个非法停车票  
  when：小弟拿停车票来取车  
  then：小弟取不到车    

8.given：给定一个有效的停车票  
  when：小弟拿停车票来取了两次车  
  then：小弟第一次取车成功，第二次取车失败  
