To run the application please execute these steps:
1. Run command line.
2. Clone repository to your local machine: git clone https://github.com/texhad3op/rssreader.git
3. In MySql create user root:rootpassword.
4. In MySql create schema "feeds".
5. Execute dump.sql file in MySql command line tool.
6. Change folder to created by git: cd rssreader
7. Run command: mvn clean install
8. Copy file rssreader\target\rssreader.war to <tomcat_folder>\webapps
9. Run tomcat
10. Application is available on address: http://localhost:8080/rssreader/