CREATE USER exampleUser WITH PASSWORD 'examplePassword';
CREATE DATABASE openIoT;
GRANT CONNECT ON DATABASE openIoT TO exampleUser;
GRANT USAGE ON SCHEMA public TO exampleUser;
GRANT ALL PRIVILEGES ON DATABASE openIoT to exampleUser;
