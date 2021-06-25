# Npp-Telda-test-task

REST service example with H2 database, MyBatis, Caching. 

Table conisits of id, name of region and short name of this region. It is possible to create, delete, update and get any region from database. Logging shows that caching works and allows not to request data from database if it has already beed fetched before.

Here links to test the application. I used Postman for it:

1) Get all regions from database
http://localhost:8889/region/all

2) Create new region in database
http://localhost:8889/region/new?region=Moscow&shrt=Msc

3) Delete region by id 
http://localhost:8889/region/delete/{id}

4) Get region by id
http://localhost:8889/region/get/{id}

5) Update region by id
http://localhost:8889/region/update/{id} 

My remarks: Lack of tests and no container.
