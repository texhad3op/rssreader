To run the application please execute these steps:<br>
1. Run command line.<br>
2. Clone repository to your local machine: git clone https://github.com/texhad3op/rssreader.git<br>
3. In MySql create user root:rootpassword.<br>
4. In MySql create schema "feeds".<br>
5. Execute dump.sql file in MySql command line tool.<br>
6. Change folder to created by git: cd rssreader<br>
7. Run command: mvn clean install<br>
8. Copy file rssreader\target\rssreader.war to <tomcat_folder>\webapps<br>
9. Run tomcat<br>
10. Application is available on address: http://localhost:8080/rssreader/