# This project demonstrates the use of Mongo db to save and retrieve Jpegs,mp4 other data types using  springboot REST API and WEB.
1. MongdoDb has no fixed schema. So any dataset can be persisted in the same collection as a document.
2. Book controller is used to save and read the book information.
3. The method getRawData() in BookController uses Aggregation to aggregate all the raw data with different schemas and returns as 1 json response string.
4. Photo controller is used to save and read the photos in jpeg formats.
5. Photo controller is used to save and read the videos.
6. MongoTemplate is used by BookController tp perform crud operations.
7. PhotoController uses BsonBinarySubType.BINARY to save the photos. 
    While fetching the photos it converts the Bson binary byte[] to base 64 string and returns to the client.
8. VideoController uses BSON DBObject to save the videos. 
   GridFsTemplate is  to fetch the videos from mongo db.

# Configuring MongoDb CRUD operations in localhost
1. Add the below dependency in springboot application's pom.xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-data-mongodb</artifactId>
   </dependency>
2. Install MongoDB 7.0 Community Edition from : https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-os-x/
3. Use mongosh to interact with the db directly
4. Define the database in application.properties spring.data.mongodb.database=BookStore
5. Configure the entities with the collection name @Document(collection = "Book")
6. Boot the spring application on port 8989
7. Use web url http://localhost:8989/video/show to add a video and view it on adding
8. Use web urlhttp://localhost:8989/photo/show to add a photo and view it on adding

# Benefits NoSQL database like MongoDb
1. **_highly and easily scalable_**
Relational database or RDBMS databases are vertically Scalable When load increase on RDBMS database then we scale database by increasing server hardware power, need to by expensive and bigger servers and NoSQL databases are designed to expand horizontally and in Horizontal scaling means that you scale by adding more machines into your pool of resources.
2. _**Maintaining NoSQL Servers is Less Expensive**_
Maintaining high-end RDBMS systems is expensive and need trained manpower for database management but NoSQL databases require less management. it supports many Features like automatic repair, easier data distribution, and simpler data models make administration and tuning requirements lesser in NoSQL.
3. **_No Schema or Fixed Data model_**
NoSQL database is schema less so Data can be inserted in a NoSQL database without any predefined schema. So the format or data model can be changed any time, without application disruption. And change management is a big headache in SQL.


#MongoDB: The NoSQL Non-Relational Database

The following are some of MongoDB benefits and strengths:

• _**Dynamic schema**_: As mentioned, this gives you flexibility to change your data schema without modifying any of your existing data.

• **_Scalability_**: MongoDB is horizontally scalable, which helps reduce the workload and scale your business with ease.

  **_Manageability_**: The database doesn’t require a database administrator. Since it is fairly user-friendly in this way, it can be used by both developers and administrators.
     • Speed: It’s high-performing for simple queries. 
     • Flexibility: You can add new columns or fields on MongoDB without affecting existing rows or application performance.
  
# Reasons to Use a SQL Database
1. You need ACID compliancy (Atomicity, Consistency, Isolation, Durability). ACID compliancy reduces anomalies and protects the integrity of your database. It does this by defining exactly how transactions interact with the database, which is not the case with NoSQL databases, which have a primary goal of flexibility and speed, rather than 100% data integrity.
2. Your data is structured and unchanging:If your business is not growing exponentially, there may be no reason to use a system designed to support a variety of data types and high traffic volume.

#Reasons to Use a NoSQL Database
1. Storing large volumes of data without structure. A NoSQL database doesn’t limit storable data types. Plus, you can add new types as business needs change.
2. Using cloud computing and storage. Cloud-based storage is a great solution, but it requires data to be easily spread across multiple servers for scaling. Using affordable hardware on-site for testing and then for production in the cloud is what NoSQL databases are designed for.
3. Rapid development. If you are developing using modern agile methodologies, a relational database will slow you down. A NoSQL database doesn’t require the level of preparation typically needed for relational databases.