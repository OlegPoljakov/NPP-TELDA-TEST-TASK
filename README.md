# Npp-Telda-test-task

REST service example with H2 database, MyBatis, Caching. 

Table conisits of id, name of region and short name of this region. It is possible to create, delete, update and get any region from database. Logging shows that caching works and allows not to request data from database if it has already beed fetched before.

H2 database:
username=admin
password=password

Database connection window:

![image](https://user-images.githubusercontent.com/46780464/123412210-05085e80-d5ba-11eb-9f31-95b1cb49b546.png)


Here links to test the application. I used Postman for it:

1) Get all regions from database (Get Mapping)
http://localhost:8889/region/all

2) Create new region in database (Get Mapping)
http://localhost:8889/region/new?region=Moscow&shrt=Msc

3) Delete region by id (Delete Mapping)
http://localhost:8889/region/delete/{id}

4) Get region by id (Get Mapping)
http://localhost:8889/region/get/{id}

5) Update region by id (Get Mapping)
http://localhost:8889/region/update/{id}?region=Murmansk&shrt=Mrm

My remarks: Lack of tests and no container. I'm going to make it a little bit later, at least for experience purpose.
