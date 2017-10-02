# flightticketdetails

sample request url
http://localhost:8080/flightTickets/gettickets?src=CJB&dest=MAA&depDate=20171103&arrDate=20171104&totalTime=5h%200m

sample response objects description


{"src":"CJB","dest":"MAA","date":"20171103","departureTime":null,"economy":[{"route":["CJB","MAA"],"seatClass":"E","departTime":"15:10","arrivalDate":"2017-11-03t1615","arrivalTime":"16:15","totalTravelTime":"1h 5m","fare":"2235"},{"route":["CJB","MAA"],"seatClass":"E","departTime":"13:50","arrivalDate":"2017-11-03t1520","arrivalTime":"15:20","totalTravelTime":"1h 30m","fare":"1505"},{"route":["CJB","MAA"],"seatClass":"E","departTime":"20:45","arrivalDate":"2017-11-03t2205","arrivalTime":"22:05","totalTravelTime":"1h 20m","fare":"2345"},{"route":["CJB","MAA"],"seatClass":"E","departTime":"10:00","arrivalDate":"2017-11-03t1100","arrivalTime":"11:00","totalTravelTime":"1h 0m","fare":"2738"},{"route":["CJB","MAA"],"seatClass":"E","departTime":"15:45","arrivalDate":"2017-11-03t1645","arrivalTime":"16:45","totalTravelTime":"1h 0m","fare":"1268"},{"route":["CJB","MAA"],"seatClass":"E","departTime":"17:00","arrivalDate":"2017-11-03t1805","arrivalTime":"18:05","totalTravelTime":"1h 5m","fare":"1614"},{"route":["CJB","MAA"],"seatClass":"E","departTime":"23:35","arrivalDate":"2017-11-04t0035","arrivalTime":"00:35","totalTravelTime":"1h 0m","fare":"1268"},{"route":["CJB","MAA"],"seatClass":"E","departTime":"11:00","arrivalDate":"2017-11-03t1210","arrivalTime":"12:10","totalTravelTime":"1h 10m","fare":"2937"},{"route":["CJB","MAA"],"seatClass":"E","departTime":"21:15","arrivalDate":"2017-11-03t2220","arrivalTime":"22:20","totalTravelTime":"1h 5m","fare":"1247"},{"route":["CJB","MAA"],"seatClass":"E","departTime":"18:30","arrivalDate":"2017-11-03t1945","arrivalTime":"19:45","totalTravelTime":"1h 15m","fare":"1582"},{"route":["CJB","MAA"],"seatClass":"E","departTime":"08:35","arrivalDate":"2017-11-03t0955","arrivalTime":"09:55","totalTravelTime":"1h 20m","fare":"1582"},{"route":["CJB","MAA"],"seatClass":"E","departTime":"14:45","arrivalDate":"2017-11-03t1605","arrivalTime":"16:05","totalTravelTime":"1h 20m","fare":"1582"},{"route":["CJB","MAA"],"seatClass":"E","departTime":"12:10","arrivalDate":"2017-11-03t1330","arrivalTime":"13:30","totalTravelTime":"1h 20m","fare":"1582"}],"business":[{"route":["CJB","MAA"],"seatClass":"B","departTime":"15:10","arrivalDate":"2017-11-03t1615","arrivalTime":"16:15","totalTravelTime":"1h 5m","fare":"10403"}],"first":[]}


it is a maven project..

Clone this repo to your local and import as maven project into you workspace.

THis application is written in spring - java

So after loading your project run FlightticketdetailsApplication.java file as java application. it will start the application and tomcat server.

