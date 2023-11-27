## Project Structure

This is the structure of the application

- app
  - controllers (serves the page + apis)
  - Dtos (server validation + map models to the UI)
  - interfaces
  - models (database table models)
  - respositories (using persistance library to communicate with database)
  - services (implementation of interfaces)
- resources
  - static (images are there)
  - templates(home html page and registration html page)

## Setup

1.  Run the following script in your mysql database

>     CREATE DATABASE aeroparker;
>     USE aeroparker;
>
>     CREATE TABLE customers (
>         id INT AUTO_INCREMENT PRIMARY KEY,
>         registered TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
>         email_address VARCHAR(255) UNIQUE NOT NULL,
>         title VARCHAR(5) NOT NULL,
>         first_name VARCHAR(50) NOT NULL,
>         last_name VARCHAR(50) NOT NULL,
>         address_line_1 VARCHAR(255) NOT NULL,
>         address_line_2 VARCHAR(255),
>         city VARCHAR(255),
>         postcode VARCHAR(10) NOT NULL,
>         phone_number VARCHAR(20)
>     );

2. Go to the src/main/java/com/interview/app/resources/application.properties file and change the connection string, username and password for your database

>     spring.datasource.url=[CON STRING]
>     spring.datasource.username=[USERNAME]
>     spring.datasource.password=[PASSWORD]
>
> 3. Run the project.

## Challanges

- Using java spring for the first time
- Setting up the first project and running it was a bit of challange. I was confuse between graddle and maven option (it seems like the different is the xml/json format difference, but i might be wrong)
- Errors in the console are not easy to understand
- Didn't know that JpaRepository was easy to configure, i started with writing custom data access classes. Later when i saw JpaRepository, I had to remove the database access class.
- Challange of mapping columns with "\_" with the names in models. Took me a lot of time to understand that email_address column should map to emailAddress column in the model class.
- Serving the page and serving and api in the controller.
- I started with attribute RestController and wasn't sure how to use it. After a lot of reading I used @Controller attribute on the class to serve pages and apis from there.
